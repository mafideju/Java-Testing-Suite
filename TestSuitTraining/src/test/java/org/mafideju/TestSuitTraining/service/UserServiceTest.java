package org.mafideju.TestSuitTraining.service;

import org.junit.jupiter.api.Test;
import org.mafideju.TestSuitTraining.model.User;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @Test
    void testCreateUser() {
        UserServiceImplementation userService = new UserServiceImplementation();
        String name = "Marcio";
        String email = "mafideju@outlook.com";
        String password = "12345678";

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
    }

    @Test
    void throwIllegalArgumentException() {
        String name = "Marcio";
        String email = "";
        String password = "";
        UserServiceImplementation userService = new UserServiceImplementation();

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            User user = userService.createUser(name, email, password);
        });

        assertEquals(thrown.getMessage(), "Email e senha são obrigatŕorios para criação do usuário.");
    }
}
