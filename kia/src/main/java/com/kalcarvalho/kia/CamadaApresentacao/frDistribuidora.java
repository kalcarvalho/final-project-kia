package CamadaApresentacao;

import CamadaNegocios.Data;
import CamadaNegocios.Distribuidora;
import CamadaNegocios.Principal;
import Controladoras.CtrBackup;
import Controladoras.CtrLog;
import Controladoras.CtrRelatorio;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

public class frDistribuidora extends JFrame {

  private Data dt = new Data();
  private CtrRelatorio ctrRel;
  private String statusBackup;
  Vector opBack = new Vector(); //guarda a situação de backup
  private CtrBackup cBack = new CtrBackup();
  private CtrLog ctrlog;
  private testeValidacao tv;
  private String tipo; //recebe tipo de bd
  private String tipo1 = "Funcionário";
  private frComprarProduto fcp;
  private frCadastrarFornecedor fcf;
  private frCadastrarCliente fcc;
  private frAlterarCliente fac;
  private frAlterarFornecedor faf;
  private frExcluirFornecedor fef;
  private frExcluirCliente fec;
  private frCadastrarUsuario fcu;
  private frCadastrarVeiculo fcv;
  private frAlterarVeiculo fav;
  private frAlterarUsuario fau;
  private frExcluirUsuario feu;
  private frExcluirVeiculo fev;
  private frCadastrarProduto fp;
  private frAlterarProduto fap;
  private frExcluirProduto fep;
  private frLogin fl;
  private frBaixarContasaPagar fbcp;
  private frConsultarCliente fccli;
  private frContasaReceber fcr;
  private frConsultarFornecedor fcforn;
  private frConsultarProduto fcprod;
  private frConsultarUsuario fcusuar;
  private frConsultarVeiculo fcvei;
  private frConsultarEstoque fcest;
  private frCadastrarCondPag fccp;
  private frRemoverCondPag frcp;
  private frLog flog;
  private frConfigurarBackup fconfback;
  private frCadastrarPraca fcpraca;
  private frCadastrarRota fcrota;
  private frGerarRota fgrota;
  private frExcluirCompra fecompra;
  private frExcluirVenda fevenda;
  private frVenderProduto fvprod;
  private frDevolverProduto frdp;

  JPanel contentPane;
  JLabel statusBar = new JLabel();
  JButton bFsair = new JButton();
  JButton bFfornecedor = new JButton();
  JButton bFcliente = new JButton();
  JButton bFentrada = new JButton();
  JButton bFsaida = new JButton();
  JButton bfpraca = new JButton();
  JButton bFCrota = new JButton();
  JButton bFGrota = new JButton();
  JButton bFajuda = new JButton();
  JButton jButton10 = new JButton();
  ImageIcon image1;
  ImageIcon image2;
  ImageIcon image3;
  ImageIcon image4;
  ImageIcon image5;
  ImageIcon image6;
  ImageIcon image7;
  ImageIcon image8;
  ImageIcon image9;
  ImageIcon image10;

  JMenuBar mnuPrincipal = new JMenuBar();
  JMenu mnuCadastro = new JMenu();
  JMenu jMenu3 = new JMenu();
  JMenu jMenu4 = new JMenu();
  JMenuItem mnConsultarEstoque = new JMenuItem();
  JMenu jMenu5 = new JMenu();
  JMenuItem mnRelatorioForn = new JMenuItem();
  JMenuItem mnRelatorioCliente = new JMenuItem();
  JMenu jMenu10 = new JMenu();
  JMenuItem jMenuItem25 = new JMenuItem();
  JMenuItem jMenuItem26 = new JMenuItem();
  JMenuItem jMenuItem27 = new JMenuItem();
  JMenu jMenu11 = new JMenu();
  JMenuItem mnContasReceber = new JMenuItem();
  JMenuItem mnContasaPagar = new JMenuItem();
  JMenuItem mnDevolucao = new JMenuItem();
  JMenuItem jMenuItem33 = new JMenuItem();
  JMenu jMenu12 = new JMenu();
  JMenuItem mnCadastrarProd = new JMenuItem();
  JMenuItem mnRelatorioCP = new JMenuItem();
  JMenu mnuSistema = new JMenu();
  JMenuItem mnuSair = new JMenuItem();
  JMenu jMenu16 = new JMenu();
  JMenuItem jMnClienteRemover = new JMenuItem();
  JMenuItem jMnClienteIncluir = new JMenuItem();
  JMenuItem jMnClienteAlterar = new JMenuItem();
  JMenuItem jMnClienteConsultar = new JMenuItem();
  JMenu jMenu17 = new JMenu();
  JMenuItem jMnForneConsultar = new JMenuItem();
  JMenuItem jMnForneAlterar = new JMenuItem();
  JMenuItem jMnForneIncluir = new JMenuItem();
  JMenuItem jMnForneRemover = new JMenuItem();
  JMenu jMenu18 = new JMenu();
  JMenuItem mnConsultarUsuario = new JMenuItem();
  JMenuItem mnuAlterarUsu = new JMenuItem();
  JMenuItem mnuIncluirUsu = new JMenuItem();
  JMenuItem mnuExcluirUsu = new JMenuItem();
  JMenu jMenu20 = new JMenu();
  JMenuItem mnIncluir = new JMenuItem();
  JMenuItem mnAlterarVei = new JMenuItem();
  JMenuItem mnConsultarVei = new JMenuItem();
  JMenuItem mnExcluirVei = new JMenuItem();
  JMenuItem mnAlterarProd = new JMenuItem();
  JMenuItem mnConsultarProd = new JMenuItem();
  JMenuItem mnExcluirProd = new JMenuItem();
  JMenu mnBackup = new JMenu();
  JMenuItem mnBackupAgora = new JMenuItem();
  JMenuItem mnConfigurarBack = new JMenuItem();
  ButtonGroup radioGrupo = new ButtonGroup();
  JRadioButtonMenuItem radioAutoBackup = new JRadioButtonMenuItem(
    "Automático",
    false
  );
  JRadioButtonMenuItem radioSemBackup = new JRadioButtonMenuItem(
    "Sem Backup",
    true
  );
  JMenu jMenu21 = new JMenu();
  JMenuItem mnLogMaq2 = new JMenuItem();
  JMenuItem mnLogSistema2 = new JMenuItem();
  JMenuItem mnLogoff = new JMenuItem();
  JMenu mnEntrega = new JMenu();
  JMenu jMenu19 = new JMenu();
  JMenuItem mnCadastrarPraca = new JMenuItem();
  JMenuItem mnAlterarPraca = new JMenuItem();
  JMenuItem mnConsultarPraca = new JMenuItem();
  JMenuItem mnRemoverPraca = new JMenuItem();
  JMenu jMenu22 = new JMenu();
  JMenuItem mnIncluirRota = new JMenuItem();
  JMenuItem mnAlterarRota = new JMenuItem();
  JMenuItem mnConsultarRota = new JMenuItem();
  JMenuItem mnRemoverRota = new JMenuItem();
  JMenuItem mnGerarEntrega = new JMenuItem();
  JMenuItem nConsultarEntrega = new JMenuItem();
  JMenu mnCondicaoP = new JMenu();
  JMenuItem mnExcluirCP = new JMenuItem();
  JMenuItem mnIncluirCP = new JMenuItem();
  JMenu mnNE = new JMenu();
  JMenuItem mnCancelarNE = new JMenuItem();
  JMenuItem mnNovaNE = new JMenuItem();
  JMenu mnNS = new JMenu();
  JMenuItem mnCancelarNS = new JMenuItem();
  JMenuItem mnNovaNS = new JMenuItem();
  JToolBar jToolBar1 = new JToolBar();
  BorderLayout borderLayout1 = new BorderLayout();
  JLabel mapa = new JLabel();
  JMenu mnRCliente = new JMenu();
  JMenuItem mnRpanual = new JMenuItem();
  JMenuItem mnRCmensal = new JMenuItem();
  JMenuItem mnRCsemanal = new JMenuItem();
  JMenu mnRproduto = new JMenu();
  JMenuItem mnPanual = new JMenuItem();
  JMenuItem mnPmensal = new JMenuItem();
  JMenuItem mnPSemanal = new JMenuItem();
  JMenuItem mnEstoque = new JMenuItem();
  JMenuItem mnTabelaPreco = new JMenuItem();

