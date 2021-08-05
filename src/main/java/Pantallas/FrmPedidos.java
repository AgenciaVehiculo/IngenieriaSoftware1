/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import Clases.Cliente;
import Clases.Detalle_Pedido_Vehiculo;
import Clases.Detalle_Pedido_pieza;
import Clases.Marca;
import Clases.Pedido;
import Clases.Persona;
import Clases.Pieza;
import Clases.Tipo_Documento;
import Clases.Vehiculo;
import JPAController.Detalle_Pedido_VehiculoJpaController;
import JPAController.Detalle_Pedido_piezaJpaController;
import JPAController.MarcaJpaController;
import JPAController.PedidoJpaController;
import JPAController.PiezaJpaController;
import JPAController.VehiculoJpaController;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
public class FrmPedidos extends javax.swing.JFrame {

    /**
     * Creates new form Empleados
     */
    PedidoJpaController Pedidodao = new PedidoJpaController();
    Detalle_Pedido_VehiculoJpaController PedidoVehiculodao = new Detalle_Pedido_VehiculoJpaController();
    Detalle_Pedido_piezaJpaController PedidoPiezadao = new Detalle_Pedido_piezaJpaController();
    PiezaJpaController PiezaDao = new PiezaJpaController();
    VehiculoJpaController Vehiculodao = new VehiculoJpaController();
    MarcaJpaController MarcaDao = new MarcaJpaController();
    public FrmPedidos() {
        initComponents();
         setIconImage(new ImageIcon(getClass().getResource("/Img/CarSoft-removebg-preview.png")).getImage());
        this.setExtendedState(MAXIMIZED_BOTH);
        btnDesactivar3.setEnabled(false);
        createComboBoxPedido();
        createTablePedido();
        createComboPieza();
        createComboVehiculo();
        txtFechaFinal.setEnabled(false);
        btnModificar3.setEnabled(false);
        this.jPanel3.setBackground( new Color(0, 75, 143));
        this.getContentPane().setBackground(new Color(0, 75, 143));
        setIconImage(new ImageIcon(getClass().getResource("/Img/CarSoft-removebg-preview.png")).getImage());
        this.btnAgregar3.setBackground( new Color(14, 209, 69));
        this.btnSalir.setBackground( new Color(236, 28, 36));
        this.btnModificar3.setBackground( new Color(14, 209, 69));
        this.btnLimpiar3.setBackground( new Color(14, 209, 69));
        this.btnDesactivar3.setBackground( new Color(14, 209, 69));
        this.btnRegresar.setBackground( new Color(14, 209, 69));
        tblPedido.setForeground(Color.WHITE);
        tblPedido.setBackground(Color.BLACK);
        cmbIDVehiculo.setEnabled(true);
        cmbIDVehiculo.setEnabled(true);
    }
public void btnActivarDesactivarPedido(){
        Pedido temp = new Pedido();
        temp = Pedidodao.findPedido(cmbIDPedido.getSelectedIndex());
        
        if(temp.isEstado()){
        btnDesactivar3.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnDesactivar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar3.setText("Desactivar");  
        btnDesactivar3.setEnabled(true);
        }
        else{
            btnDesactivar3.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar3.setText("Activar");
            btnDesactivar3.setEnabled(true);
        }
        }
public void createComboBoxPedido(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        cmbIDPedido.setModel(modelo);
        List<Pedido> temp = Pedidodao.findPedidoEntities();
        modelo.addElement("Nuevo");
        temp.forEach((c) -> {
        modelo.addElement(c.getId_pedido());
        });
        }
public void createComboVehiculo(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        cmbIDVehiculo.setModel(modelo);
        List<Vehiculo> temp = Vehiculodao.findVehiculoEntities();
        List<Marca> tempp = MarcaDao.findMarcaEntities();
        modelo.addElement("Seleccione...");
        for (Vehiculo cc : temp){     
            for(Marca pp : tempp){
        temp.forEach((tpp)-> {
        tempp.forEach((tp) -> {
            if(tpp.getId_marca()== tp.getIdMarca()){
            modelo.addElement(tpp.getId_vehiculo()+". "+tp.getMarca());
            }
        });   
        });          
            return;
        }
        }
                }
public void createComboPieza(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        cmbIDPieza.setModel(modelo);
        List<Pieza> temp = PiezaDao.findPiezaEntities();
        modelo.addElement("Seleccione...");
        temp.forEach((tp) -> {
            modelo.addElement(tp.getId_Pieza()+". "+tp.getNombre());
        });
                }
    private void setFechatxt(){
        
        Calendar fecha = new GregorianCalendar();
        String aux1,aux2,aux3;
        aux1 = Integer.toString(fecha.get(Calendar.YEAR));
        aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
        aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
        
        txtFechaFinal.setText(aux1+"-"+aux2+"-"+aux3);
        
    }
public void createTablePedido(){
        DefaultTableModel modelo = new DefaultTableModel();
        tblPedido.setModel(modelo);
        modelo.addColumn("ID Pedido");
        modelo.addColumn("Vehículo");
        modelo.addColumn("Cantidad de Vehículos Pedidos");
        modelo.addColumn("Precio de Cada Vehículo");
        modelo.addColumn("Pieza");
        modelo.addColumn("Cantidad de Piezas Pedidas");
        modelo.addColumn("Precio de Cada Pieza");
        modelo.addColumn("Monto total del pedido");
        modelo.addColumn("Fecha pedido");
        modelo.addColumn("Fecha de Entrega");
        modelo.addColumn("Estado");
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00",separadoresPersonalizados);
        List<Pedido> tempo = Pedidodao.findPedidoEntities();
        List<Detalle_Pedido_Vehiculo> temp = PedidoVehiculodao.findDetalle_Pedido_VehiculoEntities();
        int auxcantidadvehiculos=0;
        double auxpreciovehiculo=0;
        List<Vehiculo> tempv = Vehiculodao.findVehiculoEntities();
        String auxmarca="";
        int auxVeh=0;
        String veh="";
        List<Detalle_Pedido_pieza> tempp = PedidoPiezadao.findDetalle_Pedido_piezaEntities();
        List<Pieza> temppp = PiezaDao.findPiezaEntities();
        String auxpieza="";
        int auxidpieza=0;
        String pieza="";
        String auxfecha="";
        String auxfechab="";
        List<Marca> tempm = MarcaDao.findMarcaEntities();
        int auxcantidadpiezas=0;
        double auxpreciopieza=0;
        for(Pedido p : tempo){
            for(Detalle_Pedido_Vehiculo cc : temp){
                if(p.getId_pedido()==cc.getId_pedido()){
                    auxcantidadvehiculos=(cc.getCantidad());
                    auxpreciovehiculo=cc.getPrecio();
                    for(Vehiculo v : tempv){
                if(cc.getId_vehiculo()==v.getId_vehiculo()){
                    for(Marca m : tempm){
                        if(v.getId_marca()==m.getIdMarca()){
                    auxmarca=(m.getMarca());
                    auxVeh=v.getId_vehiculo();
                    veh=auxVeh+". "+auxmarca;
                        }
                    }
                }   
            }
                }
             
            }
            auxfecha=(p.getFecha_pedido().substring(8, 10)+"/"+p.getFecha_pedido().substring(5, 7)+"/"+p.getFecha_pedido().substring(0, 4));
            if(p.getFecha_entrega()==null) {
                                            auxfechab="";
                                    } else {
                                        auxfechab=(p.getFecha_entrega().substring(8, 10)+"/"+p.getFecha_entrega().substring(5, 7)+"/"+p.getFecha_entrega().substring(0, 4));
                                    } 
            for(Detalle_Pedido_pieza tp : tempp){
                if(p.getId_pedido() == tp.getId_pedido()){
                    auxcantidadpiezas=(tp.getCantidad());
                    auxpreciopieza=tp.getPrecio();
                    for(Pieza pp : temppp){
                if(tp.getId_pieza()==pp.getId_Pieza()){
                    auxpieza=pp.getNombre();
                    auxidpieza=pp.getId_Pieza();
                    pieza=(auxidpieza+". "+auxpieza);
                }   
            }
                }
            
            }
            modelo.addRow(
                    new Object[]{
                        p.getId_pedido(),
                        veh,
                        auxcantidadvehiculos,
                         formato1.format(auxpreciovehiculo),
                        pieza,
                        auxcantidadpiezas,
                         formato1.format(auxpreciopieza),
                        p.getMonto_pedido(),
                        auxfecha,
                        auxfechab,
                        p.isEstado()? "Activo" : "Inactivo",
                      
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

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        cmbIDPedido = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPedido = new javax.swing.JTable();
        btnAgregar3 = new javax.swing.JButton();
        btnModificar3 = new javax.swing.JButton();
        btnLimpiar3 = new javax.swing.JButton();
        btnDesactivar3 = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCantidadVehiculos = new javax.swing.JTextField();
        txtCantidadPiezas = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cmbIDPieza = new javax.swing.JComboBox<>();
        cmbIDVehiculo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtPrecioPieza = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPrecioVehiculo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtFechaFinal = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmbIDPedido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", " ", " " }));
        cmbIDPedido.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDPedidoItemStateChanged(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Pedidos");

        tblPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Pedido", "Fecha del Pedido", "Cantidad de Vehículos Pedidos", "Cantidad de Piezas Pedidas", "Fecha de Entrega"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPedidoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPedido);

        btnAgregar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar3.setText("Agregar");
        btnAgregar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar3ActionPerformed(evt);
            }
        });

        btnModificar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar3.setText("Modificar");
        btnModificar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar3ActionPerformed(evt);
            }
        });

        btnLimpiar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar3.setText("Limpiar");
        btnLimpiar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar3ActionPerformed(evt);
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

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Cantidad de Vehículos:");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("ID Pedido:");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cantidad de Piezas:");

        txtCantidadVehiculos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCantidadVehiculosFocusLost(evt);
            }
        });

        txtCantidadPiezas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCantidadPiezasFocusLost(evt);
            }
        });

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Pieza:");

        cmbIDPieza.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDPiezaItemStateChanged(evt);
            }
        });
        cmbIDPieza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIDPiezaActionPerformed(evt);
            }
        });

        cmbIDVehiculo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDVehiculoItemStateChanged(evt);
            }
        });
        cmbIDVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIDVehiculoActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText(" Vehículo:");

        txtPrecioPieza.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecioPiezaFocusLost(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Lps.");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Precio del  Vehículo:");

        txtPrecioVehiculo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecioVehiculoFocusLost(evt);
            }
        });
        txtPrecioVehiculo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioVehiculoKeyTyped(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Fecha de Entrega:");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Precio de la pieza:");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Lps.");

        txtFechaFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        txtFechaFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaFinalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnAgregar3)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar3)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiar3)
                                .addGap(18, 18, 18)
                                .addComponent(btnDesactivar3))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))))
                                .addGap(47, 47, 47)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbIDPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbIDVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCantidadVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtPrecioVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(47, 47, 47)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCantidadPiezas, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbIDPieza, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtPrecioPieza, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(299, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRegresar)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(590, 590, 590)
                                .addComponent(btnSalir)))
                        .addGap(18, 18, 18))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregar3)
                            .addComponent(btnModificar3)
                            .addComponent(btnLimpiar3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(39, 39, 39))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(cmbIDPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(cmbIDVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtCantidadVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel2))
                                            .addComponent(jLabel9)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel13)
                                            .addComponent(cmbIDPieza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCantidadPiezas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtPrecioPieza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11))
                                        .addGap(4, 4, 4))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSalir))
                                .addGap(122, 122, 122)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(txtPrecioVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addComponent(jLabel8)
                            .addComponent(txtFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(btnRegresar)
                .addGap(413, 413, 413))
        );

        jTabbedPane2.addTab("Pedidos", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1091, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbIDPedidoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDPedidoItemStateChanged
       /* if(cmbIDPedido.getSelectedIndex()==0){
            //txtIDPieza.setSelectedIndex(0);
            jCmbTipoPieza.setSelectedIndex(0);
            jTxtAreaCaracteristica.setText("");
            jFtxtStock.setText("");
            jFtxtStockMaximo.setText("");
            jFtxtStockMinimo.setText("");
            jFtxtPrecio.setText("");

        }
        else{
            Pieza e1;
            e1=piezaDao.findPieza( cmbIDPedido.getSelectedIndex());
            jCmbTipoPieza.setSelectedIndex(e1.getId_Tipo_Pieza()-1);
            jTxtAreaCaracteristica.setText(e1.getCarateristica_Pieza());
            jFtxtStock.setText(Integer.toString(e1.getStock()));
            jFtxtStockMaximo.setText(Integer.toString(e1.getStock_Maximo()));
            jFtxtStockMinimo.setText(Integer.toString(e1.getStock_Minimo()));
            List<HistoricoPrecioPieza> h1 = historicoPieza.findHistoricoPrecioPiezaEntities();
            for(HistoricoPrecioPieza p2 : h1){
                if(p2.getIdPieza() == e1.getId_Pieza()){
                    if(p2.getFechaFinal()==null){
                        jFtxtPrecio.setText(Double.toString(p2.getPrecio()));
                        break;
                    }
                    else
                    jFtxtPrecio.setText("0.00");

                }
                else{
                    jFtxtPrecio.setText("0.00");
                }
            }
            btnActivarDesactivarPieza();

        }*/

        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIDPedidoItemStateChanged

    private void tblPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPedidoMouseClicked


        txtFechaFinal.setEnabled(true);
        btnAgregar3.setEnabled(false);
        btnModificar3.setEnabled(true);
                    DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
            separadoresPersonalizados.setDecimalSeparator('.');
            DecimalFormat formato1 = new DecimalFormat("#.00",separadoresPersonalizados);
        int column=0;
        String auxfechab="";
        int fila = tblPedido.getSelectedRow();
        if (fila > -1){
            Pedido temp = Pedidodao.findPedido(Integer.parseInt(tblPedido.getModel().getValueAt(fila, column).toString()));
            List<Vehiculo> tempv = Vehiculodao.findVehiculoEntities();
            List<Pieza> tempp = PiezaDao.findPiezaEntities();
            List<Marca> tempm = MarcaDao.findMarcaEntities();
            List<Detalle_Pedido_Vehiculo> tempdpv = PedidoVehiculodao.findDetalle_Pedido_VehiculoEntities();
            List<Detalle_Pedido_pieza> tempdpp = PedidoPiezadao.findDetalle_Pedido_piezaEntities();
            cmbIDPedido.setSelectedIndex((temp.getId_pedido()));
            for(Detalle_Pedido_Vehiculo b : tempdpv){
                if(b.getId_pedido()==temp.getId_pedido()){
                for(Vehiculo cc : tempv){
                if(b.getId_vehiculo()==b.getId_vehiculo()){
                for(Marca mm : tempm){
                    if(mm.getIdMarca()==cc.getId_marca()){
                        cmbIDVehiculo.setSelectedItem((b.getId_vehiculo()+". "+mm.getMarca()));
                        txtCantidadVehiculos.setText(String.valueOf(b.getCantidad()));
                        txtPrecioVehiculo.setText(String.valueOf(formato1.format(b.getPrecio())));
                    }
                }
                }
            }
            } 
            }
            for(Detalle_Pedido_pieza v : tempdpp){
                if(v.getId_pedido()==temp.getId_pedido()){
                for(Pieza pp : tempp){
                if(v.getId_pieza()==pp.getId_Pieza()){
                    cmbIDPieza.setSelectedItem((v.getId_pieza()+". "+pp.getNombre()));
                    txtCantidadPiezas.setText(String.valueOf(v.getCantidad()));
                    txtPrecioPieza.setText(String.valueOf(formato1.format(v.getPrecio())));
                    
                }
            }
            }
                
            }
            if(temp.getFecha_entrega()==null) {
                                            auxfechab="";
                                    } else {
                                        auxfechab=(temp.getFecha_entrega().substring(8, 10)+"/"+temp.getFecha_entrega().substring(5, 7)+"/"+temp.getFecha_entrega().substring(0, 4));
                                    }
                                    txtFechaFinal.setText(auxfechab);
            /*if(null== temp.getFecha_entrega()){
                txtFechaEntrega.setText("");
            } else switch (temp.getFecha_entrega()) {
                case "":
                    txtFechaEntrega.setText("");
                    break;
                default:
                    txtFechaEntrega.setText(String.valueOf(temp.getFecha_entrega()));
                    break;
            }*/
            btnActivarDesactivarPedido();
        
        }
    }//GEN-LAST:event_tblPedidoMouseClicked

    private void btnAgregar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar3ActionPerformed

        if(cmbIDPedido.getSelectedIndex()==0){

        }
        else{
            cmbIDPedido.setSelectedIndex(0);
        }
       /*if(cmbIDVehiculo.getSelectedIndex()==0){

        }
        else{
            cmbIDVehiculo.setSelectedIndex(0);
        }
        if(cmbIDPieza.getSelectedIndex()==0){
        }
        else{
            cmbIDPieza.setSelectedIndex(0);
        }*/
        if("".equals(txtPrecioPieza.getText())){
               JOptionPane.showMessageDialog(null,"El campo de precio de la pieza esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
               return;
           }
           else{
               
           }

            if (!ValidacionNumerosSiTienenDecimal(txtPrecioPieza.getText())){
           JOptionPane.showMessageDialog(null,"El precio de la Pieza solo puede contener Números positivos","Error!", JOptionPane.ERROR_MESSAGE);
           txtPrecioPieza.requestFocus();
           return;
            }else{
           
            }
        if("".equals(txtPrecioVehiculo.getText())){
               JOptionPane.showMessageDialog(null,"El campo de precio del vehículo esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
               return;
           }
           else{
               
           }
            if (!ValidacionNumerosSiTienenDecimal(txtPrecioVehiculo.getText())){
           JOptionPane.showMessageDialog(null,"El precio del vehículo solo puede contener Números positivos","Error!", JOptionPane.ERROR_MESSAGE);
           txtPrecioVehiculo.requestFocus();
           return;
            }else{
           
            }
        
        if("".equals(txtCantidadVehiculos.getText())){
               JOptionPane.showMessageDialog(null,"El campo de la cantidad de Vehículos esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
               return;
           }
           else{
               
           }
            if (!ValidacionNumeros(txtCantidadVehiculos.getText())){
           JOptionPane.showMessageDialog(null,"La Cantidad de vehículos debe ser de Números enteros positivos","Error!", JOptionPane.ERROR_MESSAGE);
           txtCantidadVehiculos.requestFocus();
           return;
            }else{
           
            }
        if("".equals(txtCantidadPiezas.getText())){
               JOptionPane.showMessageDialog(null,"El campo de cantidad de piezas esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
               return;
           }
           else{
               
           }
            if (!ValidacionNumeros(txtCantidadPiezas.getText())){
           JOptionPane.showMessageDialog(null,"La Cantidad de piezas debe ser de Números enteros positivos","Error!", JOptionPane.ERROR_MESSAGE);
           txtCantidadPiezas.requestFocus();
           return;
            }else{
           
            }
        Pedido temp = new Pedido();
        temp.setEstado(true);
        temp.setMonto_pedido(((Double.parseDouble(txtPrecioPieza.getText())*(Integer.parseInt(txtCantidadPiezas.getText())))+(Double.parseDouble(txtPrecioVehiculo.getText())*(Integer.parseInt(txtCantidadVehiculos.getText())))));
        
        int auxCmbPieza=cmbIDPieza.getSelectedIndex();
        
        int auxCmbVehiculo=cmbIDVehiculo.getSelectedIndex();
        //JOptionPane.showMessageDialog(null,auxCmbPieza+" "+auxCmbVehiculo);
        
        temp.setId_pedido(Pedidodao.getPedidoCount()+1);
        Calendar fecha = new GregorianCalendar();
           String fecha1;
           String aux1,aux2,aux3;
           aux1 = Integer.toString(fecha.get(Calendar.YEAR));
           aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
           aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
           fecha1 = aux1+aux2+aux3;
        temp.setFecha_pedido(fecha1);

        try {
            Pedidodao.create(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Detalle_Pedido_Vehiculo tempp = new Detalle_Pedido_Vehiculo();
        tempp.setId_pedido_Vehiculo(PedidoVehiculodao.getDetalle_Pedido_VehiculoCount()+1);
        
        tempp.setId_pedido(Pedidodao.getPedidoCount());
        tempp.setId_vehiculo(auxCmbVehiculo);
        
        
        tempp.setCantidad(Integer.parseInt(txtCantidadVehiculos.getText()));
        tempp.setPrecio(Double.parseDouble(txtPrecioVehiculo.getText()));
        
        try {
            PedidoVehiculodao.create(tempp);
        } catch (Exception ex) {
            Logger.getLogger(FrmPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Detalle_Pedido_pieza temppp = new Detalle_Pedido_pieza();
        temppp.setId_pedido_pieza(PedidoPiezadao.getDetalle_Pedido_piezaCount()+1);
        
        temppp.setId_pedido((Pedidodao.getPedidoCount()));
        temppp.setId_pieza(auxCmbPieza);
        temppp.setCantidad(Integer.parseInt(txtCantidadPiezas.getText()));
        temppp.setPrecio(Double.parseDouble(txtPrecioPieza.getText()));
        try {
            PedidoPiezadao.create(temppp);
        } catch (Exception ex) {
            Logger.getLogger(FrmPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null,"Datos Guardados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE);
        createTablePedido();
        createComboVehiculo();
        createComboPieza();
        btnAgregar3.setEnabled(true);
        btnModificar3.setEnabled(false);
        Limpiar();
        
    }//GEN-LAST:event_btnAgregar3ActionPerformed

    private void btnModificar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar3ActionPerformed

       if(cmbIDVehiculo.getSelectedIndex()==0){

        }
        else{
            //cmbIDVehiculo.setSelectedIndex(0);
        }
        if(cmbIDPieza.getSelectedIndex()==0){
        }
        else{
            //cmbIDPieza.setSelectedIndex(0);
        }
        if("".equals(txtPrecioPieza.getText())){
               JOptionPane.showMessageDialog(null,"El campo de precio de la pieza esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
               return;
           }
           else{
               
           }

            if (!ValidacionNumerosSiTienenDecimal(txtPrecioPieza.getText())){
           JOptionPane.showMessageDialog(null,"El precio de la Pieza solo puede contener Números positivos","Error!", JOptionPane.ERROR_MESSAGE);
           txtPrecioPieza.requestFocus();
           return;
            }else{
           
            }
        if("".equals(txtPrecioVehiculo.getText())){
               JOptionPane.showMessageDialog(null,"El campo de precio del vehículo esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
               return;
           }
           else{
               
           }
            if (!ValidacionNumerosSiTienenDecimal(txtPrecioVehiculo.getText())){
           JOptionPane.showMessageDialog(null,"El precio del vehículo solo puede contener Números positivos","Error!", JOptionPane.ERROR_MESSAGE);
           txtPrecioVehiculo.requestFocus();
           return;
            }else{
           
            }
            if (!ValidacionFechaDDMMYYYY(txtFechaFinal.getText())){
           JOptionPane.showMessageDialog(null,"El Formato de fecha es Incorrecto! El formato debe ser DD/MM/YYYY","Error!", JOptionPane.ERROR_MESSAGE);
           txtFechaFinal.requestFocus();
           return;
            }else{
            }
        
        if("".equals(txtCantidadVehiculos.getText())){
               JOptionPane.showMessageDialog(null,"El campo de la cantidad de Vehículos esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
               return;
           }
           else{
               
           }
            if (!ValidacionNumeros(txtCantidadVehiculos.getText())){
           JOptionPane.showMessageDialog(null,"La Cantidad de vehículos debe ser de Números enteros positivos","Error!", JOptionPane.ERROR_MESSAGE);
           txtCantidadVehiculos.requestFocus();
           return;
            }else{
           
            }
        if("".equals(txtCantidadPiezas.getText())){
               JOptionPane.showMessageDialog(null,"El campo de cantidad de piezas esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
               return;
           }
           else{
               
           }
            if (!ValidacionNumeros(txtCantidadPiezas.getText())){
           JOptionPane.showMessageDialog(null,"La Cantidad de piezas debe ser de Números enteros positivos","Error!", JOptionPane.ERROR_MESSAGE);
           txtCantidadPiezas.requestFocus();
           return;
            }else{
           
            }
        Pedido temp;
        temp = Pedidodao.findPedido(cmbIDPedido.getSelectedIndex());
        temp.setMonto_pedido((Double.parseDouble(txtPrecioPieza.getText())*(Integer.parseInt(txtCantidadPiezas.getText())))+(Double.parseDouble(txtPrecioVehiculo.getText())*(Integer.parseInt(txtCantidadVehiculos.getText()))));
        temp.setEstado(temp.isEstado());
        temp.setFecha_pedido(temp.getFecha_pedido());
        String auxfecha="";
           String auxfechafinal="";
           String anio="";
           String mes="";
           String dia="";
           auxfecha=txtFechaFinal.getText();
           anio=auxfecha.substring(6,10);
           mes=auxfecha.substring(3,5);
           dia=auxfecha.substring(0,2);
           auxfechafinal=anio+"-"+mes+"-"+dia;
        temp.setFecha_entrega(auxfechafinal);

        try {
            Pedidodao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        Detalle_Pedido_Vehiculo tempp = new Detalle_Pedido_Vehiculo();
                            tempp = PedidoVehiculodao.findDetalle_Pedido_Vehiculo(cmbIDPedido.getSelectedIndex());
                            tempp.setId_pedido(cmbIDPedido.getSelectedIndex());
                            tempp.setId_vehiculo(cmbIDVehiculo.getSelectedIndex());
                            tempp.setCantidad(Integer.parseInt(txtCantidadVehiculos.getText()));
                            tempp.setPrecio(Double.parseDouble(txtPrecioVehiculo.getText()));

        
        try {
            PedidoVehiculodao.edit(tempp);
        } catch (Exception ex) {
            Logger.getLogger(FrmPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        Vehiculo temp3 = new Vehiculo();
        temp3 = Vehiculodao.findVehiculo(cmbIDVehiculo.getSelectedIndex());
        temp3.setStock(temp3.getStock()+(Integer.parseInt(txtCantidadVehiculos.getText())));
        
        try {
            Vehiculodao.edit(temp3);
        } catch (Exception ex) {
            Logger.getLogger(FrmPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        Detalle_Pedido_pieza temppp = new Detalle_Pedido_pieza();
                            temppp = PedidoPiezadao.findDetalle_Pedido_pieza(PedidoPiezadao.getDetalle_Pedido_piezaCount());
                            temppp.setId_pedido(cmbIDPedido.getSelectedIndex());
                            temppp.setId_pieza(cmbIDPieza.getSelectedIndex());
                            temppp.setCantidad(Integer.parseInt(txtCantidadPiezas.getText()));
                            temppp.setPrecio(Double.parseDouble(txtPrecioPieza.getText()));
        try {
            PedidoPiezadao.edit(temppp);
        } catch (Exception ex) {
            Logger.getLogger(FrmPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        Pieza temp4 = new Pieza();
        temp4 = PiezaDao.findPieza(cmbIDPieza.getSelectedIndex());
        temp4.setStock(temp4.getStock()+(Integer.parseInt(txtCantidadPiezas.getText())));
        try {
            PiezaDao.edit(temp4);
        } catch (Exception ex) {
            Logger.getLogger(FrmPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null,"Datos Guardados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE);
        createTablePedido();
        createComboVehiculo();
        createComboPieza();
        btnAgregar3.setEnabled(true);
        btnModificar3.setEnabled(false);
        Limpiar();
        
    }//GEN-LAST:event_btnModificar3ActionPerformed
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
    private void btnLimpiar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar3ActionPerformed
        Limpiar();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiar3ActionPerformed
private void Limpiar(){
        cmbIDPedido.setSelectedIndex(0);
        cmbIDVehiculo.setSelectedIndex(0);
        cmbIDPieza.setSelectedIndex(0);
        txtCantidadVehiculos.setText("");
        txtCantidadPiezas.setText("");
        txtPrecioPieza.setText("");
        txtPrecioVehiculo.setText("");
        txtFechaFinal.setText("");
        btnDesactivar3.setEnabled(false);
        btnModificar3.setEnabled(false);
        btnAgregar3.setEnabled(true);
        txtFechaFinal.setEnabled(false);
}
    private void btnDesactivar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar3ActionPerformed
        Pedido temp;
        temp = Pedidodao.findPedido(cmbIDPedido.getSelectedIndex());
        if(temp.isEstado()){
            temp.setEstado(false);
            JOptionPane.showMessageDialog(null,"Pedido Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE);
        }
        else{
            temp.setEstado(true);
            JOptionPane.showMessageDialog(null,"Pedido Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE);
        }
        try {
            Pedidodao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        createTablePedido();
        btnActivarDesactivarPedido();
        btnDesactivar3.setEnabled(false);
        Limpiar();
        btnAgregar3.setEnabled(true);
        btnModificar3.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDesactivar3ActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        FrmMenu m = new FrmMenu();
        m.setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void cmbIDPiezaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDPiezaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIDPiezaItemStateChanged

    private void cmbIDPiezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIDPiezaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIDPiezaActionPerformed

    private void cmbIDVehiculoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDVehiculoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIDVehiculoItemStateChanged

    private void cmbIDVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIDVehiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIDVehiculoActionPerformed

    private void txtPrecioVehiculoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVehiculoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioVehiculoKeyTyped

    private void txtCantidadVehiculosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadVehiculosFocusLost
        /*if (NumerosEnteros(txtCantidadVehiculos.getText())){
        }else{
           JOptionPane.showMessageDialog(null,"Formato incorrecto de la Cantidad de Vehículos, debe ser un entero positivo","Error!", JOptionPane.ERROR_MESSAGE);
           txtCantidadVehiculos.requestFocus();
        }*/
    }//GEN-LAST:event_txtCantidadVehiculosFocusLost

    private void txtCantidadPiezasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadPiezasFocusLost
        /*if (NumerosEnteros(txtCantidadPiezas.getText())){
        }else{
           JOptionPane.showMessageDialog(null,"Formato incorrecto de la Cantidad de Piezas, debe ser un entero positivo.","Error!", JOptionPane.ERROR_MESSAGE);
           txtCantidadPiezas.requestFocus();
        }*/
    }//GEN-LAST:event_txtCantidadPiezasFocusLost

    private void txtPrecioVehiculoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioVehiculoFocusLost
        /*if (NumerosEnterosDecimales(txtPrecioVehiculo.getText())){
        }else{
           JOptionPane.showMessageDialog(null,"Formato incorrecto del Precio de Vehículos, debe ser un entero positivo y con 2 decimales","Error!", JOptionPane.ERROR_MESSAGE);
           txtPrecioVehiculo.requestFocus();
        }*/
    }//GEN-LAST:event_txtPrecioVehiculoFocusLost

    private void txtPrecioPiezaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioPiezaFocusLost
        /*if (NumerosEnterosDecimales(txtPrecioPieza.getText())){
        }else{
           JOptionPane.showMessageDialog(null,"Formato incorrecto del Precio de piezas, debe ser un entero positivo y con 2 decimales","Error!", JOptionPane.ERROR_MESSAGE);
           txtPrecioPieza.requestFocus();
        }*/
    }//GEN-LAST:event_txtPrecioPiezaFocusLost

    private void txtFechaFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaFinalActionPerformed
private boolean NumerosEnterosDecimales(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^[0-9](.)[0-9]{2}$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{
        return false;
        }
    }
private boolean NumerosEnteros(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^[0-9]$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{
        return false;
        }
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
            java.util.logging.Logger.getLogger(FrmPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FrmPedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar3;
    private javax.swing.JButton btnDesactivar3;
    private javax.swing.JButton btnLimpiar3;
    private javax.swing.JButton btnModificar3;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbIDPedido;
    private javax.swing.JComboBox<String> cmbIDPieza;
    private javax.swing.JComboBox<String> cmbIDVehiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tblPedido;
    private javax.swing.JTextField txtCantidadPiezas;
    private javax.swing.JTextField txtCantidadVehiculos;
    private javax.swing.JFormattedTextField txtFechaFinal;
    private javax.swing.JTextField txtPrecioPieza;
    private javax.swing.JTextField txtPrecioVehiculo;
    // End of variables declaration//GEN-END:variables
}
