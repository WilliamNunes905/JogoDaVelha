package com.hackathon.config;

import java.util.Random;

public class ConfigDoJogo {
  public static boolean sortearValorBooleano() {
    Random random = new Random();
    return random.nextBoolean();
  }
}
