
package tde.pkg2.torre.hanoi;

class TorreHanoi {
  private LinkList lista;

  public TorreHanoi() {
    lista = new LinkList();
  }

  public void empilharDisco(int tamanho) {
    lista.insereUltimo(tamanho);
  }

  public int desempilharDisco() {
    if (!vazia()) {
      Link ultimoLink = lista.deletarUltimo();
      return ultimoLink.iData;
    }
    return -1; 
  }

  public boolean vazia() {
    return lista.vazio();
  }

  public void imprimirTorre() {
    lista.displayList();
  }

  public int verTopo() {
    if (!vazia()) {
      Link ultimoLink = lista.verUltimo();
      return ultimoLink.iData;
    }
    return -1; 
  }
}
