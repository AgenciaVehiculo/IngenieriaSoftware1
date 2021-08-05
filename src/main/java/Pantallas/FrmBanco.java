/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import Clases.Banco;
import Clases.Cliente;
import Clases.Detalle_Banco_Cliente;
import Clases.Marca;
import Clases.Persona;
import Clases.Tipo_Documento;
import JPAController.BancoJpaController;
import JPAController.ClienteJpaController;
import JPAController.Detalle_Banco_ClienteJpaController;
import JPAController.PersonaJpaController;
import JPAController.Tipo_DocumentoJpaController;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class FrmBanco extends javax.swing.JFrame {

    /**
     * Creates new form Empleados
     */
    BancoJpaController BancoDao = new BancoJpaController();
    ClienteJpaController ClienteDao = new ClienteJpaController();
    PersonaJpaController PersonaDao = new PersonaJpaController();
    Detalle_Banco_ClienteJpaController DetalleBancoClienteDao = new Detalle_Banco_ClienteJpaController();
    Tipo_DocumentoJpaController TipoDocumentodao = new Tipo_DocumentoJpaController();
    public FrmBanco() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        createTableBanco();
        createComboBoxBanco();
        btnDesactivar.setEnabled(false);
        createTablePrestamo();
        createComboCliente();
        createComboIDBancoPrestamo();
        createComboBoxPrestamo();
        txtFechaFinalPrestamo.setEnabled(false);
        btnModificar1.setEnabled(false);
        btnModificar.setEnabled(false);
        this.jPanel1.setBackground( new Color(0, 75, 143));
        this.jPanel2.setBackground( new Color(0, 75, 143));
        this.getContentPane().setBackground(new Color(0, 75, 143));
        setIconImage(new ImageIcon(getClass().getResource("/Img/CarSoft-removebg-preview.png")).getImage());
        this.btnAgregar.setBackground( new Color(14, 209, 69));
        this.btnSalir.setBackground( new Color(236, 28, 36));
        this.btnModificar.setBackground( new Color(14, 209, 69));
        this.btnLimpiar.setBackground( new Color(14, 209, 69));
        this.btnDesactivar.setBackground( new Color(14, 209, 69));
        this.btnDesactivar1.setBackground( new Color(14, 209, 69));
        this.btnRegresar.setBackground( new Color(14, 209, 69));
        tblBanco.setForeground(Color.WHITE);
        tblBanco.setBackground(Color.BLACK);
        this.btnAgregar1.setBackground( new Color(14, 209, 69));
        this.btnSalir1.setBackground( new Color(236, 28, 36));
        this.btnModificar1.setBackground( new Color(14, 209, 69));
        this.btnLimpiar1.setBackground( new Color(14, 209, 69));
        this.btnRegresar1.setBackground( new Color(14, 209, 69));
        tblPrestamo.setForeground(Color.WHITE);
        tblPrestamo.setBackground(Color.BLACK);
        btnBuscar.setBackground( new Color(14, 209, 69));
        btnBuscar1.setBackground( new Color(14, 209, 69));
        btnBuscar2.setBackground( new Color(14, 209, 69));
        btnDesactivar1.setEnabled(false);
        habilitarAgregarPrestamo();
        
    }

