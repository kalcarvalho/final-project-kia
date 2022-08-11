package CamadaNegocios;

import java.util.Vector;
import javax.swing.JOptionPane;

public class Usuario extends CtrDados {

  protected static Logger lg;
  private String matricula;
  private String nome;
  private String login;
  private String senha;
  private String tipo;

  public Usuario() {
    lg = new Logger();
  }

  public void cadastrar(
    String mat,
    String nom,
    String login,
    String sen,
    String tip
  ) {
    Vector campo = new Vector();
    campo.addElement(mat);
    campo.addElement(nom);
    campo.addElement(login);
    campo.addElement(sen);
    campo.addElement(tip);
    cmd.inserir(campo, "Usuario");
    lg.registrar(mat, "Usuario", "Inserção");
  }

  public Vector getMatrs() {
    Vector mat;
    Vector campo = new Vector();
    campo.addElement("Matricula");
    cmd.selecionar(campo, "Usuario");
    mat = cmd.getArrayRegistros(cmd.executarSQL());
    if (mat == null) {
      JOptionPane.showMessageDialog(null, "Não Existem Usuários Cadastrados.");
    }
    return mat;
  }

  public Vector getUsuario(String mat) {
    Vector mats;
    cmd.selecionar("Usuario", "Matricula='" + mat + "'");
    mats = cmd.getFromRegistros(cmd.executarSQL(), 5);
    if (mats == null) {
      JOptionPane.showMessageDialog(null, "Não existem Usuários Cadastrados.");
    }
    return mats;
  }

  public void alterar(
    String mat,
    String nome,
    String log,
    String sh,
    String tip
  ) {
    Vector sets = new Vector();
    sets.addElement("nome='" + nome + "'");
    sets.addElement("login='" + log + "'");
    sets.addElement("senha='" + sh + "'");
    sets.addElement("tipo='" + tip + "'");
    cmd.atualizar("Usuario", sets, "matricula='" + mat + "'");
    lg.registrar(mat, "Usuario", "Alteração");
  }

  public void removerUsuario(String mat) {
    cmd.remover("Usuario", "matricula='" + mat + "'");
    lg.registrar(mat, "Usuario", "Remoção");
  }

  public String validarUsuario(String login, char s[]) {
    this.senha = String.copyValueOf(s);
    this.login = login;
    Vector campo = new Vector();
    campo.addElement("Tipo");
    campo.addElement("Matricula");
    cmd.selecionar(
      campo,
      "Usuario",
      "login='" + this.login + "' AND senha='" + this.senha + "'"
    );
    campo.removeAllElements();
    campo = cmd.getFromRegistros(cmd.executarSQL(), 2);
    try {
      tipo = (String) campo.get(0);
      matricula = (String) campo.get(1); //para o log
    } catch (ArrayIndexOutOfBoundsException ex) {
      return "";
    }
    lg.setMat(matricula);
    return tipo;
  }

  public void destrutor() throws Throwable {
    this.finalize();
  }
}
