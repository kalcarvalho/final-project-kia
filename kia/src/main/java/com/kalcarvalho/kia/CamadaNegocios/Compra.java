package CamadaNegocios;

import java.util.*;

public class Compra extends CtrDados {

  protected int cod;
  protected Date data;
  protected Date datavencimento;
  protected boolean status;
  private double total;
  protected ItensCompra ic;
  protected Estoque est;
  protected ContasaPagar conta;
  private Data dt;

  public Compra() {
    dt = new Data();
    ic = new ItensCompra();
    est = new Estoque();
    conta = new ContasaPagar();
    total = 0;
    status = true;
  }

  public double total(int qtd, double prec) {
    return total += ic.subtotal(qtd, prec);
  }

  public double construirLinhaItem(
    String idFornecedor,
    String nota,
    int idpro,
    String vali,
    int qtd,
    double prec,
    String data
  ) {
    Vector tmp = new Vector();
    Vector campo = new Vector();
    campo.addElement(data);
    campo.addElement(dt.getCorrenteHora());
    campo.addElement(null);
    campo.addElement(nota);
    campo.addElement(idFornecedor);
    String cond;
    if (status) {
      cmd.inserir(campo, "Compra");
      Logger.registrar("MAX(idCompra)", "Compra", "Inserção");
      cmd.chamarSQL("SELECT MAX(idCompra) FROM COMPRA");
      cod = cmd.getInt(cmd.executarSQL());
    }
    status = false;
    ic.criar(cod, idpro, vali, qtd, prec);
    return this.total(qtd, prec);
  }

  public void finalizar(String venc, String data, String nota, String idForn) {
    Vector campo = new Vector();
    Vector valor = new Vector();
    Vector tmp = new Vector();
    campo.addElement("data");
    campo.addElement("notaFiscal");
    campo.addElement("idFornecedor");
    valor.addElement(data);
    valor.addElement(nota);
    valor.addElement(idForn);
    cmd.atualizar("Compra", campo, valor, "idCompra=" + cod);
    //o parametro é confirmação porque apesar do update não é feito uma alteração
    //ao se inicar a compra o id já é gerado, a atualização é que lança os valor
    //      da compra
    Logger.registrar(String.valueOf(cod), "Compra", "Confirmação");
    tmp.addElement("");
    tmp.addElement(venc);
    tmp.addElement(String.valueOf(total));
    tmp.addElement("0");
    tmp.addElement(null);
    cmd.inserir(tmp, "ContasaPagar");
    Logger.registrar("MAX(idConta)", "ContasaPagar", "Inserção");
    conta.gravar(cod);
  }

  public void cancelar(Vector e) {
    cmd.remover("Compra", "idCompra='" + cod + "'");
    Logger.registrar(String.valueOf(cod), "Compra", "Remoção");
    est.cancelarEstoque(e);
    ic.cancelar(cod);
  }

  public Vector getCompraAberto() {
    Vector tmp = new Vector();
    cmd.chamarSQL(
      "SELECT Compra.idCompra " +
      "FROM Compra, ContasaPagar, ContaCompra " +
      "WHERE Compra.idCompra=ContaCompra.idCompra " +
      "AND ContasaPagar.idConta=ContaCompra.idConta " +
      "AND status=0 " +
      "ORDER BY idCompra"
    );
    tmp = cmd.getArrayRegistros(cmd.executarSQL());
    if (tmp == null) return new Vector();
    return tmp;
  }

  public Vector getDadosCompra(int idcompra) {
    Vector tmp = new Vector();
    try {
      cmd.chamarSQL(
        "SELECT razaoSocial, data, valor " +
        "FROM Fornecedor, Compra, ContasaPagar, ContaCompra " +
        "WHERE ContaCompra.idCompra=Compra.idCompra " +
        "AND ContaCompra.idConta=ContasaPagar.idConta " +
        "AND cnpj=idFornecedor " +
        "AND Compra.idCompra=" +
        idcompra
      );

      tmp = cmd.getFromRegistros(cmd.executarSQL(), 3);
      if (tmp == null) return new Vector();
    } catch (Exception ex) {
      ex.printStackTrace();
      return new Vector();
    }
    return tmp;
  }

  public void cancelar(int idv) {
    Vector itens;
    cod = idv;
    cmd.chamarSQL("DELETE FROM Compra WHERE idCompra=" + cod + "");
    cmd.inserirSQL();
    itens = ic.cancelar(Integer.toString(cod));
    itens.trimToSize();
    est.retirarEstoque(
      Integer.parseInt((String) itens.get(0)),
      Double.parseDouble((String) itens.get(1)),
      (String) itens.get(2)
    );
    conta.cancelar(cod);
  }

  public void destrutor() throws Throwable {
    ic.destrutor();
    est.destrutor();
    conta.destrutor();
    this.finalize();
  }
}
