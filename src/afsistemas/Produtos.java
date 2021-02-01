/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afsistemas;

/**
 *
 * @author Anthony
 */
import DataBase.Bdados;
import afsistemas.Cliente;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Produtos extends javax.swing.JPanel {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public Produtos() {
        initComponents();
        jButton8.setEnabled(false);
        try {
            con = Bdados.Bdados();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Produtos.class.getName()).log(Level.SEVERE, null, ex);
        }
        mostrar();
    }
    boolean menuDisplay = false;
    boolean menuDisplay1 = false;
   
    public void mostrar(){
        String sql = "SELECT * From produto";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            Table.setModel(DbUtils.resultSetToTableModel(rs));
            
       } 
        catch (SQLException error){
            JOptionPane.showMessageDialog(null, error);
        }
        
    }
    
    public void pesquisa_usuario(){
        String sql = "SELECT * From produto where Nome like ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, jtext.getText() + "%");
            rs = ps.executeQuery();
            Table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (SQLException error ){
            JOptionPane.showMessageDialog(null, error);
        }
    }
    
    public void salvar(){
        String sql = "INSERT INTO produto (CodBarra,CodAlter,Nome,Descricao,Grupo,Marca,Tributacao,NCM,ANP,AVista_Venda,AVista_Lucro,AVista_Minimo,APrazo_Venda,APrazo_Lucro,APrazo_Minimo)"+"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            
             
               ps.setString(1, CodBarra_texto.getText());
               ps.setString(2, CodAlter_texto.getText());
               ps.setString(3, Nome_texto.getText());
               ps.setString(4, Descricao_texto.getText());
               ps.setString(5, Grupo_texto.getText());
               ps.setString(6, (String) Marca_selecao.getSelectedItem());
               ps.setString(7, (String) Tributacao_selecao.getSelectedItem());
               ps.setString(8, (String) NCM_selecao.getSelectedItem());
               ps.setString(9,(String) ANP_selecao.getSelectedItem());
               ps.setString(10, AVista_Venda_texto.getText());
               ps.setString(11, AVista_Lucro_texto.getText());
               ps.setString(12, AVista_Minimo_texto.getText());
               ps.setString(13, APrazo_Venda_texto.getText());
               ps.setString(14, APrazo_Lucro_texto.getText());
               ps.setString(15, APrazo_Minimo_texto.getText());
       
           
              CodBarra_texto.setText("");
              CodAlter_texto.setText("");
              Nome_texto.setText("");
              Descricao_texto.setText("");
              Grupo_texto.setText("");
              Marca_selecao.setSelectedItem("");
              Tributacao_selecao.setSelectedItem("");
              NCM_selecao.setSelectedItem("");
              ANP_selecao.setSelectedItem("");
              AVista_Venda_texto.setText("");
              AVista_Lucro_texto.setText("");
              AVista_Minimo_texto.setText("");
              APrazo_Venda_texto.setText("");
              APrazo_Lucro_texto.setText("");
              APrazo_Minimo_texto.setText("");
       
           
            
            
        
            
            
            
            ps.execute();
            ps.close();
            
            JOptionPane.showMessageDialog(null,"Cliente cadastrado");
        } catch (SQLException error){
            JOptionPane.showMessageDialog(null,error);
        }
        
    }
     public void Atualizar(){
        
         try{
         String sql="UPDATE produto SET CodBarra=?,CodAlter=?,Nome=?,Descricao=?,Grupo=?,Marca=?,Tributacao=?,NCM=?,ANP=?,AVista_Venda=?,AVista_Lucro=?,AVista_Minimo=?,APrazo_Venda=?,APrazo_Lucro=?,APrazo_Minimo=? where Cod=?";
         ps=con.prepareStatement(sql);
         
           ps.setString(1, CodBarra_texto.getText());
               ps.setString(2, CodAlter_texto.getText());
               ps.setString(3, Nome_texto.getText());
               ps.setString(4, Descricao_texto.getText());
               ps.setString(5, Grupo_texto.getText());
               ps.setString(6, (String) Marca_selecao.getSelectedItem());
               ps.setString(7, (String) Tributacao_selecao.getSelectedItem());
               ps.setString(8, (String) NCM_selecao.getSelectedItem());
               ps.setString(9,(String) ANP_selecao.getSelectedItem());
               ps.setString(10, AVista_Venda_texto.getText());
               ps.setString(11, AVista_Lucro_texto.getText());
               ps.setString(12, AVista_Minimo_texto.getText());
               ps.setString(13, APrazo_Venda_texto.getText());
               ps.setString(14, APrazo_Lucro_texto.getText());
               ps.setString(15, APrazo_Minimo_texto.getText());
               ps.setString(16, Cod_texto.getText());
       
         ps.executeUpdate();
         ps.close();
    
     JOptionPane.showMessageDialog(null, "Atualizacao Concluida");
     }
         catch(SQLException error){
             
               JOptionPane.showMessageDialog(null, error);
         }
    }
    
    public void setar(){
        
        int setar = Table.getSelectedRow();
              Cod_texto.setText(Table.getModel().getValueAt(setar, 0).toString());
              CodBarra_texto.setText(Table.getModel().getValueAt(setar, 1).toString());
              CodAlter_texto.setText(Table.getModel().getValueAt(setar, 2).toString());
              Nome_texto.setText(Table.getModel().getValueAt(setar, 3).toString());
              Descricao_texto.setText(Table.getModel().getValueAt(setar, 4).toString());
              Grupo_texto.setText(Table.getModel().getValueAt(setar, 5).toString());
              Marca_selecao.setSelectedItem(Table.getModel().getValueAt(setar, 6).toString());
              Tributacao_selecao.setSelectedItem(Table.getModel().getValueAt(setar, 7).toString());
              NCM_selecao.setSelectedItem(Table.getModel().getValueAt(setar, 8).toString());
              ANP_selecao.setSelectedItem(Table.getModel().getValueAt(setar, 9).toString());
              AVista_Venda_texto.setText(Table.getModel().getValueAt(setar, 10).toString());
              AVista_Lucro_texto.setText(Table.getModel().getValueAt(setar, 11).toString());
              AVista_Minimo_texto.setText(Table.getModel().getValueAt(setar, 12).toString());
              APrazo_Venda_texto.setText(Table.getModel().getValueAt(setar, 13).toString());
              APrazo_Lucro_texto.setText(Table.getModel().getValueAt(setar, 14).toString());
              APrazo_Minimo_texto.setText(Table.getModel().getValueAt(setar, 15).toString());
  
       
     jButton8.setEnabled(true);
    
    }
    
    public void limpacampos(){
            CodBarra_texto.setText("");
              CodAlter_texto.setText("");
              Nome_texto.setText("");
              Descricao_texto.setText("");
              Grupo_texto.setText("");
              Marca_selecao.setSelectedItem("");
              Tributacao_selecao.setSelectedItem("");
              NCM_selecao.setSelectedItem("");
              ANP_selecao.setSelectedItem("");
              AVista_Venda_texto.setText("");
              AVista_Lucro_texto.setText("");
              AVista_Minimo_texto.setText("");
              APrazo_Venda_texto.setText("");
              APrazo_Lucro_texto.setText("");
              APrazo_Minimo_texto.setText("");
           
    }
    
    public void delete(){
        String sql = "DELETE from produto where Nome='"+Nome_texto.getText()+"'";
        
        try {
            ps = con.prepareStatement(sql);
            Cod_texto.getText();
            
            
            ps.executeUpdate();
            ps.close();
            
            JOptionPane.showMessageDialog(null,"Excluido com Sucesso");
        } catch (SQLException error) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, error);
        }
        limpacampos();
        jButton8.setEnabled(false);
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel0 = new javax.swing.JPanel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jPanel5 = new javax.swing.JPanel();
        Painel_Geral = new javax.swing.JPanel();
        Codigo = new javax.swing.JLabel();
        Nome = new javax.swing.JLabel();
        Descricao_texto = new javax.swing.JTextField();
        CodAlter = new javax.swing.JLabel();
        CodAlter_texto = new javax.swing.JFormattedTextField();
        CodBarra = new javax.swing.JLabel();
        CodBarra_texto = new javax.swing.JTextField();
        Descricao = new javax.swing.JLabel();
        Nome_texto = new javax.swing.JTextField();
        Marca = new javax.swing.JLabel();
        Cod_texto = new javax.swing.JFormattedTextField();
        Grupo = new javax.swing.JLabel();
        Marca_selecao = new javax.swing.JComboBox<>();
        NCM = new javax.swing.JLabel();
        Tributacao_selecao = new javax.swing.JComboBox<>();
        Tributacao = new javax.swing.JLabel();
        NCM_selecao = new javax.swing.JComboBox<>();
        ANP = new javax.swing.JLabel();
        ANP_selecao = new javax.swing.JComboBox<>();
        Grupo_texto = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        Painel_Preco = new javax.swing.JPanel();
        Painel_Preco_AVista = new javax.swing.JPanel();
        AVista_Lucro_texto = new javax.swing.JTextField();
        AVista_Venda_texto = new javax.swing.JTextField();
        AVista_Minimo_texto = new javax.swing.JTextField();
        AVista_Venda = new javax.swing.JLabel();
        AVista_Lucro = new javax.swing.JLabel();
        AVista_Minimo = new javax.swing.JLabel();
        Painel_Preco_APrazo = new javax.swing.JPanel();
        APrazo_Venda = new javax.swing.JLabel();
        APrazo_Lucro = new javax.swing.JLabel();
        APrazo_Minimo = new javax.swing.JLabel();
        APrazo_Minimo_texto = new javax.swing.JTextField();
        APrazo_Venda_texto = new javax.swing.JTextField();
        APrazo_Lucro_texto = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtext = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel1.setDoubleBuffered(false);
        jPanel1.setFocusCycleRoot(true);
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setVerifyInputWhenFocusTarget(false);

        jPanel0.setBackground(new java.awt.Color(245, 245, 245));

        jLayeredPane2.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane2.setAutoscrolls(true);
        jLayeredPane2.setName(""); // NOI18N

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setFocusable(false);

        Painel_Geral.setBackground(new java.awt.Color(255, 255, 255));
        Painel_Geral.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Geral", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 14))); // NOI18N
        Painel_Geral.setDoubleBuffered(false);
        Painel_Geral.setFocusCycleRoot(true);
        Painel_Geral.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        Painel_Geral.setInheritsPopupMenu(true);

        Codigo.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Codigo.setText("Codigo");

        Nome.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Nome.setText("Nome");
        Nome.setToolTipText("Nome Completo do Cliente.");

        Descricao_texto.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Descricao_texto.setToolTipText("Nome Completo do Cliente.");
        Descricao_texto.setAutoscrolls(false);

        CodAlter.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        CodAlter.setText("COD");

        CodAlter_texto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        CodAlter_texto.setAutoscrolls(false);
        CodAlter_texto.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        CodAlter_texto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CodAlter_textoKeyReleased(evt);
            }
        });

        CodBarra.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        CodBarra.setText("COD de Barra ");
        CodBarra.setToolTipText("CPF OU CNPJ");

        CodBarra_texto.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        CodBarra_texto.setToolTipText("CPF OU CNPJ");
        CodBarra_texto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodBarra_textoActionPerformed(evt);
            }
        });
        CodBarra_texto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CodBarra_textoKeyReleased(evt);
            }
        });

        Descricao.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Descricao.setText("Descrição");

        Nome_texto.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Nome_texto.setToolTipText("Nome Completo do Cliente.");
        Nome_texto.setAutoscrolls(false);

        Marca.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Marca.setText("Marca");

        Cod_texto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("00000"))));
        Cod_texto.setEnabled(false);
        Cod_texto.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N

        Grupo.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Grupo.setText("Grupo");

        Marca_selecao.setBackground(new java.awt.Color(255, 255, 255));
        Marca_selecao.setEditable(true);
        Marca_selecao.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N

        NCM.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        NCM.setText("NCM");

        Tributacao_selecao.setBackground(new java.awt.Color(255, 255, 255));
        Tributacao_selecao.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Tributacao_selecao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Substituição Tributaria", "Não tributado", "Tributado" }));
        Tributacao_selecao.setLightWeightPopupEnabled(false);

        Tributacao.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Tributacao.setText("Tributação");

        NCM_selecao.setBackground(new java.awt.Color(255, 255, 255));
        NCM_selecao.setEditable(true);
        NCM_selecao.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N

        ANP.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        ANP.setText("ANP");

        ANP_selecao.setBackground(new java.awt.Color(255, 255, 255));
        ANP_selecao.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        ANP_selecao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "110203073", "110204001", "110204002", "140101027", "140101026", "740101005", "740101004", "740101001", "740101006", "740101002", "110203083", "910101001", "110103001", "330101001", "110203091", "120204001", "110106001", "120206001", "110101001", "110101042", "810201001", "110201067", "110204003", "330201005", "330201006", "330201004", "110105001", "110203072", "110203001", "110201001", "110101002", "110203002", "120205010", "110203003", "110204004", "110204005", "110204006", "110204007", "110204008", "110204009", "110204010", "110204011", "110105027", "110103003", "110103002", "110105002", "110205001", "120203002", "120205001", "110203004", "120203001", "530102001", "530101002", "110206023", "110108001", "110105017", "110206019", "110205023", "110201002", "120202001", "110101003", "110101004", "110103004", "110103005", "110207010", "110203097", "110205037", "110101005", "110203096", "110204012", "110204013", "110204014", "110102001", "120207003", "110201003", "110201004", "110201005", "110201006", "110206001", "110205002", "110203005", "110205003", "330201001", "110206002", "110101006", "110101007", "110101038", "120205002", "820101001", "820101010", "110206003", "110201007", "120201001", "110201008", "110103017", "110205004", "110203077", "110101008", "110203006", "110203007", "110201009", "110203008", "110203009", "110203010", "120203004", "110206004", "610101009", "610801001", "120205003", "110205005", "610811001", "610812001", "610803003", "610805001", "610806003", "110203092", "110204015", "210202003", "210202001", "210202002", "110105018", "110203011", "110203012", "110101009", "110104001", "110104006", "110106010", "610802001", "610802002", "110202007", "110106002", "110111002", "110103006", "110105003", "110201010", "110201011", "110201064", "110201012", "110101010", "110101011", "110108002", "110107001", "120202002", "110202011", "110106003", "110201066", "110108003", "110203085", "110201013", "110207001", "110205034", "110105023", "110101012", "110205031", "110201014", "620501002", "620501001", "610101005", "610101006", "530101001", "530101020", "530101018", "110205006", "110201015", "110203013", "110202001", "120104001", "120102001", "120104002", "120205009", "610804001", "540101002", "540101001", "110107002", "610806006", "610806007", "610806008", "610806009", "620601003", "110201016", "110101013", "120207001", "110206020", "110104008", "110201017", "110108004", "110201018", "330201007", "110205007", "110203086", "110205008", "340101002", "130202002", "430101002", "130202003", "560101002", "130202004", "820101032", "820101026", "820101027", "820101004", "820101005", "820101022", "820101031", "820101030", "820101014", "820101006", "820101016", "820101015", "820101025", "820101017", "820101018", "820101019", "820101020", "820101021", "330101003", "130202006", "110203014", "420201001", "420201003", "120204010", "110103007", "110204017", "110204051", "110204018", "110205035", "110205022", "110203069", "110203015", "110203104", "610903001", "610903002", "110206005", "110203016", "110203017", "110203018", "110203088", "110203019", "530101003", "530101019", "110101014", "620101002", "720101001", "720101002", "120205004", "110203079", "110203020", "110201019", "110203021", "110108005", "110101015", "110104002", "110101016", "110206025", "120203007", "620101007", "140102001", "110105004", "110107003", "110203095", "210301001", "810102001", "810102004", "810102002", "130201002", "810102003", "810101002", "810101001", "810101003", "210301002", "330201010", "611003001", "611003002", "611003003", "110204016", "110105005", "110105006", "110105007", "110104003", "610904001", "110206006", "110206007", "110203022", "110204019", "110206008", "110206009", "110101043", "110201020", "110104009", "110203023", "110101017", "110101018", "210302004", "210101001", "210302003", "210302002", "210204001", "220101003", "220101004", "220101002", "220101001", "220101005", "220101006", "130202001", "130202005", "520101001", "320101001", "320101003", "320101002", "320102002", "320102001", "320102004", "320102003", "320201001", "320201002", "320103001", "220102001", "320301002", "110204020", "110203024", "120205012", "110207002", "110203087", "730101002", "210203001", "210203002", "110104005", "140101023", "140101024", "140101025", "650101004", "650101003", "650101001", "110207003", "110201021", "110103013", "110201022", "110203025", "110203026", "110206011", "110206010", "110203027", "110203028", "330101008", "330101002", "330101009", "110202009", "110201068", "620101001", "610201001", "610201002", "610201003", "710101001", "110203074", "610808001", "610808002", "110201023", "110103008", "110203029", "120205005", "110204021", "110204022", "110204023", "620101004", "620101005", "330101010", "110202002", "110202003", "110207004", "110101046", "110204024", "110113001", "110105015", "110101019", "110203098", "110103015", "110205025", "110204025", "110204026", "110204027", "120204009", "110205026", "110204028", "110204029", "110203080", "120207004", "110203030", "110105025", "110203031", "110203084", "110203032", "110204030", "110205009", "110104004", "110201024", "110201025", "110201026", "110201027", "110201028", "110201029", "110201030", "110205036", "110207005", "110204031", "110207006", "110201031", "110201032", "110201033", "120204002", "110101020", "120203006", "220102002", "110105008", "110203033", "110105009", "110201034", "110204053", "110203034", "110203035", "640201001", "120205011", "110101021", "120103001", "110203036", "120204003", "110201035", "110204032", "110101022", "110201036", "110101023", "110101024", "110101025", "110101039", "110204033", "120207002", "110202004", "110202005", "110201069", "110203037", "110201037", "110203078", "120203005", "110201038", "110201039", "120101001", "110201040", "110201041", "740101007", "640101001", "110205027", "110103009", "110103010", "110205010", "120203008", "110301001", "110208001", "110203038", "110203089", "110201042", "110101026", "620502001", "110203039", "110202008", "110204034", "110207009", "611201002", "611201003", "611201001", "610803002", "110110001", "310102001", "310103001", "310101001", "611207003", "110101027", "110205011", "110201062", "110203040", "610801002", "610801004", "610801005", "610801003", "610905001", "610101002", "610401002", "610813002", "610906002", "610101003", "610401003", "610813003", "610906003", "610101004", "610401004", "610906004", "610813004", "611102001", "611102002", "611102003", "611102004", "611001001", "611001002", "611001003", "611001004", "611001005", "611202001", "611202002", "611202003", "110203041", "110203042", "110203043", "110203094", "110206024", "110203044", "430101001", "110206021", "120204004", "110207007", "611203002", "110203045", "110201043", "110203046", "110203047", "110203048", "110203099", "110203081", "430101004", "510101003", "510101001", "510101002", "510102003", "510102001", "510102002", "510201001", "510201002", "510201003", "510301003", "140101015", "140101009", "140101016", "140101017", "140101005", "140101014", "140101018", "140101006", "140101028", "140101021", "140101010", "140101012", "140101013", "140101001", "140101030", "140101011", "140101003", "140101002", "140101008", "140101007", "140101019", "140101004", "560101001", "420105001", "420101005", "420101004", "420101003", "420102005", "420102004", "420102003", "420104001", "820101033", "820101034", "420106001", "820101011", "820101003", "820101013", "820101012", "420106002", "830101001", "420301004", "420301003", "420201002", "420202001", "420301001", "611207002", "611301001", "610601001", "610701001", "510301002", "620601001", "660101001", "620401001", "620301001", "620201001", "630101001", "611207004", "110202006", "110203093", "110204035", "110203049", "110201044", "110201045", "110206012", "120203003", "320301001", "320103002", "650101002", "310102002", "640401001", "610907001", "610814001", "611107001", "611007001", "611207006", "140101029", "740101003", "810201002", "530103001", "340101003", "430101003", "560101003", "611207001", "210302001", "210204002", "130201001", "530104001", "140101022", "610201004", "510301001", "420301002", "620601004", "620505001", "610501001", "620101008", "610101010", "110208002", "110110002", "130202008", "410103001", "610302001", "330101007", "330201009", "730101001", "110205033", "110203050", "110101028", "611103001", "611106002", "611104001", "611106003", "611101007", "611106001", "110101049", "110101029", "110101030", "110104007", "110111001", "110203102", "610809002", "610809001", "610809003", "610809004", "120205006", "110205032", "110203051", "110101050", "110201065", "110105028", "110105016", "611204001", "110201046", "110106007", "110101031", "611207005", "110207008", "110203082", "610809005", "610809006", "610809007", "610809008", "610301001", "110101032", "110101047", "110105021", "110105010", "611206001", "611206002", "620101003", "210201001", "210201002", "210201003", "610809009", "610809010", "610809011", "110105020", "110105022", "110205012", "620601002", "120206003", "110204036", "110204037", "110204038", "110203101", "410101001", "410101002", "410102001", "410102002", "110103014", "110203052", "330101005", "330101006", "110205029", "110203053", "120204008", "110203054", "110204039", "110201047", "110201048", "110103011", "550101001", "550101005", "550101002", "550101003", "550101004", "130202007", "110105011", "110201049", "110101048", "110101033", "110101040", "110101045", "110101041", "110204040", "110105019", "110205030", "110204041", "110105024", "110203070", "110203055", "110204042", "110203075", "110201050", "110201051", "110201052", "110201053", "120201002", "110105029", "110203056", "110204043", "110203103", "110203090", "110103018", "110106004", "110106005", "110106006", "110205028", "110105012", "120204005", "110205013", "110201054", "110101044", "110204044", "110203057", "110203058", "120206002", "610811002", "610806001", "610807001", "610805002", "610810001", "610803001", "610812002", "610806004", "610812003", "610806005", "610811003", "610810002", "610807002", "610805003", "610812004", "610812005", "610806002", "610812006", "120206004", "330101004", "110204045", "110204046", "110201063", "110204055", "110206013", "110203059", "110203060", "611101001", "611101002", "611101003", "611101004", "611101005", "611101006", "610101001", "610401001", "610906001", "610813001", "611203001", "610905002", "610905003", "610905004", "610905005", "110206015", "110206014", "110204052", "110205015", "110205014", "611105001", "611105002", "611105003", "611105004", "611105005", "110204047", "611203003", "110205016", "110203061", "110205017", "110204054", "110106009", "110203062", "110206016", "120205007", "120201003", "620101006", "120205008", "120204006", "110201055", "110201056", "110201057", "110103016", "110205018", "110107005", "330201002", "620504001", "620503001", "110101034", "110107004", "610101007", "610101008", "110105014", "110205019", "110103012", "110203063", "611004001", "611004002", "611004003", "611004004", "120204007", "110204048", "110105013", "110204049", "110206017", "110109001", "110107006", "110203100", "110206027", "120207006", "110201059", "110201058", "640301001", "110101035", "611002001", "611002002", "611002003", "110101036", "611205001", "110206022", "110101037", "110202010", "110205020", "120207005", "110206018", "110108006", "611005001", "611005002", "110203076", "110205021", "330201003", "130101001", "110201060", "110203071", "611006001", "611006002", "611006003", "110203065", "110203064", "110206026", "110204050", "110203066", "110203067", "110201061", "110203068", "110105026", "110106008", "610902001", "610901001", "610901002", "610901003", "610902002", "610902003", "610901004", "" }));

        Grupo_texto.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N

        javax.swing.GroupLayout Painel_GeralLayout = new javax.swing.GroupLayout(Painel_Geral);
        Painel_Geral.setLayout(Painel_GeralLayout);
        Painel_GeralLayout.setHorizontalGroup(
            Painel_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel_GeralLayout.createSequentialGroup()
                .addGroup(Painel_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Painel_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Painel_GeralLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(Codigo)
                            .addGap(25, 25, 25))
                        .addComponent(Marca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Painel_GeralLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(Tributacao))
                    .addGroup(Painel_GeralLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(Painel_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Descricao)
                            .addComponent(Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Painel_GeralLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(Grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Painel_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Grupo_texto)
                    .addComponent(Marca_selecao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Nome_texto)
                    .addComponent(Descricao_texto)
                    .addGroup(Painel_GeralLayout.createSequentialGroup()
                        .addGroup(Painel_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Painel_GeralLayout.createSequentialGroup()
                                .addComponent(Cod_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(CodBarra)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CodBarra_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CodAlter)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CodAlter_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Painel_GeralLayout.createSequentialGroup()
                                .addComponent(Tributacao_selecao, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NCM)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NCM_selecao, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(ANP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ANP_selecao, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        Painel_GeralLayout.setVerticalGroup(
            Painel_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel_GeralLayout.createSequentialGroup()
                .addGroup(Painel_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CodAlter)
                    .addComponent(CodAlter_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Codigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CodBarra)
                    .addComponent(CodBarra_texto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cod_texto))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(Painel_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nome_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(Painel_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Descricao_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(Painel_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel_GeralLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(Painel_GeralLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(Grupo_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)))
                .addGroup(Painel_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Marca)
                    .addComponent(Marca_selecao))
                .addGroup(Painel_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Painel_GeralLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(Tributacao))
                    .addGroup(Painel_GeralLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(Painel_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Painel_GeralLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(Painel_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ANP)
                                    .addComponent(ANP_selecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(Painel_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(NCM)
                                .addComponent(Tributacao_selecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(NCM_selecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/left_squared_filled_50px_1.png"))); // NOI18N
        jButton3.setMnemonic('V');
        jButton3.setText("Voltar");
        jButton3.setToolTipText("Voltar");
        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/left_squared_filled_50px_3.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save_as_filled_50px_2.png"))); // NOI18N
        jButton4.setMnemonic('S');
        jButton4.setText("Salvar");
        jButton4.setToolTipText("Salvar");
        jButton4.setBorder(null);
        jButton4.setContentAreaFilled(false);
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save_as_filled_50px.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_broom_50px.png"))); // NOI18N
        jButton5.setMnemonic('L');
        jButton5.setText("Limpar");
        jButton5.setToolTipText("LImpar os campos.");
        jButton5.setBorder(null);
        jButton5.setContentAreaFilled(false);
        jButton5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_broom_50px_1.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        Painel_Preco.setBackground(new java.awt.Color(255, 255, 255));
        Painel_Preco.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Preço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 14))); // NOI18N
        Painel_Preco.setOpaque(false);

        Painel_Preco_AVista.setBackground(new java.awt.Color(255, 255, 255));
        Painel_Preco_AVista.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "AVista", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 14))); // NOI18N

        AVista_Lucro_texto.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        AVista_Lucro_texto.setToolTipText("Nome Completo do Cliente.");
        AVista_Lucro_texto.setAutoscrolls(false);

        AVista_Venda_texto.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        AVista_Venda_texto.setToolTipText("Nome Completo do Cliente.");
        AVista_Venda_texto.setAutoscrolls(false);

        AVista_Minimo_texto.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        AVista_Minimo_texto.setToolTipText("Nome Completo do Cliente.");
        AVista_Minimo_texto.setAutoscrolls(false);

        AVista_Venda.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        AVista_Venda.setText("R$ Venda");
        AVista_Venda.setToolTipText("Nome Completo do Cliente.");

        AVista_Lucro.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        AVista_Lucro.setText("R$ Lucro");
        AVista_Lucro.setToolTipText("Nome Completo do Cliente.");

        AVista_Minimo.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        AVista_Minimo.setText("R$ Minimo");
        AVista_Minimo.setToolTipText("Nome Completo do Cliente.");

        javax.swing.GroupLayout Painel_Preco_AVistaLayout = new javax.swing.GroupLayout(Painel_Preco_AVista);
        Painel_Preco_AVista.setLayout(Painel_Preco_AVistaLayout);
        Painel_Preco_AVistaLayout.setHorizontalGroup(
            Painel_Preco_AVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel_Preco_AVistaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Painel_Preco_AVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Painel_Preco_AVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(Painel_Preco_AVistaLayout.createSequentialGroup()
                            .addComponent(AVista_Minimo)
                            .addGap(10, 10, 10)
                            .addComponent(AVista_Minimo_texto))
                        .addGroup(Painel_Preco_AVistaLayout.createSequentialGroup()
                            .addComponent(AVista_Lucro, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(AVista_Lucro_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Painel_Preco_AVistaLayout.createSequentialGroup()
                        .addComponent(AVista_Venda, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AVista_Venda_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        Painel_Preco_AVistaLayout.setVerticalGroup(
            Painel_Preco_AVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel_Preco_AVistaLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(Painel_Preco_AVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AVista_Venda_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AVista_Venda, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(Painel_Preco_AVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AVista_Lucro_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AVista_Lucro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(Painel_Preco_AVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AVista_Minimo_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AVista_Minimo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90))
        );

        Painel_Preco_APrazo.setBackground(new java.awt.Color(255, 255, 255));
        Painel_Preco_APrazo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "A Prazo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 14))); // NOI18N

        APrazo_Venda.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        APrazo_Venda.setText("R$ Venda");
        APrazo_Venda.setToolTipText("Nome Completo do Cliente.");

        APrazo_Lucro.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        APrazo_Lucro.setText("R$ Lucro");
        APrazo_Lucro.setToolTipText("Nome Completo do Cliente.");

        APrazo_Minimo.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        APrazo_Minimo.setText("R$ Minimo");
        APrazo_Minimo.setToolTipText("Nome Completo do Cliente.");

        APrazo_Minimo_texto.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        APrazo_Minimo_texto.setToolTipText("Nome Completo do Cliente.");
        APrazo_Minimo_texto.setAutoscrolls(false);

        APrazo_Venda_texto.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        APrazo_Venda_texto.setToolTipText("Nome Completo do Cliente.");
        APrazo_Venda_texto.setAutoscrolls(false);

        APrazo_Lucro_texto.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        APrazo_Lucro_texto.setToolTipText("Nome Completo do Cliente.");
        APrazo_Lucro_texto.setAutoscrolls(false);

        javax.swing.GroupLayout Painel_Preco_APrazoLayout = new javax.swing.GroupLayout(Painel_Preco_APrazo);
        Painel_Preco_APrazo.setLayout(Painel_Preco_APrazoLayout);
        Painel_Preco_APrazoLayout.setHorizontalGroup(
            Painel_Preco_APrazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel_Preco_APrazoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Painel_Preco_APrazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(APrazo_Lucro, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Painel_Preco_APrazoLayout.createSequentialGroup()
                        .addGroup(Painel_Preco_APrazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(APrazo_Minimo)
                            .addComponent(APrazo_Venda, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Painel_Preco_APrazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(APrazo_Venda_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(APrazo_Lucro_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(APrazo_Minimo_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        Painel_Preco_APrazoLayout.setVerticalGroup(
            Painel_Preco_APrazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel_Preco_APrazoLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(Painel_Preco_APrazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(APrazo_Venda, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(APrazo_Venda_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(Painel_Preco_APrazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(APrazo_Lucro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(APrazo_Lucro_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(Painel_Preco_APrazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(APrazo_Minimo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(APrazo_Minimo_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91))
        );

        javax.swing.GroupLayout Painel_PrecoLayout = new javax.swing.GroupLayout(Painel_Preco);
        Painel_Preco.setLayout(Painel_PrecoLayout);
        Painel_PrecoLayout.setHorizontalGroup(
            Painel_PrecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel_PrecoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(Painel_Preco_AVista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Painel_Preco_APrazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        Painel_PrecoLayout.setVerticalGroup(
            Painel_PrecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel_PrecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Painel_PrecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Painel_Preco_APrazo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Painel_Preco_AVista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_delete_filled_50px_2.png"))); // NOI18N
        jButton8.setMnemonic('D');
        jButton8.setText("Deletar");
        jButton8.setToolTipText("Deletar Cadastro");
        jButton8.setBorder(null);
        jButton8.setContentAreaFilled(false);
        jButton8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_delete_filled_50px_3.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_update_file_48px.png"))); // NOI18N
        jButton11.setMnemonic('S');
        jButton11.setText("Atualizar");
        jButton11.setToolTipText("Salvar");
        jButton11.setBorder(null);
        jButton11.setContentAreaFilled(false);
        jButton11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_update_file_48px_2.png"))); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(75, 75, 75)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8)
                        .addGap(17, 17, 17)
                        .addComponent(jButton11))
                    .addComponent(Painel_Preco, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Painel_Geral, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton3)
                            .addComponent(jButton5)
                            .addComponent(jButton8))
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton11)
                        .addGap(14, 14, 14)))
                .addComponent(Painel_Geral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Painel_Preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jButton11.getAccessibleContext().setAccessibleDescription("");

        jLayeredPane2.setLayer(jPanel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jButton2.setBackground(new java.awt.Color(245, 245, 245));
        jButton2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add_50px.png"))); // NOI18N
        jButton2.setText("Adicionar");
        jButton2.setToolTipText("Física ou Juridica");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setOpaque(true);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add_50px_1.png"))); // NOI18N
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(245, 245, 245));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search_50px.png"))); // NOI18N
        jButton1.setToolTipText("Pesquisar");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setOpaque(true);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search_50px_1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Pesquisar");

        jButton6.setBackground(new java.awt.Color(245, 245, 245));
        jButton6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_print_filled_100px.png"))); // NOI18N
        jButton6.setText("Imprimir");
        jButton6.setBorder(null);
        jButton6.setContentAreaFilled(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setMaximumSize(new java.awt.Dimension(57, 70));
        jButton6.setMinimumSize(new java.awt.Dimension(57, 70));
        jButton6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_print_filled_100px_1.png"))); // NOI18N
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel0Layout = new javax.swing.GroupLayout(jPanel0);
        jPanel0.setLayout(jPanel0Layout);
        jPanel0Layout.setHorizontalGroup(
            jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel0Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel2)
                    .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLayeredPane2))
        );
        jPanel0Layout.setVerticalGroup(
            jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel0Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLayeredPane2)
        );

        jPanel12.setBackground(new java.awt.Color(51, 51, 255));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Produtos");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(569, 569, 569)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtext.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jtext.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 255), null));
        jtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtextActionPerformed(evt);
            }
        });
        jtext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtextKeyReleased(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        Table.setAutoCreateRowSorter(true);
        Table.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Table.setAutoscrolls(false);
        Table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Table.setDoubleBuffered(true);
        Table.setDragEnabled(true);
        Table.setFillsViewportHeight(true);
        Table.setFocusCycleRoot(true);
        Table.setFocusTraversalPolicyProvider(true);
        Table.setInheritsPopupMenu(true);
        Table.setMaximumSize(new java.awt.Dimension(32767, 32767));
        Table.setSurrendersFocusOnKeystroke(true);
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addGap(26, 26, 26))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jPanel0, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtext, javax.swing.GroupLayout.PREFERRED_SIZE, 1087, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtext, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(menuDisplay == true){
            menuDisplay = false;

            getjPanel5().setSize(0, getHeight());
            getjLayeredPane2().setSize(0,getHeight());
            getjPanel0().setSize(70,getHeight());
            limpacampos();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        salvar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        limpacampos();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        delete();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        /*if(menuDisplay == true){
            menuDisplay = false;
            jLayeredPane2.setSize(0, getHeight());
            jPanel5.setSize(0, getHeight());
            jPanel0.setSize(70,getHeight());
        }*/
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(menuDisplay == false ){
            menuDisplay = true;

            getjPanel5().setSize(1980, getHeight());
            getjLayeredPane2().setSize(1980,getHeight());
            getjPanel0().setSize(1980,getHeight());
            menuDisplay1 = false;
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        mostrar();
        if(menuDisplay = true){
            menuDisplay = false;

            getjPanel5().setSize(0, getHeight());
            getjLayeredPane2().setSize(0,getHeight());
            getjPanel0().setSize(70,getHeight());
        }
        if(menuDisplay1 = true){
            menuDisplay1 = false;

            getjPanel5().setSize(0, getHeight());
            getjLayeredPane2().setSize(0,getHeight());
            getjPanel0().setSize(70,getHeight());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtextActionPerformed

    private void jtextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextKeyReleased
        pesquisa_usuario();
    }//GEN-LAST:event_jtextKeyReleased

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
           if(menuDisplay == false ){
            menuDisplay = true;
           
            jPanel5.setSize(1980, getHeight());
            jLayeredPane2.setSize(1980,getHeight());
            jPanel0.setSize(1980,getHeight());
            menuDisplay1 = false;
            setar();
        }      
    }//GEN-LAST:event_TableMouseClicked

    private void CodAlter_textoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CodAlter_textoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_CodAlter_textoKeyReleased

    private void CodBarra_textoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CodBarra_textoKeyReleased
       // ImageIcon imageIcon=new ImageIcon(new ImageIcon("C:/Imagem/"+CodBarra_texto.getText()+".jpg").getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT));
       // Label_Image.setIcon(imageIcon);

        // TODO add your handling code here:
    }//GEN-LAST:event_CodBarra_textoKeyReleased

    private void CodBarra_textoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodBarra_textoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodBarra_textoActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
Atualizar();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       int confirma = JOptionPane.showConfirmDialog(null,"Confirma a impressão deste relatório","Atenção",JOptionPane.YES_NO_OPTION);
        if(confirma == JOptionPane.YES_OPTION){
            try {
                JasperPrint print = JasperFillManager.fillReport("C:\\Reports\\Produtos.jasper",null,con);
                JasperViewer viewer = new JasperViewer(print, false);
                viewer.show();
                viewer.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ANP;
    private javax.swing.JComboBox<String> ANP_selecao;
    private javax.swing.JLabel APrazo_Lucro;
    private javax.swing.JTextField APrazo_Lucro_texto;
    private javax.swing.JLabel APrazo_Minimo;
    private javax.swing.JTextField APrazo_Minimo_texto;
    private javax.swing.JLabel APrazo_Venda;
    private javax.swing.JTextField APrazo_Venda_texto;
    private javax.swing.JLabel AVista_Lucro;
    private javax.swing.JTextField AVista_Lucro_texto;
    private javax.swing.JLabel AVista_Minimo;
    private javax.swing.JTextField AVista_Minimo_texto;
    private javax.swing.JLabel AVista_Venda;
    private javax.swing.JTextField AVista_Venda_texto;
    private javax.swing.JLabel CodAlter;
    private javax.swing.JFormattedTextField CodAlter_texto;
    private javax.swing.JLabel CodBarra;
    private javax.swing.JTextField CodBarra_texto;
    private javax.swing.JFormattedTextField Cod_texto;
    private javax.swing.JLabel Codigo;
    private javax.swing.JLabel Descricao;
    private javax.swing.JTextField Descricao_texto;
    private javax.swing.JLabel Grupo;
    private javax.swing.JTextField Grupo_texto;
    private javax.swing.JLabel Marca;
    private javax.swing.JComboBox<String> Marca_selecao;
    private javax.swing.JLabel NCM;
    private javax.swing.JComboBox<String> NCM_selecao;
    private javax.swing.JLabel Nome;
    private javax.swing.JTextField Nome_texto;
    private javax.swing.JPanel Painel_Geral;
    private javax.swing.JPanel Painel_Preco;
    private javax.swing.JPanel Painel_Preco_APrazo;
    private javax.swing.JPanel Painel_Preco_AVista;
    private javax.swing.JTable Table;
    private javax.swing.JLabel Tributacao;
    private javax.swing.JComboBox<String> Tributacao_selecao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel0;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtext;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the Apelido
     */
   

    /**
     * @param Apelido the Apelido to set
     */
  
    /**
     * @return the CPFCNPJ
     */
 

    /**
     * @return the Celular
     */
  

    /**
     * @param Celular the Celular to set
     */
   
    /**
     * @return the Cod
     */
   

    /**
     * @param Cod the Cod to set
     */
    public void setCod(javax.swing.JFormattedTextField Cod) {
        this.Grupo_texto = Cod;
    }

    /**
     * @return the Email
     */
  

    /**
     * @param Email the Email to set
     */
   

    /**
     * @return the Fone
     */
   

    /**
     * @param Fone the Fone to set
     */
   
    /**
     * @return the IE
     */
    

    /**
     * @param IE the IE to set
     */
   

    /**
     * @return the Nome
     */
    public javax.swing.JTextField getNome() {
        return Descricao_texto;
    }

    /**
     * @param Nome the Nome to set
     */
    public void setNome(javax.swing.JTextField Nome) {
        this.Descricao_texto = Nome;
    }

    /**
     * @return the RG
     */
    public javax.swing.JFormattedTextField getRG() {
        return CodAlter_texto;
    }

    /**
     * @param RG the RG to set
     */
    public void setRG(javax.swing.JFormattedTextField RG) {
        this.CodAlter_texto = RG;
    }

    /**
     * @return the Table
     */
    public javax.swing.JTable getTable() {
        return Table;
    }

    /**
     * @param Table the Table to set
     */
    public void setTable(javax.swing.JTable Table) {
        this.Table = Table;
    }

    /**
     * @return the Tipo
     */
   

    /**
     * @param Tipo_IE the Tipo_IE to set
     */
 

    /**
     * @return the jButton1
     */
    public javax.swing.JButton getjButton1() {
        return jButton1;
    }

    /**
     * @param jButton1 the jButton1 to set
     */
    public void setjButton1(javax.swing.JButton jButton1) {
        this.jButton1 = jButton1;
    }

    /**
     * @return the jButton2
     */
    public javax.swing.JButton getjButton2() {
        return jButton2;
    }

    /**
     * @param jButton2 the jButton2 to set
     */
    public void setjButton2(javax.swing.JButton jButton2) {
        this.jButton2 = jButton2;
    }

    /**
     * @return the jButton3
     */
    public javax.swing.JButton getjButton3() {
        return jButton3;
    }

    /**
     * @param jButton3 the jButton3 to set
     */
    public void setjButton3(javax.swing.JButton jButton3) {
        this.jButton3 = jButton3;
    }

    /**
     * @return the jButton4
     */
    public javax.swing.JButton getjButton4() {
        return jButton4;
    }

    /**
     * @param jButton4 the jButton4 to set
     */
    public void setjButton4(javax.swing.JButton jButton4) {
        this.jButton4 = jButton4;
    }

    /**
     * @return the jButton5
     */
    public javax.swing.JButton getjButton5() {
        return jButton5;
    }

    /**
     * @param jButton5 the jButton5 to set
     */
    public void setjButton5(javax.swing.JButton jButton5) {
        this.jButton5 = jButton5;
    }

    /**
     * @return the jButton8
     */
    public javax.swing.JButton getjButton8() {
        return jButton8;
    }

    /**
     * @param jButton8 the jButton8 to set
     */
    public void setjButton8(javax.swing.JButton jButton8) {
        this.jButton8 = jButton8;
    }

    /**
     * @return the jComboBox1
     */
 

    /**
     * @return the jLabel1
     */
    public javax.swing.JLabel getjLabel1() {
        return jLabel1;
    }

    /**
     * @param jLabel1 the jLabel1 to set
     */
    public void setjLabel1(javax.swing.JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    /**
     * @return the jLabel10
     */
  

    /**
     * @return the jLabel18
     */
    public javax.swing.JLabel getjLabel18() {
        return Codigo;
    }

    /**
     * @param jLabel18 the jLabel18 to set
     */
    public void setjLabel18(javax.swing.JLabel jLabel18) {
        this.Codigo = jLabel18;
    }

    /**
     * @return the jLabel19
     */
    public javax.swing.JLabel getjLabel19() {
        return Nome;
    }

    /**
     * @param jLabel19 the jLabel19 to set
     */
    public void setjLabel19(javax.swing.JLabel jLabel19) {
        this.Nome = jLabel19;
    }

    /**
     * @return the jLabel2
     */
    public javax.swing.JLabel getjLabel2() {
        return jLabel2;
    }

    /**
     * @param jLabel2 the jLabel2 to set
     */
    public void setjLabel2(javax.swing.JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    /**
     * @return the jLabel21
     */
    public javax.swing.JLabel getjLabel21() {
        return CodAlter;
    }

    /**
     * @param jLabel21 the jLabel21 to set
     */
    public void setjLabel21(javax.swing.JLabel jLabel21) {
        this.CodAlter = jLabel21;
    }

    /**
     * @return the jLabel22
     */
   
    /**
     * @return the jLabel3
     */
    public javax.swing.JLabel getjLabel3() {
        return CodBarra;
    }

    /**
     * @param jLabel3 the jLabel3 to set
     */
    public void setjLabel3(javax.swing.JLabel jLabel3) {
        this.CodBarra = jLabel3;
    }

    /**
     * @return the jLabel4
     */
    

    /**
     * @return the jLayeredPane2
     */
    public javax.swing.JLayeredPane getjLayeredPane2() {
        return jLayeredPane2;
    }

    /**
     * @param jLayeredPane2 the jLayeredPane2 to set
     */
    public void setjLayeredPane2(javax.swing.JLayeredPane jLayeredPane2) {
        this.jLayeredPane2 = jLayeredPane2;
    }

    /**
     * @return the jPanel0
     */
    public javax.swing.JPanel getjPanel0() {
        return jPanel0;
    }

    /**
     * @param jPanel0 the jPanel0 to set
     */
    public void setjPanel0(javax.swing.JPanel jPanel0) {
        this.jPanel0 = jPanel0;
    }

    /**
     * @return the jPanel1
     */
    public javax.swing.JPanel getjPanel1() {
        return jPanel1;
    }

    /**
     * @param jPanel1 the jPanel1 to set
     */
    public void setjPanel1(javax.swing.JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    /**
     * @return the jPanel12
     */
    public javax.swing.JPanel getjPanel12() {
        return jPanel12;
    }

    /**
     * @param jPanel12 the jPanel12 to set
     */
    public void setjPanel12(javax.swing.JPanel jPanel12) {
        this.jPanel12 = jPanel12;
    }

    /**
     * @return the jPanel2
     */
    public javax.swing.JPanel getjPanel2() {
        return Painel_Geral;
    }

    /**
     * @param jPanel2 the jPanel2 to set
     */
    public void setjPanel2(javax.swing.JPanel jPanel2) {
        this.Painel_Geral = jPanel2;
    }

    /**
     * @return the jPanel3
     */
    public javax.swing.JPanel getjPanel3() {
        return jPanel3;
    }

    /**
     * @param jPanel3 the jPanel3 to set
     */
    public void setjPanel3(javax.swing.JPanel jPanel3) {
        this.jPanel3 = jPanel3;
    }

    /**
     * @return the jPanel4
     */
    public javax.swing.JPanel getjPanel4() {
        return Painel_Preco_AVista;
    }

    /**
     * @param jPanel4 the jPanel4 to set
     */
    public void setjPanel4(javax.swing.JPanel jPanel4) {
        this.Painel_Preco_AVista = jPanel4;
    }

    /**
     * @return the jPanel5
     */
    public javax.swing.JPanel getjPanel5() {
        return jPanel5;
    }

    /**
     * @param jPanel5 the jPanel5 to set
     */
    public void setjPanel5(javax.swing.JPanel jPanel5) {
        this.jPanel5 = jPanel5;
    }

    /**
     * @return the jPanel6
     */
    public javax.swing.JPanel getjPanel6() {
        return Painel_Preco;
    }

    /**
     * @param jPanel6 the jPanel6 to set
     */
    public void setjPanel6(javax.swing.JPanel jPanel6) {
        this.Painel_Preco = jPanel6;
    }

    /**
     * @return the jScrollPane1
     */
    public javax.swing.JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    /**
     * @param jScrollPane1 the jScrollPane1 to set
     */
    public void setjScrollPane1(javax.swing.JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    /**
     * @return the jTextField1
     */
    public javax.swing.JTextField getjTextField1() {
        return Grupo_texto;
    }

    /**
     * @param jTextField1 the jTextField1 to set
     */
    public void setjTextField1(javax.swing.JTextField jTextField1) {
        this.Grupo_texto = jTextField1;
    }

    /**
     * @return the jTextField2
     */
    

    /**
     * @return the jtext
     */
    public javax.swing.JTextField getJtext() {
        return jtext;
    }

    /**
     * @param jtext the jtext to set
     */
    public void setJtext(javax.swing.JTextField jtext) {
        this.jtext = jtext;
    }
}
