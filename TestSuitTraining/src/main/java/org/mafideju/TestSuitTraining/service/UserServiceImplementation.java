package org.mafideju.TestSuitTraining.service;

import org.mafideju.TestSuitTraining.model.User;

import java.util.UUID;

public class UserServiceImplementation implements UserService {
    @Override
    public User createUser(String name, String email, String password) {
        boolean isEmailNotPresent = email == null || email.isBlank() || email.isEmpty();
        boolean isPasswordNotPresent = password == null || password.isBlank() || password.isEmpty();
        String id = UUID.randomUUID().toString();

        if (isEmailNotPresent || isPasswordNotPresent) {
            throw new IllegalArgumentException("Email e senha são obrigatŕorios para criação do usuário.");
        }

        User user = new User(name, email, password, id);
        //userRepository.save(user);

        System.out.println(email + ": " + id );

        return user;
    }
}
