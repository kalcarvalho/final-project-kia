package Controladoras;

import CamadaNegocios.Logger;
import CamadaNegocios.Relatorio;
import java.util.Vector;

public class CtrRelatorio
{

   private Logger log;
   private Relatorio rel;

   public CtrRelatorio()
   {
      log=new Logger();
      rel = new Relatorio();
   }

   public Vector gerarRelatorioLog()
   {
      return log.gerarRelatorioLog();
   }

   public void gerarRelatorioPreco()
   {
      rel.gerarRelatorioPreco();
   }

   public void gerarRelatorioEstoque()
   {
      rel.gerarRelatorioEstoque();
   }

   public void gerarRelatorioClientes()
   {
      rel.gerarRelatorioClientes();
   }

   public void gerarRelatorioFornecedor()
   {
      rel.gerarRelatorioFornecedor();
   }

   public void gerarRelatorioContasaPagar()
   {
      rel.gerarRelatorioContasaPagar();
   }

}
