package presentation;

import businessLayer.TransportService;
import businessLayer.observer.EmailNotification;
import businessLayer.observer.NotificationService;
import businessLayer.observer.SMSNotification;
import DataLayer.Student;
import DataLayer.StudentRepository;

public class Main {
    public static void main(String[] args) {
        // Data Access Setup
        StudentRepository repository = new StudentRepository();
        repository.addStudent(new Student("Ali", false, false));
        repository.addStudent(new Student("Ayesha", true, false));
        repository.addStudent(new Student("Ahmed", false, true));

        // Observer Setup
        NotificationService notificationService = new NotificationService();
        notificationService.addObserver(new EmailNotification());
        notificationService.addObserver(new SMSNotification());

        // Business Logic Execution
        TransportService transportService = new TransportService(repository, notificationService);
        transportService.processPayments();
    }
}

