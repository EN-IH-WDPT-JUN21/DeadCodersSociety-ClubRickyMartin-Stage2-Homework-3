package com.ironhack.homework3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {
  static ApplicationContext applicationContext;

  public static void main(String[] args) {
    // we absolutely need to store the context to be able to access it later.
    applicationContext = SpringApplication.run(Main.class, args);

    Menu.welcomeScreen();
    Menu.mainMenu();
  }
}
