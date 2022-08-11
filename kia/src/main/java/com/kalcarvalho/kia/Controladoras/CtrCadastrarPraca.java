package Controladoras;

import CamadaNegocios.Endereco;
import java.util.Vector;

public class CtrCadastrarPraca
{
   private Endereco end;

   public CtrCadastrarPraca()
   {
      end=new Endereco();
   }

   public Vector getCidades()
   {
      return end.getCidade();
   }

   public void setPraca(String praca,Vector cidade)
   {
      end.setPraca(praca,cidade);
   }

   public void destrutor() throws Throwable
     {
	end.destrutor();
	this.finalize();
     }
}
