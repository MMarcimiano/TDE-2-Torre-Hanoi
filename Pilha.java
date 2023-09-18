/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tde.pkg2.torre.hanoi;

class Pilha {
  private int maxSize;
  private long[] stackArray;
  private int top;

  public Pilha(int s) {
    maxSize = s;
    stackArray = new long[maxSize];
    top = -1;
  }

  public void inserir(long j) {
    stackArray[++top] = j;
  }

  public long remove() {
    if (!vazia()) {
      return stackArray[top--];
    } else {
      System.out.println("A pilha está vazia. Não é possível remover elementos.");
      return -1;
    }
  }

  public long ver_topo() {
    return stackArray[top];
  }

  public boolean vazia() {
    return (top == -1);
  }

  public boolean cheia() {
    return (top == maxSize - 1);
  }

  public void imprime() {
    if (!vazia()) {
      for (int i = top; i >= 0; i--) {
        System.out.print(stackArray[i] + " ");
      }
      System.out.println();
    } else {
      System.out.println("A pilha está vazia. Não há elementos para imprimir.");
    }
  }
}
