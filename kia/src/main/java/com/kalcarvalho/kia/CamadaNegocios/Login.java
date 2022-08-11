package CamadaNegocios;

import javax.swing.JOptionPane;

public class Login
{
   private Usuario usu;

  public Login()
  {
     usu = new Usuario();
  }

  public String logar(String login,char[] senha)
  {
     return usu.validarUsuario(login,senha);
  }
}