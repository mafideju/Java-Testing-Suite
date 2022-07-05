package org.mafideju.TestSuitTraining.service;

import org.mafideju.TestSuitTraining.exception.UserServiceException;
import org.mafideju.TestSuitTraining.model.User;
import org.mafideju.TestSuitTraining.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class UserServiceImplementation implements UserService {

    @Autowired
    UsersRepository usersRepository;

    EmailVerificationService emailVerificationService;

    public UserServiceImplementation(UsersRepository usersRepository, EmailVerificationService emailVerificationService) {
        this.usersRepository = usersRepository;
        this.emailVerificationService = emailVerificationService;
    }

    @Override
    public User createUser(String name, String email, String password) {
        boolean isEmailNotPresent = email == null || email.isBlank() || email.isEmpty();
        boolean isPasswordNotPresent = password == null || password.isBlank() || password.isEmpty();
        String id = UUID.randomUUID().toString();

        if (isEmailNotPresent || isPasswordNotPresent) {
            throw new IllegalArgumentException("Email e senha são obrigatórios para criação do usuário.");
        }

        User user = new User(name, email, password, id);
        boolean isUserCreated = usersRepository.save(user);
        if (!isUserCreated) throw new UserServiceException("Não foi possível criar o usuário.");

        try {
            emailVerificationService.scheduleEmailConfirmation(user);
        } catch(RuntimeException e) {
            throw new UserServiceException(e.getMessage());
        }

        System.out.println(email + ": " + id );

        return user;
    }
}
