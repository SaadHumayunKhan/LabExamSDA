package DataLayer;

public class Student {
    private String name;
    private boolean hasPaid;
    private boolean hasChallan;

    public Student(String name, boolean hasPaid, boolean hasChallan) {
        this.name = name;
        this.hasPaid = hasPaid;
        this.hasChallan = hasChallan;
    }

    public String getName() {
        return name;
    }

    public boolean hasPaid() {
        return hasPaid;
    }

    public boolean hasChallan() {
        return hasChallan;
    }
}


