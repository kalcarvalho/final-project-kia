package Controladoras;

import CamadaNegocios.*;
import java.util.*;

public class CtrVenda {

  private static Venda vnd;
  private static ContasaReceber conta;
  private static CatalogoProduto ctp;
  private static Cliente cli;

  public CtrVenda() {
    vnd = new Venda();
    ctp = new CatalogoProduto();
    cli = new Cliente();
    conta = new ContasaReceber();
  }

  /**
   * Preenche o combobox de cliente
   * @return Vetor de clientes
   */
  public Vector preencherCliente() {
    return cli.getCliente();
  }

  /**
   * Preenche o combobox de produtos em estoque
   * @return Vetor de Produtos
   */
  public Vector preencherProduto() {
    return ctp.selecionarProduto(0);
  }

  /**
   * Retorna um cliente
   * @param str codigo de cliente
   * @return
   */
  public String selecionarCliente(String str) {
    return cli.getCliente(str);
  }

  /**
   *
   * @param descp Descricao de Produto
   * @param emis Emissao da Nota
   * @return Vetor c/ id de produto / precos / validades
   */

  public Vector selecionarProduto(String descp, String emis) {
    Vector tmp = new Vector();
    int idcod = ctp.selecionarProd(descp);
    tmp.add(Integer.toString(idcod)); //Carregar: Preco  Estoque Validade
    tmp.add(Double.toString(ctp.carregarPreco(idcod)));
    tmp.addElement(vnd.getValidade(idcod, emis));
    tmp.addElement(ctp.carregarUnidade(idcod));
    tmp.trimToSize();
    return tmp;
  }

  /**
   * Entrar Itens
   * @param idpro Código do item
   * @param vali Validade do item
   * @param qtd Quantidade selecionada
   * @param prec Preco de venda do item
   * @param data
   * @return Vetor com Numero da Nota e Total da Venda
   */
  public Vector entrarItem(
    int idpro,
    String vali,
    int qtd,
    double prec,
    String data
  ) {
    Vector tmp = new Vector();
    tmp.add(
      Double.toString(vnd.construirLinhaItem(idpro, vali, qtd, prec, data))
    );
    tmp.add(Integer.toString(vnd.getMaxIdVenda()));
    tmp.trimToSize();
    return tmp;
  }

  public void vender(String venc, String data, String nota, String idCliente) {
    vnd.finalizar(venc, data, nota, idCliente);
  }

  public void cancelar(Vector est) {
    vnd.cancelar(est);
  }

  public Vector selecionarValidade(int idcod, String str) {
    Vector tmp = new Vector();
    tmp.add(Integer.toString(vnd.getEstoquePorValidade(idcod, str)));
    tmp.add(Integer.toString(ctp.getEstoqueMinimo(idcod)));
    tmp.add(Integer.toString(ctp.getEstoqueMaximo(idcod)));
    tmp.trimToSize();
    return tmp;
  }
}
