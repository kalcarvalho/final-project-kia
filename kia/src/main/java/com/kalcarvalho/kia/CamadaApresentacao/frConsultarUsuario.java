package CamadaApresentacao;

import java.awt.event.*;

public class frConsultarUsuario extends frAlterarUsuario {

  public frConsultarUsuario() {
    try {
      jbInit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  void jBtSair_actionPerformed(ActionEvent e) {
    try {
      this.finalize();
      super.finalize();
      this.setVisible(false);
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    this.setTitle("Consultar Usuário");
    btAlterar.setBounds(1, 1, 1, 1);
    btLimpar.setBounds(1, 1, 1, 1);
    tfLogin.setEditable(false);
    tfSenha.setEditable(false);
    tfNome.setEditable(false);
    tfTipo.setEditable(false);
  }
}
