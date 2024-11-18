package businessLayer;

import businessLayer.filters.Filter;
import businessLayer.filters.PaymentValidationFilter;
import businessLayer.filters.NotificationFilter;
import businessLayer.observer.NotificationService;
import DataLayer.Student;
import DataLayer.StudentRepository;

import java.util.Arrays;
import java.util.List;

public class TransportService {
    private StudentRepository repository;
    private NotificationService notificationService;

    public TransportService(StudentRepository repository, NotificationService notificationService) {
        this.repository = repository;
        this.notificationService = notificationService;
    }

    public void processPayments() {
        List<Filter> pipeline = Arrays.asList(
            new PaymentValidationFilter(),
            new NotificationFilter(notificationService)
        );

        for (Student student : repository.getAllStudents()) {
            boolean isValid = true;
            for (Filter filter : pipeline) {
                if (!filter.process(student)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                System.out.println("Student " + student.getName() + " payment is valid.");
            }
        }
    }
}
