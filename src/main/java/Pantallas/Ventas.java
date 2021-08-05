/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import Clases.Cliente;
import Clases.Empleado;
import Clases.Factura;
import Clases.HistoricoPrecioPieza;
import Clases.HistoricoPrecioVehiculos;
import Clases.Persona;
import Clases.Pieza;
import Clases.PiezaFactura;
import Clases.TipoFactura;
import Clases.Validaciones;
import Clases.Vehiculo;
import Clases.VehiculoFactura;
import FormModales.ModalPiezas;
import FormModales.ModalVehiculos;
import JPAController.ClienteJpaController;
import JPAController.EmpleadoJpaController;
import JPAController.FacturaJpaController;
import JPAController.HistoricoPrecioPiezaJpaController;
import JPAController.HistoricoPrecioVehiculosJpaController;
import JPAController.MarcaJpaController;
import JPAController.Numero_AsientosJpaController;
import JPAController.PersonaJpaController;
import JPAController.PiezaFacturaJpaController;
import JPAController.PiezaJpaController;
import JPAController.TipoCabinaJpaController;
import JPAController.TipoFacturaJpaController;
import JPAController.TipoGasolinaJpaController;
import JPAController.TipoVehiculoJpaController;
import JPAController.Tipo_DocumentoJpaController;
import JPAController.Tipo_colorJpaController;
import JPAController.VehiculoFacturaJpaController;
import JPAController.VehiculoJpaController;
import JPAController.transmisionJpaController;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
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
public class Ventas extends javax.swing.JFrame {

    
    Tipo_DocumentoJpaController tipoDocumentoDao = new Tipo_DocumentoJpaController();
    PersonaJpaController personaDao = new PersonaJpaController();
    ClienteJpaController clienteDao = new ClienteJpaController();
    EmpleadoJpaController empleadoDao = new EmpleadoJpaController();
    PiezaJpaController piezaDao = new PiezaJpaController();
    HistoricoPrecioPiezaJpaController historicoPiezaDao = new HistoricoPrecioPiezaJpaController();
    HistoricoPrecioVehiculosJpaController historicoVehiculoDao = new HistoricoPrecioVehiculosJpaController();
    VehiculoJpaController vehiculoDao = new VehiculoJpaController();
    MarcaJpaController Marcadao = new MarcaJpaController();
    Tipo_colorJpaController Colorrdao = new Tipo_colorJpaController();
    TipoCabinaJpaController TipoCabinadao = new TipoCabinaJpaController();
    TipoGasolinaJpaController TipoGasolinadao = new TipoGasolinaJpaController();
    transmisionJpaController TipoTransmisiondao = new transmisionJpaController();
    TipoVehiculoJpaController TipoVehiculodao = new TipoVehiculoJpaController();
    Numero_AsientosJpaController NumeroAsientosdao = new Numero_AsientosJpaController();
    
    
    FacturaJpaController facturaDao = new FacturaJpaController();
    PiezaFacturaJpaController piezaFacturaDao = new PiezaFacturaJpaController();
    VehiculoFacturaJpaController vehiculoFacturaDao = new VehiculoFacturaJpaController();
    TipoFacturaJpaController tipoFacturaDao = new TipoFacturaJpaController();
    
    /**
     * Creates new form Empleados
     */
    public Ventas() {
        initComponents();
        
        setIconImage(new ImageIcon(getClass().getResource("/Img/CarSoft-removebg-preview.png")).getImage());
        this.setExtendedState(MAXIMIZED_BOTH);
        tab_Ventas.setBackground(Color.CYAN);
        jPanel1.setBackground(Color.CYAN);
        jPanel2.setBackground(Color.CYAN);
        this.jPanel2.setBackground( new Color(0, 75, 143));
        this.jPanel1.setBackground( new Color(0, 75, 143));
        this.jPanel3.setBackground( new Color(0, 75, 143));
        this.getContentPane().setBackground(new Color(0, 75, 143));
        crearCmbIDEmpleado();
        crearCmbIDPieza();
        crearTbVenta();
        setFechatxt();
        crearCmbIDVehiculo();
        setTxtNumFactura();
        crearCmbIDTipoFactura();
        createCmbTipoFacturaVenta();
        createCmbTipoFactura();
        createTbTipoFactura();
    }

    private void createCmbTipoFacturaVenta(){
        DefaultComboBoxModel modelo1=new DefaultComboBoxModel();
        cmbTipoFacturaVenta.setModel(modelo1);
        modelo1.addElement("Seleccione");
        List<TipoFactura> temp = tipoFacturaDao.findTipoFacturaEntities();
        for(TipoFactura e : temp){
            modelo1.addElement(e.getTipoFactura());
        }
        
    }
    