  //Construct the frame
  public frDistribuidora(String tip, String stBack) {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      tipo = tip;
      statusBackup = stBack;
      jbInit();
      this.centrWindow();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //Component initialization
  private void jbInit() throws Exception {
    statusBar.setBackground(Color.blue);
    statusBar.setEnabled(true);
    statusBar.setFont(new java.awt.Font("Monospaced", 1, 12));
    statusBar.setForeground(Color.blue);
    statusBar.setBorder(BorderFactory.createEtchedBorder());
    statusBar.setDebugGraphicsOptions(0);
    statusBar.setText(" " + dt.getCurrentDate("dd-MM-yyyy"));
    image1 =
      new ImageIcon(
        CamadaApresentacao.frDistribuidora.class.getResource("sair2.gif")
      );
    image2 =
      new ImageIcon(
        CamadaApresentacao.frDistribuidora.class.getResource("fornecedor.gif")
      );
    image3 =
      new ImageIcon(
        CamadaApresentacao.frDistribuidora.class.getResource("cliente.gif")
      );
    image4 =
      new ImageIcon(
        CamadaApresentacao.frDistribuidora.class.getResource("entrada.gif")
      );
    image5 =
      new ImageIcon(
        CamadaApresentacao.frDistribuidora.class.getResource("saida2.gif")
      );
    image6 =
      new ImageIcon(
        CamadaApresentacao.frDistribuidora.class.getResource("praca.gif")
      );
    image7 =
      new ImageIcon(
        CamadaApresentacao.frDistribuidora.class.getResource("cRota2.gif")
      );
    image8 =
      new ImageIcon(
        CamadaApresentacao.frDistribuidora.class.getResource("gRota2.gif")
      );
    image9 =
      new ImageIcon(
        CamadaApresentacao.frDistribuidora.class.getResource("ajuda.gif")
      );
    image10 =
      new ImageIcon(
        CamadaApresentacao.frDistribuidora.class.getResource("mapa.jpg")
      );
    mapa.setIcon(image10);
    bFsair.setIcon(image1);
    bFsair.addActionListener(new frDistribuidora_bFsair_actionAdapter(this));
    bFsair.setToolTipText("Sair");
    bFfornecedor.setIcon(image2);
    bFfornecedor.addActionListener(
      new frDistribuidora_bFfornecedor_actionAdapter(this)
    );
    bFfornecedor.setToolTipText("Cadastrar Fornecedor");
    bFcliente.setIcon(image3);
    bFcliente.addActionListener(
      new frDistribuidora_bFcliente_actionAdapter(this)
    );
    bFcliente.setToolTipText("Cadastrar Cliente");
    bFentrada.setIcon(image4);
    bFentrada.addActionListener(
      new frDistribuidora_bFentrada_actionAdapter(this)
    );
    bFentrada.setToolTipText("Notas de Entrada");
    bFsaida.setIcon(image5);
    bFsaida.addActionListener(new frDistribuidora_bFsaida_actionAdapter(this));
    bFsaida.setToolTipText("Notas de Saída");
    bfpraca.setIcon(image6);
    bfpraca.addActionListener(new frDistribuidora_bfpraca_actionAdapter(this));
    bfpraca.setToolTipText("Cadastrar Praça");
    bFCrota.setIcon(image7);
    bFCrota.addActionListener(new frDistribuidora_bFCrota_actionAdapter(this));
    bFCrota.setToolTipText("Cadastrar Rota");
    bFGrota.setIcon(image8);
    bFGrota.addActionListener(new frDistribuidora_bFGrota_actionAdapter(this));
    bFGrota.setToolTipText("Gerar Rota");
    bFajuda.setIcon(image9);
    bFajuda.addActionListener(new frDistribuidora_bFajuda_actionAdapter(this));
    bFajuda.setToolTipText("Ajuda");
    jToolBar1.setBorder(BorderFactory.createEtchedBorder());
    this.setForeground(SystemColor.text);
    mnNovaNS.addActionListener(
      new frDistribuidora_mnNovaNS_actionAdapter(this)
    );
    mnRCliente.setMnemonic('C');
    mnRCliente.setText("Ranking de Clientes");
    mnRCsemanal.setMnemonic('S');
    mnRCsemanal.setText("Semanal");
    mnRCmensal.setMnemonic('M');
    mnRCmensal.setText("Mensal");
    mnRpanual.setMnemonic('A');
    mnRpanual.setText("Anual");
    mnRproduto.setMnemonic('P');
    mnRproduto.setText("Ranking de Produtos");
    mnPSemanal.setMnemonic('S');
    mnPSemanal.setText("Semanal");
    mnPmensal.setMnemonic('M');
    mnPmensal.setText("Mensal");
    mnPanual.setMnemonic('A');
    mnPanual.setText("Anual");
    mnEstoque.setMnemonic('E');
    mnEstoque.setText("Estoque/Validade");
    mnEstoque.addActionListener(
      new frDistribuidora_mnEstoque_actionAdapter(this)
    );
    mnTabelaPreco.setMnemonic('T');
    mnTabelaPreco.setText("Tabela de Preços");
    mnTabelaPreco.addActionListener(
      new frDistribuidora_mnTabelaPreco_actionAdapter(this)
    );
    mnCancelarNE.addActionListener(
      new frDistribuidora_mnCancelarNE_actionAdapter(this)
    );
    mnCancelarNS.addActionListener(
      new frDistribuidora_mnCancelarNS_actionAdapter(this)
    );
    mnDevolucao.addActionListener(
      new frDistribuidora_mnDevolucao_actionAdapter(this)
    );
    mnRelatorioCliente.addActionListener(
      new frDistribuidora_mnRelatorioCliente_actionAdapter(this)
    );
    mnRelatorioForn.addActionListener(
      new frDistribuidora_mnRelatorioForn_actionAdapter(this)
    );
    mnRelatorioCP.addActionListener(
      new frDistribuidora_mnRelatorioCP_actionAdapter(this)
    );
    jToolBar1.add(bFsair);
    jToolBar1.add(bFfornecedor);
    jToolBar1.add(bFcliente);
    jToolBar1.add(bFentrada);
    jToolBar1.add(bFsaida);
    jToolBar1.addSeparator();
    jToolBar1.add(bfpraca);
    jToolBar1.add(bFCrota);
    jToolBar1.add(bFGrota);
    jToolBar1.add(bFajuda);

    if (statusBackup.equalsIgnoreCase("false")) {
      radioAutoBackup.setEnabled(false);
      radioSemBackup.setEnabled(false);
      mnBackupAgora.setEnabled(false);
    }

    //     mnbackupa
    /**
     * limita a permissao de acesso ao usuario funcionário
     */
    if (tipo.equals(tipo1)) {
      jMnClienteAlterar.setEnabled(false);
      jMnClienteRemover.setEnabled(false);
      jMnForneAlterar.setEnabled(false);
      jMnForneRemover.setEnabled(false);
      mnIncluirCP.setEnabled(false);
      mnExcluirCP.setEnabled(false);
      mnCancelarNE.setEnabled(false);
      mnCancelarNS.setEnabled(false);
      mnAlterarProd.setEnabled(false);
      mnExcluirProd.setEnabled(false);
      mnAlterarVei.setEnabled(false);
      mnExcluirVei.setEnabled(false);
      mnuIncluirUsu.setEnabled(false);
      mnConsultarUsuario.setEnabled(false);
      mnuAlterarUsu.setEnabled(false);
      mnuExcluirUsu.setEnabled(false);
      mnLogMaq2.setEnabled(false);
      mnLogSistema2.setEnabled(false);
      mnConfigurarBack.setEnabled(false);
      radioAutoBackup.setEnabled(false);
      radioSemBackup.setEnabled(false);
    } else JOptionPane.showMessageDialog(
      null,
      "Você está logando como Administrador," + " Mantenha a Atenção!",
      "Logando",
      JOptionPane.WARNING_MESSAGE
    );

    mnLogoff.setEnabled(false);

    contentPane = (JPanel) this.getContentPane();
    contentPane.setLayout(borderLayout1);
    this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    this.setSize(new Dimension(640, 480));
    this.setTitle("KIA Software");
    contentPane.addFocusListener(
      new frDistribuidora_contentPane_focusAdapter(this)
    );
    mnuCadastro.setMnemonic('C');
    mnuCadastro.setText("Cadastros");
    jMenu3.setMnemonic('L');
    jMenu3.setText("Lançamentos");
    jMenu4.setMnemonic('O');
    jMenu4.setText("Consultas");
    mnConsultarEstoque.setMnemonic('E');
    mnConsultarEstoque.setText("Estoque / Validade");
    mnConsultarEstoque.addActionListener(
      new frDistribuidora_mnConsultarEstoque_actionAdapter(this)
    );
    jMenu5.setMnemonic('R');
    jMenu5.setText("Relatórios");
    mnRelatorioForn.setMnemonic('F');
    mnRelatorioForn.setText("Fornecedores");
    mnRelatorioCliente.setMnemonic('C');
    mnRelatorioCliente.setText("Clientes");
    jMenu10.setMnemonic('A');
    jMenu10.setText("Ajuda");
    jMenuItem25.setMnemonic('S');
    jMenuItem25.setText("Sobre ...");
    jMenuItem26.setMnemonic('T');
    jMenuItem26.setText("Tutorial");
    jMenuItem27.setMnemonic('R');
    jMenuItem27.setText("Referência Rápida");
    jMenu11.setMnemonic('F');
    jMenu11.setText("Financeiro");
    mnContasReceber.setMnemonic('R');
    mnContasReceber.setText("Contas a Receber");
    mnContasReceber.addActionListener(
      new frDistribuidora_mnContasReceber_actionAdapter(this)
    );
    mnContasaPagar.setMnemonic('P');
    mnContasaPagar.setText("Contas a Pagar");
    mnContasaPagar.addActionListener(
      new frDistribuidora_mnContasaPagar_actionAdapter(this)
    );
    mnDevolucao.setMnemonic('D');
    mnDevolucao.setText("Devolução");
    jMenuItem33.setMnemonic('R');
    jMenuItem33.setText("Contas a Receber");
    jMenu12.setMnemonic('P');
    jMenu12.setText("Produtos");
    mnCadastrarProd.setMnemonic('C');
    mnCadastrarProd.setText("Incluir");
    mnCadastrarProd.addActionListener(
      new frDistribuidora_mnCadastrarProd_actionAdapter(this)
    );
    mnRelatorioCP.setMnemonic('P');
    mnRelatorioCP.setText("Contas a Pagar");
    //jLabel1.setIcon(new ImageIcon(frDistribuidora.class.getResource("queijo.png")));
    contentPane.setBackground(SystemColor.textHighlightText);
    mnuSistema.setBorderPainted(false);
    mnuSistema.setMnemonic('S');
    mnuSistema.setText("Sistema");
    mnuSair.setMaximumSize(new Dimension(32767, 32767));
    mnuSair.setMnemonic('S');
    mnuSair.setText("Sair");
    mnuSair.addActionListener(new frDistribuidora_mnuSair_actionAdapter(this));
    jMenu16.setMnemonic('C');
    jMenu16.setText("Clientes");
    jMnClienteIncluir.setToolTipText("");
    jMnClienteIncluir.setMnemonic('I');
    jMnClienteIncluir.setText("Incluir");
    jMnClienteIncluir.addActionListener(
      new frDistribuidora_jMnClienteIncluir_actionAdapter(this)
    );
    jMnClienteAlterar.setMnemonic('A');
    jMnClienteAlterar.setText("Alterar");
    jMnClienteAlterar.addActionListener(
      new frDistribuidora_jMnClienteAlterar_actionAdapter(this)
    );
    jMnClienteConsultar.setToolTipText("");
    jMnClienteConsultar.setMnemonic('C');
    jMnClienteConsultar.setText("Consultar");
    jMnClienteConsultar.addActionListener(
      new frDistribuidora_jMnClienteConsultar_actionAdapter(this)
    );
    jMnClienteRemover.setToolTipText("");
    jMnClienteRemover.setMnemonic('R');
    jMnClienteRemover.setSelectedIcon(null);
    jMnClienteRemover.setText("Remover");
    jMnClienteRemover.addActionListener(
      new frDistribuidora_jMnClienteRemover_actionAdapter(this)
    );
    jMenu17.setMnemonic('F');
    jMenu17.setText("Fornecedores");
    jMnForneIncluir.setMnemonic('I');
    jMnForneIncluir.setText("Incluir");
    jMnForneIncluir.addActionListener(
      new frDistribuidora_jMnForneIncluir_actionAdapter(this)
    );
    jMnForneAlterar.setMnemonic('A');
    jMnForneAlterar.setText("Alterar");
    jMnForneAlterar.addActionListener(
      new frDistribuidora_jMnForneAlterar_actionAdapter(this)
    );
    jMnForneConsultar.setMnemonic('C');
    jMnForneConsultar.setText("Consultar");
    jMnForneConsultar.addActionListener(
      new frDistribuidora_jMnForneConsultar_actionAdapter(this)
    );
    jMnForneRemover.setMnemonic('R');
    jMnForneRemover.setText("Remover");
    jMnForneRemover.addActionListener(
      new frDistribuidora_jMnForneRemover_actionAdapter(this)
    );
    jMenu18.setMnemonic('U');
    jMenu18.setText("Usuários");
    mnConsultarUsuario.setMnemonic('C');
    mnConsultarUsuario.setText("Consultar");
    mnConsultarUsuario.addActionListener(
      new frDistribuidora_mnConsultarUsuario_actionAdapter(this)
    );
    mnuIncluirUsu.setActionCommand("");
    mnuIncluirUsu.setMnemonic('I');
    mnuIncluirUsu.setText("Incluir");
    mnuIncluirUsu.addActionListener(
      new frDistribuidora_mnuIncluirUsu_actionAdapter(this)
    );
    mnuAlterarUsu.setMnemonic('A');
    mnuAlterarUsu.setText("Alterar");
    mnuAlterarUsu.addActionListener(
      new frDistribuidora_mnuAlterarUsu_actionAdapter(this)
    );
    mnuExcluirUsu.setMnemonic('R');
    mnuExcluirUsu.setText("Remover");
    mnuExcluirUsu.addActionListener(
      new frDistribuidora_mnuExcluirUsu_actionAdapter(this)
    );
    jMenu20.setMnemonic('V');
    jMenu20.setText("Veículos");
    mnIncluir.setMnemonic('I');
    mnIncluir.setText("Incluir");
    mnIncluir.addActionListener(
      new frDistribuidora_mnIncluir_actionAdapter(this)
    );
    mnAlterarVei.setMnemonic('A');
    mnAlterarVei.setText("Alterar");
    mnAlterarVei.addActionListener(
      new frDistribuidora_mnAlterarVei_actionAdapter(this)
    );
    mnConsultarVei.setMnemonic('C');
    mnConsultarVei.setText("Consultar");
    mnConsultarVei.addActionListener(
      new frDistribuidora_mnConsultarVei_actionAdapter(this)
    );
    mnExcluirVei.setMnemonic('R');
    mnExcluirVei.setText("Remover");
    mnExcluirVei.addActionListener(
      new frDistribuidora_mnExcluirVei_actionAdapter(this)
    );
    mnAlterarProd.setMnemonic('A');
    mnAlterarProd.setText("Alterar");
    mnAlterarProd.addActionListener(
      new frDistribuidora_mnAlterarProd_actionAdapter(this)
    );
    mnConsultarProd.setMnemonic('C');
    mnConsultarProd.setText("Consultar");
    mnConsultarProd.addActionListener(
      new frDistribuidora_mnConsultarProd_actionAdapter(this)
    );
    mnExcluirProd.setVerifyInputWhenFocusTarget(true);
    mnExcluirProd.setMnemonic('R');
    mnExcluirProd.setText("Remover");
    mnExcluirProd.addActionListener(
      new frDistribuidora_mnExcluirProd_actionAdapter(this)
    );
    mnBackup.setMnemonic('B');
    mnBackup.setText("Backup");
    mnBackupAgora.setToolTipText("Fazer backup com um click");
    mnBackupAgora.setMnemonic('A');
    mnBackupAgora.setText("Agora");
    mnBackupAgora.addActionListener(
      new frDistribuidora_mnBackupAgora_actionAdapter(this)
    );
    mnConfigurarBack.setToolTipText("Escolher Diretório para fazer o backup");
    mnConfigurarBack.setMnemonic('C');
    mnConfigurarBack.setText("Configurar");
    mnConfigurarBack.addActionListener(
      new frDistribuidora_mnConfigurarBack_actionAdapter(this)
    );
    radioSemBackup.setToolTipText("Não fazer Backup");
    radioSemBackup.addActionListener(
      new frDistribuidora_radioSemBackup_actionAdapter(this)
    );
    radioAutoBackup.setToolTipText(
      "O backup será feito automaticamente quando você sair do sistema ou efetuar logoff"
    );
    radioAutoBackup.addActionListener(
      new frDistribuidora_radioAutoBackup_actionAdapter(this)
    );
    jMenu21.setMnemonic('A');
    jMenu21.setText("Arquivo de Log");
    mnLogMaq2.setToolTipText("");
    mnLogMaq2.setText("Log da Máquina");
    mnLogMaq2.addActionListener(
      new frDistribuidora_mnLogMaq2_actionAdapter(this)
    );
    mnLogSistema2.setText("Log do Sistema");
    mnLogoff.setMnemonic('E');
    mnLogoff.setText("Efetuar Logoff");
    mnLogoff.addActionListener(
      new frDistribuidora_mnLogoff_actionAdapter(this)
    );
    mnEntrega.setMnemonic('E');
    mnEntrega.setText("Entregas");
    jMenu19.setMnemonic('P');
    jMenu19.setText("Praça");
    mnCadastrarPraca.setMnemonic('I');
    mnCadastrarPraca.setText("Incluir");
    mnCadastrarPraca.addActionListener(
      new frDistribuidora_mnCadastrarPraca_actionAdapter(this)
    );
    mnAlterarPraca.setMnemonic('A');
    mnAlterarPraca.setText("Alterar");
    mnConsultarPraca.setMnemonic('C');
    mnConsultarPraca.setText("Consultar");
    mnRemoverPraca.setMnemonic('R');
    mnRemoverPraca.setText("Remover");
    jMenu22.setMnemonic('R');
    jMenu22.setText("Rota");
    mnIncluirRota.setMnemonic('I');
    mnIncluirRota.setText("Incluir");
    mnIncluirRota.addActionListener(
      new frDistribuidora_mnIncluirRota_actionAdapter(this)
    );
    mnAlterarRota.setMnemonic('A');
    mnAlterarRota.setText("Alterar");
    mnConsultarRota.setMnemonic('C');
    mnConsultarRota.setText("Consultar");
    mnRemoverRota.setMnemonic('R');
    mnRemoverRota.setText("Remover");
    mnGerarEntrega.setMnemonic('G');
    mnGerarEntrega.setText("Gerar Entrega");
    mnGerarEntrega.addActionListener(
      new frDistribuidora_mnGerarEntrega_actionAdapter(this)
    );
    nConsultarEntrega.setMnemonic('C');
    nConsultarEntrega.setText("Consultar Entrega");
    mnCondicaoP.setMnemonic('C');
    mnCondicaoP.setText("Condição de Pagamento");
    mnIncluirCP.setMnemonic('I');
    mnIncluirCP.setText("Incluir");
    mnIncluirCP.addActionListener(
      new frDistribuidora_mnIncluirCP_actionAdapter(this)
    );
    mnExcluirCP.setMnemonic('E');
    mnExcluirCP.setText("Excluir");
    mnExcluirCP.addActionListener(
      new frDistribuidora_mnExcluirCP_actionAdapter(this)
    );
    mnNE.setMnemonic('E');
    mnNE.setText("Notas de Entrada");
    mnNovaNE.setMnemonic('N');
    mnNovaNE.setText("Nova");
    mnNovaNE.addActionListener(
      new frDistribuidora_mnNovaNE_actionAdapter(this)
    );
    mnCancelarNE.setMnemonic('C');
    mnCancelarNE.setText("Cancelar");
    mnNS.setMnemonic('S');
    mnNS.setText("Notas de Saída");
    mnNovaNS.setMnemonic('N');
    mnNovaNS.setText("Nova");
    mnCancelarNS.setMnemonic('C');
    mnCancelarNS.setText("Cancelar");
    jToolBar1.setBounds(new Rectangle(96, 28, 10, 2));
    mnuPrincipal.add(mnuSistema);
    mnuPrincipal.add(mnuCadastro);
    mnuPrincipal.add(jMenu3);
    mnuPrincipal.add(jMenu4);
    mnuPrincipal.add(mnEntrega);
    mnuPrincipal.add(jMenu5);
    mnuPrincipal.add(jMenu10);
    mnuCadastro.add(jMenu16);
    mnuCadastro.add(jMenu17);
    mnuCadastro.addSeparator();
    mnuCadastro.add(jMenu12);
    mnuCadastro.addSeparator();
    mnuCadastro.add(mnCondicaoP);
    mnuCadastro.addSeparator();
    mnuCadastro.add(jMenu18);
    mnuCadastro.add(jMenu20);
    jMenu3.add(mnNE);
    jMenu3.add(mnNS);
    jMenu3.addSeparator();
    jMenu3.add(jMenu11);
    jMenu3.addSeparator();
    jMenu3.add(mnDevolucao);
    jMenu4.add(mnConsultarEstoque);
    jMenu4.add(jMenu21);
    jMenu5.add(mnRelatorioCliente);
    jMenu5.add(mnRelatorioForn);
    jMenu5.addSeparator();
    jMenu5.add(mnRelatorioCP);
    jMenu5.add(jMenuItem33);
    jMenu5.addSeparator();
    jMenu5.add(mnTabelaPreco);
    jMenu5.add(mnEstoque);
    jMenu5.addSeparator();
    jMenu5.add(mnRCliente);
    jMenu5.add(mnRproduto);
    jMenu10.add(jMenuItem27);
    jMenu10.add(jMenuItem26);
    jMenu10.addSeparator();
    jMenu10.add(jMenuItem25);
    jMenu11.add(mnContasReceber);
    jMenu11.add(mnContasaPagar);
    jMenu12.add(mnCadastrarProd);
    jMenu12.add(mnAlterarProd);
    jMenu12.add(mnConsultarProd);
    jMenu12.add(mnExcluirProd);
    this.getContentPane().add(mapa, BorderLayout.CENTER);
    this.getContentPane().add(jToolBar1, BorderLayout.NORTH);
    this.getContentPane().add(statusBar, BorderLayout.SOUTH);
    mnuSistema.add(mnBackup);
    mnuSistema.add(mnLogoff);
    mnuSistema.add(mnuSair);
    jMenu16.add(jMnClienteIncluir);
    jMenu16.add(jMnClienteAlterar);
    jMenu16.add(jMnClienteConsultar);
    jMenu16.add(jMnClienteRemover);
    jMenu17.add(jMnForneIncluir);
    jMenu17.add(jMnForneAlterar);
    jMenu17.add(jMnForneConsultar);
    jMenu17.add(jMnForneRemover);
    jMenu18.add(mnuIncluirUsu);
    jMenu18.add(mnuAlterarUsu);
    jMenu18.add(mnConsultarUsuario);
    jMenu18.add(mnuExcluirUsu);
    jMenu20.add(mnIncluir);
    jMenu20.add(mnAlterarVei);
    jMenu20.add(mnConsultarVei);
    jMenu20.add(mnExcluirVei);
    mnBackup.add(radioAutoBackup);
    mnBackup.add(radioSemBackup);
    mnBackup.addSeparator();
    radioGrupo.add(radioAutoBackup);
    radioGrupo.add(radioSemBackup);
    mnBackup.add(mnBackupAgora);
    mnBackup.addSeparator();
    mnBackup.add(mnConfigurarBack);
    jMenu21.add(mnLogMaq2);
    jMenu21.add(mnLogSistema2);
    this.setJMenuBar(mnuPrincipal);
    mnLogSistema2.addActionListener(
      new frDistribuidora_mnLogSistema2_actionAdapter(this)
    );
    mnEntrega.add(jMenu19);
    mnEntrega.add(jMenu22);
    mnEntrega.addSeparator();
    mnEntrega.add(mnGerarEntrega);
    mnEntrega.add(nConsultarEntrega);
    jMenu19.add(mnCadastrarPraca);
    jMenu19.add(mnAlterarPraca);
    jMenu19.add(mnConsultarPraca);
    jMenu19.add(mnRemoverPraca);
    jMenu22.add(mnIncluirRota);
    jMenu22.add(mnAlterarRota);
    jMenu22.add(mnConsultarRota);
    jMenu22.add(mnRemoverRota);
    mnCondicaoP.add(mnIncluirCP);
    mnCondicaoP.add(mnExcluirCP);
    mnNE.add(mnNovaNE);
    mnNE.add(mnCancelarNE);
    mnNS.add(mnNovaNS);
    mnNS.add(mnCancelarNS);
    mnRCliente.add(mnRCsemanal);
    mnRCliente.add(mnRCmensal);
    mnRCliente.add(mnRpanual);
    mnRproduto.add(mnPSemanal);
    mnRproduto.add(mnPmensal);
    mnRproduto.add(mnPanual);
  }

  //File | Exit action performed
  public void jMenuFileExit_actionPerformed(ActionEvent e) {}

  //Overridden so we can exit when window is closed
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      jMenuFileExit_actionPerformed(null);
    }
  }

  //Centralizar a janela
  public void centrWindow() {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = this.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    this.setLocation(
        (screenSize.width - frameSize.width) / 2,
        (screenSize.height - frameSize.height) / 2
      );
    this.setVisible(true);
  }

  void mnuSair_actionPerformed(ActionEvent e) {
    if (radioAutoBackup.isSelected()) Principal.dist.sair(
      true
    ); else Distribuidora.sair();
  }

  public void mudarUsuario(String t, String s) {
    if (s.equalsIgnoreCase("false")) {
      radioAutoBackup.setEnabled(false);
      radioSemBackup.setEnabled(false);
      mnBackupAgora.setEnabled(false);
    }

    //     mnbackupa
    /**
     * limita a permissao de acesso ao usuario funcionário
     */
    if (t.equals(tipo1)) {
      jMnClienteAlterar.setEnabled(false);
      jMnClienteRemover.setEnabled(false);
      jMnForneAlterar.setEnabled(false);
      jMnForneRemover.setEnabled(false);
      mnAlterarProd.setEnabled(false);
      mnExcluirProd.setEnabled(false);
      mnAlterarVei.setEnabled(false);
      mnExcluirVei.setEnabled(false);
      mnuIncluirUsu.setEnabled(false);
      mnConsultarUsuario.setEnabled(false);
      mnuAlterarUsu.setEnabled(false);
      mnuExcluirUsu.setEnabled(false);
      mnLogMaq2.setEnabled(false);
      mnLogSistema2.setEnabled(false);
      mnConfigurarBack.setEnabled(false);
      radioAutoBackup.setEnabled(false);
      radioSemBackup.setEnabled(false);
    } else JOptionPane.showMessageDialog(
      null,
      "Você está logando no sistema como Administrador," +
      " não vá fazer merda!",
      "Logando",
      JOptionPane.WARNING_MESSAGE
    );
  }

  void jMnForneIncluir_actionPerformed(ActionEvent e) {
    fcf = new frCadastrarFornecedor();
  }

  void jMnClienteIncluir_actionPerformed(ActionEvent e) {
    fcc = new frCadastrarCliente();
  }

  void jMnClienteAlterar_actionPerformed(ActionEvent e) {
    fac = new frAlterarCliente();
  }

  void jMnForneAlterar_actionPerformed(ActionEvent e) {
    faf = new frAlterarFornecedor();
  }

  void jMnForneRemover_actionPerformed(ActionEvent e) {
    fef = new frExcluirFornecedor();
  }

  void jMnClienteRemover_actionPerformed(ActionEvent e) {
    fec = new frExcluirCliente();
  }

  void mnuIncluirUsu_actionPerformed(ActionEvent e) {
    fcu = new frCadastrarUsuario();
  }

  void mnuAlterarUsu_actionPerformed(ActionEvent e) {
    fau = new frAlterarUsuario();
  }

  void mnuExcluirUsu_actionPerformed(ActionEvent e) {
    feu = new frExcluirUsuario();
  }

  void mnIncluir_actionPerformed(ActionEvent e) {
    fcv = new frCadastrarVeiculo();
  }

  void mnAlterarVei_actionPerformed(ActionEvent e) {
    fav = new frAlterarVeiculo();
  }

  void mnExcluirVei_actionPerformed(ActionEvent e) {
    fev = new frExcluirVeiculo();
  }

  void mnCadastrarProd_actionPerformed(ActionEvent e) {
    fp = new frCadastrarProduto();
  }

  void mnAlterarProd_actionPerformed(ActionEvent e) {
    fap = new frAlterarProduto();
  }

  void mnExcluirProd_actionPerformed(ActionEvent e) {
    fep = new frExcluirProduto();
  }

  void jMnClienteConsultar_actionPerformed(ActionEvent e) {
    fccli = new frConsultarCliente();
  }

  void mnContasaPagar_actionPerformed(ActionEvent e) {
    fbcp = new frBaixarContasaPagar();
  }

  void mnContasReceber_actionPerformed(ActionEvent e) {
    fcr = new frContasaReceber();
  }

  void mnEntrega_actionPerformed(ActionEvent e) {
    tv = new testeValidacao();
  }

  void jMnForneConsultar_actionPerformed(ActionEvent e) {
    fcforn = new frConsultarFornecedor();
  }

  void mnConsultarProd_actionPerformed(ActionEvent e) {
    fcprod = new frConsultarProduto();
  }

  void mnConsultarUsuario_actionPerformed(ActionEvent e) {
    fcusuar = new frConsultarUsuario();
  }

  void mnConsultarVei_actionPerformed(ActionEvent e) {
    fcvei = new frConsultarVeiculo();
  }

  void mnConsultarEstoque_actionPerformed(ActionEvent e) {
    fcest = new frConsultarEstoque();
  }

  void radioAutoBackup_actionPerformed(ActionEvent e) {
    opBack.addElement("true");
    opBack.addElement("false");
    cBack.setOPcaoBackup(opBack);
    opBack.removeAllElements();
    JOptionPane.showMessageDialog(null, "Em construção, update table ok");
  }

  void radioSemBackup_actionPerformed(ActionEvent e) {
    opBack.addElement("false");
    opBack.addElement("true");
    cBack.setOPcaoBackup(opBack);
    opBack.removeAllElements();
    JOptionPane.showMessageDialog(null, "Em construção, update table ok");
  }

  public void setRadioBackup(String op) {
    if (op.equalsIgnoreCase("Automatico")) radioAutoBackup.setSelected(true);
  }

  void mnConfigurarBack_actionPerformed(ActionEvent e) {
    fconfback = new frConfigurarBackup(statusBackup);
  }

  void mnBackupAgora_actionPerformed(ActionEvent e) {
    cBack.copiar();
  }

  void mnLogMaq2_actionPerformed(ActionEvent e) {
    ctrlog = new CtrLog();
  }

  void mnLogSistema2_actionPerformed(ActionEvent e) {
    ctrRel = new CtrRelatorio();
    Vector tmp = new Vector();
    tmp = ctrRel.gerarRelatorioLog();
    flog = new frLog(tmp);
  }

  void mnLogoff_actionPerformed(ActionEvent e) {
    fl = new frLogin();
  }

  void mnCadastrarPraca_actionPerformed(ActionEvent e) {
    fcpraca = new frCadastrarPraca();
  }

  void mnIncluirRota_actionPerformed(ActionEvent e) {
    fcrota = new frCadastrarRota();
  }

  void mnGerarEntrega_actionPerformed(ActionEvent e) {
    fgrota = new frGerarRota();
  }

  void mnIncluirCP_actionPerformed(ActionEvent e) {
    fccp = new frCadastrarCondPag();
  }

  void mnExcluirCP_actionPerformed(ActionEvent e) {
    frcp = new frRemoverCondPag();
  }

  void mnNovaNE_actionPerformed(ActionEvent e) {
    fcp = new frComprarProduto();
  }

  void bFsair_actionPerformed(ActionEvent e) {
    if (radioAutoBackup.isSelected()) Principal.dist.sair(
      true
    ); else Distribuidora.sair();
  }

  void bFfornecedor_actionPerformed(ActionEvent e) {
    fcf = new frCadastrarFornecedor();
  }

  void bFcliente_actionPerformed(ActionEvent e) {
    fcc = new frCadastrarCliente();
  }

  void bFentrada_actionPerformed(ActionEvent e) {
    fcp = new frComprarProduto();
  }

  void bFsaida_actionPerformed(ActionEvent e) {
    fvprod = new frVenderProduto();
  }

  void bfpraca_actionPerformed(ActionEvent e) {
    fcpraca = new frCadastrarPraca();
  }

  void bFCrota_actionPerformed(ActionEvent e) {
    fcrota = new frCadastrarRota();
  }

  void bFGrota_actionPerformed(ActionEvent e) {
    fgrota = new frGerarRota();
  }

  void bFajuda_actionPerformed(ActionEvent e) {}

  void mnNovaNS_actionPerformed(ActionEvent e) {
    fvprod = new frVenderProduto();
  }

  void mnCancelarNE_actionPerformed(ActionEvent e) {
    fecompra = new frExcluirCompra();
  }

  void mnCancelarNS_actionPerformed(ActionEvent e) {
    fevenda = new frExcluirVenda();
  }

  void mnDevolucao_actionPerformed(ActionEvent e) {
    frdp = new frDevolverProduto();
  }

  void mnTabelaPreco_actionPerformed(ActionEvent e) {
    ctrRel = new CtrRelatorio();
    ctrRel.gerarRelatorioPreco();
  }

  void mnEstoque_actionPerformed(ActionEvent e) {
    ctrRel = new CtrRelatorio();
    ctrRel.gerarRelatorioEstoque();
  }

  void mnRelatorioCliente_actionPerformed(ActionEvent e) {
    ctrRel = new CtrRelatorio();
    ctrRel.gerarRelatorioClientes();
  }

  void mnRelatorioForn_actionPerformed(ActionEvent e) {
    ctrRel = new CtrRelatorio();
    ctrRel.gerarRelatorioFornecedor();
  }

  void mnRelatorioCP_actionPerformed(ActionEvent e) {
    ctrRel = new CtrRelatorio();
    ctrRel.gerarRelatorioContasaPagar();
  }
}

