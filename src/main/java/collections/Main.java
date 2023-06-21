package collections;

import collections.comparators.StudentComparatorByAge;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparingDouble;

public class Main
{

    public static void main(String[] args)
    {

        String[] strings = {"Ion", "Maria", "Jamal", "Carlos"};
        List<String> list = asList(strings);
//        list.remove("Ion");

        List<String> names = new ArrayList<>(asList("Ion", "Maria", "Jamal", "Carlos"));

        Collections.sort(names);
        names.sort((o1, o2) -> o2.length() - o1.length());

        System.out.println(names);

        List<Student> students = new ArrayList<>();

//        Collections.sort(students);

        students.sort(new StudentComparatorByAge());

        students.sort(comparingDouble(Student::getGpa));

        Student ion = new Student("Ion", 25, 5);
        Student maria = new Student("Maria", 35, 7);

        System.out.println("Students:");
        Set<Student> studentSet = new TreeSet<>(new StudentComparatorByAge());
        studentSet.add(maria);
        studentSet.add(ion);
        studentSet.forEach(student -> System.out.println(student.name));


        Iterator<String> iterator = names.iterator();

        while (iterator.hasNext()) {
            String name = iterator.next();

            if (name.startsWith("I")) {
                iterator.remove();
            }
            System.out.println(name);
        }

        String toDelete = "";
        for (String name : names)
        {
            System.out.println(name);
            if (name.startsWith("M")) {
                toDelete = name;
                break;
            }
        }
        names.indexOf(toDelete);

        List<String> c = names.stream()
                .filter(s -> s.startsWith("C"))
                .collect(Collectors.toList());
        names.removeAll(c);

        names.forEach(System.out::println);


        System.out.println(names.size());

        Integer i1 = 25;
        Integer i2 = 25;
        System.out.println(i1 == i2);

        String s = "Maria";
        String s2 = "Maria";
        String s3 = new String("Maria");



    }

}
