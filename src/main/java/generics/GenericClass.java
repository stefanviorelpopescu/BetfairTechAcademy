package generics;

import org.apache.commons.math3.util.Pair;

import java.util.List;

public class GenericClass<A, B>
{
    static <L, R> boolean arePairsEqual(Pair<L, R> p1, Pair<L, R> p2) {

        if (p1.getKey() == null || p1.getValue() == null) {
            return false;
        }
        return p1.getKey().equals(p2.getKey())
                && p1.getValue().equals(p2.getValue());
    }

    static Integer getSum(List<? extends Integer> numbers) {
        Integer sum = 0;
        for (Integer number : numbers)
        {
            sum += number;
        }
        return sum;
    }

    static List<? super Integer> getSumMore(List<? super Integer> numbers) {

        for (int i = 0; i<10; i++) {
            numbers.add(i);
        }

        return numbers;
    }

    public int getValue(int n) {
        return n;
    }

    public int getValue(String s) {
        return s.length();
    }

    private int getSize(List<A> strings) {
        return strings.size();
    }

//    private int getSize(List<B> longs) {
//        return longs.size();
//    }

}
