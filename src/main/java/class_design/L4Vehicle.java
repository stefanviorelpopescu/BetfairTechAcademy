package class_design;

import class_design.engine.Engine;
import class_design.engine.L4Engine;

public class L4Vehicle implements Vehicle
{
    L4Engine engine;

    @Override
    public void start()
    {
        engine.turnOn();
    }

    @Override
    public void setEngine(Engine engine)
    {

    }
}
