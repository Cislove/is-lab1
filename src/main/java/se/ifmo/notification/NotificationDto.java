package se.ifmo.notification;

public record NotificationDto(
    NotificationType type,
    String entityType,
    boolean allIds,
    String entityId
){
    public enum NotificationType {
        ADD,
        UPDATE,
        DELETE,
        ERROR
    }
}

