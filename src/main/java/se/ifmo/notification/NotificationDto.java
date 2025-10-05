package se.ifmo.notification;

public record NotificationDto(
    NotificationType type,
    String entityType,
    String entityId
){
    public enum NotificationType {
        ADD,
        UPDATE,
        DELETE,
        ERROR
    }
}

