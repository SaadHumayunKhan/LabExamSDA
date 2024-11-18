package businessLayer.observer;

public class SMSNotification implements Observer {
    public void update(String message) {
        System.out.println("SMS sent: " + message);
    }
}