class frDistribuidora_contentPane_focusAdapter
  extends java.awt.event.FocusAdapter {

  frDistribuidora adaptee;

  frDistribuidora_contentPane_focusAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }
}

class frDistribuidora_mnuSair_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnuSair_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnuSair_actionPerformed(e);
  }
}

class frDistribuidora_jMnClienteIncluir_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_jMnClienteIncluir_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.jMnClienteIncluir_actionPerformed(e);
  }
}

class frDistribuidora_jMnForneIncluir_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_jMnForneIncluir_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.jMnForneIncluir_actionPerformed(e);
  }
}

class frDistribuidora_jMnClienteAlterar_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_jMnClienteAlterar_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.jMnClienteAlterar_actionPerformed(e);
  }
}

class frDistribuidora_jMnForneAlterar_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_jMnForneAlterar_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.jMnForneAlterar_actionPerformed(e);
  }
}

class frDistribuidora_jMnForneRemover_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_jMnForneRemover_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.jMnForneRemover_actionPerformed(e);
  }
}

class frDistribuidora_jMnClienteRemover_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_jMnClienteRemover_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.jMnClienteRemover_actionPerformed(e);
  }
}

class frDistribuidora_mnuIncluirUsu_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnuIncluirUsu_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnuIncluirUsu_actionPerformed(e);
  }
}

