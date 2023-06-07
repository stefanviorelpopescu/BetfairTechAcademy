package class_design;

import class_design.engine.Engine;
import class_design.engine.V8Engine;

public class V8Vehicle implements Vehicle
{
    V8Engine engine;

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
