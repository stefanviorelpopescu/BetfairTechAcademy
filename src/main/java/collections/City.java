package collections;

import java.util.Objects;

public class City
{
    final String name;
    String shortCode;

    public City(String name)
    {
        this.name = name;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(name, city.name) && Objects.equals(shortCode, city.shortCode);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name);
    }
}
