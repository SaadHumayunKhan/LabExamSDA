package businessLayer.observer;

public class EmailNotification implements Observer {
    public void update(String message) {
        System.out.println("Email sent: " + message);
    }
}
