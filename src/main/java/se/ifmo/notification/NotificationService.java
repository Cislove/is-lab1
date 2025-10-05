package se.ifmo.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final EventWebSocketHandler eventWebSocketHandler;

    public void sendAddNotification(String addId, String entityName) {
        sendNotification(addId, entityName, NotificationDto.NotificationType.ADD);
    }

    public void sendUpdateNotification(String updateId, String entityName) {
        sendNotification(updateId, entityName, NotificationDto.NotificationType.UPDATE);
    }

    public void sendDeleteNotification(String deleteId, String entityName) {
        sendNotification(deleteId, entityName, NotificationDto.NotificationType.DELETE);
    }

    private void sendNotification(String entityId, String entityName, NotificationDto.NotificationType type) {
        eventWebSocketHandler.broadcast(
                new NotificationDto(
                        type,
                        entityName,
                        entityId
                )
        );
    }
}
