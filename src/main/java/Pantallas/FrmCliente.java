/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import Clases.Cliente;
import Clases.Persona;
import Clases.Tipo_Documento;
import JPAController.ClienteJpaController;
import JPAController.PersonaJpaController;
import JPAController.Tipo_DocumentoJpaController;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Usuario
 */
public class FrmCliente extends javax.swing.JFrame {

    /**
     * Creates new form Empleados
     */
    Tipo_DocumentoJpaController TipoDocumentodao = new Tipo_DocumentoJpaController();
    ClienteJpaController Clientedao = new ClienteJpaController();
    PersonaJpaController Personadao = new PersonaJpaController();

    public FrmCliente() {
        initComponents();
        
        this.setExtendedState(MAXIMIZED_BOTH);
        //jLabel5.setForeground(Color.WHITE);
        tpnNuevoDoc.setBackground(Color.CYAN);
        this.btnAgregar1.setBackground( new Color(14, 209, 69));
        setIconImage(new ImageIcon(getClass().getResource("/Img/CarSoft-removebg-preview.png")).getImage());
        this.btnSalir1.setBackground( new Color(236, 28, 36));
        this.btnModificar1.setBackground( new Color(14, 209, 69));
        this.btnLimpiar1.setBackground( new Color(14, 209, 69));
        this.btnDesactivar1.setBackground( new Color(14, 209, 69));
        this.btnRegresar1.setBackground( new Color(14, 209, 69));
        
        this.btnAgregar.setBackground( new Color(14, 209, 69));
        this.btnSalir.setBackground( new Color(236, 28, 36));
        this.btnModificar.setBackground( new Color(14, 209, 69));
        this.btnLimpiar.setBackground( new Color(14, 209, 69));
        this.btnDesactivar.setBackground( new Color(14, 209, 69));
        this.btnRegresar.setBackground( new Color(14, 209, 69));
        btnBuscar2.setBackground( new Color(14, 209, 69));
        //cmbIDTipoDocumento.setEnabled(false);
        //cmbIDCliente.setEnabled(false);
        tblClientes.setForeground(Color.WHITE);
            tblClientes.setBackground(Color.BLACK);
            
            tblNuevoDoc.setForeground(Color.WHITE);
            tblNuevoDoc.setBackground(Color.BLACK);
        this.jPanel1.setBackground( new Color(0, 75, 143));
        this.jPanel2.setBackground( new Color(0, 75, 143));
        createTableTipoDocumento();
        createComboBox2();
        btnDesactivar.setEnabled(false);
        btnDesactivar1.setEnabled(false);
        btnModificar.setEnabled(false);
        btnModificar1.setEnabled(false);
        createTableCliente();
        createComboTipoDocumento();
        createComboBox();
        this.getContentPane().setBackground(new Color(0, 75, 143));
        habilitarAgregarCliente();
        

       /* setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Agregar");
        setSize(32,32);
        
        ImageIcon wallpaper = new ImageIcon("src/main/java/Img/agregar.png");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jlbl_agregar.getWidth(), jlbl_agregar.getHeight(),Image.SCALE_DEFAULT));
        jlbl_agregar.setIcon(icono);
        this.repaint();
        */ 
    }
private void habilitarAgregarCliente(){
        //Validacion de agregar
        if(TipoDocumentodao.getTipo_DocumentoCount()!=0){
            btnAgregar.setEnabled(true);
        }
        else{
            
        }
        //Fin de validacion agregar
    }   
public void btnActivarDesactivar(){
        Tipo_Documento temp = new Tipo_Documento();
        temp = TipoDocumentodao.findTipo_Documento(cmbIDTipoDocumento.getSelectedIndex());
        
        if(temp.isEstado()){
        btnDesactivar1.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnDesactivar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar1.setText("Desactivar");  
        btnDesactivar1.setEnabled(true);
        }
        else{
            btnDesactivar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            btnDesactivar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar1.setText("Activar");
            btnDesactivar1.setEnabled(true);
        }
        }
        
public void btnActivarDesactivarCliente(){
        Cliente temp = new Cliente();
        temp = Clientedao.findCliente(cmbIDCliente.getSelectedIndex());
        
        if(temp.isEstado()){
        btnDesactivar.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar.setText("Desactivar");  
        btnDesactivar.setEnabled(true);
        }
        else{
            btnDesactivar.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar.setText("Activar");
            btnDesactivar.setEnabled(true);
        }
        }
        
        public void createComboBox(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        cmbIDCliente.setModel(modelo);
        List<Cliente> temp = Clientedao.findClienteEntities();
        modelo.addElement("Nuevo");
        temp.forEach((c) -> {
        modelo.addElement(c.getId_cliente());
        });
        }
        /*public void createComboTipoDocumento(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        cmbTipoDocumentoCli.setModel(modelo);
        List<Tipo_Documento> temp = TipoDocumentodao.findTipo_DocumentoEntities();
        temp.forEach((tp) -> {
            modelo.addElement(tp.getDocumento());
        });
                }*/
        public void createComboTipoDocumento(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        cmbTipoDocumentoCli.setModel(modelo);
        List<Tipo_Documento> temp = TipoDocumentodao.findTipo_DocumentoEntities();
        modelo.addElement("Seleccione...");
        
        for(Tipo_Documento tp : temp){    
        temp.forEach((tpp) -> {
            modelo.addElement(tpp.getId_Tipo_Documento()+". "+tpp.getDocumento());
        });         
            return;
        }
                }
        
