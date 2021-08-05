/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import Clases.Cargo_empleado;
import Clases.Empleado;
import Clases.Hash;
import Clases.HistoricoCargo_empleado;
import Clases.HistoricoSueldo_empleado;
import Clases.Persona;
import Clases.Tipo_Documento;
import Clases.Usuarios;
import JPAController.Cargo_empleadoJpaController;
import JPAController.EmpleadoJpaController;
import JPAController.HistoricoCargo_empleadoJpaController;
import JPAController.HistoricoSueldo_empleadoJpaController;
import JPAController.PersonaJpaController;
import JPAController.Tipo_DocumentoJpaController;
import JPAController.UsuariosJpaController;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Component;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.KeyAdapter;
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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Usuario
 */
public class FrmEmpleados extends javax.swing.JFrame {
    
    UsuariosJpaController UsuariosDao = new UsuariosJpaController();
    HistoricoSueldo_empleadoJpaController HistoricoSueldoDao = new HistoricoSueldo_empleadoJpaController();
    HistoricoCargo_empleadoJpaController HistoricoCargoDao = new HistoricoCargo_empleadoJpaController();
    Cargo_empleadoJpaController CargoDao = new Cargo_empleadoJpaController();
    /**
     * Creates new form Empleados
     */
    Tipo_DocumentoJpaController TipoDocumentodao = new Tipo_DocumentoJpaController();
    PersonaJpaController Personadao = new PersonaJpaController();
    EmpleadoJpaController Empleadodao = new EmpleadoJpaController();
    
    public FrmEmpleados() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);

        //Tab_Empleado.setIconAt(0, (new javax.swing.ImageIcon(getClass().getResource("/Img/Empleado.png"))));
       this.getContentPane().setBackground(new Color(0, 75, 143));
for (int i = 0; i < this.Tab_Empleado.getTabCount(); i++) { 
      this.Tab_Empleado.setBackgroundAt(i, new Color(0, 75, 143)); 
      this.Tab_Empleado.getComponentAt(i).setBackground(new Color(0, 75, 143)); 
} 
       this.Tab_Empleado.setBackgroundAt(0, new Color(0, 75, 143));
       this.Tab_Empleado.setBackgroundAt(1, new Color(0, 75, 143));
       this.Tab_Empleado.setBackgroundAt(2, new Color(0, 75, 143));
       this.Tab_Empleado.setBackgroundAt(3, new Color(0, 75, 143));
       this.Tab_Empleado.setBackgroundAt(4, new Color(0, 75, 143));
        this.jPanel1.setBackground( new Color(0, 75, 143));
        this.jPanel2.setBackground( new Color(0, 75, 143));
        this.jPanel3.setBackground( new Color(0, 75, 143));
        this.jPanel4.setBackground( new Color(0, 75, 143));
        this.jPanel5.setBackground( new Color(0, 75, 143));
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
        
        this.btnAgregar2.setBackground( new Color(14, 209, 69));
        this.btnSalir2.setBackground( new Color(236, 28, 36));
        this.btnModificar2.setBackground( new Color(14, 209, 69));
        this.btnLimpiar2.setBackground( new Color(14, 209, 69));
        this.btnDesactivar2.setBackground( new Color(14, 209, 69));
        this.btnRegresar2.setBackground( new Color(14, 209, 69));
        
        this.btnSalir3.setBackground( new Color(236, 28, 36));
        this.btnRegresar3.setBackground( new Color(14, 209, 69));
        this.btnSalir4.setBackground( new Color(236, 28, 36));
        this.btnRegresar4.setBackground( new Color(14, 209, 69));
        //this.cmbIDEmpleado.setEnabled(false);
        /*int fila= tblEmpleados.getRowCount();
        for(int i = 0; i < fila;i++)
        {
        if(i%2==0){*/
            tblEmpleados.setForeground(Color.WHITE);
            tblEmpleados.setBackground(Color.BLACK);
            
            tblNuevoCargo.setForeground(Color.WHITE);
            tblNuevoCargo.setBackground(Color.BLACK);
            
            Tbl_Usuarios.setForeground(Color.WHITE);
            Tbl_Usuarios.setBackground(Color.BLACK);
            
            tblHistorialSueldo.setForeground(Color.WHITE);
            tblHistorialSueldo.setBackground(Color.BLACK);
            
            jTbHistorialCargo.setForeground(Color.WHITE);
            jTbHistorialCargo.setBackground(Color.BLACK);
        /*}
        else {

        }*/
        btnModificar1.setEnabled(false);

        //jPanel1.setBackground(Color.CYAN);
        txtIDUsuario.setBackground(Color.GRAY);
        createComboBoxEmpleado();
        createTableEmpleado();
        createComboTipoDocumentoEmpleado();
        createComboCargoEmpleado();
        btnDesactivar.setEnabled(false);
        btnDesactivar1.setEnabled(false);
        createTableUsuario();
        createCmbIDEmpleado();
        createComboBoxNuevoCargo();
        createTableNuevoCargo();
        crearTbHistorialSueldo();
        crearTbHistorialCargo();
        habilitarAgregarEmpleado();
    
    }
    private void habilitarAgregarEmpleado(){
        //Validacion de agregar
        if(TipoDocumentodao.getTipo_DocumentoCount()!=0 || CargoDao.getCargo_empleadoCount()!=0){
            btnAgregar.setEnabled(true);
        }
        else{
            
        }
        //Fin de validacion agregar
    } 
    public void createCmbIDEmpleado(){
        
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        cmbIDEmpleado.setModel(modelo);
        cmbIDEmpleado.setModel(modelo);
        List<Empleado>  temp = Empleadodao.findEmpleadoEntities();
        List<Persona> tempp = Personadao.findPersonaEntities();
        modelo.addElement("Seleccione...");
        for (Empleado cc : temp){     
            for(Persona pp : tempp){
        temp.forEach((tpp)-> {
        tempp.forEach((tp) -> {
            if(tpp.getId_Persona()== tp.getId_persona()){
            modelo.addElement(tpp.getId_Empleado());
            }
        });   
        });          
            return;
        }
        }
    }

    public void btnActivarDesactivarUsuario(){
        Usuarios temp;
        temp = UsuariosDao.findUsuarios(Integer.parseInt(txtIDUsuario.getText()));
        
        if(temp.isEstado()){
        btnDesactivar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar.setText("Desactivar");  
        btnDesactivar.setEnabled(true);
        }
        else{
            btnDesactivar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            btnDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png"))); // NOI18N
            btnDesactivar.setText("Activar");
            btnDesactivar.setEnabled(true);
        }
    }
    public void btnActivarDesactivarCargo(){
        Cargo_empleado temp = new Cargo_empleado();
        temp = CargoDao.findCargo_empleado(cmbIDNuevoCargo.getSelectedIndex());
        
        if(temp.isEstado()){
        btnDesactivar2.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnDesactivar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar2.setText("Desactivar");  
        btnDesactivar1.setEnabled(true);
        }
        else{
            btnDesactivar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            btnDesactivar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar2.setText("Activar");
            btnDesactivar2.setEnabled(true);
        }
        }
       public void crearTbHistorialSueldo(){
        DefaultTableModel modelo = new DefaultTableModel();
        tblHistorialSueldo.setModel(modelo);
        modelo.addColumn("ID Sueldo Historico");
        modelo.addColumn("Empleado");
        modelo.addColumn("Sueldo");
        modelo.addColumn("Desde");
        modelo.addColumn("Hasta");
        modelo.addColumn("Estado");
        List<HistoricoSueldo_empleado> temp = HistoricoSueldoDao.findHistoricoSueldo_empleadoEntities();
        List<Empleado> temp2 = Empleadodao.findEmpleadoEntities();
        List<Persona> tempo = Personadao.findPersonaEntities();
        String auxEmpleadonombre="";
        String auxclienteapellido="";
        String auxNombreApellido="";
        String auxEmpleado="";
        String auxfecha="";
        String auxfechab="";
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00",separadoresPersonalizados);
        for(HistoricoSueldo_empleado e : temp){
            //if(e.getId_sueldo()==(cmbIDCargo.getSelectedIndex()+1) && e.getFecha_final()!=null){
            for(Empleado tp : temp2){
                if(tp.getId_Empleado() == e.getId_empleado()){
                 for(Persona p : tempo){   
                            if(p.getId_persona()==tp.getId_Persona()){
                            auxEmpleadonombre=(p.getNombre());
                            auxclienteapellido=(p.getApellido());
                            auxNombreApellido= auxEmpleadonombre+" "+auxclienteapellido;
                            auxEmpleado=(tp.getId_Empleado() + ". " + auxNombreApellido);
                            auxfecha=(e.getFecha_inicial().substring(8, 10)+"/"+e.getFecha_inicial().substring(5, 7)+"/"+e.getFecha_inicial().substring(0, 4));
                            
                            }   
                        }
                }
                if(e.getFecha_final()==null) {
                                            auxfechab="";
                                    } else {
                                        auxfechab=(e.getFecha_final().substring(8, 10)+"/"+e.getFecha_final().substring(5, 7)+"/"+e.getFecha_final().substring(0, 4));
                                    }
            }
                        
            
            
            modelo.addRow(new Object[]{
                                  e.getId_sueldo(),
                                  auxEmpleado,
                                  formato1.format(e.getSueldo()),
                                  auxfecha,
                                  auxfechab,
                                  e.isEstado()? "Activo" : "Inactivo"
            });
        
            //}
            }
        
            
    }
       
 /*       public void crearcmbSueldoHistorico(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        cmbIDSueldo.setModel(modelo);
        List<Empleado> temp = Empleadodao.findEmpleadoEntities();
        
        List<Persona> tempp = Personadao.findPersonaEntities();
        modelo.addElement("Seleccione...");
        for (Empleado cc : temp){     
            for(Persona pp : tempp){
        temp.forEach((tpp)-> {
        tempp.forEach((tp) -> {
            if(tpp.getId_Persona()== tp.getId_persona()){
            modelo.addElement(tpp.getId_Empleado()+". "+tp.getNombre()+" "+tp.getApellido());
            }
        });   
        });          
            return;
        }
        }
    }*/
   public void crearTbHistorialCargo(){
        DefaultTableModel modelo = new DefaultTableModel();
        jTbHistorialCargo.setModel(modelo);
        modelo.addColumn("ID Cargo Historico");
        modelo.addColumn("Empleado");
        modelo.addColumn("Cargo");
        modelo.addColumn("Desde");
        modelo.addColumn("Hasta");
        modelo.addColumn("Estado");
        List<HistoricoCargo_empleado> temp = HistoricoCargoDao.findHistoricoCargo_empleadoEntities();
        List<Empleado> temp2 = Empleadodao.findEmpleadoEntities();
        List<Cargo_empleado> tempce = CargoDao.findCargo_empleadoEntities();
        String auxCargo="";
        List<Persona> tempo = Personadao.findPersonaEntities();
        String auxEmpleadonombre="";
        String auxclienteapellido="";
        String auxNombreApellido="";
        String auxEmpleado="";
        String auxfecha="";
        String auxfechab="";
        for(HistoricoCargo_empleado e : temp){
            //if(e.getId_sueldo()==(cmbIDCargo.getSelectedIndex()+1) && e.getFecha_final()!=null){
            for(Empleado tp : temp2){
                if(tp.getId_Empleado() == e.getId_empleado()){
                 for(Persona p : tempo){   
                            if(p.getId_persona()==tp.getId_Persona()){
                            auxEmpleadonombre=(p.getNombre());
                            auxclienteapellido=(p.getApellido());
                            auxNombreApellido= auxEmpleadonombre+" "+auxclienteapellido;
                            auxEmpleado=(tp.getId_Empleado() + ". " + auxNombreApellido);
                            auxfecha=(e.getFecha_inicial().substring(8, 10)+"/"+e.getFecha_inicial().substring(5, 7)+"/"+e.getFecha_inicial().substring(0, 4));   
                            }   
                        }
                }
                for(Cargo_empleado ce : tempce){
                    if(ce.getId_cargo()==e.getId_cargo()){
                        auxCargo=(ce.getId_cargo() + ". " + ce.getCargo());
                    }
                }
                if(e.getFecha_final()==null) {
                                            auxfechab="";
                                    } else {
                                        auxfechab=(e.getFecha_final().substring(8, 10)+"/"+e.getFecha_final().substring(5, 7)+"/"+e.getFecha_final().substring(0, 4));
                                    } 
            }  
            
            modelo.addRow(new Object[]{
                                  e.getId_cargo_historico(),
                                  auxEmpleado,
                                  auxCargo,
                                  auxfecha,
                                  auxfechab,
                                  e.isEstado()? "Activo" : "Inactivo"
            });
        
            //}
            }
        
            
    }
       /* public void crearcmbCargoHistorico(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        cmbIDCargo.setModel(modelo);
        List<Empleado> temp = Empleadodao.findEmpleadoEntities();
        
        List<Persona> tempp = Personadao.findPersonaEntities();
        modelo.addElement("Seleccione...");
        for (Empleado cc : temp){     
            for(Persona pp : tempp){
        temp.forEach((tpp)-> {
        tempp.forEach((tp) -> {
            if(tpp.getId_Persona()== tp.getId_persona()){
            modelo.addElement(tpp.getId_Empleado()+". "+tp.getNombre()+" "+tp.getApellido());
            }
        });   
        });          
            return;
        }
        }
    }*/

    public void createTableUsuario(){
        DefaultTableModel modelo = new DefaultTableModel();
            
            Tbl_Usuarios.setModel(modelo);
            modelo.addColumn("Numero de Usuario");
            modelo.addColumn("ID de Empleado");
            modelo.addColumn("Nombre de usuario");
            modelo.addColumn("Contraseña");
            modelo.addColumn("Estado"); //NUEVO
            List<Usuarios> usuario = UsuariosDao.findUsuariosEntities();
            List<Empleado> temp2 = Empleadodao.findEmpleadoEntities();
            List<Persona> tempo = Personadao.findPersonaEntities();
            String auxEmpleadonombre="";
            String auxclienteapellido="";
            String auxNombreApellido="";
            String auxEmpleado="";
            
            if(usuario ==null){
                
            }
            else{
            for(Usuarios usu : usuario){
                for(Empleado tp : temp2){
                if(tp.getId_Empleado() == usu.getId_Empleado()){
                 for(Persona p : tempo){   
                            if(p.getId_persona()==tp.getId_Persona()){
                            auxEmpleadonombre=(p.getNombre());
                            auxclienteapellido=(p.getApellido());
                            auxNombreApellido= (auxEmpleadonombre+" "+auxclienteapellido);
                            auxEmpleado=(tp.getId_Empleado() + ". " + auxNombreApellido);
                            }   
                        }
                }
            } 
                modelo.addRow(
                    new Object[]{
                        usu.getId_Usuario(),
                        auxEmpleado,
                        usu.getId_Nombre(),
                        usu.getContraseña(), 
                        (usu.isEstado())? "Activo" : "Inactivo" //NUEVO
                    }
                );
            }
            }
    
    }
