package junit;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest
{
    private final long USER_ID = 1L;

    @Mock
    AccountRepository accountRepository;
    @InjectMocks
    UserService victim;

    @BeforeAll
    public static void setUp() {
//        accountRepository = mock(AccountRepository.class);
//        victim = new UserService(accountRepository);
    }

    @Test
    public void testInvalidStateParam() {
        //given
        String state = String.valueOf(new Random(1_000_000));

        //when
        UserAccountsResponse response = victim.getUserAccounts(USER_ID, state);

        //then
        assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatus());
        assertTrue(response.getMessage().contains("Invalid state:"));
    }

    @Test
    public void testNoAccountsWithGivenState() {
        //given
        String state = AccountState.CLOSED.name();
        when(accountRepository.getUserAccounts(eq(USER_ID)))
                .thenReturn(Collections.singletonList(new UserAccount(1, USER_ID, AccountState.ACTIVE)));

        //when
        UserAccountsResponse response = victim.getUserAccounts(USER_ID, state);

        //then
        verify(accountRepository).getUserAccounts(eq(USER_ID));
        assertEquals(HttpStatus.SC_OK, response.getStatus());
        assertTrue(response.getMessage().contains("OK"));
        assertEquals(0, response.getUserAccounts().size());
    }

    @Test
    public void testOnlyAccountsWithGivenStateAreReturned() {
        //given
        String state = AccountState.CLOSED.name();
        List<UserAccount> accountsToReturn = Arrays.asList(new UserAccount(1, USER_ID, AccountState.ACTIVE),
                new UserAccount(1, USER_ID, AccountState.CLOSED),
                new UserAccount(1, USER_ID, AccountState.CLOSED));
        when(accountRepository.getUserAccounts(eq(USER_ID))).thenReturn(accountsToReturn);

        //when
        UserAccountsResponse response = victim.getUserAccounts(USER_ID, state);

        //then
        verify(accountRepository).getUserAccounts(eq(USER_ID));
        assertEquals(HttpStatus.SC_OK, response.getStatus());
        assertTrue(response.getMessage().contains("OK"));
        assertEquals(2, response.getUserAccounts().size());
    }

    @Test
    public void testExceptionFromRepositoryIsPropagated() {
        //given
        String state = AccountState.CLOSED.name();
        String exceptionMessage = "Message";
        when(accountRepository.getUserAccounts(eq(USER_ID))).thenThrow(new IllegalArgumentException(exceptionMessage));

        //when then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> victim.getUserAccounts(USER_ID, state));
        assertEquals(exceptionMessage, exception.getMessage());
    }

}