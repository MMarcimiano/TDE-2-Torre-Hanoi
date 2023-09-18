
package tde.pkg2.torre.hanoi;

import java.util.Scanner;
import java.util.Random;

public class TDE2TorreHanoi {
  private static Torre[] torres;
  private static int NUM_DISCOS;
  private static int numMovimentos;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Selecione o número desejado de peças para a partida: ");
    NUM_DISCOS = scanner.nextInt();

    torres = new Torre[3];
    inicializarTorres();
    boolean jogando = true;

    while (jogando) {
      mostrarMenu();
      int opcao = scanner.nextInt();
      switch (opcao) {
        case 0:
          jogando = false;
          break;
        case 1:
          jogarTorreHanoi(scanner);
          break;
        case 2:
          numMovimentos = 0;
          resolverTorreHanoi(NUM_DISCOS, 0, 2, 1);
          System.out
              .println("O modo máquina resolveu automaticamente a Torre de Hanói em " + numMovimentos + " movimentos");
          break;
        default:
          System.out.println("Opção inválida. Escolha novamente!");
          break;
      }
    }

    System.out.println("Encerrado. Obrigado!");
    scanner.close();
  }

  public static void mostrarMenu() {
    System.out.println("\nMenu:");
    System.out.println("0 - Sair do jogo");
    System.out.println("1 - Jogar (padrão)");
    System.out.println("2 - Resolver automático (Modo máquina)");
    System.out.print("Escolha uma opção: ");
  }

  public static void inicializarTorres() {
    for (int i = 0; i < 3; i++) {
      torres[i] = new Torre();
    }

    int[] discosAleatorios = gerarDiscosAleatorios(NUM_DISCOS);

    for (int i = NUM_DISCOS - 1; i >= 0; i--) {
      torres[0].empilharDisco(discosAleatorios[i]);
    }
  }

  public static int[] gerarDiscosAleatorios(int numDiscos) {
    int[] discos = new int[numDiscos];
    Random random = new Random();

    for (int i = 0; i < numDiscos; i++) {
      discos[i] = random.nextInt(100);
    }

    return discos;
  }

  public static void jogarTorreHanoi(Scanner scanner) {
    int movimentos = 0;
    while (true) {
      imprimirEstadoTorres();
      System.out.print("Digite a torre de origem da peça (0, 1, 2) ou -1 para encerrar: ");
      int origem = scanner.nextInt();

      if (origem == -1) {
        break;
      }

      System.out.print("digite a torre de destino do movimento (0, 1, 2): ");
      int destino = scanner.nextInt();

      if (movimentoValido(origem, destino)) {
        moverDisco(origem, destino);
        movimentos++;
      } else {
        System.out.println("Movimento inválido. Realizar novamente a jogada.");
      }
    }
    System.out.println("Meus parabéns!!!!! Você conseguiu completar a partida em " + movimentos + " movimentos!");
  }

  public static boolean movimentoValido(int origem, int destino) {
    if (origem < 0 || origem > 2 || destino < 0 || destino > 2) {
      return false;
    }

    if (torres[origem].vazia()) {
      return false;
    }

    if (!torres[destino].vazia() && torres[origem].verTopo() > torres[destino].verTopo()) {
      return false;
    }

    return true;
  }

  public static void moverDisco(int origem, int destino) {
    if (movimentoValido(origem, destino)) {
      int disco = torres[origem].desempilharDisco();
      if (disco != -1) {
        torres[destino].empilharDisco(disco);
      } else {
        System.out.println("Erro: a torre desejada está vazia.");
      }
    } else {
      System.out.println("Movimento inválido. realizar novamente.");
    }
  }

  public static void imprimirEstadoTorres() {
    for (int i = 0; i < 3; i++) {
      System.out.print("Torre " + i + ": ");
      torres[i].imprimirTorre();
    }
    System.out.println();
  }

  public static void resolverTorreHanoi(int n, int origem, int destino, int auxiliar) {
    if (n == 1) {
      int discoMovido = torres[origem].desempilharDisco();
      torres[destino].empilharDisco(discoMovido);
      System.out.println("Mover disco " + discoMovido + " da torre " + origem + " para a torre " + destino);
      numMovimentos++;
    } else {
      resolverTorreHanoi(n - 1, origem, auxiliar, destino);
      int discoMovido = torres[origem].desempilharDisco();
      torres[destino].empilharDisco(discoMovido);
      System.out.println("Mover disco " + discoMovido + " da torre " + origem + " para a torre " + destino);
      numMovimentos++;
      resolverTorreHanoi(n - 1, auxiliar, destino, origem);
    }
  }
}

