package model;

import model.json.JSONObject;

import javax.websocket.Session;

public class Human extends Player {
    private Human(Room room, Session session) {
        super(room, session);
        this.name = session.getId();
        this.id = session.getId();
    }

    @Override
    public void startTyping() {
        super.startTyping();

        // send message to people
        JSONObject jsonObject = new JSONObject();
        jsonObject.head = "running";
        jsonObject.body = room.getText();
        sendMessage(utils.GSON.toJson(jsonObject));
    }

    @Override
    public void type(String letter) {
        boolean correct = typing.type(letter);
    }

    public static Human of(Room room, Session session) {
        return new Human(room, session);
    }

}
