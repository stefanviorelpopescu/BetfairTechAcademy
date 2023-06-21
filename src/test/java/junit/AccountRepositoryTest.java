package junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryTest
{
    AccountRepository victim = new AccountRepository();

    @ParameterizedTest
    @ValueSource(ints = {-1, -3, -15, Integer.MIN_VALUE})
    public void testExceptionIsThrownForInvalidUserId(long invalidUserId) {
        assertThrows(IllegalArgumentException.class, () -> victim.getUserAccounts(invalidUserId), "Exception expected!");
    }
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3, 5, 15, Integer.MAX_VALUE})
    public void testNoExceptionIsThrownForFirstValidUserId(long userId) {

        List<UserAccount> userAccounts = victim.getUserAccounts(userId);

        //then
        assertTrue(userAccounts.isEmpty());
    }


}