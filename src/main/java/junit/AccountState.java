package junit;

import java.util.Optional;

public enum AccountState
{
    ACTIVE,
    INACTIVE,
    CLOSED,
    INVALID,
    EXPIRED,
    ;

    public static Optional<AccountState> fromString(String state) {
        for (AccountState value : AccountState.values())
        {
            if (value.name().equalsIgnoreCase(state)) {
                return Optional.of(value);
            }
        }
        return Optional.empty();
    }
}
