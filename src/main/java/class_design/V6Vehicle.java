package class_design;

import class_design.engine.Engine;
import class_design.engine.V6Engine;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        V6Vehicle v6Vehicle = (V6Vehicle) o;
        return Objects.equals(engine, v6Vehicle.engine);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(engine);
    }
}
