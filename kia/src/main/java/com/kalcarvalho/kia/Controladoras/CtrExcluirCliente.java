package Controladoras;

import CamadaNegocios.Cliente;
import javax.swing.JOptionPane;
import java.util.Vector;

public class CtrExcluirCliente
{
   private Cliente cli;

  public CtrExcluirCliente()
  {
     cli = new Cliente();
  }

  public Vector preencherCliente()
  {
     return cli.getCliente();
  }

  public void selecionarCliente(String str)
  {
     String cnpj= cli.getCliente(str);
     cli.removerCliente(cnpj);
  }

  public void destrutor() throws Throwable
    {
       cli.destrutor();
       this.finalize();
    }

}
