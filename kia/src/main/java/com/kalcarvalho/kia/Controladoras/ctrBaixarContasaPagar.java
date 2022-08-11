package Controladoras;

import CamadaNegocios.Compra;
import CamadaNegocios.ContasaPagar;
import CamadaNegocios.Fornecedor;
import javax.swing.JOptionPane;
import java.util.Vector;

public class ctrBaixarContasaPagar
{
   private ContasaPagar cap;
   private Fornecedor forn;

   public ctrBaixarContasaPagar()
   {
      cap = new ContasaPagar();
      forn = new Fornecedor();
   }

   public Vector preencherContasaPagar()
   {
      return cap.preencherContasaPagar();
   }

   public Vector selecionarConta(String idCompra)
  {
     Vector tmp = cap.selecionarConta(idCompra);
     String idForn=(String)tmp.get(0);
     String rz=forn.getRazaoSocial(idForn);
     tmp.setElementAt(rz,0);
     tmp.trimToSize();
     return tmp;
  }

  public void pagar (String idCompra)
  {
     cap.pagar(idCompra);
  }

  public void destrutor() throws Throwable
    {
       cap.destrutor();
       forn.destrutor();
       this.finalize();
    }

}
