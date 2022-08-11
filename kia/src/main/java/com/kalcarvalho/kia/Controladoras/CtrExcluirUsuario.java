package Controladoras;

import javax.swing.JOptionPane;
import java.util.Vector;
import CamadaNegocios.Usuario;

public class CtrExcluirUsuario
{
   private Usuario usu;

  public CtrExcluirUsuario()
  {
     usu=new Usuario();
  }

  public Vector preencherMat()
   {
      return usu.getMatrs();
   }

   public void selecionarMat(String mat)
   {
      usu.removerUsuario(mat);
   }

   public void destrutor() throws Throwable
     {
	usu.destrutor();
	this.finalize();
     }

}
