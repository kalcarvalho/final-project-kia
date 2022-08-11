package Controladoras;

import javax.swing.JOptionPane;
import java.util.Vector;
import CamadaNegocios.Usuario;

public class CtrCadastrarUsuario
{
  private Usuario usu;

  public CtrCadastrarUsuario()
  {
     usu= new Usuario();
  }

  public void cadastrar(String mat,String nom,String login,String sen,
			  String tip)
  {
    usu.cadastrar( mat, nom, login, sen, tip);
  }

  public void destrutor() throws Throwable
    {
       usu.destrutor();
       this.finalize();
    }

}
