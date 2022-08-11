package Controladoras;

import CamadaNegocios.ContasaReceber;
import java.util.Vector;

public class CtrRemoverCondPag
{
   private ContasaReceber cr;

   public CtrRemoverCondPag()
   {
      cr=new ContasaReceber();
   }

   public Vector selecioneCb()
   {
      return cr.getFormaPagto();
   }

   public void RemoverCondPag(String cond)
   {
      cr.removerCondPag(cond);
   }

   public void destrutor() throws Throwable
   {
      this.finalize();
   }
}
