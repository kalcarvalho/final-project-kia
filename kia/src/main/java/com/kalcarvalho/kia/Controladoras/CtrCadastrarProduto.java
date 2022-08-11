package Controladoras;

import CamadaNegocios.CatalogoProduto;
import CamadaNegocios.Fornecedor;
import javax.swing.JOptionPane;
import java.util.Vector;

public class CtrCadastrarProduto
{
   private Fornecedor forn;
   private CatalogoProduto ct;

   public CtrCadastrarProduto()
   {
      ct = new CatalogoProduto();
      forn = new Fornecedor();
   }

   public Vector preencherForn()
  {
     return forn.getFornecedor();
  }

  public void cadastrar(String razaoSocial,String descricao,String codProd,
			String refrig,String unidade,String apres,double estMin,
			double estMax,double pCusto,double pVenda)
  {
     ct.cadastrar(razaoSocial,descricao,codProd,refrig,unidade,apres,
			 estMin,estMax,pCusto,pVenda);
  }

  public void destrutor() throws Throwable
    {
       ct.destrutor();
       forn.destrutor();
       this.finalize();
    }

}
