package Controladoras;

import CamadaNegocios.Compra;
import java.util.*;

public class CtrExcluirCompra
{
   private Compra cp;

  public CtrExcluirCompra()
  {
     cp = new Compra();
  }

  public Vector preencherNota()
  {
     return cp.getCompraAberto(); //vnd.getcompraAberto();
  }

  public Vector selecionarNota(int idcompra)
  {
     return cp.getDadosCompra(idcompra); //vnd.getDadoscompra(idcompra);
  }

  public void excluir(int idcompra)
  {
     cp.cancelar(idcompra); //.cancelar(idcompra);
  }
}
