package org.mafideju.TestSuitTraining.repository;

import org.mafideju.TestSuitTraining.model.User;

import java.util.HashMap;
import java.util.Map;

public class UsersRepositoryImplementation implements UsersRepository {
  @Override
  public boolean save(User user) {
    Map<String, User> users = new HashMap<>();
    boolean returnValue = false;

    if (!users.containsKey(user.getId())) {
        users.put(user.getId(), user);
        returnValue = true;
    }

    return returnValue;
  }
}
