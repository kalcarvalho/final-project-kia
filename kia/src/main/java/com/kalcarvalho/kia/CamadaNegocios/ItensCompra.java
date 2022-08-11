package CamadaNegocios;

import java.util.Vector;

public class ItensCompra extends CtrDados {

  protected double quantidade;
  private double preco;
  protected Estoque est;

  public ItensCompra() {
    est = new Estoque();
  }

  public double subtotal(double quant, double preco) {
    quantidade = quant;
    this.preco = preco;
    return quantidade * preco;
  }

  public void criar(
    int idcompra,
    int idpro,
    String vali,
    int qtd,
    double prec
  ) {
    Vector campo = new Vector();
    campo.addElement("");
    campo.addElement(String.valueOf(qtd));
    campo.addElement(String.valueOf(idpro));
    campo.addElement(String.valueOf(this.subtotal(qtd, prec)));
    campo.addElement(vali);
    campo.addElement(String.valueOf(idcompra));
    cmd.inserir(campo, "ItensCompra");
    //     Logger.registrar("MAX(idTens)","ItensCompra","Inserção");
    est.atualizarEstoque(idpro, qtd, vali);
  }

  public void cancelar(int cod) {
    cmd.remover("ItensCompra", "idCompra='" + cod + "'");
    Logger.registrar(String.valueOf(cod), "Itens", "Remoção");
  }

  public Vector cancelar(String cod) {
    Vector itens;
    cmd.chamarSQL(
      "SELECT idProduto, Quantidade, validade FROM ItensCompra WHERE idCompra=" +
      cod
    );
    itens = cmd.getFromRegistros(cmd.executarSQL(), 3);
    this.cancelar(Integer.parseInt(cod));
    return itens;
  }

  public void destrutor() throws Throwable {
    est.destrutor();
    this.finalize();
  }
}
