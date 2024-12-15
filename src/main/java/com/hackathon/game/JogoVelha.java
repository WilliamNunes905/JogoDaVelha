package com.hackathon.game;

import static com.hackathon.config.ConfigDoJogo.sortearValorBooleano;
import static com.hackathon.game.ValidadorDoJogo.obterJogadaComputador;
import static com.hackathon.game.ValidadorDoJogo.obterJogadaUsuario;
import static com.hackathon.ui.Emojes.exibirEmpate;
import static com.hackathon.ui.Emojes.exibirVitoriaComputador;
import static com.hackathon.ui.Emojes.exibirVitoriaUsuario;
import static com.hackathon.ui.MenuDoJogo.limparTela;

import java.util.Scanner;

public class JogoVelha {

  final static String CARACTERES_IDENTIFICADORES_ACEITOS = "XO0UC";

  final static int TAMANHO_TABULEIRO = 3;

  public static void InicializarJogo() {
    Scanner teclado = new Scanner(System.in);

    char[][] tabuleiro = new char[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];
    tabuleiro = inicializarTabuleiro(tabuleiro);

    // Define caracteres para usuário e computador
    char caractereUsuario = obterCaractereUsuario(teclado);
    char caractereComputador = obterCaractereComputador(teclado, caractereUsuario);

    // Sorteia quem começa jogando
    boolean vezUsuarioJogar = sortearValorBooleano();

    boolean jogoContinua;

    do {
      limparTela();
      exibirTabuleiro(tabuleiro);
      jogoContinua = true;

      if (vezUsuarioJogar) {
        tabuleiro = processarVezUsuario(teclado, tabuleiro, caractereUsuario);

        if (teveGanhador(tabuleiro, caractereUsuario)) {
          exibirTabuleiro(tabuleiro);
          exibirVitoriaUsuario();
          jogoContinua = false;
        }
        vezUsuarioJogar = false;
      } else {
        tabuleiro = processarVezComputador(tabuleiro, caractereComputador);

        if (teveGanhador(tabuleiro, caractereComputador)) {
          exibirTabuleiro(tabuleiro);
          exibirVitoriaComputador();
          jogoContinua = false;
        }
        vezUsuarioJogar = true;
      }

      if (jogoContinua && teveEmpate(tabuleiro)) {
        exibirTabuleiro(tabuleiro);
        exibirEmpate();
        jogoContinua = false;
      }
    } while (jogoContinua);
  }

  //Inicializa o tabuleiro com o caractere ' ' (espaço).
  static char[][] inicializarTabuleiro(char[][] tabuleiro) {
    for (int i = 0; i < tabuleiro.length; i++) {
      for (int j = 0; j < tabuleiro[i].length; j++) {
        tabuleiro[i][j] = ' ';
      }
    }
    return tabuleiro;
  }

  static char obterCaractereUsuario(Scanner teclado) {
    char caractere;
    do {
      System.out.print("Digite o caractere que deseja utilizar (X, O, 0, U, C): ");
      caractere = teclado.next().toUpperCase().charAt(0);

      if (CARACTERES_IDENTIFICADORES_ACEITOS.indexOf(caractere) == -1) {
        System.out.println("Caractere inválido! Escolha apenas entre: " + CARACTERES_IDENTIFICADORES_ACEITOS);
      }
    } while (CARACTERES_IDENTIFICADORES_ACEITOS.indexOf(caractere) == -1);
    return caractere;
  }

  static char obterCaractereComputador(Scanner teclado, char caractereUsuario) {
    char caractereComputador;
    while (true) {
      System.out.print("Digite o caractere para o computador (X, O, 0, U, C): ");
      caractereComputador = teclado.next().toUpperCase().charAt(0);

      // Verifica se o caractere está na lista aceita e é diferente do caractere do usuário
      if (CARACTERES_IDENTIFICADORES_ACEITOS.indexOf(caractereComputador) != -1 && caractereComputador != caractereUsuario) {
        break; // Sai do loop se for válido
      } else {
        System.out.println("Caractere inválido ou já escolhido pelo usuário. Tente novamente.");
      }
    }
    return caractereComputador;
  }

  static char[][] processarVezUsuario(Scanner teclado, char[][] tabuleiro, char caractereUsuario) {
    System.out.println("\nVez do usuário: ");
    String posicoesLivres = retornarPosicoesLivres(tabuleiro);
    int[] jogada = obterJogadaUsuario(posicoesLivres, teclado);
    tabuleiro = retornarTabuleiroAtualizado(tabuleiro, jogada, caractereUsuario);
    return tabuleiro;
  }

