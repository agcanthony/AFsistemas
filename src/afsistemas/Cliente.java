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
import java.awt.event.*;
import javax.swing.JFrame;
import java.awt.*;
import afsistemas.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Cliente extends javax.swing.JPanel {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public Cliente() {
       //setExtendedState(MAXIMIZED_BOTH); 
       initComponents();
       jButton8.setEnabled(false);
       
       try {
            con = Bdados.Bdados();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        mostrar();
    }
    boolean menuDisplay = false;
    boolean menuDisplay1 = false;
   
    public void mostrar(){
        String sql = "SELECT * From cliente";
        
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
        String sql = "SELECT * From cliente where Nome like ?";
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
        String sql = "INSERT INTO cliente (Nome,Tipo,CPFCNPJ,RG,Tipo_IE,IE,Razao_Social,Fone,Celular,Whatsapp,Email,Cep,Endereco,Numero,Cidade,Estado,Bairro,Descri)"+"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            
            ps.setString(1, Nome.getText());
            ps.setString(2, (String) Tipo.getSelectedItem());
            ps.setString(3, CPFCNPJ.getText());
            ps.setString(4, RG.getText());
            ps.setString(5, (String) Tipo_IE.getSelectedItem());
            ps.setString(6, IE.getText());
            ps.setString(7, Razao.getText());
            ps.setString(8, Fone.getText());
            ps.setString(9, Celular.getText());
            ps.setString(10, Whatsapp.getText());
            ps.setString(11, Email.getText());
            ps.setString(12, Cep.getText());
            ps.setString(13, Endereco.getText());
            ps.setString(14, Numero.getText());
            ps.setString(15, Cidade.getText());
            ps.setString(16, (String) Estado.getSelectedItem());
            ps.setString(17, Bairro.getText());
            ps.setString(18, Descri.getText());
            
            
            
            Nome.setText("");
            Tipo.setSelectedItem("");
            CPFCNPJ.setText("");
            RG.setText("");
            Tipo_IE.setSelectedItem("");
            IE.setText("");
            Razao.setText("");
            Fone.setText("");
            Celular.setText("");
            Whatsapp.setText("");
            Email.setText("");
            Cep.setText("");
            Endereco.setText("");
            Numero.setText("");
            Cidade.setText("");
            Estado.setSelectedItem("");
            Bairro.setText("");
            Descri.setText("");
            
            
            
            
            ps.execute();
            ps.close();
            
            JOptionPane.showMessageDialog(null,"Cliente cadastrado");
            
        } catch (SQLException error){
            JOptionPane.showMessageDialog(null,error);
        }
        
    }
    
    public void setar(){
        
        int setar = Table.getSelectedRow();
        jButton8.setEnabled(true);
        Cod.setText(Table.getModel().getValueAt(setar, 0).toString());
        Nome.setText(Table.getModel().getValueAt(setar, 1).toString());
        Tipo.setSelectedItem(Table.getModel().getValueAt(setar, 2).toString());
        CPFCNPJ.setText(Table.getModel().getValueAt(setar, 3).toString());
        RG.setText(Table.getModel().getValueAt(setar, 4).toString());        
        Tipo_IE.setSelectedItem(Table.getModel().getValueAt(setar, 5).toString());               
        IE.setText(Table.getModel().getValueAt(setar, 6).toString());
        Razao.setText(Table.getModel().getValueAt(setar, 7).toString());
        Fone.setText(Table.getModel().getValueAt(setar, 8).toString());
        Celular.setText(Table.getModel().getValueAt(setar, 9).toString());
        Whatsapp.setText(Table.getModel().getValueAt(setar, 10).toString());
        Email.setText(Table.getModel().getValueAt(setar, 11).toString());
        Cep.setText(Table.getModel().getValueAt(setar, 12).toString());
        Endereco.setText(Table.getModel().getValueAt(setar, 13).toString());
        Numero.setText(Table.getModel().getValueAt(setar, 14).toString());
        Cidade.setText(Table.getModel().getValueAt(setar, 15).toString());
        Estado.setSelectedItem(Table.getModel().getValueAt(setar, 16).toString());
        Bairro.setText(Table.getModel().getValueAt(setar, 17).toString());
        Descri.setText(Table.getModel().getValueAt(setar, 18).toString());
    
    }
    
    public void limpacampos(){
            Nome.setText("");
            Tipo.setSelectedItem("");
            CPFCNPJ.setText("");
            RG.setText("");
            Tipo_IE.setSelectedItem("");
            IE.setText("");
            Razao.setText("");
            Fone.setText("");
            Celular.setText("");
            Whatsapp.setText("");
            Email.setText("");
            Cep.setText("");
            Endereco.setText("");
            Numero.setText("");
            Cidade.setText("");
            Estado.setSelectedItem("");            
            Bairro.setText("");
            Descri.setText("");
    }
    
    public void delete(){
        String sql = "DELETE from cliente where Nome='"+Nome.getText()+"'";
        
        try {
            ps = con.prepareStatement(sql);
            Cod.getText();
            
            
            ps.executeUpdate();
            ps.close();
            
            JOptionPane.showMessageDialog(null,"Excluido com Sucesso");
        } catch (SQLException error) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, error);
        }
        limpacampos();
        jButton8.setEnabled(false);
            
    }
    public void Atualizar(){
        String sql="UPDATE cliente SET Nome=?,Tipo=?,CPFCNPJ=?,RG=?,Tipo_IE=?,IE=?,Razao_Social=?,Fone=?,Celular=?,Whatsapp=?,Email=?,Cep=?,Endereco=?,Numero=?,Cidade=?,Estado=?,Bairro=?,Descri=? where Cod=?";
         try{
         
         ps=con.prepareStatement(sql);
         
            ps.setString(1, Nome.getText());
            ps.setString(2, (String) Tipo.getSelectedItem());
            ps.setString(3, CPFCNPJ.getText());
            ps.setString(4, RG.getText());
            ps.setString(5, (String) Tipo_IE.getSelectedItem());
            ps.setString(6, IE.getText());
            ps.setString(7, Razao.getText());
            ps.setString(8, Fone.getText());
            ps.setString(9, Celular.getText());
            ps.setString(10, Whatsapp.getText());
            ps.setString(11, Email.getText());
            ps.setString(12, Cep.getText());
            ps.setString(13, Endereco.getText());
            ps.setString(14, Numero.getText());
            ps.setString(15, Cidade.getText());
            ps.setString(16, (String) Estado.getSelectedItem());
            ps.setString(17, Bairro.getText());
            ps.setString(18, Descri.getText());
            
            ps.setString(19,Cod.getText());
         
       
         ps.executeUpdate();
         ps.close();
    
     JOptionPane.showMessageDialog(null, "Atualizacao Concluida");
     }
         catch(SQLException error){
             
               JOptionPane.showMessageDialog(null, error);
         }
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
        jPanel4 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        Fone = new javax.swing.JFormattedTextField();
        jLabel26 = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        Celular = new javax.swing.JFormattedTextField();
        jLabel28 = new javax.swing.JLabel();
        Whatsapp = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        Cod = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        Nome = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        RG = new javax.swing.JFormattedTextField();
        jLabel22 = new javax.swing.JLabel();
        Razao = new javax.swing.JTextField();
        Tipo_IE = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        IE = new javax.swing.JFormattedTextField();
        Tipo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        CPFCNPJ = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        Cep = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        Endereco = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Bairro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Cidade = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Estado = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        Numero = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Descri = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtext = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        setDoubleBuffered(false);
        setFocusCycleRoot(true);
        setMaximumSize(new java.awt.Dimension(1280, 800));
        setPreferredSize(new java.awt.Dimension(1146, 517));

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

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contato", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 14))); // NOI18N

        jLabel25.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel25.setText("FONE");

        try {
            Fone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Fone.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel26.setText("E-MAIL");
        jLabel26.setToolTipText("E-MAIL");

        Email.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Email.setToolTipText("E-MAIL.");

        jLabel27.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel27.setText("CELULAR");
        jLabel27.setToolTipText("CELULAR");

        try {
            Celular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Celular.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N

        jLabel28.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel28.setText("WHATSAPP");
        jLabel28.setToolTipText("WHATSAPP");

        try {
            Whatsapp.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Whatsapp.setToolTipText("WHATSAPP");
        Whatsapp.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Whatsapp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WhatsappActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(35, 35, 35)
                        .addComponent(Fone, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel27)
                        .addGap(26, 26, 26)
                        .addComponent(Celular, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel28)
                        .addGap(18, 18, 18)
                        .addComponent(Whatsapp, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Whatsapp)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25)
                        .addComponent(Fone, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel27))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Celular)
                        .addComponent(jLabel28)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Geral", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 14))); // NOI18N
        jPanel2.setDoubleBuffered(false);
        jPanel2.setFocusCycleRoot(true);
        jPanel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanel2.setInheritsPopupMenu(true);

        jLabel18.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel18.setText("CODIGO");

        Cod.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("00000"))));
        Cod.setEnabled(false);
        Cod.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel19.setText("NOME");
        jLabel19.setToolTipText("Nome Completo do Cliente.");

        Nome.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Nome.setToolTipText("Nome Completo do Cliente.");
        Nome.setAutoscrolls(false);

        jLabel21.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel21.setText("RG");

        try {
            RG.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        RG.setAutoscrolls(false);
        RG.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel22.setText("RAZÃO SOCIAL");

        Razao.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N

        Tipo_IE.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        Tipo_IE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "CONTRIBUINTE", "ISENTO", "NÃO CONTRIBUINTE" }));

        jLabel23.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel23.setText("TIPO IE");

        jLabel24.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel24.setText("IE");
        jLabel24.setToolTipText("INSCRIÇÃO ESTADUAL.");

        try {
            IE.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###.###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        IE.setToolTipText("INSCRIÇÃO ESTADUAL.");
        IE.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        IE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IEActionPerformed(evt);
            }
        });

        Tipo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        Tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "CPF", "CNPJ" }));
        Tipo.setToolTipText("CPF OU CNPJ");
        Tipo.setPreferredSize(new java.awt.Dimension(172, 27));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel3.setText("TIPO");
        jLabel3.setToolTipText("CPF OU CNPJ");

        CPFCNPJ.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        CPFCNPJ.setToolTipText("CPF OU CNPJ");
        CPFCNPJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPFCNPJActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Cod, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CPFCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21))
                    .addComponent(Nome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(RG, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Tipo_IE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IE, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Razao)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cod)
                    .addComponent(jLabel21)
                    .addComponent(RG, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tipo_IE, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(IE, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(CPFCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22)
                    .addComponent(Razao, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
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
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_update_file_48px.png"))); // NOI18N
        jButton4.setMnemonic('S');
        jButton4.setText("Atualizar");
        jButton4.setToolTipText("Salvar");
        jButton4.setBorder(null);
        jButton4.setContentAreaFilled(false);
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_update_file_48px_2.png"))); // NOI18N
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

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 14))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel4.setText("CEP");

        try {
            Cep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Cep.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel5.setText("ENDEREÇO");

        Endereco.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Endereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnderecoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel6.setText("BAIRRO");

        Bairro.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel7.setText("CIDADE");

        Cidade.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel8.setText("UF");

        Estado.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        Estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Acre - AC", "Alagoas - AL", "Amapá - AP", "Amazonas - AM", "Bahia - BA", "Ceará - CE", "Distrito Federal - DF", "Espírito Santo - ES", "Goiás - GO", "Maranhão - MA", "Mato Grosso- MT", "Mato Grosso do Sul - MS", "Minas Gerais - MG", "Pará - PA", "Paraíba - PB", "Paraná- PR", "Pernambuco - PE", "Piauí - PI", "Rio de Janeiro - RJ", "Rio Grande do Norte - RN", "Rio Grande do Sul - RS", "Rondônia - RO", "Roraima - RR", "Santa Catarina - SC", "São Paulo - SP", "Sergipe - SE", "Tocantins - TO" }));

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel9.setText("NUMERO");
        jLabel9.setToolTipText("");

        Numero.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel10.setText("COMPLEMENTO");

        Descri.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(Cep, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(Cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(Bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(Descri, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(Endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(Numero, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(Cep, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Estado, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(Numero, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(Descri, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

        jButton6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save_as_filled_50px_2.png"))); // NOI18N
        jButton6.setMnemonic('S');
        jButton6.setText("Salvar");
        jButton6.setToolTipText("Salvar");
        jButton6.setBorder(null);
        jButton6.setContentAreaFilled(false);
        jButton6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save_as_filled_50px.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(87, 87, 87)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3)
                    .addComponent(jButton5)
                    .addComponent(jButton8)
                    .addComponent(jButton6))
                .addGap(16, 16, 16)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jLayeredPane2.setLayer(jPanel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
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

        jButton7.setBackground(new java.awt.Color(245, 245, 245));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_print_filled_100px.png"))); // NOI18N
        jButton7.setText("Imprimir.");
        jButton7.setToolTipText("");
        jButton7.setBorder(null);
        jButton7.setContentAreaFilled(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_print_filled_100px_1.png"))); // NOI18N
        jButton7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
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
                        .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jButton7)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLayeredPane2)
        );

        jPanel12.setBackground(new java.awt.Color(51, 51, 255));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cliente");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jPanel0, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtext, javax.swing.GroupLayout.PREFERRED_SIZE, 1613, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(menuDisplay == false ){
            menuDisplay = true;
            
            jPanel5.setSize(1980, getHeight());
            jLayeredPane2.setSize(1980,getHeight());
            jPanel0.setSize(1980,getHeight());
            menuDisplay1 = false;
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    private void jtextActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    }
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         mostrar();
         if(menuDisplay = true){
         menuDisplay = false;
         
         jPanel5.setSize(0, getHeight());
         jLayeredPane2.setSize(0,getHeight());
         jPanel0.setSize(70,getHeight());
         }
         if(menuDisplay1 = true){
         menuDisplay1 = false;
         
         jPanel5.setSize(0, getHeight());
         jLayeredPane2.setSize(0,getHeight());
         jPanel0.setSize(70,getHeight());
         }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void IEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IEActionPerformed

    private void WhatsappActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WhatsappActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WhatsappActionPerformed

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        /*if(menuDisplay == true){
        menuDisplay = false;
        jLayeredPane2.setSize(0, getHeight());
        jPanel5.setSize(0, getHeight());
        jPanel0.setSize(70,getHeight());
        }*/
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(menuDisplay == true){
            menuDisplay = false;
            
            jPanel5.setSize(0, getHeight());
            jLayeredPane2.setSize(0,getHeight());
            jPanel0.setSize(70,getHeight()); 
            limpacampos();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       Atualizar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       limpacampos();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       delete();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void CPFCNPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPFCNPJActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CPFCNPJActionPerformed

    private void EnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EnderecoActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       salvar();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       int confirma = JOptionPane.showConfirmDialog(null,"Confirma a impressão deste relatório","Atenção",JOptionPane.YES_NO_OPTION);
        if(confirma == JOptionPane.YES_OPTION){
            try {
                JasperPrint print = JasperFillManager.fillReport("C:\\Reports\\Clientes.jasper",null,con);
                JasperViewer viewer = new JasperViewer(print, false);
                viewer.show();
                viewer.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField Bairro;
    public javax.swing.JTextField CPFCNPJ;
    public javax.swing.JFormattedTextField Celular;
    public javax.swing.JFormattedTextField Cep;
    public javax.swing.JTextField Cidade;
    public javax.swing.JFormattedTextField Cod;
    public javax.swing.JTextField Descri;
    public javax.swing.JTextField Email;
    public javax.swing.JTextField Endereco;
    public javax.swing.JComboBox<String> Estado;
    public javax.swing.JFormattedTextField Fone;
    public javax.swing.JFormattedTextField IE;
    public javax.swing.JTextField Nome;
    public javax.swing.JTextField Numero;
    public javax.swing.JFormattedTextField RG;
    public javax.swing.JTextField Razao;
    public javax.swing.JTable Table;
    public javax.swing.JComboBox<String> Tipo;
    public javax.swing.JComboBox<String> Tipo_IE;
    public javax.swing.JFormattedTextField Whatsapp;
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JButton jButton3;
    public javax.swing.JButton jButton4;
    public javax.swing.JButton jButton5;
    public javax.swing.JButton jButton6;
    public javax.swing.JButton jButton7;
    public javax.swing.JButton jButton8;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel18;
    public javax.swing.JLabel jLabel19;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel21;
    public javax.swing.JLabel jLabel22;
    public javax.swing.JLabel jLabel23;
    public javax.swing.JLabel jLabel24;
    public javax.swing.JLabel jLabel25;
    public javax.swing.JLabel jLabel26;
    public javax.swing.JLabel jLabel27;
    public javax.swing.JLabel jLabel28;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JLayeredPane jLayeredPane2;
    public javax.swing.JPanel jPanel0;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel12;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    public javax.swing.JPanel jPanel5;
    public javax.swing.JPanel jPanel6;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField jtext;
    // End of variables declaration//GEN-END:variables

}
