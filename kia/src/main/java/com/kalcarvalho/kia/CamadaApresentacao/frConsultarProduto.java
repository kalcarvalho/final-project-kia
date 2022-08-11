package CamadaApresentacao;

import java.awt.event.*;

public class frConsultarProduto extends frAlterarProduto
{
   public frConsultarProduto()
   {
      try {
        jbInit();
      }
      catch(Exception e) {
        e.printStackTrace();
      }
   }

   void jBtSair_actionPerformed(ActionEvent e)
  {
      try
      {
	 this.finalize();
	 super.finalize();
	 this.setVisible(false);
      }
      catch (Throwable ex)
      {
	 ex.printStackTrace();
      }
  }
   private void jbInit() throws Exception
   {
     this.setTitle("Consultar Produto");
     btAlterar.setBounds(1,1,1,1);
     btLimpar.setBounds(1,1,1,1);
     tfCodProd.setEditable(false);
     tfRefr.setEditable(false);
     tfUnidade.setEditable(false);
     tfApresentacao.setEditable(false);
     tfEstoqueMinimo.setEditable(false);
     tfEstoqueMaximo.setEditable(false);
     tfPCusto.setEditable(false);
     tfPVenda.setEditable(false);
   }
}
