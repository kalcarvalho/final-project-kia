package CamadaNegocios;

/**
 * <p>Title: Distribuidora</p>
 * <p>Description: Controla Venda, Compra, Validade, Estoque, Relatórios e Melhor Rota de Entrega</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: AIK</p>
 * @author Alan, Ilson e Kal-el
 * @version 1.0
 */

public class Loja {

  private int num;
  private int rota;

  public Loja() {}

  public Loja(int n, int r) {
    num = n;
    rota = r;
  }

  public int getNumero() {
    return num;
  }

  public int getRota() {
    return rota;
  }
}
