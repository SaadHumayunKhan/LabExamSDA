package businessLayer.filters;


import DataLayer.Student;

public class PaymentValidationFilter implements Filter {
    public boolean process(Student student) {
        if (student.hasPaid() || student.hasChallan()) {
            return true;
        }
        System.out.println("Payment or challan is missing for: " + student.getName());
        return false;
    }
}