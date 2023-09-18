/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tde.pkg2.torre.hanoi;

class Node {
  public int iData; 
  public Link next; // Próximo nó na lista

  public Node(int id) { 
        iData = id;
    }

  public void displayLink() { // Exibe os nos
    System.out.print("[" + iData + "] ");
  }
}

class LinkedListNode {
  private Link first; 

  public LinkedListNode() { 
        first = null; 
    }
  public boolean vazio() {
    return (first == null);
  }

  public void inserePrimeiro(int id) { // Insere no início da lista
    Link newLink = new Link(id); 
    newLink.next = first; 
    first = newLink; 
  }

  public Link verUltimo() {
    if (vazio()) {
      return null;
    }

    Link current = first;
    while (current.next != null) {
      current = current.next;
    }
    return current;
  }

  public void insereUltimo(int id) { // Insere ao final da lista
    Link newLink = new Link(id); // Cria um novo nó

    if (first == null) { // Caso a lista estiver vazia
      first = newLink; 
    } else {
      Link current = first;
      while (current.next != null) {
        current = current.next; // Move para o próximo nó existente
      }
      current.next = newLink; // novo nó no final da lista
    }
  }

  public Link encontrar(int chave) {
    Link current = first; // inicia primeiro nó
    while (current != null) { 
      if (current.iData == chave) { // caso encontrar valor requisitado 
        return current; 
      }
      current = current.next; 
    }
    return null; 
  }

  public Link deletar(int chave) {
    Link current = first;
    Link previous = null;

    while (current != null && current.iData != chave) { 
      previous = current; 
      current = current.next; 
    }
    if (current == null) {
      return null; 
    }

    if (previous == null) {
      first = first.next; 
    } else {
      previous.next = current.next; 
    }

    return current; 
  }

  public Link deletarUltimo() {
    if (vazio()) {
      return null; 
    }

    if (first.next == null) {
      Link temp = first;
      first = null;
      return temp; 
    }

    Link current = first;
    Link previous = null;

    while (current.next != null) {
      previous = current;
      current = current.next;
    }

    previous.next = null; 
    return current; 
  }

  public void displayList() { 
    System.out.print("(primeiro -> último): ");
    Link current = first; 
    while (current != null) { 
      current.displayLink(); 
      current = current.next; 
    }
    System.out.println(" ");
  }
}
