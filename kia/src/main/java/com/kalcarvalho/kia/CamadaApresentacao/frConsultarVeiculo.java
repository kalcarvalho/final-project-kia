package CamadaApresentacao;

import java.awt.event.*;

public class frConsultarVeiculo extends frAlterarVeiculo {

  public frConsultarVeiculo() {
    try {
      jbInit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void jBtSair_actionPerformed(ActionEvent e) {
    try {
      this.finalize();
      super.finalize();
      this.setVisible(false);
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    this.setTitle("Consultar Veículo");
    btAlterar.setBounds(1, 1, 1, 1);
    jbLimpar.setBounds(1, 1, 1, 1);
    tfTara.setEditable(false);
    tfCapacidade.setEditable(false);
    tfConsumoMedio.setEditable(false);
    tfCor.setEditable(false);
    tfAno.setEditable(false);
    tfTipo.setEditable(false);
    tfRefrigeracao.setEditable(false);
  }
}
