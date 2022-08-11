package Controladoras;

import javax.swing.JOptionPane;
import java.util.Vector;
import CamadaNegocios.Veiculo;

public class CtrAlterarVeiculo
{
   private Veiculo ve;

  public CtrAlterarVeiculo()
  {
     ve = new Veiculo();
  }

  public Vector preencherPlaca()
  {
     return ve.getPlacas();
  }

  public Vector selecionarPlaca(String placa)
  {
     return ve.getVeiculo(placa);
  }

  public void alterar(String placa,double tara,double capac,double consmed,String cor,double ano,String tipo,String refr)
  {
   ve.alterar(placa,tara,capac,consmed,cor,ano,tipo,refr);
  }

  public void destrutor() throws Throwable
    {
       ve.destrutor();
       this.finalize();
    }

}
