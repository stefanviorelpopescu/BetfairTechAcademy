package class_design.interfaces;

public interface Pet
{
    default void wakeUp()
    {
        System.out.println("AAaaaaaaaaaaaaaa");
    }

    void talk();

}
