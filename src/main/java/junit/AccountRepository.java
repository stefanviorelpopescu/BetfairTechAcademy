package junit;

import java.util.Collections;
import java.util.List;

public class AccountRepository
{
    public List<UserAccount> getUserAccounts(long userId) {
        if (userId < 0 ) {
            throw new IllegalArgumentException("Invalid user ID!: " + userId);
        }
        return Collections.emptyList();
    }
}
