package CamadaNegocios;

import javax.swing.JOptionPane;
import java.util.Vector;
import CamadaNegocios.Fornecedor;

public class Produto extends CtrDados
{
   private Estoque est;
   private Vector descricao;
   private int codprod;
   private double precocusto;
   private double precovenda;
   private int minimo;
   private int maximo;
   private String descr;
   private String codProduto;
   private String refrigeracao;
   private String unidade;
   private String apresentacao;
   private double estMinimo;
   private double estMaximo;

   public Produto()
   {
      est = new Estoque();
   }

   /**
    * seleciona a descrição de todos produtos de um determinado fornecedor
    * @param str razaosocial de Fornecedor
    * @return um Vector com todos produtos do fornecedor x
    */
   public Vector getProduto(String str)
   {
      String id=str;
      Vector campo = new Vector();
      campo.addElement("descricao");
      cmd.selecionar(campo,"(Produto INNER JOIN CT ON Produto.idProduto="+
		     "CT.idProduto) INNER JOIN Fornecedor ON CT.idFornecedor="+
		     "Fornecedor.cnpj","cnpj='"+id+"'");
      descricao=cmd.getArrayRegistros(cmd.executarSQL());
      if (descricao == null)
      {
	 JOptionPane.showMessageDialog(null, "Não existem Produtos cadastrados.");
      }
      return descricao;
   }

   public int getProd(String des, String cnp)
  {
      Vector pro = new Vector();
      pro.addElement("Produto.idProduto");
      cmd.selecionar(pro,"(Produto INNER JOIN CT ON Produto.idProduto="+
      "CT.idProduto) INNER JOIN Fornecedor ON CT.idFornecedor=Fornecedor.cnpj",
      "Descricao='"+des+"'"+" AND cnpj='"+cnp+"'");
      codprod=cmd.getInt(cmd.executarSQL());
      return codprod;
   }

   public double getPrecoCusto(int idcod)
   {
      int id=idcod;
      Vector campo=new Vector();
      campo.addElement("precoCusto");
      cmd.selecionar(campo,"Produto","idProduto='"+id+"'");
      precocusto=cmd.getDouble(cmd.executarSQL());
      return precocusto;
   }

   public String getUnidade(int idcod)
   {
      String un= new String();
      Vector campo=new Vector();
      campo.addElement("unidade");
      cmd.selecionar(campo,"Produto","idProduto='"+idcod+"'");
      un=cmd.getRegistros(cmd.executarSQL());
      return un;
   }

   public int cadastrar(String descricao,String codProd,String refrig,
			   String unidade,String apres,double estMin,
			   double estMax,double pCusto,double pVenda)
   {
      Vector campo=new Vector();
      precocusto=pCusto;
      precovenda=pVenda;
      descr=descricao;
      codProduto=codProd;
      refrigeracao=refrig;
      this.unidade=unidade;
      apresentacao=apres;
      estMinimo=estMin;
      estMaximo=estMax;
      campo.addElement("");
      campo.addElement(String.valueOf(precocusto));
      campo.addElement(String.valueOf(precovenda));
      campo.addElement(descr);
      campo.addElement(codProduto);
      campo.addElement(refrigeracao);
      campo.addElement(this.unidade);
      campo.addElement(apresentacao);
      campo.addElement(String.valueOf(estMinimo));
      campo.addElement(String.valueOf(estMaximo));
      cmd.inserir(campo,"Produto");
      //o Max deve ser maísculo
      Logger.registrar("MAX(idProduto)","Produto","Inserção");
      return this.getIdProduto();
   }

    public int getIdProduto()
    {
       Vector campo=new Vector();
       campo.addElement("MAX(idProduto)");
       cmd.selecionar(campo,"Produto");
       return cmd.getInt(cmd.executarSQL());
    }

    /**
     * seleciona todos os produtos cadastrados
     * @return Vector de descriçao de produto
     */
    public Vector getProdutos ()
   {
      Vector campo=new Vector();
      campo.addElement("Descricao");
      cmd.selecionar(campo,"Produto ORDER BY Descricao");
      descricao=cmd.getArrayRegistros(cmd.executarSQL());
      if (descricao == null)
      {
	 JOptionPane.showMessageDialog(null, "Não existem Produtos Cadastrados.");
      }
      return descricao;
   }

   /**
    * método que retorna todos os dados de um produto especifico
    * @param des descriçao de produto
    * @return Vector com todos os campos de produto
    */
   public Vector getDadosProduto(String des)
     {
	cmd.selecionar("Produto","Descricao='"+des+"'");
	//o 2º parametro é o numero de campos na tabela
	descricao=cmd.getFromRegistros(cmd.executarSQL(),10);
	if (descricao == null)
	{
	   JOptionPane.showMessageDialog
	       (null, "Não existem Produtos Cadastrados.");
	 }
	 return descricao;
      }

   public void alterar(String descricao,String codProd,String ref,String un,
		    String apres,double estmin,double estmax,double pCusto,
		    double pVenda,String idProduto)
   {
      Vector sets=new Vector();
      sets.addElement("precoCusto='"+pCusto+"'");
      sets.addElement("precoVenda='"+pVenda+"'");
      sets.addElement("codProduto='"+codProd+"'");
      sets.addElement("refrigeracao='"+ref+"'");
      sets.addElement("unidade='"+un+"'");
      sets.addElement("apresentacao='"+apres+"'");
      sets.addElement("estMinimo='"+estmin+"'");
      sets.addElement("estMaximo='"+estmax+"'");
      cmd.atualizar("Produto",sets,"idProduto='"+idProduto+"'");
      Logger.registrar(idProduto,"Produto","Alteração");
   }

   public void removerProduto(int id)
   {
      cmd.remover("Produto","idProduto="+id);
      Logger.registrar(String.valueOf(id),"Produto","Remoção");
   }

   public int getIdProduto(String str)
   {
      String descricao=str;
      Vector campo=new Vector();
      campo.addElement("idProduto");
      cmd.selecionar(campo,"Produto","descricao='"+descricao+"'");
      codprod=cmd.getInt(cmd.executarSQL());
      return codprod;
   }

   public Vector getProduto(int min)
   {
      cmd.chamarSQL(
	  "SELECT DISTINCT Descricao "+
	  "FROM Produto, Estoque "+
	  "WHERE Estoque.idProduto=Produto.idProduto "+
	  "AND Quantidade > "+min
      );
      descricao = cmd.getFromRegistros(cmd.executarSQL(),1);
      descricao.trimToSize();
      if(descricao.capacity() == 0) return new Vector();
      return descricao;
   }

   public int getEstoqueMinimo(int idcod)
   {
      cmd.chamarSQL("SELECT estMinimo from Produto WHERE idProduto="+ idcod);
      minimo = cmd.getInt(cmd.executarSQL());
      return minimo;
   }
   public int getEstoqueMaximo(int idcod)
   {
      cmd.chamarSQL("SELECT estMaximo from Produto WHERE idProduto="+ idcod);
      maximo = cmd.getInt(cmd.executarSQL());
      return maximo;
   }

   public int getProd(String str)
   {
      cmd.chamarSQL("SELECT idProduto FROM Produto WHERE Descricao='"+ str + "'");
      return cmd.getInt(cmd.executarSQL());
    }

    public void cadastrarIDEstoque(int idProd)
    {
       est.cadastrarID(idProd);
    }

   public void destrutor() throws Throwable
  {
     this.finalize();
  }
}
