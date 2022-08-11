package Controladoras;

import CamadaNegocios.Venda;
import CamadaNegocios.Devolucao;
import java.util.Vector;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class CtrDevolverProduto
{
   private Devolucao dev;
   private Venda vd;

   public CtrDevolverProduto()
   {
      dev = new Devolucao();
      vd = new Venda();
   }

   public Vector preencherNota()
   {
      return dev.getVendaAberto();
  }

  public Vector selecionarNota(int idnota)
  {
//     return vd.getProdutosVenda(idnota, "< curdate()");
     return vd.getProdutosVenda(idnota);
  }

  public Vector selecionarProduto(int idpro,int idVenda)
  {
     return vd.getValidadeVenda(idpro,idVenda);
  }

  public Vector selecionarValidade(String data,int idVenda, int idpro)
  {
     return vd.getQuantidadeVenda(data, idVenda,idpro);
  }


  public void devolver(int idpro, int qtd, String val, double preco)
  {
     dev.devolver(idpro, qtd, val, preco);
  }
}