class frDistribuidora_mnuAlterarUsu_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnuAlterarUsu_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnuAlterarUsu_actionPerformed(e);
  }
}

class frDistribuidora_mnuExcluirUsu_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnuExcluirUsu_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnuExcluirUsu_actionPerformed(e);
  }
}

class frDistribuidora_mnIncluir_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnIncluir_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnIncluir_actionPerformed(e);
  }
}

class frDistribuidora_mnAlterarVei_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnAlterarVei_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnAlterarVei_actionPerformed(e);
  }
}

class frDistribuidora_mnExcluirVei_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnExcluirVei_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnExcluirVei_actionPerformed(e);
  }
}

class frDistribuidora_mnCadastrarProd_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnCadastrarProd_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnCadastrarProd_actionPerformed(e);
  }
}

class frDistribuidora_mnAlterarProd_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnAlterarProd_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnAlterarProd_actionPerformed(e);
  }
}

class frDistribuidora_mnExcluirProd_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnExcluirProd_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnExcluirProd_actionPerformed(e);
  }
}

class frDistribuidora_jMnClienteConsultar_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_jMnClienteConsultar_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.jMnClienteConsultar_actionPerformed(e);
  }
}

class frDistribuidora_mnContasaPagar_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnContasaPagar_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnContasaPagar_actionPerformed(e);
  }
}

