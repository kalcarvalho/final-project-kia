package CamadaNegocios;

import java.util.Vector;

public class CatalogoProduto extends CtrDados
{

   private int idcp;
   private Fornecedor forn;
   private Produto esp;

   public CatalogoProduto()
   {
      forn = new Fornecedor();
      esp = new Produto();
   }

   public Vector selecionarFornecedor()
   {
      return forn.getFornecedor();
   }

   public Vector selecionarProduto(String str)
   {
      return esp.getProduto(str);
   }

   public int selecionarProd(String str, String str2)
   {
      return esp.getProd(str,str2);
   }

   public double carregarPreco(int idcod)
   {
      return esp.getPrecoCusto(idcod);
   }

   public String carregarUnidade(int idcod)
   {
      return esp.getUnidade(idcod);
   }


   public String selecionarFornecedor(String str)
   {
      return forn.getFornecedor(str);
   }

   public void cadastrar(String razaoSocial,String descricao,String codProd,
			String refrig,String unidade,String apres,double estMin,
			double estMax,double pCusto,double pVenda)
  {

      int idProduto = esp.cadastrar(descricao,codProd,refrig,unidade,apres,
				  estMin,estMax,pCusto,pVenda);
      esp.cadastrarIDEstoque(idProduto);
      String idForn = this.selecionarFornecedor(razaoSocial);
      this.setAssociativa(idProduto,idForn);
   }

   public void setAssociativa(int idProduto,String idFornecedor)
   {
      Vector tmp = new Vector();
      tmp.addElement(idFornecedor);
      tmp.addElement(String.valueOf(idProduto));
      cmd.inserir(tmp,"CT");
   }

   /**
    * remove o produto de um determinado fornecedor
    * @param cnpj chave primaria do fornecedor
    * @param descricao é um parametro único de fornecedor, não possui
    * nomes iguais, ex. arroz sepé, arroz figueira, não permite
    * duas entradas iguais na tabela
    */
   public void removerProduto(String descricao,String cnpj)
      {
	 int idProd=this.selecionarProd(descricao,cnpj);
	 cmd.remover("CT","idProduto="+idProd);
	 esp.removerProduto(idProd);
      }

   public Vector selecionarProduto(int min)
   {
      return esp.getProduto(min);
   }

   public int selecionarProd(String str)
   {
      return esp.getProd(str);
   }

   /**
       * Retorna o estoque minimo de um produto informado
       * @param idcod Codigo do produto
       * @return Estoque minimo
       */
      public int getEstoqueMinimo(int idcod)
      {
	 return esp.getEstoqueMinimo(idcod);
      }
      /**
       * Retorna o estoque maximo de um produto informado
       * @param idcod Codigo do produto
       * @return Estoque maximo
       */
      public int getEstoqueMaximo(int idcod)
      {
	 return esp.getEstoqueMaximo(idcod);
      }

      public void destrutor() throws Throwable
      {
	 forn.destrutor();
	 esp.destrutor();
	 this.finalize();
      }
}