public void btnActivarDesactivarBanco(){
        Banco temp = new Banco();
        temp = BancoDao.findBanco(cmbIDBanco.getSelectedIndex());
        
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
private void habilitarAgregarPrestamo(){
        //Validacion de agregar
        if(ClienteDao.getClienteCount()!=0 || BancoDao.getBancoCount()!=0){
            btnAgregar.setEnabled(true);
        }
        else{
            
        }
        //Fin de validacion agregar
    }
public void createComboBoxBanco(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        cmbIDBanco.setModel(modelo);
        List<Banco> temp = BancoDao.findBancoEntities();
        modelo.addElement("Nuevo");
        temp.forEach((c) -> {
        modelo.addElement(c.getId_banco());
        });
        }
public void createComboBoxPrestamo(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        cmbIDPrestamo.setModel(modelo);
        List<Detalle_Banco_Cliente> temp = DetalleBancoClienteDao.findDetalle_Banco_ClienteEntities();
        modelo.addElement("Nuevo");
        temp.forEach((c) -> {
        modelo.addElement(c.getNumero_prestamo());
        });
        }

    public void createComboCliente(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        cmbIDClientePrestamo.setModel(modelo);
        List<Cliente> temp = ClienteDao.findClienteEntities();
        modelo.addElement("Seleccione...");
        temp.forEach((tpp)-> {
            modelo.addElement(tpp.getId_cliente());
             
        });          
        
        
    }

        public void createComboIDBancoPrestamo(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        cmbIDBancoPrestamo.setModel(modelo);
        List<Banco> temp = BancoDao.findBancoEntities();
        modelo.addElement("Seleccione...");
        temp.forEach((tp) -> {
            modelo.addElement(tp.getId_banco());
        });
                }

public void createTableBanco(){
        DefaultTableModel modelo = new DefaultTableModel();
        tblBanco.setModel(modelo);
        modelo.addColumn("ID Banco");
        modelo.addColumn("Nombre Banco");
        modelo.addColumn("Nombre Contacto");
        modelo.addColumn("Teléfono del Contacto");
        modelo.addColumn("Correo electrónico");
        modelo.addColumn("Estado");
        
        List<Banco> temp = BancoDao.findBancoEntities();
        for(Banco tp : temp)
        modelo.addRow(
                    new Object[]{
                        tp.getId_banco(),
                        tp.getNombre_banco(),
                        tp.getNombre_contacto(),
                        tp.getTelefono_contacto(),
                        tp.getCorreo_electronico(),
                        (tp.isEstado())?"Activo":"Inactivo"
            });  
    }
public void createTablePrestamo(){
        DefaultTableModel modelo = new DefaultTableModel();
        tblPrestamo.setModel(modelo);
        modelo.addColumn("N° de Préstamo");
        modelo.addColumn("Banco");
        modelo.addColumn("Cliente");
        modelo.addColumn("Monto del Préstamo");
        modelo.addColumn("N° de Cuotas");
        modelo.addColumn("Valor Total del Interés");
        modelo.addColumn("Tasa de Interés");
        modelo.addColumn("Valor Capital");
        modelo.addColumn("Fecha Inicio");
        modelo.addColumn("Fecha Final");
        modelo.addColumn("Estado");
        
        List<Banco> tempb = BancoDao.findBancoEntities();
        int auxidbanco =0;
        String auxbanco="";
        String auxnombrebanco="";
        List<Detalle_Banco_Cliente> tempdbc = DetalleBancoClienteDao.findDetalle_Banco_ClienteEntities();
        List<Persona> tempo = PersonaDao.findPersonaEntities();
        String auxdocumento = "";
        List<Cliente> temp = ClienteDao.findClienteEntities();
        String aux1="";
        List<Tipo_Documento> temp2 = TipoDocumentodao.findTipo_DocumentoEntities();
        String auxclientenombre="";
        String auxclienteapellido="";
        String auxNombreApellido="";
        String auxcliente="";
        String auxfecha="";
        String auxfechab="";
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00",separadoresPersonalizados);
        DecimalFormat formato2 = new DecimalFormat("#.00",separadoresPersonalizados);
            for(Detalle_Banco_Cliente dbc : tempdbc){
                
                for(Banco b : tempb){
                if(dbc.getId_banco()==b.getId_banco()){
                    auxidbanco=(b.getId_banco());
                    auxnombrebanco=(b.getNombre_banco());
                    auxbanco =((b.getId_banco())+ ". " + b.getNombre_banco());
                }
                    for(Cliente cc : temp){
                        if(dbc.getId_cliente()==cc.getId_cliente()){
                    
                        for(Persona p : tempo){   
                            if(p.getId_persona()== cc.getId_Persona()){
                            auxdocumento=(p.getDocumento_id());
                            auxclientenombre=(p.getNombre());
                            auxclienteapellido=(p.getApellido());
                            auxNombreApellido= auxclientenombre+" "+auxclienteapellido;
                            auxcliente=(dbc.getId_cliente() + ". " + auxNombreApellido);
                            auxfecha=(dbc.getFecha_inicio().substring(8, 10)+"/"+dbc.getFecha_inicio().substring(5, 7)+"/"+dbc.getFecha_inicio().substring(0, 4));
                                for(Tipo_Documento tp : temp2){
                                    if(tp.getId_Tipo_Documento() == p.getID_tipo_documento()){
                                    aux1=tp.getDocumento();
                                    }
                                }
                            }   
                        }
                    }
                }
            }
            if(dbc.getFecha_final()==null) {
                                            auxfechab="";
                                    } else {
                                        auxfechab=(dbc.getFecha_final().substring(8, 10)+"/"+dbc.getFecha_final().substring(5, 7)+"/"+dbc.getFecha_final().substring(0, 4));
                                    } 
        
            modelo.addRow(
                    new Object[]{
                        dbc.getNumero_prestamo(),
                        auxbanco,
                        auxcliente,
                        formato1.format(dbc.getMonto_prestamo()),
                        dbc.getCuota(),
                        formato1.format(dbc.getValor_interes()),
                        formato2.format(dbc.getTasa_interes()),
                        formato1.format(dbc.getValor_capital()),
                        auxfecha,
                        auxfechab,
                        dbc.isEstado()?"Activo":"Inactivo"
                      
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        cmbIDBanco = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        txtCorreoBanco = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTelContacto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombreContacto = new javax.swing.JTextField();
        txtNombreBanco = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnDesactivar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBanco = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btnAgregar1 = new javax.swing.JButton();
        cmbIDPrestamo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPrestamo = new javax.swing.JTable();
        btnSalir1 = new javax.swing.JButton();
        btnRegresar1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cmbIDBancoPrestamo = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cmbIDClientePrestamo = new javax.swing.JComboBox<>();
        txtMontoPrestamo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCuotasPrestamo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtTasaPrestamo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtFechaFinalPrestamo = new javax.swing.JFormattedTextField();
        btnLimpiar1 = new javax.swing.JButton();
        btnModificar1 = new javax.swing.JButton();
        txtIDNombreBancoP = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        btnBuscar1 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        txtIDNombreCliente = new javax.swing.JTextField();
        btnBuscar2 = new javax.swing.JButton();
        btnDesactivar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmbIDBanco.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDBancoItemStateChanged(evt);
            }
        });
        cmbIDBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIDBancoActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("ID Banco:");

        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txtCorreoBanco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoBancoFocusLost(evt);
            }
        });
        txtCorreoBanco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoBancoKeyTyped(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Correo electrónico:");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Teléfono del Contacto:");

        txtTelContacto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelContactoFocusLost(evt);
            }
        });
        txtTelContacto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelContactoKeyTyped(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nombre del Contacto:");

        txtNombreContacto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreContactoKeyTyped(evt);
            }
        });

        txtNombreBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreBancoActionPerformed(evt);
            }
        });
        txtNombreBanco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreBancoKeyTyped(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre del Banco:");

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

        tblBanco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Banco", "Nombre Banco", "Nombre Contacto", "Teléfono del Contacto", "Correo electrónico", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblBanco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBancoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBanco);

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

        jLabel11.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Banco");

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(1187, Short.MAX_VALUE)
                        .addComponent(btnRegresar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(640, 640, 640)
                                        .addComponent(jLabel11))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(16, 16, 16)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNombreContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cmbIDBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(txtNombreBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(btnBuscar)))
                                                .addGap(70, 70, 70)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtCorreoBanco)
                                                    .addComponent(txtTelContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnAgregar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnModificar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnLimpiar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDesactivar)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 338, Short.MAX_VALUE)
                                .addComponent(btnSalir))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(cmbIDBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtTelContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtNombreBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtCorreoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtNombreContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregar)
                            .addComponent(btnModificar)
                            .addComponent(btnDesactivar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSalir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(btnRegresar)
                .addGap(94, 94, 94))
        );

        jTabbedPane1.addTab("Banco", jPanel1);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Préstamos");

        btnAgregar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar1.setText("Agregar");
        btnAgregar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar1ActionPerformed(evt);
            }
        });

        cmbIDPrestamo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDPrestamoItemStateChanged(evt);
            }
        });
        cmbIDPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIDPrestamoActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("N° de Préstamo:");

        tblPrestamo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Préstamo", "ID Banco", "Nombre del Banco", "ID Cliente", "Nombre Completo", "Tipo Documento", "Documento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblPrestamo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPrestamoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblPrestamo);

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

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Banco:");

        cmbIDBancoPrestamo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDBancoPrestamoItemStateChanged(evt);
            }
        });
        cmbIDBancoPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIDBancoPrestamoActionPerformed(evt);
            }
        });

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Cliente:");

        cmbIDClientePrestamo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDClientePrestamoItemStateChanged(evt);
            }
        });
        cmbIDClientePrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIDClientePrestamoActionPerformed(evt);
            }
        });

        txtMontoPrestamo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMontoPrestamoFocusLost(evt);
            }
        });
        txtMontoPrestamo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoPrestamoKeyTyped(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Monto del Prestamo:");

        txtCuotasPrestamo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCuotasPrestamoFocusLost(evt);
            }
        });
        txtCuotasPrestamo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCuotasPrestamoKeyTyped(evt);
            }
        });

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Cuotas del Prestamo:");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Tasa de Interés:");

        txtTasaPrestamo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTasaPrestamoFocusLost(evt);
            }
        });
        txtTasaPrestamo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTasaPrestamoKeyTyped(evt);
            }
        });

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Fecha Final del Préstamo:");

        txtFechaFinalPrestamo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        txtFechaFinalPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaFinalPrestamoActionPerformed(evt);
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

        btnModificar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar1.setText("Modificar");
        btnModificar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar1ActionPerformed(evt);
            }
        });

        txtIDNombreBancoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDNombreBancoPActionPerformed(evt);
            }
        });

        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("Nombre del Banco:");

        btnBuscar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        btnBuscar1.setText("Buscar");
        btnBuscar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });

        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("Nombre del Cliente:");

        txtIDNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDNombreClienteActionPerformed(evt);
            }
        });

        btnBuscar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        btnBuscar2.setText("Buscar");
        btnBuscar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar2ActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAgregar1)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbIDBancoPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbIDPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtIDNombreBancoP, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnBuscar1)))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCuotasPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTasaPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIDNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbIDClientePrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btnBuscar2)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtFechaFinalPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(23, 23, 23))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnModificar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMontoPrestamo))
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiar1)
                                .addGap(18, 18, 18)
                                .addComponent(btnDesactivar1)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(452, 452, 452)
                                .addComponent(btnSalir1))
                            .addComponent(btnRegresar1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir1))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmbIDPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(cmbIDClientePrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtFechaFinalPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cmbIDBancoPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(txtIDNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtIDNombreBancoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtCuotasPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMontoPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtTasaPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar1)
                    .addComponent(btnModificar1)
                    .addComponent(btnLimpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesactivar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnRegresar1)
                .addGap(72, 72, 72))
        );

        jTabbedPane1.addTab("Préstamos", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbIDBancoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDBancoItemStateChanged

    if(cmbIDBanco.getSelectedIndex()==0){
        txtNombreBanco.setText("");
        txtNombreContacto.setText("");
        txtTelContacto.setText("");
        txtCorreoBanco.setText("");
        }
        else{
        Banco tp;
        tp=BancoDao.findBanco(cmbIDBanco.getSelectedIndex());
        txtNombreBanco.setText(tp.getNombre_banco());
        txtNombreContacto.setText(tp.getNombre_contacto());
        txtTelContacto.setText(tp.getTelefono_contacto());
        txtCorreoBanco.setText(tp.getCorreo_electronico());
        btnActivarDesactivarBanco();
        }
    }//GEN-LAST:event_cmbIDBancoItemStateChanged

    private void cmbIDBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIDBancoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIDBancoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        if(cmbIDBanco.getSelectedIndex()!=0){
            cmbIDBanco.setSelectedIndex(0);
        }
        else{

        }
        if("".equals(txtNombreContacto.getText()) || txtNombreContacto.getText().length()>25){
                JOptionPane.showMessageDialog(null, "Ingrese la cantidad necesaria de caracteres para el nombre del Contacto","Error!", JOptionPane.ERROR_MESSAGE);
                return;   
            }
            else{
                         
            }
        if (ValidacionTresletras(txtNombreContacto.getText())){
                JOptionPane.showMessageDialog(null,"No se Admite en el nombre del Contacto la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        txtNombreContacto.requestFocus(); 
                        return;
                    }else{
                        
                     }
                     if (telefono(txtTelContacto.getText())){
           JOptionPane.showMessageDialog(null,"Formato de teléfono incorrecto debe comenzar con 2, 3, 7, 8 o 9","Error!", JOptionPane.ERROR_MESSAGE);
           txtTelContacto.requestFocus();
            }else{
           
            }
           if("".equals(txtTelContacto.getText()) || txtTelContacto.getText().length()>8) {
               JOptionPane.showMessageDialog(null, "Ingrese la cantidad necesaria de caracteres para el teléfono del Contacto","Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }
           else{
           }
           
           if("".equals(txtCorreoBanco.getText()) || txtCorreoBanco.getText().length()>30){
               JOptionPane.showMessageDialog(null, "Ingrese la cantidad necesaria de caracteres para el correo electrónico del Banco","Error!", JOptionPane.ERROR_MESSAGE);
               return;
           }
            else{
           }
           if (ValidacionTresletras(txtNombreBanco.getText())){
                JOptionPane.showMessageDialog(null,"No se Admite en el nombre del Banco la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        txtNombreBanco.requestFocus(); 
                        return;
                    }else{
                        
                     }
        if("".equals(txtNombreBanco.getText()) || (txtNombreBanco.getText().length()>15)){
            JOptionPane.showMessageDialog(null,"Ingrese la cantidad necesaria de caracteres para el nombre del Banco","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            int i;
            boolean flag=false;
            for(i=0;i<BancoDao.findBancoEntities().size();i++){
                if(txtNombreBanco.getText().toLowerCase().equals(BancoDao.findBanco(i+1).getNombre_banco())){
                    JOptionPane.showMessageDialog(null, "Ya existe este Banco registrado en el sistema","Error!", JOptionPane.ERROR_MESSAGE);
                    flag=true;
                    return;
                } else {
                }
            }
            if(flag){
                return;
            }
            else{
                Banco cc = new Banco();
                cc.setEstado(true);
                cc.setNombre_banco(txtNombreBanco.getText().toLowerCase());
                cc.setNombre_contacto(txtNombreContacto.getText());
                cc.setTelefono_contacto(txtTelContacto.getText());
                cc.setCorreo_electronico(txtCorreoBanco.getText());
                try {
                    BancoDao.create(cc);
                } catch (Exception ex) {
                    Logger.getLogger(FrmBanco.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null,"Datos Guardados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE);
//                cmbIDBanco.setSelectedIndex(1);
                cmbIDBanco.setSelectedIndex(0);
                createTableBanco();
                createComboBoxBanco();
                createComboIDBancoPrestamo();
                btnDesactivar.setEnabled(false);
                btnAgregar.setEnabled(true);
                btnModificar.setEnabled(false);
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed
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
    private void txtCorreoBancoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoBancoFocusLost
        if (correo(txtCorreoBanco.getText())){
        }else{
            JOptionPane.showMessageDialog(null,"Formato de correo electrónico incorrecto","Error!", JOptionPane.ERROR_MESSAGE);
            //txtCorreoBanco.requestFocus();
        }
    }//GEN-LAST:event_txtCorreoBancoFocusLost
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
    private void txtCorreoBancoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoBancoKeyTyped

    }//GEN-LAST:event_txtCorreoBancoKeyTyped

    private void txtTelContactoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelContactoFocusLost

    }//GEN-LAST:event_txtTelContactoFocusLost

   private boolean telefono(String tel){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^[2|3|7|8|9]{1}[0-9]{2,8}$");
        mat =pat.matcher(tel);
        if (mat.find()){
            return true;
        } else{       
        return false;
        
        }

    }
private boolean ValidacionNumerosDecimales(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^\\d*\\.\\d*$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{       
        return false;
        
        }
    }
private boolean ValidacionNumerosSiTienenDecimal(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^\\d*\\.?\\d*$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{       
        return false;
        
        }
    }
private boolean ValidacionNumeros(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^\\d*$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{       
        return false;
        
        }
    }

    
    
    private void txtTelContactoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelContactoKeyTyped

    }//GEN-LAST:event_txtTelContactoKeyTyped

    private void txtNombreContactoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreContactoKeyTyped
        char validar=evt.getKeyChar();
       if((validar<'a'||validar>'z')&& (validar<'A' || validar>'Z') && (validar!=(char)KeyEvent.VK_BACKSPACE) && (validar!=(char)KeyEvent.VK_SPACE)){
           evt.consume();
           JOptionPane.showMessageDialog(null,"Solo se admiten letras para el nombre del Contacto","Error!", JOptionPane.ERROR_MESSAGE);

       }
       else{
           
       }
    }//GEN-LAST:event_txtNombreContactoKeyTyped

    private void txtNombreBancoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreBancoKeyTyped
        char validar=evt.getKeyChar();
       if((validar<'a'||validar>'z')&& (validar<'A' || validar>'Z') && (validar!=(char)KeyEvent.VK_BACKSPACE) && (validar!=(char)KeyEvent.VK_SPACE)){
           evt.consume();
           JOptionPane.showMessageDialog(null,"Solo se admiten letras para el nombre del Banco","Error!", JOptionPane.ERROR_MESSAGE);

       }
       else{
           
       }
    }//GEN-LAST:event_txtNombreBancoKeyTyped

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
if(cmbIDBanco.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Banco no encontrado");
        }
        else{
if("".equals(txtNombreBanco.getText()) || (txtNombreBanco.getText().length()>15)){
            JOptionPane.showMessageDialog(null,"Ingrese la cantidad necesaria de caracteres para el nombre del Banco","Error!", JOptionPane.ERROR_MESSAGE);
            return;
     }
else{
    
}
if (ValidacionTresletras(txtNombreBanco.getText())){
                JOptionPane.showMessageDialog(null,"No se Admite en el nombre del Banco la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        txtNombreBanco.requestFocus(); 
                        return;
                    }else{
                        
                     }
if("".equals(txtNombreContacto.getText()) || txtNombreContacto.getText().length()>25){
                JOptionPane.showMessageDialog(null, "Ingrese la cantidad necesaria de caracteres para el nombre del Contacto","Error!", JOptionPane.ERROR_MESSAGE);
                return;   
            }
            else{
                         
            }
if (ValidacionTresletras(txtNombreContacto.getText())){
                JOptionPane.showMessageDialog(null,"No se Admite en el nombre del Contacto la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        txtNombreContacto.requestFocus(); 
                        return;
                    }else{
                        
                     }
if("".equals(txtTelContacto.getText()) || txtTelContacto.getText().length()>8) {
               JOptionPane.showMessageDialog(null, "Ingrese la cantidad necesaria de caracteres para el teléfono del Contacto","Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }
           else{
           }
if (telefono(txtTelContacto.getText())){
           JOptionPane.showMessageDialog(null,"Formato de teléfono incorrecto debe comenzar con 2, 3, 7, 8 o 9","Error!", JOptionPane.ERROR_MESSAGE);
           txtTelContacto.requestFocus();
            }else{
           
            }
if("".equals(txtCorreoBanco.getText()) || txtCorreoBanco.getText().length()>30){
               JOptionPane.showMessageDialog(null, "Ingrese la cantidad necesaria de caracteres para el correo electrónico del Banco","Error!", JOptionPane.ERROR_MESSAGE);
               return;
           }
            else{

            Banco tp = new Banco();
            tp.setEstado(true);
            tp=BancoDao.findBanco(cmbIDBanco.getSelectedIndex());
            tp.setNombre_banco(txtNombreBanco.getText());
            tp.setNombre_contacto(txtNombreContacto.getText());
            tp.setTelefono_contacto(txtTelContacto.getText());
            tp.setCorreo_electronico(txtCorreoBanco.getText());
                    try {
                        BancoDao.edit(tp);
                    } catch (Exception ex) {
                        Logger.getLogger(FrmBanco.class.getName()).log(Level.SEVERE, null, ex);
                    }
                JOptionPane.showMessageDialog(null,"Datos Modificados exitosamente","Modificado",JOptionPane.PLAIN_MESSAGE);
                cmbIDBanco.setSelectedIndex(1);
                cmbIDBanco.setSelectedIndex(0);
                createTableBanco();
                btnDesactivar.setEnabled(false);
                btnAgregar.setEnabled(true);
                btnModificar.setEnabled(false);
        }
}
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        //        cmbIDCliente.setSelectedIndex(1);
        cmbIDBanco.setSelectedIndex(0);
        createTableBanco();
        createComboBoxBanco();
        btnDesactivar.setEnabled(false);
        btnAgregar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnBuscar.setEnabled(true);
        //JOptionPane.showMessageDialog(null,"Datos limpiados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarActionPerformed
        Banco temp;
        temp = BancoDao.findBanco(cmbIDBanco.getSelectedIndex());
        if(temp.isEstado()){
            temp.setEstado(false);
        }
        else{
            temp.setEstado(true);
        }
        try {
            BancoDao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(Marca.class.getName()).log(Level.SEVERE, null, ex);
        }
        createTableBanco();
        btnActivarDesactivarBanco();
        btnDesactivar.setEnabled(false);
        btnAgregar.setEnabled(true);
        btnModificar.setEnabled(false);

    }//GEN-LAST:event_btnDesactivarActionPerformed

    private void tblBancoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBancoMouseClicked
        btnAgregar.setEnabled(false);
        btnModificar.setEnabled(true);
        btnBuscar.setEnabled(false);
        int column=0;
        int fila = tblBanco.getSelectedRow();
        if (fila > -1){
            cmbIDBanco.setSelectedIndex(Integer.parseInt(tblBanco.getModel().getValueAt(fila, column).toString()));
            txtNombreBanco.setText(String.valueOf(tblBanco.getValueAt(fila, ++column)));
            txtNombreContacto.setText(String.valueOf(tblBanco.getValueAt(fila, ++column)));
            txtTelContacto.setText(String.valueOf(tblBanco.getValueAt(fila, ++column)));
            txtCorreoBanco.setText(String.valueOf(tblBanco.getValueAt(fila, ++column)));

            btnActivarDesactivarBanco();
        }
    }//GEN-LAST:event_tblBancoMouseClicked

    public void BuscarBanco1(){
        List<Banco> tempp = BancoDao.findBancoEntities();
        boolean bandera = false;
            for(Banco e: tempp) {
                if((e.getNombre_banco()).equalsIgnoreCase(txtNombreBanco.getText()) || BancoDao.equals(e)){
                    cmbIDBanco.setSelectedItem(e.getId_banco());
                    //txtNombreBanco.setText(e.getNombre_banco());
                    txtNombreContacto.setText(e.getNombre_contacto());
                    txtTelContacto.setText(e.getTelefono_contacto());
                    txtCorreoBanco.setText(e.getCorreo_electronico());
                    bandera=true;
                    
                }  
                else{
                          
                }
                
            }
            if(!bandera){
                    JOptionPane.showMessageDialog(null,"El banco que ingreso no existe","Error!",JOptionPane.ERROR_MESSAGE);
                }
            

}
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        FrmMenu m = new FrmMenu();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar1ActionPerformed
        
        if(cmbIDPrestamo.getSelectedIndex()==0){    
            }
           else{ 
           }
if (!ValidacionNumerosSiTienenDecimal(txtMontoPrestamo.getText())){
           JOptionPane.showMessageDialog(null,"El Monto solo puede contener Números positivos","Error!", JOptionPane.ERROR_MESSAGE);
           txtMontoPrestamo.requestFocus();
           return;
            }else{
           
            }
        if (!ValidacionNumerosDecimales(txtTasaPrestamo.getText())){
           JOptionPane.showMessageDialog(null,"La Tasa de Interés  tienen que contener 2 decimales después del punto","Error!", JOptionPane.ERROR_MESSAGE);
           txtTasaPrestamo.requestFocus();
           return;
            }else{
           
            }
        if (!ValidacionNumeros(txtCuotasPrestamo.getText())){
           JOptionPane.showMessageDialog(null,"La Cuota del Préstamo debe ser de Números enteros positivos","Error!", JOptionPane.ERROR_MESSAGE);
           txtCuotasPrestamo.requestFocus();
           return;
            }else{
           
            }
           Detalle_Banco_Cliente temp = new Detalle_Banco_Cliente();
           temp.setNumero_prestamo(DetalleBancoClienteDao.getDetalle_Banco_ClienteCount()+1);
           temp.setEstado(true);
           temp.setId_banco(cmbIDBancoPrestamo.getSelectedIndex());
           temp.setId_cliente(cmbIDClientePrestamo.getSelectedIndex());
           temp.setMonto_prestamo(Double.parseDouble(txtMontoPrestamo.getText()));
           temp.setTasa_interes(Double.parseDouble(txtTasaPrestamo.getText()));
           temp.setCuota(Integer.parseInt(txtCuotasPrestamo.getText()));
           temp.setValor_interes(Double.parseDouble(txtMontoPrestamo.getText())*(Double.parseDouble(txtTasaPrestamo.getText()))*(Double.parseDouble(txtTasaPrestamo.getText())));
           temp.setValor_capital((Double.parseDouble(txtMontoPrestamo.getText())*(Double.parseDouble(txtTasaPrestamo.getText()))*(Double.parseDouble(txtTasaPrestamo.getText())))+Double.parseDouble(txtMontoPrestamo.getText()));
           Calendar fecha = new GregorianCalendar();
           String fecha1;
           String aux1,aux2,aux3;
           aux1 = Integer.toString(fecha.get(Calendar.YEAR));
           aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
           aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
           fecha1 = aux1+aux2+aux3;
           temp.setFecha_inicio(fecha1);
           
        try {
            DetalleBancoClienteDao.create(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
//         cmbIDPrestamo.setSelectedIndex(1);
           cmbIDPrestamo.setSelectedIndex(0);
           createTablePrestamo();
           createComboIDBancoPrestamo();
           createComboCliente();
           btnAgregar1.setEnabled(true);
           btnModificar1.setEnabled(false);
           LimpiarPre();
    }//GEN-LAST:event_btnAgregar1ActionPerformed

    private void cmbIDPrestamoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDPrestamoItemStateChanged
        if(cmbIDPrestamo.getSelectedIndex()==0){
        }
        else{
        Detalle_Banco_Cliente tp;
        tp=DetalleBancoClienteDao.findDetalle_Banco_Cliente(cmbIDPrestamo.getSelectedIndex());
        }
    }//GEN-LAST:event_cmbIDPrestamoItemStateChanged

    private boolean ValidacionFechaDDMMYYYY(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^(?:(?:(?:0[1-9]|1\\d|2[0-8])[/](?:0[1-9]|1[0-2])|(?:29|30)[/](?:0[13-9]|1[0-2])|31[/](?:0[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\\d|0?[1-9]\\d{2}|[1-9]\\d{3})|29[/]0?2[/](?:\\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{
        return false;
        }
    }
private boolean ValidacionFechaDMYYYY(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^(?:(?:(?:0?[1-9]|1\\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\\d|0?[1-9]\\d{2}|[1-9]\\d{3})|29[/]0?2[/](?:\\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{
        return false;
        }
    }
    private void cmbIDPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIDPrestamoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIDPrestamoActionPerformed
    private void setFechatxt(){
        
        Calendar fecha = new GregorianCalendar();
        String aux1,aux2,aux3;
        aux1 = Integer.toString(fecha.get(Calendar.YEAR));
        aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
        aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
        
        txtFechaFinalPrestamo.setText(aux1+"-"+aux2+"-"+aux3);
        
    }
    private void tblPrestamoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPrestamoMouseClicked
        btnAgregar1.setEnabled(false);
        btnModificar1.setEnabled(true);
        btnBuscar1.setEnabled(false);
        btnBuscar2.setEnabled(false);
        txtIDNombreCliente.setEnabled(false);
        txtIDNombreBancoP.setEnabled(false);
        txtFechaFinalPrestamo.setEnabled(true);
        btnDesactivar1.setEnabled(true);
        int column=0;
        int fila = tblPrestamo.getSelectedRow();
        if (fila > -1){
            DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
            separadoresPersonalizados.setDecimalSeparator('.');
            DecimalFormat formato1 = new DecimalFormat("#.00",separadoresPersonalizados);
            Detalle_Banco_Cliente temp = DetalleBancoClienteDao.findDetalle_Banco_Cliente(Integer.parseInt(tblPrestamo.getModel().getValueAt(fila, column).toString()));
            List<Cliente> tempc = ClienteDao.findClienteEntities();
            List<Persona> tempp = PersonaDao.findPersonaEntities();
            List<Banco> tempb = BancoDao.findBancoEntities();
            String auxfechab="";
            for (Banco b : tempb) {
                if(b.getId_banco()!=temp.getId_banco()){
                } else {
                    for (Cliente cc : tempc) {
                        if(temp.getId_cliente()==cc.getId_cliente()){
                            for (Persona pp : tempp) {
                                if(pp.getId_persona()!=cc.getId_Persona()){
                                } else {
                                    cmbIDPrestamo.setSelectedIndex((temp.getNumero_prestamo()));
                                    cmbIDBancoPrestamo.setSelectedItem((b.getId_banco()));
                                    txtIDNombreBancoP.setText(b.getNombre_banco());
                                    cmbIDClientePrestamo.setSelectedIndex((cc.getId_cliente()));
                                    txtIDNombreCliente.setText(pp.getNombre()+" "+pp.getApellido());
                                    txtMontoPrestamo.setText(String.valueOf(formato1.format(temp.getMonto_prestamo())));
                                    txtCuotasPrestamo.setText(String.valueOf(temp.getCuota()));
                                    txtTasaPrestamo.setText(String.valueOf(formato1.format(temp.getTasa_interes())));
                                    if(temp.getFecha_final()==null) {
                                            auxfechab="";
                                    } else {
                                        auxfechab=(temp.getFecha_final().substring(8, 10)+"/"+temp.getFecha_final().substring(5, 7)+"/"+temp.getFecha_final().substring(0, 4));
                                    }
                                    txtFechaFinalPrestamo.setText(auxfechab);
                                }
                            }
                        }
                    }
                }
            }
        }
        
    }//GEN-LAST:event_tblPrestamoMouseClicked

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        
        System.exit(0);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void btnRegresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar1ActionPerformed

        FrmMenu m = new FrmMenu();
        m.setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresar1ActionPerformed

    private void cmbIDBancoPrestamoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDBancoPrestamoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIDBancoPrestamoItemStateChanged

    private void cmbIDBancoPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIDBancoPrestamoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIDBancoPrestamoActionPerformed

    private void cmbIDClientePrestamoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDClientePrestamoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIDClientePrestamoItemStateChanged

    private void cmbIDClientePrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIDClientePrestamoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIDClientePrestamoActionPerformed

    private void txtMontoPrestamoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMontoPrestamoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoPrestamoFocusLost

    private void txtMontoPrestamoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoPrestamoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoPrestamoKeyTyped

    private void txtCuotasPrestamoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCuotasPrestamoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCuotasPrestamoFocusLost

    private void txtCuotasPrestamoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuotasPrestamoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCuotasPrestamoKeyTyped

    private void txtTasaPrestamoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTasaPrestamoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTasaPrestamoFocusLost

    private void txtTasaPrestamoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTasaPrestamoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTasaPrestamoKeyTyped
public void LimpiarPre(){
        cmbIDPrestamo.setSelectedIndex(0);
        cmbIDBancoPrestamo.setSelectedIndex(0);
        cmbIDClientePrestamo.setSelectedIndex(0);
        txtIDNombreBancoP.setText("");
        txtMontoPrestamo.setText("");
        txtIDNombreCliente.setText("");
        txtCuotasPrestamo.setText("");
        txtTasaPrestamo.setText("");
        txtFechaFinalPrestamo.setText("");
        createTablePrestamo();
        createComboBoxPrestamo();
        txtIDNombreBancoP.setEnabled(true);
        txtIDNombreCliente.setEnabled(true);
        btnBuscar1.setEnabled(true);
        btnBuscar2.setEnabled(true);
        
        
        btnAgregar1.setEnabled(true);
        btnModificar1.setEnabled(false);
        btnDesactivar1.setEnabled(false);
}
    private void btnLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar1ActionPerformed
        LimpiarPre();
    }//GEN-LAST:event_btnLimpiar1ActionPerformed

    private void btnModificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar1ActionPerformed
                
        if(cmbIDPrestamo.getSelectedIndex()==0){    
            }
           else{ 
           }
if (!ValidacionNumerosSiTienenDecimal(txtMontoPrestamo.getText())){
           JOptionPane.showMessageDialog(null,"El Monto solo puede contener Números positivos","Error!", JOptionPane.ERROR_MESSAGE);
           txtMontoPrestamo.requestFocus();
           return;
            }else{
           
            }
        if (!ValidacionNumerosDecimales(txtTasaPrestamo.getText())){
           JOptionPane.showMessageDialog(null,"La Tasa de Interés  tienen que contener 2 decimales después del punto","Error!", JOptionPane.ERROR_MESSAGE);
           txtTasaPrestamo.requestFocus();
           return;
            }else{
           
            }
        if (!ValidacionNumeros(txtCuotasPrestamo.getText())){
           JOptionPane.showMessageDialog(null,"La Cuota del Préstamo debe ser de Números enteros positivos","Error!", JOptionPane.ERROR_MESSAGE);
           txtCuotasPrestamo.requestFocus();
           return;
            }else{
           
            }
        if (!ValidacionFechaDDMMYYYY(txtFechaFinalPrestamo.getText())){
           JOptionPane.showMessageDialog(null,"El Formato de fecha es Incorrecto! El formato debe ser DD/MM/YYYY","Error!", JOptionPane.ERROR_MESSAGE);
           txtFechaFinalPrestamo.requestFocus();
           return;
            }else{
            }
           Detalle_Banco_Cliente temp = new Detalle_Banco_Cliente();
           //temp.setNumero_prestamo(DetalleBancoClienteDao.getDetalle_Banco_ClienteCount());
           temp.setId_banco(cmbIDBancoPrestamo.getSelectedIndex());
           temp.setId_cliente(cmbIDClientePrestamo.getSelectedIndex());
           temp=DetalleBancoClienteDao.findDetalle_Banco_Cliente(cmbIDPrestamo.getSelectedIndex());
           //temp=DetalleBancoClienteDao.findDetalle_Banco_Cliente(cmbIDBancoPrestamo.getSelectedIndex());
           //temp=DetalleBancoClienteDao.findDetalle_Banco_Cliente(cmbIDClientePrestamo.getSelectedIndex());
           temp.setMonto_prestamo(Double.parseDouble(txtMontoPrestamo.getText()));
           temp.setTasa_interes(Double.parseDouble(txtTasaPrestamo.getText()));
           temp.setCuota(Integer.parseInt(txtCuotasPrestamo.getText()));
           temp.setValor_interes(Double.parseDouble(txtMontoPrestamo.getText())*(Double.parseDouble(txtTasaPrestamo.getText()))*(Double.parseDouble(txtTasaPrestamo.getText())));
           temp.setValor_capital((Double.parseDouble(txtMontoPrestamo.getText())*(Double.parseDouble(txtTasaPrestamo.getText()))*(Double.parseDouble(txtTasaPrestamo.getText())))+Double.parseDouble(txtMontoPrestamo.getText()));
           String auxfecha="";
           String auxfechafinal="";
           String anio="";
           String mes="";
           String dia="";
           auxfecha=txtFechaFinalPrestamo.getText();
           anio=auxfecha.substring(6,10);
           mes=auxfecha.substring(3,5);
           dia=auxfecha.substring(0,2);
           auxfechafinal=anio+"-"+mes+"-"+dia;
           temp.setFecha_final(auxfechafinal);
           
        try {
            DetalleBancoClienteDao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
           cmbIDPrestamo.setSelectedIndex(1);
           cmbIDPrestamo.setSelectedIndex(0);
           createTablePrestamo();
           createComboIDBancoPrestamo();
           createComboCliente();
           LimpiarPre();
           btnAgregar1.setEnabled(true);
           btnModificar1.setEnabled(false);
    }//GEN-LAST:event_btnModificar1ActionPerformed

    private void txtNombreBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreBancoActionPerformed
        
    }//GEN-LAST:event_txtNombreBancoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        BuscarBanco1();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtIDNombreBancoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDNombreBancoPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDNombreBancoPActionPerformed
public void BuscarBanco2(){
        List<Banco> tempp = BancoDao.findBancoEntities();
        boolean bandera = false;
            for(Banco e: tempp) {
                if((e.getNombre_banco()).equalsIgnoreCase(txtIDNombreBancoP.getText())){
                    cmbIDBancoPrestamo.setSelectedIndex(e.getId_banco());
                    bandera=true;
                }  
                else{                         
                }
            }
            if(!bandera){
                    JOptionPane.showMessageDialog(null,"El banco que ingreso no existe","Error!",JOptionPane.ERROR_MESSAGE);
                }
}
    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        BuscarBanco2();
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void txtIDNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDNombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDNombreClienteActionPerformed
public void BuscarCiente(){
        List<Detalle_Banco_Cliente> temp = DetalleBancoClienteDao.findDetalle_Banco_ClienteEntities();
        boolean bandera = false;
        Persona temp3 = new Persona();
        Cliente temp2 = new Cliente();
        if("".equals(txtIDNombreCliente.getText())){
            JOptionPane.showMessageDialog(null,"El campo de nombre de cliente esta vacio","Error!",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{   
        } 
                for(Detalle_Banco_Cliente c : temp){
                    temp2=ClienteDao.findCliente(c.getId_cliente());
                    temp3=PersonaDao.findPersona(temp2.getId_Persona());   
                    String auxNombre=(temp3.getNombre()+" "+temp3.getApellido());
                    if (auxNombre.equals(txtIDNombreCliente.getText())){
                    cmbIDClientePrestamo.setSelectedIndex(temp2.getId_cliente());
                    bandera=true;
                    }
                    else{                 
                    }
                }        
                if(!bandera){
                        JOptionPane.showMessageDialog(null,"El Cliente que ingreso no existe","Error!",JOptionPane.ERROR_MESSAGE); 
                    }   
}
    private void btnBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar2ActionPerformed
        BuscarCiente();
    }//GEN-LAST:event_btnBuscar2ActionPerformed

    private void txtFechaFinalPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaFinalPrestamoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaFinalPrestamoActionPerformed
public void btnActivarDesactivarPrestamo(){
        Detalle_Banco_Cliente temp = new Detalle_Banco_Cliente();
        temp = DetalleBancoClienteDao.findDetalle_Banco_Cliente(cmbIDPrestamo.getSelectedIndex());
        
        if(temp.isEstado()){
        btnDesactivar1.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnDesactivar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar1.setText("Desactivar");  
        btnDesactivar1.setEnabled(true);
        }
        else{
            btnDesactivar1.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar1.setText("Activar");
            btnDesactivar1.setEnabled(true);
        }
        }
    private void btnDesactivar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar1ActionPerformed
        Detalle_Banco_Cliente temp;
        temp = DetalleBancoClienteDao.findDetalle_Banco_Cliente(cmbIDPrestamo.getSelectedIndex());
        if(temp.isEstado()){
            temp.setEstado(false);
            JOptionPane.showMessageDialog(null,"Préstamo Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE);
        }
        else{
            temp.setEstado(true);
            JOptionPane.showMessageDialog(null,"Préstamo Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE);
        }
        try {
            DetalleBancoClienteDao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        createTablePrestamo();
        btnActivarDesactivarPrestamo();
        btnDesactivar1.setEnabled(false);
        btnAgregar1.setEnabled(true);
        btnModificar1.setEnabled(false);
        LimpiarPre();

    }//GEN-LAST:event_btnDesactivar1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmBanco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBanco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBanco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBanco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new FrmBanco().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregar1;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
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
    private javax.swing.JComboBox<String> cmbIDBanco;
    private javax.swing.JComboBox<String> cmbIDBancoPrestamo;
    private javax.swing.JComboBox<String> cmbIDClientePrestamo;
    private javax.swing.JComboBox<String> cmbIDPrestamo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblBanco;
    private javax.swing.JTable tblPrestamo;
    private javax.swing.JTextField txtCorreoBanco;
    private javax.swing.JTextField txtCuotasPrestamo;
    private javax.swing.JFormattedTextField txtFechaFinalPrestamo;
    private javax.swing.JTextField txtIDNombreBancoP;
    private javax.swing.JTextField txtIDNombreCliente;
    private javax.swing.JTextField txtMontoPrestamo;
    private javax.swing.JTextField txtNombreBanco;
    private javax.swing.JTextField txtNombreContacto;
    private javax.swing.JTextField txtTasaPrestamo;
    private javax.swing.JTextField txtTelContacto;
    // End of variables declaration//GEN-END:variables
}