  static char[][] processarVezComputador(char[][] tabuleiro, char caractereComputador) {
    System.out.println("\nVez do computador: ");
    String posicoesLivres = retornarPosicoesLivres(tabuleiro);
    int[] jogada = obterJogadaComputador(posicoesLivres);
    tabuleiro = retornarTabuleiroAtualizado(tabuleiro, jogada, caractereComputador);
    return tabuleiro;
  }

  static String retornarPosicoesLivres(char[][] tabuleiro) {
    StringBuilder posicoesLivres = new StringBuilder();

    // Percorre as linhas e colunas do tabuleiro
    for (int i = 0; i < tabuleiro.length; i++) {
      for (int j = 0; j < tabuleiro[i].length; j++) {
        // Verifica se a posição está livre (representada por um espaço)
        if (tabuleiro[i][j] == ' ') {
          // Adiciona a posição no formato "linha,coluna" ao resultado
          posicoesLivres.append(i).append(",").append(j).append(";");
        }
      }
    }

    // Remove o último ";" caso exista
    if (posicoesLivres.length() > 0) {
      posicoesLivres.setLength(posicoesLivres.length() - 1);
    }
    return posicoesLivres.toString();
  }

  // Verifica se o jogador ganhou em alguma linha, coluna, diagonal peincipal ou secundária
  static boolean teveGanhador(char[][] tabuleiro, char caractereJogador) {
    if (teveGanhadorLinha(tabuleiro, caractereJogador)) {
      return true;
    }
    if (teveGanhadorColuna(tabuleiro, caractereJogador)) {
      return true;
    }
    if (teveGanhadorDiagonalPrincipal(tabuleiro, caractereJogador)) {
      return true;
    }
    if (teveGanhadorDiagonalSecundaria(tabuleiro, caractereJogador)) {
      return true;
    }
    return false;
  }

  // Verifica se toda a linha está preenchida com o caractere do jogador
  static boolean teveGanhadorLinha(char[][] tabuleiro, char caractereJogador) {
    for (int i = 0; i < tabuleiro.length; i++) {
      boolean venceu = true;
      for (int j = 0; j < tabuleiro[i].length; j++) {
        if (tabuleiro[i][j] != caractereJogador) {
          venceu = false;
          break;
        }
      }
      if (venceu) {
        return true;
      }
    }
    return false;
  }

  // Verifica se toda a coluna está preenchida com o caractere do jogador
  static boolean teveGanhadorColuna(char[][] tabuleiro, char caractereJogador) {
    for (int j = 0; j < tabuleiro.length; j++) { // Percorre todas as colunas
      boolean venceu = true;
      for (int i = 0; i < tabuleiro.length; i++) { // Verifica cada linha da coluna
        if (tabuleiro[i][j] != caractereJogador) {
          venceu = false;
          break;
        }
      }
      if (venceu) {
        return true; // Retorna true se todas as linhas da coluna forem do jogador
      }
    }
    return false;
  }

  // Verifica se a diagonal principal está toda preenchida com o caractere do jogador
  static boolean teveGanhadorDiagonalPrincipal(char[][] tabuleiro, char caractereJogador) {
    for (int i = 0; i < tabuleiro.length; i++) {
      if (tabuleiro[i][i] != caractereJogador) {
        return false;
      }
    }
    return true;
  }
  // Verifica se a diagonal secundária está toda preenchida com o caractere do jogador
  static boolean teveGanhadorDiagonalSecundaria(char[][] tabuleiro, char caractereJogador) {
    for (int i = 0; i < tabuleiro.length; i++) {
      if (tabuleiro[i][tabuleiro.length - 1 - i] != caractereJogador) {
        return false;
      }
    }
    return true;
  }

  static void exibirTabuleiro(char[][] tabuleiro) {
    System.out.println("   0   1   2");
    for (int l = 0; l < 3; l++) {
      System.out.print(l + " ");
      for (int c = 0; c < 3; c++) {
        System.out.print(" " + tabuleiro[l][c] + " ");
        if (c < 2) System.out.print("|");
      }
      if (l < 2) System.out.println("\n  -----------");
    }
  }

  static char[][] retornarTabuleiroAtualizado(char[][] tabuleiro, int[] jogada, char caractereJogador) {
    tabuleiro[jogada[0]][jogada[1]] = caractereJogador;
    return tabuleiro;
  }

  // Percorre todo o tabuleiro e verifica se há algum espaço vazio
  static boolean teveEmpate(char[][] tabuleiro) {
    for (int i = 0; i < tabuleiro.length; i++) {
      for (int j = 0; j < tabuleiro[i].length; j++) {
        if (tabuleiro[i][j] == ' ') {
          return false;
        }
      }
    }
    return true;
  }
}