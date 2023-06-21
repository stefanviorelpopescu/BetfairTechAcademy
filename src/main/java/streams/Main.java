package streams;

import collections.Student;
import collections.comparators.StudentComparatorByAge;
import collections.comparators.StudentComparatorByGpa;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main
{
    public static void main(String[] args)
    {
        Student s1 = new Student("1", 25, 2);
        Student s2 = new Student("1", 25, 2);
        Student s3 = new Student("1", 25, 2);
        List<Student> students = new ArrayList<>(Arrays.asList(s1, s2, s3));

        Optional<Double> max3 = students.stream()
                .flatMap(student -> student.getGrades().stream())
                .distinct()
                .limit(10)
                .max(Double::compareTo);

        List<List<Double>> max4 = students.stream()
                .sorted(new StudentComparatorByAge().reversed().thenComparing(new StudentComparatorByGpa()))
                .map(Student::getGrades)
                .collect(Collectors.toList());


        Map<Long, Student> collect = students.stream()
                .sorted(new StudentComparatorByAge().reversed().thenComparing(new StudentComparatorByGpa()))
                .collect(Collectors.toMap(Student::getUuid, Function.identity()));



        students.stream()
                .map(Student::getName)
                .collect(Collectors.joining(","));


        Map<Integer, List<Student>> studentsByAge = new HashMap<>();

        students.forEach(student -> studentsByAge.computeIfAbsent(student.getAge(), k -> new ArrayList<>())
                                                    .add(student));

        Map<Integer, List<Student>> collect1 = students.stream()
                .collect(Collectors.groupingBy(Student::getAge));

        new Thread(() -> System.out.println("dad")).start();

        Double max = students.stream()
                .filter(student -> student.getAge() == 25)
                .map(StudentConverter::studentToGpa)
                .max(Double::compareTo)
                .orElse(0d);

        Optional<Integer> max2 = students.stream()
                .map(Student::getAge)
                .filter(age -> age == 25)
                .max(Integer::compareTo);

        students.removeIf(student -> student.getGpa() == 5);

        int ageFilter = 25;

        int ageSum = students.stream()
                .map(Student::getAge)
                .reduce(0, Integer::sum);

        Stream<Double> doubleStream = students.stream()
                .filter(student -> student.getAge() == ageFilter)
                .map(StudentConverter::studentToGpa);

        new Thread(() -> {
            try
            {
                Thread.sleep(12000);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
            Optional<Double> max1 = doubleStream.max(Double::compareTo);
        });

        List<Integer> params = new ArrayList<>();
        String sql = "select * from students where age in (??) and gpa in (??)";
        String whereStr = "(?, ?, ?, ?)";
        String whereStr2 = "(?, ?, ?)";

        String s = sql.replaceFirst(Pattern.quote("??"), Matcher.quoteReplacement(whereStr))
                .replaceFirst(Pattern.quote("??"), Matcher.quoteReplacement(whereStr2));
    }
}
