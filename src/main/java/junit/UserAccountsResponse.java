package junit;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class UserAccountsResponse
{
    private final int status;
    private final String message;
    private final List<UserAccount> userAccounts;

    public UserAccountsResponse(int status, String message)
    {
        this.status = status;
        this.message = message;
        this.userAccounts = new ArrayList<>();
    }
}
