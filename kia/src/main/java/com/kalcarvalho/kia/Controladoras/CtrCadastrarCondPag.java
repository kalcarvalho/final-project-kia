package Controladoras;

import CamadaNegocios.ContasaReceber;

public class CtrCadastrarCondPag
{

   private ContasaReceber cr;

   public CtrCadastrarCondPag()
   {
      cr=new ContasaReceber();
   }

   public void cadastrar(String cond)
   {
      cr.cadastrarFormaPagto(cond);
   }

   public void destrutor() throws Throwable
  {
     this.finalize();
  }

}
