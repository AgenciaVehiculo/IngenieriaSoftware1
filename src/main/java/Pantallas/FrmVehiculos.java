/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;


import Clases.HistoricoPrecioVehiculos;
import Clases.Marca;
import Clases.Numero_Asientos;
import Clases.TipoCabina;
import Clases.TipoGasolina;
import Clases.TipoVehiculo;
import Clases.Tipo_color;
import Clases.Vehiculo;
import Clases.transmision;
import JPAController.HistoricoPrecioVehiculosJpaController;


import JPAController.MarcaJpaController;
import JPAController.Numero_AsientosJpaController;
import JPAController.TipoCabinaJpaController;
import JPAController.TipoGasolinaJpaController;
import JPAController.TipoVehiculoJpaController;
import JPAController.Tipo_colorJpaController;
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
public class FrmVehiculos extends javax.swing.JFrame {

    /**
     * Creates new form Empleados
     */
    MarcaJpaController Marcadao = new MarcaJpaController();
    Tipo_colorJpaController Colorrdao = new Tipo_colorJpaController();
    TipoCabinaJpaController TipoCabinadao = new TipoCabinaJpaController();
    TipoGasolinaJpaController TipoGasolinadao = new TipoGasolinaJpaController();
    transmisionJpaController TipoTransmisiondao = new transmisionJpaController();
    TipoVehiculoJpaController TipoVehiculodao = new TipoVehiculoJpaController();
    Numero_AsientosJpaController NumeroAsientosdao = new Numero_AsientosJpaController();
    VehiculoJpaController vehiculoDao = new VehiculoJpaController();
    HistoricoPrecioVehiculosJpaController historicoPrecioVehiculoDao = new HistoricoPrecioVehiculosJpaController();
    
    public FrmVehiculos() {
        initComponents();
        
        setIconImage(new ImageIcon(getClass().getResource("/Img/CarSoft-removebg-preview.png")).getImage());
        this.setExtendedState(MAXIMIZED_BOTH);
        jPanel1.setBackground(Color.CYAN);
        jPanel2.setBackground(Color.CYAN);
        jPanel3.setBackground(Color.CYAN);
        jPanel4.setBackground(Color.CYAN);
        jPanel5.setBackground(Color.CYAN);
        jPanel6.setBackground(Color.CYAN);
        jPanel7.setBackground(Color.CYAN);
        jPanel8.setBackground(Color.CYAN);
        jPanel9.setBackground(Color.CYAN);
        btnDesactivar1.setEnabled(false);
        btnDesactivar2.setEnabled(false);
        btnDesactivar3.setEnabled(false);
        btnDesactivar4.setEnabled(false);
        btnDesactivar5.setEnabled(false);
        btnDesactivar6.setEnabled(false);
        btnDesactivar7.setEnabled(false);
        btnDesactivar8.setEnabled(false);
        btnAgregar7.setEnabled(false);
        btnModificar7.setEnabled(false);
        btnSalir1.setAlignmentX(700);
        btnSalir1.setAlignmentY(20);
        createTableMarca();
        createComboBoxMarca();
        createTableColor();
        createComboBoxColor();
        createTableTipoVehiculo();
        createComboBoxTipoVehiculo();
        createTableTipoCabina();
        createComboBoxTipoCabina();
        createTableTipoGasolina();
        createComboBoxTipoGasolina();
        createTableTipoTransmision();
        createComboBoxTipoTransmision();
        createTableNumeroAsientos();
        createComboBoxNumeroAsientos();
        
        
        createcmbMarcaVehiculo();
        createcmbColorVehiculo();
        createcmbTipoVehiculoVehiculo();
        createcmbTipoCabinaVehiculo();
        createcmbTipoGasolinaVehiculo();
        createcmbTipoTransmisionVehiculo();
        createNumAsientosVehiculo();
        habilitarAgregarVehiculo();
        createTableVehiculosAgregar();
        createcmbIDVehiculo();
        createcmbMarcaBusqueda();
        createcmbColorBusqueda();
        createcmbTipoGasolinaBusqueda();
        createcmbTipoVehiculoBusqueda();
    }
    private void createcmbMarcaBusqueda(){
        //cmbMarcaBusqueda
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        cmbMarcaBusqueda.setModel(modelo);
        List<Marca> temp = Marcadao.findMarcaEntities();
        modelo.addElement("Seleccione");//modelo.addElement("Nuevo");
        temp.forEach((e) -> {
            modelo.addElement(e.getMarca());
        });
    }
    
    private void createTableVehiculosAgregar(){
        DefaultTableModel modelo = new DefaultTableModel();
        tbAgregarVehiculo.setModel(modelo);
        modelo.addColumn("ID Vehiculo");
        
        modelo.addColumn("Marca");
        modelo.addColumn("Modelo");
        modelo.addColumn("Color");
        modelo.addColumn("Tipo de Combustible");
        modelo.addColumn("Tipo de Vehiculo");
        modelo.addColumn("Número de asientos");
        modelo.addColumn("Cilindraje");
        modelo.addColumn("Stock");
        modelo.addColumn("Stock Maximo");
        modelo.addColumn("Stock Minimo");
        modelo.addColumn("Precio");
        
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);
        
        List<Vehiculo> temp = vehiculoDao.findVehiculoEntities();
        //List<Marca> tempMarca = Marcadao.findMarcaEntities();
        //List<Numero_Asientos> tempAsientos = NumeroAsientosdao.findNumero_AsientosEntities();
        //++++++List<TipoCabina> tempCabina = TipoCabinadao.findTipoCabinaEntities(); // Añadir cabina para el tercer sprint
        //List<TipoGasolina> tempGasolina = TipoGasolinadao.findTipoGasolinaEntities();
        //List<Tipo_color> tempColor = Colorrdao.findTipo_colorEntities();
        List<HistoricoPrecioVehiculos> tempPrecio = historicoPrecioVehiculoDao.findHistoricoPrecioVehiculosEntities();
        
        String aux1="";
        String aux2="";
        String aux3="";
        String aux4="";
        String aux5="";
       // String aux6="";
        double aux7=0.00;
        
