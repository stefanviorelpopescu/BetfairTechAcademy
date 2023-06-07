package generics;

import org.apache.commons.math3.util.Pair;

import java.util.Arrays;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Pair<Integer, String> first = new Pair<>(null, "one");
        Pair<Integer, String> second = new Pair<>(1, "one");

        System.out.println(GenericClass.arePairsEqual(first, second));

        GetterTest test = new GetterTest(45);
        System.out.println(test.getValue());

        List<String> strings = Arrays.asList("one", "two");
        for (String string : strings)
        {
            System.out.println(string);
        }

        List<Number> justNumbers = Arrays.asList(1, 2, 3);
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        Integer sum = GenericClass.getSum(numbers);

        List<? super Integer> sumMore = GenericClass.getSumMore(numbers);
        for (Object o : sumMore)
        {
            System.out.println(o);
        }

        List<? super Integer> sumMore1 = GenericClass.getSumMore(justNumbers);

        GenericClass<Integer, String> gc = new GenericClass<>();

    }
}
