package Controladoras;

import javax.swing.JOptionPane;
import java.util.Vector;
import CamadaNegocios.Veiculo;

public class CtrCadastrarVeiculo
{
   private Veiculo ve;

  public CtrCadastrarVeiculo()
  {
     ve= new Veiculo();
  }

  public void cadastrar(String placa,double tara,double capac,double consmed,String cor,double ano,String tipo,String refr)
  {
     ve.cadastrar(placa,tara,capac,consmed,cor,ano,tipo,refr);
  }

  public void destrutor() throws Throwable
    {
       ve.destrutor();
       this.finalize();
    }
}
