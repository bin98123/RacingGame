package model;


import model.json.JSONObject;
import model.json.TypingJSONReceive;
import utils.Utils;

import javax.websocket.Session;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class RoomManager implements Runnable {
    public static Queue<Human> queue = new ArrayDeque<>();
    public static int MAX_ROOM = 2;

    private List<Room> rooms = new ArrayList<>();

    private Thread thread;

    private RoomManager() {
        // init room
        for (int i = 0; i < MAX_ROOM; i++) {
            rooms.add(Room.of(String.valueOf(i)));
        }


        thread = new Thread(this, "ROOM_MANAGER_THREAD");
        thread.start();
    }

    public void onMessage(Session session, String message) {


    }

    public void addToQueue(Session session) {
        queue.add(Human.of(null, session));
    }

    public void removePlayer(Session session) {
        // remove on queue
        queue = queue.stream().filter(h -> !h.getSession().equals(session)).collect(Collectors.toCollection(ArrayDeque::new));
        // remove in room
        for (Room room : rooms) {
            if (room.remove(session)) {
                break;
            }
        }
    }

    public static RoomManager of() {
        return new RoomManager();
    }

    @Override
    public void run() {
        while (true) {
            while (queue.size() != 0) {
                Human human = queue.poll();
                addToRoom(human);
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void addToRoom(Human human) {
        // get room available is running false
        List<Room> available = getAvailable();

        System.out.println("RoomManager.addToRoom");
        // full room
        if (available.size() == 0) {
            // All rooms full. Please human wait a second.
            System.out.println("All rooms full.");
        } else {
            available.get(0).add(human);
        }
    }

    private List<Room> getAvailable() {
        return rooms.stream().filter(r -> !r.isRunning()).collect(Collectors.toList());
    }

    public void receiveMessage(Session session, String message) {

        try {
            JSONObject jsonObject = Utils.getInstance().GSON.fromJson(message, JSONObject.class);
            final String head = jsonObject.head;

            switch (head) {
                case "typing":
                    TypingJSONReceive typingJSONReceive = Utils.getInstance().GSON.fromJson(message, TypingJSONReceive.class);

                    String roomId = typingJSONReceive.body.roomId;
                    String letter = typingJSONReceive.body.letter;

                    // find room
                    Room room = findRoomById(roomId);
                    if (room != null) {
                        room.getPlayer(session).type(letter);
                    }
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Room findRoomById(String id) {
        for (Room room : rooms) {
            if (room.getId().equals(id)) {
                return room;
            }
        }
        return null;
    }

}
