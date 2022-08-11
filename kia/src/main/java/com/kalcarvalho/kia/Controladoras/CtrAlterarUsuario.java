package Controladoras;

import CamadaNegocios.Usuario;
import java.util.Vector;
import javax.swing.JOptionPane;

public class CtrAlterarUsuario {

  private Usuario usu;

  public CtrAlterarUsuario() {
    usu = new Usuario();
  }

  public Vector preencherMat() {
    return usu.getMatrs();
  }

  /**
   * botão comboBox, seleciona um usario e preenche a tela com seus dados
   * @param mat
   * @return Vector com os dados do usuario mat
   */
  public Vector selecionarMat(String mat) {
    return usu.getUsuario(mat);
  }

  public void alterar(
    String mat,
    String nome,
    String lg,
    String sh,
    String tip
  ) {
    usu.alterar(mat, nome, lg, sh, tip);
  }

  public void destrutor() throws Throwable {
    usu.destrutor();
    this.finalize();
  }
}