        for(Vehiculo e : temp){
            aux1 = Marcadao.findMarca(e.getId_marca()).getMarca() ;
            aux2 = Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color();
            aux3 = TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina();
            aux4 = TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo();
            aux5= NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos();
            for(HistoricoPrecioVehiculos xd : tempPrecio){
                if(e.getId_vehiculo()== xd.getId_vehiculo() && xd.getFechaFinal()==null){
                    aux7=xd.getPrecio();
                }
            }
            
            modelo.addRow(new Object[]{
                e.getId_vehiculo(),
                aux1,e.getVin(),
                aux2,
                aux3,
                aux4,
                aux5,
                e.getTotal_cilindraje(),
                e.getStock(),
                e.getStock_maximo(),
                e.getStock_minimo(),
                formato1.format(aux7),
                (e.isEstado())? "Activo" : "Inactivo"
                    
                
            });
        }
    }
    private void createcmbIDVehiculo(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbIDVehiculo.setModel(modelo);
        List<Vehiculo> temp = vehiculoDao.findVehiculoEntities();
        modelo.addElement("Nuevo");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getId_vehiculo());
        });
    }
    
    private void habilitarAgregarVehiculo(){
        //Validacion de agregar
        if(Marcadao.getMarcaCount()!=0 && Colorrdao.getTipo_colorCount()!=0 && TipoCabinadao.getTipoCabinaCount()!=0 && TipoGasolinadao.getTipoGasolinaCount()!=0 && TipoTransmisiondao.gettransmisionCount()!=0 && TipoVehiculodao.getTipoVehiculoCount()!=0 && NumeroAsientosdao.getNumero_AsientosCount()!=0){
            btnAgregar7.setEnabled(true);
        }
        else{
            
        }
        //Fin de validacion agregar
        
        
        
        
        
    }
    
    private void createNumAsientosVehiculo(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbNumAsientos.setModel(modelo);
        List<Numero_Asientos> temp = NumeroAsientosdao.findNumero_AsientosEntities();
        modelo.addElement("Seleccione");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getNumero_Asientos());
        });
    }
    
    private void createcmbTipoTransmisionVehiculo(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbTransmisionVehiculo.setModel(modelo);
        List<transmision> temp = TipoTransmisiondao.findtransmisionEntities();
        modelo.addElement("Seleccione");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getTransmision());
        });
    }
    
    private void createcmbTipoGasolinaBusqueda(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbGasolinaBusqueda.setModel(modelo);
        List<TipoGasolina> temp = TipoGasolinadao.findTipoGasolinaEntities();
        modelo.addElement("Seleccione");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getTipoGasolina());
        });
    }
    
    private void createcmbTipoGasolinaVehiculo(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbGasolinaVehiculo.setModel(modelo);
        List<TipoGasolina> temp = TipoGasolinadao.findTipoGasolinaEntities();
        modelo.addElement("Seleccione");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getTipoGasolina());
        });
    }
    
    private void createcmbTipoCabinaVehiculo(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbCabinaVehiculo.setModel(modelo);
        List<TipoCabina> temp = TipoCabinadao.findTipoCabinaEntities();
        modelo.addElement("Seleccione");//modelo.addElement("Nuevo");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getTipoCabina());
        });
    }
    
    private void createcmbTipoVehiculoBusqueda(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbTipoVehiculoBusqueda.setModel(modelo);
        List<TipoVehiculo> temp = TipoVehiculodao.findTipoVehiculoEntities();
        modelo.addElement("Seleccione");//modelo.addElement("Nuevo");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getTipoVehiculo());
        });
    }
    
    private void createcmbTipoVehiculoVehiculo(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbTipoVehiculoVehiculo.setModel(modelo);
        List<TipoVehiculo> temp = TipoVehiculodao.findTipoVehiculoEntities();
        modelo.addElement("Seleccione");//modelo.addElement("Nuevo");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getTipoVehiculo());
        });
    }
        
    private void createcmbMarcaVehiculo(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        cmbMarcaVehiculo.setModel(modelo);
        List<Marca> temp = Marcadao.findMarcaEntities();
        modelo.addElement("Seleccione");//modelo.addElement("Nuevo");
        temp.forEach((e) -> {
            modelo.addElement(e.getMarca());
        });
    }
    
    private void createcmbColorBusqueda(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbColorBusqueda.setModel(modelo);
        List<Tipo_color > temp = Colorrdao.findTipo_colorEntities();
        modelo.addElement("Seleccione");//modelo.addElement("Nuevo");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getTipo_color());
        });
    }
    
    private void createcmbColorVehiculo(){
    DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbColorVehiculo.setModel(modelo);
        List<Tipo_color > temp = Colorrdao.findTipo_colorEntities();
        modelo.addElement("Seleccione");//modelo.addElement("Nuevo");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getTipo_color());
        });
}
    public void btnActivarDesactivarMarca(){
        Marca temp = new Marca();
        temp = Marcadao.findMarca(cmbIDMarca.getSelectedIndex());
        
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
    
    public void createComboBoxMarca(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        cmbIDMarca.setModel(modelo);
        List<Marca> temp = Marcadao.findMarcaEntities();
        modelo.addElement("Nuevo");
        temp.forEach((e) -> {
            modelo.addElement(e.getIdMarca());
        });
    }
        
    public void createTableMarca(){
        DefaultTableModel modelo = new DefaultTableModel();
        tblMarca.setModel(modelo);
        modelo.addColumn("ID Marca");
        modelo.addColumn("Marca");
        modelo.addColumn("Estado");
        
        List<Marca> temp = Marcadao.findMarcaEntities();
        
        for(Marca tp : temp)
            modelo.addRow(
                    new Object[]{
                        tp.getIdMarca(),
                        tp.getMarca(),
                        (tp.isEstado())?"Activo":"Inactivo"
            });  
    }
    
    public void cmbIDMarca(){
        if(cmbIDMarca.getSelectedIndex()==0){
            txtMarca.setText("");
            btnDesactivar1.setEnabled(false);

        }
        else{
            Marca m;
            m=Marcadao.findMarca(cmbIDMarca.getSelectedIndex());
            txtMarca.setText(m.getMarca());
            btnActivarDesactivarMarca();
        }
    }
    
    public void btnActivarDesactivarColor(){
        Tipo_color temp = new Tipo_color();
        temp = Colorrdao.findTipo_color(cmbIDColor.getSelectedIndex());
        
        if(temp.isEstado()){
        btnDesactivar2.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnDesactivar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar2.setText("Desactivar");  
        btnDesactivar2.setEnabled(true);
        }
        else{
            btnDesactivar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            btnDesactivar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar2.setText("Activar");
            btnDesactivar2.setEnabled(true);
        }
        }
    
    public void createComboBoxColor(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbIDColor.setModel(modelo);
        List<Tipo_color > temp = Colorrdao.findTipo_colorEntities();
        modelo.addElement("Nuevo");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getId_tipo_color());
        });
    }
        
    public void createTableColor(){
        DefaultTableModel modelo = new DefaultTableModel();
        tblColor.setModel(modelo);
        modelo.addColumn("ID Color");
        modelo.addColumn("Color");
        modelo.addColumn("Estado");
        
        List<Tipo_color> temp = Colorrdao.findTipo_colorEntities();
        
        for(Tipo_color tp : temp)
            modelo.addRow(
                    new Object[]{
                        tp.getId_tipo_color(),
                        tp.getTipo_color(),
                        (tp.isEstado())?"Activo":"Inactivo"
            });  
    }
    
    public void btnActivarDesactivarTipoVehiculo(){
        TipoVehiculo temp = new TipoVehiculo();
        temp = TipoVehiculodao.findTipoVehiculo(cmbIDTipoVehiculo.getSelectedIndex());
        
        if(temp.isEstado()){
        btnDesactivar3.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnDesactivar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar3.setText("Desactivar");  
        btnDesactivar3.setEnabled(true);
        }
        else{
            btnDesactivar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            btnDesactivar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar3.setText("Activar");
            btnDesactivar3.setEnabled(true);
        }
        }
    
    public void createComboBoxTipoVehiculo(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbIDTipoVehiculo.setModel(modelo);
        List<TipoVehiculo> temp = TipoVehiculodao.findTipoVehiculoEntities();
        modelo.addElement("Nuevo");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getIdTipoVehiculo());
        });
    }
        
    public void createTableTipoVehiculo(){
        DefaultTableModel modelo = new DefaultTableModel();
        tblTipoVehiculo.setModel(modelo);
        modelo.addColumn("ID Tipo Vehiculo");
        modelo.addColumn("Tipo Vehiculo");
        modelo.addColumn("Estado");
        
        List<TipoVehiculo> temp = TipoVehiculodao.findTipoVehiculoEntities();
        
        for(TipoVehiculo tp : temp)
            modelo.addRow(
                    new Object[]{
                        tp.getIdTipoVehiculo(),
                        tp.getTipoVehiculo(),
                        (tp.isEstado())?"Activo":"Inactivo"
            });  
    }
    
    public void btnActivarDesactivarTipoCabina(){
        TipoCabina temp = new TipoCabina();
        temp = TipoCabinadao.findTipoCabina(cmbPiezaClave.getSelectedIndex());
        
        if(temp.isEstado()){
        btnDesactivar4.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnDesactivar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar4.setText("Desactivar");  
        btnDesactivar4.setEnabled(true);
        }
        else{
            btnDesactivar4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            btnDesactivar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar4.setText("Activar");
            btnDesactivar4.setEnabled(true);
        }
        }
    
    private void createComboBoxTipoCabina(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbPiezaClave.setModel(modelo);
        List<TipoCabina> temp = TipoCabinadao.findTipoCabinaEntities();
        modelo.addElement("Nuevo");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getIdTipoCabina());
        });
    }
        
    public void createTableTipoCabina(){
        DefaultTableModel modelo = new DefaultTableModel();
        tblTipoCabina.setModel(modelo);
        modelo.addColumn("ID Tipo Cabina");
        modelo.addColumn("Tipo Cabina");
        modelo.addColumn("Estado");
        
        List<TipoCabina> temp = TipoCabinadao.findTipoCabinaEntities();
        
        for(TipoCabina tp : temp)
            modelo.addRow(
                    new Object[]{
                        tp.getIdTipoCabina(),
                        tp.getTipoCabina(),
                        (tp.isEstado())?"Activo":"Inactivo"
            });  
    }
    
    public void btnActivarDesactivarTipoGasolina(){
        TipoGasolina temp = new TipoGasolina();
        temp = TipoGasolinadao.findTipoGasolina(cmbIDTipoGasolina.getSelectedIndex());
        
        if(temp.isEstado()){
        btnDesactivar5.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnDesactivar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar5.setText("Desactivar");  
        btnDesactivar5.setEnabled(true);
        }
        else{
            btnDesactivar5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            btnDesactivar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar5.setText("Activar");
            btnDesactivar5.setEnabled(true);
        }
        }
    
    public void createComboBoxTipoGasolina(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbIDTipoGasolina.setModel(modelo);
        List<TipoGasolina> temp = TipoGasolinadao.findTipoGasolinaEntities();
        modelo.addElement("Nuevo");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getIdTipoGasolina());
        });
    }
        
    public void createTableTipoGasolina(){
        DefaultTableModel modelo = new DefaultTableModel();
        tblTipoGasolina.setModel(modelo);
        modelo.addColumn("ID Tipo Gasolina");
        modelo.addColumn("Tipo Gasolina");
        modelo.addColumn("Estado");
        
        List<TipoGasolina> temp = TipoGasolinadao.findTipoGasolinaEntities();
        
        for(TipoGasolina tp : temp)
            modelo.addRow(
                    new Object[]{
                        tp.getIdTipoGasolina(),
                        tp.getTipoGasolina(),
                        (tp.isEstado())?"Activo":"Inactivo"
            });  
    }
    
    public void btnActivarDesactivarTipoTransmision(){
        transmision temp = new transmision();
        temp = TipoTransmisiondao.findtransmision(cmbIDTipoTransmision.getSelectedIndex());
        
        if(temp.isEstado()){
        btnDesactivar6.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnDesactivar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar6.setText("Desactivar");  
        btnDesactivar6.setEnabled(true);
        }
        else{
            btnDesactivar6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            btnDesactivar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar6.setText("Activar");
            btnDesactivar6.setEnabled(true);
        }
        }
    
    public void createComboBoxTipoTransmision(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbIDTipoTransmision.setModel(modelo);
        List<transmision> temp = TipoTransmisiondao.findtransmisionEntities();
        modelo.addElement("Nuevo");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getId_transmision());
        });
    }
        
    public void createTableTipoTransmision(){
        DefaultTableModel modelo = new DefaultTableModel();
        tblTipoTransmision.setModel(modelo);
        modelo.addColumn("ID Tipo Transmision");
        modelo.addColumn("Tipo Transmision");
        modelo.addColumn("Estado");
        
        List<transmision> temp = TipoTransmisiondao.findtransmisionEntities();
        
        for(transmision tp : temp)
            modelo.addRow(
                    new Object[]{
                        tp.getId_transmision(),
                        tp.getTransmision(),
                        (tp.isEstado())?"Activo":"Inactivo"
            });  
    }
    
    public void btnActivarDesactivarNumeroAsientos(){
        Numero_Asientos temp = new Numero_Asientos();
        temp = NumeroAsientosdao.findNumero_Asientos(cmbIDNumeroAsientos.getSelectedIndex());
        
        if(temp.isEstado()){
        btnDesactivar8.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnDesactivar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar8.setText("Desactivar");  
        btnDesactivar8.setEnabled(true);
        }
        else{
            btnDesactivar8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            btnDesactivar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar8.setText("Activar");
            btnDesactivar8.setEnabled(true);
        }
        }
    
    public void createComboBoxNumeroAsientos(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbIDNumeroAsientos.setModel(modelo);
        List<Numero_Asientos> temp = NumeroAsientosdao.findNumero_AsientosEntities();
        modelo.addElement("Nuevo");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getId_Numero_Asientos());
        });
    }
        
    public void createTableNumeroAsientos(){
        DefaultTableModel modelo = new DefaultTableModel();
        tblNumeroAsientos.setModel(modelo);
        modelo.addColumn("ID Número de Asientos");
        modelo.addColumn("Número de Asientos");
        modelo.addColumn("Estado");
        
        List<Numero_Asientos> temp = NumeroAsientosdao.findNumero_AsientosEntities();
        
        for(Numero_Asientos tp : temp)
            modelo.addRow(
                    new Object[]{
                        tp.getId_Numero_Asientos(),
                        tp.getNumero_Asientos(),
                        (tp.isEstado())?"Activo":"Inactivo"
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        chkMarca = new javax.swing.JCheckBox();
        chkColor = new javax.swing.JCheckBox();
        chkTipoVehiculo = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cmbMarcaBusqueda = new javax.swing.JComboBox<>();
        cmbColorBusqueda = new javax.swing.JComboBox<>();
        cmbTipoVehiculoBusqueda = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        cmbGasolinaBusqueda = new javax.swing.JComboBox<>();
        chkTipoGasolina = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbBusqueda = new javax.swing.JTable();
        btnRegresar8 = new javax.swing.JButton();
        btnSalir8 = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cmbIDMarca = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        btnAgregar1 = new javax.swing.JButton();
        btnModificar1 = new javax.swing.JButton();
        btnLimpiar1 = new javax.swing.JButton();
        btnDesactivar1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblMarca = new javax.swing.JTable();
        btnRegresar1 = new javax.swing.JButton();
        btnSalir1 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        cmbIDColor = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        btnAgregar2 = new javax.swing.JButton();
        btnModificar2 = new javax.swing.JButton();
        btnLimpiar2 = new javax.swing.JButton();
        btnDesactivar2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblColor = new javax.swing.JTable();
        btnRegresar2 = new javax.swing.JButton();
        btnSalir2 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        cmbIDTipoVehiculo = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtTipoVehiculo = new javax.swing.JTextField();
        btnAgregar3 = new javax.swing.JButton();
        btnModificar3 = new javax.swing.JButton();
        btnLimpiar3 = new javax.swing.JButton();
        btnDesactivar3 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblTipoVehiculo = new javax.swing.JTable();
        btnRegresar3 = new javax.swing.JButton();
        btnSalir3 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txtTipoCabina = new javax.swing.JTextField();
        btnAgregar4 = new javax.swing.JButton();
        btnModificar4 = new javax.swing.JButton();
        btnLimpiar4 = new javax.swing.JButton();
        btnDesactivar4 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblTipoCabina = new javax.swing.JTable();
        btnRegresar4 = new javax.swing.JButton();
        btnSalir4 = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        cmbPiezaClave = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        cmbIDTipoGasolina = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtTipoGasolina = new javax.swing.JTextField();
        btnAgregar5 = new javax.swing.JButton();
        btnModificar5 = new javax.swing.JButton();
        btnLimpiar5 = new javax.swing.JButton();
        btnDesactivar5 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblTipoGasolina = new javax.swing.JTable();
        btnRegresar5 = new javax.swing.JButton();
        btnSalir5 = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        cmbIDNumeroAsientos = new javax.swing.JComboBox<>();
        jLabel48 = new javax.swing.JLabel();
        txtNumeroAsientos = new javax.swing.JTextField();
        btnAgregar8 = new javax.swing.JButton();
        btnModificar8 = new javax.swing.JButton();
        btnLimpiar8 = new javax.swing.JButton();
        btnDesactivar8 = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblNumeroAsientos = new javax.swing.JTable();
        btnSalir9 = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        btnRegresar9 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        cmbIDTipoTransmision = new javax.swing.JComboBox<>();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txtTipoTransmision = new javax.swing.JTextField();
        btnAgregar6 = new javax.swing.JButton();
        btnModificar6 = new javax.swing.JButton();
        btnLimpiar6 = new javax.swing.JButton();
        btnDesactivar6 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblTipoTransmision = new javax.swing.JTable();
        btnRegresar6 = new javax.swing.JButton();
        btnSalir6 = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cmbColorVehiculo = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbAgregarVehiculo = new javax.swing.JTable();
        cmbMarcaVehiculo = new javax.swing.JComboBox<>();
        cmbTipoVehiculoVehiculo = new javax.swing.JComboBox<>();
        cmbCabinaVehiculo = new javax.swing.JComboBox<>();
        cmbTransmisionVehiculo = new javax.swing.JComboBox<>();
        cmbGasolinaVehiculo = new javax.swing.JComboBox<>();
        txtVin = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnLimpiar7 = new javax.swing.JButton();
        btnDesactivar7 = new javax.swing.JButton();
        btnModificar7 = new javax.swing.JButton();
        btnAgregar7 = new javax.swing.JButton();
        cmbIDVehiculo = new javax.swing.JComboBox<>();
        txtCilindraje = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        btnSalir7 = new javax.swing.JButton();
        btnRegresar7 = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        cmbNumAsientos = new javax.swing.JComboBox<>();
        ftxtStock = new javax.swing.JFormattedTextField();
        ftxtStockMinimo = new javax.swing.JFormattedTextField();
        ftxtStockMaximo = new javax.swing.JFormattedTextField();
        txtPrecio = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jPanel2.setLayout(null);

        chkMarca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkMarcaItemStateChanged(evt);
            }
        });
        jPanel2.add(chkMarca);
        chkMarca.setBounds(200, 66, 21, 21);

        chkColor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkColorItemStateChanged(evt);
            }
        });
        jPanel2.add(chkColor);
        chkColor.setBounds(200, 94, 21, 21);

        chkTipoVehiculo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkTipoVehiculoItemStateChanged(evt);
            }
        });
        jPanel2.add(chkTipoVehiculo);
        chkTipoVehiculo.setBounds(200, 125, 21, 21);

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Marca:");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(59, 70, 40, 14);

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Color:");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(58, 97, 40, 14);

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Tipo de Vehiculo:");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(2, 125, 150, 28);

        cmbMarcaBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Toyota", "Chevrolet", "Honda" }));
        cmbMarcaBusqueda.setEnabled(false);
        jPanel2.add(cmbMarcaBusqueda);
        cmbMarcaBusqueda.setBounds(96, 67, 102, 28);

        cmbColorBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Negro", "Rojo", "Azul", " " }));
        cmbColorBusqueda.setEnabled(false);
        jPanel2.add(cmbColorBusqueda);
        cmbColorBusqueda.setBounds(96, 94, 102, 28);

        cmbTipoVehiculoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Deportivo", "Comercial", " " }));
        cmbTipoVehiculoBusqueda.setEnabled(false);
        jPanel2.add(cmbTipoVehiculoBusqueda);
        cmbTipoVehiculoBusqueda.setBounds(96, 125, 102, 28);

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Tipo de Combustible:");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(250, 71, 180, 14);

        cmbGasolinaBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diesel", " " }));
        cmbGasolinaBusqueda.setEnabled(false);
        jPanel2.add(cmbGasolinaBusqueda);
        cmbGasolinaBusqueda.setBounds(375, 68, 102, 28);

        chkTipoGasolina.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkTipoGasolinaItemStateChanged(evt);
            }
        });
        chkTipoGasolina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkTipoGasolinaActionPerformed(evt);
            }
        });
        jPanel2.add(chkTipoGasolina);
        chkTipoGasolina.setBounds(479, 67, 21, 21);

        tbBusqueda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "VIN", "Marca", "Color", "Tipo de Gasolina", "Tipo de Vehiculo", "Numero de asientos", "Cilindraje", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbBusqueda);

        jPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(10, 171, 1270, 184);

        btnRegresar8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar8.setText("Regresar");
        btnRegresar8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar8ActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegresar8);
        btnRegresar8.setBounds(1260, 470, 153, 45);

        btnSalir8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir8.setText("Salir");
        btnSalir8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir8ActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalir8);
        btnSalir8.setBounds(1310, 20, 93, 41);

        jLabel46.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Busqueda por Filtro");
        jPanel2.add(jLabel46);
        jLabel46.setBounds(810, 10, 230, 35);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(375, 106, 102, 39);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Fondo.jpg"))); // NOI18N
        jLabel19.setText("jLabel19");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(0, 0, 1780, 780);

        jTabbedPane1.addTab("Busqueda por filtro", jPanel2);

        cmbIDMarca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDMarcaItemStateChanged(evt);
            }
        });

        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("ID Marca:");

        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("Nueva marca:");

        txtMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMarcaKeyTyped(evt);
            }
        });

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

        tblMarca.setModel(new javax.swing.table.DefaultTableModel(
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
                "ID Marca", "Marca", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblMarca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMarcaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblMarcaMouseEntered(evt);
            }
        });
        jScrollPane4.setViewportView(tblMarca);

        btnRegresar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar1.setText("Regresar");
        btnRegresar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar1ActionPerformed(evt);
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

        jLabel36.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Ingresar Nueva Marca");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbIDMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btnAgregar1)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar1)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar1)
                        .addGap(18, 18, 18)
                        .addComponent(btnDesactivar1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegresar1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(613, 613, 613)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir1)))
                .addGap(242, 242, 242))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir1))
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cmbIDMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(btnAgregar1))
                    .addComponent(btnModificar1)
                    .addComponent(btnLimpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnDesactivar1)))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(btnRegresar1)
                .addGap(181, 181, 181))
        );

        jTabbedPane1.addTab("Nueva Marca", jPanel3);

        cmbIDColor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDColorItemStateChanged(evt);
            }
        });

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("ID Color");

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Nuevo Color:");

        txtColor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtColorKeyTyped(evt);
            }
        });

        btnAgregar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar2.setText("Agregar");
        btnAgregar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar2ActionPerformed(evt);
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

        btnDesactivar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar2.setText("Desactivar");
        btnDesactivar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDesactivar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar2ActionPerformed(evt);
            }
        });

        tblColor.setModel(new javax.swing.table.DefaultTableModel(
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
        tblColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblColorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblColorMouseEntered(evt);
            }
        });
        jScrollPane5.setViewportView(tblColor);

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

        jLabel29.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel29.setText("Ingresar Nuevo Color");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(btnAgregar2)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnModificar2)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnLimpiar2))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel28))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbIDColor, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addComponent(btnDesactivar2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 945, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel29)
                        .addGap(603, 603, 603)
                        .addComponent(btnSalir2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRegresar2)))
                .addGap(194, 194, 194))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir2))
                .addGap(57, 57, 57)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbIDColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(btnAgregar2))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnModificar2)
                        .addComponent(btnLimpiar2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDesactivar2)))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addComponent(btnRegresar2)
                .addGap(103, 103, 103))
        );

        jTabbedPane1.addTab("Nuevo Color", jPanel4);

        cmbIDTipoVehiculo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDTipoVehiculoItemStateChanged(evt);
            }
        });

        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel32.setText("ID Tipo de Vehículo:");

        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel33.setText("Nuevo Tiipo de Vehículo:");

        txtTipoVehiculo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoVehiculoKeyTyped(evt);
            }
        });

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

        tblTipoVehiculo.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTipoVehiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTipoVehiculoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblTipoVehiculoMouseEntered(evt);
            }
        });
        jScrollPane6.setViewportView(tblTipoVehiculo);

        btnRegresar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar3.setText("Regresar");
        btnRegresar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar3ActionPerformed(evt);
            }
        });

        btnSalir3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir3.setText("Salir");
        btnSalir3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir3ActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel34.setText("Ingresar Nuevo de Tipo de Vehículo");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbIDTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(btnAgregar3)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar3)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiar3)))
                        .addGap(18, 18, 18)
                        .addComponent(btnDesactivar3)))
                .addContainerGap(1220, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(623, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegresar3)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addGap(505, 505, 505)
                        .addComponent(btnSalir3)))
                .addGap(193, 193, 193))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir3)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbIDTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(btnAgregar3))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnModificar3)
                        .addComponent(btnLimpiar3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDesactivar3)))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addComponent(btnRegresar3)
                .addGap(101, 101, 101))
        );

        jTabbedPane1.addTab("Nuevo Tipo de Vehículo", jPanel6);

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel35.setText("ID Tipo de Cabina:");

        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel37.setText("Nuevo Tipo de Cabina:");

        txtTipoCabina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoCabinaKeyTyped(evt);
            }
        });

        btnAgregar4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar4.setText("Agregar");
        btnAgregar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar4ActionPerformed(evt);
            }
        });

        btnModificar4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar4.setText("Modificar");
        btnModificar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar4ActionPerformed(evt);
            }
        });

        btnLimpiar4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar4.setText("Limpiar");
        btnLimpiar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar4ActionPerformed(evt);
            }
        });

        btnDesactivar4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar4.setText("Desactivar");
        btnDesactivar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDesactivar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar4ActionPerformed(evt);
            }
        });

        tblTipoCabina.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTipoCabina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTipoCabinaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblTipoCabinaMouseEntered(evt);
            }
        });
        jScrollPane7.setViewportView(tblTipoCabina);

        btnRegresar4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar4.setText("Regresar");
        btnRegresar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar4ActionPerformed(evt);
            }
        });

        btnSalir4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir4.setText("Salir");
        btnSalir4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir4ActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel38.setText("Ingresar Nuevo Tipo de Cabina");

        cmbPiezaClave.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(btnAgregar4)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar4)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiar4))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel37))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTipoCabina, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                    .addComponent(cmbPiezaClave, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addComponent(btnDesactivar4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(508, 508, 508)
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRegresar4)
                            .addComponent(btnSalir4))
                        .addGap(189, 189, 189))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir4)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPiezaClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoCabina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnAgregar4))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnModificar4)
                            .addComponent(btnLimpiar4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar4))))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addComponent(btnRegresar4)
                .addGap(103, 103, 103))
        );

        jTabbedPane1.addTab("Nuevo Tipo de Cabina", jPanel7);

        cmbIDTipoGasolina.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDTipoGasolinaItemStateChanged(evt);
            }
        });

        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel39.setText("ID Tipo de Gasolina: ");

        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel40.setText("Tipo de Gasolina:");

        txtTipoGasolina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoGasolinaKeyTyped(evt);
            }
        });

        btnAgregar5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar5.setText("Agregar");
        btnAgregar5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar5ActionPerformed(evt);
            }
        });

        btnModificar5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar5.setText("Modificar");
        btnModificar5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar5ActionPerformed(evt);
            }
        });

        btnLimpiar5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar5.setText("Limpiar");
        btnLimpiar5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar5ActionPerformed(evt);
            }
        });

        btnDesactivar5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar5.setText("Desactivar");
        btnDesactivar5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDesactivar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar5ActionPerformed(evt);
            }
        });

        tblTipoGasolina.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTipoGasolina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTipoGasolinaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblTipoGasolinaMouseEntered(evt);
            }
        });
        jScrollPane8.setViewportView(tblTipoGasolina);

        btnRegresar5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar5.setText("Regresar");
        btnRegresar5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar5ActionPerformed(evt);
            }
        });

        btnSalir5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir5.setText("Salir");
        btnSalir5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir5ActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel41.setText("Ingresar Nuevo Tipo de Gasolina");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(btnAgregar5)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnModificar5)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnLimpiar5))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cmbIDTipoGasolina, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtTipoGasolina, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addComponent(btnDesactivar5)))
                        .addContainerGap(1211, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRegresar5)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addGap(532, 532, 532)
                                .addComponent(btnSalir5)))
                        .addGap(194, 194, 194))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSalir5)
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbIDTipoGasolina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipoGasolina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(btnAgregar5))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnModificar5)
                        .addComponent(btnLimpiar5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDesactivar5)))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addComponent(btnRegresar5)
                .addGap(105, 105, 105))
        );

        jTabbedPane1.addTab("Nuevo Tipo de Gasolina", jPanel8);

        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel47.setText("ID Número de Asientos:");

        cmbIDNumeroAsientos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDNumeroAsientosItemStateChanged(evt);
            }
        });

        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel48.setText("Nuevo Número de Asientos:");

        txtNumeroAsientos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroAsientosKeyTyped(evt);
            }
        });

        btnAgregar8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar8.setText("Agregar");
        btnAgregar8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar8ActionPerformed(evt);
            }
        });

        btnModificar8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar8.setText("Modificar");
        btnModificar8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar8ActionPerformed(evt);
            }
        });

        btnLimpiar8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar8.setText("Limpiar");
        btnLimpiar8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar8ActionPerformed(evt);
            }
        });

        btnDesactivar8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar8.setText("Desactivar");
        btnDesactivar8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDesactivar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar8ActionPerformed(evt);
            }
        });

        tblNumeroAsientos.setModel(new javax.swing.table.DefaultTableModel(
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
                "ID Número de Asientos", "Nuevo Número de Asientos", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblNumeroAsientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNumeroAsientosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblNumeroAsientosMouseEntered(evt);
            }
        });
        jScrollPane10.setViewportView(tblNumeroAsientos);

        btnSalir9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir9.setText("Salir");
        btnSalir9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir9ActionPerformed(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel49.setText("Ingresar Nuevo número de Asientos");

        btnRegresar9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar9.setText("Regresar");
        btnRegresar9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(btnAgregar8)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar8)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar8)
                        .addGap(18, 18, 18)
                        .addComponent(btnDesactivar8))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbIDNumeroAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumeroAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(635, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel49)
                        .addGap(778, 778, 778))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRegresar9)
                            .addComponent(btnSalir9))
                        .addGap(507, 507, 507))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btnSalir9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbIDNumeroAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar8)
                    .addComponent(btnModificar8)
                    .addComponent(btnLimpiar8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesactivar8))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addComponent(btnRegresar9)
                .addGap(104, 104, 104))
        );

        jTabbedPane1.addTab("Nuevo Numero de Asientos", jPanel9);

        cmbIDTipoTransmision.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDTipoTransmisionItemStateChanged(evt);
            }
        });

        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel42.setText("ID Tipo de Transmisión:");

        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel43.setText("Tipo de Transmisión:");

        txtTipoTransmision.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoTransmisionKeyTyped(evt);
            }
        });

        btnAgregar6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar6.setText("Agregar");
        btnAgregar6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar6ActionPerformed(evt);
            }
        });

        btnModificar6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar6.setText("Modificar");
        btnModificar6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar6ActionPerformed(evt);
            }
        });

        btnLimpiar6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar6.setText("Limpiar");
        btnLimpiar6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar6ActionPerformed(evt);
            }
        });

        btnDesactivar6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar6.setText("Desactivar");
        btnDesactivar6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDesactivar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar6ActionPerformed(evt);
            }
        });

        tblTipoTransmision.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTipoTransmision.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTipoTransmisionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblTipoTransmisionMouseEntered(evt);
            }
        });
        jScrollPane9.setViewportView(tblTipoTransmision);

        btnRegresar6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar6.setText("Regresar");
        btnRegresar6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar6ActionPerformed(evt);
            }
        });

        btnSalir6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir6.setText("Salir");
        btnSalir6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir6ActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel44.setText("Ingresar Nuevo Tipo de Transmisión");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(btnAgregar6)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnModificar6)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnLimpiar6))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel43)
                                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbIDTipoTransmision, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTipoTransmision, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addComponent(btnDesactivar6)))
                        .addContainerGap(1201, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel44)
                                .addGap(203, 203, 203)
                                .addComponent(btnSalir6)
                                .addGap(486, 486, 486))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btnRegresar6)
                                .addGap(478, 478, 478))))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbIDTipoTransmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipoTransmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalir6)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnAgregar6))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnModificar6)
                            .addComponent(btnLimpiar6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar6))))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(btnRegresar6)
                .addGap(132, 132, 132))
        );

        jTabbedPane1.addTab("Nuevo Tipo de Transmisión", jPanel5);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("ID Vehiculo:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(48, 86, 107, 14);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Modelo:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(48, 145, 107, 14);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Marca:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(48, 114, 107, 14);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Color");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(48, 176, 107, 14);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Tipo de Vehiculo:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(48, 207, 107, 14);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Tipo de Gasolina:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(48, 238, 107, 14);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Numero Asientos:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(347, 83, 117, 14);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Tipo de Cabina:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(347, 111, 117, 14);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Tipo de Transmision:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(347, 145, 117, 14);

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Cantidad de cilindraje:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(292, 176, 170, 14);

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Precio:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(625, 114, 117, 14);

        jPanel1.add(cmbColorVehiculo);
        cmbColorVehiculo.setBounds(159, 173, 139, 28);

        tbAgregarVehiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Vehiculo", "VIN", "Marca", "Modelo", "Color", "Tipo Gasolina", "Tipo Vehiculo", "Numero de Asientos", "Total de Cilindraje", "Stock", "Stock Minimo", "Stock Máximo", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, false, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbAgregarVehiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAgregarVehiculoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbAgregarVehiculo);
        if (tbAgregarVehiculo.getColumnModel().getColumnCount() > 0) {
            tbAgregarVehiculo.getColumnModel().getColumn(7).setPreferredWidth(100);
            tbAgregarVehiculo.getColumnModel().getColumn(8).setPreferredWidth(90);
        }

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(48, 347, 1176, 183);

        jPanel1.add(cmbMarcaVehiculo);
        cmbMarcaVehiculo.setBounds(159, 111, 139, 28);

        jPanel1.add(cmbTipoVehiculoVehiculo);
        cmbTipoVehiculoVehiculo.setBounds(159, 204, 139, 28);

        jPanel1.add(cmbCabinaVehiculo);
        cmbCabinaVehiculo.setBounds(468, 111, 139, 28);

        jPanel1.add(cmbTransmisionVehiculo);
        cmbTransmisionVehiculo.setBounds(468, 142, 139, 28);

        jPanel1.add(cmbGasolinaVehiculo);
        cmbGasolinaVehiculo.setBounds(159, 235, 139, 28);

        txtVin.setText("Editar esto");
        txtVin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVinActionPerformed(evt);
            }
        });
        jPanel1.add(txtVin);
        txtVin.setBounds(159, 142, 139, 28);

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Lps.");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(868, 114, 50, 14);

        btnLimpiar7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar7.setText("Limpiar");
        btnLimpiar7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar7ActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar7);
        btnLimpiar7.setBounds(320, 285, 111, 41);

        btnDesactivar7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar7.setText("Desactivar");
        btnDesactivar7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDesactivar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar7ActionPerformed(evt);
            }
        });
        jPanel1.add(btnDesactivar7);
        btnDesactivar7.setBounds(449, 286, 161, 39);

        btnModificar7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar7.setText("Modificar");
        btnModificar7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar7ActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar7);
        btnModificar7.setBounds(181, 285, 121, 41);

        btnAgregar7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar7.setText("Agregar");
        btnAgregar7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar7ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar7);
        btnAgregar7.setBounds(48, 288, 115, 41);

        cmbIDVehiculo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDVehiculoItemStateChanged(evt);
            }
        });
        jPanel1.add(cmbIDVehiculo);
        cmbIDVehiculo.setBounds(159, 80, 91, 28);

        txtCilindraje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCilindrajeKeyPressed(evt);
            }
        });
        jPanel1.add(txtCilindraje);
        txtCilindraje.setBounds(468, 173, 139, 28);

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Stock:");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(347, 207, 117, 14);

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Stock Minimo:");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(347, 238, 117, 14);

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Stock Máximo:");
        jPanel1.add(jLabel22);
        jLabel22.setBounds(625, 83, 117, 14);

        btnSalir7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir7.setText("Salir");
        btnSalir7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir7ActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir7);
        btnSalir7.setBounds(1214, 19, 93, 41);

        btnRegresar7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar7.setText("Regresar");
        btnRegresar7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar7ActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar7);
        btnRegresar7.setBounds(1154, 571, 153, 45);

        jLabel45.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel45.setText("Vehículos");
        jPanel1.add(jLabel45);
        jLabel45.setBounds(48, 17, 114, 35);

        jPanel1.add(cmbNumAsientos);
        cmbNumAsientos.setBounds(468, 80, 139, 28);

        ftxtStock.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jPanel1.add(ftxtStock);
        ftxtStock.setBounds(468, 204, 139, 28);

        ftxtStockMinimo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jPanel1.add(ftxtStockMinimo);
        ftxtStockMinimo.setBounds(468, 235, 139, 28);

        ftxtStockMaximo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jPanel1.add(ftxtStockMaximo);
        ftxtStockMaximo.setBounds(760, 80, 104, 28);

        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioKeyPressed(evt);
            }
        });
        jPanel1.add(txtPrecio);
        txtPrecio.setBounds(760, 111, 104, 28);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Fondo.jpg"))); // NOI18N
        jLabel18.setText("jLabel18");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(0, -16, 1770, 830);

        jTabbedPane1.addTab("Vehículos", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkTipoGasolinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkTipoGasolinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkTipoGasolinaActionPerformed

    private void txtVinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVinActionPerformed

    private void cmbIDMarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDMarcaItemStateChanged
        cmbIDMarca();
    }//GEN-LAST:event_cmbIDMarcaItemStateChanged

    private void btnAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar1ActionPerformed

        
        
        if(cmbIDMarca.getSelectedIndex()!=0){
            cmbIDMarca.setSelectedIndex(0);
        }
        else{

        }
        
        if (TresletrasMarca(txtMarca.getText())){        
                        JOptionPane.showMessageDialog(null,"No se Admite en la marca la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        txtMarca.requestFocus(); 
                        return;            
        }
        else{
                        
                     }
        if("".equals(txtMarca.getText())){
            JOptionPane.showMessageDialog(null, "Ingrese la Marca");
            return;
        }
        else{
            int i;
            boolean flag=false;
            for(i=0;i<Marcadao.findMarcaEntities().size();i++){
                //System.out.println(i);
                if(txtMarca.getText().toLowerCase().equals(Marcadao.findMarca(i+1).getMarca())){
                    JOptionPane.showMessageDialog(null, "Ya existe este tipo de Marca esta registrada en el sistema");
                    flag=true;
                    return;
                } else {
                }
            }
            if(flag){
                return;
            }
            else{
                Marca m = new Marca();
                m.setEstado(true);
                m.setMarca(txtMarca.getText().toLowerCase());
                try {
                    Marcadao.create(m);
                } catch (Exception ex) {
                    Logger.getLogger(FrmCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                //cmbIDMarca.setSelectedIndex(1);
                cmbIDMarca.setSelectedIndex(0);
                createTableMarca();
                createComboBoxMarca();
                this.jTabbedPane1.setSelectedIndex(8);
                createcmbMarcaVehiculo();
                habilitarAgregarVehiculo();
                this.jTabbedPane1.setSelectedIndex(1);
               
            }
        }
    }//GEN-LAST:event_btnAgregar1ActionPerformed

    private void btnModificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar1ActionPerformed
        if(cmbIDMarca.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Tipo de Marca no encontrada");
        }
        else{
            if (TresletrasMarca(txtMarca.getText())){        
            JOptionPane.showMessageDialog(null,"No se Admite en la marca la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        txtMarca.requestFocus(); 
                        return;        
            
            }else{
                        
                     }
            if("".equals(txtMarca.getText())){
                JOptionPane.showMessageDialog(null, "Marca no puede ir vacio");
                return;
            }
            else{
                int i;
                boolean flag=false;
                for(i=0;i<Marcadao.findMarcaEntities().size();i++){
                    //System.out.println(i);
                    if(txtMarca.getText().toLowerCase().equals(Marcadao.findMarca(i+1).getMarca())){
                        JOptionPane.showMessageDialog(null, "Ya existe esta Marca registrada en el sistema");
                        flag=true;
                        return;
                    } else {
                    }
                }
                if(flag){
                    return;
                }
                else{
                    Marca m;
                    m=Marcadao.findMarca(cmbIDMarca.getSelectedIndex());
                    m.setMarca(txtMarca.getText().toLowerCase());
                    try {
                        Marcadao.edit(m);
                    } catch (Exception ex) {
                        Logger.getLogger(Marca.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   // cmbIDMarca.setSelectedIndex(1);
                    cmbIDMarca.setSelectedIndex(0);
                    createTableMarca();
                    createComboBoxMarca();
                    this.jTabbedPane1.setSelectedIndex(8);
                    createcmbMarcaVehiculo();
                    this.jTabbedPane1.setSelectedIndex(1);
                }
            }
        }
    }//GEN-LAST:event_btnModificar1ActionPerformed

    private void btnLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar1ActionPerformed
        //cmbIDMarca.setSelectedIndex(1);
        cmbIDMarca.setSelectedIndex(0);
        createTableMarca();
        createComboBoxMarca();
    }//GEN-LAST:event_btnLimpiar1ActionPerformed

    private void btnDesactivar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar1ActionPerformed
        Marca temp;
        temp = Marcadao.findMarca(cmbIDMarca.getSelectedIndex());
        if(temp.isEstado()){
            temp.setEstado(false);
        }
        else{
            temp.setEstado(true);
        }
        try {
            Marcadao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(Marca.class.getName()).log(Level.SEVERE, null, ex);
        }
        createTableMarca();
        btnActivarDesactivarMarca();
    }//GEN-LAST:event_btnDesactivar1ActionPerformed

    private void tblMarcaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMarcaMouseClicked
        int column=0;
        int fila = tblMarca.getSelectedRow();
        if (fila > -1){
            cmbIDMarca.setSelectedIndex(Integer.parseInt(tblMarca.getModel().getValueAt(fila, column).toString()));
            txtMarca.setText(String.valueOf(tblMarca.getValueAt(fila, ++column)));
            btnActivarDesactivarMarca();
        }
    }//GEN-LAST:event_tblMarcaMouseClicked

    private void tblMarcaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMarcaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblMarcaMouseEntered

    private void btnRegresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar1ActionPerformed
        FrmMenu m = new FrmMenu();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresar1ActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void cmbIDColorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDColorItemStateChanged
       if(cmbIDColor.getSelectedIndex()==0){
            txtColor.setText("");
            btnDesactivar2.setEnabled(false);

        }
        else{
            Tipo_color cc;
            cc=Colorrdao.findTipo_color(cmbIDColor.getSelectedIndex());
            txtColor.setText(cc.getTipo_color());
            btnActivarDesactivarColor();
        }
    }//GEN-LAST:event_cmbIDColorItemStateChanged

    private void btnAgregar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar2ActionPerformed

        if(cmbIDColor.getSelectedIndex()!=0){
            cmbIDColor.setSelectedIndex(0);
        }
        else{

        }
        if (TresletrasMarca(txtColor.getText())){        
                 JOptionPane.showMessageDialog(null,"No se Admite en el color la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        txtColor.requestFocus(); 
                        return;   
        }
        else{
                        
                     }
        if("".equals(txtColor.getText())){
            JOptionPane.showMessageDialog(null, "Ingrese el Color que es");
            return;
        }
        else{
            int i;
            boolean flag=false;
            for(i=0;i<Colorrdao.findTipo_colorEntities().size();i++){
                //System.out.println(i);
                if(txtColor.getText().toLowerCase().equals(Colorrdao.findTipo_color(i+1).getTipo_color())){
                    JOptionPane.showMessageDialog(null, "Ya existe este Color esta registrado en el sistema");
                    flag=true;
                    return;
                } else {
                }
            }
            if(flag){
                return;
            }
            else{
                Tipo_color cc = new Tipo_color();
                cc.setEstado(true);
                cc.setTipo_color(txtColor.getText().toLowerCase());
                try {
                    Colorrdao.create(cc);
                } catch (Exception ex) {
                    Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
                }
                //cmbIDColor.setSelectedIndex(1);
                cmbIDColor.setSelectedIndex(0);
                createTableColor();
                createComboBoxColor();
                this.jTabbedPane1.setSelectedIndex(8);
                createcmbColorVehiculo();
                habilitarAgregarVehiculo();
                this.jTabbedPane1.setSelectedIndex(2);
                
            }
        }
    }//GEN-LAST:event_btnAgregar2ActionPerformed

    private void btnModificar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar2ActionPerformed
        if(cmbIDColor.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Color no encontrado");
        }
        else{
            if (TresletrasMarca(txtColor.getText())){        
            JOptionPane.showMessageDialog(null,"No se Admite en el color la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        txtColor.requestFocus(); 
                        return;        
            
            }else{
                        
                     }
            if("".equals(txtColor.getText())){
                JOptionPane.showMessageDialog(null, "Color no puede ir vacio");
                return;
            }
            else{
                int i;
                boolean flag=false;
                for(i=0;i<Colorrdao.findTipo_colorEntities().size();i++){
                    //System.out.println(i);
                    if(txtColor.getText().toLowerCase().equals(Colorrdao.findTipo_color(i+1).getTipo_color())){
                        JOptionPane.showMessageDialog(null, "Ya existe este Color registrado en el sistema");
                        flag=true;
                        return;
                    } else {
                    }
                }
                if(flag){
                    return;
                }
                else{
                    Tipo_color cc;
                    cc=Colorrdao.findTipo_color(cmbIDColor.getSelectedIndex());
                    cc.setTipo_color(txtColor.getText().toLowerCase());
                    try {
                        Colorrdao.edit(cc);
                    } catch (Exception ex) {
                        Logger.getLogger(Color.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //cmbIDColor.setSelectedIndex(1);
                    cmbIDColor.setSelectedIndex(0);
                    createTableColor();
                    createComboBoxColor();
                    this.jTabbedPane1.setSelectedIndex(8);
                    createcmbColorVehiculo();
                    this.jTabbedPane1.setSelectedIndex(2);
                }
            }
        }
    }//GEN-LAST:event_btnModificar2ActionPerformed

    private void btnLimpiar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar2ActionPerformed
        //cmbIDColor.setSelectedIndex(1);
        cmbIDColor.setSelectedIndex(0);
        createTableColor();
        createComboBoxColor();
    }//GEN-LAST:event_btnLimpiar2ActionPerformed

    private void btnDesactivar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar2ActionPerformed
        Tipo_color temp;
        temp = Colorrdao.findTipo_color(cmbIDColor.getSelectedIndex());
        if(temp.isEstado()){
            temp.setEstado(false);
        }
        else{
            temp.setEstado(true);
        }
        try {
            Colorrdao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(Color.class.getName()).log(Level.SEVERE, null, ex);
        }
        createTableColor();
        btnActivarDesactivarColor();
    }//GEN-LAST:event_btnDesactivar2ActionPerformed

    private void tblColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblColorMouseClicked
       int column=0;
        int fila = tblColor.getSelectedRow();
        if (fila > -1){
            cmbIDColor.setSelectedIndex(Integer.parseInt(tblColor.getModel().getValueAt(fila, column).toString()));
            txtColor.setText(String.valueOf(tblColor.getValueAt(fila, ++column)));
            btnActivarDesactivarMarca();
        }
    }//GEN-LAST:event_tblColorMouseClicked

    private void tblColorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblColorMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblColorMouseEntered

    private void btnRegresar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar2ActionPerformed
        FrmMenu m = new FrmMenu();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresar2ActionPerformed

    private void btnSalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalir2ActionPerformed

    private void cmbIDTipoVehiculoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDTipoVehiculoItemStateChanged
        if(cmbIDTipoVehiculo.getSelectedIndex()==0){
            txtTipoVehiculo.setText("");
            btnDesactivar3.setEnabled(false);

        }
        else{
            TipoVehiculo tp;
            tp=TipoVehiculodao.findTipoVehiculo(cmbIDTipoVehiculo.getSelectedIndex());
            txtTipoVehiculo.setText(tp.getTipoVehiculo());
            btnActivarDesactivarTipoVehiculo();
        }
    }//GEN-LAST:event_cmbIDTipoVehiculoItemStateChanged

    private void btnAgregar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar3ActionPerformed

        if(cmbIDTipoVehiculo.getSelectedIndex()!=0){
            cmbIDTipoVehiculo.setSelectedIndex(0);
        }
        else{

        }
        if (TresletrasMarca(txtTipoVehiculo.getText())){        
            JOptionPane.showMessageDialog(null,"No se Admite en el tipo de Vehículo la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
            txtTipoVehiculo.requestFocus(); 
            return;
        
        }else{
                        
                        
                     }
        if("".equals(txtTipoVehiculo.getText())){
            JOptionPane.showMessageDialog(null, "Ingrese el tipo de  Vehículo que es");
            return;
        }
        else{
            int i;
            boolean flag=false;
            for(i=0;i<TipoVehiculodao.findTipoVehiculoEntities().size();i++){
                //System.out.println(i);
                if(txtTipoVehiculo.getText().toLowerCase().equals(TipoVehiculodao.findTipoVehiculo(i+1).getTipoVehiculo())){
                    JOptionPane.showMessageDialog(null, "Ya existe este tipo de  Vehículo registrado en el sistema");
                    flag=true;
                    return;
                } else {
                }
            }
            if(flag){
                return;
            }
            else{
                TipoVehiculo tp = new TipoVehiculo();
                tp.setEstado(true);
                tp.setTipoVehiculo(txtTipoVehiculo.getText().toLowerCase());
                try {
                    TipoVehiculodao.create(tp);
                } catch (Exception ex) {
                    Logger.getLogger(FrmCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                //cmbIDTipoVehiculo.setSelectedIndex(1);
                cmbIDTipoVehiculo.setSelectedIndex(0);
                createTableTipoVehiculo();
                createComboBoxTipoVehiculo();
                this.jTabbedPane1.setSelectedIndex(8);
                createcmbTipoVehiculoVehiculo();
                habilitarAgregarVehiculo();
                this.jTabbedPane1.setSelectedIndex(3);
                habilitarAgregarVehiculo();
            }
        }
    }//GEN-LAST:event_btnAgregar3ActionPerformed

    private void btnModificar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar3ActionPerformed
        if(cmbIDTipoVehiculo.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Tipo de  Vehículo no encontrado");
        }
        else{
            if (TresletrasMarca(txtTipoVehiculo.getText())){        
                JOptionPane.showMessageDialog(null,"No se Admite en el tipo de Vehículo la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                txtTipoVehiculo.requestFocus(); 
                return;
            }
            else{
                        
                     }
            if("".equals(txtTipoVehiculo.getText())){
                JOptionPane.showMessageDialog(null, "Tipo de  Vehículo no puede ir vacio");
                return;
            }
            else{
                int i;
                boolean flag=false;
                for(i=0;i<TipoVehiculodao.findTipoVehiculoEntities().size();i++){
                    //System.out.println(i);
                    if(txtMarca.getText().toLowerCase().equals(TipoVehiculodao.findTipoVehiculo(i+1).getTipoVehiculo())){
                        JOptionPane.showMessageDialog(null, "Ya existe este tipo de Vehículo esta registrado en el sistema");
                        flag=true;
                        return;
                    } else {
                    }
                }
                if(flag){
                    return;
                }
                else{
                    TipoVehiculo tp;
                    tp=TipoVehiculodao.findTipoVehiculo(cmbIDTipoVehiculo.getSelectedIndex());
                    tp.setTipoVehiculo(txtTipoVehiculo.getText().toLowerCase());
                    try {
                        TipoVehiculodao.edit(tp);
                    } catch (Exception ex) {
                        Logger.getLogger(TipoVehiculo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //cmbIDTipoVehiculo.setSelectedIndex(1);
                    cmbIDTipoVehiculo.setSelectedIndex(0);
                    createTableTipoVehiculo();
                    createComboBoxTipoVehiculo();
                    this.jTabbedPane1.setSelectedIndex(8);
                    createcmbTipoVehiculoVehiculo();
                    this.jTabbedPane1.setSelectedIndex(3);
                }
            }
        }
    }//GEN-LAST:event_btnModificar3ActionPerformed

    private void btnLimpiar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar3ActionPerformed
        //cmbIDTipoVehiculo.setSelectedIndex(1);
        cmbIDTipoVehiculo.setSelectedIndex(0);
        createTableTipoVehiculo();
        createComboBoxTipoVehiculo();
    }//GEN-LAST:event_btnLimpiar3ActionPerformed

    private void btnDesactivar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar3ActionPerformed
        TipoVehiculo temp;
        temp = TipoVehiculodao.findTipoVehiculo(cmbIDTipoVehiculo.getSelectedIndex());
        if(temp.isEstado()){
            temp.setEstado(false);
        }
        else{
            temp.setEstado(true);
        }
        try {
            TipoVehiculodao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(TipoVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        createTableTipoVehiculo();
        btnActivarDesactivarTipoVehiculo();
    }//GEN-LAST:event_btnDesactivar3ActionPerformed

    private void tblTipoVehiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTipoVehiculoMouseClicked
        int column=0;
        int fila = tblTipoVehiculo.getSelectedRow();
        if (fila > -1){
            cmbIDTipoVehiculo.setSelectedIndex(Integer.parseInt(tblTipoVehiculo.getModel().getValueAt(fila, column).toString()));
            txtTipoVehiculo.setText(String.valueOf(tblTipoVehiculo.getValueAt(fila, ++column)));
            btnActivarDesactivarTipoCabina();
        }
    }//GEN-LAST:event_tblTipoVehiculoMouseClicked

    private void tblTipoVehiculoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTipoVehiculoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblTipoVehiculoMouseEntered

    private void btnRegresar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar3ActionPerformed
        FrmMenu m = new FrmMenu();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresar3ActionPerformed

    private void btnSalir3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalir3ActionPerformed

    private void btnAgregar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar4ActionPerformed

        if(cmbPiezaClave.getSelectedIndex()!=0){
            cmbPiezaClave.setSelectedIndex(0);
        }
        else{

        }
        if (TresletrasMarca(txtTipoCabina.getText())){        
            JOptionPane.showMessageDialog(null,"No se Admite en el Tipo de Cabina la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        txtTipoCabina.requestFocus(); 
                        return;
        }
        else{
                        
                     }
        if("".equals(txtTipoCabina.getText())){
            JOptionPane.showMessageDialog(null, "Ingrese el tipo de Cabina que es");
            return;
        }
        else{
            int i;
            boolean flag=false;
            for(i=0;i<TipoCabinadao.findTipoCabinaEntities().size();i++){
                //System.out.println(i);
                if(txtTipoCabina.getText().toLowerCase().equals(TipoCabinadao.findTipoCabina(i+1).getTipoCabina())){
                    JOptionPane.showMessageDialog(null, "Ya existe este tipo de Cabina registrada en el sistema");
                    flag=true;
                    return;
                } else {
                }
            }
            if(flag){
                return;
            }
            else{
                TipoCabina tp = new TipoCabina();
                tp.setEstado(true);
                tp.setTipoCabina(txtTipoCabina.getText().toLowerCase());
                try {
                    TipoCabinadao.create(tp);
                } catch (Exception ex) {
                    Logger.getLogger(FrmCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                //cmbIDTipoCabina.setSelectedIndex(1);
                cmbPiezaClave.setSelectedIndex(0);
                createTableTipoCabina();
                createComboBoxTipoCabina();
                this.jTabbedPane1.setSelectedIndex(8);
                createcmbTipoCabinaVehiculo();
                habilitarAgregarVehiculo();
                this.jTabbedPane1.setSelectedIndex(4);
                
            }
        }
    }//GEN-LAST:event_btnAgregar4ActionPerformed

    private void btnModificar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar4ActionPerformed
        if(cmbPiezaClave.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Tipo de Cabina no encontrada");
        }
        else{
            if (TresletrasMarca(txtTipoCabina.getText())){        
                JOptionPane.showMessageDialog(null,"No se Admite en el Tipo de Cabina la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                txtTipoCabina.requestFocus(); 
                return;
            
            }
            else{
                        
                     }
            if("".equals(txtTipoCabina.getText())){
                JOptionPane.showMessageDialog(null, "Tipo de cabina no puede ir vacia");
                return;
            }
            else{
                int i;
                boolean flag=false;
                for(i=0;i<TipoCabinadao.findTipoCabinaEntities().size();i++){
                    //System.out.println(i);
                    if(txtTipoCabina.getText().toLowerCase().equals(TipoCabinadao.findTipoCabina(i+1).getTipoCabina())){
                        JOptionPane.showMessageDialog(null, "Ya existe este tipo de Cabina ya esta registrado en el sistema");
                        flag=true;
                        return;
                    } else {
                    }
                }
                if(flag){
                    return;
                }
                else{
                    TipoCabina tp;
                    tp=TipoCabinadao.findTipoCabina(cmbPiezaClave.getSelectedIndex());
                    tp.setTipoCabina(txtTipoCabina.getText().toLowerCase());
                    try {
                        TipoCabinadao.edit(tp);
                    } catch (Exception ex) {
                        Logger.getLogger(TipoCabina.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   // cmbIDTipoCabina.setSelectedIndex(1);
                    cmbPiezaClave.setSelectedIndex(0);
                    createTableTipoCabina();
                    createComboBoxTipoCabina();
                    this.jTabbedPane1.setSelectedIndex(8);
                    createcmbTipoCabinaVehiculo();
                    this.jTabbedPane1.setSelectedIndex(4);
                }
            }
        }
    }//GEN-LAST:event_btnModificar4ActionPerformed

    private void btnLimpiar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar4ActionPerformed
       // cmbIDTipoCabina.setSelectedIndex(1);
        cmbPiezaClave.setSelectedIndex(0);
        createTableTipoCabina();
        createComboBoxTipoCabina();
    }//GEN-LAST:event_btnLimpiar4ActionPerformed

    private void btnDesactivar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar4ActionPerformed
        TipoCabina temp;
        temp = TipoCabinadao.findTipoCabina(cmbPiezaClave.getSelectedIndex());
        if(temp.isEstado()){
            temp.setEstado(false);
        }
        else{
            temp.setEstado(true);
        }
        try {
            TipoCabinadao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(TipoCabina.class.getName()).log(Level.SEVERE, null, ex);
        }
        createTableTipoCabina();
        btnActivarDesactivarTipoCabina();
    }//GEN-LAST:event_btnDesactivar4ActionPerformed

    private void tblTipoCabinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTipoCabinaMouseClicked
        int column=0;
        int fila = tblTipoCabina.getSelectedRow();
        if (fila > -1){
            cmbPiezaClave.setSelectedIndex(Integer.parseInt(tblTipoCabina.getModel().getValueAt(fila, column).toString()));
            txtTipoCabina.setText(String.valueOf(tblTipoCabina.getValueAt(fila, ++column)));
            btnActivarDesactivarTipoCabina();
        }
    }//GEN-LAST:event_tblTipoCabinaMouseClicked

    private void tblTipoCabinaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTipoCabinaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblTipoCabinaMouseEntered

    private void btnRegresar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar4ActionPerformed
        FrmMenu m = new FrmMenu();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresar4ActionPerformed

    private void btnSalir4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalir4ActionPerformed

    private void cmbIDTipoGasolinaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDTipoGasolinaItemStateChanged
        if(cmbIDTipoGasolina.getSelectedIndex()==0){
            txtTipoGasolina.setText("");
            btnDesactivar5.setEnabled(false);

        }
        else{
            TipoGasolina tp;
            tp=TipoGasolinadao.findTipoGasolina(cmbIDTipoGasolina.getSelectedIndex());
            txtTipoGasolina.setText(tp.getTipoGasolina());
            btnActivarDesactivarTipoGasolina();
        }
    }//GEN-LAST:event_cmbIDTipoGasolinaItemStateChanged

    private void btnAgregar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar5ActionPerformed

        if(cmbIDTipoGasolina.getSelectedIndex()!=0){
            cmbIDTipoGasolina.setSelectedIndex(0);
        }
        else{

        }
        if (TresletrasMarca(txtTipoGasolina.getText())){        
            JOptionPane.showMessageDialog(null,"No se Admite en el Tipo de Gasolina la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
            txtTipoGasolina.requestFocus(); 
            return;
        
        }else{
                        
                     }
        if("".equals(txtTipoGasolina.getText())){
            JOptionPane.showMessageDialog(null, "Ingrese el tipo de Gasolina que es");
            return;
        }
        else{
            int i;
            boolean flag=false;
            for(i=0;i<TipoGasolinadao.findTipoGasolinaEntities().size();i++){
                //System.out.println(i);
                if(txtTipoGasolina.getText().toLowerCase().equals(TipoGasolinadao.findTipoGasolina(i+1).getTipoGasolina())){
                    JOptionPane.showMessageDialog(null, "Ya existe este tipo de Gasolina registrada en el sistema");
                    flag=true;
                    return;
                } else {
                }
            }
            if(flag){
                return;
            }
            else{
                TipoGasolina tp = new TipoGasolina();
                tp.setEstado(true);
                tp.setTipoGasolina(txtTipoGasolina.getText().toLowerCase());
                try {
                    TipoGasolinadao.create(tp);
                } catch (Exception ex) {
                    Logger.getLogger(FrmCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                //cmbIDTipoGasolina.setSelectedIndex(1);
                cmbIDTipoGasolina.setSelectedIndex(0);
                createTableTipoGasolina();
                createComboBoxTipoGasolina();
                this.jTabbedPane1.setSelectedIndex(8);
                createcmbTipoGasolinaVehiculo();
                habilitarAgregarVehiculo();
                this.jTabbedPane1.setSelectedIndex(5);
                
                
            }
        }
    }//GEN-LAST:event_btnAgregar5ActionPerformed

    private void btnModificar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar5ActionPerformed
        if(cmbIDTipoGasolina.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Tipo de Gasolina no encontrado");
        }
        else{
            if (TresletrasMarca(txtTipoGasolina.getText())){        
                JOptionPane.showMessageDialog(null,"No se Admite en el Tipo de Gasolina la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                txtTipoGasolina.requestFocus(); 
                return;        
            }else{
                        
                     }
            if("".equals(txtTipoGasolina.getText())){
                JOptionPane.showMessageDialog(null, "Tipo de Gasolina no puede ir vacio");
                return;
            }
            else{
                int i;
                boolean flag=false;
                for(i=0;i<TipoGasolinadao.findTipoGasolinaEntities().size();i++){
                    //System.out.println(i);
                    if(txtMarca.getText().toLowerCase().equals(TipoGasolinadao.findTipoGasolina(i+1).getTipoGasolina())){
                        JOptionPane.showMessageDialog(null, "Ya existe este tipo de Gasolina registrado en el sistema");
                        flag=true;
                        return;
                    } else {
                    }
                }
                if(flag){
                    return;
                }
                else{
                    TipoGasolina tp;
                    tp=TipoGasolinadao.findTipoGasolina(cmbIDTipoGasolina.getSelectedIndex());
                    tp.setTipoGasolina(txtTipoGasolina.getText().toLowerCase());
                    try {
                        TipoGasolinadao.edit(tp);
                    } catch (Exception ex) {
                        Logger.getLogger(TipoGasolina.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //cmbIDTipoGasolina.setSelectedIndex(1);
                    cmbIDTipoGasolina.setSelectedIndex(0);
                    createTableTipoGasolina();
                    createComboBoxTipoGasolina();
                    this.jTabbedPane1.setSelectedIndex(8);
                    createcmbTipoGasolinaVehiculo();
                    this.jTabbedPane1.setSelectedIndex(5);
                }
            }
        }
    }//GEN-LAST:event_btnModificar5ActionPerformed

    private void btnLimpiar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar5ActionPerformed
        //cmbIDTipoGasolina.setSelectedIndex(1);
        cmbIDTipoGasolina.setSelectedIndex(0);
        createTableTipoGasolina();
        createComboBoxTipoGasolina();
    }//GEN-LAST:event_btnLimpiar5ActionPerformed

    private void btnDesactivar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar5ActionPerformed
        TipoGasolina temp;
        temp = TipoGasolinadao.findTipoGasolina(cmbIDTipoGasolina.getSelectedIndex());
        if(temp.isEstado()){
            temp.setEstado(false);
        }
        else{
            temp.setEstado(true);
        }
        try {
            TipoGasolinadao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(TipoGasolina.class.getName()).log(Level.SEVERE, null, ex);
        }
        createTableTipoGasolina();
        btnActivarDesactivarTipoGasolina();
    }//GEN-LAST:event_btnDesactivar5ActionPerformed

    private void tblTipoGasolinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTipoGasolinaMouseClicked
        int column=0;
        int fila = tblTipoGasolina.getSelectedRow();
        if (fila > -1){
            cmbIDTipoGasolina.setSelectedIndex(Integer.parseInt(tblTipoGasolina.getModel().getValueAt(fila, column).toString()));
            txtTipoGasolina.setText(String.valueOf(tblTipoGasolina.getValueAt(fila, ++column)));
            btnActivarDesactivarTipoGasolina();
        }
    }//GEN-LAST:event_tblTipoGasolinaMouseClicked

    private void tblTipoGasolinaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTipoGasolinaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblTipoGasolinaMouseEntered

    private void btnRegresar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar5ActionPerformed
        FrmMenu m = new FrmMenu();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresar5ActionPerformed

    private void btnSalir5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir5ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalir5ActionPerformed

    private void cmbIDTipoTransmisionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDTipoTransmisionItemStateChanged
        if(cmbIDTipoTransmision.getSelectedIndex()==0){
            txtTipoTransmision.setText("");
            btnDesactivar6.setEnabled(false);

        }
        else{
            transmision tp;
            tp=TipoTransmisiondao.findtransmision(cmbIDTipoTransmision.getSelectedIndex());
            txtTipoTransmision.setText(tp.getTransmision());
            btnActivarDesactivarTipoTransmision();
        }
    }//GEN-LAST:event_cmbIDTipoTransmisionItemStateChanged

    private void btnAgregar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar6ActionPerformed

        if(cmbIDTipoTransmision.getSelectedIndex()!=0){
            cmbIDTipoTransmision.setSelectedIndex(0);
        }
        else{

        }
        if (TresletrasMarca(txtTipoTransmision.getText())){        
            JOptionPane.showMessageDialog(null,"No se Admite en el Tipo de Transmisión la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
            txtTipoTransmision.requestFocus(); 
            return;
        }else{
                        
                     }
        if("".equals(txtTipoTransmision.getText())){
            JOptionPane.showMessageDialog(null, "Ingrese el tipo de Transmisión que es");
            return;
        }
        else{
            int i;
            boolean flag=false;
            for(i=0;i<TipoTransmisiondao.findtransmisionEntities().size();i++){
                //System.out.println(i);
                if(txtMarca.getText().toLowerCase().equals(TipoTransmisiondao.findtransmision(i+1).getTransmision())){
                    JOptionPane.showMessageDialog(null, "Ya existe este tipo de Transmisión esta registrada en el sistema");
                    flag=true;
                    return;
                } 
                else {
                }
            }
            if(flag){
                return;
            }
            else{
                transmision tp = new transmision();
                tp.setEstado(true);
                tp.setTransmision(txtTipoTransmision.getText().toLowerCase());
                try {
                    TipoTransmisiondao.create(tp);
                } catch (Exception ex) {
                    Logger.getLogger(FrmCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
               // cmbIDTipoTransmision.setSelectedIndex(1);
                cmbIDTipoTransmision.setSelectedIndex(0);
                createTableTipoTransmision();
                createComboBoxTipoTransmision();
                this.jTabbedPane1.setSelectedIndex(8);
                createcmbTipoTransmisionVehiculo();
                habilitarAgregarVehiculo();
                this.jTabbedPane1.setSelectedIndex(7);
            }
        }
    }//GEN-LAST:event_btnAgregar6ActionPerformed

    private void btnModificar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar6ActionPerformed
        if(cmbIDTipoTransmision.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Tipo de Transmisión no encontrado");
        }
        else{
            if (TresletrasMarca(txtTipoTransmision.getText())){        
                JOptionPane.showMessageDialog(null,"No se Admite en el Tipo de Transmisión la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                txtTipoTransmision.requestFocus(); 
                return;
            }else
            {
                        
                     }
            if("".equals(txtTipoTransmision.getText().length()>2)){
                JOptionPane.showMessageDialog(null, "Tipo de Transmisión no puede ir vacio");
                return;
            }
            else{
                int i;
                boolean flag=false;
                for(i=0;i<TipoTransmisiondao.findtransmisionEntities().size();i++){
                    //System.out.println(i);
                    if(txtTipoTransmision.getText().toLowerCase().equals(TipoTransmisiondao.findtransmision(i+1).getTransmision())){
                        JOptionPane.showMessageDialog(null, "Ya existe este tipo de Transmisión esta registrado en el sistema");
                        flag=true;
                        return;
                    } else {
                    }
                }
                if(flag){
                    return;
                }
                else{
                    transmision tp;
                    tp=TipoTransmisiondao.findtransmision(cmbIDTipoTransmision.getSelectedIndex());
                    tp.setTransmision(txtTipoTransmision.getText().toLowerCase());
                    try {
                        TipoTransmisiondao.edit(tp);
                    } catch (Exception ex) {
                        Logger.getLogger(transmision.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //cmbIDTipoTransmision.setSelectedIndex(1);
                    cmbIDTipoTransmision.setSelectedIndex(0);
                    createTableTipoTransmision();
                    createComboBoxTipoTransmision();
                    this.jTabbedPane1.setSelectedIndex(8);
                    createcmbTipoTransmisionVehiculo();
                    this.jTabbedPane1.setSelectedIndex(7);
                }
            }
        }
    }//GEN-LAST:event_btnModificar6ActionPerformed

    private void btnLimpiar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar6ActionPerformed
        //cmbIDTipoTransmision.setSelectedIndex(1);
        cmbIDTipoTransmision.setSelectedIndex(0);
        createTableTipoTransmision();
        createComboBoxTipoTransmision();
    }//GEN-LAST:event_btnLimpiar6ActionPerformed

    private void btnDesactivar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar6ActionPerformed
        transmision temp;
        temp = TipoTransmisiondao.findtransmision(cmbIDTipoTransmision.getSelectedIndex());
        if(temp.isEstado()){
            temp.setEstado(false);
        }
        else{
            temp.setEstado(true);
        }
        try {
            TipoTransmisiondao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(transmision.class.getName()).log(Level.SEVERE, null, ex);
        }
        createTableTipoTransmision();
        btnActivarDesactivarTipoTransmision();
    }//GEN-LAST:event_btnDesactivar6ActionPerformed

    private void tblTipoTransmisionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTipoTransmisionMouseClicked
        int column=0;
        int fila = tblTipoTransmision.getSelectedRow();
        if (fila > -1){
            cmbIDTipoTransmision.setSelectedIndex(Integer.parseInt(tblTipoTransmision.getModel().getValueAt(fila, column).toString()));
            txtTipoTransmision.setText(String.valueOf(tblTipoTransmision.getValueAt(fila, ++column)));
            btnActivarDesactivarMarca();
        }

    }//GEN-LAST:event_tblTipoTransmisionMouseClicked

    private void tblTipoTransmisionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTipoTransmisionMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblTipoTransmisionMouseEntered

    private void btnRegresar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar6ActionPerformed
        FrmMenu m = new FrmMenu();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresar6ActionPerformed

    private void btnSalir6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir6ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalir6ActionPerformed

    private void btnLimpiar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar7ActionPerformed

        
        limpiar();
        btnModificar7.setEnabled(false);
        btnAgregar7.setEnabled(true);
        
    }//GEN-LAST:event_btnLimpiar7ActionPerformed

    private void btnDesactivar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar7ActionPerformed
     
    }//GEN-LAST:event_btnDesactivar7ActionPerformed

    private void btnModificar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar7ActionPerformed
   
        Pattern pat = Pattern.compile("[A-z]{1,15}");
        Matcher mat = pat.matcher(txtVin.getText());
        //Validacion de VIN Cambiar por validacion de modelo y cambiar la base de datos
        if(!mat.matches()){
            JOptionPane.showMessageDialog(null, "Modelo solo puede contener letras","MODELO INVALIDO",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            
        }
        if(txtVin.getText().length()>15){
            JOptionPane.showMessageDialog(null,"Modelo solo puede contener hasta 15 letras","CAMPO DEMASIADO LARGO",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            
        }
        
        
        
        //Fin validacion de VIN
        
        if(cmbMarcaVehiculo.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"Seleccione una marca","CAMPO SIN SELECCIONAR",JOptionPane.ERROR_MESSAGE);
            return;
            
        }
        else{
            
        }
        if(cmbColorVehiculo.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"Seleccione una Color","CAMPO SIN SELECCIONAR",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            
        }
        if(cmbCabinaVehiculo.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"Seleccione un tipo de cabina","CAMPO SIN SELECCIONAR",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            
        }
        if(cmbGasolinaVehiculo.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"Seleccione un tipo de Gasolina","CAMPO SIN SELECCIONAR",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            
        }
        if(cmbTipoVehiculoVehiculo.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"Seleccione el Tipo de Vehiculo","CAMPO SIN SELECCIONAR",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            
        }
        if(cmbTransmisionVehiculo.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"Seleccione el tipo de Transmision","CAMPO SIN SELECCIONAR",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            
        }
        if(cmbNumAsientos.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"Seleccione el número de asientos","CAMPO SIN SELECCIONAR",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            
        }
        
        //Validacion de cilindraje
        if("".equals(txtCilindraje.getText())){
            JOptionPane.showMessageDialog(null, "Por favor, ingresar un cilindraje","CAMPO VACIO",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            
        }  
        if(Double.parseDouble(txtCilindraje.getText())<0 || Double.parseDouble(txtCilindraje.getText())>18 ){
            JOptionPane.showMessageDialog(null, "Cilindraje ingresado no valido\nSugrencias:\n-2\n-3\n-4","Cilindraje Invalido",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            
        }
        //Fin validacion de cilindraje
        //Validacion de stock
        if("".equals(ftxtStock.getText())){
               JOptionPane.showMessageDialog(null, "Por favor ingrese la cantidad actual del vehiculo","",0);
                return;
            }
           else{
               
           }
           if("".equals(ftxtStockMaximo.getText())){
               JOptionPane.showMessageDialog(null,"Por favor ingrese la cantidad maxima que puede haber de este Vehiculo","",0);
               return;
           }
           else{
               
           }
           if("".equals(ftxtStockMinimo.getText())){
               JOptionPane.showMessageDialog(null,"Por favor ingrese la cantidad minima que puede haber de esta Vehiculo","",0);
               return;
           }
           else{
               
           }
           if(Integer.parseInt(ftxtStockMinimo.getText()) >= Integer.parseInt(ftxtStockMaximo.getText())){
               JOptionPane.showMessageDialog(null, "El stock minimo no puede ser igual o mayor al stock maximo","",0);
               return;
           }
           else{
            }
           if(Double.parseDouble(ftxtStock.getText())>Integer.parseInt(ftxtStockMaximo.getText())){
               JOptionPane.showMessageDialog(null, "El stock no puede ser mayor al stock maximo","",0);
               return;
           }
           if(Double.parseDouble(ftxtStock.getText())<Integer.parseInt(ftxtStockMinimo.getText())){
               JOptionPane.showMessageDialog(null, "El stock no puede ser menor al stock minimo","",0);
               return;
           }
           Vehiculo temp = new Vehiculo();
           temp.setEstado(true);
           temp.setId_marca(cmbMarcaVehiculo.getSelectedIndex());
           temp.setId_numero_asientos(cmbNumAsientos.getSelectedIndex());
           temp.setId_tipo_cabina(cmbCabinaVehiculo.getSelectedIndex());
           temp.setId_tipo_color(cmbColorVehiculo.getSelectedIndex());
           temp.setId_tipo_gasolina(cmbGasolinaVehiculo.getSelectedIndex());
           temp.setId_tipo_vehiculo(cmbTipoVehiculoVehiculo.getSelectedIndex());
           temp.setId_transmision(cmbTransmisionVehiculo.getSelectedIndex());
           temp.setStock(Integer.parseInt(ftxtStock.getText()));
           temp.setStock_maximo(Integer.parseInt(ftxtStockMaximo.getText()));
           temp.setStock_minimo(Integer.parseInt(ftxtStockMinimo.getText()));
           temp.setId_vehiculo(cmbIDVehiculo.getSelectedIndex());
           
           
           
           temp.setTotal_cilindraje(Double.parseDouble(txtCilindraje.getText()));
           temp.setVin(txtVin.getText());
           
        try {
            vehiculoDao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
           
       
        
        HistoricoPrecioVehiculos temp2 = new HistoricoPrecioVehiculos();   
        List<HistoricoPrecioVehiculos> t1 = historicoPrecioVehiculoDao.findHistoricoPrecioVehiculosEntities();
        
        for(HistoricoPrecioVehiculos e : t1){
            if(e.getId_vehiculo()==cmbIDVehiculo.getSelectedIndex() && e.getFechaFinal()==null){
                temp2 = e;
            }
        }
        
        
        
        if(temp2.getPrecio()!=Double.parseDouble(txtPrecio.getText())){
        temp2.setEstado(true);
        Calendar fecha = new GregorianCalendar();
        String fecha1;
        String aux1,aux2,aux3;
        aux1 = Integer.toString(fecha.get(Calendar.YEAR));
        if(fecha.get(Calendar.DAY_OF_MONTH)==1){
            aux2=(fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH))) : Integer.toString(fecha.get(Calendar.MONTH));
            aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)-1) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)-1);
        }
        else{
        aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH)+1);
        aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)-1) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)-1);
        }
        fecha1 = aux1+aux2+aux3;
        temp2.setFechaFinal(fecha1);
        double aux=Float.parseFloat(txtPrecio.getText().trim());
        //temp2.setPrecio(aux);
       // temp2.setId_vehiculo(cmbIDVehiculo.getSelectedIndex());
        
        
            try {
                historicoPrecioVehiculoDao.edit(temp2);
            } catch (Exception ex) {
                Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            aux1 = Integer.toString(fecha.get(Calendar.YEAR));
            aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH)+1);
            aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
            fecha1 = aux1+aux2+aux3;
            
           HistoricoPrecioVehiculos temp3 = new HistoricoPrecioVehiculos();
           temp3.setId_vehiculo(cmbIDVehiculo.getSelectedIndex());
           temp3.setFechaInicial(fecha1);
           temp3.setEstado(true);
           temp3.setPrecio(aux);
           
           historicoPrecioVehiculoDao.create(temp3);
            
            
        }
        createTableVehiculosAgregar();
        createcmbIDVehiculo();
        limpiar();
        btnModificar7.setEnabled(false);
        btnAgregar7.setEnabled(true);
        
    }//GEN-LAST:event_btnModificar7ActionPerformed

    private void btnAgregar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar7ActionPerformed
        Pattern pat = Pattern.compile("[A-z]{1,15}");
        Matcher mat = pat.matcher(txtVin.getText());
        //Validacion de VIN Cambiar por validacion de modelo y cambiar la base de datos
        if(!mat.matches()){
            JOptionPane.showMessageDialog(null, "Modelo solo puede contener letras","MODELO INVALIDO",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            
        }
        if(txtVin.getText().length()>15){
            JOptionPane.showMessageDialog(null,"Modelo solo puede contener hasta 15 letras","CAMPO DEMASIADO LARGO",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            
        }
        if(txtVin.getText().length()<3){
            JOptionPane.showMessageDialog(null,"Modelo no puede contener menos de 3 letras","CAMPO DEMASIADO CORTO",JOptionPane.ERROR_MESSAGE);
            return;
            
        }
        
        
        //Fin validacion de VIN
        
        if(cmbMarcaVehiculo.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"Seleccione una marca","CAMPO SIN SELECCIONAR",JOptionPane.ERROR_MESSAGE);
            return;
            
        }
        else{
            
        }
        if(cmbColorVehiculo.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"Seleccione una Color","CAMPO SIN SELECCIONAR",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            
        }
        if(cmbCabinaVehiculo.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"Seleccione un tipo de cabina","CAMPO SIN SELECCIONAR",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            
        }
        if(cmbGasolinaVehiculo.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"Seleccione un tipo de Gasolina","CAMPO SIN SELECCIONAR",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            
        }
        if(cmbTipoVehiculoVehiculo.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"Seleccione el Tipo de Vehiculo","CAMPO SIN SELECCIONAR",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            
        }
        if(cmbTransmisionVehiculo.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"Seleccione el tipo de Transmision","CAMPO SIN SELECCIONAR",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            
        }
        if(cmbNumAsientos.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"Seleccione el número de asientos","CAMPO SIN SELECCIONAR",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            
        }
        
        
        //Validacion de cilindraje
        if("".equals(txtCilindraje.getText())){
            JOptionPane.showMessageDialog(null, "Por favor, ingresar un cilindraje","CAMPO VACIO",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            
        }    
        if(Integer.parseInt(txtCilindraje.getText())<0 || Integer.parseInt(txtCilindraje.getText())>18 ){
            JOptionPane.showMessageDialog(null, "Cilindraje ingresado no valido\nSugrencias:\n-2\n-3\n-4","Cilindraje Invalido",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            
        }
        //Fin validacion de cilindraje
        //Validacion de stock
        if("".equals(ftxtStock.getText())){
               JOptionPane.showMessageDialog(null, "Por favor ingrese la cantidad actual del vehiculo","",0);
                return;
            }
           else{
               
           }
           if("".equals(ftxtStockMaximo.getText())){
               JOptionPane.showMessageDialog(null,"Por favor ingrese la cantidad maxima que puede haber de este Vehiculo","",0);
               return;
           }
           else{
               
           }
           if("".equals(ftxtStockMinimo.getText())){
               JOptionPane.showMessageDialog(null,"Por favor ingrese la cantidad minima que puede haber de esta Vehiculo","",0);
               return;
           }
           else{
               
           }
           if(Integer.parseInt(ftxtStockMinimo.getText()) >= Integer.parseInt(ftxtStockMaximo.getText())){
               JOptionPane.showMessageDialog(null, "El stock minimo no puede ser igual o mayor al stock maximo","",0);
               return;
           }
           else{
            }
           if(Double.parseDouble(ftxtStock.getText())>Integer.parseInt(ftxtStockMaximo.getText())){
               JOptionPane.showMessageDialog(null, "El stock no puede ser mayor al stock maximo","",0);
               return;
           }
           if(Double.parseDouble(ftxtStock.getText())<Integer.parseInt(ftxtStockMinimo.getText())){
               JOptionPane.showMessageDialog(null, "El stock no puede ser menor al stock minimo","",0);
               return;
           }
           Vehiculo temp = new Vehiculo();
           temp.setEstado(true);
           temp.setId_marca(cmbMarcaVehiculo.getSelectedIndex());
           temp.setId_numero_asientos(cmbNumAsientos.getSelectedIndex());
           temp.setId_tipo_cabina(cmbCabinaVehiculo.getSelectedIndex());
           temp.setId_tipo_color(cmbColorVehiculo.getSelectedIndex());
           temp.setId_tipo_gasolina(cmbGasolinaVehiculo.getSelectedIndex());
           temp.setId_tipo_vehiculo(cmbTipoVehiculoVehiculo.getSelectedIndex());
           temp.setId_transmision(cmbTransmisionVehiculo.getSelectedIndex());
           temp.setStock(Integer.parseInt(ftxtStock.getText()));
           temp.setStock_maximo(Integer.parseInt(ftxtStockMaximo.getText()));
           temp.setStock_minimo(Integer.parseInt(ftxtStockMinimo.getText()));
           
           
           
           temp.setTotal_cilindraje(Double.parseDouble(txtCilindraje.getText()));
           temp.setVin(txtVin.getText());
           
        try {
            vehiculoDao.create(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        HistoricoPrecioVehiculos temp2 = new HistoricoPrecioVehiculos();   
        
        temp2.setEstado(true);
        Calendar fecha = new GregorianCalendar();
        String fecha1;
        String aux1,aux2,aux3;
        aux1 = Integer.toString(fecha.get(Calendar.YEAR));
        aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
        aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
        fecha1 = aux1+aux2+aux3;
        temp2.setFechaInicial(fecha1);
        double aux=Float.parseFloat(txtPrecio.getText().trim());
        temp2.setPrecio(aux);
        temp2.setId_vehiculo(vehiculoDao.getVehiculoCount());
        
        
        historicoPrecioVehiculoDao.create(temp2);
        
        createTableVehiculosAgregar();
        createcmbIDVehiculo();
        limpiar();
        
        
        
        
    }//GEN-LAST:event_btnAgregar7ActionPerformed

    private void limpiar(){
        txtVin.setText("");
        txtCilindraje.setText("");
        ftxtStock.setText("");
        ftxtStockMaximo.setText("");
        ftxtStockMinimo.setText("");
        txtPrecio.setText("");
        cmbColorVehiculo.setSelectedIndex(0);
        cmbTransmisionVehiculo.setSelectedIndex(0);
        cmbTipoVehiculoVehiculo.setSelectedIndex(0);
        cmbGasolinaVehiculo.setSelectedIndex(0);
        cmbCabinaVehiculo.setSelectedIndex(0);
        cmbNumAsientos.setSelectedIndex(0);
        cmbMarcaVehiculo.setSelectedIndex(0);
    }
    
    private void cmbIDVehiculoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDVehiculoItemStateChanged
        if(cmbIDVehiculo.getSelectedIndex()==0){
            limpiar();
            btnModificar7.setEnabled(false);
            btnAgregar7.setEnabled(true);
        }
        else{
            Vehiculo temp = new Vehiculo();
            temp = vehiculoDao.findVehiculo(cmbIDVehiculo.getSelectedIndex());
            cmbMarcaVehiculo.setSelectedIndex(temp.getId_marca());
            cmbColorVehiculo.setSelectedIndex(temp.getId_tipo_color());
            cmbTipoVehiculoVehiculo.setSelectedIndex(temp.getId_tipo_vehiculo());
            cmbGasolinaVehiculo.setSelectedIndex(temp.getId_tipo_gasolina());
            cmbNumAsientos.setSelectedIndex(temp.getId_numero_asientos());
            cmbCabinaVehiculo.setSelectedIndex(temp.getId_tipo_cabina());
            cmbTransmisionVehiculo.setSelectedIndex(temp.getId_transmision());
            txtCilindraje.setText(String.valueOf(temp.getTotal_cilindraje()));
            ftxtStock.setText(String.valueOf(temp.getStock()));
            ftxtStockMaximo.setText(String.valueOf(temp.getStock_maximo()));
            ftxtStockMinimo.setText(String.valueOf(temp.getStock_minimo()));
            txtVin.setText(temp.getVin());
            
            List<HistoricoPrecioVehiculos> temp2 = historicoPrecioVehiculoDao.findHistoricoPrecioVehiculosEntities();
            for(HistoricoPrecioVehiculos e : temp2)
            {
                if(e.getId_vehiculo()==cmbIDVehiculo.getSelectedIndex() && e.getFechaFinal()==null){
                    txtPrecio.setText(String.valueOf(e.getPrecio()));
                }
            }
            
            
            btnModificar7.setEnabled(true);
            btnAgregar7.setEnabled(false);
            
            
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIDVehiculoItemStateChanged

    private void btnSalir7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir7ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalir7ActionPerformed

    private void btnRegresar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar7ActionPerformed
        FrmMenu m = new FrmMenu();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresar7ActionPerformed

    private void btnRegresar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar8ActionPerformed
        FrmMenu m = new FrmMenu();
        m.setVisible(true);
        this.setVisible(false);        

        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresar8ActionPerformed

    private void btnSalir8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir8ActionPerformed
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalir8ActionPerformed

    private void cmbIDNumeroAsientosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDNumeroAsientosItemStateChanged
        if(cmbIDNumeroAsientos.getSelectedIndex()==0){
            txtNumeroAsientos.setText("");
            btnDesactivar8.setEnabled(false);

        }
        else{
            Numero_Asientos tp;
            tp=NumeroAsientosdao.findNumero_Asientos(cmbIDNumeroAsientos.getSelectedIndex());
            txtNumeroAsientos.setText(tp.getNumero_Asientos());
            btnActivarDesactivarNumeroAsientos();
        }
    }//GEN-LAST:event_cmbIDNumeroAsientosItemStateChanged

    private void btnAgregar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar8ActionPerformed
       
        if(cmbIDNumeroAsientos.getSelectedIndex()!=0){
            cmbIDNumeroAsientos.setSelectedIndex(0);
        }
        else{

        }
        if("".equals(txtNumeroAsientos.getText())){
            JOptionPane.showMessageDialog(null, "Ingrese el Número de Asientos que es");
            return;
        }
        else{
            int i;
            boolean flag=false;
            for(i=0;i<NumeroAsientosdao.findNumero_AsientosEntities().size();i++){
                //System.out.println(i);
                if(txtNumeroAsientos.getText().toLowerCase().equals(NumeroAsientosdao.findNumero_Asientos(i+1).getNumero_Asientos())){
                    JOptionPane.showMessageDialog(null, "Ya existe este Número de Asientos registrado en el sistema");
                    flag=true;
                    return;
                } else {
                }
            }
            if(flag){
                return;
            }
            else{
                Numero_Asientos tp = new Numero_Asientos();
                tp.setEstado(true);
                tp.setNumero_Asientos(txtNumeroAsientos.getText().toLowerCase());
                try {
                    NumeroAsientosdao.create(tp);
                } catch (Exception ex) {
                    Logger.getLogger(FrmCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                //cmbIDNumeroAsientos.setSelectedIndex(1);
                cmbIDNumeroAsientos.setSelectedIndex(0);
                createTableNumeroAsientos();
                createComboBoxNumeroAsientos();
                this.jTabbedPane1.setSelectedIndex(8);
                createNumAsientosVehiculo();
                habilitarAgregarVehiculo();
                this.jTabbedPane1.setSelectedIndex(6);
            }
        }
    }//GEN-LAST:event_btnAgregar8ActionPerformed

    private void btnModificar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar8ActionPerformed
        if(cmbIDNumeroAsientos.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Número de Asientos no encontrado");
        }
        else{
            if("".equals(txtNumeroAsientos.getText())){
                JOptionPane.showMessageDialog(null, "Número de Asientos no puede ir vacio");
                return;
            }
            else{
                int i;
                boolean flag=false;
                for(i=0;i<NumeroAsientosdao.findNumero_AsientosEntities().size();i++){
                    //System.out.println(i);
                    if(txtNumeroAsientos.getText().toLowerCase().equals(NumeroAsientosdao.findNumero_Asientos(i+1).getNumero_Asientos())){
                        JOptionPane.showMessageDialog(null, "Ya existe este Número de Asientos registrado en el sistema");
                        flag=true;
                        return;
                    } else {
                    }
                }
                if(flag){
                    return;
                }
                else{
                    Numero_Asientos tp;
                    tp=NumeroAsientosdao.findNumero_Asientos(cmbIDNumeroAsientos.getSelectedIndex());
                    tp.setNumero_Asientos(txtNumeroAsientos.getText().toLowerCase());
                    try {
                        NumeroAsientosdao.edit(tp);
                    } catch (Exception ex) {
                        Logger.getLogger(TipoGasolina.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //cmbIDNumeroAsientos.setSelectedIndex(1);
                    cmbIDNumeroAsientos.setSelectedIndex(0);
                    createTableNumeroAsientos();
                    createComboBoxNumeroAsientos();
                    this.jTabbedPane1.setSelectedIndex(8);
                    createNumAsientosVehiculo();
                    this.jTabbedPane1.setSelectedIndex(6);
                }
            }
        }
    }//GEN-LAST:event_btnModificar8ActionPerformed

    private void btnLimpiar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar8ActionPerformed
      //  cmbIDNumeroAsientos.setSelectedIndex(1);
        cmbIDNumeroAsientos.setSelectedIndex(0);
        createTableNumeroAsientos();
        createComboBoxNumeroAsientos();
    }//GEN-LAST:event_btnLimpiar8ActionPerformed

    private void btnDesactivar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar8ActionPerformed
        Numero_Asientos temp;
        temp = NumeroAsientosdao.findNumero_Asientos(cmbIDNumeroAsientos.getSelectedIndex());
        if(temp.isEstado()){
            temp.setEstado(false);
        }
        else{
            temp.setEstado(true);
        }
        try {
            NumeroAsientosdao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(transmision.class.getName()).log(Level.SEVERE, null, ex);
        }
        createTableNumeroAsientos();
        btnActivarDesactivarNumeroAsientos();
    }//GEN-LAST:event_btnDesactivar8ActionPerformed

    private void tblNumeroAsientosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNumeroAsientosMouseClicked
        int column=0;
        int fila = tblNumeroAsientos.getSelectedRow();
        if (fila > -1){
            cmbIDNumeroAsientos.setSelectedIndex(Integer.parseInt(tblNumeroAsientos.getModel().getValueAt(fila, column).toString()));
            txtNumeroAsientos.setText(String.valueOf(tblNumeroAsientos.getValueAt(fila, ++column)));
            btnActivarDesactivarMarca();
        }
    }//GEN-LAST:event_tblNumeroAsientosMouseClicked

    private void tblNumeroAsientosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNumeroAsientosMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblNumeroAsientosMouseEntered

    private void btnSalir9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir9ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalir9ActionPerformed

    private void btnRegresar9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar9ActionPerformed
        FrmMenu m = new FrmMenu();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresar9ActionPerformed

    private void txtMarcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMarcaKeyTyped
       char validar=evt.getKeyChar();
       if((validar<'a'||validar>'z')&& (validar<'A' || validar>'Z') && (validar!=(char)KeyEvent.VK_BACKSPACE) && (validar!=(char)KeyEvent.VK_SPACE)){
           evt.consume();
           JOptionPane.showMessageDialog(null,"Solo se admiten letras para la nueva Marca","Error!", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_txtMarcaKeyTyped
private boolean TresletrasMarca(String Marca){
        
            Pattern pat = Pattern.compile("(?i)(.*aaa.*|.*bbb.*|.*ccc.*|.*ddd.*|.*eee.*|.*fff.*|.*ggg.*|.*hhh.*|.*iii.*|.*jjj.*|.*kkk.*|.*lll.*|.*mmm.*|.*nnn.*|.*ooo.*|.*ppp.*|.*qqq.*|.*rrr.*|.*sss.*|.*ttt.*|.*uuu.*|.*vvv.*|.*www.*|.*xxx.*|.*yyy.*|.*zzz.*)");
            Matcher mat = pat.matcher(Marca);
            
            if(mat.matches()){
                //JOptionPane.showMessageDialog(null, "Por favor, ingrese la marca valida","Error",JOptionPane.ERROR_MESSAGE);
                return true;   
            }
            else{
               return false; 
            }
    }
    private void txtColorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtColorKeyTyped
       char validar=evt.getKeyChar();
       if((validar<'a'||validar>'z')&& (validar<'A' || validar>'Z') && (validar!=(char)KeyEvent.VK_BACKSPACE) && (validar!=(char)KeyEvent.VK_SPACE)){
           evt.consume();
           JOptionPane.showMessageDialog(null,"Solo se admiten letras para el nuevo color","Error!", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_txtColorKeyTyped

    private void txtTipoVehiculoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoVehiculoKeyTyped
        char validar=evt.getKeyChar();
       if((validar<'a'||validar>'z')&& (validar<'A' || validar>'Z') && (validar!=(char)KeyEvent.VK_BACKSPACE) && (validar!=(char)KeyEvent.VK_SPACE)){
           evt.consume();
           JOptionPane.showMessageDialog(null,"Solo se admiten letras para el tipo de vehículo","Error!", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_txtTipoVehiculoKeyTyped

    private void txtTipoTransmisionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoTransmisionKeyTyped
        char validar=evt.getKeyChar();
       if((validar<'a'||validar>'z')&& (validar<'A' || validar>'Z') && (validar!=(char)KeyEvent.VK_BACKSPACE) && (validar!=(char)KeyEvent.VK_SPACE)){
           evt.consume();
           JOptionPane.showMessageDialog(null,"Solo se admiten letras para el nuevo tipo de transmisión","Error!", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_txtTipoTransmisionKeyTyped

    private void txtNumeroAsientosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroAsientosKeyTyped
       char validar=evt.getKeyChar();
       if((validar<'0'||validar>'9')){
           evt.consume();
           JOptionPane.showMessageDialog(null,"Solo se admiten números para el nuevo número de asientos","Error!", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_txtNumeroAsientosKeyTyped

    private void txtTipoCabinaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoCabinaKeyTyped
        char validar=evt.getKeyChar();
       if((validar<'a'||validar>'z')&& (validar<'A' || validar>'Z') && (validar!=(char)KeyEvent.VK_BACKSPACE) && (validar!=(char)KeyEvent.VK_SPACE)){
           evt.consume();
           JOptionPane.showMessageDialog(null,"Solo se admiten letras para el nuevo tipo de cabina","Error!", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_txtTipoCabinaKeyTyped

    private void txtTipoGasolinaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoGasolinaKeyTyped
        char validar=evt.getKeyChar();
       if((validar<'a'||validar>'z')&& (validar<'A' || validar>'Z') && (validar!=(char)KeyEvent.VK_BACKSPACE) && (validar!=(char)KeyEvent.VK_SPACE)){
           evt.consume();
           JOptionPane.showMessageDialog(null,"Solo se admiten letras para el nuevo tipo de gasolina","Error!", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_txtTipoGasolinaKeyTyped

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
/*        if(jTabbedPane1.getSelectedIndex()==4){
            createComboBoxTipoCabina();
        }
        else if(jTabbedPane1.getSelectedIndex()==8){
            createcmbTipoCabinaVehiculo();
            createNumAsientosVehiculo();
        }*/
            

        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void txtPrecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyPressed
        char validar=evt.getKeyChar();
        if((validar<'0'||validar>'9')&& (validar<'.' || validar>'.') && (validar!=(char)KeyEvent.VK_BACKSPACE && (validar!=(char)KeyEvent.VK_SPACE)) ){
          JOptionPane.showMessageDialog(null,"Solo se admiten numeros para el precio","Error!", JOptionPane.ERROR_MESSAGE);
          txtPrecio.setText("");
          evt.consume();
       }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioKeyPressed

    private void txtCilindrajeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCilindrajeKeyPressed
         char validar=evt.getKeyChar();
        if((validar<'0'||validar>'9') && (validar!=(char)KeyEvent.VK_BACKSPACE && (validar!=(char)KeyEvent.VK_SPACE)) ){
          JOptionPane.showMessageDialog(null,"Solo se admiten numeros para el precio","Error!", JOptionPane.ERROR_MESSAGE);
          txtPrecio.setText("");
          evt.consume();
       }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCilindrajeKeyPressed

    private void tbAgregarVehiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAgregarVehiculoMouseClicked
        int column = 0;
        int fila = tbAgregarVehiculo.getSelectedRow();
        if (fila > -1){
            cmbIDVehiculo.setSelectedIndex(Integer.parseInt(tbAgregarVehiculo.getModel().getValueAt(fila, column).toString()));
            Vehiculo temp = vehiculoDao.findVehiculo(Integer.parseInt(tbAgregarVehiculo.getModel().getValueAt(fila, column).toString()));
            cmbMarcaVehiculo.setSelectedIndex(temp.getId_marca());
            cmbColorVehiculo.setSelectedIndex(temp.getId_tipo_color());
            cmbTipoVehiculoVehiculo.setSelectedIndex(temp.getId_tipo_vehiculo());
            cmbGasolinaVehiculo.setSelectedIndex(temp.getId_tipo_gasolina());
            cmbNumAsientos.setSelectedIndex(temp.getId_numero_asientos());
            cmbCabinaVehiculo.setSelectedIndex(temp.getId_tipo_cabina());
            cmbTransmisionVehiculo.setSelectedIndex(temp.getId_transmision());
            txtCilindraje.setText(String.valueOf(temp.getTotal_cilindraje()));
            ftxtStock.setText(String.valueOf(temp.getStock()));
            ftxtStockMaximo.setText(String.valueOf(temp.getStock_maximo()));
            ftxtStockMinimo.setText(String.valueOf(temp.getStock_minimo()));
            txtVin.setText(temp.getVin());
            
            txtPrecio.setText(String.valueOf(tbAgregarVehiculo.getValueAt(fila, 11)));
            
            
            
            //btnActivarDesactivarPieza();
            btnModificar7.setEnabled(true);
            btnAgregar7.setEnabled(false);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tbAgregarVehiculoMouseClicked

    private void chkMarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkMarcaItemStateChanged
        if(chkMarca.isSelected()){
            //createcmbMarcaBusqueda();
            cmbMarcaBusqueda.enable(true);
        }
        else{
            //createcmbMarcaBusqueda();
            cmbMarcaBusqueda.enable(false);
        }
        createcmbMarcaBusqueda();
        // TODO add your handling code here:
    }//GEN-LAST:event_chkMarcaItemStateChanged

    private void chkColorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkColorItemStateChanged
        if(chkColor.isSelected()){
            cmbColorBusqueda.enable(true);
        }
        else{
            cmbColorBusqueda.enable(false);
        }
        createcmbColorBusqueda();
        // TODO add your handling code here:
    }//GEN-LAST:event_chkColorItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
        createTableBusqueda();
        
        

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void chkTipoVehiculoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkTipoVehiculoItemStateChanged

        if(chkTipoVehiculo.isSelected()){
            cmbTipoVehiculoBusqueda.enable(true);
            
        }
        else{
            cmbTipoVehiculoBusqueda.enable(false);
        }
        createcmbTipoVehiculoBusqueda();
        // TODO add your handling code here:
    }//GEN-LAST:event_chkTipoVehiculoItemStateChanged

    private void chkTipoGasolinaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkTipoGasolinaItemStateChanged
        if(chkTipoGasolina.isSelected()){
            cmbGasolinaBusqueda.enable(true);
        }
        else{
            cmbGasolinaBusqueda.enable(false);
        }
        createcmbTipoGasolinaBusqueda();
        // TODO add your handling code here:
    }//GEN-LAST:event_chkTipoGasolinaItemStateChanged

    private void createTableBusqueda(){
        DefaultTableModel modelo = new DefaultTableModel();
        tbBusqueda.setModel(modelo);
        modelo.addColumn("ID");
        
        modelo.addColumn("Marca");
        modelo.addColumn("Modelo");
        modelo.addColumn("Color");
        modelo.addColumn("Combustible");
        modelo.addColumn("Tipo de vehiculo");
        modelo.addColumn("Numero de asientos");
        modelo.addColumn("Precio");
        
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00",separadoresPersonalizados);
        
       
        
        List<Vehiculo> temp = vehiculoDao.findVehiculoEntities();
        List<HistoricoPrecioVehiculos> temp2 = historicoPrecioVehiculoDao.findHistoricoPrecioVehiculosEntities();
        Double aux = 0.0;
        if(chkMarca.isSelected() && !chkColor.isSelected() && !chkTipoGasolina.isSelected() && !chkTipoVehiculo.isSelected()){
            for(Vehiculo e : temp){
                if(e.getId_marca()==(cmbMarcaBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                e.getVin(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                formato1.format(aux)
                                                         
                            
                        });
                        }
                    }
                }
            }
        }
        else if(!chkMarca.isSelected() && chkColor.isSelected() && !chkTipoGasolina.isSelected() && !chkTipoVehiculo.isSelected()){
            for(Vehiculo e : temp){
                if(e.getId_tipo_color()==(cmbColorBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                e.getVin(),
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                formato1.format(aux)
                                                         
                            
                        });
                        }
                    }
                }
            }
        }
        else if(!chkMarca.isSelected() && !chkColor.isSelected() && chkTipoGasolina.isSelected() && !chkTipoVehiculo.isSelected()){
            for(Vehiculo e : temp){
                if(e.getId_tipo_gasolina()==(cmbGasolinaBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                e.getVin(),
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                formato1.format(aux)
                                                         
                            
                        });
                        }
                    }
                }
            }
        }
        else if(!chkMarca.isSelected() && !chkColor.isSelected() && !chkTipoGasolina.isSelected() && chkTipoVehiculo.isSelected()){
            for(Vehiculo e : temp){
                if(e.getId_tipo_vehiculo()==(cmbTipoVehiculoBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                e.getVin(),
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                formato1.format(aux)
                                                         
                            
                        });
                        }
                    }
                }
            }
        }
        else if(chkMarca.isSelected() && chkColor.isSelected() &&  !chkTipoGasolina.isSelected() && !chkTipoVehiculo.isSelected()){
            
            //JOptionPane.showMessageDialog(null,"Entro aqui");
            for(Vehiculo e : temp){
                if(e.getId_tipo_vehiculo()==(cmbMarcaBusqueda.getSelectedIndex())  && e.getId_tipo_color()==(cmbColorBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                e.getVin(),
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                formato1.format(aux)
                                                         
                            
                        });
                        }
                    }
                }
            }
        }
        else if(chkMarca.isSelected() && !chkColor.isSelected() &&  chkTipoGasolina.isSelected() && !chkTipoVehiculo.isSelected()){
            
            //JOptionPane.showMessageDialog(null,"Entro aqui");
            for(Vehiculo e : temp){
                if(e.getId_tipo_vehiculo()==(cmbMarcaBusqueda.getSelectedIndex())  && e.getId_tipo_gasolina()==(cmbGasolinaBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                e.getVin(),
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                formato1.format(aux)
                                                         
                            
                        });
                        }
                    }
                }
            }
        }
        else if(chkMarca.isSelected() && !chkColor.isSelected() &&  !chkTipoGasolina.isSelected() && chkTipoVehiculo.isSelected()){
            
            //JOptionPane.showMessageDialog(null,"Entro aqui");
            for(Vehiculo e : temp){
                if(e.getId_tipo_vehiculo()==(cmbMarcaBusqueda.getSelectedIndex())  && e.getId_tipo_vehiculo()==(cmbTipoVehiculoBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                e.getVin(),
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                formato1.format(aux)
                                                         
                            
                        });
                        }
                    }
                }
            }
        }
        else if(!chkMarca.isSelected() && chkColor.isSelected() &&  chkTipoGasolina.isSelected() && !chkTipoVehiculo.isSelected()){
            
            //JOptionPane.showMessageDialog(null,"Entro aqui");
            for(Vehiculo e : temp){
                if(e.getId_tipo_color()==(cmbColorBusqueda.getSelectedIndex())  && e.getId_tipo_gasolina()==(cmbGasolinaBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                e.getVin(),
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                formato1.format(aux)
                                                         
                            
                        });
                        }
                    }
                }
            }
        }
        else if(!chkMarca.isSelected() && chkColor.isSelected() &&  !chkTipoGasolina.isSelected() && chkTipoVehiculo.isSelected()){
            
            //JOptionPane.showMessageDialog(null,"Entro aqui");
            for(Vehiculo e : temp){
                if(e.getId_tipo_color()==(cmbColorBusqueda.getSelectedIndex())  && e.getId_tipo_vehiculo()==(cmbTipoVehiculoBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                e.getVin(),
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                formato1.format(aux)
                                                         
                            
                        });
                        }
                    }
                }
            }
        }
        else if(!chkMarca.isSelected() && !chkColor.isSelected() &&  chkTipoGasolina.isSelected() && chkTipoVehiculo.isSelected()){
            
            //JOptionPane.showMessageDialog(null,"Entro aqui");
            for(Vehiculo e : temp){
                if(e.getId_tipo_gasolina()==(cmbGasolinaBusqueda.getSelectedIndex())  && e.getId_tipo_vehiculo()==(cmbTipoVehiculoBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                e.getVin(),
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                formato1.format(aux)
                                                         
                            
                        });
                        }
                    }
                }
            }
        }
        else if(!chkMarca.isSelected() && chkColor.isSelected() &&  chkTipoGasolina.isSelected() && chkTipoVehiculo.isSelected()){
            
            //JOptionPane.showMessageDialog(null,"Entro aqui");
            for(Vehiculo e : temp){
                if(e.getId_tipo_color()==(cmbColorBusqueda.getSelectedIndex()) &&  e.getId_tipo_gasolina()==(cmbGasolinaBusqueda.getSelectedIndex())  && e.getId_tipo_vehiculo()==(cmbTipoVehiculoBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                e.getVin(),
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                formato1.format(aux)
                                                         
                            
                        });
                        }
                    }
                }
            }
        }
        else if(chkMarca.isSelected() && !chkColor.isSelected() &&  chkTipoGasolina.isSelected() && chkTipoVehiculo.isSelected()){
            
            //JOptionPane.showMessageDialog(null,"Entro aqui");
            for(Vehiculo e : temp){
                if(e.getId_marca()==(cmbMarcaBusqueda.getSelectedIndex()) &&  e.getId_tipo_gasolina()==(cmbGasolinaBusqueda.getSelectedIndex())  && e.getId_tipo_vehiculo()==(cmbTipoVehiculoBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                e.getVin(),
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                formato1.format(aux)
                                                         
                            
                        });
                        }
                    }
                }
            }
        }
        else if(chkMarca.isSelected() && chkColor.isSelected() &&  !chkTipoGasolina.isSelected() && chkTipoVehiculo.isSelected()){
            
            //JOptionPane.showMessageDialog(null,"Entro aqui");
            for(Vehiculo e : temp){
                if(e.getId_marca()==(cmbMarcaBusqueda.getSelectedIndex()) &&  e.getId_tipo_color()==(cmbColorBusqueda.getSelectedIndex())  && e.getId_tipo_vehiculo()==(cmbTipoVehiculoBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                e.getVin(),
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                formato1.format(aux)
                                                         
                            
                        });
                        }
                    }
                }
            }
        }
        else if(chkMarca.isSelected() && chkColor.isSelected() &&  chkTipoGasolina.isSelected() && !chkTipoVehiculo.isSelected()){
            
            //JOptionPane.showMessageDialog(null,"Entro aqui");
            for(Vehiculo e : temp){
                if(e.getId_marca()==(cmbMarcaBusqueda.getSelectedIndex()) &&  e.getId_tipo_color()==(cmbColorBusqueda.getSelectedIndex())  && e.getId_tipo_gasolina()==(cmbGasolinaBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                e.getVin(),
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                formato1.format(aux)
                                                         
                            
                        });
                        }
                    }
                }
            }
        }
        else if(chkMarca.isSelected() && chkColor.isSelected() &&  chkTipoGasolina.isSelected() && chkTipoVehiculo.isSelected()){
            
            //JOptionPane.showMessageDialog(null,"Entro aqui");
            for(Vehiculo e : temp){
                if(e.getId_tipo_vehiculo()==cmbTipoVehiculoBusqueda.getSelectedIndex() && e.getId_marca()==(cmbMarcaBusqueda.getSelectedIndex()) &&  e.getId_tipo_color()==(cmbColorBusqueda.getSelectedIndex())  && e.getId_tipo_gasolina()==(cmbGasolinaBusqueda.getSelectedIndex())){
                    for(HistoricoPrecioVehiculos t : temp2){
                        if(e.getId_vehiculo()==t.getId_vehiculo() && t.getFechaFinal()==null){
                            aux=t.getPrecio();
                            modelo.addRow(new Object[]{
                                e.getId_vehiculo(),
                                e.getVin(),
                                Marcadao.findMarca(e.getId_marca()).getMarca(),
                                Colorrdao.findTipo_color(e.getId_tipo_color()).getTipo_color(),
                                TipoGasolinadao.findTipoGasolina(e.getId_tipo_gasolina()).getTipoGasolina(),
                                TipoVehiculodao.findTipoVehiculo(e.getId_tipo_vehiculo()).getTipoVehiculo(),
                                NumeroAsientosdao.findNumero_Asientos(e.getId_numero_asientos()).getNumero_Asientos(),
                                formato1.format(aux)
                                                         
                            
                        });
                        }
                    }
                }
            }
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
            java.util.logging.Logger.getLogger(FrmVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVehiculos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar1;
    private javax.swing.JButton btnAgregar2;
    private javax.swing.JButton btnAgregar3;
    private javax.swing.JButton btnAgregar4;
    private javax.swing.JButton btnAgregar5;
    private javax.swing.JButton btnAgregar6;
    private javax.swing.JButton btnAgregar7;
    private javax.swing.JButton btnAgregar8;
    private javax.swing.JButton btnDesactivar1;
    private javax.swing.JButton btnDesactivar2;
    private javax.swing.JButton btnDesactivar3;
    private javax.swing.JButton btnDesactivar4;
    private javax.swing.JButton btnDesactivar5;
    private javax.swing.JButton btnDesactivar6;
    private javax.swing.JButton btnDesactivar7;
    private javax.swing.JButton btnDesactivar8;
    private javax.swing.JButton btnLimpiar1;
    private javax.swing.JButton btnLimpiar2;
    private javax.swing.JButton btnLimpiar3;
    private javax.swing.JButton btnLimpiar4;
    private javax.swing.JButton btnLimpiar5;
    private javax.swing.JButton btnLimpiar6;
    private javax.swing.JButton btnLimpiar7;
    private javax.swing.JButton btnLimpiar8;
    private javax.swing.JButton btnModificar1;
    private javax.swing.JButton btnModificar2;
    private javax.swing.JButton btnModificar3;
    private javax.swing.JButton btnModificar4;
    private javax.swing.JButton btnModificar5;
    private javax.swing.JButton btnModificar6;
    private javax.swing.JButton btnModificar7;
    private javax.swing.JButton btnModificar8;
    private javax.swing.JButton btnRegresar1;
    private javax.swing.JButton btnRegresar2;
    private javax.swing.JButton btnRegresar3;
    private javax.swing.JButton btnRegresar4;
    private javax.swing.JButton btnRegresar5;
    private javax.swing.JButton btnRegresar6;
    private javax.swing.JButton btnRegresar7;
    private javax.swing.JButton btnRegresar8;
    private javax.swing.JButton btnRegresar9;
    private javax.swing.JButton btnSalir1;
    private javax.swing.JButton btnSalir2;
    private javax.swing.JButton btnSalir3;
    private javax.swing.JButton btnSalir4;
    private javax.swing.JButton btnSalir5;
    private javax.swing.JButton btnSalir6;
    private javax.swing.JButton btnSalir7;
    private javax.swing.JButton btnSalir8;
    private javax.swing.JButton btnSalir9;
    private javax.swing.JCheckBox chkColor;
    private javax.swing.JCheckBox chkMarca;
    private javax.swing.JCheckBox chkTipoGasolina;
    private javax.swing.JCheckBox chkTipoVehiculo;
    private javax.swing.JComboBox<String> cmbCabinaVehiculo;
    private javax.swing.JComboBox<String> cmbColorBusqueda;
    private javax.swing.JComboBox<String> cmbColorVehiculo;
    private javax.swing.JComboBox<String> cmbGasolinaBusqueda;
    private javax.swing.JComboBox<String> cmbGasolinaVehiculo;
    private javax.swing.JComboBox<String> cmbIDColor;
    private javax.swing.JComboBox<String> cmbIDMarca;
    private javax.swing.JComboBox<String> cmbIDNumeroAsientos;
    private javax.swing.JComboBox<String> cmbIDTipoGasolina;
    private javax.swing.JComboBox<String> cmbIDTipoTransmision;
    private javax.swing.JComboBox<String> cmbIDTipoVehiculo;
    private javax.swing.JComboBox<String> cmbIDVehiculo;
    private javax.swing.JComboBox<String> cmbMarcaBusqueda;
    private javax.swing.JComboBox<String> cmbMarcaVehiculo;
    private javax.swing.JComboBox<String> cmbNumAsientos;
    private javax.swing.JComboBox<String> cmbPiezaClave;
    private javax.swing.JComboBox<String> cmbTipoVehiculoBusqueda;
    private javax.swing.JComboBox<String> cmbTipoVehiculoVehiculo;
    private javax.swing.JComboBox<String> cmbTransmisionVehiculo;
    private javax.swing.JFormattedTextField ftxtStock;
    private javax.swing.JFormattedTextField ftxtStockMaximo;
    private javax.swing.JFormattedTextField ftxtStockMinimo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbAgregarVehiculo;
    private javax.swing.JTable tbBusqueda;
    private javax.swing.JTable tblColor;
    private javax.swing.JTable tblMarca;
    private javax.swing.JTable tblNumeroAsientos;
    private javax.swing.JTable tblTipoCabina;
    private javax.swing.JTable tblTipoGasolina;
    private javax.swing.JTable tblTipoTransmision;
    private javax.swing.JTable tblTipoVehiculo;
    private javax.swing.JTextField txtCilindraje;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNumeroAsientos;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTipoCabina;
    private javax.swing.JTextField txtTipoGasolina;
    private javax.swing.JTextField txtTipoTransmision;
    private javax.swing.JTextField txtTipoVehiculo;
    private javax.swing.JTextField txtVin;
    // End of variables declaration//GEN-END:variables
}
