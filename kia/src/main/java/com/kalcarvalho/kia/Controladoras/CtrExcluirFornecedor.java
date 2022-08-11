package Controladoras;

import CamadaNegocios.Fornecedor;
import javax.swing.JOptionPane;
import java.util.Vector;

public class CtrExcluirFornecedor
{
   private Fornecedor forn;

  public CtrExcluirFornecedor()
  {
     forn = new Fornecedor();
  }

  public Vector preencherForn()
  {
     return forn.getFornecedor();
  }

  public void selecionarFornecedor(String str)
  {
     String cnpj= forn.getFornecedor(str);
     forn.removerFornecedor(cnpj);
  }

  public void destrutor() throws Throwable
    {
       forn.destrutor();
       this.finalize();
    }

}
