package Controladoras;

import CamadaNegocios.Produto;
import CamadaNegocios.Fornecedor;
import javax.swing.JOptionPane;
import java.util.Vector;

public class CtrAlterarProduto
{

   private Produto pro;
   private Fornecedor forn;

  public CtrAlterarProduto()
  {
     pro = new Produto();
     forn = new Fornecedor();
  }

  public Vector preencherForn()
    {
       return forn.getFornecedor();
    }

    /**
     * botão comboBox, seleciona um fornecedor e o comboBox Produto
     * @param razaoSocial
     * @return Vector de descrição de produto
     */
  public Vector SelecionarFornecedor(String razaoSocial)
  {
     String cnpj = forn.getFornecedor(razaoSocial);
     return pro.getProduto(cnpj);
  }

  /**
   * botão comboBox, seleciona um produto e preenche a tela com seus dados
   * @param descricao
   * @return Vector com todos os campos de um produto x
   */
  public Vector SelecionarProduto(String descricao)
  {
     return pro.getDadosProduto(descricao);
  }

  public void alterar(String descricao,String codProd,String ref,String un,
		      String apres,double estmin,double estmax,double pCusto,
		      double pVenda,String idProduto)
   {
      pro.alterar(descricao, codProd, ref, un, apres, estmin, estmax,
		  pCusto,pVenda,idProduto);
   }
   public void destrutor() throws Throwable
     {
	pro.destrutor();
	forn.destrutor();
	this.finalize();
     }

}
