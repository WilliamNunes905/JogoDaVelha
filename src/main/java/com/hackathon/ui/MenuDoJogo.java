package com.hackathon.ui;

import static com.hackathon.game.JogoVelha.InicializarJogo;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.fusesource.jansi.Ansi;

public class MenuDoJogo {
  private static final Scanner SCANNER = new Scanner(System.in);

  public static void menuEscolha() {
    int escolha = -1;
    logoJogoDaVelha();

    while (escolha != 3) {
      exibirMenu();

      try {
        System.out.print(Ansi.ansi().fgYellow().a("Escolha uma opção: ").reset());
        escolha = SCANNER.nextInt();
        SCANNER.nextLine();

        switch (escolha) {
          case 1:
            iniciarJogo();
            break;
          case 2:
            sobreOJogo();
            break;
          case 3:
            System.out.println(Ansi.ansi().fgBrightGreen().a("Saindo do jogo...").reset());
            limparTela();
            break;
          default:
            System.out.println(Ansi.ansi().fgBrightRed().a("Opção inválida. Escolha novamente!").reset());
            break;
        }
      } catch (InputMismatchException e) {
        SCANNER.nextLine(); // Limpar entrada inválida
        System.out.println(Ansi.ansi().fgBrightRed().a("Entrada inválida! Escolha um número.").reset());
      }
    }
  }

  private static void exibirMenu() {
    System.out.println(Ansi.ansi()
        .fgGreen().a("\n=== Menu Interativo ===\n").reset()
        .fgYellow().a("1- Jogar Jogo da Velha\n").reset()
        .fgYellow().a("2- Sobre o Jogo\n").reset()
        .fgYellow().a("3- Sair\n").reset()
        .fgGreen().a("=== === === === === ===\n").reset());
  }

  private static void logoJogoDaVelha() {
    System.out.println(Ansi.ansi()
        .fgCyan().bold().a(" ███████    █████     █████     █████       █████     █████      ██       ██   █████   ██     ██     ██     █████\n")
        .a("    ██     ██   ██   ██   ██   ██   ██      ██  ██   ██   ██     ██       ██   ██      ██     ██     ██   ██     ██\n")
        .fgYellow().a("    ██     ██   ██   ██        ██   ██      ██   ██  ███████      ██     ██    ████    ██     █████████   █████████\n")
        .fgGreen().a("██  ██     ██   ██   ██  ████  ██   ██      ██  ██   ██   ██       ██   ██     ██      ██     ██     ██   ██     ██\n")
        .fgGreen().a("  ██        █████      ████     █████       █████    ██   ██        █████      █████   █████  ██     ██   ██     ██\n")
        .reset()
        .toString()
    );
  }

  private static void iniciarJogo() {
    InicializarJogo();
  }

  private static void sobreOJogo() {
    System.out.println(Ansi.ansi()
        .fgDefault().a("\n")
        .fgDefault().a("O Jogo da Velha foi um projeto idealizado pelo professor ").reset()
        .fgGreen().a("Rogério Freitas").reset()
        .fgDefault().a(", da Turma 4 do Programa 1000Devs,\n").reset()
        .fgDefault().a("realizado pela ").reset()
        .fgMagenta().a("mesttra ").reset()
        .fgDefault().a("em parceria com a ").reset()
        .fgRed().a("Johnson & Johnson MedTech ").reset()
        .fgDefault().a("e o ").reset()
        .fgBlue().a("Hospital Israelita Albert Einstein").reset()
        .fgDefault().a(".\n\n").reset());

    System.out.println(Ansi.ansi()
        .fgDefault().a("O jogo foi desenvolvido com:\n").reset()
        .fgDefault().a("- Linguagem de programação: ").reset()
        .fgRed().a("Java com Maven\n").reset()
        .fgDefault().a("- Controle de versionamento: ").reset()
        .fgRed().a("Git e Gitflow\n").reset());


    System.out.println(Ansi.ansi()
        .fgDefault().a("Versão: 1.0\n").reset()
        .fgDefault().a("Build: 12/12/2024\n\n").reset());

    System.out.println(Ansi.ansi()
        .fgGreen().a("Pressione Enter para voltar ao menu...\n").reset());

    SCANNER.nextLine(); // Aguarda Enter
  }

  public static void limparTela() {
    try {
      if (System.getProperty("os.name").contains("Windows")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      } else {
        System.out.print("\033[H\033[2J");
        System.out.flush();
      }
    } catch (Exception e) {
      System.out.println(Ansi.ansi().fgRed().a("Erro ao limpar a tela.").reset());
    }
  }
}

