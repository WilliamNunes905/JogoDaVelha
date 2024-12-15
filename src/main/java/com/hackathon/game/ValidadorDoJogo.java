package com.hackathon.game;

import java.util.Random;
import java.util.Scanner;

public class ValidadorDoJogo {
  static int[] obterJogadaUsuario(String posicoesLivres, Scanner teclado) {
    int[] jogada = new int[2];
    boolean jogadaAceita = false;

    while (!jogadaAceita) {
      try {
        // Exibe o prompt apenas uma vez por iteração
        System.out.print("Digite a linha e coluna com espaço entre eles: ");
        String entrada = teclado.nextLine().trim();

        // Se a entrada for vazia, continue sem exibir mensagens adicionais
        if (entrada.isEmpty()) {
          continue;
        }

        String[] partes = entrada.split(" ");

        // Verifica se foram fornecidos dois números
        if (partes.length != 2) {
          System.out.println("Entrada inválida! Digite dois números separados por espaço.");
          continue;
        }

        // Tenta converter os números
        int linha = Integer.parseInt(partes[0]);
        int coluna = Integer.parseInt(partes[1]);

        // Valida se a jogada está nas posições livres
        if (jogadaValida(posicoesLivres, linha, coluna)) {
          jogada[0] = linha;
          jogada[1] = coluna;
          jogadaAceita = true;
        } else {
          System.out.println("Jogada não existe ou está indisponível. Tente novamente!");
        }
      } catch (NumberFormatException e) {
        System.out.println("Entrada inválida! Certifique-se de digitar números válidos.");
      }
    }
    return jogada;
  }

  static int[] obterJogadaComputador(String posicoesLivres) {
    String[] vetorPosicoes = posicoesLivres.split(";");
    Random random = new Random();

    // Sorteia uma posição livre
    int indiceSorteado = random.nextInt(vetorPosicoes.length);

    // Converte a posição sorteada para um vetor de inteiros
    return converterJogadaStringParaVetorInt(vetorPosicoes[indiceSorteado]);
  }

  static int[] converterJogadaStringParaVetorInt(String jogada) {
    // Divide a string no formato "linha,coluna" usando vírgula como separador
    String[] partes = jogada.split(",");

    // Inicializa o vetor de inteiros para linha e coluna
    int[] jogadaVetor = new int[2];
    jogadaVetor[0] = Integer.parseInt(partes[0]); // Linha
    jogadaVetor[1] = Integer.parseInt(partes[1]); // Coluna

    return jogadaVetor;
  }

  static boolean jogadaValida(String posicoesLivres, int linha, int coluna) {
    // Formata a jogada no formato "linha,coluna"
    String jogada = linha + "," + coluna;

    // Verifica se a jogada está presente na string de posições livres
    return posicoesLivres.contains(jogada);
  }
}
