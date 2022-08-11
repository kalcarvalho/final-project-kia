package CamadaApresentacao;

import java.awt.event.*;

public class frConsultarCliente extends frAlterarCliente
{
   public frConsultarCliente()
   {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
   }
  private void jbInit() throws Exception
  {
    this.setTitle("Consultar Cliente");
    btAlterar.setBounds(1,1,1,1);
    btLimpar.setBounds(1,1,1,1);
    tfCNPJ.setEditable(false);
    tfRazaoSocial.setEditable(false);
    tfInscEstadual.setEditable(false);
    tfNomeFantasia.setEditable(false);
    tfEndereco.setEditable(false);
    tfBairro.setEditable(false);
    tfCidade.setEditable(false);
    TFcep.setEditable(false);
    tfNumero.setEditable(false);
    tfEmail.setEditable(false);
    tfEstado.setEditable(false);
    tfTelefone.setEditable(false);
    tfFax.setEditable(false);
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
}
