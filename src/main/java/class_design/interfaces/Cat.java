package class_design.interfaces;

public class Cat implements Pet
{
    @Override
    public void talk()
    {
        System.out.println("Miau");
    }

    @Override
    public void wakeUp()
    {
        System.out.println("Cat wakes up");
    }

    public int getAge() {
        return 2;
    }

    public long getAge(String s) {
        return 3L;
    }
}
