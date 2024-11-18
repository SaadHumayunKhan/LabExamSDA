package businessLayer.filters;

import DataLayer.Student;

public interface Filter {
    boolean process(Student student);
}