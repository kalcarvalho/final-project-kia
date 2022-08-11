package Controladoras;

import CamadaNegocios.Estoque;
import CamadaNegocios.Fornecedor;
import CamadaNegocios.Produto;
import java.util.Vector;
import javax.swing.*;

public class CtrConsultarEstoque extends JFrame {

  private Fornecedor forn;
  private Produto pro;
  private Estoque est;

  public CtrConsultarEstoque() {
    forn = new Fornecedor();
    pro = new Produto();
    est = new Estoque();
  }

  public Vector preencherForn() {
    return forn.getFornecedor();
  }

  /**
   * botão comboBox, seleciona um fornecedor e o comboBox Produto
   * @param razaoSocial
   * @return Vector de descrição de produto
   */
  public Vector SelecionarFornecedor(String razaoSocial) {
    String cnpj = forn.getFornecedor(razaoSocial);
    return pro.getProduto(cnpj);
  }

  public Vector SelecionarProduto(String descricao) {
    int id = pro.getIdProduto(descricao);
    return est.getEstoqueVal(id);
  }

  public void destrutor() throws Throwable {
    this.finalize();
  }
}
