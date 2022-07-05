package org.mafideju.TestSuitTraining.service;

import org.mafideju.TestSuitTraining.model.User;

public interface EmailVerificationService {
  void scheduleEmailConfirmation(User user);
}
