package model;

import com.google.gson.Gson;
import model.json.JSONArray;
import model.json.JSONObject;
import model.json.PlayerJSON;
import model.json.ProfileJSON;
import utils.Utils;

import javax.websocket.Session;
import java.util.ArrayList;
import java.util.List;

public class Room implements Runnable {
    private final String id;
    public static Gson GSON = new Gson();
    public static final int MAX_PLAYER = 3;
    private boolean running = false;
    private List<Player> players;

    private Thread threadAddAI;

    private String text = "Typing me please, typing me";

    private Room(String id) {
        this.id = id;
        players = new ArrayList<>();

        /**
         * Auto add AI to room per 2 second
         * - Not add AI when room empty
         * - Not add AI when room full
         */
        threadAddAI = new Thread(() -> {
            while (true) {
                if (!running) {
                    if (players.size() != 0 && players.size() != MAX_PLAYER) {
                        add(new AI(this));
                    }
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadAddAI.start();
    }

    public static Room of(String id) {
        return new Room(id);
    }

    public boolean add(Player player) {
        if (running) {
            System.out.println("Room full.");
            return false;
        }
        // set room for player
        player.setRoom(this);
        // set text for player
        player.setTyping(Typing.of(player, text));

        // add player
        players.add(player);

        // send profile
        player.sendProfile();

        // notify for players
        sendInfoPlayers();

        // check available
        if (available() == 0) {
            running = true;
            // run room
            new Thread(this, "ROOM").start();

            return true;
        }

        return false;
    }


    private void sendInfoPlayers() {
        JSONArray<PlayerJSON> jsonArray = new JSONArray<>();
        jsonArray.head = "players";

        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);

            Typing typing = p.getTyping();
            PlayerJSON playerJSON = new PlayerJSON(p.getName(), typing.percentage(), typing.speed());
            jsonArray.body.add(playerJSON);
        }

        sendMessagePeople(GSON.toJson(jsonArray));
    }


    private void sendMessagePeople(String message) {
        players.forEach(player -> {
            if (!(player instanceof AI)) {
                player.sendMessage(message);
            }
        });
    }

    public int available() {
        return MAX_PLAYER - players.size();
    }

    public int size() {
        return players.size();
    }

    public boolean isRunning() {
        return running;
    }


    @Override
    public void run() {

        // notify start for all players ( AI and human )
        players.forEach(Player::startTyping);

        while (running) {
            // notify for players
            sendInfoPlayers();

            // check all player complete
            boolean completeAll = true;
            for (Player p : players) {
                if (!p.isComplete()) {
                    completeAll = false;
                    break;
                }
            }
            running = !completeAll;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        players.clear();
        System.out.println("ROOM " + id + " close.");
    }

    public String getId() {
        return id;
    }


    public Player getPlayer(Session session) {
        return players.stream().filter(p -> p.session.equals(session)).findFirst().orElse(null);
    }

    public boolean remove(Session session) {
        for (Player player : players) {
            if (player.getSession().equals(session)) {
                System.out.println("Remove " + session.getId());
                players.remove(player);
                return true;
            }
        }
        return false;
    }

    public boolean remove(Player player) {

        boolean removed = players.remove(player);
        if (players.isEmpty()) {
            running = false;
        }
        return removed;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
