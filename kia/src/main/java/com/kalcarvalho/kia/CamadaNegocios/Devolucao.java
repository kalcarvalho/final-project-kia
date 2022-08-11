package CamadaNegocios;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Devolucao extends Venda
{
   private int codev;
   private ContasaPagar conta;

   public Devolucao()
   {
      conta = new ContasaPagar();
   }

   public void getIdDevolucao()
  {
     cmd.chamarSQL("INSERT INTO ContaDevolucao SET idConta=0, idVenda=0");
     cmd.inserirSQL();
     cmd.chamarSQL("SELECT MAX(idDevolucao) FROM ContaDevolucao");
     codev = cmd.getInt(cmd.executarSQL());
  }

   public void devolver(int idpro, int qtd, String vali, double preco)
   {
      double t = iv.devolverItens(idpro, qtd, preco, vali ,cod);
      this.getIdDevolucao();
      conta.gravarDevolucao(codev, cod, t);
   }
}
