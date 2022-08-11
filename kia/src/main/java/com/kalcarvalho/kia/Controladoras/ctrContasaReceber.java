package Controladoras;

import CamadaNegocios.ContasaReceber;
import CamadaNegocios.Cliente;
import javax.swing.JOptionPane;
import java.util.Vector;

public class ctrContasaReceber
{
   private ContasaReceber car;
   private Cliente cli;

   public ctrContasaReceber()
   {
      car = new ContasaReceber();
      cli = new Cliente();
   }

   public Vector preencherContasaReceber()
   {
      return car.preencherContasaReceber();
   }

   public Vector selecionarConta(String idVenda)
  {
     Vector tmp = car.selecionarConta(idVenda);
       String idCli=(String)tmp.get(0);
       String rz=cli.getRazaoSocial(idCli);
       tmp.setElementAt(rz,0);
       tmp.trimToSize();
       return tmp;
  }

  public void liquidar(String idVenda,String tipo)
  {
     car.liquidar(idVenda,tipo);
  }

  public Vector getFormaPagto()
  {
     return car.getFormaPagto();
  }

  public void destrutor() throws Throwable
    {
       car.destrutor();
       cli.destrutor();
       this.finalize();
    }
}
