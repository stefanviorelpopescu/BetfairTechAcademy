package generics;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetterTest
{
    private final int value;

    public GetterTest(int value)
    {
        this.value = value;
    }
}