class frDistribuidora_mnContasReceber_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnContasReceber_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnContasReceber_actionPerformed(e);
  }
}

class frDistribuidora_jMnForneConsultar_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_jMnForneConsultar_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.jMnForneConsultar_actionPerformed(e);
  }
}

class frDistribuidora_mnConsultarProd_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnConsultarProd_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnConsultarProd_actionPerformed(e);
  }
}

class frDistribuidora_mnConsultarUsuario_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnConsultarUsuario_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnConsultarUsuario_actionPerformed(e);
  }
}

class frDistribuidora_mnConsultarVei_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnConsultarVei_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnConsultarVei_actionPerformed(e);
  }
}

class frDistribuidora_mnConsultarEstoque_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnConsultarEstoque_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnConsultarEstoque_actionPerformed(e);
  }
}

class frDistribuidora_radioAutoBackup_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_radioAutoBackup_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.radioAutoBackup_actionPerformed(e);
  }
}

class frDistribuidora_radioSemBackup_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_radioSemBackup_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.radioSemBackup_actionPerformed(e);
  }
}

class frDistribuidora_mnConfigurarBack_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnConfigurarBack_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnConfigurarBack_actionPerformed(e);
  }
}

class frDistribuidora_mnBackupAgora_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnBackupAgora_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnBackupAgora_actionPerformed(e);
  }
}

