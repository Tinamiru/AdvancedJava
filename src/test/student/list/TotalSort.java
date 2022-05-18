package test.student.list;

import java.util.Comparator;

class TotalSort implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        if (student1.getTotal() == student2.getTotal()) {
            return student1.getNum().compareTo(student2.getNum()) * 1;
        } else {
            return Integer.compare(student1.getTotal(), student2.getTotal()) * -1;
        }

    }
}