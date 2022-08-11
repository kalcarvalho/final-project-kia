package Controladoras;

import CamadaNegocios.Cliente;
import CamadaNegocios.Rota;
import java.util.Vector;
import javax.swing.*;

public class CtrCadastrarCliente {

  private Cliente cl;
  private Rota ro;

  public CtrCadastrarCliente() {
    cl = new Cliente();
  }

  public String novoEndereco(
    String rua,
    String bairro,
    String cidade,
    String estado,
    String cep,
    String numero,
    String Email,
    String cnpj
  ) {
    return cl.inserirEndereco(
      rua,
      bairro,
      cidade,
      estado,
      cep,
      numero,
      Email,
      cnpj
    );
  }

  public void novoTelefone(String t, String f, String cnpj) {
    cl.inserirTelefone(t, f, cnpj);
  }

  /**
   * método para inserir dados na tabela cliente.
   * atualiza a tabela endereço inserindo o idrota caso o endereço
   * já tenha rota cadastrada na tabela rota
   * Insere o nome da praça caso exista praça já cadastrada
   * @param cnp String
   * @param razaosoc String
   * @param inscest String
   * @param fant String
   * @param ends Vector
   * @param idEnds Vector
   * @param cid String
   */
  public void cadastrar(
    String cnp,
    String razaosoc,
    String inscest,
    String fant,
    Vector ends,
    Vector idEnds,
    String cid
  ) {
    Vector praca = new Vector();
    int ids[] = new int[ends.size()];
    cl.cadastrar(cnp, razaosoc, inscest, fant);
    for (int i = 0; i < ends.size(); i++) ids[i] =
      ro.getIdRota((String) ends.get(i), cid);
    for (int j = 0; j < ids.length; j++) cl.atualizar(
      ids[j],
      (String) idEnds.get(j)
    );
    praca = cl.selecionarPraca(cid);
    praca.remove(null);
    praca.remove("");
    if (praca.equals(null)) return; else for (
      int j = 0;
      j < ids.length;
      j++
    ) cl.atualizarPraca((String) praca.get(0), (String) idEnds.get(j));
  }

  /**
   * seelciona ruas da tabela rota para o combobox endereço. esta prática é valida,
   * para caso se já houver uma rota cadastrada neste endereço, configurá-la
   * @return Vector
   */
  public Vector selecionarRua() {
    ro = new Rota();
    return ro.getRua();
  }

  public void destrutor() throws Throwable {
    cl.destrutor();
    this.finalize();
  }
}
