package junit;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserAccount
{
    private long accountId;
    private long userId;
    private AccountState state;
}
