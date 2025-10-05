package se.ifmo.notification;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class EventWebSocketHandler extends TextWebSocketHandler {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
    private final Set<WebSocketSession> sessions =
            Collections.newSetFromMap(new ConcurrentHashMap<>());

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        sessions.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, org.springframework.web.socket.CloseStatus status) {
        sessions.remove(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        try {
            String json = objectMapper.writeValueAsString(new NotificationDto(
                    NotificationDto.NotificationType.ERROR,
                    null,
                    false,
                    null
            ));

            session.sendMessage(new TextMessage(json));
        } catch (IOException e) {
            //TODO: добавить логгер
            throw new RuntimeException(e);
        }
    }

    public void broadcast(NotificationDto dto) {
        try {
            String json = objectMapper.writeValueAsString(dto);

            sessions.stream()
                    .filter(WebSocketSession::isOpen)
                    .forEach(session -> executor.submit(() -> sendMessage(session, json)));
        } catch (IOException e) {
            //TODO: добавить логгер
            throw new RuntimeException(e);
        }
    }

    private void sendMessage(WebSocketSession session, String message) {
        try {
            session.sendMessage(new TextMessage(message));
        }
        //TODO: добавить логгер
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
