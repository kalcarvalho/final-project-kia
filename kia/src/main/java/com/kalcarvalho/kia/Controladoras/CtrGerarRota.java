package Controladoras;

import CamadaNegocios.Rota;
import CamadaNegocios.Cliente;
import java.util.Vector;
import javax.swing.JOptionPane;
import CamadaApresentacao.frDetalhesRota;

public class CtrGerarRota
{
   private Rota ro;
   private Cliente cl;
   private frDetalhesRota fdr;
   public CtrGerarRota()
   {
      ro=new Rota();
      cl=new Cliente();
   }

   public Vector selecionarPracas()
   {
      Vector praca=new Vector();
      praca=cl.getPracas();
      praca.removeElement("");
      praca.removeElement(null);
      praca.insertElementAt("Todas",0);
      return praca;
   }

   public Vector selecionarVenda(String praca)
   {
      return cl.getVendaAberto(praca);
   }

   /**
    * método para gerar a rota
    * @param roteador Vector posicao 0 Vector de IdEnd, posicao 1 Vector de rua da tabela
    * Endereco e posicao 2 Vector com as ruas que foram tiradas manualmente, esse Vector
    * é so pra informar ao usuario que as ruas não estao entrando na rota
    */
   public void gerarRota(Vector roteador)
   {
      Vector newRota=new Vector();
      Vector VidEnd=new Vector();
      Vector foraRota=new Vector();
      Vector rua=new Vector();
      VidEnd=(Vector)roteador.get(0);
      rua=(Vector)roteador.get(1);
      foraRota=(Vector)roteador.get(2);
      if (! foraRota.isEmpty())
	 JOptionPane.showMessageDialog(null,"Não estão entrando na rota os seguintes "+
			      "endereços retirados manualmente: "+
			      roteador.get(2),"Exclusão da rota",
			      JOptionPane.WARNING_MESSAGE);

      newRota=ro.selecionarRota(VidEnd,rua);
      if (newRota.isEmpty())
	 JOptionPane.showMessageDialog(null
	  ,"Não há rota dadastrada nessses endereços","Rota",
	  JOptionPane.INFORMATION_MESSAGE);
      else ro.gerarRota(newRota);
   }

   /**
    * Este Método busca dados do cliente como cnpj, razaosocial e seu endereço
    * rua, numero, bairro... e mostra num JTable gerado dinamicamente
    * @param idEnd Vector
    */

   public void exibirDetalhes(Vector idEnd)
   {
      Vector tmp=new Vector();
      tmp=cl.exibirDetalhes(idEnd);
      System.out.print(tmp);
      //chama classe frDetalahesRota que herda de TemplateRelatório
      fdr=new frDetalhesRota(tmp);

   }

   public void destrutor() throws Throwable
  {
     ro.destrutor();
     cl.destrutor();
     this.finalize();
  }
}
