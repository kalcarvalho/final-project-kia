package Controladoras;

import javax.swing.JOptionPane;
import java.util.Vector;
import CamadaNegocios.Veiculo;

public class CtrExcluirVeiculo
{
   private Veiculo vei;

  public CtrExcluirVeiculo()
  {
     vei=new Veiculo();
  }

  public Vector preencherPlaca()
   {
      return vei.getPlacas();
   }

   public void selecionarPlaca(String placa)
   {
      vei.removerVeiculo(placa);
   }

   public void destrutor() throws Throwable
  {
     vei.destrutor();
     this.finalize();
  }

}
