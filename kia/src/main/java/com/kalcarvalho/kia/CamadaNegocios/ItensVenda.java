package CamadaNegocios;

import java.util.Vector;

public class ItensVenda extends CtrDados
{
   private double quantidade;
   private double preco;
   private Estoque est;

   public ItensVenda()
   {
      est = new Estoque();
   }

   public double subtotal()
    {
       return quantidade * preco;
    }

   public double subtotal(double quant,double preco)
   {
      quantidade = quant;
      this.preco = preco;
      return quantidade * preco;
   }

  public void criar(int idvenda, int idpro, String vali, double qtd, double prec)
  {
     cmd.chamarSQL(
       "INSERT INTO ItensVenda(Quantidade, idProduto, subtotal, validade, idVenda)VALUES("
       +qtd+","+idpro+","+this.subtotal(qtd,prec)+",'"+vali+"',"+idvenda+")");

     cmd.inserirSQL();
     est.retirarEstoque(idpro, qtd, vali);
  }

  public void cancelar(int cod)
  {
     cmd.chamarSQL("DELETE FROM ItensVenda WHERE idVenda="+cod);
     cmd.inserirSQL();
  }

  public Vector cancelar(String cod)
  {
     Vector vet = new Vector();
     cmd.chamarSQL("SELECT idProduto, Quantidade, validade FROM ItensVenda where idVenda="+cod);
     vet = cmd.getFromRegistros(cmd.executarSQL(), 3);
     this.cancelar(Integer.parseInt(cod));
     return vet;
  }

  public Vector getProdutosVenda(int idvenda)
  {
     Vector prod;
     cmd.chamarSQL(
	  "SELECT DISTINCT concat(Produto.idProduto, ' - ', descricao) "+
	  "FROM ItensVenda, Produto "+
	  "WHERE ItensVenda.idProduto=Produto.idProduto "+
	  "AND idVenda="+ idvenda);
     prod = cmd.getArrayRegistros(cmd.executarSQL());
     prod.trimToSize();
     if(prod.capacity() == 0)
     {
	 return null;
     }
     return prod;
  }

  public Vector getValidadeVenda(int p, int v)
  {
     Vector val;
     cmd.chamarSQL(
	  "SELECT validade "+
	  "FROM ItensVenda "+
	  "WHERE idProduto="+ p + " "+
	  "AND idVenda="+ v
    );
    val = cmd.getArrayRegistros(cmd.executarSQL());
    if(val.capacity() == 0) return new Vector();
    return val;
  }

  public Vector getQuantidadeVenda(String d, int v, int p)
  {
     cmd.chamarSQL("SELECT Quantidade, subtotal/Quantidade as Preco "+
		   "FROM ItensVenda "+
		   "WHERE idProduto="+ p + " "+
		   "AND idVenda="+ v + " "+
		   "AND validade='" + d + "'"
    );
    return cmd.getFromRegistros(cmd.executarSQL(), 2);
  }

  public double devolverItens(int idpro, int qtd, double prec, String d, int idv)
  {
     quantidade = qtd;
     preco = prec;
     cmd.chamarSQL(
	  "UPDATE ItensVenda"+
	  " SET Quantidade=Quantidade-"+qtd+","+
	  " subtotal=subtotal-("+qtd+" * (subtotal/(Quantidade+"+qtd+")))"+
	  " WHERE idProduto="+idpro+
	  " AND idVenda="+idv+
	  " AND validade='"+d+"'"
     );
     cmd.inserirSQL();

     cmd.chamarSQL(
	  "DELETE FROM ItensVenda"+
	  " WHERE idProduto="+idpro+
	  " AND idVenda="+idv+
	  " AND validade='"+d+"'"+
	  " AND quantidade < 1"
     );
     cmd.inserirSQL();

     return this.subtotal();

  }
}
