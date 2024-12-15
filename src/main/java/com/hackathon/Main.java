package com.hackathon;

import static com.hackathon.ui.MenuDoJogo.menuEscolha;

import java.util.Scanner;
import org.fusesource.jansi.AnsiConsole;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.setProperty("jansi.passthrough", "true");
    AnsiConsole.systemInstall();

    try {
      menuEscolha();
    } finally {
      AnsiConsole.systemUninstall();
      scanner.close();
    }
  }
}