package collections.comparators;

import collections.Student;

import java.util.Comparator;

public class StudentComparatorByGpa implements Comparator<Student>
{
    @Override
    public int compare(Student o1, Student o2)
    {
        return (int) (o1.getGpa() - o2.getGpa());
    }
}
