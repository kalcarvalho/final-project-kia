package Controladoras;

import CamadaNegocios.*;
import java.util.*;

public class CtrExcluirVenda
{
   private Venda vnd;

  public CtrExcluirVenda()
  {
     vnd = new Venda();
  }

  public Vector preencherNota()
  {
     return vnd.getVendaAberto();
  }

  public Vector selecionarNota(int idvenda)
  {
     return vnd.getDadosVenda(idvenda);
  }

  public void excluir(int idvenda)
  {
     vnd.cancelar(idvenda);
  }
}
