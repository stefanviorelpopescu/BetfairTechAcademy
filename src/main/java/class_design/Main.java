package class_design;

import class_design.engine.L4Engine;
import class_design.engine.V6Engine;
import class_design.interfaces.Cat;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;

public class Main
{

    public static void main(String[] args) throws IOException
    {
        List<String> names = new ArrayList<>();

        names.add("Ion");

        names = new LinkedList<>(names);

        names.add("Maria");

        Vehicle vehicle = new VehicleImpl(new V6Engine());

        vehicle.start();


        vehicle.setEngine(new L4Engine());

        vehicle.start();

        Cat cat = new Cat();

        long age2 = cat.getAge();

        System.out.println(cat.getAge());

        Map<Long, String> myMap = new HashMap<>();
        myMap.put(1L, "s");
        Set<Map.Entry<Long, String>> entries = myMap.entrySet();
        Set<Long> longs = myMap.keySet();

        Collection<String> values = myMap.values();
        for (String value : values)
        {
            System.out.println(value);
        }

        values.forEach(new Consumer<String>()
        {
            @Override
            public void accept(String s)
            {
                System.out.println(s);
            }
        });

        values.forEach(System.out::println);





        List<Cat> cats = new ArrayList<>();
        cats.sort(
            (o1, o2) -> o1.getAge() - o2.getAge()
            );

        Runnable runnable = () -> {

        };

        System.out.println(">>>>>>>>>> " + test());

        FileInputStream fs = null;
        try {
            fs = new FileInputStream("test.txt");
            fs.read();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (fs != null) {
                fs.close();
            }
        }

        try (FileInputStream fs2 = new FileInputStream("test.txt");
             FileInputStream fs3 = new FileInputStream("test.txt"))
        {
            fs2.read();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static int test() {
        try {
//            throw new RuntimeException("EX");
            return 0;
        } catch (Exception ex) {
            return 1;
        } finally {
            return 2;
        }
    }

}
