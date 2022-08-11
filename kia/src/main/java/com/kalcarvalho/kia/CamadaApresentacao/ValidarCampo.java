package CamadaApresentacao;

import javax.swing.JOptionPane;

/**
 *
 * <p>Title: Validar Campo
 * <p>Description: Valida campos de entrada pelo usuário, verifica
 * se o campo é double, inteiro, nulo. Retorna mensagens informando o
 * erro e os campos a serem corrigidos.
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Andrade's
 * @author Ilson de Andrade
 * @version 1.0
 */
public class ValidarCampo {

  public ValidarCampo() {}

  /**
   * método para verificar se um campo é double, se não for double ou
   * for nulo exibe uma mensagem pedindo pra inserir o valor correto,
   * se o valor de entrada for negativo, uma mensagem enviada ao
   * usuario informando que o sistema vai desprezar o sinal negativo,
   * contudo o método ainda retorna o valor com o sinal negativo, deixando
   * para o banco de dados o trabalho de desprezar o sinal negativo
   * @param x String recebe o valor do textfield
   * @return double return o valor se ok, ou 0.0 se não
   */
  public boolean valDouble(String x) {
    double tmp;
    x.trim();
    for (int j = 0; j < x.length(); j++) for (int i = 0; i < 9; i++) if (
      x.substring(j).equals("-" + i)
    ) JOptionPane.showMessageDialog(
      null,
      "O Sistema Desprezará o Sinal Negativo",
      "Número Negativo",
      JOptionPane.ERROR_MESSAGE
    );

    try {
      tmp = Double.parseDouble(x);
    } catch (NumberFormatException ex) {
      ex.printStackTrace();
      JOptionPane.showMessageDialog(
        null,
        "Entre com um Número Inteiro ou Decimal",
        "Campo Inválido",
        JOptionPane.ERROR_MESSAGE
      );
      return false;
    }
    return true;
  }

  /**
   * método para verificar se um campo é double, se não for double ou
   * for nulo exibe uma mensagem pedindo pra inserir o valor correto,
   * a mensagem enviada informa o campo a ser corrigido
   * se o valor de entrada for negativo, uma mensagem enviada ao
   * usuario informando que o sistema vai desprezar o sinal negativo,
   * contudo o método ainda retorna o valor com o sinal negativo, deixando
   * para o banco de dados o trabalho de desprezar o sinal negativo
   * @param x String recebe o valor do textfield
   * @param campo String recebe o nome do campo a ser corrigido
   * @return double return o valor se ok, ou 0.0 se não
   */
  public boolean valDouble(String x, String campo) {
    double tmp;
    x.trim();
    for (int j = 0; j < x.length(); j++) for (int i = 0; i < 9; i++) if (
      x.substring(j).equals("-" + i)
    ) JOptionPane.showMessageDialog(
      null,
      "O Sistema Desprezará o Sinal Negativo",
      "Número Negativo",
      JOptionPane.ERROR_MESSAGE
    );
    try {
      tmp = Double.parseDouble(x);
    } catch (NumberFormatException ex) {
      ex.printStackTrace();
      JOptionPane.showMessageDialog(
        null,
        "Entre com um Número Inteiro ou Decimal",
        "Campo " + campo + " Inválido",
        JOptionPane.ERROR_MESSAGE
      );
      return false;
    }
    return true;
  }

  /**
   * método para verificar se um campo é inteiro, se não for int ou
   * for nulo exibe uma mensagem pedindo pra inserir o valor correto,
   * se o valor de entrada for negativo, uma mensagem enviada ao
   * usuario informando que o sistema vai desprezar o sinal negativo,
   * contudo o método ainda retorna o valor com o sinal negativo, deixando
   * para o banco de dados o trabalho de desprezar o sinal negativo
   * @param x String recebe o valor do textfield
   * @return int return o valor se OK, ou 0 se não
   */
  public boolean valInt(String x) {
    int tmp;
    x.trim();
    for (int j = 0; j < x.length(); j++) for (int i = 0; i < 9; i++) if (
      x.substring(j).equals("-" + i)
    ) JOptionPane.showMessageDialog(
      null,
      "O Sistema Desprezará o Sinal Negativo",
      "Número Negativo",
      JOptionPane.ERROR_MESSAGE
    );

    try {
      tmp = Integer.parseInt(x);
    } catch (NumberFormatException ex) {
      ex.printStackTrace();
      JOptionPane.showMessageDialog(
        null,
        "Entre com um Número Inteiro",
        "Campo Inválido",
        JOptionPane.ERROR_MESSAGE
      );
      return false;
    }
    return true;
  }

  /**
   * método para verificar se um campo é inteiro, se não for inteiro ou
   * for nulo exibe uma mensagem pedindo pra inserir o valor correto,
   * a mensagem enviada informa o campo a ser corrigido,
   * se o valor de entrada for negativo, uma mensagem enviada ao
   * usuario informando que o sistema vai desprezar o sinal negativo,
   * contudo o método ainda retorna o valor com o sinal negativo, deixando
   * para o banco de dados o trabalho de desprezar o sinal negativo
   * @param x String recebe o valor do textfield
   * @param campo String recebe o nome do campo a ser corrigido
   * @return int return o valor se OK, ou 0 se não
   */
  public boolean valInt(String x, String campo) {
    int tmp;
    x.trim();
    for (int j = 0; j < x.length(); j++) for (int i = 0; i < 9; i++) if (
      x.substring(j).equals("-" + i)
    ) JOptionPane.showMessageDialog(
      null,
      "O Sistema Desprezará o Sinal Negativo",
      "Número Negativo",
      JOptionPane.ERROR_MESSAGE
    );

    try {
      tmp = Integer.parseInt(x);
    } catch (NumberFormatException ex) {
      ex.printStackTrace();
      JOptionPane.showMessageDialog(
        null,
        "Entre com um Número Inteiro",
        "Campo " + campo + " Inválido",
        JOptionPane.ERROR_MESSAGE
      );
      return false;
    }
    return true;
  }

  /**
   * método para verificar se um campo é NULO, SE for nulo exibe uma
   * mensagem informando que o campo não pode ficar nulo
   * @param x String recebe o valor do textField
   * @return String retorna o valor de entrada se ok,
   */
  public boolean valNulo(String x) {
    String tmp = new String();
    try {
      tmp = x.substring(0, 1);
    } catch (IndexOutOfBoundsException ex) {
      ex.printStackTrace();
      JOptionPane.showMessageDialog(
        null,
        "Campo não pode ser NULO",
        "Campo NULO",
        JOptionPane.ERROR_MESSAGE
      );
      return false;
    }
    return true;
  }

  /**
   * método para verificar se um campo é NULO, SE for nulo exibe uma
   * mensagem informando que o campo não pode ficar nulo,
   * a mensagem informa o nome do campo a ser corrigido
   * @param x String recebe o valor do textfield
   * @param campo String recebe o nome do campo a ser validado
   * @return String retorna o valor de entrada se ok
   */
  public boolean valNulo(String x, String campo) {
    String tmp = new String();
    try {
      tmp = x.substring(0, 1);
    } catch (IndexOutOfBoundsException ex) {
      ex.printStackTrace();
      JOptionPane.showMessageDialog(
        null,
        "Campo " + campo + " não pode ser NULO",
        "Campo NULO",
        JOptionPane.ERROR_MESSAGE
      );
      return false;
    }
    return true;
  }
}
