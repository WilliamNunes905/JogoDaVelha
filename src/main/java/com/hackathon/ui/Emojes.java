package com.hackathon.ui;

import org.fusesource.jansi.Ansi;

public class Emojes {
  public static void exibirVitoriaComputador() {
    System.out.println(Ansi.ansi().fgRed().a("\n\nO COMPUTADOR VENCEU!\n"));
    System.out.println("""
        \t\t\t    +---------------+
        \t\t\t    | +-----------+ |
        \t\t\t    | | __    __  | |
        \t\t\t    | |  0    0   | |
        \t\t\t    | |    --     | |
        \t\t\t    | |   \\__/   | |
        \t\t\t    | |           | |
        \t\t\t    | +-----------+ |
        \t\t\t    +-----+---+-----+
        \t\t\t    ______|   |_____
        \t\t\t   /                \\
        \t\t\t  /  --------------- \\
        \t\t\t /   ---------------  \\
        \t\t\t +--------------------+
        \n\n""");
  }

  public static void exibirVitoriaUsuario() {
    System.out.println(Ansi.ansi().fgGreen().a("\n\nO USUÁRIO VENCEU!\n"));
    System.out.println("""
        \t\t\t          /////////
        \t\t\t    \\\\|/////////
        \t\t\t     \\/////////
        \t\t\t     |         |
        \t\t\t    (| --- --- |)
        \t\t\t     |  0   0  |
        \t\t\t     |    ..   |
        \t\t\t     |  \\___/  |
        \t\t\t     |_________|
        \t\t\t        |   |
        \t\t\t        |   |
        \t\t\t       /     \\
        \t\t\t      /       \\
        \n\n\n""");
  }

  public static void exibirEmpate() {
    System.out.println(Ansi.ansi().fgYellow().a("\n\nOCORREU EMPATE!\n"));
    System.out.println("+---+       +---+");
    System.out.println("| 0 |   X   | 0 |");
    System.out.println("+---+       +---+");
  }
}

