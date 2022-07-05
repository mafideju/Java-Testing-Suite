package org.mafideju.TestSuitTraining.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mafideju.TestSuitTraining.exception.UserServiceException;
import org.mafideju.TestSuitTraining.model.User;
import org.mafideju.TestSuitTraining.repository.UsersRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @InjectMocks
    UserServiceImplementation userService;
    @Mock
    UsersRepository usersRepository;
    @Mock
    EmailVerificationServiceImplementation emailVerificationServiceImplementation;

    @Test
    void testCreateUser() {
        String name = "Marcio";
        String email = "mafideju@outlook.com";
        String password = "12345678";

        when(usersRepository.save(any(User.class))).thenReturn(Boolean.TRUE);

        User user = userService.createUser(name, email, password);
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setId(user.getId());

        assertNotNull(user);
        assertNotNull(user.getId());
        assertEquals(name, user.getName());
        assertEquals(email, user.getEmail());
        assertEquals(password, user.getPassword());

        verify(usersRepository, times(1)).save(any(User.class));
    }

    @Test
    void throwIllegalArgumentException() {
        String name = "Marcio";
        String email = "";
        String password = "";

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(name, email, password);
        });

        assertEquals(thrown.getMessage(), "Email e senha são obrigatórios para criação do usuário.");
    }

    @Test
    void throwUserServiceException() {
        String name = "Marcio";
        String email = "mafideju@outlook.com";
        String password = "12345678";

        when(usersRepository.save(any(User.class))).thenReturn(Boolean.FALSE);
        UserServiceException thrownable = assertThrows(UserServiceException.class, () -> {
            userService.createUser(name, email, password);
        });

        assertEquals(thrownable.getMessage(), "Não foi possível criar o usuário.");
    }

    @Test
    void throwUserServiceExceptionForEmailNotificationMessage() {
        String name = "Marcio";
        String email = "mafideju@outlook.com";
        String password = "12345678";

        when(usersRepository.save(any(User.class))).thenReturn(Boolean.TRUE);
        doThrow(EmailVerificationServiceException.class)
            .when(emailVerificationServiceImplementation)
            .scheduleEmailConfirmation(any(User.class));

        assertThrows(UserServiceException.class, () -> {
            userService.createUser(name, email, password);
        });
    }

    @Test
    void scheduleEmailConfirmation() {
        String name = "Marcio";
        String email = "mafideju@outlook.com";
        String password = "12345678";

        when(usersRepository.save(any(User.class))).thenReturn(Boolean.TRUE);

        doCallRealMethod().when(emailVerificationServiceImplementation).scheduleEmailConfirmation(any(User.class));

        userService.createUser(name, email, password);

        verify(emailVerificationServiceImplementation, times(1)).scheduleEmailConfirmation(any(User.class));
    }
}