class frDistribuidora_mnLogMaq2_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnLogMaq2_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnLogMaq2_actionPerformed(e);
  }
}

class frDistribuidora_mnLogSistema2_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnLogSistema2_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnLogSistema2_actionPerformed(e);
  }
}

class frDistribuidora_mnLogoff_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnLogoff_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnLogoff_actionPerformed(e);
  }
}

class frDistribuidora_mnCadastrarPraca_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnCadastrarPraca_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnCadastrarPraca_actionPerformed(e);
  }
}

class frDistribuidora_mnIncluirRota_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnIncluirRota_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnIncluirRota_actionPerformed(e);
  }
}

class frDistribuidora_mnGerarEntrega_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnGerarEntrega_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnGerarEntrega_actionPerformed(e);
  }
}

class frDistribuidora_mnIncluirCP_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnIncluirCP_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnIncluirCP_actionPerformed(e);
  }
}

class frDistribuidora_mnExcluirCP_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnExcluirCP_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnExcluirCP_actionPerformed(e);
  }
}

class frDistribuidora_mnNovaNE_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnNovaNE_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnNovaNE_actionPerformed(e);
  }
}

class frDistribuidora_bFsair_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_bFsair_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.bFsair_actionPerformed(e);
  }
}

class frDistribuidora_bFfornecedor_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_bFfornecedor_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.bFfornecedor_actionPerformed(e);
  }
}

