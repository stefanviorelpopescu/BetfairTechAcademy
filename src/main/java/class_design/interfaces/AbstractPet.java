package class_design.interfaces;

public abstract class AbstractPet implements Pet
{
    @Override
    public void wakeUp()
    {
        System.out.println("AAaaaaaaaaaaaaaa");
    }

    protected void abstractMethod() {
        System.out.println("");
    }
}
