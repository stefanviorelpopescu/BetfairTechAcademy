package class_design;

import class_design.engine.Engine;
import class_design.engine.V6Engine;

public class V6Vehicle implements Vehicle
{
    V6Engine engine;

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
