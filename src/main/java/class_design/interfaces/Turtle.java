package class_design.interfaces;

public class Turtle extends AbstractPet
{
    @Override
    public void talk()
    {
        System.out.println("Brrrr");
    }

    @Override
    protected void abstractMethod()
    {
        super.abstractMethod();
    }
}
