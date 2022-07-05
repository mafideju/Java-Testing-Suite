package org.mafideju.TestSuitTraining.service;

import org.mafideju.TestSuitTraining.model.User;

public class EmailVerificationServiceImplementation implements EmailVerificationService {
  @Override
  public void scheduleEmailConfirmation(User user) {
    System.out.println("Mandar email de confirmação para " + user.getEmail());
  }
}
