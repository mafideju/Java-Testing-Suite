package org.mafideju.TestSuitTraining.service;

import org.mafideju.TestSuitTraining.model.User;

public interface UserService {
    User createUser(String name, String email, String password);
}
