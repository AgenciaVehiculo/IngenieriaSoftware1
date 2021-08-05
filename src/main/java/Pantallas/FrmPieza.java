/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import Clases.HistoricoPrecioPieza;
import Clases.Pieza;
import Clases.TipoPieza;
import Clases.Validaciones;
import JPAController.HistoricoPrecioPiezaJpaController;
import JPAController.PiezaJpaController;
import JPAController.TipoPiezaJpaController;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
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
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class FrmPieza extends javax.swing.JFrame {

    /**
     * Creates new form Empleados
     * 
     */
    
    PiezaJpaController piezaDao = new PiezaJpaController();
    HistoricoPrecioPiezaJpaController historicoPieza = new HistoricoPrecioPiezaJpaController();
    TipoPiezaJpaController tipoPieza = new TipoPiezaJpaController();
    
    
    public FrmPieza() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Img/CarSoft-removebg-preview.png")).getImage());
        this.setExtendedState(MAXIMIZED_BOTH);
        pnlPieza.setBackground(Color.CYAN);
        jTabbedPane3.setBackground(Color.CYAN);
        jPanel2.setBackground(Color.CYAN);
        jPanel1.setBackground(Color.CYAN);
        txtIDPieza.setBackground(Color.GRAY);
        txtIDTipoPieza.setBackground(Color.GRAY);
        
        createTableTipoPieza();
        createComboBox3();
        btnDesactivar2.setEnabled(false);
        btnDesactivar3.setEnabled(false);
        btnModificar3.setEnabled(false);
        createTablaPieza();
        createCmbTipoPieza();
        createCmbIDPieza();
        crearcmbPiezaHistorico();
    }
    
    public void crearTbHistorialPrecio(){
        DefaultTableModel modelo = new DefaultTableModel();
        
        
        
        
        jTbHistorialPrecio.setModel(modelo);
        
        
        
        modelo.addColumn("ID Precio Historico");
        modelo.addColumn("ID pieza");
        modelo.addColumn("Pieza");
        modelo.addColumn("Caracteristica");
        modelo.addColumn("Precio");
        modelo.addColumn("Desde");
        modelo.addColumn("Hasta");
        
        List<HistoricoPrecioPieza> temp = historicoPieza.findHistoricoPrecioPiezaEntities();
        List<Pieza> temp2 = piezaDao.findPiezaEntities();
        String aux1="";
        String aux2="";
        String auxFecha1 = "";
        String auxFecha2 = "";
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00",separadoresPersonalizados);
        for(HistoricoPrecioPieza e : temp){
            if(e.getIdPieza()==(cmbIDPieza.getSelectedIndex()+1) && e.getFechaFinal()!=null)
            for(Pieza tp : temp2){
                if(tp.getId_Pieza() == e.getIdPieza()){
                    aux1=(tp.getCarateristica_Pieza());
                    aux2=tp.getNombre();
                    auxFecha1 = e.getFechaInicial().substring(8, 10)+"/"+e.getFechaInicial().substring(5,7)+"/"+e.getFechaInicial().substring(0, 4);
                    auxFecha2 = e.getFechaFinal().substring(8, 10)+"/"+e.getFechaFinal().substring(5,7)+"/"+e.getFechaFinal().substring(0, 4);
            modelo.addRow(new Object[]{
                                  e.getIdPrecioHistorico(),
                                  e.getIdPieza(),
                                  aux2,
                                  aux1,
                                  formato1.format(e.getPrecio()),
                                  auxFecha1,
                                  auxFecha2});
        
        }
            }
        }
            
    }
    
    public void crearcmbPiezaHistorico(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        cmbIDPieza.setModel(modelo);
        List<Pieza> temp = piezaDao.findPiezaEntities();
        
        for (Pieza e : temp){
            modelo.addElement(e.getId_Pieza());
        }
    }
    
    public void btnActivarDesactivar(){
        TipoPieza temp;
        temp = tipoPieza.findTipoPieza(txtIDTipoPieza.getSelectedIndex());
        
        if(temp.getEstado()){
        btnDesactivar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar2.setText("Desactivar");  
        btnDesactivar2.setEnabled(true);
        }
        else{
            btnDesactivar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            btnDesactivar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png"))); // NOI18N
            btnDesactivar2.setText("Activar");
            btnDesactivar2.setEnabled(true);
        }
    }
    
    public void btnActivarDesactivarPieza(){
        Pieza temp;
        temp = piezaDao.findPieza(txtIDPieza.getSelectedIndex());
        
        if(temp.isEstado()){
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

    public void createComboBox3(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        txtIDTipoPieza.setModel(modelo);
        List<TipoPieza> temp = tipoPieza.findTipoPiezaEntities();
        modelo.addElement(" ");
        temp.forEach((e) -> {
            modelo.addElement(e.getIDtipopieza());
        });
        
    }
    
    public void createCmbTipoPieza(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        jCmbTipoPieza.setModel(modelo);
        modelo.addElement("Seleccione");
        List<TipoPieza> temp = tipoPieza.findTipoPiezaEntities();
        temp.forEach((e) -> {
            modelo.addElement(e.getTipopieza());
        });
        
    }
    
    public void createCmbIDPieza(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        txtIDPieza.setModel(modelo);
        List<Pieza> temp = piezaDao.findPiezaEntities();
        modelo.addElement("Nuevo");
        temp.forEach((e) -> {
            modelo.addElement(e.getId_Pieza());
        });
        
    }
    
    public void createTablaPieza(){
        DefaultTableModel modelo = new DefaultTableModel();
        jTablePieza.setModel(modelo);
        modelo.addColumn("ID");
        modelo.addColumn("Tipo de Pieza");
        modelo.addColumn("Nombre");
        modelo.addColumn("Característica");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        modelo.addColumn("Estado Maximo");
        modelo.addColumn("Estado minimo");
        modelo.addColumn("Estado");
        List<Pieza> temp = piezaDao.findPiezaEntities();
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);
        double auxPrecio=0;
        String aux1="";
        List<TipoPieza> temp2 = tipoPieza.findTipoPiezaEntities();
        List<HistoricoPrecioPieza> temp3 = historicoPieza.findHistoricoPrecioPiezaEntities();
        
        for(Pieza p : temp){
            for(TipoPieza p1 : temp2){
                if(p.getId_Tipo_Pieza()==p1.getIDtipopieza())
                    aux1=p1.getTipopieza();
                    
            }
            for(HistoricoPrecioPieza p2 : temp3){
                if(p2.getIdPieza() == p.getId_Pieza()){
                    if(p2.getFechaFinal()==null){
                        auxPrecio=p2.getPrecio();
                    }
                }
            }
            
            modelo.addRow(new Object[]{
                p.getId_Pieza(),
                aux1,
                p.getNombre(),
                p.getCarateristica_Pieza(),
                formato1.format(auxPrecio),
                p.getStock(),
                p.getStock_Maximo(),
                p.getStock_Minimo(),
                (p.isEstado())? "Activo" : "Inactivo"
            });
        }
        
        
    }
    
    private void crearTableBusquedaPieza(){
        DefaultTableModel modelo = new DefaultTableModel();
        tablaBusqueda.setModel(modelo);
        modelo.addColumn("ID");
        modelo.addColumn("Tipo de Pieza");
        modelo.addColumn("Nombre");
        modelo.addColumn("Característica");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        modelo.addColumn("Estado Maximo");
        modelo.addColumn("Estado minimo");
        modelo.addColumn("Estado");
        List<Pieza> temp = piezaDao.findPiezaEntities();
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);
        double auxPrecio=0;
        String aux1="";
        List<TipoPieza> temp2 = tipoPieza.findTipoPiezaEntities();
        List<HistoricoPrecioPieza> temp3 = historicoPieza.findHistoricoPrecioPiezaEntities();
        
        for(Pieza p : temp){
            if(p.getNombre().equalsIgnoreCase(txtNombreBusqueda.getText())){
            for(TipoPieza p1 : temp2){
                if(p.getId_Tipo_Pieza()==p1.getIDtipopieza())
                    aux1=p1.getTipopieza();
                    
            }
            for(HistoricoPrecioPieza p2 : temp3){
                if(p2.getIdPieza() == p.getId_Pieza()){
                    if(p2.getFechaFinal()==null){
                        auxPrecio=p2.getPrecio();
                    }
                }
            }
            
            modelo.addRow(new Object[]{
                p.getId_Pieza(),
                aux1,
                p.getNombre(),
                p.getCarateristica_Pieza(),
                formato1.format(auxPrecio),
                p.getStock(),
                p.getStock_Maximo(),
                p.getStock_Minimo(),
                (p.isEstado())? "Activo" : "Inactivo"
            });}
        }
        
        
    }
    
    public void limpiar(){
        txtIDPieza.setSelectedIndex(0);
        jCmbTipoPieza.setSelectedIndex(0);
        jTxtAreaCaracteristica.setText("");
        jFtxtStock.setText("");
        jFtxtStockMaximo.setText("");
        jFtxtStockMinimo.setText("");
        jFtxtPrecio.setText("");
    }
    
    public void createTableTipoPieza(){
        DefaultTableModel modelo = new DefaultTableModel();
        jTableTipoPieza.setModel(modelo);
        modelo.addColumn("ID");
        modelo.addColumn("Pieza");
        modelo.addColumn("Estado");
        
        List<TipoPieza> temp = tipoPieza.findTipoPiezaEntities();
        
        for(TipoPieza e : temp)
            modelo.addRow(
                    new Object[]{
                        e.getIDtipopieza(),
                        e.getTipopieza(),
                        (e.getEstado())?"Activo":"Inactivo"
            });
                     
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane3 = new javax.swing.JTabbedPane();
        pnlPieza = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePieza = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnAgregar3 = new javax.swing.JButton();
        btnModificar3 = new javax.swing.JButton();
        btnLimpiar3 = new javax.swing.JButton();
        btnDesactivar3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTxtAreaCaracteristica = new javax.swing.JTextArea();
        txtIDPieza = new javax.swing.JComboBox<>();
        jCmbTipoPieza = new javax.swing.JComboBox<>();
        jFtxtStockMaximo = new javax.swing.JFormattedTextField();
        jFtxtStock = new javax.swing.JFormattedTextField();
        jFtxtStockMinimo = new javax.swing.JFormattedTextField();
        jFtxtPrecio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtxtNombre = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cmbIDPieza = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTbHistorialPrecio = new javax.swing.JTable();
        btnSalir2 = new javax.swing.JButton();
        btnRegresar2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtTipoPiezaNuevo = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableTipoPieza = new javax.swing.JTable();
        btnAgregar2 = new javax.swing.JButton();
        btnModificar2 = new javax.swing.JButton();
        btnLimpiar2 = new javax.swing.JButton();
        btnDesactivar2 = new javax.swing.JButton();
        btnSalir1 = new javax.swing.JButton();
        btnRegresar1 = new javax.swing.JButton();
        txtIDTipoPieza = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtNombreBusqueda = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaBusqueda = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTabbedPane3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTabbedPane3FocusLost(evt);
            }
        });

        pnlPieza.setBackground(new java.awt.Color(0, 255, 255));
        pnlPieza.setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("ID Pieza:");
        pnlPieza.add(jLabel1);
        jLabel1.setBounds(30, 95, 70, 30);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Tipo Pieza:");
        pnlPieza.add(jLabel2);
        jLabel2.setBounds(30, 136, 70, 30);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Características:");
        pnlPieza.add(jLabel3);
        jLabel3.setBounds(231, 136, 89, 25);

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Precio:");
        pnlPieza.add(jLabel11);
        jLabel11.setBounds(542, 133, 89, 14);

        jTablePieza.setBackground(new java.awt.Color(0, 0, 0));
        jTablePieza.setForeground(new java.awt.Color(255, 255, 255));
        jTablePieza.setModel(new javax.swing.table.DefaultTableModel(
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
                "ID Pieza", "Tipo Pieza", "Características", "Precio", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePieza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePiezaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTablePieza);
        if (jTablePieza.getColumnModel().getColumnCount() > 0) {
            jTablePieza.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTablePieza.getColumnModel().getColumn(1).setPreferredWidth(90);
            jTablePieza.getColumnModel().getColumn(2).setPreferredWidth(150);
            jTablePieza.getColumnModel().getColumn(3).setPreferredWidth(70);
            jTablePieza.getColumnModel().getColumn(4).setPreferredWidth(70);
        }

        pnlPieza.add(jScrollPane2);
        jScrollPane2.setBounds(30, 306, 676, 183);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel12.setText("Piezas");
        pnlPieza.add(jLabel12);
        jLabel12.setBounds(603, 17, 74, 35);

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        pnlPieza.add(btnSalir);
        btnSalir.setBounds(1255, 11, 93, 41);

        btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        pnlPieza.add(btnRegresar);
        btnRegresar.setBounds(1195, 574, 153, 45);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Stock:");
        pnlPieza.add(jLabel4);
        jLabel4.setBounds(542, 95, 92, 14);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Stock minimo:");
        pnlPieza.add(jLabel5);
        jLabel5.setBounds(740, 133, 92, 14);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Stock máximo:");
        pnlPieza.add(jLabel6);
        jLabel6.setBounds(740, 95, 92, 14);

        btnAgregar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar3.setText("Agregar");
        btnAgregar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar3ActionPerformed(evt);
            }
        });
        pnlPieza.add(btnAgregar3);
        btnAgregar3.setBounds(30, 213, 115, 41);

        btnModificar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar3.setText("Modificar");
        btnModificar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar3ActionPerformed(evt);
            }
        });
        pnlPieza.add(btnModificar3);
        btnModificar3.setBounds(163, 213, 121, 41);

        btnLimpiar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar3.setText("Limpiar");
        btnLimpiar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar3ActionPerformed(evt);
            }
        });
        pnlPieza.add(btnLimpiar3);
        btnLimpiar3.setBounds(302, 213, 111, 41);

        btnDesactivar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar3.setText("Desactivar");
        btnDesactivar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDesactivar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar3ActionPerformed(evt);
            }
        });
        pnlPieza.add(btnDesactivar3);
        btnDesactivar3.setBounds(431, 214, 161, 39);

        jTxtAreaCaracteristica.setColumns(20);
        jTxtAreaCaracteristica.setRows(5);
        jScrollPane1.setViewportView(jTxtAreaCaracteristica);

        pnlPieza.add(jScrollPane1);
        jScrollPane1.setBounds(324, 130, 214, 72);

        txtIDPieza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", " ", " " }));
        txtIDPieza.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtIDPiezaItemStateChanged(evt);
            }
        });
        pnlPieza.add(txtIDPieza);
        txtIDPieza.setBounds(104, 92, 109, 30);

        jCmbTipoPieza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "1", "2" }));
        jCmbTipoPieza.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCmbTipoPiezaItemStateChanged(evt);
            }
        });
        pnlPieza.add(jCmbTipoPieza);
        jCmbTipoPieza.setBounds(104, 133, 109, 30);

        jFtxtStockMaximo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        pnlPieza.add(jFtxtStockMaximo);
        jFtxtStockMaximo.setBounds(836, 92, 94, 30);

        jFtxtStock.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        pnlPieza.add(jFtxtStock);
        jFtxtStock.setBounds(638, 92, 98, 30);

        jFtxtStockMinimo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        pnlPieza.add(jFtxtStockMinimo);
        jFtxtStockMinimo.setBounds(836, 130, 94, 30);

        jFtxtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFtxtPrecioKeyPressed(evt);
            }
        });
        pnlPieza.add(jFtxtPrecio);
        jFtxtPrecio.setBounds(638, 130, 98, 30);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nombre:");
        pnlPieza.add(jLabel7);
        jLabel7.setBounds(275, 95, 70, 25);
        pnlPieza.add(jtxtNombre);
        jtxtNombre.setBounds(324, 92, 214, 30);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Fondo.jpg"))); // NOI18N
        jLabel13.setText("jLabel13");
        pnlPieza.add(jLabel13);
        jLabel13.setBounds(0, 0, 1440, 770);

        jTabbedPane3.addTab("Piezas", pnlPieza);

        jPanel2.setBackground(new java.awt.Color(0, 255, 255));
        jPanel2.setLayout(null);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("ID Pieza:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(167, 124, 102, 30);

        jLabel16.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel16.setText("Historial de precios de las piezas");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(517, 11, 378, 35);

        cmbIDPieza.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDPiezaItemStateChanged(evt);
            }
        });
        jPanel2.add(cmbIDPieza);
        cmbIDPieza.setBounds(279, 121, 94, 30);

        jTbHistorialPrecio.setBackground(new java.awt.Color(0, 0, 0));
        jTbHistorialPrecio.setForeground(new java.awt.Color(255, 255, 255));
        jTbHistorialPrecio.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Precio Histórico", "ID Pieza", "Fecha Inicial", "Fecha Final", "Precio", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTbHistorialPrecio);
        if (jTbHistorialPrecio.getColumnModel().getColumnCount() > 0) {
            jTbHistorialPrecio.getColumnModel().getColumn(0).setPreferredWidth(60);
            jTbHistorialPrecio.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTbHistorialPrecio.getColumnModel().getColumn(2).setPreferredWidth(60);
            jTbHistorialPrecio.getColumnModel().getColumn(3).setPreferredWidth(60);
            jTbHistorialPrecio.getColumnModel().getColumn(4).setPreferredWidth(50);
            jTbHistorialPrecio.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        jPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(34, 319, 837, 187);

        btnSalir2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir2.setText("Salir");
        btnSalir2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir2ActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalir2);
        btnSalir2.setBounds(1256, 13, 93, 41);

        btnRegresar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar2.setText("Regresar");
        btnRegresar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar2ActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegresar2);
        btnRegresar2.setBounds(1196, 557, 153, 45);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Fondo.jpg"))); // NOI18N
        jLabel10.setText("jLabel10");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(0, 0, 1410, 670);

        jTabbedPane3.addTab("Historial de Precios", jPanel2);

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));
        jPanel1.setLayout(null);

        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("ID Tipo de Pieza:");
        jPanel1.add(jLabel28);
        jLabel28.setBounds(-35, 89, 150, 23);

        jLabel29.setForeground(new java.awt.Color(255, 246, 239));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Tipo de Pieza:");
        jPanel1.add(jLabel29);
        jLabel29.setBounds(33, 130, 81, 23);

        txtTipoPiezaNuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoPiezaNuevoKeyTyped(evt);
            }
        });
        jPanel1.add(txtTipoPiezaNuevo);
        txtTipoPiezaNuevo.setBounds(132, 131, 107, 30);

        jLabel31.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel31.setText("Ingresar Nuevos Datos");
        jPanel1.add(jLabel31);
        jLabel31.setBounds(533, 17, 260, 35);

        jTableTipoPieza.setModel(new javax.swing.table.DefaultTableModel(
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
                "ID Tipo de Pieza", "Tipo de Pieza", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTipoPieza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTipoPiezaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableTipoPieza);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(33, 299, 530, 126);

        btnAgregar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar2.setText("Agregar");
        btnAgregar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar2);
        btnAgregar2.setBounds(33, 211, 115, 41);

        btnModificar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar2.setText("Modificar");
        btnModificar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar2);
        btnModificar2.setBounds(154, 211, 121, 41);

        btnLimpiar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar2.setText("Limpiar");
        btnLimpiar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar2);
        btnLimpiar2.setBounds(281, 211, 111, 41);

        btnDesactivar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar2.setText("Desactivar");
        btnDesactivar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDesactivar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnDesactivar2);
        btnDesactivar2.setBounds(398, 212, 161, 39);

        btnSalir1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir1.setText("Salir");
        btnSalir1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir1);
        btnSalir1.setBounds(1258, 11, 93, 41);

        btnRegresar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar1.setText("Regresar");
        btnRegresar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar1);
        btnRegresar1.setBounds(1198, 553, 153, 45);

        txtIDTipoPieza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "1", "2" }));
        txtIDTipoPieza.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtIDTipoPiezaItemStateChanged(evt);
            }
        });
        txtIDTipoPieza.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIDTipoPiezaFocusLost(evt);
            }
        });
        txtIDTipoPieza.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDTipoPiezaKeyTyped(evt);
            }
        });
        jPanel1.add(txtIDTipoPieza);
        txtIDTipoPieza.setBounds(132, 90, 107, 30);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Fondo.jpg"))); // NOI18N
        jLabel9.setText("jLabel9");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(0, 0, 1450, 690);

        jTabbedPane3.addTab("Ingresar Datos Nuevos", jPanel1);

        jPanel3.setLayout(null);

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Nombre:");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(80, 120, 70, 30);
        jPanel3.add(txtNombreBusqueda);
        txtNombreBusqueda.setBounds(130, 120, 160, 30);

        tablaBusqueda.setModel(new javax.swing.table.DefaultTableModel(
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
                "ID Pieza", "Tipo Pieza", "Características", "Precio", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaBusquedaMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tablaBusqueda);
        if (tablaBusqueda.getColumnModel().getColumnCount() > 0) {
            tablaBusqueda.getColumnModel().getColumn(0).setPreferredWidth(50);
            tablaBusqueda.getColumnModel().getColumn(1).setPreferredWidth(90);
            tablaBusqueda.getColumnModel().getColumn(2).setPreferredWidth(150);
            tablaBusqueda.getColumnModel().getColumn(3).setPreferredWidth(70);
            tablaBusqueda.getColumnModel().getColumn(4).setPreferredWidth(70);
        }

        jPanel3.add(jScrollPane5);
        jScrollPane5.setBounds(30, 306, 676, 183);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(310, 120, 100, 35);

        jLabel17.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel17.setText("Busqueda de Piezas");
        jPanel3.add(jLabel17);
        jLabel17.setBounds(570, 20, 240, 35);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Fondo.jpg"))); // NOI18N
        jPanel3.add(jLabel15);
        jLabel15.setBounds(0, 0, 1400, 680);

        jTabbedPane3.addTab("Buscar", jPanel3);

        getContentPane().add(jTabbedPane3);
        jTabbedPane3.setBounds(0, 0, 1388, 796);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Fondo.jpg"))); // NOI18N
        jLabel18.setText("jLabel18");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(0, 0, 1450, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnAgregar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar2ActionPerformed
        
        if(txtIDTipoPieza.getSelectedIndex()!=0){
            txtIDTipoPieza.setSelectedIndex(0);
        }
        else{
            
        }
         Pattern pat = Pattern.compile("(?i)(.*aaa.*|.*bbb.*|.*ccc.*|.*ddd.*|.*eee.*|.*fff.*|.*ggg.*|.*hhh.*|.*iii.*"
                    + "                         |.*jjj.*|.*kkk.*|.*lll.*|.*mmm.*|.*nnn.*|.*ooo.*|.*ppp.*|.*qqq.*|.*rrr.*|.*sss.*|.*ttt.*|.*uuu.*"
                    + "                         |.*vvv.*|.*www.*|.*xxx.*|.*yyy.*|.*zzz.*)");
            
            Matcher mat = pat.matcher(txtTipoPiezaNuevo.getText());
            
        if(mat.matches()){
            JOptionPane.showMessageDialog(null, "Tipo de pieza invalido\nIngrese un tipo de Pieza","ERROR",0);
            return;
        }
        
        
        
        if("".equals(txtTipoPiezaNuevo.getText())){
            JOptionPane.showMessageDialog(null, "Ingrese el tipo de pieza que es","ERROR",0);
            return;
        }
        else{
            int i;
            boolean flag=false;
            for(i=0;i<tipoPieza.findTipoPiezaEntities().size();i++){
                //System.out.println(i);
                if(txtTipoPiezaNuevo.getText().toLowerCase().equals(tipoPieza.findTipoPieza(i+1).getTipopieza())){
                    JOptionPane.showMessageDialog(null, "Ya existe este tipo de pieza registrada en el sistema");
                    flag=true;
                    return;
                } else {
                }
            }
            if(flag){
                return;
            }
            else{
            TipoPieza e1 = new TipoPieza();
            e1.setEstado(true);
            e1.setTipopieza(txtTipoPiezaNuevo.getText().toLowerCase());
           tipoPieza.create(e1);
//           txtIDTipoPieza.setSelectedIndex(1);
           txtIDTipoPieza.setSelectedIndex(0);
           createTableTipoPieza();
           createComboBox3();
           FrmPieza f= new FrmPieza();
           f.show();
           f.jTabbedPane3.setSelectedIndex(2);
           this.hide();
        }
        }
     
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregar2ActionPerformed

    private void btnModificar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar2ActionPerformed
        if(txtIDTipoPieza.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Tipo de pieza no encontrado");
        }
        else{
            if("".equals(txtTipoPiezaNuevo.getText())){
                JOptionPane.showMessageDialog(null, "Tipo de Pieza no puede ir vacio");
                return;
            }
            else{
                int i;
                boolean flag=false;
                for(i=0;i<tipoPieza.findTipoPiezaEntities().size();i++){
                    //System.out.println(i);
                if(txtTipoPiezaNuevo.getText().toLowerCase().equals(tipoPieza.findTipoPieza(i+1).getTipopieza())){
                    JOptionPane.showMessageDialog(null, "Ya existe este tipo de pieza registrada en el sistema");
                    flag=true;
                    return;
                } else {
                }
            }
                if(flag){
                    return;
                }
                else{
                    TipoPieza e1;
                    e1=tipoPieza.findTipoPieza(txtIDTipoPieza.getSelectedIndex());
                    e1.setTipopieza(txtTipoPiezaNuevo.getText().toLowerCase());
                    try {
                        tipoPieza.edit(e1);
                    } catch (Exception ex) {
                        Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
                    }
                txtIDTipoPieza.setSelectedIndex(1);
                txtIDTipoPieza.setSelectedIndex(0);
                createTableTipoPieza();
                createComboBox3();
                }
            }
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificar2ActionPerformed

    private void btnLimpiar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar2ActionPerformed
        txtIDTipoPieza.setSelectedIndex(1);
        txtIDTipoPieza.setSelectedIndex(0);
        createTableTipoPieza();
        createComboBox3();
       // txtTipoPiezaNuevo.setText("");

        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiar2ActionPerformed

    private void btnDesactivar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar2ActionPerformed
        TipoPieza temp;
        temp = tipoPieza.findTipoPieza(txtIDTipoPieza.getSelectedIndex());
        if(temp.getEstado()){
            temp.setEstado(false);
        }
        else{
            temp.setEstado(true);
        }
        try {
            tipoPieza.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
        }
        createTableTipoPieza();
        btnActivarDesactivar();
        
        
    }//GEN-LAST:event_btnDesactivar2ActionPerformed

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

    private void btnSalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir2ActionPerformed
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalir2ActionPerformed

    private void btnRegresar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar2ActionPerformed
        FrmMenu m = new FrmMenu();
        m.setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresar2ActionPerformed

    private void btnAgregar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar3ActionPerformed
            if(txtIDPieza.getSelectedIndex()==0){
                
            }
            else{
                txtIDPieza.setSelectedIndex(0);
            }
            //Validacion del campo Nombre
            Pattern pat = Pattern.compile("(?i)(.*aaa.*|.*bbb.*|.*ccc.*|.*ddd.*|.*eee.*|.*fff.*|.*ggg.*|.*hhh.*|.*iii.*"
                    + "                         |.*jjj.*|.*kkk.*|.*lll.*|.*mmm.*|.*nnn.*|.*ooo.*|.*ppp.*|.*qqq.*|.*rrr.*|.*sss.*|.*ttt.*|.*uuu.*"
                    + "                         |.*vvv.*|.*www.*|.*xxx.*|.*yyy.*|.*zzz.*)");
            
            Matcher mat = pat.matcher(jtxtNombre.getText());
            if(mat.matches()){
                JOptionPane.showMessageDialog(null, "Nombre invalido\n Por favor ingrese un nombre ","ERROR",0);
                return;   
            }
            else{
                
            }
            if(jtxtNombre.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Por favor Ingrese el nombre de la pieza a registrar","Espacio en blanco",0);
                return;
            }
            else{
                
            }
            //Fin de validacion del campo nombre
            //Validacion de textAreaPieza
            
            if(jTxtAreaCaracteristica.getText().length()>100 || jTxtAreaCaracteristica.getText().length()==0){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese las carateristicas de la pieza","",0);
                return;   
            }
            else{
                
            }
            
            
            mat = pat.matcher(jTxtAreaCaracteristica.getText());
            
            if(mat.matches()){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese las carateristicas de la pieza validas","",0);
                return;   
            }
            else{
                
            }
            
            //Fin de validacion de textAreaPieza
            
           if("".equals(jFtxtStock.getText())){
               JOptionPane.showMessageDialog(null, "Por favor ingrese la cantidad actual del producto","",0);
                return;
            }
           else{
               
           }
           if("".equals(jFtxtStockMaximo.getText())){
               JOptionPane.showMessageDialog(null,"Por favor ingrese la cantidad maxima que puede haber de esta pieza","",0);
               return;
           }
           else{
               
           }
           if("".equals(jFtxtStockMinimo.getText())){
               JOptionPane.showMessageDialog(null,"Por favor ingrese la cantidad minima que puede haber de esta pieza","",0);
               return;
           }
           else{
               
           }
           //Validacion del precio
           if("".equals(jFtxtPrecio.getText())){
               JOptionPane.showMessageDialog(null, "Por favor, ingrese un precio de la pieza","",0);
               return;
           }
           else{
               
           }
                     
           if(!Validaciones.validacionDecimales(jFtxtPrecio.getText().trim())){
               JOptionPane.showMessageDialog(null, "Formato de Precio Invalido");
               return;
           }
           
           if(Double.parseDouble(jFtxtPrecio.getText())==0){
               JOptionPane.showMessageDialog(null, "El precio no puede ser 0","",0);
               return;
           }
           
           
           
           
           
           //Fin de validacion del precio
           
           //Validacion de stock
           
           if(Integer.parseInt(jFtxtStockMinimo.getText()) >= Integer.parseInt(jFtxtStockMaximo.getText())){
               JOptionPane.showMessageDialog(null, "El stock minimo no puede ser igual o mayor al stock maximo","",0);
               return;
           }
           else{
            }
           if(Double.parseDouble(jFtxtStock.getText())>Integer.parseInt(jFtxtStockMaximo.getText())){
               JOptionPane.showMessageDialog(null, "El stock no puede ser mayor al stock maximo","",0);
               return;
           }
           if(Double.parseDouble(jFtxtStock.getText())<Integer.parseInt(jFtxtStockMinimo.getText())){
               JOptionPane.showMessageDialog(null, "El stock no puede ser menor al stock minimo","",0);
               return;
           }
           
           
           //Fin de la validacion de stock
           
           Pieza temp = new Pieza();
           temp.setEstado(true);
           temp.setNombre(jtxtNombre.getText());
           temp.setCarateristica_Pieza(jTxtAreaCaracteristica.getText());
           temp.setId_Tipo_Pieza(jCmbTipoPieza.getSelectedIndex());
           temp.setStock(Integer.parseInt(jFtxtStock.getText()));
           temp.setStock_Maximo(Integer.parseInt(jFtxtStockMaximo.getText()));
           temp.setStock_Minimo(Integer.parseInt(jFtxtStockMinimo.getText()));
           
        try {
            piezaDao.create(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           
           HistoricoPrecioPieza temp2 = new HistoricoPrecioPieza();
           temp2.setEstado(true);
           Calendar fecha = new GregorianCalendar();
           String fecha1;
           String aux1,aux2,aux3;
           aux1 = Integer.toString(fecha.get(Calendar.YEAR));
           aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
           aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
           fecha1 = aux1+aux2+aux3;
           temp2.setFechaInicial(fecha1);
           double aux=Float.parseFloat(jFtxtPrecio.getText().trim());
           temp2.setPrecio(aux);
           temp2.setIdPieza(piezaDao.getPiezaCount());
           historicoPieza.create(temp2);
           
//           txtIDPieza.setSelectedIndex(1);
           txtIDPieza.setSelectedIndex(0);
           createTablaPieza();
           createCmbIDPieza();
           
           new FrmPieza().show();
           this.hide();
        /*if(txtIDPieza.getSelectedIndex()==0){
                
            }
            else{
                txtIDPieza.setSelectedIndex(0);
            }
            if(jTxtAreaCaracteristica.getText().length()>100 || jTxtAreaCaracteristica.getText().length()==0){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese las carateristicas de la pieza");
                return;   
            }
            else{
                
            }
           if("".equals(jFtxtStock.getText())){
               JOptionPane.showMessageDialog(null, "Por favor ingrese la cantidad actual del producto");
                return;
            }
           else{
               
           }
           if("".equals(jFtxtStockMaximo.getText())){
               JOptionPane.showMessageDialog(null,"Por favor ingrese la cantidad maxima que puede haber de esta pieza");
               return;
           }
           else{
               
           }
           if("".equals(jFtxtStockMinimo.getText())){
               JOptionPane.showMessageDialog(null,"Por favor ingrese la cantidad minima que puede haber de esta pieza");
               return;
           }
           else{
               
           }
           if("".equals(jFtxtPrecio.getText())){
               JOptionPane.showMessageDialog(null, "Por favor, ingrese un precio de la pieza");
               return;
           }
           else{
               
           }
           if(Integer.parseInt(jFtxtStockMinimo.getText()) > Integer.parseInt(jFtxtStockMaximo.getText())){
               JOptionPane.showMessageDialog(null, "El stock minimo no puede ser igual o mayor al stock maximo");
               return;
           }
           else{
               
           }
           Pieza temp = new Pieza();
           temp.setEstado(true);
           temp.setCarateristica_Pieza(jTxtAreaCaracteristica.getText());
           temp.setId_Tipo_Pieza(jCmbTipoPieza.getSelectedIndex()+1);
           temp.setStock(Integer.parseInt(jFtxtStock.getText()));
           temp.setStock_Maximo(Integer.parseInt(jFtxtStockMaximo.getText()));
           temp.setStock_Minimo(Integer.parseInt(jFtxtStockMinimo.getText()));
           
        try {
            piezaDao.create(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           
           HistoricoPrecioPieza temp2 = new HistoricoPrecioPieza();
           temp2.setEstado(true);
           Calendar fecha = new GregorianCalendar();
           String fecha1;
           String aux1,aux2,aux3;
           aux1 = Integer.toString(fecha.get(Calendar.YEAR));
           aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
           aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
           fecha1 = aux1+aux2+aux3;
           temp2.setFechaInicial(fecha1);
           double aux=Float.parseFloat(jFtxtPrecio.getText().trim());
           temp2.setPrecio(aux);
           temp2.setIdPieza(piezaDao.getPiezaCount());
           historicoPieza.create(temp2);
           
           txtIDPieza.setSelectedIndex(1);
           txtIDPieza.setSelectedIndex(0);
           createTablaPieza();
           createCmbIDPieza();*/
              
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregar3ActionPerformed

    private void btnModificar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar3ActionPerformed

            Pattern pat = Pattern.compile("(?i)(.*aaa.*|.*bbb.*|.*ccc.*|.*ddd.*|.*eee.*|.*fff.*|.*ggg.*|.*hhh.*|.*iii.*"
                    + "                         |.*jjj.*|.*kkk.*|.*lll.*|.*mmm.*|.*nnn.*|.*ooo.*|.*ppp.*|.*qqq.*|.*rrr.*|.*sss.*|.*ttt.*|.*uuu.*"
                    + "                         |.*vvv.*|.*www.*|.*xxx.*|.*yyy.*|.*zzz.*)");
            
            Matcher mat = pat.matcher(jtxtNombre.getText());
            if(mat.matches()){
                JOptionPane.showMessageDialog(null, "Nombre invalido\n Por favor ingrese un nombre ","ERROR",0);
                return;   
            }
            else{
                
            }
            if(jtxtNombre.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Por favor Ingrese el nombre de la pieza a registrar","Espacio en blanco",0);
                return;
            }
            else{
                
            }
        
            if(jTxtAreaCaracteristica.getText().length()>100 || jTxtAreaCaracteristica.getText().length()==0){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese las carateristicas de la pieza","",0);
                return;   
            }
            else{
                
            }
            
            
            mat = pat.matcher(jTxtAreaCaracteristica.getText());
            
            if(mat.matches()){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese las carateristicas de la pieza validas","",0);
                return;   
            }
            else{
                
            }
            
           if("".equals(jFtxtStock.getText())){
               JOptionPane.showMessageDialog(null, "Por favor ingrese la cantidad actual del producto","",0);
                return;
            }
           else{
               
           }
           if("".equals(jFtxtStockMaximo.getText())){
               JOptionPane.showMessageDialog(null,"Por favor ingrese la cantidad maxima que puede haber de esta pieza","",0);
               return;
           }
           else{
               
           }
           if("".equals(jFtxtStockMinimo.getText())){
               JOptionPane.showMessageDialog(null,"Por favor ingrese la cantidad minima que puede haber de esta pieza","",0);
               return;
           }
           else{
               
           }
           if("".equals(jFtxtPrecio.getText())){
               JOptionPane.showMessageDialog(null, "Por favor, ingrese un precio de la pieza","",0);
               return;
           }
           else{
               
           }
           if(Integer.parseInt(jFtxtStockMinimo.getText()) > Integer.parseInt(jFtxtStockMaximo.getText())){
               JOptionPane.showMessageDialog(null, "El stock minimo no puede ser igual o mayor al stock maximo","",0);
               return;
           }
           else{
               
           }
           if(Double.parseDouble(jFtxtStock.getText())>Integer.parseInt(jFtxtStockMaximo.getText())){
               JOptionPane.showMessageDialog(null, "El stock no puede ser mayor al stock maximo","",0);
               return;
           }
           
           Pieza temp = new Pieza();
           temp.setId_Pieza(txtIDPieza.getSelectedIndex());
           temp.setNombre(jtxtNombre.getText());
           temp.setCarateristica_Pieza(jTxtAreaCaracteristica.getText());
           temp.setId_Tipo_Pieza(jCmbTipoPieza.getSelectedIndex());
           temp.setStock(Integer.parseInt(jFtxtStock.getText()));
           temp.setStock_Maximo(Integer.parseInt(jFtxtStockMaximo.getText()));
           temp.setStock_Minimo(Integer.parseInt(jFtxtStockMinimo.getText()));
           temp.setEstado(true);
           
        try {
            piezaDao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           List<HistoricoPrecioPieza> t1 = historicoPieza.findHistoricoPrecioPiezaEntities();
           HistoricoPrecioPieza temp2 = new HistoricoPrecioPieza();
           
           for(HistoricoPrecioPieza t : t1){
               if(t.getIdPieza() == txtIDPieza.getSelectedIndex()){
                    if(t.getFechaFinal()==null){
                        temp2 = t;
                        
                    }
                    
                        
                    
                
                
                    
                }
           }
           
           if(temp2.getPrecio()!= Double.parseDouble(jFtxtPrecio.getText())){
           Calendar fecha = new GregorianCalendar();
           String fecha1;
           String aux1,aux2,aux3;
           aux1 = Integer.toString(fecha.get(Calendar.YEAR));
           aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.MONTH)+1) : Integer.toString(fecha.get(Calendar.MONTH));
           aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
           fecha1 = aux1+aux2+aux3;
           temp2.setFechaFinal(fecha1);
           double aux=Double.parseDouble(jFtxtPrecio.getText().trim());
           //temp2.setPrecio();
           temp2.setIdPieza(txtIDPieza.getSelectedIndex());
        try {
            historicoPieza.edit(temp2);
        } catch (Exception ex) {
            Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
        }
           HistoricoPrecioPieza temp3 = new HistoricoPrecioPieza();          
           temp3.setFechaInicial(fecha1);
           temp3.setIdPieza(txtIDPieza.getSelectedIndex());
           temp3.setPrecio(aux);
           historicoPieza.create(temp3);
           //txtIDPieza.setSelectedIndex(1);
           
           }
           txtIDPieza.setSelectedIndex(0);
           createTablaPieza();
           createCmbIDPieza();
        /*if(jTxtAreaCaracteristica.getText().length()>100 || jTxtAreaCaracteristica.getText().length()==0){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese las carateristicas de la pieza");
                return;   
            }
            else{
                
            }
           if("".equals(jFtxtStock.getText())){
               JOptionPane.showMessageDialog(null, "Por favor ingrese la cantidad actual del producto");
                return;
            }
           else{
               
           }
           if("".equals(jFtxtStockMaximo.getText())){
               JOptionPane.showMessageDialog(null,"Por favor ingrese la cantidad maxima que puede haber de esta pieza");
               return;
           }
           else{
               
           }
           if("".equals(jFtxtStockMinimo.getText())){
               JOptionPane.showMessageDialog(null,"Por favor ingrese la cantidad minima que puede haber de esta pieza");
               return;
           }
           else{
               
           }
           if("".equals(jFtxtPrecio.getText())){
               JOptionPane.showMessageDialog(null, "Por favor, ingrese un precio de la pieza");
               return;
           }
           else{
               
           }
           if(Integer.parseInt(jFtxtStockMinimo.getText()) > Integer.parseInt(jFtxtStockMaximo.getText())){
               JOptionPane.showMessageDialog(null, "El stock minimo no puede ser igual o mayor al stock maximo");
               return;
           }
           else{
               
           }
           Pieza temp = new Pieza();
           temp.setId_Pieza(txtIDPieza.getSelectedIndex());
           temp.setCarateristica_Pieza(jTxtAreaCaracteristica.getText());
           temp.setId_Tipo_Pieza(jCmbTipoPieza.getSelectedIndex()+1);
           temp.setStock(Integer.parseInt(jFtxtStock.getText()));
           temp.setStock_Maximo(Integer.parseInt(jFtxtStockMaximo.getText()));
           temp.setStock_Minimo(Integer.parseInt(jFtxtStockMinimo.getText()));
           
        try {
            piezaDao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           List<HistoricoPrecioPieza> t1 = historicoPieza.findHistoricoPrecioPiezaEntities();
           HistoricoPrecioPieza temp2 = new HistoricoPrecioPieza();
           
           for(HistoricoPrecioPieza t : t1){
               if(t.getIdPieza() == txtIDPieza.getSelectedIndex()){
                    if(t.getFechaFinal()==null){
                        temp2 = t;
                        
                    }
                    
                        
                    
                
                
                    
                }
           }
           
           
           Calendar fecha = new GregorianCalendar();
           String fecha1;
           String aux1,aux2,aux3;
           aux1 = Integer.toString(fecha.get(Calendar.YEAR));
           aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.MONTH)+1) : Integer.toString(fecha.get(Calendar.MONTH));
           aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
           fecha1 = aux1+aux2+aux3;
           temp2.setFechaFinal(fecha1);
           double aux=Float.parseFloat(jFtxtPrecio.getText().trim());
           //temp2.setPrecio();
           temp2.setIdPieza(txtIDPieza.getSelectedIndex());
        try {
            historicoPieza.edit(temp2);
        } catch (Exception ex) {
            Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
        }
           HistoricoPrecioPieza temp3 = new HistoricoPrecioPieza();          
           temp3.setFechaInicial(fecha1);
           temp3.setIdPieza(txtIDPieza.getSelectedIndex());
           temp3.setPrecio(aux);
           historicoPieza.create(temp3);
           txtIDPieza.setSelectedIndex(1);
           txtIDPieza.setSelectedIndex(0);
           createTablaPieza();
           createCmbIDPieza();*/

        new FrmPieza().show();
           this.hide();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificar3ActionPerformed

    private void btnLimpiar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar3ActionPerformed
//        txtIDPieza.setSelectedIndex(1);
        txtIDPieza.setSelectedIndex(0);
        btnModificar3.enable(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiar3ActionPerformed

    private void btnDesactivar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar3ActionPerformed
        Pieza temp;
        temp = piezaDao.findPieza(txtIDPieza.getSelectedIndex());
        //temp = piezaDao.findPieza(txtIDPieza.getSelectedIndex()+1);
        //JOptionPane.showMessageDialog(null, temp.isEstado());
        if(temp.isEstado()){
            temp.setEstado(false);
        }
        else{
            temp.setEstado(true);
        }
        try {
            piezaDao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
        }
        createTablaPieza();
        btnActivarDesactivarPieza();

        /*Pieza temp;
        temp = piezaDao.findPieza(txtIDPieza.getSelectedIndex());
        if(temp.isEstado()){
            temp.setEstado(false);
        }
        else{
            temp.setEstado(true);
        }
        try {
            piezaDao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
        }
        createTablaPieza();
        btnActivarDesactivarPieza();
*/
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDesactivar3ActionPerformed

    private void txtIDTipoPiezaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtIDTipoPiezaItemStateChanged
        if(txtIDTipoPieza.getSelectedIndex()==0){
            txtTipoPiezaNuevo.setText("");
            btnDesactivar2.setEnabled(false);
            
        }
        else{
        TipoPieza e1;
        e1=tipoPieza.findTipoPieza( txtIDTipoPieza.getSelectedIndex());
        txtTipoPiezaNuevo.setText(e1.getTipopieza());
        btnActivarDesactivar();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDTipoPiezaItemStateChanged

    private void jCmbTipoPiezaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCmbTipoPiezaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jCmbTipoPiezaItemStateChanged

    private void txtIDTipoPiezaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDTipoPiezaFocusLost
            // TODO add your handling code here:
    }//GEN-LAST:event_txtIDTipoPiezaFocusLost

    private void txtIDTipoPiezaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDTipoPiezaKeyTyped
        
// TODO add your handling code here:
    }//GEN-LAST:event_txtIDTipoPiezaKeyTyped

    private void txtIDPiezaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtIDPiezaItemStateChanged
        if(txtIDPieza.getSelectedIndex()==0){
            //txtIDPieza.setSelectedIndex(0);
//            jCmbTipoPieza.setSelectedIndex(0);
            jtxtNombre.setText("");
            jTxtAreaCaracteristica.setText("");
            jFtxtStock.setText("");
            jFtxtStockMaximo.setText("");
            jFtxtStockMinimo.setText("");
            jFtxtPrecio.setText("");
            
            
        }
        else{
        Pieza e1;
        e1=piezaDao.findPieza( txtIDPieza.getSelectedIndex());
        jCmbTipoPieza.setSelectedIndex(e1.getId_Tipo_Pieza());
        jTxtAreaCaracteristica.setText(e1.getCarateristica_Pieza());
        jFtxtStock.setText(Integer.toString(e1.getStock()));
        jFtxtStockMaximo.setText(Integer.toString(e1.getStock_Maximo()));
        jFtxtStockMinimo.setText(Integer.toString(e1.getStock_Minimo()));
        
        
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00",separadoresPersonalizados);
        List<HistoricoPrecioPieza> h1 = historicoPieza.findHistoricoPrecioPiezaEntities();
        for(HistoricoPrecioPieza p2 : h1){
                if(p2.getIdPieza() == e1.getId_Pieza()){
                    if(p2.getFechaFinal()==null){
                        jFtxtPrecio.setText(formato1.format(p2.getPrecio()));
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
        btnModificar3.setEnabled(true);
        
        }
        
    // TODO add your handling code here:
    }//GEN-LAST:event_txtIDPiezaItemStateChanged

    private void cmbIDPiezaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDPiezaItemStateChanged
        crearTbHistorialPrecio();
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIDPiezaItemStateChanged

    private void jTabbedPane3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane3FocusLost
        createCmbIDPieza();
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane3FocusLost

    private void jTableTipoPiezaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTipoPiezaMouseClicked

         int column=0;
        int fila = jTableTipoPieza.getSelectedRow();
        if (fila > -1){
            txtIDTipoPieza.setSelectedIndex(Integer.parseInt(jTableTipoPieza.getModel().getValueAt(fila, column).toString()));
            txtTipoPiezaNuevo.setText(String.valueOf(jTableTipoPieza.getValueAt(fila, ++column)));
            btnActivarDesactivar();
        }
    }//GEN-LAST:event_jTableTipoPiezaMouseClicked

    private void jTablePiezaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePiezaMouseClicked
        int column=0;
        int fila = jTablePieza.getSelectedRow();
        if (fila > -1){
            txtIDPieza.setSelectedIndex(Integer.parseInt(jTablePieza.getModel().getValueAt(fila, column).toString()));
            Pieza temp = piezaDao.findPieza(Integer.parseInt(jTablePieza.getModel().getValueAt(fila, column).toString()));
            jCmbTipoPieza.setSelectedIndex(temp.getId_Tipo_Pieza());
            jtxtNombre.setText(temp.getNombre());
            jTxtAreaCaracteristica.setText(temp.getCarateristica_Pieza());
            jFtxtPrecio.setText(String.valueOf(jTablePieza.getValueAt(fila, 4)));
            jFtxtStock.setText(String.valueOf(temp.getStock()));
            jFtxtStockMaximo.setText(String.valueOf(temp.getStock_Maximo()));
            jFtxtStockMinimo.setText(String.valueOf(temp.getStock_Minimo()));
            
            btnActivarDesactivarPieza();
            btnModificar3.enable(true);
        }
    }//GEN-LAST:event_jTablePiezaMouseClicked

    private void txtTipoPiezaNuevoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoPiezaNuevoKeyTyped
        char validar=evt.getKeyChar();
       if((validar<'a'||validar>'z')&& (validar<'A' || validar>'Z') && (validar!=(char)KeyEvent.VK_BACKSPACE && (validar!=(char)KeyEvent.VK_SPACE)) ){
           evt.consume();
           JOptionPane.showMessageDialog(null,"Solo se admiten letras para el nuevo tipo de pieza","Error!", JOptionPane.ERROR_MESSAGE);
       }
       else if((validar==(char)KeyEvent.VK_ENTER)){
           
           
           
       }
    }//GEN-LAST:event_txtTipoPiezaNuevoKeyTyped

    private void jFtxtPrecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFtxtPrecioKeyPressed
        char validar=evt.getKeyChar();
       if((validar<'0'||validar>'9')&& (validar<'.' || validar>'.') && (validar!=(char)KeyEvent.VK_BACKSPACE && (validar!=(char)KeyEvent.VK_SPACE)) ){
          JOptionPane.showMessageDialog(null,"Solo se admiten numeros para el precio","Error!", JOptionPane.ERROR_MESSAGE);
          jFtxtPrecio.setText("");
          evt.consume();
            //   JOptionPane.showMessageDialog(null,"Solo se admiten letras para el nuevo tipo de pieza","Error!", JOptionPane.ERROR_MESSAGE);
       }

        // TODO add your handling code here:
    }//GEN-LAST:event_jFtxtPrecioKeyPressed

    private void tablaBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBusquedaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaBusquedaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        crearTableBusquedaPieza();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPieza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPieza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPieza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPieza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FrmPieza().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar2;
    private javax.swing.JButton btnAgregar3;
    private javax.swing.JButton btnDesactivar2;
    private javax.swing.JButton btnDesactivar3;
    private javax.swing.JButton btnLimpiar2;
    private javax.swing.JButton btnLimpiar3;
    private javax.swing.JButton btnModificar2;
    private javax.swing.JButton btnModificar3;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnRegresar1;
    private javax.swing.JButton btnRegresar2;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalir1;
    private javax.swing.JButton btnSalir2;
    private javax.swing.JComboBox<String> cmbIDPieza;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jCmbTipoPieza;
    private javax.swing.JTextField jFtxtPrecio;
    private javax.swing.JFormattedTextField jFtxtStock;
    private javax.swing.JFormattedTextField jFtxtStockMaximo;
    private javax.swing.JFormattedTextField jFtxtStockMinimo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTablePieza;
    private javax.swing.JTable jTableTipoPieza;
    private javax.swing.JTable jTbHistorialPrecio;
    private javax.swing.JTextArea jTxtAreaCaracteristica;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JPanel pnlPieza;
    private javax.swing.JTable tablaBusqueda;
    private javax.swing.JComboBox<String> txtIDPieza;
    private javax.swing.JComboBox<String> txtIDTipoPieza;
    private javax.swing.JTextField txtNombreBusqueda;
    private javax.swing.JTextField txtTipoPiezaNuevo;
    // End of variables declaration//GEN-END:variables
}