public void btnActivarDesactivarEmpleado(){
        Empleado temp = new Empleado();
        temp = Empleadodao.findEmpleado(cmbIDEmpleado1.getSelectedIndex());
        
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
public void createComboBoxEmpleado(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        cmbIDEmpleado1.setModel(modelo);
        List<Empleado> temp = Empleadodao.findEmpleadoEntities();
        modelo.addElement("Nuevo");
        temp.forEach((c) -> {
        modelo.addElement(c.getId_Empleado());
        });
        }
public void createComboTipoDocumentoEmpleado(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        cmbTipoDocumentoEmpleado.setModel(modelo);
        List<Tipo_Documento> temp = TipoDocumentodao.findTipo_DocumentoEntities();
        modelo.addElement("Seleccione...");

        for(Tipo_Documento tp : temp){    
        temp.forEach((tpp) -> {
            modelo.addElement(tpp.getId_Tipo_Documento()+". "+tpp.getDocumento());
        });         
            return;
        }
                }
public void createComboCargoEmpleado(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        cmbCargoEmpleado.setModel(modelo);
        List<Cargo_empleado> tempp = CargoDao.findCargo_empleadoEntities();
        modelo.addElement("Seleccione...");   
        for(Cargo_empleado tp : tempp){   
        tempp.forEach((tpp) -> {
            modelo.addElement(tpp.getId_cargo()+". "+tpp.getCargo());
     
        });
            return;
        }
        

                }

public void createTableEmpleado(){
        DefaultTableModel modelo = new DefaultTableModel();
        tblEmpleados.setModel(modelo);
        modelo.addColumn("ID Empleado");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Dirección");
        modelo.addColumn("Correo electrónico");
        modelo.addColumn("Fecha Registro");
        modelo.addColumn("Tipo Documento");
        modelo.addColumn("Documento");
        modelo.addColumn("Cargo");
        modelo.addColumn("Sueldo");
        modelo.addColumn("Estado");
        
        List<Persona> tempo = Personadao.findPersonaEntities();
        String auxNombre="";
        String auxApellido="";
        String auxDireccion="";
        String auxCorreo="";
        String auxTelefono="";
        String auxDocumento="";
        List<Empleado> temp = Empleadodao.findEmpleadoEntities();
        String aux1="";
        
        String auxfecharegistro="";
        List<Tipo_Documento> temp2 = TipoDocumentodao.findTipo_DocumentoEntities();
        int aux=0;
        List<HistoricoSueldo_empleado> temp3 = HistoricoSueldoDao.findHistoricoSueldo_empleadoEntities();
        double auxSueldo=0;
        List<HistoricoCargo_empleado> tempc = HistoricoCargoDao.findHistoricoCargo_empleadoEntities();
        int auxCargo=0;
        String auxfecha="";
        List<Cargo_empleado> tempce = CargoDao.findCargo_empleadoEntities();
        String auxCargoEmp = null;
        for(Empleado cc : temp){
            for(Persona p : tempo){
                if(p.getId_persona()==cc.getId_Persona()){
                    auxNombre=(p.getNombre());
                    auxApellido=(p.getApellido());
                    auxDireccion=(p.getDireccion());
                    auxCorreo=p.getCorreo_electroncio();
                    auxTelefono=p.getTelefono();
                    auxDocumento=p.getDocumento_id();
                    auxfecha=(cc.getFecha_ingreso().substring(8, 10)+"/"+cc.getFecha_ingreso().substring(5, 7)+"/"+cc.getFecha_ingreso().substring(0, 4));
                    for(Tipo_Documento tp : temp2){
                if(tp.getId_Tipo_Documento() == p.getID_tipo_documento()){
                    aux1=(tp.getId_Tipo_Documento()+". "+tp.getDocumento());
                }
            }
                    }
                for(HistoricoCargo_empleado hce : tempc){
                if(hce.getId_empleado() == cc.getId_Empleado()){
                    if(hce.getFecha_final()==null){
                        auxCargo=(hce.getId_cargo());
                        }
                    for(Cargo_empleado tp : tempce){
                    if(tp.getId_cargo()== hce.getId_cargo()){
                    auxCargoEmp=(hce.getId_cargo()+". "+tp.getCargo());
                        }   
                    }
                }
                    }
                    
            for(HistoricoSueldo_empleado hse : temp3){
                if(hse.getId_empleado() == cc.getId_Empleado()){
                    if(hse.getFecha_final()==null){
                        auxSueldo=hse.getSueldo();
                        }
                    }
                }
            
            }

            modelo.addRow(
                    new Object[]{
                        cc.getId_Empleado(),
                        auxNombre,
                        auxApellido,
                        auxTelefono,
                        auxDireccion,
                        auxCorreo,
                        auxfecha,
                        aux1,
                        auxDocumento,
                        auxCargoEmp,
                        auxSueldo,
                        cc.isEstado()? "Activo" : "Inactivo",
                        //(cc.isEstado())?"Activo":"Inactivo"
                      
            });  
    }
        }
        public void createComboBoxNuevoCargo(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        cmbIDNuevoCargo.setModel(modelo);
        List<Cargo_empleado> temp = CargoDao.findCargo_empleadoEntities();
        modelo.addElement("Nuevo");
        temp.forEach((tp) -> {
        modelo.addElement(tp.getId_cargo());
        });
        
    }
        
        public void createTableNuevoCargo(){
        DefaultTableModel modelo = new DefaultTableModel();
        tblNuevoCargo.setModel(modelo);
        modelo.addColumn("ID Cargo");
        modelo.addColumn("Nuevo Cargo");
        modelo.addColumn("Estado");
        
        List<Cargo_empleado> temp = CargoDao.findCargo_empleadoEntities();
        
        for(Cargo_empleado tp : temp)
            modelo.addRow(
                    new Object[]{
                        tp.getId_cargo(),
                        tp.getCargo(),
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

        Tab_Empleado = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        cmbIDEmpleado1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbTipoDocumentoEmpleado = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtaDirec = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        btnAgregar1 = new javax.swing.JButton();
        btnModificar1 = new javax.swing.JButton();
        btnLimpiar1 = new javax.swing.JButton();
        btnDesactivar1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        btnSalir1 = new javax.swing.JButton();
        btnRegresar1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cmbCargoEmpleado = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtSueldo = new javax.swing.JTextField();
        btnBuscar1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnRegresar2 = new javax.swing.JButton();
        btnSalir2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblNuevoCargo = new javax.swing.JTable();
        btnAgregar2 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        cmbIDNuevoCargo = new javax.swing.JComboBox<>();
        txtNuevoCargo = new javax.swing.JTextField();
        btnModificar2 = new javax.swing.JButton();
        btnLimpiar2 = new javax.swing.JButton();
        btnDesactivar2 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtIDUsuario = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tbl_Usuarios = new javax.swing.JTable();
        cmbIDEmpleado = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnDesactivar = new javax.swing.JButton();
        txtContraseña = new javax.swing.JPasswordField();
        txtConfirmarContraseña = new javax.swing.JPasswordField();
        jLabel30 = new javax.swing.JLabel();
        txtIDNombreEmpleado = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblHistorialSueldo = new javax.swing.JTable();
        btnRegresar3 = new javax.swing.JButton();
        btnSalir3 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtEmpleadoSueldo = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btnRegresar4 = new javax.swing.JButton();
        btnSalir4 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTbHistorialCargo = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtEmpleadoCargo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Tab_Empleado.setBackground(new java.awt.Color(0, 204, 204));
        Tab_Empleado.setForeground(new java.awt.Color(255, 255, 255));
        Tab_Empleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tab_EmpleadoMouseClicked(evt);
            }
        });

        cmbIDEmpleado1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDEmpleado1ItemStateChanged(evt);
            }
        });
        cmbIDEmpleado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIDEmpleado1ActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("ID Empleado:");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre:");

        txtNombre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombre1KeyTyped(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Apellidos:");

        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Teléfono:");

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

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Correo electrónico:");

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

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Tipo Documento:");

        cmbTipoDocumentoEmpleado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipoDocumentoEmpleadoItemStateChanged(evt);
            }
        });

        txtaDirec.setColumns(20);
        txtaDirec.setRows(5);
        txtaDirec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtaDirecKeyTyped(evt);
            }
        });
        jScrollPane4.setViewportView(txtaDirec);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Documento:");

        txtDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocumentoKeyTyped(evt);
            }
        });

        btnAgregar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar1.setText("Agregar");
        btnAgregar1.setBorder(null);
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

        jScrollPane2.setBackground(new java.awt.Color(102, 204, 0));

        tblEmpleados.setBackground(new java.awt.Color(102, 204, 0));
        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
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
        tblEmpleados.setGridColor(new java.awt.Color(0, 0, 0));
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblEmpleados);

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

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Dirección:");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Empleados");

        cmbCargoEmpleado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCargoEmpleadoItemStateChanged(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Cargo:");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Sueldo:");

        txtSueldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSueldoKeyTyped(evt);
            }
        });

        btnBuscar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        btnBuscar1.setText("Buscar");
        btnBuscar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnRegresar1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(630, 630, 630)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalir1))
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
                                            .addComponent(cmbIDEmpleado1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtNombre1, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                                .addComponent(txtApellidos, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtTel, javax.swing.GroupLayout.Alignment.TRAILING))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(369, 369, 369)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbTipoDocumentoEmpleado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscar1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbCargoEmpleado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregar1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar1)
                        .addGap(18, 18, 18)
                        .addComponent(btnDesactivar1)))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir1))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cmbIDEmpleado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(jLabel6)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbCargoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbTipoDocumentoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar1)
                    .addComponent(btnDesactivar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegresar1)
                .addContainerGap(299, Short.MAX_VALUE))
        );

        Tab_Empleado.addTab("Empleados", jPanel1);

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

        jScrollPane5.setBackground(new java.awt.Color(102, 204, 0));

        tblNuevoCargo.setBackground(new java.awt.Color(102, 204, 0));
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
        tblNuevoCargo.setGridColor(new java.awt.Color(0, 0, 0));
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

        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Nuevo Cargo:");

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("ID del Cargo:");

        cmbIDNuevoCargo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDNuevoCargoItemStateChanged(evt);
            }
        });

        txtNuevoCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNuevoCargoKeyTyped(evt);
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

        jLabel29.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Ingresar Nuevo Cargo");

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
                                    .addComponent(cmbIDNuevoCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNuevoCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(btnDesactivar2)))
                .addGap(894, 894, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegresar2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(419, 419, 419)
                        .addComponent(btnSalir2)))
                .addGap(137, 137, 137))
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
                            .addComponent(cmbIDNuevoCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNuevoCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnAgregar2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnModificar2)
                            .addComponent(btnLimpiar2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar2))))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(btnRegresar2)
                .addGap(292, 292, 292))
        );

        Tab_Empleado.addTab("Cargos", jPanel3);

        jPanel4.setBackground(new java.awt.Color(0, 255, 255));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Usuarios");

        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Empleado:");

        txtIDUsuario.setEditable(false);
        txtIDUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIDUsuarioFocusLost(evt);
            }
        });

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("ID Usuario: ");

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Nombre de Usuario:");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("Contraseña:");

        Tbl_Usuarios.setModel(new javax.swing.table.DefaultTableModel(
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
                "ID Empleado", "ID USuario", "Usuario", "Contraseña", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Tbl_Usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tbl_UsuariosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Tbl_Usuarios);

        cmbIDEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIDEmpleadoActionPerformed(evt);
            }
        });

        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel36.setText("Confirmar contraseña:");

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

        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("Nombre Empleado:");

        txtIDNombreEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDNombreEmpleadoActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificar)
                        .addGap(6, 6, 6)
                        .addComponent(btnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDesactivar))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIDNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIDUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbIDEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre)
                            .addComponent(txtContraseña)
                            .addComponent(txtConfirmarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(201, 700, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegresar))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(570, 570, 570)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir)))
                .addGap(132, 132, 132))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIDUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(cmbIDEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtIDNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(txtConfirmarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnDesactivar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btnRegresar)
                .addGap(298, 298, 298))
        );

        Tab_Empleado.addTab("Usuarios", jPanel4);

        tblHistorialSueldo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(tblHistorialSueldo);

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

        jLabel16.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Historial de Sueldos del Empleado");

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Empleado:");

        txtEmpleadoSueldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpleadoSueldoActionPerformed(evt);
            }
        });
        txtEmpleadoSueldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmpleadoSueldoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 468, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnRegresar3)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGap(361, 361, 361)
                                        .addComponent(btnSalir3)))))
                        .addGap(135, 135, 135))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEmpleadoSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir3))
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtEmpleadoSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                .addComponent(btnRegresar3)
                .addGap(287, 287, 287))
        );

        Tab_Empleado.addTab("Historial de Sueldos", jPanel2);

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

        jTbHistorialCargo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(jTbHistorialCargo);

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Empleado:");

        jLabel17.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Historial de Cargos del Empleado");

        txtEmpleadoCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpleadoCargoActionPerformed(evt);
            }
        });
        txtEmpleadoCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmpleadoCargoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 426, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnRegresar4)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(423, 423, 423)
                                        .addComponent(btnSalir4)))))
                        .addGap(139, 139, 139))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEmpleadoCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir4))
                .addGap(54, 54, 54)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtEmpleadoCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 223, Short.MAX_VALUE)
                .addComponent(btnRegresar4)
                .addGap(295, 295, 295))
        );

        Tab_Empleado.addTab("Historial de Cargos", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tab_Empleado, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tab_Empleado, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

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

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        Empleado tempopp;
        tempopp = Empleadodao.findEmpleado(cmbIDEmpleado.getSelectedIndex());
        if(tempopp.isEstado()!=true){
            JOptionPane.showMessageDialog(null,"El Empleado seleccionado esta Inactivo","Error!", JOptionPane.ERROR_MESSAGE); 
            return;
        }
        else{
            
        }
       Usuarios usu = new  Usuarios();
        
        
        String Contrasenia = txtContraseña.getText();
        String ConfirmarContrasenia = txtConfirmarContraseña.getText();
        
        
        
        
        //Validacion de nombre de usuario
        boolean bandera = false;
        
        List<Usuarios> temporal = UsuariosDao.findUsuariosEntities();
        for(Usuarios sus : temporal){
            if(sus.getId_Nombre().equals(txtNombre.getText()))
            {
                bandera=true;
            }
        }
        
        if(bandera){
            JOptionPane.showMessageDialog(null, "Nombre de usuario no disponible \n Ingrese otro nombre de usuario","Nombre de Usuario Invalido",JOptionPane.ERROR_MESSAGE);
            return ;
        }
        
        Pattern pat = Pattern.compile("(.* .*|.*:.*)");
        Matcher mat = pat.matcher(txtNombre.getText());
        
        if(mat.matches()){
            JOptionPane.showMessageDialog(null, "No puede haber espacios en nombre de usuario","ERROR",JOptionPane.ERROR_MESSAGE);
            return;
        }
        Empleado tempop;
        tempop = Empleadodao.findEmpleado(cmbIDEmpleado.getSelectedIndex());
        if(tempop.isEstado()!=true){
            JOptionPane.showMessageDialog(null,"El empleado seleccionado esta Desactivado","Error!", JOptionPane.ERROR_MESSAGE); 
            return;
        }
        else{
            
        }
        
        //Fin de validacion de nombre de usuario
        
        if("".equals(Contrasenia)){
            JOptionPane.showMessageDialog(null, "La contraseña no puede ir vacia \n Ingrese una contraseña","Contraseña",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        if (Contrasenia.equals(ConfirmarContrasenia))
        {
           String NuevaContraseña = Hash.getHash(Contrasenia);
            
            usu.setId_Empleado(cmbIDEmpleado.getSelectedIndex());
            usu.setId_Nombre(txtNombre.getText());
            usu.setContraseña(NuevaContraseña);
            
            usu.setEstado(true);
            try {
            UsuariosDao.create(usu);
        } catch (Exception ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            //NUEVO
            JOptionPane.showMessageDialog(null,"Datos Guardados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE);
            createTableUsuario();
            limpiar();
            btnAgregar.setEnabled(true);
            btnModificar.setEnabled(false);
            //FIN NUEVO
            
            
        } else {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
            return;
            
        }
        
        
        
        
        /* 
        Usuarios usu = new  Usuarios();
        
        
        String Contraseña = new String(txtContraseña.getText());
        String ConfirmarContraseña = new String(txtConfirmarContraseña.getText());
        
        if (Contraseña.equals(ConfirmarContraseña))
        {
            String NuevaContraseña = Hash.sha1(Contraseña);
            
            usu.setId_Usuario(Integer.parseInt(txtIDUsuario.getText()));
            usu.setId_Empleado(Integer.parseInt(cmbIDEmpleado.getSelectedItem().toString()));
            usu.setId_Nombre(txtNombre.getText());
            usu.setContraseña(txtContraseña.getText());
            usu.setContraseña(txtConfirmarContraseña.getText());
            
        } else {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
            
        }
        
        try {
            UsuariosDao.create(usu);
        } catch (Exception ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }//GEN-LAST:event_btnAgregarActionPerformed

     public void limpiar(){
        txtIDUsuario.setText("");
        txtNombre.setText("");
        txtContraseña.setText("");
        txtIDNombreEmpleado.setText("");
        txtIDNombreEmpleado.setEnabled(true);
        txtConfirmarContraseña.setText("");
        cmbIDEmpleado.setSelectedIndex(0);
        btnDesactivar.enable(false);
        
    }
    
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
         
        Usuarios usu = new  Usuarios();
        
        
        String Contraseña = new String(txtContraseña.getText());
        String ConfirmarContraseña = new String(txtConfirmarContraseña.getText());
        
        //Validacion de nombre de usuario
        Empleado tempop;
        tempop = Empleadodao.findEmpleado(cmbIDEmpleado.getSelectedIndex());
        if(tempop.isEstado()!=true){
            JOptionPane.showMessageDialog(null,"El empleado seleccionado esta Inactivo","Error!", JOptionPane.ERROR_MESSAGE); 
            return;
        }
        else{
            
        }
        
        Pattern pat = Pattern.compile("(.* .*|.*:.*)");
        Matcher mat = pat.matcher(txtNombre.getText());
        
        if(mat.matches()){
            JOptionPane.showMessageDialog(null, "No puede haber espacios en nombre de usuario","ERROR",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //Fin de validacion de nombre de usuario
        

        //NUEVA VALIDACION
        if("".equals(Contraseña)){
            JOptionPane.showMessageDialog(null, "La contraseña no puede ir vacia \n Ingrese una contraseña","Contraseña",JOptionPane.ERROR_MESSAGE);
            return;
        }
        //FIN NUEVA VALIDACION
        
        
        
        if (Contraseña.equals(ConfirmarContraseña))
        {
            String NuevaContraseña = Hash.getHash(Contraseña);
            
            usu.setId_Usuario(Integer.parseInt(txtIDUsuario.getText()));
            usu.setId_Empleado(cmbIDEmpleado.getSelectedIndex());
            usu.setId_Nombre(txtNombre.getText());
            usu.setContraseña(NuevaContraseña); //CAMBIO DE TXT A NuevaContraseña
            
            usu.setEstado(UsuariosDao.findUsuarios(Integer.parseInt(txtIDUsuario.getText())).isEstado()); //NUEVO
            //usu.setContraseña(txtConfirmarContrasenia.getText());
            
        } else {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden","",JOptionPane.ERROR_MESSAGE);
            return;
            
        }
        
        try {
            UsuariosDao.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null,"Datos Modificados exitosamente","Modificado",JOptionPane.PLAIN_MESSAGE);
        //txtNombre.setEditable(true);
        createTableUsuario();  //NUEVO
        btnAgregar.setEnabled(true);
        btnModificar.setEnabled(false);

        // TODO add your handling code here:
        /*Usuarios usu = new  Usuarios();
        
        
        String Contraseña = new String(txtContraseña.getText());
        String ConfirmarContraseña = new String(txtConfirmarContraseña.getText());
        
        if (Contraseña.equals(ConfirmarContraseña))
        {
            String NuevaContraseña = Hash.sha1(Contraseña);
            
            usu.setId_Usuario(Integer.parseInt(txtIDUsuario.getText()));
            usu.setId_Empleado(Integer.parseInt(cmbIDEmpleado.getSelectedItem().toString()));
            usu.setId_Nombre(txtNombre.getText());
            usu.setContraseña(txtContraseña.getText());
            usu.setContraseña(txtConfirmarContraseña.getText());
            
        } else {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
            
        }
        
        try {
            UsuariosDao.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        
        limpiar();
        btnAgregar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnDesactivar.setEnabled(false);
        btnBuscar.setEnabled(true);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarActionPerformed
        Usuarios temp;
        temp = UsuariosDao.findUsuarios(Integer.parseInt(txtIDUsuario.getText()));
        //temp = piezaDao.findPieza(txtIDPieza.getSelectedIndex()+1);
        //JOptionPane.showMessageDialog(null, temp.isEstado());
        if(temp.isEstado()){
            temp.setEstado(false);
            JOptionPane.showMessageDialog(null,"Usuario Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE);
        }
        else{
            temp.setEstado(true);
            JOptionPane.showMessageDialog(null,"Usuario Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE);
        }
        try {
            UsuariosDao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
        }
        createTableUsuario();
        btnActivarDesactivarUsuario();
        btnDesactivar.setEnabled(false);
        btnAgregar.setEnabled(true);
        btnModificar.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDesactivarActionPerformed

    private void Tbl_UsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tbl_UsuariosMouseClicked
       btnAgregar.setEnabled(false);
       btnModificar.setEnabled(true);
       btnBuscar.setEnabled(false);
       txtIDNombreEmpleado.setEnabled(false);
       int fila = Tbl_Usuarios.getSelectedRow();
       if (fila > -1){
       Usuarios temp = UsuariosDao.findUsuarios(Integer.parseInt(Tbl_Usuarios.getModel().getValueAt(fila, 0).toString()));
       List<Empleado> tempc = Empleadodao.findEmpleadoEntities();
       List<Persona> tempp = Personadao.findPersonaEntities();
       for (Empleado cc : tempc) {
                        if(temp.getId_Empleado()==cc.getId_Empleado()){
                            for (Persona pp : tempp) {
                                if(pp.getId_persona()==cc.getId_Persona()){
                                    txtIDUsuario.setText(String.valueOf(temp.getId_Usuario()));
                                    cmbIDEmpleado.setSelectedIndex(cc.getId_Empleado());
                                    txtNombre.setText((temp.getId_Nombre()));
                                    txtIDNombreEmpleado.setText(pp.getNombre()+" "+pp.getApellido());
                                } else {
                                    
                                }
                            }
                        }

       
       btnActivarDesactivarUsuario();
       }
       }
    }//GEN-LAST:event_Tbl_UsuariosMouseClicked

    private void Tab_EmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tab_EmpleadoMouseClicked
        // TODO add your handling code here:
        /*if(Tab_Empleado.getSelectedIndex()==1)
        {    
            DefaultTableModel modelo = new DefaultTableModel();
            Tbl_Usuarios.setModel(modelo);
            modelo.addColumn("Numero de Identidad");
            modelo.addColumn("Nombre");
            modelo.addColumn("Telefono");
            modelo.addColumn("Direccion");
            
        
            List<Usuarios> usuario = UsuariosDao.findUsuariosEntities();
        
            for(Usuarios usu : usuario){
                modelo.addRow(
                    new Object[]{
                        usu.getId_Usuario(),
                        usu.getId_Empleado(),
                        usu.getId_Nombre(),
                        usu.getContraseña(),
                        usu.getContraseña()
                        
                    }
                );
            }    
        }else if (Tab_Empleado.getSelectedIndex()== 0)
             txtNombre.requestFocus();
        */
    }//GEN-LAST:event_Tab_EmpleadoMouseClicked

    private void txtIDUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDUsuarioFocusLost
        // TODO add your handling code here:
       /* Usuarios usu = new Usuarios();
        usu = UsuariosDao.findUsuarios(Integer.parseInt(txtIDUsuario.getText()));
        if (usu==null){
            usu.setId_Empleado(Integer.parseInt(cmbIDEmpleado.getSelectedItem().toString()));
            cmbIDEmpleado.setSelectedItem("");
            txtNombre.setText("");
            txtContraseña.setText("");
            txtConfirmarContraseña.setText("");
            
            btnAgregar.setEnabled(true);
            btnBuscar.setEnabled(false);
            btnModificar.setEnabled(false);
            btnLimpiar.setEnabled(false);
            
        }else{
            usu.setId_Usuario(Integer.parseInt(txtIDUsuario.getText()));
            usu.setId_Usuario(Integer.parseInt(txtIDUsuario.getText()));
            txtIDUsuario.setText(String.valueOf(usu.getId_Usuario()));
            cmbIDEmpleado.setSelectedItem(usu.getId_Empleado());
            txtNombre.setText(usu.getId_Nombre());
            txtContraseña.setText(usu.getContraseña());
            txtConfirmarContraseña.setText(usu.getContraseña());
            
            btnAgregar.setEnabled(false);
            btnBuscar.setEnabled(true);
            btnModificar.setEnabled(true);
            btnLimpiar.setEnabled(true);
        }*/
        
    }//GEN-LAST:event_txtIDUsuarioFocusLost

    private void cmbIDEmpleado1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDEmpleado1ItemStateChanged
       /* if(cmbIDEmpleado1.getSelectedIndex()==0){
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
            p=Personadao.findPersona(cmbIDEmpleado1.getSelectedIndex());

            txtNombre.setText(p.getNombre());
            txtApellidos.setText(p.getApellido());
            txtTel.setText(p.getTelefono());
            txtaDirec.setText(p.getDireccion());
            txtCorreo.setText(p.getCorreo_electroncio());
            cmbTipoDocumentoCli.setSelectedIndex(p.getID_tipo_documento()-1);
            txtDocumento.setText(p.getDocumento_id());
            List<Empleado> c = Empleadodao.findEmpleadoEntities();
            for(Empleado c1 : c){
                if(c1.getId_Persona() == p.getId_persona()){
                    if(c1.getFecha_ingreso()==null){

                        break;
                    }
                    else{
                    }
                }
                btnActivarDesactivarEmpleado();

            }
        }*/
    }//GEN-LAST:event_cmbIDEmpleado1ItemStateChanged

    private void cmbIDEmpleado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIDEmpleado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIDEmpleado1ActionPerformed

    private void txtNombre1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre1KeyTyped
        char validar=evt.getKeyChar();
        if((validar<'a'||validar>'z')&& (validar<'A' || validar>'Z') && (validar!=(char)KeyEvent.VK_BACKSPACE) && (validar!=(char)KeyEvent.VK_SPACE)){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Solo se admiten letras para el nombre del cliente","Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtNombre1KeyTyped

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        char validar=evt.getKeyChar();
        if((validar<'a'||validar>'z')&& (validar<'A' || validar>'Z') && (validar!=(char)KeyEvent.VK_BACKSPACE) && (validar!=(char)KeyEvent.VK_SPACE)){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Solo se admiten letras para el apellido del cliente","Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtApellidosKeyTyped

    private void txtTelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelFocusLost
        /*
        if (telefono(txtTel.getText())){
        }else{
            JOptionPane.showMessageDialog(null,"Formato de Telefono incorrecto debe comenzar con 3,8 o 9","Error!", JOptionPane.ERROR_MESSAGE);
            txtTel.requestFocus();
        }*/

    }//GEN-LAST:event_txtTelFocusLost

    private void txtTelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelKeyTyped
        char validar=evt.getKeyChar();
        if((validar<'0'||validar>'9')){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Solo se admiten números para el teléfono del cliente","Error!", JOptionPane.ERROR_MESSAGE);
        }else{
        }
    }//GEN-LAST:event_txtTelKeyTyped
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
    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost
        if (correo(txtCorreo.getText())){
        }else{
            JOptionPane.showMessageDialog(null,"Formato de correo electrónico incorrecto","Error!", JOptionPane.ERROR_MESSAGE);
            txtCorreo.requestFocus();
        }
    }//GEN-LAST:event_txtCorreoFocusLost

    private void txtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyTyped

    }//GEN-LAST:event_txtCorreoKeyTyped

    private void cmbTipoDocumentoEmpleadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipoDocumentoEmpleadoItemStateChanged

        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoDocumentoEmpleadoItemStateChanged

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

    private void btnAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar1ActionPerformed

        if(cmbIDEmpleado1.getSelectedIndex()==0){

        }
        else{
            cmbIDEmpleado1.setSelectedIndex(0);
        }
        if("".equals(txtNombre1.getText()) || txtNombre1.getText().length()>25){
            JOptionPane.showMessageDialog(null, "Ingrese la cantidad necesaria de carateres para el nombre del empleado","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        if (ValidacionTresletras(txtNombre1.getText())){
                JOptionPane.showMessageDialog(null,"No se Admite en el nombre del Empleado la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        txtNombre1.requestFocus(); 
                        return;
                    }else{
                        
                     }
        if("".equals(txtApellidos.getText()) || txtApellidos.getText().length()>25) {
            JOptionPane.showMessageDialog(null, "Ingrese la cantidad necesaria de carateres para el apellido del empleado","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
        }
        if (ValidacionTresletras(txtApellidos.getText())){ 
               JOptionPane.showMessageDialog(null,"No se Admite en el apellido del Empleado la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        txtApellidos.requestFocus(); 
                        return;
                    }else{
                        
                     }
        if("".equals(txtTel.getText()) || txtTel.getText().length()>10){
            JOptionPane.showMessageDialog(null,"Ingrese la cantidad necesaria de caracteres para el teléfono del empleado","Error!", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null,"Ingrese la cantidad necesaria de caracteres para la dirección del empleado","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        if (ValidacionTresletras(txtaDirec.getText())){ 
               JOptionPane.showMessageDialog(null,"No se Admite en la dirección del Empleado la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        txtaDirec.requestFocus(); 
                        return;
                    }else{
                        
                     }
        if("".equals(txtCorreo.getText()) || txtCorreo.getText().length()>30){
            JOptionPane.showMessageDialog(null, "Ingrese la cantidad necesaria de caracteres para el correo electrónico del empleado","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        Cargo_empleado tempopp;
        tempopp = CargoDao.findCargo_empleado(cmbCargoEmpleado.getSelectedIndex());
        if(tempopp.isEstado()!=true){
            JOptionPane.showMessageDialog(null,"El cargo seleccionado esta Desactivado","Error!", JOptionPane.ERROR_MESSAGE); 
            return;
        }
        else{
            
        }
        Tipo_Documento tempop;
        tempop = TipoDocumentodao.findTipo_Documento(cmbTipoDocumentoEmpleado.getSelectedIndex());
        if(tempop.isEstado()!=true){
            JOptionPane.showMessageDialog(null,"Este tipo de documento esta Desactivado","Error!", JOptionPane.ERROR_MESSAGE); 
            return;
        }
        else{
            
        }
         if (!ValidacionSueldo(txtSueldo.getText())){
           JOptionPane.showMessageDialog(null,"El Sueldo del Empleado solo puede contener Números positivos","Error!", JOptionPane.ERROR_MESSAGE);
           txtSueldo.requestFocus();
           return;
            }else{
           
            }
        int aux=14;
        switch (cmbTipoDocumentoEmpleado.getSelectedItem().toString().toLowerCase()) {
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
        if(txtDocumento.getText().length()>aux || txtDocumento.getText().length()==0 || txtDocumento.getText().length()<aux){
            //JOptionPane.showMessageDialog(null, "Ingrese la cantidad necesaria de dígitos del Documento del empleado","Error!", JOptionPane.ERROR_MESSAGE);
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
                temp.setNombre(txtNombre1.getText());
                temp.setApellido(txtApellidos.getText());
                temp.setTelefono(txtTel.getText());
                temp.setDireccion(txtaDirec.getText());
                temp.setCorreo_electroncio(txtCorreo.getText());
                temp.setID_tipo_documento(cmbTipoDocumentoEmpleado.getSelectedIndex());
                temp.setDocumento_id(txtDocumento.getText());
                try {
                    Personadao.create(temp);
                } catch (Exception ex) {
                    Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
                }
                Empleado tempp = new Empleado();
                tempp.setEstado(true);
                Calendar fecha = new GregorianCalendar();
                tempp.setId_Persona(Personadao.getPersonaCount());
                tempp.setId_Empleado(Empleadodao.getEmpleadoCount()+1);

                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+aux2+aux3;
                tempp.setFecha_ingreso(fecha1);

                try {
                    Empleadodao.create(tempp);
                } catch (Exception ex) {
                    Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                
           HistoricoCargo_empleado temphc2 = new HistoricoCargo_empleado();
           temphc2.setEstado(true);
           temphc2.setId_cargo_historico(HistoricoCargoDao.getHistoricoCargo_empleadoCount());
           Calendar fechace = new GregorianCalendar();
           String fechace1;
           String auxce1,auxce2,auxce3;
           auxce1 = Integer.toString(fechace.get(Calendar.YEAR));
           auxce2 = (fechace.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fechace.get(Calendar.MONTH)+1)) : Integer.toString(fechace.get(Calendar.MONTH));
           auxce3 = (fechace.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fechace.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fechace.get(Calendar.DAY_OF_MONTH));
           fechace1 = auxce1+auxce2+auxce3;
           temphc2.setFecha_inicial(fechace1);
           temphc2.setId_empleado(Empleadodao.getEmpleadoCount());
           temphc2.setId_cargo(cmbCargoEmpleado.getSelectedIndex());
           try {
           HistoricoCargoDao.create(temphc2);
           }catch  (Exception ex){
               Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
           }
           HistoricoSueldo_empleado temphs2 = new HistoricoSueldo_empleado();
           temphs2.setEstado(true);
           temphs2.setId_sueldo(HistoricoSueldoDao.getHistoricoSueldo_empleadoCount());
           Calendar fechase = new GregorianCalendar();
           String fechase1;
           String auxse1,auxse2,auxse3;
           auxse1 = Integer.toString(fechase.get(Calendar.YEAR));
           auxse2 = (fechase.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fechase.get(Calendar.MONTH)+1)) : Integer.toString(fechase.get(Calendar.MONTH));
           auxse3 = (fechase.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fechase.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fechase.get(Calendar.DAY_OF_MONTH));
           fechase1 = auxse1+auxse2+auxse3;
           temphs2.setFecha_inicial(fechase1);
           temphs2.setId_empleado(Empleadodao.getEmpleadoCount());
           double auxsueldo=(Double.parseDouble(txtSueldo.getText().trim()));
           
           temphs2.setSueldo(auxsueldo);
           try {
           HistoricoSueldoDao.create(temphs2);
           }catch  (Exception ex){
               Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
           }
            }
            
                
                JOptionPane.showMessageDialog(null,"Datos Guardados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE);
                createTableEmpleado();
                btnAgregar1.setEnabled(true);
                btnModificar1.setEnabled(false);
            }
        
    }//GEN-LAST:event_btnAgregar1ActionPerformed

    private void btnModificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar1ActionPerformed
if("".equals(txtNombre1.getText()) || txtNombre1.getText().length()>25){
            JOptionPane.showMessageDialog(null, "Ingrese la cantidad necesaria de caracteres para el nombre del empleado","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
if (ValidacionTresletras(txtNombre1.getText())){
                JOptionPane.showMessageDialog(null,"No se Admite en el nombre del Empleado la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        txtNombre1.requestFocus(); 
                        return;
                    }else{
                        
                     }
        if("".equals(txtApellidos.getText()) || txtApellidos.getText().length()>25) {
            JOptionPane.showMessageDialog(null, "Ingrese la cantidad necesaria de caracteres para el apellido del empleado","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
        }
if (ValidacionTresletras(txtApellidos.getText())){ 
               JOptionPane.showMessageDialog(null,"No se Admite en el apellido del Empleado la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        txtApellidos.requestFocus(); 
                        return;
                    }else{
                        
                     }
        
        if (!telefono(txtTel.getText())){
           JOptionPane.showMessageDialog(null,"Formato de teléfono incorrecto debe comenzar con 2, 3, 7, 8 o 9","Error!", JOptionPane.ERROR_MESSAGE);
           txtTel.requestFocus();
           return;
            }else{
           
            }
        if("".equals(txtTel.getText()) || txtTel.getText().length()>10){
            JOptionPane.showMessageDialog(null,"Ingrese la cantidad necesaria de caracteres para el teléfono del empleado","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        if (ValidacionTresletras(txtaDirec.getText())){ 
               JOptionPane.showMessageDialog(null,"No se Admite en la dirección del Empleado la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                        txtaDirec.requestFocus(); 
                        return;
                    }else{
                        
                     }
        if("".equals(txtaDirec.getText()) || txtaDirec.getText().length()>50){
            JOptionPane.showMessageDialog(null,"Ingrese la cantidad necesaria de caracteres para la dirección del empleado","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        if("".equals(txtCorreo.getText()) || txtCorreo.getText().length()>30){
            JOptionPane.showMessageDialog(null, "Ingrese la cantidad necesaria de caracteres para el correo electrónico del empleado","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        Cargo_empleado tempopp;
        tempopp = CargoDao.findCargo_empleado(cmbCargoEmpleado.getSelectedIndex());
        if(tempopp.isEstado()!=true){
            JOptionPane.showMessageDialog(null,"El cargo seleccionado esta Desactivado","Error!", JOptionPane.ERROR_MESSAGE); 
            return;
        }
        else{
            
        }
        
        Tipo_Documento tempop;
        tempop = TipoDocumentodao.findTipo_Documento(cmbTipoDocumentoEmpleado.getSelectedIndex());
        if(tempop.isEstado()!=true){
            JOptionPane.showMessageDialog(null,"El tipo de documento seleccionado esta Desactivado","Error!", JOptionPane.ERROR_MESSAGE); 
            return;
        }
        else{
            
        }
         if (!ValidacionSueldo(txtSueldo.getText())){
           JOptionPane.showMessageDialog(null,"El Sueldo del Empleado solo puede contener Números positivos","Error!", JOptionPane.ERROR_MESSAGE);
           txtSueldo.requestFocus();
           return;
            }else{
           
            }
        int aux=14;
        switch (cmbTipoDocumentoEmpleado.getSelectedItem().toString().toLowerCase()) {
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
        if(txtDocumento.getText().length()>aux || txtDocumento.getText().length()==0 || txtDocumento.getText().length()<aux){
            //JOptionPane.showMessageDialog(null, "Ingrese la cantidad necesaria de dígitos del Documento del empleado","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }

            else{
                Persona temp = new Persona();
                List<Persona> e = Personadao.findPersonaEntities();
                int auxCmb=cmbIDEmpleado1.getSelectedIndex();
           List<Empleado> f = Empleadodao.findEmpleadoEntities();
           for(Persona a : e){
               for(Empleado t : f){
                    if(a.getId_persona()==t.getId_Persona() && t.getId_Empleado()==auxCmb) {
                        temp.setId_persona(a.getId_persona());
                    } else {
                    }
                        }
               
           }
                temp.setNombre(txtNombre1.getText());
                temp.setApellido(txtApellidos.getText());
                temp.setTelefono(txtTel.getText());
                temp.setDireccion(txtaDirec.getText());
                temp.setCorreo_electroncio(txtCorreo.getText());
                temp.setID_tipo_documento(cmbTipoDocumentoEmpleado.getSelectedIndex());
                temp.setDocumento_id(txtDocumento.getText());
                //JOptionPane.showMessageDialog(null,temp.getId_persona());
                try {
                    Personadao.edit(temp);
                } catch (Exception ex) {
                    Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                Empleado tempp = new Empleado();
                //tempp.setEstado(true);
                //JOptionPane.showMessageDialog(null,auxCmb);
                tempp=Empleadodao.findEmpleado(auxCmb);
                 
               // JOptionPane.showMessageDialog(null,tempp.getId_Empleado());
                 //JOptionPane.showMessageDialog(null,temp.getId_persona());
                try {
                    Empleadodao.edit(tempp);
                } catch (Exception ex) {
                    Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
                }
           List<HistoricoCargo_empleado> t1 = HistoricoCargoDao.findHistoricoCargo_empleadoEntities();
           HistoricoCargo_empleado temphc2 = new HistoricoCargo_empleado();
           for(HistoricoCargo_empleado  t : t1){
               if(t.getId_empleado() == auxCmb){
                    if(t.getFecha_final()==null){
                        temphc2= t;    
                    }  
                }
           }
           if(temphc2.getId_cargo()!= (cmbCargoEmpleado.getSelectedIndex())){
           Calendar fecha = new GregorianCalendar();
           String fecha1;
            int menos=1;
           String restar="";
           int pasar=0;
           String aux1,aux2,aux3;
           aux1 = Integer.toString(fecha.get(Calendar.YEAR));
           aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.MONTH)+1) : Integer.toString(fecha.get(Calendar.MONTH));
           aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
           pasar=(Integer.parseInt(aux3));
           restar=String.valueOf(pasar-menos);
           fecha1 = aux1+aux2+restar;
           temphc2.setEstado(false);
           temphc2.setFecha_final((fecha1));
           //temphc2.setId_cargo((cmbCargoEmpleado.getSelectedIndex()));
           temphc2.setId_cargo(temphc2.getId_cargo());//=HistoricoCargoDao.findHistoricoCargo_empleado(temphc2.getId_cargo());
        try {
            HistoricoCargoDao.edit(temphc2);
        } catch (Exception ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
           HistoricoCargo_empleado temphc3 = new HistoricoCargo_empleado();
           temphc3.setEstado(true);
           temphc3.setId_cargo_historico(HistoricoCargoDao.getHistoricoCargo_empleadoCount());
           Calendar fecha22 = new GregorianCalendar();
           String fecha11;
           String aux11,aux22,aux33;
           aux11 = Integer.toString(fecha22.get(Calendar.YEAR));
           aux22 = (fecha22.get(Calendar.MONTH)<10)? "0"+Integer.toString(fecha22.get(Calendar.MONTH)+1) : Integer.toString(fecha22.get(Calendar.MONTH));
           aux33 = (fecha22.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha22.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha22.get(Calendar.DAY_OF_MONTH));
           fecha11 = aux11+aux22+aux33;
           temphc3.setFecha_inicial(fecha11);
           temphc3.setId_cargo(cmbCargoEmpleado.getSelectedIndex());
           temphc3.setId_empleado(auxCmb);
           
           JOptionPane.showMessageDialog(null,temphc3.getId_empleado());
          
           
            try {
            HistoricoCargoDao.create(temphc3);
        } catch (Exception ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
           }

           HistoricoSueldo_empleado temphs2 = new HistoricoSueldo_empleado();
            List<HistoricoSueldo_empleado> t2 = HistoricoSueldoDao.findHistoricoSueldo_empleadoEntities();
           for(HistoricoSueldo_empleado  tt : t2){
               if(tt.getId_empleado() == cmbIDEmpleado1.getSelectedIndex()){
                    if(tt.getFecha_final()==null){
                        temphs2= tt;    
                    }  
                }
           }
           if(temphs2.getSueldo()!= (Double.parseDouble(txtSueldo.getText()))){
           Calendar fecha = new GregorianCalendar();
           String fecha1;
            int menos=1;
           String restar="";
           int pasar=0;
           String aux1,aux2,aux3;
           aux1 = Integer.toString(fecha.get(Calendar.YEAR));
           aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.MONTH)+1) : Integer.toString(fecha.get(Calendar.MONTH));
           aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
           pasar=(Integer.parseInt(aux3));
           restar=String.valueOf(pasar-menos);
           fecha1 = aux1+aux2+restar;
           temphc2.setEstado(false);
           temphs2.setFecha_final((fecha1));
           
           //temphs2.getSueldo((cmbCargoEmpleado.getSelectedIndex()+1));
           double auxsueldo1=temphs2.getSueldo();
           //temphs2=HistoricoSueldoDao.findHistoricoSueldo_empleado(Integer.parseInt(String.valueOf(temphs2.getSueldo())));
           temphs2.setSueldo(auxsueldo1);
           try {
           HistoricoSueldoDao.edit(temphs2);
           }catch  (Exception ex){
               Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           HistoricoSueldo_empleado temphs3 = new HistoricoSueldo_empleado();
           Calendar fecha222 = new GregorianCalendar();
           String fecha111;
           
           String aux111,aux222,aux333;
           aux111 = Integer.toString(fecha222.get(Calendar.YEAR));
           aux222 = (fecha222.get(Calendar.MONTH)<10)? "0"+Integer.toString(fecha222.get(Calendar.MONTH)+1) : Integer.toString(fecha222.get(Calendar.MONTH));
           aux333 = (fecha222.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha222.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha222.get(Calendar.DAY_OF_MONTH));
           fecha111 = aux111+aux222+aux333;
           temphs3.setId_sueldo(HistoricoSueldoDao.getHistoricoSueldo_empleadoCount());
           temphs3.setEstado(true);
           temphs3.setFecha_inicial(fecha111);
           double auxsueldo11=Double.parseDouble(txtSueldo.getText().trim());
           temphs3.setSueldo(auxsueldo11);
           temphs3.setId_empleado(cmbIDEmpleado1.getSelectedIndex());
            try {
            HistoricoSueldoDao.create(temphs3);
        } catch (Exception ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
           }
            
                
                JOptionPane.showMessageDialog(null,"Datos Modificados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE);
                createTableEmpleado();
                btnAgregar1.setEnabled(true);
                btnModificar1.setEnabled(false);
            }
    }//GEN-LAST:event_btnModificar1ActionPerformed

    private void btnLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar1ActionPerformed
        //        cmbIDEmpleado1.setSelectedIndex(1);
        cmbIDEmpleado1.setSelectedIndex(0);
        createTableEmpleado();
        //createComboBox();
        //createComboTipoDocumento();
    }//GEN-LAST:event_btnLimpiar1ActionPerformed

    private void btnDesactivar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar1ActionPerformed
        Empleado temp;
        temp = Empleadodao.findEmpleado(cmbIDEmpleado1.getSelectedIndex());
        if(temp.isEstado()){
            temp.setEstado(false);
            JOptionPane.showMessageDialog(null,"Empleado Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE);
            
        }
        else{
            temp.setEstado(true);
            JOptionPane.showMessageDialog(null,"Empleado Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE);
            
        }
        try {
            Empleadodao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        createTableEmpleado();
        btnActivarDesactivarEmpleado();
        btnDesactivar1.setEnabled(false);
        btnAgregar1.setEnabled(true);
        btnModificar1.setEnabled(false);

    }//GEN-LAST:event_btnDesactivar1ActionPerformed

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
        btnAgregar1.setEnabled(false);
        btnModificar1.setEnabled(true);
        int column=0;
        int fila = tblEmpleados.getSelectedRow();
        if (fila > -1){
            Empleado temp = Empleadodao.findEmpleado(Integer.parseInt(tblEmpleados.getModel().getValueAt(fila, column).toString()));
            List<HistoricoSueldo_empleado> tempc = HistoricoSueldoDao.findHistoricoSueldo_empleadoEntities();
            List<Persona> tempp = Personadao.findPersonaEntities();
            List<HistoricoCargo_empleado> tempb = HistoricoCargoDao.findHistoricoCargo_empleadoEntities();
            List<Cargo_empleado> temppc = CargoDao.findCargo_empleadoEntities();
            List<Tipo_Documento> tempptp = TipoDocumentodao.findTipo_DocumentoEntities();
           for(Persona b : tempp){
                if(b.getId_persona()==temp.getId_Persona()){
            cmbIDEmpleado1.setSelectedIndex((temp.getId_Empleado()));
            cmbIDEmpleado.setSelectedIndex((temp.getId_Empleado()));
            txtNombre1.setText(b.getNombre());
            txtApellidos.setText(b.getApellido());
            txtTel.setText(b.getTelefono());
            txtaDirec.setText(b.getDireccion());
            txtCorreo.setText(b.getCorreo_electroncio());
            for(Tipo_Documento pptp : tempptp){
                  if(b.getID_tipo_documento()==pptp.getId_Tipo_Documento()){ 
                cmbTipoDocumentoEmpleado.setSelectedItem((b.getID_tipo_documento()+". "+pptp.getDocumento()));
                txtDocumento.setText(b.getDocumento_id());
                  }
                }
                }
            }
                for(HistoricoCargo_empleado cc : tempb){
                if(cc.getId_empleado()==temp.getId_Empleado()){
               for(Cargo_empleado pp : temppc){
            if(pp.getId_cargo()==cc.getId_cargo()){       
            cmbCargoEmpleado.setSelectedItem((cc.getId_cargo()+". "+pp.getCargo()));          
            }
                }
                }
            }
                for(HistoricoSueldo_empleado ccse : tempc){
                if(ccse.getId_empleado()==temp.getId_Empleado()){
            txtSueldo.setText(String.valueOf(ccse.getSueldo()));
                }
            }
            
            btnActivarDesactivarEmpleado();
        }
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed

        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void btnRegresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar1ActionPerformed
        FrmMenu m = new FrmMenu();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresar1ActionPerformed

    private void cmbIDEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIDEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIDEmpleadoActionPerformed

    private void cmbCargoEmpleadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCargoEmpleadoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCargoEmpleadoItemStateChanged

    private void txtSueldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSueldoKeyTyped

    private void btnRegresar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar2ActionPerformed
        FrmMenu m = new FrmMenu();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresar2ActionPerformed

    private void btnSalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalir2ActionPerformed

    private void tblNuevoCargoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNuevoCargoMouseClicked
        btnAgregar2.setEnabled(false);
        btnModificar2.setEnabled(true);
        int column=0;
        int fila = tblNuevoCargo.getSelectedRow();
        if (fila > -1){
            cmbIDNuevoCargo.setSelectedIndex(Integer.parseInt(tblNuevoCargo.getModel().getValueAt(fila, column).toString()));
            txtNuevoCargo.setText(String.valueOf(tblNuevoCargo.getValueAt(fila, ++column)));
            btnActivarDesactivarCargo();
        }

    }//GEN-LAST:event_tblNuevoCargoMouseClicked

    private void tblNuevoCargoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNuevoCargoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblNuevoCargoMouseEntered
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
    private void btnAgregar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar2ActionPerformed

        if(cmbIDNuevoCargo.getSelectedIndex()!=0){
            cmbIDNuevoCargo.setSelectedIndex(0);
        }
        else{

        }
        if (ValidacionTresletras(txtNuevoCargo.getText())){
            JOptionPane.showMessageDialog(null,"No se Admite en el Cargo la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
            txtNuevoCargo.requestFocus();
            return;
        }else{
        }
        if("".equals(txtNuevoCargo.getText()) || (txtNuevoCargo.getText().length()>25)){
            JOptionPane.showMessageDialog(null,"Ingrese la cantidad necesaria de caracteres para el Cargo","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            int i;
            boolean flag=false;
            for(i=0;i<CargoDao.findCargo_empleadoEntities().size();i++){
                if(txtNuevoCargo.getText().toLowerCase().equals(CargoDao.findCargo_empleado(i+1).getCargo())){
                    JOptionPane.showMessageDialog(null, "Ya existe este cargo registrado en el sistema","Error!", JOptionPane.ERROR_MESSAGE);
                    flag=true;
                    return;
                } else {
                }
            }
            if(flag){
                return;
            }
            else{
                Cargo_empleado tp = new Cargo_empleado();
                tp.setEstado(true);
                tp.setCargo(txtNuevoCargo.getText().toLowerCase());
                try {
                    CargoDao.create(tp);
                } catch (Exception ex) {
                    Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
                }
                //cmbIDTipoDocumento.setSelectedIndex(1);
                JOptionPane.showMessageDialog(null,"Datos Guardados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE);
                cmbIDNuevoCargo.setSelectedIndex(0);
                createTableNuevoCargo();
                createComboBoxNuevoCargo();
                createComboCargoEmpleado();
                btnAgregar2.setEnabled(true);
                btnModificar2.setEnabled(false);
            }
        }

    }//GEN-LAST:event_btnAgregar2ActionPerformed

    private void cmbIDNuevoCargoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDNuevoCargoItemStateChanged
        if(cmbIDNuevoCargo.getSelectedIndex()==0){
            txtNuevoCargo.setText("");
            btnDesactivar2.setEnabled(false);

        }
        else{
            Cargo_empleado tp;
            tp=CargoDao.findCargo_empleado(cmbIDNuevoCargo.getSelectedIndex());
            txtNuevoCargo.setText(tp.getCargo());
            btnActivarDesactivarCargo();
        }
    }//GEN-LAST:event_cmbIDNuevoCargoItemStateChanged

    private void txtNuevoCargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNuevoCargoKeyTyped
        char validar=evt.getKeyChar();
        if((validar<'a'||validar>'z')&& (validar<'A' || validar>'Z') && (validar!=(char)KeyEvent.VK_BACKSPACE) && (validar!=(char)KeyEvent.VK_SPACE)){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Solo se admiten letras para el Nuevo Cargo","Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtNuevoCargoKeyTyped

    private void btnModificar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar2ActionPerformed
        if(cmbIDNuevoCargo.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Cargo no encontrado");
        }
        else{
            if (ValidacionTresletras(txtNuevoCargo.getText())){
                JOptionPane.showMessageDialog(null,"No se Admite en el Cargo la misma letra 3 veces en forma consecutiva","Error!", JOptionPane.ERROR_MESSAGE);
                txtNuevoCargo.requestFocus();
                return;
            }else{
            }
            if("".equals(txtNuevoCargo.getText())){
                JOptionPane.showMessageDialog(null, "Cargo no puede ir vacio");
                return;
            }
            else{

                Cargo_empleado tp;
                tp=CargoDao.findCargo_empleado(cmbIDNuevoCargo.getSelectedIndex());
                tp.setCargo(txtNuevoCargo.getText().toLowerCase());
                try {
                    CargoDao.edit(tp);
                } catch (Exception ex) {
                    Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null,"Datos Modificados exitosamente","Modificado",JOptionPane.PLAIN_MESSAGE);
                cmbIDNuevoCargo.setSelectedIndex(1);
                cmbIDNuevoCargo.setSelectedIndex(0);
                createTableNuevoCargo();
                createComboBoxNuevoCargo();
                createComboCargoEmpleado();
                btnAgregar2.setEnabled(true);
                btnModificar2.setEnabled(false);

            }
        }
    }//GEN-LAST:event_btnModificar2ActionPerformed

    private void btnLimpiar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar2ActionPerformed

        cmbIDNuevoCargo.setSelectedIndex(0);
        btnAgregar2.setEnabled(true);
        btnModificar2.setEnabled(false);
        btnDesactivar2.setEnabled(false);
        createTableNuevoCargo();
        createComboBoxNuevoCargo();
    }//GEN-LAST:event_btnLimpiar2ActionPerformed
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
        pat = Pattern.compile("^[0-1]{1}[0-9]{2,14}$");
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
   private boolean ValidacionSueldo(String sueldo){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^\\d*\\.?\\d*$");
        mat =pat.matcher(sueldo);
        if (mat.find()){
            return true;
        } else{       
        return false;
        
        }
    }
   
    private void btnDesactivar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar2ActionPerformed
        Cargo_empleado temp;
        temp = CargoDao.findCargo_empleado(cmbIDNuevoCargo.getSelectedIndex());
        if(temp.isEstado()){
            temp.setEstado(false);
            JOptionPane.showMessageDialog(null,"Tipo de Cargo Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE);
        }
        else{
            temp.setEstado(true);
            JOptionPane.showMessageDialog(null,"Tipo de Cargo Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE);
        }
        try {
            CargoDao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        createTableNuevoCargo();
        btnActivarDesactivarCargo();
        btnDesactivar2.setEnabled(false);
        btnAgregar2.setEnabled(true);
        btnModificar2.setEnabled(false);
    }//GEN-LAST:event_btnDesactivar2ActionPerformed
        public void filtroCargoHistorico() {
        TableRowSorter trsfiltro = new TableRowSorter(jTbHistorialCargo.getModel());
        jTbHistorialCargo.setRowSorter(trsfiltro);
        trsfiltro.setRowFilter(RowFilter.regexFilter(txtEmpleadoCargo.getText(), 1));      
}
    private void btnRegresar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar3ActionPerformed
        FrmMenu m = new FrmMenu();
        m.setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresar3ActionPerformed

    private void btnSalir3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir3ActionPerformed
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalir3ActionPerformed

    private void btnRegresar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresar4ActionPerformed

    private void btnSalir4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalir4ActionPerformed

    private void txtEmpleadoSueldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmpleadoSueldoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpleadoSueldoKeyTyped

    private void txtEmpleadoCargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmpleadoCargoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpleadoCargoKeyTyped

    private void txtEmpleadoCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpleadoCargoActionPerformed
         txtEmpleadoCargo.addKeyListener(new KeyAdapter() {
                                                                public void keyReleased(final java.awt.event.KeyEvent e) {
                                                                                repaint();
                                                                                filtroCargoHistorico();
                                                                }
                                                                });

    }//GEN-LAST:event_txtEmpleadoCargoActionPerformed

    private void txtEmpleadoSueldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpleadoSueldoActionPerformed
        txtEmpleadoSueldo.addKeyListener(new KeyAdapter() {
                                                                public void keyReleased(final java.awt.event.KeyEvent e) {
                                                                        repaint();
                                                                        filtroSueldoHistorico();
                                                                }
                                                                });

    }//GEN-LAST:event_txtEmpleadoSueldoActionPerformed

    private void txtIDNombreEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDNombreEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDNombreEmpleadoActionPerformed
    public void BuscarEmpleadoUsuario(){
        List<Usuarios> temp = UsuariosDao.findUsuariosEntities();
        Empleado temp2 = new Empleado();
        boolean bandera = false;
        Persona temp3 = new Persona();
        if("".equals(txtIDNombreEmpleado.getText())){
            JOptionPane.showMessageDialog(null,"El campo de nombre de empleado esta vacio","Error!",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{   
        } 
                for(Usuarios u : temp){
                    temp2=Empleadodao.findEmpleado(u.getId_Empleado());
                    temp3=Personadao.findPersona(temp2.getId_Persona());   
                    String auxNombre=(temp3.getNombre()+" "+temp3.getApellido());
                    if (auxNombre.equals(txtIDNombreEmpleado.getText())){
                    txtIDUsuario.setText(String.valueOf(u.getId_Usuario()));
                    cmbIDEmpleado.setSelectedIndex(temp2.getId_Empleado());
                    txtNombre.setText(u.getId_Nombre());
                    
                    bandera=true;
                    }
                    else{
                     
                    }
                }        
                if(!bandera){
                        JOptionPane.showMessageDialog(null,"El Empleado que ingreso no existe","Error!",JOptionPane.ERROR_MESSAGE); 
                    }   
}
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        BuscarEmpleadoUsuario();
    }//GEN-LAST:event_btnBuscarActionPerformed
public void BuscarEmpleadoDocumento(){
        List<Empleado> temp = Empleadodao.findEmpleadoEntities();
        boolean flag = false;
        Persona temp3 = new Persona();
        Tipo_Documento temp4 = new Tipo_Documento();
        List<HistoricoSueldo_empleado> temp8 = HistoricoSueldoDao.findHistoricoSueldo_empleadoEntities();
        List<HistoricoCargo_empleado> temp9 = HistoricoCargoDao.findHistoricoCargo_empleadoEntities();
        if("".equals(txtDocumento.getText())){
            JOptionPane.showMessageDialog(null,"El campo de documento del empleado esta vacio","Error!",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{   
        } 
                for(Empleado e : temp){
                    temp3=Personadao.findPersona(e.getId_Persona());   
                    temp4=TipoDocumentodao.findTipo_Documento(temp3.getID_tipo_documento());  
                    if (temp3.getDocumento_id().equals(txtDocumento.getText())){
                    cmbIDEmpleado1.setSelectedIndex(e.getId_Empleado());
                    cmbIDEmpleado.setSelectedIndex(e.getId_Empleado());
                    txtNombre1.setText(temp3.getNombre());
                    txtApellidos.setText(temp3.getApellido());
                    txtTel.setText(temp3.getTelefono());
                    txtaDirec.setText(temp3.getDireccion());
                    cmbTipoDocumentoEmpleado.setSelectedIndex(temp3.getID_tipo_documento());
                    txtCorreo.setText(temp3.getCorreo_electroncio());
                    for(HistoricoSueldo_empleado es: temp8){
                        if(es.getId_empleado()==e.getId_Empleado()){
                        txtSueldo.setText(String.valueOf(es.getSueldo()));
                        }
                    }
                    for(HistoricoCargo_empleado ec: temp9){
                        if(ec.getId_empleado()==e.getId_Empleado()){   
                        cmbCargoEmpleado.setSelectedIndex(ec.getId_cargo());
                        }
                    }
                    
                    flag=true;
                    }
                    else{
                     
                    }
                }        
                if(!flag){
                        JOptionPane.showMessageDialog(null,"El Empleado que busco no existe","Error!",JOptionPane.ERROR_MESSAGE); 
                    }   
}
    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        BuscarEmpleadoDocumento();
    }//GEN-LAST:event_btnBuscar1ActionPerformed
public void filtroSueldoHistorico() {
        TableRowSorter trsfiltro = new TableRowSorter(tblHistorialSueldo.getModel());
        tblHistorialSueldo.setRowSorter(trsfiltro);
        trsfiltro.setRowFilter(RowFilter.regexFilter(txtEmpleadoSueldo.getText(), 1)); 
        
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
            java.util.logging.Logger.getLogger(FrmEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmEmpleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Tab_Empleado;
    private javax.swing.JTable Tbl_Usuarios;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregar1;
    private javax.swing.JButton btnAgregar2;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnDesactivar;
    private javax.swing.JButton btnDesactivar1;
    private javax.swing.JButton btnDesactivar2;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLimpiar1;
    private javax.swing.JButton btnLimpiar2;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnModificar1;
    private javax.swing.JButton btnModificar2;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnRegresar1;
    private javax.swing.JButton btnRegresar2;
    private javax.swing.JButton btnRegresar3;
    private javax.swing.JButton btnRegresar4;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalir1;
    private javax.swing.JButton btnSalir2;
    private javax.swing.JButton btnSalir3;
    private javax.swing.JButton btnSalir4;
    private javax.swing.JComboBox<String> cmbCargoEmpleado;
    private javax.swing.JComboBox<String> cmbIDEmpleado;
    private javax.swing.JComboBox<String> cmbIDEmpleado1;
    private javax.swing.JComboBox<String> cmbIDNuevoCargo;
    private javax.swing.JComboBox<String> cmbTipoDocumentoEmpleado;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTbHistorialCargo;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTable tblHistorialSueldo;
    private javax.swing.JTable tblNuevoCargo;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JPasswordField txtConfirmarContraseña;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtEmpleadoCargo;
    private javax.swing.JTextField txtEmpleadoSueldo;
    private javax.swing.JTextField txtIDNombreEmpleado;
    private javax.swing.JTextField txtIDUsuario;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtNuevoCargo;
    private javax.swing.JTextField txtSueldo;
    private javax.swing.JTextField txtTel;
    private javax.swing.JTextArea txtaDirec;
    // End of variables declaration//GEN-END:variables

}
