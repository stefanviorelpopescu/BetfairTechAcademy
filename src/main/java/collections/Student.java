package collections;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Student implements Comparable<Student>
{
    String name;
    int age;
    double gpa;

    @Override
    public int compareTo(Student o)
    {
        return this.name.compareTo(o.name);
    }
}
