package junit;

import org.apache.http.HttpStatus;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserService
{
    final AccountRepository accountRepository;

    public UserService(AccountRepository accountRepository)
    {
        this.accountRepository = accountRepository;
    }

    public UserAccountsResponse getUserAccounts(long userId, String state) {

        Optional<AccountState> stateQueryParam = AccountState.fromString(state);
        if (!stateQueryParam.isPresent()) {
            return new UserAccountsResponse(HttpStatus.SC_BAD_REQUEST, "Invalid state: " + state);
        }

        List<UserAccount> accounts = accountRepository.getUserAccounts(userId).stream()
                .filter(userAccount -> stateQueryParam.get().equals(userAccount.getState()))
                .collect(Collectors.toList());
        UserAccountsResponse response = new UserAccountsResponse(HttpStatus.SC_OK, "OK");
        response.getUserAccounts().addAll(accounts);
        return response;
    }

}
