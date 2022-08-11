package Controladoras;

import java.util.Vector;
import CamadaNegocios.*;
import CamadaApresentacao.frLogMaquina;

public class CtrLog
{
   private Logger log;
   private frLogMaquina fl;

   public CtrLog()
   {
      log = new Logger();
      this.logMaquina();
   }

   public Vector gerarRelatorioLog()
   {
      return log.gerarRelatorioLog();
   }

   public void logMaquina()
   {
      Vector tmp=new Vector();
      tmp=log.identificarPc();
      fl=new frLogMaquina(tmp);
   }
}