    private void createTbTipoFactura(){
        DefaultTableModel modelo2 = new DefaultTableModel();
        tblNuevoCargo.setModel(modelo2);
        modelo2.addColumn("ID");
        modelo2.addColumn("Tipo de Factura");
        modelo2.addColumn("Estado");
        
        
        List<TipoFactura> temp = tipoFacturaDao.findTipoFacturaEntities();
        
        for(TipoFactura e : temp)
            modelo2.addRow(
                    new Object[]{
                        e.getIDtipofactura(),
                        e.getTipoFactura(),
                        (e.getEstado())?"Activo":"Inactivo"
            });
    }
    
    private void createCmbTipoFactura(){
        DefaultComboBoxModel modelo1=new DefaultComboBoxModel();
        cmbIDNuevoFactura.setModel(modelo1);
        modelo1.addElement("Nuevo");
        List<TipoFactura> temp = tipoFacturaDao.findTipoFacturaEntities();
        for(TipoFactura e : temp){
            modelo1.addElement(e.getTipoFactura());
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

        tab_Ventas = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtFechaInicial = new javax.swing.JFormattedTextField();
        jButton10 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtFechaFinal = new javax.swing.JFormattedTextField();
        chkFecha = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        txtNumFacturaBusqueda = new javax.swing.JFormattedTextField();
        chkNumFactura = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        txtClienteBusqueda = new javax.swing.JTextField();
        chkCliente = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        label1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNumFactura = new javax.swing.JTextField();
        btnImprimirFactura = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbVenta = new javax.swing.JTable();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtVIN = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cmbIDEmpleado = new javax.swing.JComboBox<>();
        btnAgregarPieza = new javax.swing.JButton();
        btnAgregarVehiculo = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JFormattedTextField();
        jButton3 = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtDocumentoCliente = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cmbTipoFacturaVenta = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtIDPieza = new javax.swing.JFormattedTextField();
        txtIDVehiculo = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        btnRegresar2 = new javax.swing.JButton();
        btnSalir2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblNuevoCargo = new javax.swing.JTable();
        btnAgregar2 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        cmbIDNuevoFactura = new javax.swing.JComboBox<>();
        txtTipoFactura = new javax.swing.JTextField();
        btnModificar2 = new javax.swing.JButton();
        btnLimpiar2 = new javax.swing.JButton();
        btnDesactivar3 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 75, 143));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Venta", "ID Vehiculo", "ID Empleado", "Nombre Empleado", "Nombre del Cliente", "ID Accesorio", "Nombre del Accesorio", "SubTotal"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jLabel3.setText("Fecha Inicial: ");

        txtFechaInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/YYYY"))));
        txtFechaInicial.setEnabled(false);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/imprimir1.png"))); // NOI18N
        jButton10.setText("Imprimir");

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        jButton7.setText("Buscar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        jButton18.setText("Regresar");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        jButton19.setText("Salir");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jLabel4.setText("FechaFinal: ");

        txtFechaFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/YYYY"))));
        txtFechaFinal.setEnabled(false);

        chkFecha.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkFechaItemStateChanged(evt);
            }
        });

        jLabel15.setText("Numero de Factura:");

        txtNumFacturaBusqueda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtNumFacturaBusqueda.setEnabled(false);

        chkNumFactura.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkNumFacturaItemStateChanged(evt);
            }
        });

        jLabel16.setText("Cliente:");

        txtClienteBusqueda.setEnabled(false);

        chkCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkClienteItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(chkFecha))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(137, 137, 137)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton7)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNumFacturaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtClienteBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(155, 155, 155)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(chkNumFactura)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton19))
                            .addComponent(chkCliente)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton18))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1127, Short.MAX_VALUE))
                        .addGap(85, 85, 85)))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chkFecha)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(chkNumFactura)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel15)
                                        .addComponent(txtNumFacturaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txtFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16)
                                .addComponent(txtClienteBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(chkCliente))
                        .addGap(19, 19, 19)
                        .addComponent(jButton7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jButton19)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton10)
                    .addComponent(jButton18))
                .addGap(0, 399, Short.MAX_VALUE))
        );

        tab_Ventas.addTab("Reportes", jPanel2);

        jPanel1.setBackground(java.awt.Color.cyan);

        label1.setText("Fecha: ");

        jLabel5.setText("ID Empleado:");

        jLabel6.setText("Documento Cliente:");

        jLabel7.setText("VIN:");

        txtNumFactura.setEditable(false);

        btnImprimirFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnImprimirFactura.setText("Imprimir");
        btnImprimirFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirFacturaActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        jButton4.setText("Nuevo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        tbVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Decripcion", "Precio Unit", "Cantidad", "SubTotal"
            }
        ));
        jScrollPane2.setViewportView(tbVenta);

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        jButton16.setText("Regresar");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        jButton17.setText("Salir");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jLabel8.setText("Número de Factura:");

        jLabel9.setText("ID Vehiculo:");

        txtVIN.setText(" ");
        txtVIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVINActionPerformed(evt);
            }
        });

        jLabel10.setText("ID Pieza:");

        txtTotal.setEditable(false);
        txtTotal.setText(" ");
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        jLabel1.setText("Total:");

        cmbIDEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAgregarPieza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregarPieza.setText("Agregar Pieza");
        btnAgregarPieza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPiezaActionPerformed(evt);
            }
        });

        btnAgregarVehiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregarVehiculo.setText("Agregar Vehiculo");
        btnAgregarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarVehiculoActionPerformed(evt);
            }
        });

        jLabel11.setText("Cantidad:");

        txtCantidad.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cancelar.png"))); // NOI18N
        jButton3.setText("Borrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtNombre.setEditable(false);

        jLabel2.setText("Nombre:");

        txtFecha.setEditable(false);

        jLabel12.setText("Tipo de Factura:");

        cmbTipoFacturaVenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        txtIDPieza.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtIDPieza.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIDPiezaFocusLost(evt);
            }
        });
        txtIDPieza.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDPiezaKeyTyped(evt);
            }
        });

        txtIDVehiculo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnAgregarPieza)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(label1, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNombre)
                                            .addComponent(cmbIDEmpleado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                            .addComponent(txtFecha)
                                            .addComponent(txtIDPieza))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel9)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel12)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cmbTipoFacturaVenta, 0, 189, Short.MAX_VALUE)
                                            .addComponent(txtIDVehiculo)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel6)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtDocumentoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel7)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtVIN, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtNumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(btnAgregarVehiculo, javax.swing.GroupLayout.Alignment.TRAILING)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 60, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(34, 34, 34)
                                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton17))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3)
                                    .addComponent(jLabel14))
                                .addGap(0, 411, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnImprimirFactura)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton16)))
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton17))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(label1)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cmbIDEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtDocumentoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbTipoFacturaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(txtIDPieza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(txtIDVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel7)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarPieza)
                    .addComponent(btnAgregarVehiculo))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jButton16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnImprimirFactura))))
                .addContainerGap(358, Short.MAX_VALUE))
        );

        tab_Ventas.addTab("Ventas ", jPanel1);

        btnRegresar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar2.setText("Regresar");
        btnRegresar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar2ActionPerformed(evt);
            }
        });

        btnSalir2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir2.setText("Salir");
        btnSalir2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir2ActionPerformed(evt);
            }
        });

        tblNuevoCargo.setModel(new javax.swing.table.DefaultTableModel(
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
        tblNuevoCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNuevoCargoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblNuevoCargoMouseEntered(evt);
            }
        });
        jScrollPane5.setViewportView(tblNuevoCargo);

        btnAgregar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar2.setText("Agregar");
        btnAgregar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar2ActionPerformed(evt);
            }
        });

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Tipo de Factura:");

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("ID de Factura:");

        cmbIDNuevoFactura.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDNuevoFacturaItemStateChanged(evt);
            }
        });

        txtTipoFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoFacturaKeyTyped(evt);
            }
        });

        btnModificar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar2.setText("Modificar");
        btnModificar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar2ActionPerformed(evt);
            }
        });

        btnLimpiar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar2.setText("Limpiar");
        btnLimpiar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar2ActionPerformed(evt);
            }
        });

        btnDesactivar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar3.setText("Desactivar");
        btnDesactivar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDesactivar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar3ActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel29.setText("Ingresar Nuevo Tipo de Factura");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnAgregar2)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar2)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiar2))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbIDNuevoFactura, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTipoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(btnDesactivar3)))
                .addGap(894, 894, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegresar2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(475, 475, 475)
                        .addComponent(btnSalir2)))
                .addGap(81, 81, 81))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSalir2)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbIDNuevoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnAgregar2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnModificar2)
                            .addComponent(btnLimpiar2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar3))))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar2)
                .addGap(388, 388, 388))
        );

        tab_Ventas.addTab("Tipo de Factura", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tab_Ventas, javax.swing.GroupLayout.PREFERRED_SIZE, 1263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tab_Ventas)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDesactivar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar3ActionPerformed
       
    }//GEN-LAST:event_btnDesactivar3ActionPerformed

    private void btnLimpiar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar2ActionPerformed
        
    }//GEN-LAST:event_btnLimpiar2ActionPerformed

    private void btnModificar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar2ActionPerformed

        if(cmbIDNuevoFactura.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Tipo de pieza no encontrado");
            return;
        }
        else{
            if("".equals(txtTipoFactura.getText())){
                JOptionPane.showMessageDialog(null, "Tipo de Pieza no puede ir vacio");
                return;
            }
            else{
                int i;
                boolean flag=false;
                for(i=0;i<tipoFacturaDao.findTipoFacturaEntities().size();i++){
                    //System.out.println(i);
                if(txtTipoFactura.getText().toLowerCase().equals(tipoFacturaDao.findTipoFactura(i+1).getTipoFactura())){
                    JOptionPane.showMessageDialog(null, "Ya existe este tipo de Factura registrada en el sistema");
                    flag=true;
                    return;
                } else {
                }
            }
                if(flag){
                    return;
                }
                else{
                    TipoFactura e1;
                    e1=tipoFacturaDao.findTipoFactura(cmbIDNuevoFactura.getSelectedIndex());
                    e1.setTipoFactura(txtTipoFactura.getText().toLowerCase());
                    try {
                        tipoFacturaDao.edit(e1);
                    } catch (Exception ex) {
                        Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }  
        } 
                cmbIDNuevoFactura.setSelectedIndex(1);
                cmbIDNuevoFactura.setSelectedIndex(0);
        
        
        
        
        
        
        
        
        
        createTbTipoFactura();
        createCmbTipoFactura();
    }//GEN-LAST:event_btnModificar2ActionPerformed

    private void txtTipoFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoFacturaKeyTyped
        
    }//GEN-LAST:event_txtTipoFacturaKeyTyped

    private void cmbIDNuevoFacturaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDNuevoFacturaItemStateChanged
        if(cmbIDNuevoFactura.getSelectedIndex()==0){
            txtTipoFactura.setText("");
            btnDesactivar3.setEnabled(false);

        }
        else{
            TipoFactura temp = tipoFacturaDao.findTipoFactura(cmbIDNuevoFactura.getSelectedIndex());
            txtTipoFactura.setText(temp.getTipoFactura());
            btnActivarDesactivar();
            
        }
    }//GEN-LAST:event_cmbIDNuevoFacturaItemStateChanged
 public void btnActivarDesactivar(){
        TipoFactura temp;
        temp = tipoFacturaDao.findTipoFactura(cmbIDNuevoFactura.getSelectedIndex());
        
        if(temp.getEstado()){
        btnDesactivar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar3.setText("Desactivar");  
        btnDesactivar3.setEnabled(true);
        }
        else{
            btnDesactivar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            btnDesactivar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png"))); // NOI18N
            btnDesactivar3.setText("Activar");
            btnDesactivar3.setEnabled(true);
        }
    }
    
    private void btnAgregar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar2ActionPerformed
            if(cmbIDNuevoFactura.getSelectedIndex()==0){
                
            }
            else{
                cmbIDNuevoFactura.setSelectedIndex(0);
            }
            Validaciones temp = new Validaciones();
            
            if(txtTipoFactura.getText().length()<2){
                JOptionPane.showMessageDialog(null,"Campo insuficiente, debe tener minimo 3 caracteres","INSUFICIENTE",0);
                return;
            }
            else{
                
            }
            
            if(temp.validacionTresLetras(txtTipoFactura.getText())){
                JOptionPane.showMessageDialog(null, "Tipo de Factura Invalido","ERROR",0);
                return;
            }
            else{
                
            }
            
            TipoFactura temp2 = new TipoFactura();
            temp2.setEstado(true);
            temp2.setTipoFactura(txtTipoFactura.getText());
            //temp2.setIDtipofactura(tipoFacturaDao.getTipoFacturaCount()+1);
            
            tipoFacturaDao.create(temp2);
            
            createTbTipoFactura();
            createCmbTipoFactura();
            tab_Ventas.setSelectedIndex(1);
            createCmbTipoFacturaVenta();
            tab_Ventas.setSelectedIndex(2);
            
            
            
        
        
    }//GEN-LAST:event_btnAgregar2ActionPerformed

    private void crearCmbIDTipoFactura(){
        DefaultComboBoxModel modelo1 = new DefaultComboBoxModel();
        cmbIDNuevoFactura.setModel(modelo1);
        modelo1.addElement("Nuevo");
        
        List<TipoFactura> temp = tipoFacturaDao.findTipoFacturaEntities();
        for(TipoFactura e : temp){
            modelo1.addElement(e.getIDtipofactura());
        }
    }
    
    private void tblNuevoCargoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNuevoCargoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblNuevoCargoMouseEntered

    private void tblNuevoCargoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNuevoCargoMouseClicked

        int column=0;
        int fila = tblNuevoCargo.getSelectedRow();
        if (fila > -1){
            cmbIDNuevoFactura.setSelectedIndex(Integer.parseInt(tblNuevoCargo.getModel().getValueAt(fila, column).toString()));
            txtTipoFactura.setText(String.valueOf(tblNuevoCargo.getValueAt(fila, ++column)));
           // btnActivarDesactivarCargo();
        }
    }//GEN-LAST:event_tblNuevoCargoMouseClicked

    private void btnSalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalir2ActionPerformed

    private void btnRegresar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar2ActionPerformed
        FrmMenu m = new FrmMenu();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresar2ActionPerformed

    private void btnAgregarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarVehiculoActionPerformed
        // TODO add your handling code here:
        crearTbVentaAgregarVehiculo();
    }//GEN-LAST:event_btnAgregarVehiculoActionPerformed

    private void btnAgregarPiezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPiezaActionPerformed
        
        crearTbVentaAgregarPieza();
        limpiarPieza();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarPiezaActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        System.exit(0);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed

        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void btnImprimirFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirFacturaActionPerformed

        if(cmbIDEmpleado.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"Seleccione su id de empleado","EMPLEADO SIN SELECCIONAR",0);
            return;
        }

        if(txtDocumentoCliente.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Ingrese un documento del cliente","CAMPO VACIO",0);
            return;
        }

        if(cmbTipoFacturaVenta.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Tipo de Factura sin seleccionar","CAMPO SIN SELECCIONAR",0);
            return;
        }
        
        List<Persona> temp = personaDao.findPersonaEntities();
        List<Cliente> temp2 = clienteDao.findClienteEntities();
        int auxID=1;
        boolean flag=false;
        for(Persona p : temp){
            if(p.getDocumento_id().equals(txtDocumentoCliente.getText())){
                for(Cliente c : temp2){
                    if(c.getId_Persona()==p.getId_persona()){
                        flag=true;
                        auxID=c.getId_cliente();
                    }
                }
            }
        }

        if(!flag){
            JOptionPane.showMessageDialog(null,"Cliente no encontrado","CLIENTE NO ENCONTRADO",0);
            return;
        }

        Factura f = new Factura();
        f.setIdEmpleado(cmbIDEmpleado.getSelectedIndex());
        f.setIdCliente(auxID);
        f.setiDtipofactura(cmbTipoFacturaVenta.getSelectedIndex());
        //f.setIDFactura(Integer.parseInt(txtNumFactura.getText()));

        Calendar fecha = new GregorianCalendar();
        String auxMinutos =(fecha.get(Calendar.MINUTE)<10)? "0"+(Integer.toString(fecha.get(Calendar.MINUTE))) : Integer.toString(fecha.get(Calendar.MINUTE));
        String auxFecha = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH)+1);
        String auxHora= (fecha.get(Calendar.HOUR_OF_DAY)<10)? "0"+(Integer.toString(fecha.get(Calendar.HOUR_OF_DAY))) : Integer.toString(fecha.get(Calendar.HOUR_OF_DAY));
        String auxSegundo=(fecha.get(Calendar.SECOND)<10)? "0"+(Integer.toString(fecha.get(Calendar.SECOND))) : Integer.toString(fecha.get(Calendar.SECOND));
        String auxDia=(fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.DAY_OF_MONTH))) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
        f.setFechaHora(String.valueOf(fecha.get(Calendar.YEAR))+auxFecha+auxDia+auxHora+auxMinutos+auxSegundo);
        f.setEstado(true);
        facturaDao.create(f);

        PiezaFactura temporal = new PiezaFactura();
        VehiculoFactura temporal2 = new VehiculoFactura();

        for(int i = 0;i<tbVenta.getRowCount();i++){
            if(tbVenta.getModel().getValueAt(i, 1).toString().charAt(0)=='1'){
                temporal.setIdFactura(Integer.parseInt(txtNumFactura.getText()));
                temporal.setIdPieza(Integer.parseInt(tbVenta.getModel().getValueAt(i, 0).toString()));
                temporal.setCantidad(Integer.parseInt(tbVenta.getModel().getValueAt(i, 3).toString()));

                try {
                    piezaFacturaDao.create(temporal);
                    //crear facturapieza
                } catch (Exception ex) {
                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                }
                Pieza decremento = piezaDao.findPieza(temporal.getIdPieza());
                int stock = decremento.getStock();
                stock=stock-temporal.getCantidad();
                decremento.setStock(stock);
                try {
                    piezaDao.edit(decremento);
                } catch (Exception ex) {
                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                temporal2.setIdFactura(Integer.parseInt(txtNumFactura.getText()));
                temporal2.setIdVehiculo(Integer.parseInt(tbVenta.getModel().getValueAt(i, 0).toString()));
                temporal2.setCantidad(tbVenta.getModel().getValueAt(i, 1).toString().substring(1, 17));

                try {
                    vehiculoFacturaDao.create(temporal2);
                } catch (Exception ex) {
                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                Vehiculo bajada = vehiculoDao.findVehiculo(temporal2.getIdVehiculo());
                int stock = bajada.getStock();
                stock-=1;
                bajada.setStock(stock);
                try {
                    vehiculoDao.edit(bajada);
                } catch (Exception ex) {
                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        
        
        int a= modelo.getRowCount()-1;
        for(int i=a;i>=0;i--){
            modelo.removeRow(i);
        }
        this.txtDocumentoCliente.setText("");
        this.setTxtNumFactura();
        this.setFechatxt();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImprimirFacturaActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        this.setVisible(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        
        ModalPiezas temp2 = new ModalPiezas(this,true);
        temp2.setLocationRelativeTo(null);
        temp2.setVisible(true);
        txtIDPieza.setText(String.valueOf(temp2.getId()));

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        ModalVehiculos temp2 = new ModalVehiculos(this,true);
        temp2.setLocationRelativeTo(null);
        temp2.setVisible(true);
        txtIDVehiculo.setText(String.valueOf(temp2.getId()));

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseClicked

    private void txtVINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVINActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVINActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(modelo.getRowCount()==0){
            
        }
        else{
        modelo.removeRow(modelo.getRowCount()-1);
        
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);
        
        double contenedorPrecio=0;
        for(int i=0;i<modelo.getRowCount();i++){
            contenedorPrecio+=Double.parseDouble((String) modelo.getValueAt(i, 4));
            
            
        }
        txtTotal.setText(formato1.format(contenedorPrecio));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtIDPiezaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDPiezaFocusLost
       Pattern pat = Pattern.compile("^\\d*$");
       Matcher mat = pat.matcher(txtIDPieza.getText());
       
       if(txtIDPieza.getText().equals("")){
           txtNombre.setText("");
           return;
       }
       
       Pieza xd=piezaDao.findPieza(Integer.parseInt(txtIDPieza.getText()));

        if(!mat.matches() || xd==null){
            txtNombre.setText("");
            
            //return;
            
        }
        else{
        txtNombre.setText(piezaDao.findPieza(Integer.parseInt(txtIDPieza.getText())).getNombre());
    }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDPiezaFocusLost

    private void txtIDPiezaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDPiezaKeyTyped
        
        char validar=evt.getKeyChar();
        if((validar<'0'||validar>'9')&&  (validar!=(char)KeyEvent.VK_BACKSPACE && (validar!=(char)KeyEvent.VK_SPACE)) ){
          JOptionPane.showMessageDialog(null,"Solo se admiten numeros para el ID de Pieza","Error!", JOptionPane.ERROR_MESSAGE);
          txtIDPieza.setText("");
          evt.consume();
            //   JOptionPane.showMessageDialog(null,"Solo se admiten letras para el nuevo tipo de pieza","Error!", JOptionPane.ERROR_MESSAGE);
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDPiezaKeyTyped

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        createTablaBusqueda();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void createTablaBusqueda(){
        DefaultTableModel modelo1 = new DefaultTableModel();
        jTable3.setModel(modelo1);
        modelo1.addColumn("Num de Factura");
        modelo1.addColumn("Cliente");
        modelo1.addColumn("Total de la factura");
        
        List<Factura> temp = facturaDao.findFacturaEntities();
        List<PiezaFactura> temp2 = piezaFacturaDao.findPiezaFacturaEntities();
        List<VehiculoFactura> temp3 = vehiculoFacturaDao.findVehiculoFacturaEntities();
        double valorFactura=0;
        double valorTotal=0;
        
        if(chkNumFactura.isSelected() && !chkCliente.isSelected() && !chkFecha.isSelected()){
            for(Factura f : temp){
                if(f.getIDFactura()==Integer.parseInt(txtNumFacturaBusqueda.getText())){
                    for(PiezaFactura p : temp2){
                        if(p.getIdFactura()==f.getIDFactura()){
                            List<HistoricoPrecioPieza> temp4 = historicoPiezaDao.findHistoricoPrecioPiezaEntities();
                            for(HistoricoPrecioPieza pp : temp4){
                                if(pp.getIdPieza()==p.getIdPieza() && pp.getFechaFinal()==null){//Cambiar la condicion de la fecha
                                    valorFactura+=(pp.getPrecio()*p.getCantidad());
                                }
                            }
                            
                            
                            
                            
                        }
                    }
                    for(VehiculoFactura v : temp3){
                        if(v.getIdFactura()==f.getIDFactura()){
                            List<HistoricoPrecioVehiculos> temp5 = historicoVehiculoDao.findHistoricoPrecioVehiculosEntities();
                            for(HistoricoPrecioVehiculos pv : temp5){
                                if(v.getIdVehiculo()==pv.getId_vehiculo() && pv.getFechaFinal()==null){//Cambiar la condicion de la fehca
                                    valorFactura+=(pv.getPrecio());                                    
                                }
                                
                            }
                        }
                    }
                    
                    
                    modelo1.addRow(new Object[]{f.getIDFactura(),"Nombre del Cliente",valorFactura});
                    
                    
                }
            }
            
            
        }
        
        
    }
    
    private void chkNumFacturaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkNumFacturaItemStateChanged
        if(chkNumFactura.isSelected()){
            txtNumFacturaBusqueda.setEnabled(true);
        }
        else{
            txtNumFacturaBusqueda.setEnabled(false);
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_chkNumFacturaItemStateChanged

    private void chkClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkClienteItemStateChanged

        if(chkCliente.isSelected()){
            txtClienteBusqueda.setEnabled(true);
        }
        else{
            txtClienteBusqueda.setEnabled(false);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_chkClienteItemStateChanged

    private void chkFechaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkFechaItemStateChanged

        if(chkFecha.isSelected()){
            txtFechaInicial.setEnabled(true);
            txtFechaFinal.setEnabled(true);
        }
        else{
            txtFechaInicial.setEnabled(false);
            txtFechaFinal.setEnabled(false);
        }
              
        // TODO add your handling code here:
    }//GEN-LAST:event_chkFechaItemStateChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.txtDocumentoCliente.setText("");
        int a= modelo.getRowCount()-1;
        for(int i=a;i>=0;i--){
            modelo.removeRow(i);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void setTxtNumFactura(){
        txtNumFactura.setText(String.valueOf(facturaDao.getFacturaCount()+1));
    }
    
    private void crearCmbIDPieza(){
     /*   DefaultComboBoxModel modelo1 = new DefaultComboBoxModel();
        cmbIDPieza.setModel(modelo1);
        modelo1.addElement("Seleccione");
        
        List<Pieza> temp = piezaDao.findPiezaEntities();
        for(Pieza e : temp){
            modelo1.addElement(e.getId_Pieza());
        }
     */   
    }
    
    private void crearCmbIDVehiculo(){
       /* DefaultComboBoxModel modelo1 = new DefaultComboBoxModel();
        cmbIDVehiculo.setModel(modelo1);
        modelo1.addElement("Seleccione");
        
        List<Vehiculo> temp = vehiculoDao.findVehiculoEntities();
        
        for(Vehiculo e : temp){
            modelo1.addElement(e.getId_vehiculo());
        }*/
    }
    
    private void setFechatxt(){
        
        Calendar fecha = new GregorianCalendar();
        String fecha1;
        String aux1,aux2,aux3;
        aux1 = Integer.toString(fecha.get(Calendar.YEAR));
        aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
        aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
        fecha1 = aux1+aux2+aux3;
        
        txtFecha.setText(aux3+"/"+aux2+"/"+aux1+"   "+fecha.get(Calendar.HOUR_OF_DAY)+":"+fecha.get(Calendar.MINUTE)/*+":"+fecha.get(Calendar.SECOND)*/);
        
    }
    
    private void crearTbVenta(){
        tbVenta.setModel(modelo);
        modelo.addColumn("ID");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Precio Unit");
        modelo.addColumn("Cant");
        modelo.addColumn("SubTotal");
    }
    DefaultTableModel modelo = new DefaultTableModel();
    private void crearCmbIDEmpleado(){
        DefaultComboBoxModel modelo1 = new DefaultComboBoxModel();
        cmbIDEmpleado.setModel(modelo1);
        modelo1.addElement("Seleccione");
        List<Empleado> temp = empleadoDao.findEmpleadoEntities();
        for(Empleado e : temp){
            modelo1.addElement(personaDao.findPersona(e.getId_Persona()).getNombre()+" "+personaDao.findPersona(e.getId_Persona()).getApellido());
        }
        
    }
    
    public void setCmbEmpleado(int valor){
        cmbIDEmpleado.setSelectedIndex(valor);
    }
    
    private void crearTbVentaAgregarVehiculo(){
        tbVenta.setModel(modelo);
        
        
        if("".equals(txtIDVehiculo.getText())){
            JOptionPane.showMessageDialog(null,"Por favor, seleccione un Vehiculo","ID SIN SELECCIONAR",0);
            return;
        }
        
         if("0".equals(txtIDVehiculo.getText())){
            JOptionPane.showMessageDialog(null,"No hay ningun Vehiculo con ID 0 ","ID NO RECONOCIDO",0);
            return;
        }
        
        
        Vehiculo temp = vehiculoDao.findVehiculo(Integer.parseInt(txtIDVehiculo.getText()));
        
        if(temp==null){
            JOptionPane.showMessageDialog(null,"Vehiculo no encontrado","ID NO VALIDO",0);
            return;
        }
        
        if(txtVIN.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Ingrese el VIN del Vehiculo","CAMPO VACíO",0);
            return;
        }
        
        Pattern pat = Pattern.compile("^(?=.*[0-9])(?=.*[A-z])[0-9A-z-]{17}$");
        Matcher mat = pat.matcher(txtVIN.getText());
        
        
        if(!mat.matches()){
            JOptionPane.showMessageDialog(null, "VIN no Valido","VIN INVALIDO",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            
        }
        
        
        
        if(temp.getStock()==0){
            JOptionPane.showMessageDialog(null, "No hay vehiculos disponibles en el inventario","Sin Stock",0);
            return;
        }
        
        if(!temp.isEstado()){
            JOptionPane.showMessageDialog(null, "Vehiculo descontinuada, por favor, Ponerse en contacto con el Gerente","VEHICULO DESCONTINUADO",0);
        }
     
        List<HistoricoPrecioVehiculos> temp2 = historicoVehiculoDao.findHistoricoPrecioVehiculosEntities();
        double aux=0.00;
        for(HistoricoPrecioVehiculos e : temp2){
            if(e.getId_vehiculo()==temp.getId_vehiculo() && e.getFechaFinal()==null){
                aux=e.getPrecio();
            }
        }
        
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);
        
        modelo.addRow(new Object[]{
            temp.getId_vehiculo(),"2"+txtVIN.getText()+Marcadao.findMarca(temp.getId_marca()).getMarca()+temp.getVin(),formato1.format(aux),1,formato1.format((aux))
        });
        
        
        double contenedorPrecio=0;
        for(int i=0;i<modelo.getRowCount();i++){
            contenedorPrecio+=Double.parseDouble((String) modelo.getValueAt(i, 4));
            
            
        }
        txtTotal.setText(formato1.format(contenedorPrecio));
        
    }
    
    private void crearTbVentaAgregarPieza(){
        //label1.setText("11223");
        tbVenta.setModel(modelo);
        
        
        if("".equals(txtIDPieza.getText())){
            JOptionPane.showMessageDialog(null,"Por favor, seleccione una pieza","ID SIN SELECCIONAR",0);
            return;
        }
        
        if("0".equals(txtIDPieza.getText())){
            JOptionPane.showMessageDialog(null,"No hay ninguna pieza con ID 0 ","ID NO RECONOCIDO",0);
            return;
        }
        
        Pieza temp = piezaDao.findPieza(Integer.parseInt(txtIDPieza.getText()));
        
        if(temp==null){
            JOptionPane.showMessageDialog(null,"Pieza no encontrada","ID NO VALIDO",0);
            return;
        }
        
        if(txtCantidad.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Ingrese la cantidad","CAMPO VACíO",0);
            return;
        }
        
        if(temp.getStock()==0){
            JOptionPane.showMessageDialog(null, "No hay piezas en el inventario","Sin Stock",0);
            return;
        }
        
        if(!temp.isEstado()){
            JOptionPane.showMessageDialog(null, "Pieza descontinuada, por favor, Ponerse en contacto con el Gerente","PIEZA DESCONTINUADA",0);
        }
     
        List<HistoricoPrecioPieza> temp2 = historicoPiezaDao.findHistoricoPrecioPiezaEntities();
        double aux=0.00;
        for(HistoricoPrecioPieza e : temp2){
            if(e.getIdPieza()==temp.getId_Pieza() && e.getFechaFinal()==null){
                aux=e.getPrecio();
            }
        }
        
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);
        
        modelo.addRow(new Object[]{
            temp.getId_Pieza(),"1"+temp.getNombre()+temp.getCarateristica_Pieza(),formato1.format(aux),txtCantidad.getText(),formato1.format((aux*Double.parseDouble(txtCantidad.getText())))
        });
        
        double contenedorPrecio=0;
        for(int i=0;i<modelo.getRowCount();i++){
            contenedorPrecio+=Double.parseDouble((String) modelo.getValueAt(i, 4));
            
            
        }
        txtTotal.setText(formato1.format(contenedorPrecio));
    }
    
    private void limpiarPieza(){
        txtIDPieza.setText("");
        txtNombre.setText("");
        txtCantidad.setText("");
    }
    
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
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar2;
    private javax.swing.JButton btnAgregarPieza;
    private javax.swing.JButton btnAgregarVehiculo;
    private javax.swing.JButton btnDesactivar3;
    private javax.swing.JButton btnImprimirFactura;
    private javax.swing.JButton btnLimpiar2;
    private javax.swing.JButton btnModificar2;
    private javax.swing.JButton btnRegresar2;
    private javax.swing.JButton btnSalir2;
    private javax.swing.JCheckBox chkCliente;
    private javax.swing.JCheckBox chkFecha;
    private javax.swing.JCheckBox chkNumFactura;
    public static javax.swing.JComboBox<String> cmbIDEmpleado;
    private javax.swing.JComboBox<String> cmbIDNuevoFactura;
    private javax.swing.JComboBox<String> cmbTipoFacturaVenta;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel label1;
    private javax.swing.JTabbedPane tab_Ventas;
    private javax.swing.JTable tbVenta;
    private javax.swing.JTable tblNuevoCargo;
    private javax.swing.JFormattedTextField txtCantidad;
    private javax.swing.JTextField txtClienteBusqueda;
    private javax.swing.JTextField txtDocumentoCliente;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JFormattedTextField txtFechaFinal;
    private javax.swing.JFormattedTextField txtFechaInicial;
    public static javax.swing.JFormattedTextField txtIDPieza;
    private javax.swing.JFormattedTextField txtIDVehiculo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumFactura;
    private javax.swing.JFormattedTextField txtNumFacturaBusqueda;
    private javax.swing.JTextField txtTipoFactura;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtVIN;
    // End of variables declaration//GEN-END:variables
}
