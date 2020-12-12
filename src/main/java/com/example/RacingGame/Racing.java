package com.example.RacingGame;

import model.RoomManager;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/race")
public class Racing {
    public static final RoomManager ROOM_MANAGER = RoomManager.of();

    @OnOpen
    public void onOpen(Session session) throws IOException {
        session.setMaxIdleTimeout(99999999);
        // Get session and WebSocket connection
        ROOM_MANAGER.addToQueue(session);
        System.out.println("Racing.onOpen");
    }

    @OnMessage
    public void onMessage(Session session, String message) throws IOException {
        // Handle new messages
        ROOM_MANAGER.receiveMessage(session, message);
    }

    @OnClose
    public void onClose(Session session) throws IOException {
        // WebSocket connection closes
        ROOM_MANAGER.removePlayer(session);
        System.out.println("Racing.onClose");
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("Racing.onError");
        ROOM_MANAGER.removePlayer(session);
        throwable.printStackTrace();
    }


}
