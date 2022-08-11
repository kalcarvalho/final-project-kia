package Controladoras;

import CamadaNegocios.*;
import javax.swing.JOptionPane;
import java.util.Vector;

public class CtrCompra
{
  private static Compra cmp;
  private static ContasaPagar conta;
  private static CatalogoProduto ctp;
  private Data dt;

  public CtrCompra()
  {
     cmp = new Compra();
     ctp = new CatalogoProduto();
     conta = new ContasaPagar();
     dt = new Data();
  }

  public Vector preencherForn()
  {
     return ctp.selecionarFornecedor();
  }

  public Vector preencherProd(String str)
  {
     return ctp.selecionarProduto(str);
  }

  public String selecionarFornecedor(String str)
  {
     return ctp.selecionarFornecedor(str);
  }

  public int selecionarProduto(String str, String str2)
  {
     return ctp.selecionarProd(str,str2);
  }

  public double carregarPreco(int idcod)
  {
     return ctp.carregarPreco(idcod);
  }

  public boolean parseMySQL (String vali)
  {
    return dt.parseMySQL(vali);
  }

  public String getDataMysql()
  {
     return dt.getDataMysql();
  }

  public double entrarItem(String idFornecedor,String nota,int idpro,String vali,int qtd,double prec,String data)
  {
     return cmp.construirLinhaItem(idFornecedor,nota,idpro,dt.getDataMysql(),qtd,prec,data);
  }

  public void comprar(String venc, String data, String nota, String idFornecedor)
  {
     cmp.finalizar(venc, data, nota, idFornecedor);
  }

  public void cancelar(Vector est)
  {
     cmp.cancelar(est);
  }

  public String carregarUnidade(int idP)
  {
     return ctp.carregarUnidade(idP);
  }

  public void destrutor() throws Throwable
    {
       cmp.destrutor();
       ctp.destrutor();
       conta.destrutor();
       this.finalize();
    }
}
