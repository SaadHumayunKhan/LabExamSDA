package businessLayer.filters;


import DataLayer.Student;
import businessLayer.observer.NotificationService;

public class NotificationFilter implements Filter {
    private NotificationService notificationService;

    public NotificationFilter(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public boolean process(Student student) {
        if (!student.hasPaid() && !student.hasChallan()) {
            notificationService.notifyAllObservers("Payment is pending for: " + student.getName());
            return false;
        }
        return true;
    }
}