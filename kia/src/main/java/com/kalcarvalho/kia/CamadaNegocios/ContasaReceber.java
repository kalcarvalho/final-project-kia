package CamadaNegocios;

import java.util.*;
import javax.swing.JOptionPane;

public class ContasaReceber extends CtrDados
{
   private int idconta;
   private String datavencimento;
   private double valorvenda;

   public ContasaReceber()
   {
   }

   public Vector preencherContasaReceber()
   {
	 Vector tmp = new Vector();
	 Vector campo=new Vector();
	 campo.addElement("Venda.idVenda");
	 cmd.selecionar(campo,"(Venda INNER JOIN Contavenda ON Venda.idVenda=Contavenda.idVenda) INNER JOIN ContasaReceber ON Contavenda.idConta=ContasaReceber.idConta","ContasaReceber.Aberto='false'");
	 tmp=cmd.getArrayRegistros(cmd.executarSQL());
	 if (tmp == null)
	 {
	    JOptionPane.showMessageDialog(
		null, "Não Existem Contas Cadastradas.");
	 }
	 return tmp;
    }

    public Vector selecionarConta(String id)
   {
      int idVenda=Integer.parseInt(id);
       Vector tmp;
       Vector campo=new Vector();
       campo.addElement("Venda.idCliente");
       campo.addElement("Venda.data");
       campo.addElement("ContasaReceber.vencimento");
       campo.addElement("ContasaReceber.valor");
       cmd.selecionar(campo,"(Venda INNER JOIN Contavenda ON Venda.idVenda=Contavenda.idVenda) INNER JOIN ContasaReceber ON Contavenda.idConta=ContasaReceber.idConta","Venda.idVenda="+idVenda);
       tmp=cmd.getFromRegistros(cmd.executarSQL(),4);
       if (tmp == null)
       {
	  JOptionPane.showMessageDialog
	      (null, "Não existem Vendas Cadastradas.");
	}
	return tmp;
   }

   public void liquidar(String idVe,String tipo)
  {
     int id=Integer.parseInt(idVe);
     Vector campo=new Vector();
     Vector valor=new Vector();
     campo.addElement("ContasaReceber.Aberto");
     valor.addElement("1");
     campo.addElement("ContasaReceber.Tipo");
     valor.addElement(tipo);
     cmd.atualizar("(Venda INNER JOIN Contavenda ON Venda.idVenda=Contavenda.idVenda) INNER JOIN ContasaReceber ON Contavenda.idConta=ContasaReceber.idConta",campo,valor,"Venda.idVenda="+id);
     Logger.registrar(idVe,"ContasaReceber","Atualização");
  }

  public void cadastrarFormaPagto(String cond)
  {
     Vector campo=new Vector();
     campo.addElement(cond);
     campo.addElement("");
     cmd.inserir(campo,"Pagto");
     Logger.registrar("MAX(id)","Pagto","Inserção");
  }

  public Vector getFormaPagto()
  {
     Vector tmp;
     Vector campo=new Vector();
     campo.addElement("DISTINCT Tipo");
     cmd.selecionar(campo,"Pagto");
     tmp=cmd.getArrayRegistros(cmd.executarSQL());
     if (tmp == null)
     {
	JOptionPane.showMessageDialog(
       null, "Não Há Formas de Pagamento Cadastradas.");
     }
     return tmp;
  }

  public void removerCondPag(String cond)
  {
   cmd.remover("Pagto","Tipo='"+cond+"'");
   Logger.registrar(cond,"Pagto","Remoção");
   }

   public void cancelar(int idv)
   {
      cmd.chamarSQL(
	  "SELECT ContasaReceber.idConta FROM ContasaReceber, ContaVenda WHERE ContaVenda.idConta=ContasaReceber.idConta AND idVenda=" + idv);
      idconta = Integer.parseInt((String)cmd.getFromRegistros(cmd.executarSQL(), 1).get(0));
      cmd.chamarSQL("DELETE FROM ContasaReceber WHERE idConta=" + idconta);
      cmd.inserirSQL();
      cmd.chamarSQL("DELETE FROM ContaVenda WHERE idConta=" + idconta);
      cmd.inserirSQL();
   }

   /**
       * Gravar Conta
       * @param idv int ID de Venda
       * @param v String Data de Vencimento
       * @param t double Total da Venda
       */
      public void gravar(int idv, String v, double t)
      {
	 datavencimento = v;
	 valorvenda = t;
	 cmd.chamarSQL("INSERT INTO ContasaReceber VALUES (NULL,'"
			     +datavencimento+"',"+valorvenda+",0,NULL)");
	 cmd.inserirSQL();
	 this.validaIdConta();
	 cmd.chamarSQL("INSERT INTO ContaVenda VALUES('"+idconta+"','"+idv+"')");
	 cmd.inserirSQL();
      }

      public void validaIdConta()
   {
      cmd.chamarSQL("SELECT MAX(idConta) FROM ContasaReceber");
      idconta = cmd.getInt(cmd.executarSQL());
   }


  public void destrutor() throws Throwable
  {
     this.finalize();
  }
}
