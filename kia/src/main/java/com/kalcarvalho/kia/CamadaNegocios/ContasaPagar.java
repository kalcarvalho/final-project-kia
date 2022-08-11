package CamadaNegocios;

import java.util.*;
import javax.swing.JOptionPane;

public class ContasaPagar extends CtrDados
{
   protected int idconta;
   protected Date datavencimento;
   protected double valorcompra;
   private boolean status;

   public ContasaPagar()
   {
   }

   public void gravar(int cod)
   {
      Vector tmp=new Vector();
      Vector campo=new Vector();
      String cond="MAX(idConta)";
      tmp.addElement(cond);
      cmd.selecionar(tmp,"ContasaPagar");
      idconta = cmd.getInt(cmd.executarSQL());
      campo.addElement(String.valueOf(idconta));
      campo.addElement(String.valueOf(cod));
      cmd.inserir(campo,"ContaCompra");
   }


   public Vector preencherContasaPagar()
   {
	 Vector tmp;
	 Vector campo=new Vector();
	 campo.addElement("Compra.idCompra");
	 cmd.selecionar(campo,"(Compra INNER JOIN Contacompra ON Compra.idCompra=Contacompra.idCompra) INNER JOIN ContasaPagar ON Contacompra.idConta=ContasaPagar.idConta","ContasaPagar.status='false'");
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
      int idCompra=Integer.parseInt(id);
      Vector campo=new Vector();
       Vector tmp;
      campo.addElement("Compra.idFornecedor");
      campo.addElement("Compra.data");
      campo.addElement("ContasaPagar.vencimento");
      campo.addElement("ContasaPagar.valor");
      cmd.selecionar(campo,"(Compra INNER JOIN Contacompra ON Compra.idCompra=Contacompra.idCompra) INNER JOIN ContasaPagar ON Contacompra.idConta=ContasaPagar.idConta","Compra.idCompra="+idCompra);
      tmp=cmd.getFromRegistros(cmd.executarSQL(),4);
      if (tmp == null)
     {
	JOptionPane.showMessageDialog
	    (null, "Não existem Compras Cadastradas.");
      }
      System.out.println(tmp);
      return tmp;
   }

   public void pagar(String idcomp)
  {
     int id=Integer.parseInt(idcomp);
     Vector campo=new Vector();
     Vector valor=new Vector();
     campo.addElement("ContasaPagar.status");
     valor.addElement("1");
     cmd.atualizar("(Compra INNER JOIN Contacompra ON Compra.idCompra=Contacompra.idCompra) INNER JOIN ContasaPagar ON Contacompra.idConta=ContasaPagar.idConta",campo,valor,"Compra.idCompra="+id);
     Logger.registrar(idcomp,"ContasaPagar","Atualização");
  }

  public void cancelar(int cod)
     {
	idconta = cod;
	cmd.chamarSQL(
	    "SELECT ContasaPagar.idConta "+
	    "FROM ContasaPagar, ContaCompra "+
	    "WHERE ContaCompra.idConta=ContasaPagar.idConta "+
	    "AND idCompra=" + idconta
	);
	idconta = Integer.parseInt((String)cmd.getFromRegistros(cmd.executarSQL(), 1).get(0));

	cmd.chamarSQL("DELETE FROM ContasaPagar WHERE idConta=" + idconta);
	cmd.inserirSQL();

	cmd.chamarSQL("DELETE FROM ContaCompra WHERE idConta=" + idconta);
	cmd.inserirSQL();
     }

     public void gravarDevolucao(int cod, int idv)
      {
	 cmd.chamarSQL("SELECT MAX(idConta) FROM ContasaPagar");
	 idconta = cmd.getInt(cmd.executarSQL());
	 cmd.chamarSQL("UPDATE ContaDevolucao SET idConta="+idconta+", idVenda="+idv+" WHERE idDevolucao="+cod);
	 cmd.inserirSQL();
   }
   public void gravarDevolucao(int iddev, int idvenda, double t)
   {
      cmd.chamarSQL(
	  "INSERT INTO ContasaPagar"+
	  " SET idDevolucao="+iddev+
	  ", status=1"+
	  ", vencimento=curdate()"+
	  ", valor="+t );
      cmd.inserirSQL();

      this.gravarDevolucao(iddev, idvenda);
   }

  public void destrutor() throws Throwable
  {
     this.finalize();
  }
}
