package Controladoras;

import CamadaNegocios.Fornecedor;
import CamadaNegocios.CatalogoProduto;
import javax.swing.JOptionPane;
import java.util.Vector;

public class CtrExcluirProduto
{
   private Fornecedor forn;
   private CatalogoProduto ct;

  public CtrExcluirProduto()
  {
     forn = new Fornecedor();
     ct = new CatalogoProduto();
  }

  public Vector preencherForn()
  {
     return forn.getFornecedor();
  }

  public String selecionarFornecedor(String str)
  {
     return forn.getFornecedor(str);
  }

  public Vector preencherProd(String str)
  {
     return ct.selecionarProduto(str);
  }

  public void opcaoProduto(String descricao, String cnpj)
  {
     ct.removerProduto(descricao,cnpj);
  }

  public void destrutor() throws Throwable
    {
       forn.destrutor();
       ct.destrutor();
       this.finalize();
    }

}
