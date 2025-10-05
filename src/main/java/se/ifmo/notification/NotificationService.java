package se.ifmo.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final EventWebSocketHandler eventWebSocketHandler;

    public void sendAddNotification(String addId, String entityName, boolean allIds) {
        sendNotification(addId, entityName, NotificationDto.NotificationType.ADD, allIds);
    }

    public void sendUpdateNotification(String updateId, String entityName, boolean allIds) {
        sendNotification(updateId, entityName, NotificationDto.NotificationType.UPDATE, allIds);
    }

    public void sendDeleteNotification(String deleteId, String entityName, boolean allIds) {
        sendNotification(deleteId, entityName, NotificationDto.NotificationType.DELETE, allIds);
    }

    private void sendNotification(String entityId, String entityName, NotificationDto.NotificationType type, boolean allIds) {
        eventWebSocketHandler.broadcast(
                new NotificationDto(
                        type,
                        entityName,
                        allIds,
                        entityId
                )
        );
    }
}
