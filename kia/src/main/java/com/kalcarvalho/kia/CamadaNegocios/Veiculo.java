package CamadaNegocios;

import java.util.Vector;
import javax.swing.JOptionPane;
import java.util.*;

public class Veiculo extends CtrDados
{
  protected String placa;
  protected String refrigeracao;
  protected String tipo;
  protected String cor;
  protected double ano;
  protected double tara;
  protected double consumoMedio;
  protected double capacidade;

  public Veiculo()
  {
  }

  public Vector getPlacas()
  {
     Vector placas;
     Vector campo = new Vector();
     campo.addElement("placa");
     cmd.selecionar(campo,"Veiculo");
      placas=cmd.getArrayRegistros(cmd.executarSQL());
      if (placas == null)
      {
	 JOptionPane.showMessageDialog(
	     null, "Não Existem Veículos Cadastrados.");
      }
      return placas;
  }

  public void cadastrar(String placa,double tara,double capac,double consmed,
			String cor,double ano,String tipo,String refr)
  {
     Vector vei = new Vector();
     vei.addElement(placa);
     vei.addElement(String.valueOf(tara));
     vei.addElement(String.valueOf(capac));
     vei.addElement(String.valueOf(consmed));
     vei.addElement(cor);
     vei.addElement(String.valueOf(ano));
     vei.addElement(tipo);
     vei.addElement(refr);
     cmd.inserir(vei,"Veiculo");
     Logger.registrar(placa,"Veiculo","Inserção");
  }

  public Vector getVeiculo(String placa)
  {
     Vector tmp;
     cmd.selecionar("Veiculo","placa='"+placa+"'");
     tmp=cmd.getFromRegistros(cmd.executarSQL(),8);
     if (tmp == null)
     {
	JOptionPane.showMessageDialog
	    (null, "Não existem Veículos cadastrados.");
      }
      return tmp;
   }

   public void alterar(String placa,double tara,double capac,double consmed,
		       String cor,double ano,String tipo,String refr)
   {
      Vector campo = new Vector();
      Vector vei = new Vector();
      campo.addElement("tara");
      campo.addElement("capacidade");
      campo.addElement("ConsumoMedio");
      campo.addElement("cor");
      campo.addElement("ano");
      campo.addElement("tipo");
      campo.addElement("refrigeracao");
      vei.addElement(String.valueOf(tara));
      vei.addElement(String.valueOf(capac));
      vei.addElement(String.valueOf(consmed));
      vei.addElement(cor);
      vei.addElement(String.valueOf(ano));
      vei.addElement(tipo);
      vei.addElement(refr);
      cmd.atualizar("Veiculo",campo,vei,"placa='"+placa+"'");
      Logger.registrar(placa,"Veiculo","Alteração");
   }

   public void removerVeiculo(String placa)
   {
      cmd.remover("Veiculo","placa='"+placa+"'");
      Logger.registrar(placa,"Veiculo","Remoção");
   }

   public void destrutor() throws Throwable
  {
     this.finalize();
  }
}
