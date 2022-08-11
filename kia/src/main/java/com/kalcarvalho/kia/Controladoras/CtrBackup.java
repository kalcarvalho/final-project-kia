package Controladoras;

import CamadaNegocios.Backup;
import java.util.Vector;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.IOException;

public class CtrBackup
{
   private Backup bck;
   private boolean status;
   private String dir;

   public CtrBackup()
   {
      bck=new Backup();
   }

   public Vector getOpcaoBackup()
   {
      return bck.getOpcaoBackup();
   }

   public void setOPcaoBackup(Vector op)
   {
      bck.setOpcaoBackup(op);
   }

   public void copiar()
   {
      bck.copiar();
   }


   public void configurar(String origem,String destino)
   {
      Vector dir=new Vector();
      if (bck.validarDir(origem,destino) && ! origem.equals("") && !
	  destino.equals(""))
      {
	 dir=bck.formatarDir(origem,destino);
	 bck.removerOpcaoBackup();
	 bck.inserirOpcaoBackup(dir);
	 JOptionPane.showMessageDialog(null,"Backup Configurado com Sucesso",
				       "Configuração de Backup",
				       JOptionPane.INFORMATION_MESSAGE);
      }
      else return;
   }

   public String getOrigem()
   {
      return bck.getOrigem();
   }

   public String getDestino()
   {
      return bck.getDestino();
   }

}
