package Controladoras;

import CamadaNegocios.Login;
import CamadaNegocios.Principal;

public class CtrLogin
{
   private Login lg;

  public CtrLogin()
  {
     lg = new Login();
  }

  public String logar(String login,char senha[])
  {
     return lg.logar(login,senha);
  }

  public void sair()
  {
     Principal.dist.sair();
  }
}
