package class_design;

import class_design.engine.Engine;

public class VehicleImpl implements Vehicle
{
    Engine engine;
    String color;

    public VehicleImpl(Engine engine)
    {
        this.engine = engine;
    }

    @Override
    public void start()
    {
        engine.turnOn();
    }

    public void setEngine(Engine engine)
    {
        this.engine = engine;
    }
}