class frDistribuidora_bFcliente_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_bFcliente_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.bFcliente_actionPerformed(e);
  }
}

class frDistribuidora_bFentrada_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_bFentrada_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.bFentrada_actionPerformed(e);
  }
}

class frDistribuidora_bFsaida_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_bFsaida_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.bFsaida_actionPerformed(e);
  }
}

class frDistribuidora_bfpraca_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_bfpraca_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.bfpraca_actionPerformed(e);
  }
}

class frDistribuidora_bFCrota_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_bFCrota_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.bFCrota_actionPerformed(e);
  }
}

class frDistribuidora_bFGrota_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_bFGrota_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.bFGrota_actionPerformed(e);
  }
}

class frDistribuidora_bFajuda_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_bFajuda_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.bFajuda_actionPerformed(e);
  }
}

class frDistribuidora_mnNovaNS_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnNovaNS_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnNovaNS_actionPerformed(e);
  }
}

class frDistribuidora_mnCancelarNE_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnCancelarNE_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnCancelarNE_actionPerformed(e);
  }
}

class frDistribuidora_mnCancelarNS_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnCancelarNS_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnCancelarNS_actionPerformed(e);
  }
}

class frDistribuidora_mnDevolucao_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnDevolucao_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnDevolucao_actionPerformed(e);
  }
}

class frDistribuidora_mnTabelaPreco_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnTabelaPreco_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnTabelaPreco_actionPerformed(e);
  }
}

class frDistribuidora_mnEstoque_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnEstoque_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnEstoque_actionPerformed(e);
  }
}

class frDistribuidora_mnRelatorioCliente_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnRelatorioCliente_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnRelatorioCliente_actionPerformed(e);
  }
}

class frDistribuidora_mnRelatorioForn_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnRelatorioForn_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnRelatorioForn_actionPerformed(e);
  }
}

class frDistribuidora_mnRelatorioCP_actionAdapter
  implements java.awt.event.ActionListener {

  frDistribuidora adaptee;

  frDistribuidora_mnRelatorioCP_actionAdapter(frDistribuidora adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.mnRelatorioCP_actionPerformed(e);
  }
}
