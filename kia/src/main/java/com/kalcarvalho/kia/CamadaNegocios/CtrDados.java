package CamadaNegocios;

import CamadaDados.*;

public class CtrDados {

  private String bd = "mysql";

  /**
   * declarar esse objeto como estático permite que apenas uma cópia desse objeto
   * seja instanciada permitindo o uso do construtor com parametro conforme
   * explicado abaixo
   */
  protected static CamadaDados cmd;

  public CtrDados() {}

  /**
   * esse construtor é chamado uma única vez ao se iniciar o sistema, assim um único
   * objeto de conexão é instaciado
   * @param x String serve apenas como um diferencial do construtor padrão porque
   * as classes da camada de negócios são subclasses desta classe, e toda vez que são
   * instanciadas implicitamente o construtor padrão pai CtrDados(){} é chamado,
   * e esse construtor com o parâmetro String mantém o único objeto instanciado cmd.
   * se não fosse criado esse construtor, todas as vezes que um objeto da camada de
   * negócios fosse instanciado, consequentemente um novo objeto cmd seria também instanciado,
   * com essa solução mantemos a consistência dos dados, gerenciamos melhor a memória,
   * e usamos apenas um objeto cmd, que é o nosso interesse
   */
  public CtrDados(String x) {
    cmd = new CamadaDados();
    cmd.criarInstancia(bd);
    cmd.getUserPassword("AIK", "FVB");
    cmd.especificarBD(
      "jdbc:mysql://127.0.0.1/Distribuidora?user=AIK&password=FVB"
    );
    cmd.prepararSQL();
  }

  public String getBd() {
    return bd;
  }
}
