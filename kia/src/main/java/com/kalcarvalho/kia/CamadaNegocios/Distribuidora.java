package CamadaNegocios;

import CamadaApresentacao.frLogin;
import CamadaNegocios.CtrDados;
import Controladoras.CtrBackup;
import java.io.*;

public class Distribuidora extends CtrDados
{

   private int idd;
   private frLogin fl;
   private CtrDados cd;
   private CtrBackup cb;
//   private frDistribuidora ff;

//   public static CtrDados cd;

	public Distribuidora()
	{
	  cd = new CtrDados("Distribuidora");
	  fl = new frLogin();
	}

	public static void sair()
	{
	   cmd.fecharConexao();
	   System.exit(0);
	}

	public void sair(boolean b)
	{
	   cmd.fecharConexao();
	   cb=new CtrBackup();
	    cb.copiar();
	   System.exit(0);
	}
}
