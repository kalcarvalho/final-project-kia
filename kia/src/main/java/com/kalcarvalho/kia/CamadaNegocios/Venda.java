package CamadaNegocios;

import java.util.*;
import java.sql.SQLException;
import java.lang.*;

public class Venda extends CtrDados
{
   protected int cod;
   private Date data;
   private Date datavencimento;
   private boolean status;
   private double total;
   protected ItensVenda iv;
   private Estoque est;
   private ContasaReceber conta;

   public Venda()
   {
      iv = new ItensVenda();
      est = new Estoque();
      conta = new ContasaReceber();
      total = 0;
      status = true;
   }

   public double total(int qtd, double prec)
   {
      return total+=iv.subtotal(qtd, prec);
   }


   public double construirLinhaItem(int idpro,
			    String vali,int qtd,double prec,String data)
   {
      if (status)
      {
	 cmd.chamarSQL("INSERT INTO VENDA VALUES(NULL,'" + data + "',curtime(),0,0)");
	 cmd.inserirSQL();
	 this.validaMaxIdVenda();
      }
      status = false;
      iv.criar(cod,idpro,vali,qtd,prec);
      return this.total(qtd,prec);
   }

   public void finalizar(String venc, String data, String nota, String idCliente)
   {
      cmd.chamarSQL("UPDATE Venda SET data='"+data+"',"+
		    "idCliente='"+idCliente+"' WHERE idVenda="+cod);
      cmd.inserirSQL();
     conta.gravar(cod, venc, total);
   }

   public void cancelar(int idv)
   {
      Vector itens;
      cod = idv;
      cmd.chamarSQL("DELETE FROM VENDA WHERE idVenda="+cod+"");
      cmd.inserirSQL();
      itens = iv.cancelar(Integer.toString(cod));
      itens.trimToSize();
      est.inserirEstoque(
	  Integer.parseInt((String) itens.get(0)),
	  Double.parseDouble((String) itens.get(1)),
	  (String) itens.get(2));
      conta.cancelar(cod);
   }

   public void cancelar(Vector e)
   {
      cmd.chamarSQL("DELETE FROM Venda WHERE idVenda='"+cod+"'");
      cmd.inserirSQL();
      est.acrescentarEstoque(e);
      iv.cancelar(cod);
   }

   public void validaMaxIdVenda()
   {
      cmd.chamarSQL("SELECT MAX(idVenda) FROM VENDA");
      cod = cmd.getInt(cmd.executarSQL());
   }

   public int getMaxIdVenda()
   {
      return cod;
   }

   public Vector getNumVenda()
   {
      //cmd.chamarSQL("SELECT MAX(idVenda) FROM Venda, ContasaReceber " +
	//	    "WHERE Aberto=0 AND Venda.idVenda=ContasaReceber.idConta");
      return cmd.getArrayRegistros(cmd.executarSQL());
   }

   public Vector getValidade(int idcod, String str)
   {
      return est.getValidade(idcod, str);
   }

   public int getEstoquePorValidade(int idcod, String str)
   {
      return est.getEstoquePorValidade(idcod, str);
   }

   public int getEstoque(int idcod)
   {
      return est.getEstoque(idcod);
   }

   public Vector getProdutosVenda(int idvenda)
   {
      return iv.getProdutosVenda(idvenda);
   }

   public Vector getValidadeVenda(int idpro, int idVenda)
   {
      return iv.getValidadeVenda(idpro,idVenda);
   }

   public Vector getQuantidadeVenda(String data,int idVenda, int idpro)
   {
      return iv.getQuantidadeVenda(data, idVenda, idpro);
   }

   public Vector getDadosVenda(int idvenda)
   {
      Vector tmp = new Vector();
      try
      {
	 cmd.chamarSQL(
		    "SELECT razaoSocial, data, valor FROM Cliente, Venda, ContasaReceber, ContaVenda WHERE ContaVenda.idVenda=Venda.idVenda AND ContaVenda.idConta=ContasaReceber.idConta AND  cnpj=idCliente AND Venda.idVenda=" + idvenda );
	 tmp = cmd.getFromRegistros(cmd.executarSQL(),3);
	 if(tmp == null) return new Vector();
      }
      catch(Exception ex)
      {
	 ex.printStackTrace();
	 return new Vector();
      }
      return tmp;
   }

   public Vector getVendaAberto()
   {
      Vector tmp = new Vector();
      cmd.chamarSQL("SELECT idVenda FROM Venda WHERE StatusRota=0 ORDER BY idVenda");
      tmp = cmd.getArrayRegistros(cmd.executarSQL());
      if (tmp == null)
      {
	 return new Vector();
      }
      return tmp;
   }
   public void devolver(int idpro, int qtd, String vali, double preco)
   {
      double t = iv.devolverItens(idpro, qtd, preco, vali ,cod);

      conta.gravar(cod,"curdate()",t);
   }
}
