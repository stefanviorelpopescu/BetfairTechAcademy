package collections;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Student implements Comparable<Student>
{
    Long uuid;
    String name;
    int age;
    double gpa;
    List<Double> grades = new ArrayList<>();

    public Student(String name, int age, double gpa)
    {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    @Override
    public int compareTo(Student o)
    {
        return this.name.compareTo(o.name);
    }
}