        public void createComboBox2(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbIDTipoDocumento.setModel(modelo);
        List<Tipo_Documento> temp = TipoDocumentodao.findTipo_DocumentoEntities();
        modelo.addElement("Nuevo");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getId_Tipo_Documento());
        });
        
    }
        
        public void createTableTipoDocumento(){
        DefaultTableModel modelo = new DefaultTableModel();
        tblNuevoDoc.setModel(modelo);
        modelo.addColumn("ID Tipo Documento");
        modelo.addColumn("Tipo Documento");
        modelo.addColumn("Estado");
        
        List<Tipo_Documento> temp = TipoDocumentodao.findTipo_DocumentoEntities();
        
        for(Tipo_Documento tp : temp)
            modelo.addRow(
                    new Object[]{
                        tp.getId_Tipo_Documento(),
                        tp.getDocumento(),
                        (tp.isEstado())?"Activo":"Inactivo"
            });  
    }
        
        public void createTableCliente(){
        DefaultTableModel modelo = new DefaultTableModel();
        tblClientes.setModel(modelo);
        modelo.addColumn("ID Cliente");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Dirección");
        modelo.addColumn("Correo electrónico");
        modelo.addColumn("Fecha Registro");
        modelo.addColumn("Tipo Documento");
        modelo.addColumn("Documento");
        modelo.addColumn("Estado");
        
        List<Persona> tempo = Personadao.findPersonaEntities();
        List<Cliente> temp = Clientedao.findClienteEntities();
        String aux1="";
        Boolean auxestado=true;
        String auxNombre="";
        String auxApellido="";
        String auxDireccion="";
        String auxCorreo="";
        String auxTelefono="";
        String auxDocumento="";
        List<Tipo_Documento> temp2 = TipoDocumentodao.findTipo_DocumentoEntities();
        int aux=0;
        String auxfecha="";
            for(Cliente cc : temp){
                for(Persona p : tempo){
                if(p.getId_persona()==cc.getId_Persona()){
                       auxNombre=(p.getNombre());
                       auxApellido=(p.getApellido());
                       auxDireccion=(p.getDireccion());
                       auxCorreo=(p.getCorreo_electroncio());
                       auxTelefono=(p.getTelefono());
                       auxDocumento=(p.getDocumento_id());
                       auxfecha=(cc.getFecha_ingreso_sistema().substring(8, 10)+"/"+cc.getFecha_ingreso_sistema().substring(5, 7)+"/"+cc.getFecha_ingreso_sistema().substring(0, 4));
                       for(Tipo_Documento tp : temp2){
                if(tp.getId_Tipo_Documento() == p.getID_tipo_documento()){
                    aux1=tp.getDocumento();
                }
        }
            }
            
                }
            modelo.addRow(
                    new Object[]{
                        cc.getId_cliente(),
                        auxNombre,
                        auxApellido,
                        auxTelefono,
                        auxDireccion,
                        auxCorreo,
                        auxfecha,
                        aux1,
                        auxDocumento,
                        cc.isEstado()? "Activo" : "Inactivo",
                        //(cc.isEstado())?"Activo":"Inactivo"
                      
            });  
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

        tpnNuevoDoc = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnBuscar2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        cmbTipoDocumentoCli = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        cmbIDCliente = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnDesactivar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaDirec = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtTipoDocumento = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblNuevoDoc = new javax.swing.JTable();
        btnAgregar1 = new javax.swing.JButton();
        btnModificar1 = new javax.swing.JButton();
        btnLimpiar1 = new javax.swing.JButton();
        btnDesactivar1 = new javax.swing.JButton();
        btnSalir1 = new javax.swing.JButton();
        btnRegresar1 = new javax.swing.JButton();
        cmbIDTipoDocumento = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        tpnNuevoDoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tpnNuevoDocMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));

        btnBuscar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        btnBuscar2.setText("Buscar");
        btnBuscar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar2ActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre:");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Apellidos:");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Tipo Documento:");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Teléfono:");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Correo electrónico:");

        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
        });

        txtTel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelFocusLost(evt);
            }
        });
        txtTel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelKeyTyped(evt);
            }
        });

        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoFocusLost(evt);
            }
        });
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoKeyTyped(evt);
            }
        });

        cmbTipoDocumentoCli.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipoDocumentoCliItemStateChanged(evt);
            }
        });

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Cliente", "Nombre", "Apellidos", "Teléfono", "Dirección", "Correo electrónico", "Fecha Registro", "Tipo Documento", "Documento", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblClientes);
        if (tblClientes.getColumnModel().getColumnCount() > 0) {
            tblClientes.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblClientes.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblClientes.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblClientes.getColumnModel().getColumn(3).setPreferredWidth(80);
            tblClientes.getColumnModel().getColumn(4).setPreferredWidth(130);
            tblClientes.getColumnModel().getColumn(5).setPreferredWidth(90);
            tblClientes.getColumnModel().getColumn(6).setPreferredWidth(90);
            tblClientes.getColumnModel().getColumn(7).setPreferredWidth(60);
            tblClientes.getColumnModel().getColumn(8).setPreferredWidth(60);
            tblClientes.getColumnModel().getColumn(9).setPreferredWidth(50);
        }

        cmbIDCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDClienteItemStateChanged(evt);
            }
        });
        cmbIDCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIDClienteActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("ID Cliente:");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Documento:");

        txtDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocumentoKeyTyped(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Dirección:");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Clientes");

        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnDesactivar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar.setText("Desactivar");
        btnDesactivar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        txtaDirec.setColumns(20);
        txtaDirec.setRows(5);
        txtaDirec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtaDirecKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtaDirec);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnRegresar)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(630, 630, 630)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalir))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1346, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                                        .addGap(16, 16, 16)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                                .addComponent(txtApellidos, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtTel, javax.swing.GroupLayout.Alignment.TRAILING)))
                                        .addGap(82, 82, 82)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(cmbTipoDocumentoCli, 0, 113, Short.MAX_VALUE)
                                                    .addComponent(txtDocumento))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnBuscar2))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar)
                        .addGap(18, 18, 18)
                        .addComponent(btnDesactivar)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cmbIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregar)
                            .addComponent(btnModificar)
                            .addComponent(btnDesactivar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbTipoDocumentoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(btnBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(btnRegresar)
                .addGap(374, 374, 374))
        );

        tpnNuevoDoc.addTab("Clientes", jPanel1);

        jPanel2.setBackground(new java.awt.Color(0, 255, 255));

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("ID Tipo de Documento: ");

        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Tipo de Documento:");

        txtTipoDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoDocumentoKeyTyped(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Ingresar Nuevo Tipo de Documento");

        tblNuevoDoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Tipo de Documento", "Tipo de Documento", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblNuevoDoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNuevoDocMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblNuevoDocMouseEntered(evt);
            }
        });
        jScrollPane3.setViewportView(tblNuevoDoc);
        if (tblNuevoDoc.getColumnModel().getColumnCount() > 0) {
            tblNuevoDoc.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblNuevoDoc.getColumnModel().getColumn(1).setPreferredWidth(60);
            tblNuevoDoc.getColumnModel().getColumn(2).setPreferredWidth(50);
        }

        btnAgregar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar1.setText("Agregar");
        btnAgregar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar1ActionPerformed(evt);
            }
        });

        btnModificar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar1.setText("Modificar");
        btnModificar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar1ActionPerformed(evt);
            }
        });

        btnLimpiar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar1.setText("Limpiar");
        btnLimpiar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar1ActionPerformed(evt);
            }
        });

        btnDesactivar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar1.setText("Desactivar");
        btnDesactivar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDesactivar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar1ActionPerformed(evt);
            }
        });

        btnSalir1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir1.setText("Salir");
        btnSalir1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });

        btnRegresar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar1.setText("Regresar");
        btnRegresar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar1ActionPerformed(evt);
            }
        });

        cmbIDTipoDocumento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDTipoDocumentoItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnAgregar1)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar1)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiar1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel28))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbIDTipoDocumento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTipoDocumento, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addComponent(btnDesactivar1)))
                .addGap(815, 815, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegresar1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(475, 475, 475)
                        .addComponent(btnSalir1)))
                .addGap(81, 81, 81))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSalir1)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbIDTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(btnAgregar1))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnModificar1)
                        .addComponent(btnLimpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDesactivar1)))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(btnRegresar1)
                .addGap(388, 388, 388))
        );

        tpnNuevoDoc.addTab("Ingresar Nuevo Tipo de Documento", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tpnNuevoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 1431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tpnNuevoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

            if(cmbIDCliente.getSelectedIndex()==0){
                
            }
            else{
                cmbIDCliente.setSelectedIndex(0);
            }
            if("".equals(txtNombre.getText()) || txtNombre.getText().length()>25){
                JOptionPane.showMessageDialog(null, "Ingrese la cantidad necesaria de caracteres para el nombre del cliente","Error!", JOptionPane.ERROR_MESSAGE);
                return;   
            }
            else{
                         
            }
            if (ValidacionTresletras(txtNombre.getText())){
                JOptionPane.showMessageDialog(null,"No se Admite en el nombre del Cliente la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        txtNombre.requestFocus(); 
                        return;
                    }else{
                        
                     }
           if("".equals(txtApellidos.getText()) || txtApellidos.getText().length()>25) {
               JOptionPane.showMessageDialog(null, "Ingrese la cantidad necesaria de caracteres para el apellido del cliente","Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }
           else{
           }
           if (ValidacionTresletras(txtApellidos.getText())){ 
               JOptionPane.showMessageDialog(null,"No se Admite en el apellido del Cliente la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        txtApellidos.requestFocus(); 
                        return;
                    }else{
                        
                     }
           if("".equals(txtTel.getText()) || txtTel.getText().length()>10){
               JOptionPane.showMessageDialog(null,"Ingrese la cantidad necesaria de caracteres para el teléfono del cliente","Error!", JOptionPane.ERROR_MESSAGE);
               return;
           }
           else{
               
           }
           if (!telefono(txtTel.getText())){
           JOptionPane.showMessageDialog(null,"Formato de teléfono incorrecto debe comenzar con 2, 3, 7, 8 o 9","Error!", JOptionPane.ERROR_MESSAGE);
           txtTel.requestFocus();
           return;
            }else{
           
            }
           if("".equals(txtaDirec.getText()) || txtaDirec.getText().length()>50){
               JOptionPane.showMessageDialog(null,"Ingrese la cantidad necesaria de caracteres para la dirección del cliente","Error!", JOptionPane.ERROR_MESSAGE);
               return;
           }
           else{
               
           }
           if (ValidacionTresletras(txtaDirec.getText())){ 
               JOptionPane.showMessageDialog(null,"No se Admite en la dirección del Cliente la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        txtaDirec.requestFocus(); 
                        return;
                    }else{
                        
                     }
           if("".equals(txtCorreo.getText()) || txtCorreo.getText().length()>30){
               JOptionPane.showMessageDialog(null, "Ingrese la cantidad necesaria de caracteres para el correo electrónico del cliente","Error!", JOptionPane.ERROR_MESSAGE);
               return;
           }
           else{
               
           }
        Tipo_Documento tempop;
        tempop = TipoDocumentodao.findTipo_Documento(cmbTipoDocumentoCli.getSelectedIndex());
        if(tempop.isEstado()!=true){
            JOptionPane.showMessageDialog(null,"El tipo de documento seleccionado esta Desactivado","Error!", JOptionPane.ERROR_MESSAGE); 
            return;
        }
        else{
            
        }
        
        int aux=14;
        switch (cmbTipoDocumentoCli.getSelectedItem().toString().toLowerCase()) {
            case "1. visa":
           aux=8;
           if(txtDocumento.getText().length()>aux || txtDocumento.getText().length()==0 || txtDocumento.getText().length()<aux){
            JOptionPane.showMessageDialog(null, "La VISA solo puede contener 8 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return;
            }
            else{
                
            }
           if (!ValidacionVISA(txtDocumento.getText())){
           JOptionPane.showMessageDialog(null,"Formato de VISA invalido! Solo debe contener solo Letras y Números","Error!", JOptionPane.ERROR_MESSAGE);
           txtDocumento.requestFocus();
           return;
            }else{
            }
                break;
            case "2. identidad":
            aux=13;
            if(txtDocumento.getText().length()>aux || txtDocumento.getText().length()==0 || txtDocumento.getText().length()<aux){
            JOptionPane.showMessageDialog(null, "La Identidad solo puede contener 13 dígitos","Error!", JOptionPane.ERROR_MESSAGE);
            return;
            }
            else{
                
            }
                if (!ValidacionIdentidad3(txtDocumento.getText())){
           JOptionPane.showMessageDialog(null,"Formato de Identidad invalido! El primer Digito solo puede ser uno o cero","Error!", JOptionPane.ERROR_MESSAGE);
           txtDocumento.requestFocus();
           return;
           }else{
            }
                break;
            case "3. pasaporte":
           aux=9;
           if(txtDocumento.getText().length()>aux || txtDocumento.getText().length()==0 || txtDocumento.getText().length()<aux){
            JOptionPane.showMessageDialog(null, "El RTN solo puede contener 14 dígitos","Error!", JOptionPane.ERROR_MESSAGE);
            return;
            }
            else{
                
            }
           if (!ValidacionPasaporte(txtDocumento.getText())){
           JOptionPane.showMessageDialog(null,"Formato de Pasaporte invalido! Solo puede contener solo Letras y Números","Error!", JOptionPane.ERROR_MESSAGE);
           txtDocumento.requestFocus();
           return;
           }else{
            }
                break;
            case "4. rtn":
            aux=14;
            if(txtDocumento.getText().length()>aux || txtDocumento.getText().length()==0 || txtDocumento.getText().length()<aux){
            JOptionPane.showMessageDialog(null, "El Pasaporte solo puede contener 9 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return;
            }
            else{
                
            }
                if (!ValidacionRTN3(txtDocumento.getText())){
           JOptionPane.showMessageDialog(null,"Formato de RTN  invalido! El primer Digito solo puede ser uno o cero","Error!", JOptionPane.ERROR_MESSAGE);
           txtDocumento.requestFocus();
           return;
           }else{
            }
                break; 
            default:
                break;
        }
           if(txtDocumento.getText().length()>aux || txtDocumento.getText().length()==0){
               //JOptionPane.showMessageDialog(null, "Ingrese la cantidad necesaria de dígitos del Documento del cliente","Error!", JOptionPane.ERROR_MESSAGE);
               return;
           }
           else{
              
               int i;
                boolean flag=false;
                for(i=0;i<Personadao.findPersonaEntities().size();i++){
                    //System.out.println(i);
                if(txtDocumento.getText().toLowerCase().equals(Personadao.findPersona(i+1).getDocumento_id())){
                    JOptionPane.showMessageDialog(null, "Ya existe este Documento registrado en el sistema","Error!", JOptionPane.ERROR_MESSAGE);
                    flag=true;
                    return;
                } else {
                }
                }
                if(flag){
                    return;
                } 

                else{
                    Persona temp = new Persona();
           temp.setId_persona(Personadao.getPersonaCount()+1);
           temp.setNombre(txtNombre.getText());
           temp.setApellido(txtApellidos.getText());
           temp.setTelefono(txtTel.getText());
           temp.setDireccion(txtaDirec.getText());
           temp.setCorreo_electroncio(txtCorreo.getText());
           temp.setID_tipo_documento(cmbTipoDocumentoCli.getSelectedIndex());
           temp.setDocumento_id(txtDocumento.getText());       
        try {
            Personadao.create(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        Cliente tempp = new Cliente();
           tempp.setEstado(true);
           Calendar fecha = new GregorianCalendar();
           tempp.setId_Persona(Personadao.getPersonaCount());
           tempp.setId_cliente(Clientedao.getClienteCount()+1);

           
           String fecha1;
           String aux1,aux2,aux3;
           aux1 = Integer.toString(fecha.get(Calendar.YEAR));
           aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
           aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
           fecha1 = aux1+aux2+aux3;
           tempp.setFecha_ingreso_sistema(fecha1);
           
        try {
            Clientedao.create(tempp);
        } catch (Exception ex) {
            Logger.getLogger(FrmCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JOptionPane.showMessageDialog(null,"Datos Guardados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE);
        createTableCliente();
        createComboTipoDocumento();
        btnAgregar.setEnabled(true);
        btnModificar.setEnabled(false);
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
         
            if("".equals(txtNombre.getText()) || txtNombre.getText().length()>30){
                JOptionPane.showMessageDialog(null, "Ingrese la cantidad necesaria de caracteres para el nombre del cliente","Error!", JOptionPane.ERROR_MESSAGE);
                return;   
            }
            else{
                
            }
            if (ValidacionTresletras(txtNombre.getText())){
                JOptionPane.showMessageDialog(null,"No se Admite en el nombre del Cliente la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        txtNombre.requestFocus(); 
                        return;
                    }else{
                        
                     }
           if("".equals(txtApellidos.getText()) || txtApellidos.getText().length()>25){
               JOptionPane.showMessageDialog(null, "Ingrese la cantidad necesaria de caracteres para el apellido del cliente","Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }
           else{
               
           }
           if (ValidacionTresletras(txtApellidos.getText())){  
               JOptionPane.showMessageDialog(null,"No se Admite en el apellido del Cliente la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        txtApellidos.requestFocus(); 
                        return;
                    }else{
                        
                     }
           if("".equals(txtTel.getText()) || txtTel.getText().length()>10){
               JOptionPane.showMessageDialog(null,"Ingrese la cantidad necesaria de carateres para el teléfono del cliente","Error!", JOptionPane.ERROR_MESSAGE);
               return;
           }
           else{
               
           }
           if (!telefono(txtTel.getText())){
           JOptionPane.showMessageDialog(null,"Formato de teléfono incorrecto debe comenzar con 2, 3, 7, 8 o 9","Error!", JOptionPane.ERROR_MESSAGE);
           txtTel.requestFocus();
           return;
            }else{
           
            }
           if("".equals(txtaDirec.getText()) || txtaDirec.getText().length()>50){
               JOptionPane.showMessageDialog(null,"Ingrese la cantidad necesaria de carateres para la dirección del cliente","Error!", JOptionPane.ERROR_MESSAGE);
               return;
           }
           else{
               
           }
           if (ValidacionTresletras(txtaDirec.getText())){
               JOptionPane.showMessageDialog(null,"No se Admite en la dirección del cliente la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        txtaDirec.requestFocus(); 
                        return;
                    }else{
                     }
           if("".equals(txtCorreo.getText()) || txtCorreo.getText().length()>25){
               JOptionPane.showMessageDialog(null, "Ingrese la cantidad necesaria de carateres para el correo electrónico del cliente","Error!", JOptionPane.ERROR_MESSAGE);
               return;
           }
           else{
               
           }
          Tipo_Documento tempop;
        tempop = TipoDocumentodao.findTipo_Documento(cmbTipoDocumentoCli.getSelectedIndex());
        if(tempop.isEstado()!=true){
            JOptionPane.showMessageDialog(null,"El tipo de documento seleccionado esta Desactivado","Error!", JOptionPane.ERROR_MESSAGE); 
            return;
        }
        else{
            
        }
           int aux=14;
        switch (cmbTipoDocumentoCli.getSelectedItem().toString().toLowerCase()) {
            case "1. visa":
           aux=8;
           if(txtDocumento.getText().length()>aux || txtDocumento.getText().length()==0 || txtDocumento.getText().length()<aux){
            JOptionPane.showMessageDialog(null, "La VISA solo puede contener 8 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return;
            }
            else{
                
            }
           if (!ValidacionVISA(txtDocumento.getText())){
           JOptionPane.showMessageDialog(null,"Formato de VISA invalido! Solo debe contener solo Letras y Números","Error!", JOptionPane.ERROR_MESSAGE);
           txtDocumento.requestFocus();
           return;
            }else{
            }
                break;
            case "2. identidad":
            aux=13;
            if(txtDocumento.getText().length()>aux || txtDocumento.getText().length()==0 || txtDocumento.getText().length()<aux){
            JOptionPane.showMessageDialog(null, "La Identidad solo puede contener 13 dígitos","Error!", JOptionPane.ERROR_MESSAGE);
            return;
            }
            else{
                
            }
                if (!ValidacionIdentidad3(txtDocumento.getText())){
           JOptionPane.showMessageDialog(null,"Formato de Identidad invalido! El primer Digito solo puede ser uno o cero","Error!", JOptionPane.ERROR_MESSAGE);
           txtDocumento.requestFocus();
           return;
           }else{
            }
                break;
            case "3. pasaporte":
           aux=9;
           if(txtDocumento.getText().length()>aux || txtDocumento.getText().length()==0 || txtDocumento.getText().length()<aux){
            JOptionPane.showMessageDialog(null, "El RTN solo puede contener 14 dígitos","Error!", JOptionPane.ERROR_MESSAGE);
            return;
            }
            else{
                
            }
           if (!ValidacionPasaporte(txtDocumento.getText())){
           JOptionPane.showMessageDialog(null,"Formato de Pasaporte invalido! Solo puede contener solo Letras y Números","Error!", JOptionPane.ERROR_MESSAGE);
           txtDocumento.requestFocus();
           return;
           }else{
            }
                break;
            case "4. rtn":
            aux=14;
            if(txtDocumento.getText().length()>aux || txtDocumento.getText().length()==0 || txtDocumento.getText().length()<aux){
            JOptionPane.showMessageDialog(null, "El Pasaporte solo puede contener 9 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return;
            }
            else{
                
            }
                if (!ValidacionRTN3(txtDocumento.getText())){
           JOptionPane.showMessageDialog(null,"Formato de RTN  invalido! El primer Digito solo puede ser uno o cero","Error!", JOptionPane.ERROR_MESSAGE);
           txtDocumento.requestFocus();
           return;
           }else{
            }
                break; 
            default:
                break;
        }
           if(txtDocumento.getText().length()>aux || txtDocumento.getText().length()==0){
               //JOptionPane.showMessageDialog(null, "Ingrese la cantidad necesaria de dígitos del Documento del cliente","Error!", JOptionPane.ERROR_MESSAGE);
               return;
           }
            else{   Persona temp = new Persona();           
           List<Persona> e = Personadao.findPersonaEntities();
           List<Cliente> f = Clientedao.findClienteEntities();
           for(Persona a : e){
               for(Cliente t : f){
                    if(a.getId_persona()==cmbIDCliente.getSelectedIndex())
                        temp.setId_persona(a.getId_persona());
                        }
               
           }
           
           //temp.setId_persona(cmbIDCliente.getSelectedIndex()+1);
           temp.setNombre(txtNombre.getText());
           temp.setApellido(txtApellidos.getText());
           temp.setTelefono(txtTel.getText());
           temp.setDireccion(txtaDirec.getText());
           temp.setCorreo_electroncio(txtCorreo.getText());
           temp.setID_tipo_documento(cmbTipoDocumentoCli.getSelectedIndex());
           temp.setDocumento_id(txtDocumento.getText());       
        try {
            Personadao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        Cliente tempp = new Cliente();
           tempp.setEstado(true);
           tempp=Clientedao.findCliente(cmbIDCliente.getSelectedIndex());
           
        try {
            Clientedao.edit(tempp);
        } catch (Exception ex) {
            Logger.getLogger(FrmCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null,"Datos Modificados exitosamente","Modificado",JOptionPane.PLAIN_MESSAGE);
        createTableCliente();
        createComboTipoDocumento();
        btnAgregar.setEnabled(true);
        btnModificar.setEnabled(false);
           }
           
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
//        cmbIDCliente.setSelectedIndex(1);
        cmbIDCliente.setSelectedIndex(0);
        btnAgregar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnDesactivar.setEnabled(false);
        btnBuscar2.setEnabled(true);
        createTableCliente();
        createComboBox();
        createComboTipoDocumento();
        
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarActionPerformed
        Cliente temp;
        temp = Clientedao.findCliente(cmbIDCliente.getSelectedIndex());
        if(temp.isEstado()){
            temp.setEstado(false);
            JOptionPane.showMessageDialog(null,"Cliente Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE);
        }
        else{
            temp.setEstado(true);
            JOptionPane.showMessageDialog(null,"Cliente Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE);
        }
        try {
            Clientedao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
        }
        createTableCliente();
        btnActivarDesactivarCliente();
        btnDesactivar.setEnabled(false);
        btnAgregar.setEnabled(true);
        btnModificar.setEnabled(false);
        
    }//GEN-LAST:event_btnDesactivarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        FrmMenu m = new FrmMenu();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar1ActionPerformed

        if(cmbIDTipoDocumento.getSelectedIndex()!=0){
            cmbIDTipoDocumento.setSelectedIndex(0);
        }
        else{
            
        }
        if (ValidacionTresletras(txtTipoDocumento.getText())){
               JOptionPane.showMessageDialog(null,"No se Admite en el Documento del cliente la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        txtTipoDocumento.requestFocus(); 
                        return;
                    }else{
                     }
        if("".equals(txtTipoDocumento.getText()) || (txtTipoDocumento.getText().length()>25)){
            JOptionPane.showMessageDialog(null,"Ingrese la cantidad necesaria de caracteres para el documento","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            int i;
            boolean flag=false;
            for(i=0;i<TipoDocumentodao.findTipo_DocumentoEntities().size();i++){
                if(txtTipoDocumento.getText().toLowerCase().equals(TipoDocumentodao.findTipo_Documento(i+1).getDocumento())){
                    JOptionPane.showMessageDialog(null, "Ya existe este tipo de Documento registrado en el sistema","Error!", JOptionPane.ERROR_MESSAGE);
                    flag=true;
                    return;
                } else {
                }
            }
            if(flag){
                return;
            }
            else{
            Tipo_Documento tp = new Tipo_Documento();
            tp.setEstado(true);
            tp.setDocumento(txtTipoDocumento.getText().toLowerCase());
                try {
                    TipoDocumentodao.create(tp);
                } catch (Exception ex) {
                    Logger.getLogger(FrmCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
           //cmbIDTipoDocumento.setSelectedIndex(1);
           JOptionPane.showMessageDialog(null,"Datos Guardados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE);
           cmbIDTipoDocumento.setSelectedIndex(0);
           createTableTipoDocumento();
           createComboBox2();
           createComboTipoDocumento();
           btnAgregar1.setEnabled(true);
           btnModificar1.setEnabled(false);
        }
        }
    
    }//GEN-LAST:event_btnAgregar1ActionPerformed

    private void btnModificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar1ActionPerformed
        if(cmbIDTipoDocumento.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Tipo de Documento no encontrado");
        }
        else{
            if (ValidacionTresletras(txtTipoDocumento.getText())){
               JOptionPane.showMessageDialog(null,"No se Admite en el Documento del cliente la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        txtTipoDocumento.requestFocus(); 
                        return;
                    }else{
                     }
            if("".equals(txtTipoDocumento.getText())){
                JOptionPane.showMessageDialog(null, "Tipo de Documento no puede ir vacio");
                return;
            }
            else{
                
                    Tipo_Documento tp;
                    tp=TipoDocumentodao.findTipo_Documento(cmbIDTipoDocumento.getSelectedIndex());
                    tp.setDocumento(txtTipoDocumento.getText().toLowerCase());
                    try {
                        TipoDocumentodao.edit(tp);
                    } catch (Exception ex) {
                        Logger.getLogger(Tipo_Documento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                JOptionPane.showMessageDialog(null,"Datos Modificados exitosamente","Modificado",JOptionPane.PLAIN_MESSAGE);
                cmbIDTipoDocumento.setSelectedIndex(1);
                cmbIDTipoDocumento.setSelectedIndex(0);
                createTableTipoDocumento();
                createComboBox2();
                btnAgregar1.setEnabled(true);
                btnModificar1.setEnabled(false);
                
            }
        }
    }//GEN-LAST:event_btnModificar1ActionPerformed

    private void btnLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar1ActionPerformed

        cmbIDTipoDocumento.setSelectedIndex(0);
        btnAgregar1.setEnabled(true);
        btnModificar1.setEnabled(false);
        btnDesactivar1.setEnabled(false);
        createTableTipoDocumento();
        createComboBox2();
    }//GEN-LAST:event_btnLimpiar1ActionPerformed

    private void btnDesactivar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar1ActionPerformed
        Tipo_Documento temp;
        temp = TipoDocumentodao.findTipo_Documento(cmbIDTipoDocumento.getSelectedIndex());
        if(temp.isEstado()){
            temp.setEstado(false);
            JOptionPane.showMessageDialog(null,"Tipo de Documento Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE);
        }
        else{
            temp.setEstado(true);
            JOptionPane.showMessageDialog(null,"Tipo de Documento Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE);
        }
        try {
            TipoDocumentodao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(Tipo_Documento.class.getName()).log(Level.SEVERE, null, ex);
        }
        createTableTipoDocumento();
        btnActivarDesactivar();
        btnDesactivar1.setEnabled(false);
        btnAgregar1.setEnabled(true);
        btnModificar1.setEnabled(false);
    }//GEN-LAST:event_btnDesactivar1ActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void btnRegresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar1ActionPerformed
        FrmMenu m = new FrmMenu();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresar1ActionPerformed

    private void tpnNuevoDocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tpnNuevoDocMouseClicked
        /*if(tpnNuevoDoc.getSelectedIndex()==1)
        {    
            DefaultTableModel modelo = new DefaultTableModel();
            tblNuevoDoc.setModel(modelo);
            modelo.addColumn("Id Tipo de Documento");
            modelo.addColumn("Tipo de Documento");
            modelo.addColumn("Estado");
        
            List<Tipo_Documento> Tipo_Documento = TipoDocumentodao.findTipo_DocumentoEntities();
            for(Tipo_Documento tp : Tipo_Documento){
                modelo.addRow(
                    new Object[]{
                        tp.getId_Tipo_Documento(),
                        tp.getDocumento(),
                        tp.isEstado(),
                    }
                );
            }    
        }else if (tpnNuevoDoc.getSelectedIndex()== 0)
             txtTipoDocumento.requestFocus();
        
        
        if(tpnNuevoDoc.getSelectedIndex()==1)
        {    
            DefaultTableModel modelo = new DefaultTableModel();
            tblNuevoDoc.setModel(modelo);
            modelo.addColumn("Id Tipo de Documento");
            modelo.addColumn("Tipo de Documento");
            modelo.addColumn("Estado");
        
            List<Tipo_Documento> Tipo_Documento = TipoDocumentodao.findTipo_DocumentoEntities();
            for(Tipo_Documento tp : Tipo_Documento){
                modelo.addRow(
                    new Object[]{
                        tp.getId_Tipo_Documento(),
                        tp.getDocumento(),
                        tp.isEstado(),
                    }
                );
            }    
        }else if (tpnNuevoDoc.getSelectedIndex()== 0)
             txtTipoDocumento.requestFocus();*/

    }//GEN-LAST:event_tpnNuevoDocMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

     /* btnAgregar1.setEnabled(true);
      btnModificar1.setEnabled(false);
      btnDesactivar1.setEnabled(false);*/
    }//GEN-LAST:event_formWindowActivated

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        btnAgregar.setEnabled(false);
        btnModificar.setEnabled(true);
        btnBuscar2.setEnabled(false);
        int column=0;
        int fila = tblClientes.getSelectedRow();
        if (fila > -1){
            /*cmbIDCliente.setSelectedIndex(Integer.parseInt(tblClientes.getModel().getValueAt(fila, column).toString()));
            txtNombre.setText(String.valueOf(tblClientes.getValueAt(fila, ++column)));
            txtApellidos.setText(String.valueOf(tblClientes.getValueAt(fila, ++column)));
            txtTel.setText(String.valueOf(tblClientes.getValueAt(fila, ++column)));
            txtaDirec.setText(String.valueOf(tblClientes.getValueAt(fila, ++column)));
            txtCorreo.setText(String.valueOf(tblClientes.getValueAt(fila, ++column)));
            cmbTipoDocumentoCli.setSelectedIndex(Integer.parseInt(tblClientes.getModel().getValueAt(fila, column).toString()));
            txtDocumento.setText(String.valueOf(tblClientes.getValueAt(fila, ++column)));
            */
            Cliente temp = Clientedao.findCliente(Integer.parseInt(tblClientes.getModel().getValueAt(fila, column).toString()));
            List<Persona> tempp = Personadao.findPersonaEntities();
            List<Tipo_Documento> tempptp = TipoDocumentodao.findTipo_DocumentoEntities();
           for(Persona b : tempp){
                if(b.getId_persona()==temp.getId_Persona()){
            cmbIDCliente.setSelectedIndex((temp.getId_cliente()));
            txtNombre.setText(b.getNombre());
            txtApellidos.setText(b.getApellido());
            txtTel.setText(b.getTelefono());
            txtaDirec.setText(b.getDireccion());
            txtCorreo.setText(b.getCorreo_electroncio());
            for(Tipo_Documento pptp : tempptp){
                  if(b.getID_tipo_documento()==pptp.getId_Tipo_Documento()){ 
                cmbTipoDocumentoCli.setSelectedItem((b.getID_tipo_documento()+". "+pptp.getDocumento()));
                txtDocumento.setText(b.getDocumento_id());
                  }
                }
                }
            }
            btnActivarDesactivarCliente();
        }
    }//GEN-LAST:event_tblClientesMouseClicked

    private void tblNuevoDocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNuevoDocMouseClicked
        btnAgregar1.setEnabled(false);
        btnModificar1.setEnabled(true);
        int column=0;
        int fila = tblNuevoDoc.getSelectedRow();
        if (fila > -1){
            cmbIDTipoDocumento.setSelectedIndex(Integer.parseInt(tblNuevoDoc.getModel().getValueAt(fila, column).toString()));
            txtTipoDocumento.setText(String.valueOf(tblNuevoDoc.getValueAt(fila, ++column)));
            btnActivarDesactivar();
        }


    }//GEN-LAST:event_tblNuevoDocMouseClicked

    private void cmbIDTipoDocumentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDTipoDocumentoItemStateChanged
        if(cmbIDTipoDocumento.getSelectedIndex()==0){
            txtTipoDocumento.setText("");
            btnDesactivar1.setEnabled(false);
            
        }
        else{
        Tipo_Documento tp;
        tp=TipoDocumentodao.findTipo_Documento(cmbIDTipoDocumento.getSelectedIndex());
        txtTipoDocumento.setText(tp.getDocumento());
        btnActivarDesactivar();
        }
    }//GEN-LAST:event_cmbIDTipoDocumentoItemStateChanged

    private void tblNuevoDocMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNuevoDocMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblNuevoDocMouseEntered

    private void cmbIDClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDClienteItemStateChanged
        if(cmbIDCliente.getSelectedIndex()==0){
            txtNombre.setText("");
            txtApellidos.setText("");
            txtTel.setText("");
            txtaDirec.setText("");
            txtCorreo.setText("");
//            cmbTipoDocumentoCli.setSelectedIndex(0);
            txtDocumento.setText("");
            
        }
        else{
        Persona p;
        p=Personadao.findPersona(cmbIDCliente.getSelectedIndex());
        
        txtNombre.setText(p.getNombre());
        txtApellidos.setText(p.getApellido());
        txtTel.setText(p.getTelefono());
        txtaDirec.setText(p.getDireccion());
        txtCorreo.setText(p.getCorreo_electroncio());
        cmbTipoDocumentoCli.setSelectedIndex(p.getID_tipo_documento()-1);
        txtDocumento.setText(p.getDocumento_id());
        List<Cliente> c = Clientedao.findClienteEntities();
        for(Cliente c1 : c){
                if(c1.getId_Persona() == p.getId_persona()){
                    if(c1.getFecha_ingreso_sistema()==null){
                        
                        break;
                    }
                    else{
                    }
            }
        btnActivarDesactivarCliente();
        
        }
        }
    }//GEN-LAST:event_cmbIDClienteItemStateChanged

    private void cmbIDClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIDClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIDClienteActionPerformed

    private void cmbTipoDocumentoCliItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipoDocumentoCliItemStateChanged
        

        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoDocumentoCliItemStateChanged

    private void txtTelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelKeyTyped
      /* char validar=evt.getKeyChar();
       if((validar<'0'||validar>'9')){
           evt.consume();
           JOptionPane.showMessageDialog(null,"Solo se admiten números para el teléfono del cliente","Error!", JOptionPane.ERROR_MESSAGE);
       }else{
       }*/
    }//GEN-LAST:event_txtTelKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
       char validar=evt.getKeyChar();
       if((validar<'a'||validar>'z')&& (validar<'A' || validar>'Z') && (validar!=(char)KeyEvent.VK_BACKSPACE) && (validar!=(char)KeyEvent.VK_SPACE)){
           evt.consume();
           JOptionPane.showMessageDialog(null,"Solo se admiten letras para el nombre del cliente","Error!", JOptionPane.ERROR_MESSAGE);

       }
       else{
           
       }
       
       
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        char validar=evt.getKeyChar();
       if((validar<'a'||validar>'z')&& (validar<'A' || validar>'Z') && (validar!=(char)KeyEvent.VK_BACKSPACE) && (validar!=(char)KeyEvent.VK_SPACE)){
           evt.consume();
           JOptionPane.showMessageDialog(null,"Solo se admiten letras para el apellido del cliente","Error!", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_txtApellidosKeyTyped

    private void txtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyTyped
        
    }//GEN-LAST:event_txtCorreoKeyTyped

private boolean ValidacionIdentidad3(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^[0-1]{1}[0-9]{3,13}$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{
        return false;
        }
    }

private boolean ValidacionRTN3(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^[0-1]{1}[0-9]{3,14}$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{
        return false;
        }
    }
private boolean ValidacionVISA(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^[A-Z0-9-]{1,8}$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{
        return false;
        }
    }
private boolean ValidacionPasaporte(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^[A-Z0-9-]{1,9}$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{
        return false;
        }
    }

    private boolean correo(String correo_elec){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^[\\w\\-\\_\\+]+(\\.[\\w\\-\\_]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$");
        mat =pat.matcher(correo_elec);
        if (mat.find()){
            return true;
        } else{
        return false;
        }
    }
 private boolean ValidacionTresletras(String Validar){
        
        Pattern pat = Pattern.compile("(?i)(.*aaa.*|.*bbb.*|.*ccc.*|.*ddd.*|.*eee.*|.*fff.*|.*ggg.*|.*hhh.*|.*iii.*|.*jjj.*|.*kkk.*|.*lll.*|.*mmm.*|.*nnn.*|.*ooo.*|.*ppp.*|.*qqq.*|.*rrr.*|.*sss.*|.*ttt.*|.*uuu.*|.*vvv.*|.*www.*|.*xxx.*|.*yyy.*|.*zzz.*)");
            Matcher mat = pat.matcher(Validar);
            
            if(mat.matches()){
                return true;   
            }
            else{
               return false; 
            }
    }

    
    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost
        if (correo(txtCorreo.getText())){
        }else{
           JOptionPane.showMessageDialog(null,"Formato de correo electrónico incorrecto","Error!", JOptionPane.ERROR_MESSAGE);
           txtCorreo.requestFocus();
        }
    }//GEN-LAST:event_txtCorreoFocusLost
   private boolean telefono(String tel){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^[2|3|7|8|9]{1}[0-9]{2,10}$");
        mat =pat.matcher(tel);
        if (mat.find()){
            return true;
        } else{       
        return false;
        
        }

    }
    private void txtTelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelFocusLost
  
    }//GEN-LAST:event_txtTelFocusLost

    private void txtaDirecKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtaDirecKeyTyped
        char validar=evt.getKeyChar();
       if((validar<'a'||validar>'z')&& (validar<'A' || validar>'Z') && (validar<'0'||validar>'9')&& 
               validar<'.'&& validar<';'&& validar<','&& validar<':'&& validar<'"'&& validar<'}'&& validar<'{'&& validar<'['&& validar<']'
               && validar<'-'&& validar<'+'&& validar<'='&& validar<'&'&& validar<'!'&& validar<'*'&& validar<','&& validar<'^'&& validar<'|'&& validar<'.'&& validar<'#'&& validar<'.'&& validar<','
               &&(validar!=(char)KeyEvent.VK_BACKSPACE) && 
               (validar!=(char)KeyEvent.VK_SPACE)){
           evt.consume();
           JOptionPane.showMessageDialog(null,"Solo se admiten letras, números y algunos carcateres","Error!", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_txtaDirecKeyTyped

    private void txtDocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoKeyTyped
        char validar=evt.getKeyChar();
       if((validar<'a'||validar>'z')&& (validar<'A' || validar>'Z') && (validar<'0'||validar>'9')&& 
               (validar!=(char)KeyEvent.VK_BACKSPACE) && (validar!=(char)KeyEvent.VK_SPACE)){
           evt.consume();
           JOptionPane.showMessageDialog(null,"Solo se admiten letras y números","Error!", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_txtDocumentoKeyTyped

    private void txtTipoDocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoDocumentoKeyTyped
       char validar=evt.getKeyChar();
       if((validar<'a'||validar>'z')&& (validar<'A' || validar>'Z') && (validar!=(char)KeyEvent.VK_BACKSPACE) && (validar!=(char)KeyEvent.VK_SPACE)){
           evt.consume();
           JOptionPane.showMessageDialog(null,"Solo se admiten letras para el Nombre del Documento","Error!", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_txtTipoDocumentoKeyTyped

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed
public void BuscarClienteDocumento(){
        List<Cliente> temp = Clientedao.findClienteEntities();
        boolean bandera = false;
        Persona temp3 = new Persona();
        Tipo_Documento temp4 = new Tipo_Documento();
        List<Tipo_Documento> temp5 = TipoDocumentodao.findTipo_DocumentoEntities();
        if("".equals(txtDocumento.getText())){
            JOptionPane.showMessageDialog(null,"El campo de documento del cliente esta vacio","Error!",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{   
        } 
                for(Cliente e : temp){
                    temp3=Personadao.findPersona(e.getId_Persona());   
                    temp4=TipoDocumentodao.findTipo_Documento(temp3.getID_tipo_documento());  
                    if (temp3.getDocumento_id().equals(txtDocumento.getText())){
                    cmbIDCliente.setSelectedIndex(e.getId_cliente());
                    txtNombre.setText(temp3.getNombre());
                    txtApellidos.setText(temp3.getApellido());
                    txtTel.setText(temp3.getTelefono());
                    txtaDirec.setText(temp3.getDireccion());
                    cmbTipoDocumentoCli.setSelectedIndex(temp4.getId_Tipo_Documento());
                    txtDocumento.setText(temp3.getDocumento_id());
                    txtCorreo.setText(temp3.getCorreo_electroncio());
                    
                    bandera=true;
                    }
                    else{
                     
                    }
                }        
                if(!bandera){
                        JOptionPane.showMessageDialog(null,"El Cliente que busco no existe","Error!",JOptionPane.ERROR_MESSAGE); 
                    }   
}
    private void btnBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar2ActionPerformed
        BuscarClienteDocumento();
    }//GEN-LAST:event_btnBuscar2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregar1;
    private javax.swing.JButton btnBuscar2;
    private javax.swing.JButton btnDesactivar;
    private javax.swing.JButton btnDesactivar1;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLimpiar1;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnModificar1;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnRegresar1;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalir1;
    private javax.swing.JComboBox<String> cmbIDCliente;
    private javax.swing.JComboBox<String> cmbIDTipoDocumento;
    private javax.swing.JComboBox<String> cmbTipoDocumentoCli;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTable tblNuevoDoc;
    private javax.swing.JTabbedPane tpnNuevoDoc;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTel;
    private javax.swing.JTextField txtTipoDocumento;
    private javax.swing.JTextArea txtaDirec;
    // End of variables declaration//GEN-END:variables
}
