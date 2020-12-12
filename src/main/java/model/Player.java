package model;

import model.json.CompleteJSON;
import model.json.JSONObject;
import model.json.ProfileJSON;
import utils.Utils;

import javax.websocket.Session;
import java.io.IOException;
import java.util.Objects;

public abstract class Player {
    protected final static Utils utils = Utils.getInstance();
    protected String id;
    protected String name;
    protected Session session;
    protected Typing typing;
    protected boolean complete = false;
    protected Room room;

    protected Player(Room room, Session session) {
        this.room = room;
        this.session = session;
    }


    public void sendMessage(String msg) {
        try {
            session.getBasicRemote().sendText(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Send if of room
     */
    public void sendProfile() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.head = "profile";
        jsonObject.body = new ProfileJSON(room.getId());
        sendMessage(utils.GSON.toJson(jsonObject));
    }

    public abstract void type(String letter);

    public void startTyping() {
        typing.setStart(System.currentTimeMillis());
    }

    public Typing getTyping() {
        return typing;
    }

    public void setTyping(Typing typing) {
        this.typing = typing;
    }

    public Utils getUtils() {
        return utils;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        if (complete) {
            // send message complete
            sendMessageComplete();
        }

        this.complete = complete;
    }

    private void sendMessageComplete() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.head = "complete";
        // set body json
        jsonObject.body = new CompleteJSON(typing.speed(), typing.actual(), 0);
        sendMessage(utils.GSON.toJson(jsonObject));
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(session, player.session);
    }

    @Override
    public int hashCode() {
        return Objects.hash(session);
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
