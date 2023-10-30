/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package massalud.Vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.nio.channels.FileChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import massalud.AccesoDatos.AfiliadoData;
import massalud.AccesoDatos.Conexion;
import massalud.AccesoDatos.EmpleadoData;
import massalud.AccesoDatos.EspecialidadData;
import massalud.AccesoDatos.OrdenData;
import massalud.AccesoDatos.PrestadorData;
import massalud.Entidades.Afiliado;
import massalud.Entidades.Empleado;
import massalud.Entidades.Especialidad;
import massalud.Entidades.Orden;
import massalud.Entidades.Prestador;

/**
 *
 * @author Cintia
 */
public class Menu extends javax.swing.JFrame {

  private AfiliadoData afiData = new AfiliadoData();
  private PrestadorData presData = new PrestadorData();
  private EspecialidadData espData = new EspecialidadData();
  private EmpleadoData EmpData = new EmpleadoData();
  private OrdenData od=new OrdenData();

  private Afiliado afiliadoActualDni = null;
  private Prestador prestadorActualEsp = null;
  private Especialidad especialidadActualNom = null;
////  private DefaultTableModel model = new DefaultTableModel();

  DefaultTableModel TLOrd = new DefaultTableModel();
  DefaultTableModel modelo = new DefaultTableModel();
  DefaultTableModel pres = new DefaultTableModel();
  DefaultTableModel espec=new DefaultTableModel();
  DefaultTableModel empleado=new DefaultTableModel();

  /**
   * Creates new form Menu
   */
  public Menu() {

    initComponents();
    FechaOrd.setMinSelectableDate(new Date());
    FechaOrd.setMaxSelectableDate(new Date());
    
     String[] cabeceraemp = new String[]{"ID Empleado", "Nombre/s", "Apellido/s", "DNI", "Usuario", "Contraseña","Telefono","Clave Acceso"};
    empleado.setColumnIdentifiers(cabeceraemp);
    jemp.setModel(empleado);
    JTableHeader he = jemp.getTableHeader();
    he.setForeground(new Color(0, 153, 153));
    he.setFont(new Font("Segoe UI", Font.BOLD, 15));
    
    jemp.getColumnModel().getColumn(0).setPreferredWidth(6);
    jemp.getColumnModel().getColumn(0).setResizable(false);
    jemp.getColumnModel().getColumn(1).setPreferredWidth(25);
    jemp.getColumnModel().getColumn(1).setResizable(false);
    jemp.getColumnModel().getColumn(2).setPreferredWidth(25);
    jemp.getColumnModel().getColumn(2).setResizable(false);
    jemp.getColumnModel().getColumn(3).setPreferredWidth(30);
    jemp.getColumnModel().getColumn(3).setResizable(false);
    jemp.getColumnModel().getColumn(4).setPreferredWidth(40);
    jemp.getColumnModel().getColumn(4).setResizable(false);
    jemp.getColumnModel().getColumn(5).setPreferredWidth(55);
    jemp.getColumnModel().getColumn(5).setResizable(false);
    jemp.getColumnModel().getColumn(6).setPreferredWidth(40);
    jemp.getColumnModel().getColumn(6).setResizable(false);
    jemp.getColumnModel().getColumn(7).setPreferredWidth(55);
    jemp.getColumnModel().getColumn(7).setResizable(false);
    jemp.setShowGrid(true);
    jemp.setRowHeight(28);
    
    String[] cabespe = new String[]{"ID Especialidad", "Nombre"};
    espec.setColumnIdentifiers(cabespe);
    jespe.setModel(espec);
    JTableHeader hea = jespe.getTableHeader();
    hea.setForeground(new Color(0, 153, 153));
    hea.setFont(new Font("Segoe UI", Font.BOLD, 15));
    
     jespe.getColumnModel().getColumn(0).setPreferredWidth(20);
    jespe.getColumnModel().getColumn(0).setResizable(false);
    jespe.getColumnModel().getColumn(1).setPreferredWidth(50);
    jespe.getColumnModel().getColumn(1).setResizable(false);
    jespe.setShowGrid(true);
    jespe.setRowHeight(28);
    
    String[] cabepre = new String[]{"ID Prestador", "Nombre/s", "Apellido/s", "Institucion", "Domicilio","Telefono","Email","ID Especialidad"};
    pres.setColumnIdentifiers(cabepre);
    jtpre.setModel(pres);
    JTableHeader head = jtpre.getTableHeader();
    head.setForeground(new Color(0, 153, 153));
    head.setFont(new Font("Segoe UI", Font.BOLD, 15));
    
    jtpre.getColumnModel().getColumn(0).setPreferredWidth(5);
    jtpre.getColumnModel().getColumn(0).setResizable(false);
    jtpre.getColumnModel().getColumn(1).setPreferredWidth(20);
    jtpre.getColumnModel().getColumn(1).setResizable(false);
    jtpre.getColumnModel().getColumn(2).setPreferredWidth(20);
    jtpre.getColumnModel().getColumn(2).setResizable(false);
    jtpre.getColumnModel().getColumn(3).setPreferredWidth(30);
    jtpre.getColumnModel().getColumn(3).setResizable(false);
    jtpre.getColumnModel().getColumn(4).setPreferredWidth(60);
    jtpre.getColumnModel().getColumn(4).setResizable(false);
    jtpre.getColumnModel().getColumn(5).setPreferredWidth(30);
    jtpre.getColumnModel().getColumn(5).setResizable(false);
    jtpre.getColumnModel().getColumn(6).setPreferredWidth(60);
    jtpre.getColumnModel().getColumn(6).setResizable(false);
    jtpre.getColumnModel().getColumn(7).setPreferredWidth(5);
    jtpre.getColumnModel().getColumn(7).setResizable(false);
   
    jtpre.setShowGrid(true);
    jtpre.setRowHeight(28);
    
    String[] cabecera = new String[]{"ID Afiliado", "Nombre/s", "Apellido/s", "DNI", "ID Empleado", "Domicilio","Telefono"};
    modelo.setColumnIdentifiers(cabecera);
    jtAfi.setModel(modelo);
    JTableHeader heade = jtAfi.getTableHeader();
    heade.setForeground(new Color(0, 153, 153));
    heade.setFont(new Font("Segoe UI", Font.BOLD, 15));
    
    jtAfi.getColumnModel().getColumn(0).setPreferredWidth(5);
    jtAfi.getColumnModel().getColumn(0).setResizable(false);
    jtAfi.getColumnModel().getColumn(1).setPreferredWidth(50);
    jtAfi.getColumnModel().getColumn(1).setResizable(false);
    jtAfi.getColumnModel().getColumn(2).setPreferredWidth(50);
    jtAfi.getColumnModel().getColumn(2).setResizable(false);
    jtAfi.getColumnModel().getColumn(3).setPreferredWidth(40);
    jtAfi.getColumnModel().getColumn(3).setResizable(false);
    jtAfi.getColumnModel().getColumn(4).setPreferredWidth(5);
    jtAfi.getColumnModel().getColumn(4).setResizable(false);
    jtAfi.getColumnModel().getColumn(5).setPreferredWidth(60);
    jtAfi.getColumnModel().getColumn(5).setResizable(false);
    jtAfi.getColumnModel().getColumn(6).setPreferredWidth(50);
    jtAfi.getColumnModel().getColumn(6).setResizable(false);
    jtAfi.setShowGrid(true);
    jtAfi.setRowHeight(28);
    

    String[] titulo = new String[]{"IdOrden", "Fecha", "Forma de Pago", "Importe", "IdAfiliado", "IdPrestador"};
    TLOrd.setColumnIdentifiers(titulo);
    TListOrd.setModel(TLOrd);
    JTableHeader header = TListOrd.getTableHeader();
    header.setForeground(new Color(0, 153, 153));
    header.setFont(new Font("Segoe UI", Font.BOLD, 15));
  

    TListOrd.getColumnModel().getColumn(0).setPreferredWidth(3);
    TListOrd.getColumnModel().getColumn(0).setResizable(false);
    TListOrd.getColumnModel().getColumn(1).setPreferredWidth(40);
     TListOrd.getColumnModel().getColumn(1).setResizable(false);
    TListOrd.getColumnModel().getColumn(2).setPreferredWidth(70);
     TListOrd.getColumnModel().getColumn(2).setResizable(false);
    TListOrd.getColumnModel().getColumn(3).setPreferredWidth(40);
     TListOrd.getColumnModel().getColumn(3).setResizable(false);
    TListOrd.getColumnModel().getColumn(4).setPreferredWidth(30);
     TListOrd.getColumnModel().getColumn(4).setResizable(false);
    TListOrd.getColumnModel().getColumn(5).setPreferredWidth(40);
     TListOrd.getColumnModel().getColumn(5).setResizable(false);
     TListOrd.setShowGrid(true);
     TListOrd.setRowHeight(28);

    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    setIconImage(new ImageIcon(getClass().getResource("/massalud/Recursos/icon.png")).getImage());
    setLocationRelativeTo(null);
    FInicio.setVisible(true);

//    POrden.setBackground(new Color(204, 102, 0));
//    Orden.setForeground(new Color(0, 204, 204));
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icono2=new ImageIcon(getClass().getResource("/massalud/Recursos/fmenu.png"));
        Image imagen2=icono2.getImage();
        PanelMenu = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen2,0,0,getWidth(),getHeight(),this);
            }
        };
        logomenu = new javax.swing.JLabel();
        POrden = new javax.swing.JPanel();
        Orden = new javax.swing.JLabel();
        PAfil = new javax.swing.JPanel();
        Afil = new javax.swing.JLabel();
        PPrest = new javax.swing.JPanel();
        Prest = new javax.swing.JLabel();
        PEspe = new javax.swing.JPanel();
        Espe = new javax.swing.JLabel();
        PEmpl = new javax.swing.JPanel();
        Empl = new javax.swing.JLabel();
        Salir = new javax.swing.JButton();
        PanelOt = new javax.swing.JPanel();
        ImageIcon iconoini=new ImageIcon(getClass().getResource("/massalud/Recursos/F1.png"));
        Image imagenini=iconoini.getImage();
        FInicio = new javax.swing.JPanel(){

            public void paintComponent(Graphics g){
                g.drawImage(imagenini,0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel7 = new javax.swing.JLabel();
        ImageIcon iconord=new ImageIcon(getClass().getResource("/massalud/Recursos/F1.png"));
        Image imagenord=iconord.getImage();
        FOrd = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagenord,0,0,getWidth(),getHeight(),this);
            }
        };
        Ordenes = new javax.swing.JLabel();
        tituAfil = new javax.swing.JLabel();
        Docu = new javax.swing.JLabel();
        Doc = new javax.swing.JTextField();
        IdAfil = new javax.swing.JLabel();
        IdAf = new javax.swing.JTextField();
        Nomb = new javax.swing.JLabel();
        Nom = new javax.swing.JTextField();
        Apel = new javax.swing.JLabel();
        Ape = new javax.swing.JTextField();
        Domi = new javax.swing.JLabel();
        Dom = new javax.swing.JTextField();
        Telf = new javax.swing.JLabel();
        Tel = new javax.swing.JTextField();
        EstaA = new javax.swing.JLabel();
        Act = new java.awt.Checkbox();
        Ina = new java.awt.Checkbox();
        BuscarAfi = new javax.swing.JButton();
        Import = new javax.swing.JLabel();
        texImpo = new javax.swing.JTextField();
        FormdP = new javax.swing.JLabel();
        FdP = new javax.swing.JComboBox<>();
        Fecha = new javax.swing.JLabel();
        FechaOrd = new com.toedter.calendar.JDateChooser();
        tituPrest = new javax.swing.JLabel();
        IdPres = new javax.swing.JLabel();
        IdPresta = new javax.swing.JTextField();
        InstiP = new javax.swing.JLabel();
        InstP = new javax.swing.JTextField();
        NombP = new javax.swing.JLabel();
        NomP = new javax.swing.JTextField();
        ApelP = new javax.swing.JLabel();
        ApeP = new javax.swing.JTextField();
        DomiP = new javax.swing.JLabel();
        DomP = new javax.swing.JTextField();
        TelfP = new javax.swing.JLabel();
        TelP = new javax.swing.JTextField();
        correoP = new javax.swing.JLabel();
        CorreP = new javax.swing.JTextField();
        Especi = new javax.swing.JLabel();
        TexEspe = new javax.swing.JTextField();
        BuscarEspe = new javax.swing.JButton();
        EstEsp = new javax.swing.JLabel();
        ActP = new java.awt.Checkbox();
        InaP = new java.awt.Checkbox();
        GenerarOrd = new javax.swing.JButton();
        EliLisOrd = new javax.swing.JButton();
        ListarOrd = new javax.swing.JButton();
        nuevo = new javax.swing.JButton();
        IdEspe = new javax.swing.JLabel();
        IdEspec = new javax.swing.JTextField();
        Sepa1 = new javax.swing.JSeparator();
        Sepa2 = new javax.swing.JSeparator();
        Sepa3 = new javax.swing.JSeparator();
        idemple = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dniPres = new javax.swing.JLabel();
        dniPrest = new javax.swing.JTextField();
        FechaList = new javax.swing.JLabel();
        FechaListOrd = new com.toedter.calendar.JDateChooser();
        Sepa4 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        TListOrd = new javax.swing.JTable();
        LimpiarTabla = new javax.swing.JButton();
        AfiBus = new javax.swing.JLabel();
        Afibusc = new javax.swing.JTextField();
        Presbusc1 = new javax.swing.JTextField();
        PresBus = new javax.swing.JLabel();
        listarAfi = new javax.swing.JLabel();
        listarPres = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        ImageIcon iconoa=new ImageIcon(getClass().getResource("/massalud/Recursos/F1.png"));
        Image imagena=iconoa.getImage();
        FAfi = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagena,0,0,getWidth(),getHeight(),this);
            }
        };
        afili = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        idafiliado = new javax.swing.JTextField();
        jbuscarafi = new javax.swing.JLabel();
        IdAfil1 = new javax.swing.JLabel();
        Nomb1 = new javax.swing.JLabel();
        Apel1 = new javax.swing.JLabel();
        documento = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        apellido = new javax.swing.JTextField();
        Corre2 = new javax.swing.JLabel();
        Telf1 = new javax.swing.JLabel();
        Domi1 = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        domicilio = new javax.swing.JTextField();
        activo = new java.awt.Checkbox();
        inactivo = new java.awt.Checkbox();
        jLabel1 = new javax.swing.JLabel();
        idempleafi = new javax.swing.JTextField();
        Guardarafi = new javax.swing.JLabel();
        Modificarafi = new javax.swing.JLabel();
        Eliminarafi = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtAfi = new javax.swing.JTable();
        Listarafi = new javax.swing.JLabel();
        ImageIcon iconop=new ImageIcon(getClass().getResource("/massalud/Recursos/F1.png"));
        Image imagenp=iconop.getImage();
        FPres = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(imagenp,0,0,getWidth(),getHeight(),this);
            }
        }
        ;
        prest = new javax.swing.JLabel();
        Apel2 = new javax.swing.JLabel();
        Nomb2 = new javax.swing.JLabel();
        IdAfil2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        idprestador = new javax.swing.JTextField();
        dnipre = new javax.swing.JTextField();
        institucion = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        buscarpre = new javax.swing.JLabel();
        Domi2 = new javax.swing.JLabel();
        Telf2 = new javax.swing.JLabel();
        Corre3 = new javax.swing.JLabel();
        actpre = new java.awt.Checkbox();
        inapre = new java.awt.Checkbox();
        telpre = new javax.swing.JTextField();
        dompre = new javax.swing.JTextField();
        nompre = new javax.swing.JTextField();
        Nomb3 = new javax.swing.JLabel();
        Apel3 = new javax.swing.JLabel();
        apepre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        idespe = new javax.swing.JTextField();
        guardarpre = new javax.swing.JLabel();
        modipre = new javax.swing.JLabel();
        elipre = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtpre = new javax.swing.JTable();
        listarpre = new javax.swing.JLabel();
        ImageIcon iconoe=new ImageIcon(getClass().getResource("/massalud/Recursos/F1.png"));
        Image imagene=iconoe.getImage();
        FEsp = new javax.swing.JPanel(){

            public void paintComponent(Graphics g){
                g.drawImage(imagene,0,0,getWidth(),getHeight(),this);
            }
        };
        espe = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        idespecialidad = new javax.swing.JTextField();
        buscarespe = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        nomespe = new javax.swing.JTextField();
        Corre5 = new javax.swing.JLabel();
        actespe = new java.awt.Checkbox();
        inaespe = new java.awt.Checkbox();
        guardarespe = new javax.swing.JLabel();
        modiespe = new javax.swing.JLabel();
        eliespe = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jespe = new javax.swing.JTable();
        listarespe = new javax.swing.JLabel();
        ImageIcon iconoem=new ImageIcon(getClass().getResource("/massalud/Recursos/F1.png"));
        Image imagenem=iconoem.getImage();
        FEmp = new javax.swing.JPanel(){

            public void paintComponent(Graphics g){
                g.drawImage(imagenem,0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel6 = new javax.swing.JLabel();
        actemp = new java.awt.Checkbox();
        Nomb4 = new javax.swing.JLabel();
        inaemp = new java.awt.Checkbox();
        Apel4 = new javax.swing.JLabel();
        dniemp = new javax.swing.JTextField();
        nomemp = new javax.swing.JTextField();
        apeemp = new javax.swing.JTextField();
        Corre4 = new javax.swing.JLabel();
        Telf3 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        Domi3 = new javax.swing.JLabel();
        idempleado = new javax.swing.JTextField();
        telemp = new javax.swing.JTextField();
        buscaremp = new javax.swing.JLabel();
        clave = new javax.swing.JTextField();
        IdAfil3 = new javax.swing.JLabel();
        Nomb5 = new javax.swing.JLabel();
        Apel5 = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        contra = new javax.swing.JTextField();
        guardaremp = new javax.swing.JLabel();
        modiemp = new javax.swing.JLabel();
        elimemp = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jemp = new javax.swing.JTable();
        listaremp = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logomenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/logomen.gif"))); // NOI18N

        POrden.setBackground(new java.awt.Color(0, 204, 204));
        POrden.setPreferredSize(new java.awt.Dimension(280, 50));
        POrden.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                POrdenMouseClicked(evt);
            }
        });

        Orden.setFont(new java.awt.Font("Segoe UI Black", 0, 26)); // NOI18N
        Orden.setForeground(new java.awt.Color(204, 102, 0));
        Orden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/orden.png"))); // NOI18N
        Orden.setLabelFor(Ape);
        Orden.setText("Ordenes");
        Orden.setAlignmentY(0.0F);

        javax.swing.GroupLayout POrdenLayout = new javax.swing.GroupLayout(POrden);
        POrden.setLayout(POrdenLayout);
        POrdenLayout.setHorizontalGroup(
            POrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(POrdenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Orden)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        POrdenLayout.setVerticalGroup(
            POrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Orden, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, Short.MAX_VALUE)
        );

        PAfil.setBackground(new java.awt.Color(0, 204, 204));
        PAfil.setPreferredSize(new java.awt.Dimension(280, 50));
        PAfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PAfilMouseClicked(evt);
            }
        });

        Afil.setFont(new java.awt.Font("Segoe UI Black", 0, 26)); // NOI18N
        Afil.setForeground(new java.awt.Color(204, 102, 0));
        Afil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/Afiliados.png"))); // NOI18N
        Afil.setText("Afiliados");

        javax.swing.GroupLayout PAfilLayout = new javax.swing.GroupLayout(PAfil);
        PAfil.setLayout(PAfilLayout);
        PAfilLayout.setHorizontalGroup(
            PAfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PAfilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Afil, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PAfilLayout.setVerticalGroup(
            PAfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PAfilLayout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(Afil, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PPrest.setBackground(new java.awt.Color(0, 204, 204));
        PPrest.setForeground(new java.awt.Color(51, 51, 255));
        PPrest.setPreferredSize(new java.awt.Dimension(280, 50));
        PPrest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PPrestMouseClicked(evt);
            }
        });

        Prest.setFont(new java.awt.Font("Segoe UI Black", 0, 26)); // NOI18N
        Prest.setForeground(new java.awt.Color(204, 102, 0));
        Prest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/Prestador.png"))); // NOI18N
        Prest.setText("Prestador");

        javax.swing.GroupLayout PPrestLayout = new javax.swing.GroupLayout(PPrest);
        PPrest.setLayout(PPrestLayout);
        PPrestLayout.setHorizontalGroup(
            PPrestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PPrestLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Prest)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PPrestLayout.setVerticalGroup(
            PPrestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Prest, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, Short.MAX_VALUE)
        );

        PEspe.setBackground(new java.awt.Color(0, 204, 204));
        PEspe.setForeground(new java.awt.Color(51, 102, 255));
        PEspe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PEspeMouseClicked(evt);
            }
        });

        Espe.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        Espe.setForeground(new java.awt.Color(204, 102, 0));
        Espe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/Especialidad.png"))); // NOI18N
        Espe.setText("Especialidad");

        javax.swing.GroupLayout PEspeLayout = new javax.swing.GroupLayout(PEspe);
        PEspe.setLayout(PEspeLayout);
        PEspeLayout.setHorizontalGroup(
            PEspeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PEspeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Espe, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addContainerGap())
        );
        PEspeLayout.setVerticalGroup(
            PEspeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Espe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        PEmpl.setBackground(new java.awt.Color(0, 204, 204));
        PEmpl.setForeground(new java.awt.Color(51, 102, 255));
        PEmpl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PEmplMouseClicked(evt);
            }
        });

        Empl.setFont(new java.awt.Font("Segoe UI Black", 0, 26)); // NOI18N
        Empl.setForeground(new java.awt.Color(204, 102, 0));
        Empl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/Empleados.png"))); // NOI18N
        Empl.setText("Empleados");
        Empl.setAlignmentY(0.0F);

        javax.swing.GroupLayout PEmplLayout = new javax.swing.GroupLayout(PEmpl);
        PEmpl.setLayout(PEmplLayout);
        PEmplLayout.setHorizontalGroup(
            PEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PEmplLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Empl)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        PEmplLayout.setVerticalGroup(
            PEmplLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PEmplLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Empl, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Salir.setBackground(new java.awt.Color(255, 102, 0));
        Salir.setFont(new java.awt.Font("Segoe UI Black", 1, 28)); // NOI18N
        Salir.setForeground(new java.awt.Color(0, 204, 204));
        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/salirc.png"))); // NOI18N
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(PPrest, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(PEspe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PEmpl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(PAfil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(POrden, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(logomenu, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Salir))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(logomenu, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(POrden, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PAfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PPrest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PEspe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PEmpl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(Salir)
                .addGap(34, 34, 34))
        );

        getContentPane().add(PanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 260, 780));

        PanelOt.setBackground(new java.awt.Color(204, 255, 204));
        PanelOt.setLayout(new javax.swing.OverlayLayout(PanelOt));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/logoini.gif"))); // NOI18N
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout FInicioLayout = new javax.swing.GroupLayout(FInicio);
        FInicio.setLayout(FInicioLayout);
        FInicioLayout.setHorizontalGroup(
            FInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FInicioLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        FInicioLayout.setVerticalGroup(
            FInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FInicioLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        PanelOt.add(FInicio);

        FOrd.setForeground(new java.awt.Color(0, 153, 153));
        FOrd.setPreferredSize(new java.awt.Dimension(880, 780));

        Ordenes.setFont(new java.awt.Font("Bauhaus 93", 3, 26)); // NOI18N
        Ordenes.setForeground(new java.awt.Color(0, 102, 204));
        Ordenes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/ord (2).png"))); // NOI18N

        tituAfil.setFont(new java.awt.Font("Segoe UI Black", 2, 18)); // NOI18N
        tituAfil.setForeground(new java.awt.Color(0, 153, 153));
        tituAfil.setText("AFILIADO:");

        Docu.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Docu.setForeground(new java.awt.Color(0, 153, 153));
        Docu.setText("DNI:");

        Doc.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        Doc.setForeground(new java.awt.Color(0, 153, 153));
        Doc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DocActionPerformed(evt);
            }
        });

        IdAfil.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        IdAfil.setForeground(new java.awt.Color(0, 153, 153));
        IdAfil.setText("ID Afiliado/a:");

        IdAf.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        IdAf.setForeground(new java.awt.Color(0, 153, 153));
        IdAf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdAfActionPerformed(evt);
            }
        });

        Nomb.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Nomb.setForeground(new java.awt.Color(0, 153, 153));
        Nomb.setText("Nombre/s:");

        Nom.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        Nom.setForeground(new java.awt.Color(0, 153, 153));
        Nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomActionPerformed(evt);
            }
        });

        Apel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Apel.setForeground(new java.awt.Color(0, 153, 153));
        Apel.setText("Apellido/s:");

        Ape.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        Ape.setForeground(new java.awt.Color(0, 153, 153));
        Ape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApeActionPerformed(evt);
            }
        });

        Domi.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Domi.setForeground(new java.awt.Color(0, 153, 153));
        Domi.setText("Domicilio:");

        Dom.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        Dom.setForeground(new java.awt.Color(0, 153, 153));
        Dom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DomActionPerformed(evt);
            }
        });

        Telf.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Telf.setForeground(new java.awt.Color(0, 153, 153));
        Telf.setText("Telf. o Cel. :");

        Tel.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        Tel.setForeground(new java.awt.Color(0, 153, 153));
        Tel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelActionPerformed(evt);
            }
        });

        EstaA.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        EstaA.setForeground(new java.awt.Color(0, 153, 153));
        EstaA.setText("Estado:");

        Act.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Act.setForeground(new java.awt.Color(0, 153, 153));
        Act.setLabel("Activo");

        Ina.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Ina.setForeground(new java.awt.Color(0, 153, 153));
        Ina.setLabel("Inactivo");

        BuscarAfi.setBackground(new java.awt.Color(0, 153, 153));
        BuscarAfi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/BUSCAR VERDE 95X22PX.png"))); // NOI18N
        BuscarAfi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarAfiActionPerformed(evt);
            }
        });

        Import.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Import.setForeground(new java.awt.Color(0, 153, 153));
        Import.setText("Importe: $");
        Import.setPreferredSize(new java.awt.Dimension(53, 22));
        Import.setRequestFocusEnabled(false);
        Import.setVerifyInputWhenFocusTarget(false);

        texImpo.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        texImpo.setForeground(new java.awt.Color(0, 153, 153));
        texImpo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texImpoActionPerformed(evt);
            }
        });

        FormdP.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        FormdP.setForeground(new java.awt.Color(0, 153, 153));
        FormdP.setText("Forma de Pago:");
        FormdP.setPreferredSize(new java.awt.Dimension(101, 22));

        FdP.setBackground(new java.awt.Color(204, 255, 255));
        FdP.setEditable(true);
        FdP.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        FdP.setForeground(new java.awt.Color(0, 153, 153));
        FdP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "T de Débito", "T de Crédito" }));
        FdP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FdPActionPerformed(evt);
            }
        });

        Fecha.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Fecha.setForeground(new java.awt.Color(0, 153, 153));
        Fecha.setText("Fecha:");

        FechaOrd.setForeground(new java.awt.Color(0, 153, 153));
        FechaOrd.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        FechaOrd.setPreferredSize(new java.awt.Dimension(100, 35));

        tituPrest.setFont(new java.awt.Font("Segoe UI Black", 2, 18)); // NOI18N
        tituPrest.setForeground(new java.awt.Color(0, 153, 153));
        tituPrest.setText("PRESTADOR:");

        IdPres.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        IdPres.setForeground(new java.awt.Color(0, 153, 153));
        IdPres.setText("ID:");

        IdPresta.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        IdPresta.setForeground(new java.awt.Color(0, 153, 153));
        IdPresta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdPrestaActionPerformed(evt);
            }
        });

        InstiP.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        InstiP.setForeground(new java.awt.Color(0, 153, 153));
        InstiP.setText("Institucion:");

        InstP.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        InstP.setForeground(new java.awt.Color(0, 153, 153));
        InstP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InstPActionPerformed(evt);
            }
        });

        NombP.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        NombP.setForeground(new java.awt.Color(0, 153, 153));
        NombP.setText("Nombre/s:");

        NomP.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        NomP.setForeground(new java.awt.Color(0, 153, 153));
        NomP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomPActionPerformed(evt);
            }
        });

        ApelP.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ApelP.setForeground(new java.awt.Color(0, 153, 153));
        ApelP.setText("Apellido/s:");

        ApeP.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        ApeP.setForeground(new java.awt.Color(0, 153, 153));
        ApeP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApePActionPerformed(evt);
            }
        });

        DomiP.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        DomiP.setForeground(new java.awt.Color(0, 153, 153));
        DomiP.setText("Dirección:");

        DomP.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        DomP.setForeground(new java.awt.Color(0, 153, 153));
        DomP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DomPActionPerformed(evt);
            }
        });

        TelfP.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        TelfP.setForeground(new java.awt.Color(0, 153, 153));
        TelfP.setText("Telf. o Cel. :");

        TelP.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        TelP.setForeground(new java.awt.Color(0, 153, 153));
        TelP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelPActionPerformed(evt);
            }
        });

        correoP.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        correoP.setForeground(new java.awt.Color(0, 153, 153));
        correoP.setText("E-mail:");

        CorreP.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        CorreP.setForeground(new java.awt.Color(0, 153, 153));
        CorreP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CorrePActionPerformed(evt);
            }
        });

        Especi.setFont(new java.awt.Font("Segoe UI Black", 2, 18)); // NOI18N
        Especi.setForeground(new java.awt.Color(0, 153, 153));
        Especi.setText("ESPECIALIDAD:");

        TexEspe.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        TexEspe.setForeground(new java.awt.Color(0, 153, 153));
        TexEspe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TexEspeActionPerformed(evt);
            }
        });

        BuscarEspe.setBackground(new java.awt.Color(0, 153, 153));
        BuscarEspe.setForeground(new java.awt.Color(0, 153, 153));
        BuscarEspe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/BUSCAR VERDE 95X22PX.png"))); // NOI18N
        BuscarEspe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarEspeActionPerformed(evt);
            }
        });

        EstEsp.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        EstEsp.setForeground(new java.awt.Color(0, 153, 153));
        EstEsp.setText("Estado:");

        ActP.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ActP.setForeground(new java.awt.Color(0, 153, 153));
        ActP.setLabel("Activo");
        ActP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ActPItemStateChanged(evt);
            }
        });

        InaP.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        InaP.setForeground(new java.awt.Color(0, 153, 153));
        InaP.setLabel("Inactivo");
        InaP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                InaPItemStateChanged(evt);
            }
        });

        GenerarOrd.setBackground(new java.awt.Color(0, 153, 153));
        GenerarOrd.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        GenerarOrd.setForeground(new java.awt.Color(255, 255, 255));
        GenerarOrd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/GENERAR VERDE 95X22PX.png"))); // NOI18N
        GenerarOrd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarOrdActionPerformed(evt);
            }
        });

        EliLisOrd.setBackground(new java.awt.Color(0, 153, 153));
        EliLisOrd.setForeground(new java.awt.Color(255, 255, 255));
        EliLisOrd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/ELIMINAR VERDE 95X22PX.png"))); // NOI18N
        EliLisOrd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliLisOrdActionPerformed(evt);
            }
        });

        ListarOrd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/LISTAR VERDE 95X22PX.png"))); // NOI18N
        ListarOrd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListarOrdActionPerformed(evt);
            }
        });

        nuevo.setBackground(new java.awt.Color(0, 153, 153));
        nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/NUEVO VERDE 95X22PX.png"))); // NOI18N
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        IdEspe.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        IdEspe.setForeground(new java.awt.Color(0, 153, 153));
        IdEspe.setText("ID Especialidad:");

        IdEspec.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        IdEspec.setForeground(new java.awt.Color(0, 153, 153));
        IdEspec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdEspecActionPerformed(evt);
            }
        });

        Sepa1.setBackground(new java.awt.Color(0, 153, 153));
        Sepa1.setForeground(new java.awt.Color(0, 204, 204));
        Sepa1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        Sepa2.setBackground(new java.awt.Color(0, 153, 153));
        Sepa2.setForeground(new java.awt.Color(0, 204, 204));
        Sepa2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        Sepa3.setBackground(new java.awt.Color(0, 153, 153));
        Sepa3.setForeground(new java.awt.Color(0, 204, 204));

        idemple.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        idemple.setForeground(new java.awt.Color(0, 153, 153));
        idemple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idempleActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("IdEmpleado:");

        dniPres.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        dniPres.setForeground(new java.awt.Color(0, 153, 153));
        dniPres.setText("DNI:");

        dniPrest.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        dniPrest.setForeground(new java.awt.Color(0, 153, 153));
        dniPrest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dniPrestActionPerformed(evt);
            }
        });

        FechaList.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        FechaList.setForeground(new java.awt.Color(0, 153, 153));
        FechaList.setText("Fecha:");

        FechaListOrd.setForeground(new java.awt.Color(0, 153, 153));
        FechaListOrd.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        FechaListOrd.setPreferredSize(new java.awt.Dimension(100, 35));

        Sepa4.setBackground(new java.awt.Color(0, 153, 153));
        Sepa4.setForeground(new java.awt.Color(0, 204, 204));
        Sepa4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        TListOrd.setBackground(new java.awt.Color(226, 243, 225));
        TListOrd.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        TListOrd.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        TListOrd.setForeground(new java.awt.Color(0, 153, 153));
        TListOrd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TListOrd.setGridColor(new java.awt.Color(0, 153, 153));
        TListOrd.setSelectionBackground(new java.awt.Color(0, 153, 153));
        TListOrd.setSelectionForeground(new java.awt.Color(226, 243, 225));
        jScrollPane1.setViewportView(TListOrd);

        LimpiarTabla.setBackground(new java.awt.Color(0, 153, 153));
        LimpiarTabla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/NUEVO VERDE 95X22PX.png"))); // NOI18N
        LimpiarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarTablaActionPerformed(evt);
            }
        });

        AfiBus.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        AfiBus.setForeground(new java.awt.Color(0, 153, 153));
        AfiBus.setText("ID Afiliado:");
        AfiBus.setPreferredSize(new java.awt.Dimension(53, 22));
        AfiBus.setRequestFocusEnabled(false);
        AfiBus.setVerifyInputWhenFocusTarget(false);

        Afibusc.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        Afibusc.setForeground(new java.awt.Color(0, 153, 153));
        Afibusc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfibuscActionPerformed(evt);
            }
        });

        Presbusc1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        Presbusc1.setForeground(new java.awt.Color(0, 153, 153));
        Presbusc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Presbusc1ActionPerformed(evt);
            }
        });

        PresBus.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        PresBus.setForeground(new java.awt.Color(0, 153, 153));
        PresBus.setText("ID Prestador:");
        PresBus.setPreferredSize(new java.awt.Dimension(53, 22));
        PresBus.setRequestFocusEnabled(false);
        PresBus.setVerifyInputWhenFocusTarget(false);

        listarAfi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/LISTAR VERDE 95X22PX.png"))); // NOI18N
        listarAfi.setText("Consulta");
        listarAfi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listarAfiMouseClicked(evt);
            }
        });

        listarPres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/LISTAR VERDE 95X22PX.png"))); // NOI18N
        listarPres.setText("Consulta");
        listarPres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listarPresMouseClicked(evt);
            }
        });

        jLabel37.setBackground(new java.awt.Color(0, 153, 153));
        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 153, 153));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/LISTAR V167X42 PX.png"))); // NOI18N

        javax.swing.GroupLayout FOrdLayout = new javax.swing.GroupLayout(FOrd);
        FOrd.setLayout(FOrdLayout);
        FOrdLayout.setHorizontalGroup(
            FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FOrdLayout.createSequentialGroup()
                .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FOrdLayout.createSequentialGroup()
                        .addComponent(Ordenes)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(FOrdLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Sepa3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
                            .addGroup(FOrdLayout.createSequentialGroup()
                                .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(FOrdLayout.createSequentialGroup()
                                        .addComponent(Telf)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Tel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tituAfil)
                                    .addGroup(FOrdLayout.createSequentialGroup()
                                        .addComponent(IdAfil)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(IdAf, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(FOrdLayout.createSequentialGroup()
                                        .addComponent(Domi)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Dom, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, FOrdLayout.createSequentialGroup()
                                            .addComponent(Apel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(Ape))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, FOrdLayout.createSequentialGroup()
                                            .addComponent(Nomb)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(Nom, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(FOrdLayout.createSequentialGroup()
                                        .addComponent(EstaA)
                                        .addGap(23, 23, 23)
                                        .addComponent(Act, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Ina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(FOrdLayout.createSequentialGroup()
                                        .addComponent(Docu)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Doc, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(BuscarAfi, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(27, 27, 27)
                                .addComponent(Sepa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(FOrdLayout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(FOrdLayout.createSequentialGroup()
                                                .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(FOrdLayout.createSequentialGroup()
                                                            .addComponent(DomiP)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(DomP, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(FOrdLayout.createSequentialGroup()
                                                            .addComponent(TelfP)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(TelP, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(FOrdLayout.createSequentialGroup()
                                                            .addComponent(ApelP)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(ApeP))
                                                        .addGroup(FOrdLayout.createSequentialGroup()
                                                            .addComponent(NombP)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(NomP, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(FOrdLayout.createSequentialGroup()
                                                            .addComponent(correoP)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(CorreP, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGroup(FOrdLayout.createSequentialGroup()
                                                        .addComponent(InstiP)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(InstP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(8, 8, 8))
                                            .addGroup(FOrdLayout.createSequentialGroup()
                                                .addComponent(tituPrest)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(IdPres)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(IdPresta, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                                    .addGroup(FOrdLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(dniPres)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dniPrest, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(Sepa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Especi)
                                        .addComponent(EstEsp)
                                        .addGroup(FOrdLayout.createSequentialGroup()
                                            .addComponent(ActP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(InaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(IdEspe)
                                        .addComponent(IdEspec, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TexEspe))
                                    .addComponent(BuscarEspe, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(FOrdLayout.createSequentialGroup()
                                .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(FOrdLayout.createSequentialGroup()
                                        .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(FOrdLayout.createSequentialGroup()
                                                .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(FOrdLayout.createSequentialGroup()
                                                        .addComponent(AfiBus, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(23, 23, 23))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FOrdLayout.createSequentialGroup()
                                                        .addComponent(PresBus, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                                .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(Afibusc, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(Presbusc1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(FOrdLayout.createSequentialGroup()
                                                .addComponent(nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(GenerarOrd, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(Import, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(FOrdLayout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(idemple, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(texImpo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, FOrdLayout.createSequentialGroup()
                                                        .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(FechaOrd, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, FOrdLayout.createSequentialGroup()
                                                        .addComponent(FormdP, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(FdP, 0, 1, Short.MAX_VALUE))))
                                            .addComponent(jLabel37)
                                            .addGroup(FOrdLayout.createSequentialGroup()
                                                .addComponent(FechaList, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(FechaListOrd, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(2, 2, 2))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FOrdLayout.createSequentialGroup()
                                        .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(listarAfi, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ListarOrd, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(listarPres, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(Sepa4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(FOrdLayout.createSequentialGroup()
                                        .addComponent(LimpiarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(EliLisOrd, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        FOrdLayout.setVerticalGroup(
            FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FOrdLayout.createSequentialGroup()
                .addComponent(Ordenes, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(FOrdLayout.createSequentialGroup()
                            .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tituPrest)
                                .addComponent(IdPres)
                                .addComponent(IdPresta, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(dniPrest, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dniPres))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(InstiP)
                                .addComponent(InstP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(9, 9, 9)
                            .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(FOrdLayout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addComponent(NombP)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ApelP)
                                        .addComponent(ApeP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(NomP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(DomiP)
                                .addComponent(DomP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TelP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TelfP))
                            .addGap(10, 10, 10)
                            .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(CorreP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(correoP)))
                        .addGroup(FOrdLayout.createSequentialGroup()
                            .addComponent(Especi)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TexEspe, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BuscarEspe, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(IdEspe, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(IdEspec, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(EstEsp)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ActP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(InaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(17, 17, 17))
                        .addComponent(Sepa1)
                        .addComponent(Sepa2))
                    .addGroup(FOrdLayout.createSequentialGroup()
                        .addComponent(tituAfil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Docu)
                                .addComponent(Doc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BuscarAfi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EstaA)
                            .addComponent(Act, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Ina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IdAfil)
                            .addComponent(IdAf, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FOrdLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(Nomb))
                            .addComponent(Nom, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Apel)
                            .addComponent(Ape, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Domi)
                            .addComponent(Dom, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Tel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Telf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Sepa3, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Sepa4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FOrdLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EliLisOrd, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LimpiarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5))
                    .addGroup(FOrdLayout.createSequentialGroup()
                        .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(idemple, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Fecha)
                            .addComponent(FechaOrd, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FormdP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FdP, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(texImpo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Import, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(GenerarOrd, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, Short.MAX_VALUE))
                        .addGap(8, 8, 8)
                        .addComponent(jLabel37)
                        .addGap(8, 8, 8)
                        .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FechaListOrd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FechaList, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ListarOrd, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Afibusc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AfiBus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(listarAfi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FOrdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Presbusc1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PresBus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listarPres)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        PanelOt.add(FOrd);

        afili.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/afil (1).png"))); // NOI18N
        afili.setText("AFILIADO");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("ID Afiliado/a :");

        idafiliado.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        idafiliado.setForeground(new java.awt.Color(0, 153, 153));

        jbuscarafi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/buskar.png"))); // NOI18N
        jbuscarafi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbuscarafiMouseClicked(evt);
            }
        });

        IdAfil1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        IdAfil1.setForeground(new java.awt.Color(0, 153, 153));
        IdAfil1.setText("Documento :");

        Nomb1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Nomb1.setForeground(new java.awt.Color(0, 153, 153));
        Nomb1.setText("Nombre/s :");

        Apel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Apel1.setForeground(new java.awt.Color(0, 153, 153));
        Apel1.setText("Apellido/s :");

        documento.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        documento.setForeground(new java.awt.Color(0, 153, 153));
        documento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                documentoActionPerformed(evt);
            }
        });

        nombre.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        nombre.setForeground(new java.awt.Color(0, 153, 153));
        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });

        apellido.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        apellido.setForeground(new java.awt.Color(0, 153, 153));
        apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidoActionPerformed(evt);
            }
        });

        Corre2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Corre2.setForeground(new java.awt.Color(0, 153, 153));
        Corre2.setText("Estado :");

        Telf1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Telf1.setForeground(new java.awt.Color(0, 153, 153));
        Telf1.setText("Telf. o Cel. :");

        Domi1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Domi1.setForeground(new java.awt.Color(0, 153, 153));
        Domi1.setText("Domicilio :");

        telefono.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        telefono.setForeground(new java.awt.Color(0, 153, 153));
        telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoActionPerformed(evt);
            }
        });

        domicilio.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        domicilio.setForeground(new java.awt.Color(0, 153, 153));
        domicilio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                domicilioActionPerformed(evt);
            }
        });

        activo.setBackground(new java.awt.Color(229, 248, 229));
        activo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        activo.setForeground(new java.awt.Color(0, 153, 153));
        activo.setLabel("Activo");
        activo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                activoItemStateChanged(evt);
            }
        });

        inactivo.setBackground(new java.awt.Color(229, 248, 229));
        inactivo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        inactivo.setForeground(new java.awt.Color(0, 153, 153));
        inactivo.setLabel("Inactivo");
        inactivo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                inactivoItemStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("ID Empleado :");

        Guardarafi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/botonguardar95x22.png"))); // NOI18N
        Guardarafi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GuardarafiMouseClicked(evt);
            }
        });

        Modificarafi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/MODIFICAR VERDE 95X22PX.png"))); // NOI18N
        Modificarafi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ModificarafiMouseClicked(evt);
            }
        });

        Eliminarafi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/ELIMINAR VERDE 95X22PX.png"))); // NOI18N
        Eliminarafi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EliminarafiMouseClicked(evt);
            }
        });

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/LISTAR VERDE 167X42 PX.png"))); // NOI18N

        jtAfi.setBackground(new java.awt.Color(229, 243, 229));
        jtAfi.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        jtAfi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtAfi.setForeground(new java.awt.Color(0, 153, 153));
        jtAfi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtAfi.setGridColor(new java.awt.Color(0, 153, 153));
        jScrollPane4.setViewportView(jtAfi);

        Listarafi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/LISTAR VERDE 95X22PX.png"))); // NOI18N
        Listarafi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListarafiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout FAfiLayout = new javax.swing.GroupLayout(FAfi);
        FAfi.setLayout(FAfiLayout);
        FAfiLayout.setHorizontalGroup(
            FAfiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FAfiLayout.createSequentialGroup()
                .addGroup(FAfiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(afili, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(0, 670, Short.MAX_VALUE))
            .addGroup(FAfiLayout.createSequentialGroup()
                .addGroup(FAfiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FAfiLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(FAfiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IdAfil1)
                            .addComponent(Nomb1)
                            .addComponent(Apel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FAfiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FAfiLayout.createSequentialGroup()
                                .addComponent(Guardarafi, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(154, 154, 154)
                                .addComponent(Modificarafi))
                            .addGroup(FAfiLayout.createSequentialGroup()
                                .addComponent(idafiliado, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jbuscarafi))
                            .addGroup(FAfiLayout.createSequentialGroup()
                                .addGroup(FAfiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(FAfiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(nombre)
                                        .addComponent(apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(FAfiLayout.createSequentialGroup()
                                        .addComponent(documento, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(idempleafi, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(12, 12, 12)
                                .addGroup(FAfiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(FAfiLayout.createSequentialGroup()
                                        .addGroup(FAfiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Telf1)
                                            .addComponent(Domi1))
                                        .addGap(18, 18, 18)
                                        .addGroup(FAfiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(domicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(FAfiLayout.createSequentialGroup()
                                        .addComponent(Corre2)
                                        .addGap(51, 51, 51)
                                        .addComponent(activo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(inactivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(Eliminarafi, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(FAfiLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FAfiLayout.createSequentialGroup()
                        .addGap(388, 388, 388)
                        .addComponent(Listarafi)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        FAfiLayout.setVerticalGroup(
            FAfiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FAfiLayout.createSequentialGroup()
                .addGroup(FAfiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(afili, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FAfiLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(FAfiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbuscarafi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(FAfiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(idafiliado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addGroup(FAfiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(FAfiLayout.createSequentialGroup()
                                .addGroup(FAfiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(FAfiLayout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(IdAfil1))
                                    .addGroup(FAfiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(documento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1)))
                                .addGap(8, 8, 8)
                                .addGroup(FAfiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Nomb1)
                                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(FAfiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(apellido)
                                    .addComponent(Apel1)))
                            .addGroup(FAfiLayout.createSequentialGroup()
                                .addGroup(FAfiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Domi1)
                                    .addComponent(domicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(idempleafi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(FAfiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Telf1))
                                .addGap(18, 18, 18)
                                .addGroup(FAfiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Corre2)
                                    .addGroup(FAfiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(activo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(inactivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(44, 44, 44)
                .addGroup(FAfiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Modificarafi, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Guardarafi, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Eliminarafi, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(Listarafi, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        PanelOt.add(FAfi);

        FPres.setMaximumSize(new java.awt.Dimension(880, 780));

        prest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/prestador (1).png"))); // NOI18N

        Apel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Apel2.setForeground(new java.awt.Color(0, 153, 153));
        Apel2.setText("Apellido/s :");

        Nomb2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Nomb2.setForeground(new java.awt.Color(0, 153, 153));
        Nomb2.setText("Nombre/s :");

        IdAfil2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        IdAfil2.setForeground(new java.awt.Color(0, 153, 153));
        IdAfil2.setText("Documento :");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 153));
        jLabel11.setText("ID Prestador :");

        idprestador.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        idprestador.setForeground(new java.awt.Color(0, 153, 153));

        dnipre.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        dnipre.setForeground(new java.awt.Color(0, 153, 153));
        dnipre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dnipreActionPerformed(evt);
            }
        });

        institucion.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        institucion.setForeground(new java.awt.Color(0, 153, 153));
        institucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                institucionActionPerformed(evt);
            }
        });

        email.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        email.setForeground(new java.awt.Color(0, 153, 153));
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        buscarpre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/buskar.png"))); // NOI18N
        buscarpre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarpreMouseClicked(evt);
            }
        });

        Domi2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Domi2.setForeground(new java.awt.Color(0, 153, 153));
        Domi2.setText("Domicilio :");

        Telf2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Telf2.setForeground(new java.awt.Color(0, 153, 153));
        Telf2.setText("Telf. o Cel. :");

        Corre3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Corre3.setForeground(new java.awt.Color(0, 153, 153));
        Corre3.setText("Estado :");

        actpre.setBackground(new java.awt.Color(229, 248, 229));
        actpre.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        actpre.setForeground(new java.awt.Color(0, 153, 153));
        actpre.setLabel("Activo");
        actpre.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                actpreItemStateChanged(evt);
            }
        });

        inapre.setBackground(new java.awt.Color(229, 248, 229));
        inapre.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        inapre.setForeground(new java.awt.Color(0, 153, 153));
        inapre.setLabel("Inactivo");
        inapre.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                inapreItemStateChanged(evt);
            }
        });

        telpre.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        telpre.setForeground(new java.awt.Color(0, 153, 153));
        telpre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telpreActionPerformed(evt);
            }
        });

        dompre.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        dompre.setForeground(new java.awt.Color(0, 153, 153));
        dompre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dompreActionPerformed(evt);
            }
        });

        nompre.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        nompre.setForeground(new java.awt.Color(0, 153, 153));
        nompre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nompreActionPerformed(evt);
            }
        });

        Nomb3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Nomb3.setForeground(new java.awt.Color(0, 153, 153));
        Nomb3.setText("Institucion:");

        Apel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Apel3.setForeground(new java.awt.Color(0, 153, 153));
        Apel3.setText("Email:");

        apepre.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        apepre.setForeground(new java.awt.Color(0, 153, 153));
        apepre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apepreActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setText("Especialidad:");

        idespe.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        idespe.setForeground(new java.awt.Color(0, 153, 153));

        guardarpre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/botonguardar95x22.png"))); // NOI18N
        guardarpre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarpreMouseClicked(evt);
            }
        });

        modipre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/MODIFICAR VERDE 95X22PX.png"))); // NOI18N
        modipre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modipreMouseClicked(evt);
            }
        });

        elipre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/ELIMINAR VERDE 95X22PX.png"))); // NOI18N
        elipre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                elipreMouseClicked(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/LISTAR VERDE 167X42 PX.png"))); // NOI18N

        jtpre.setBackground(new java.awt.Color(229, 243, 229));
        jtpre.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        jtpre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jtpre.setForeground(new java.awt.Color(0, 153, 153));
        jtpre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtpre.setGridColor(new java.awt.Color(0, 153, 153));
        jScrollPane2.setViewportView(jtpre);

        listarpre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/LISTAR VERDE 95X22PX.png"))); // NOI18N
        listarpre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listarpreMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout FPresLayout = new javax.swing.GroupLayout(FPres);
        FPres.setLayout(FPresLayout);
        FPresLayout.setHorizontalGroup(
            FPresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FPresLayout.createSequentialGroup()
                .addComponent(prest)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(FPresLayout.createSequentialGroup()
                .addGroup(FPresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FPresLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(FPresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IdAfil2)
                            .addComponent(Nomb2)
                            .addComponent(Apel2)
                            .addComponent(jLabel11)
                            .addComponent(Nomb3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FPresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FPresLayout.createSequentialGroup()
                                .addComponent(idprestador, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(buscarpre))
                            .addGroup(FPresLayout.createSequentialGroup()
                                .addGroup(FPresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(FPresLayout.createSequentialGroup()
                                        .addGroup(FPresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(FPresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(institucion)
                                                .addComponent(apepre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(nompre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(guardarpre))
                                        .addGap(23, 23, 23))
                                    .addGroup(FPresLayout.createSequentialGroup()
                                        .addComponent(dnipre)
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(FPresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(FPresLayout.createSequentialGroup()
                                        .addComponent(idespe, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addGroup(FPresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(FPresLayout.createSequentialGroup()
                                                .addGroup(FPresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(Telf2)
                                                    .addComponent(Domi2))
                                                .addGap(18, 18, 18)
                                                .addGroup(FPresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(telpre)
                                                    .addComponent(dompre)))
                                            .addGroup(FPresLayout.createSequentialGroup()
                                                .addGroup(FPresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(Corre3)
                                                    .addComponent(Apel3))
                                                .addGap(51, 51, 51)
                                                .addGroup(FPresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(FPresLayout.createSequentialGroup()
                                                        .addComponent(actpre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(inapre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(FPresLayout.createSequentialGroup()
                                        .addComponent(modipre)
                                        .addGap(186, 186, 186)
                                        .addComponent(elipre)
                                        .addGap(29, 29, 29))))))
                    .addGroup(FPresLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15)))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FPresLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(FPresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FPresLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FPresLayout.createSequentialGroup()
                        .addComponent(listarpre)
                        .addGap(382, 382, 382))))
        );
        FPresLayout.setVerticalGroup(
            FPresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FPresLayout.createSequentialGroup()
                .addComponent(prest)
                .addGap(24, 24, 24)
                .addGroup(FPresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(FPresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(idprestador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buscarpre))
                .addGap(24, 24, 24)
                .addGroup(FPresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FPresLayout.createSequentialGroup()
                        .addGroup(FPresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FPresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Domi2)
                                .addComponent(idespe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dompre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FPresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telpre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Telf2)))
                    .addGroup(FPresLayout.createSequentialGroup()
                        .addGroup(FPresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FPresLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(IdAfil2))
                            .addComponent(jLabel9)
                            .addComponent(dnipre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(FPresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Nomb2)
                            .addComponent(nompre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(13, 13, 13)
                .addGroup(FPresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FPresLayout.createSequentialGroup()
                        .addComponent(apepre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(FPresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(institucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Nomb3))
                        .addGap(42, 42, 42))
                    .addGroup(FPresLayout.createSequentialGroup()
                        .addGroup(FPresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Apel2)
                            .addGroup(FPresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Corre3)
                                .addGroup(FPresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(actpre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inapre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FPresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Apel3)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)))
                .addGroup(FPresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(elipre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(guardarpre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modipre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(listarpre, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 78, Short.MAX_VALUE))
        );

        PanelOt.add(FPres);

        espe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/espe (1).png"))); // NOI18N
        espe.setText("ESPECIALISTA");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 153, 153));
        jLabel29.setText("ID Especialidad:");

        idespecialidad.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        idespecialidad.setForeground(new java.awt.Color(0, 153, 153));

        buscarespe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/BUSCAR VERDE 95X22PX.png"))); // NOI18N
        buscarespe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarespeMouseClicked(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 153, 153));
        jLabel31.setText("Nombre:");

        nomespe.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        nomespe.setForeground(new java.awt.Color(0, 153, 153));

        Corre5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Corre5.setForeground(new java.awt.Color(0, 153, 153));
        Corre5.setText("Estado :");

        actespe.setBackground(new java.awt.Color(229, 248, 229));
        actespe.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        actespe.setForeground(new java.awt.Color(0, 153, 153));
        actespe.setLabel("Activo");
        actespe.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                actespeItemStateChanged(evt);
            }
        });

        inaespe.setBackground(new java.awt.Color(229, 248, 229));
        inaespe.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        inaespe.setForeground(new java.awt.Color(0, 153, 153));
        inaespe.setLabel("Inactivo");
        inaespe.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                inaespeItemStateChanged(evt);
            }
        });

        guardarespe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/botonguardar95x22.png"))); // NOI18N
        guardarespe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarespeMouseClicked(evt);
            }
        });

        modiespe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/MODIFICAR VERDE 95X22PX.png"))); // NOI18N
        modiespe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modiespeMouseClicked(evt);
            }
        });

        eliespe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/ELIMINAR VERDE 95X22PX.png"))); // NOI18N
        eliespe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliespeMouseClicked(evt);
            }
        });

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/LISTAR VERDE 167X42 PX.png"))); // NOI18N

        jespe.setBackground(new java.awt.Color(229, 243, 229));
        jespe.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        jespe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jespe.setForeground(new java.awt.Color(0, 153, 153));
        jespe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jespe.setGridColor(new java.awt.Color(0, 153, 153));
        jScrollPane5.setViewportView(jespe);

        listarespe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/LISTAR VERDE 95X22PX.png"))); // NOI18N
        listarespe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listarespeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout FEspLayout = new javax.swing.GroupLayout(FEsp);
        FEsp.setLayout(FEspLayout);
        FEspLayout.setHorizontalGroup(
            FEspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FEspLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FEspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FEspLayout.createSequentialGroup()
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FEspLayout.createSequentialGroup()
                        .addGap(0, 90, Short.MAX_VALUE)
                        .addGroup(FEspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FEspLayout.createSequentialGroup()
                                .addGroup(FEspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Corre5)
                                    .addComponent(jLabel29))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(FEspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(FEspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(FEspLayout.createSequentialGroup()
                                            .addComponent(actespe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(inaespe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(nomespe, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(FEspLayout.createSequentialGroup()
                                        .addComponent(modiespe)
                                        .addGap(118, 118, 118)
                                        .addComponent(eliespe))
                                    .addGroup(FEspLayout.createSequentialGroup()
                                        .addComponent(idespecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(buscarespe)))
                                .addGap(256, 256, 256))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FEspLayout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(218, 218, 218))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FEspLayout.createSequentialGroup()
                                .addComponent(guardarespe, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(690, 690, 690))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FEspLayout.createSequentialGroup()
                                .addComponent(listarespe, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(426, 426, 426))))))
            .addGroup(FEspLayout.createSequentialGroup()
                .addComponent(espe, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        FEspLayout.setVerticalGroup(
            FEspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FEspLayout.createSequentialGroup()
                .addComponent(espe)
                .addGap(38, 38, 38)
                .addGroup(FEspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscarespe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FEspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29)
                        .addComponent(idespecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(FEspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(nomespe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(FEspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Corre5)
                    .addGroup(FEspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(actespe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inaespe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(FEspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FEspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(modiespe, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(eliespe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(guardarespe, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(listarespe, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
        );

        PanelOt.add(FEsp);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/emple (1).png"))); // NOI18N
        jLabel6.setText("EMPLEADO");

        actemp.setBackground(new java.awt.Color(229, 248, 229));
        actemp.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        actemp.setForeground(new java.awt.Color(0, 153, 153));
        actemp.setLabel("Activo");
        actemp.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                actempItemStateChanged(evt);
            }
        });

        Nomb4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Nomb4.setForeground(new java.awt.Color(0, 153, 153));
        Nomb4.setText("Usuario:");

        inaemp.setBackground(new java.awt.Color(229, 248, 229));
        inaemp.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        inaemp.setForeground(new java.awt.Color(0, 153, 153));
        inaemp.setLabel("Inactivo");
        inaemp.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                inaempItemStateChanged(evt);
            }
        });

        Apel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Apel4.setForeground(new java.awt.Color(0, 153, 153));
        Apel4.setText("Contraseña:");

        dniemp.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        dniemp.setForeground(new java.awt.Color(0, 153, 153));
        dniemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dniempActionPerformed(evt);
            }
        });

        nomemp.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        nomemp.setForeground(new java.awt.Color(0, 153, 153));
        nomemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomempActionPerformed(evt);
            }
        });

        apeemp.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        apeemp.setForeground(new java.awt.Color(0, 153, 153));
        apeemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apeempActionPerformed(evt);
            }
        });

        Corre4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Corre4.setForeground(new java.awt.Color(0, 153, 153));
        Corre4.setText("Estado :");

        Telf3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Telf3.setForeground(new java.awt.Color(0, 153, 153));
        Telf3.setText("Telf. o Cel. :");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 153, 153));
        jLabel18.setText("ID Empleado :");

        Domi3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Domi3.setForeground(new java.awt.Color(0, 153, 153));
        Domi3.setText("Clave Acceso:");

        idempleado.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        idempleado.setForeground(new java.awt.Color(0, 153, 153));

        telemp.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        telemp.setForeground(new java.awt.Color(0, 153, 153));
        telemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telempActionPerformed(evt);
            }
        });

        buscaremp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/buskar.png"))); // NOI18N
        buscaremp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarempMouseClicked(evt);
            }
        });

        clave.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        clave.setForeground(new java.awt.Color(0, 153, 153));
        clave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                claveActionPerformed(evt);
            }
        });

        IdAfil3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        IdAfil3.setForeground(new java.awt.Color(0, 153, 153));
        IdAfil3.setText("Documento :");

        Nomb5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Nomb5.setForeground(new java.awt.Color(0, 153, 153));
        Nomb5.setText("Nombre/s :");

        Apel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Apel5.setForeground(new java.awt.Color(0, 153, 153));
        Apel5.setText("Apellido/s :");

        usuario.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        usuario.setForeground(new java.awt.Color(0, 153, 153));
        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });

        contra.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        contra.setForeground(new java.awt.Color(0, 153, 153));
        contra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contraActionPerformed(evt);
            }
        });

        guardaremp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/botonguardar95x22.png"))); // NOI18N
        guardaremp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarempMouseClicked(evt);
            }
        });

        modiemp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/MODIFICAR VERDE 95X22PX.png"))); // NOI18N
        modiemp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modiempMouseClicked(evt);
            }
        });

        elimemp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/ELIMINAR VERDE 95X22PX.png"))); // NOI18N
        elimemp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                elimempMouseClicked(evt);
            }
        });

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/LISTAR VERDE 167X42 PX.png"))); // NOI18N

        jemp.setBackground(new java.awt.Color(229, 243, 229));
        jemp.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        jemp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jemp.setForeground(new java.awt.Color(0, 153, 153));
        jemp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jemp.setGridColor(new java.awt.Color(0, 153, 153));
        jScrollPane3.setViewportView(jemp);

        listaremp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/LISTAR VERDE 95X22PX.png"))); // NOI18N
        listaremp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listarempMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout FEmpLayout = new javax.swing.GroupLayout(FEmp);
        FEmp.setLayout(FEmpLayout);
        FEmpLayout.setHorizontalGroup(
            FEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FEmpLayout.createSequentialGroup()
                .addGroup(FEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(0, 680, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FEmpLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(listaremp)
                .addGap(402, 402, 402))
            .addGroup(FEmpLayout.createSequentialGroup()
                .addGroup(FEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FEmpLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(FEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addGroup(FEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(IdAfil3)
                                .addComponent(Nomb4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Apel4, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(Apel5)
                            .addComponent(Nomb5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FEmpLayout.createSequentialGroup()
                                .addComponent(idempleado, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(buscaremp))
                            .addGroup(FEmpLayout.createSequentialGroup()
                                .addGroup(FEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(FEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(nomemp)
                                        .addComponent(apeemp, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(dniemp, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(FEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(usuario)
                                        .addComponent(contra, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(74, 74, 74)
                                .addGroup(FEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(FEmpLayout.createSequentialGroup()
                                        .addGroup(FEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Telf3)
                                            .addComponent(Domi3))
                                        .addGap(18, 18, 18)
                                        .addGroup(FEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(clave, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(telemp, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(FEmpLayout.createSequentialGroup()
                                        .addComponent(Corre4)
                                        .addGap(51, 51, 51)
                                        .addComponent(actemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(inaemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(FEmpLayout.createSequentialGroup()
                                .addComponent(guardaremp)
                                .addGap(140, 140, 140)
                                .addComponent(modiemp)
                                .addGap(134, 134, 134)
                                .addComponent(elimemp))))
                    .addGroup(FEmpLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        FEmpLayout.setVerticalGroup(
            FEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FEmpLayout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(24, 24, 24)
                .addGroup(FEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(idempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buscaremp))
                .addGroup(FEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FEmpLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(clave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(FEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Telf3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Corre4)
                            .addGroup(FEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(actemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(inaemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(FEmpLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(FEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(FEmpLayout.createSequentialGroup()
                                .addComponent(Domi3)
                                .addGap(38, 38, 38))
                            .addGroup(FEmpLayout.createSequentialGroup()
                                .addGroup(FEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(FEmpLayout.createSequentialGroup()
                                        .addComponent(IdAfil3)
                                        .addGap(12, 12, 12))
                                    .addGroup(FEmpLayout.createSequentialGroup()
                                        .addComponent(dniemp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(FEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nomemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Nomb5))
                                .addGap(10, 10, 10)))
                        .addGroup(FEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(apeemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Apel5))
                        .addGroup(FEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FEmpLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(Nomb4))
                            .addGroup(FEmpLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Apel4)
                            .addComponent(contra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(46, 46, 46)
                .addGroup(FEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(elimemp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modiemp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(guardaremp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(listaremp, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 36, Short.MAX_VALUE))
        );

        PanelOt.add(FEmp);

        getContentPane().add(PanelOt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 780));

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void PEmplMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PEmplMouseClicked
    // TODO add your handling code here:
    FInicio.setVisible(false);
    FEmp.setVisible(true);
    FOrd.setVisible(false);
    FAfi.setVisible(false);
    FPres.setVisible(false);
    FEsp.setVisible(false);
    FEmp.setVisible(true);
    Empl.setForeground(new Color(0, 204, 204));
    Espe.setForeground(new Color(204, 102, 0));
    Prest.setForeground(new Color(204, 102, 0));
    Afil.setForeground(new Color(204, 102, 0));
    Orden.setForeground(new Color(204, 102, 0));
    POrden.setBackground(new Color(0, 204, 204));
    PAfil.setBackground(new Color(0, 204, 204));
    PPrest.setBackground(new Color(0, 204, 204));
    PEspe.setBackground(new Color(0, 204, 204));
    PEmpl.setBackground(new Color(204, 102, 0));
  }//GEN-LAST:event_PEmplMouseClicked

  private void PEspeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PEspeMouseClicked
    // TODO add your handling code here:
    FInicio.setVisible(false);
    FEsp.setVisible(true);
    FOrd.setVisible(false);
    FAfi.setVisible(false);
    FPres.setVisible(false);
    FEmp.setVisible(false);
    Espe.setForeground(new Color(0, 204, 204));
    Prest.setForeground(new Color(204, 102, 0));
    Afil.setForeground(new Color(204, 102, 0));
    Orden.setForeground(new Color(204, 102, 0));
    Empl.setForeground(new Color(204, 102, 0));
    POrden.setBackground(new Color(0, 204, 204));
    PAfil.setBackground(new Color(0, 204, 204));
    PPrest.setBackground(new Color(0, 204, 204));
    PEspe.setBackground(new Color(204, 102, 0));
    PEmpl.setBackground(new Color(0, 204, 204));
  }//GEN-LAST:event_PEspeMouseClicked

  private void PPrestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PPrestMouseClicked
    // TODO add your handling code here:
    FInicio.setVisible(false);
    FPres.setVisible(true);
    FOrd.setVisible(false);
    FAfi.setVisible(false);
    FEsp.setVisible(false);
    FEmp.setVisible(false);
    Prest.setForeground(new Color(0, 204, 204));
    Afil.setForeground(new Color(204, 102, 0));
    Orden.setForeground(new Color(204, 102, 0));
    Espe.setForeground(new Color(204, 102, 0));
    Empl.setForeground(new Color(204, 102, 0));
    POrden.setBackground(new Color(0, 204, 204));
    PAfil.setBackground(new Color(0, 204, 204));
    PPrest.setBackground(new Color(204, 102, 0));
    PEspe.setBackground(new Color(0, 204, 204));
    PEmpl.setBackground(new Color(0, 204, 204));
  }//GEN-LAST:event_PPrestMouseClicked

  private void PAfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PAfilMouseClicked
    // TODO add your handling code here:
    FInicio.setVisible(false);
    FAfi.setVisible(true);
    FOrd.setVisible(false);

    FPres.setVisible(false);
    FEsp.setVisible(false);
    FEmp.setVisible(false);
    Afil.setForeground(new Color(0, 204, 204));
    Orden.setForeground(new Color(204, 102, 0));
    Prest.setForeground(new Color(204, 102, 0));
    Espe.setForeground(new Color(204, 102, 0));
    Empl.setForeground(new Color(204, 102, 0));
    POrden.setBackground(new Color(0, 204, 204));
    PAfil.setBackground(new Color(204, 102, 0));
    PPrest.setBackground(new Color(0, 204, 204));
    PEspe.setBackground(new Color(0, 204, 204));
    PEmpl.setBackground(new Color(0, 204, 204));
  }//GEN-LAST:event_PAfilMouseClicked

  private void POrdenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_POrdenMouseClicked
    // TODO add your handling code here:
    FInicio.setVisible(false);
    FOrd.setVisible(true);
    FAfi.setVisible(false);
    FPres.setVisible(false);
    FEsp.setVisible(false);
    FEmp.setVisible(false);
    Orden.setForeground(new Color(0, 204, 204));
    Afil.setForeground(new Color(204, 102, 0));
    Prest.setForeground(new Color(204, 102, 0));
    Espe.setForeground(new Color(204, 102, 0));
    Empl.setForeground(new Color(204, 102, 0));
    POrden.setBackground(new Color(204, 102, 0));
    PAfil.setBackground(new Color(0, 204, 204));
    PPrest.setBackground(new Color(0, 204, 204));
    PEspe.setBackground(new Color(0, 204, 204));
    PEmpl.setBackground(new Color(0, 204, 204));
  }//GEN-LAST:event_POrdenMouseClicked

  private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
    // TODO add your handling code here:
    cerrarWin();
  }//GEN-LAST:event_SalirActionPerformed

  private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    // TODO add your handling code here:    
    cerrarWin();
  }//GEN-LAST:event_formWindowClosing

  private void BuscarAfiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarAfiActionPerformed
//     TODO add your handling code here:      

    try {
      Integer dni = Integer.parseInt(Doc.getText());
      afiliadoActualDni = afiData.buscarAfiliadoPorDni(dni);
      if (afiliadoActualDni != null) {
        Nom.setText(afiliadoActualDni.getNombre());
        Ape.setText(afiliadoActualDni.getApellido());
        IdAf.setText(Integer.toString(afiliadoActualDni.getIdafiliaado()));
        Dom.setText(afiliadoActualDni.getDomicilio());
        Tel.setText(Integer.toString(afiliadoActualDni.getTelefono()));
        if (afiliadoActualDni.isEstado() == true) {
          Act.setState(true);
          Ina.setState(false);
        } else {
          Ina.setState(true);
          Act.setState(false);
        }
      }
    } catch (NumberFormatException ex) {
      String mensajea = "Ingrese DNI de Afiliado Válido";
      UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 18));
      UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
      UIManager.put("OptionPane.buttonFont", new Font("Segoe UI", Font.BOLD, 16));
      UIManager.put("OptionPane.buttonForeground", new Color(204, 204, 0));
      ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
      JOptionPane.showMessageDialog(this, mensajea, "  Búsqueda Fallida ", JOptionPane.PLAIN_MESSAGE, icono);
    }
  }//GEN-LAST:event_BuscarAfiActionPerformed

  private void TelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_TelActionPerformed

  private void DomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DomActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_DomActionPerformed

  private void ApeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApeActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_ApeActionPerformed

  private void NomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_NomActionPerformed

  private void IdAfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdAfActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_IdAfActionPerformed

  private void DocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DocActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_DocActionPerformed

  private void FdPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FdPActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_FdPActionPerformed


  private void NomPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomPActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_NomPActionPerformed

  private void ApePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApePActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_ApePActionPerformed

  private void DomPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DomPActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_DomPActionPerformed

  private void TelPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelPActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_TelPActionPerformed

  private void InstPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InstPActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_InstPActionPerformed

  private void CorrePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CorrePActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_CorrePActionPerformed

  private void TexEspeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TexEspeActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_TexEspeActionPerformed

  private void BuscarEspeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarEspeActionPerformed
    // TODO add your handling code here:
    try {
      String nombreEsp = TexEspe.getText();
      List<Prestador> prestadores = presData.buscarPrestadoresPorEspecialidad(nombreEsp);
      if (!prestadores.isEmpty()) {
        Prestador prestadorElegido = elegirPrestadorPorEspecialidad(prestadores);
        if (prestadorElegido != null) {

          IdPresta.setText(Integer.toString(prestadorElegido.getIdPrestador()));
          IdEspec.setText(Integer.toString(prestadorElegido.getEspecialidad().getIdEspecialidad())); // Obtén el ID de la especialidad
          dniPrest.setText(Integer.toString(prestadorElegido.getDni()));
          InstP.setText(prestadorElegido.getInstitucion());
          NomP.setText(prestadorElegido.getNombre());
          ApeP.setText(prestadorElegido.getApellido());
          DomP.setText(prestadorElegido.getDireccion());
          TelP.setText(prestadorElegido.getTelefono());
          CorreP.setText(prestadorElegido.getEmail());
          if (prestadorElegido.isEstado() == true) {
            ActP.setState(true);
            InaP.setState(false);
          } else {
            InaP.setState(true);
            ActP.setState(false);
          }
        }
      } else {
        String mensaje = "No Existe prestador:'" + nombreEsp + "'.";
        UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
        UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
        UIManager.put("OptionPane.buttonFont", new Font("Segoe UI", Font.BOLD, 16));
        UIManager.put("OptionPane.buttonForeground", new Color(204, 204, 0));
        ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
        JOptionPane.showMessageDialog(this, mensaje, "Búsqueda Fallida", JOptionPane.PLAIN_MESSAGE, icono);
      }
    } catch (NumberFormatException ex) {
      String nombreEsp = TexEspe.getText();
      String mensaje = "No Existe prestador:'" + nombreEsp + "'.";
      UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
      UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
      UIManager.put("OptionPane.buttonFont", new Font("Segoe UI", Font.BOLD, 16));
      UIManager.put("OptionPane.buttonForeground", new Color(204, 204, 0));
      ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
      JOptionPane.showMessageDialog(this, mensaje, "Búsqueda Fallida", JOptionPane.PLAIN_MESSAGE, icono);
    }
  }//GEN-LAST:event_BuscarEspeActionPerformed

  private void GenerarOrdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarOrdActionPerformed
    // TODO add your handling code here:   

    try {

      String formaDePago = (String) FdP.getSelectedItem();
      double importe = Double.parseDouble(texImpo.getText());
      int IdA = Integer.parseInt(IdAf.getText());
      int dniA = Integer.parseInt(Doc.getText());
      int Tf = Integer.parseInt(Tel.getText());
      int IdP = Integer.parseInt(IdPresta.getText());
      int IdE = Integer.parseInt(idemple.getText());
      int dniP = Integer.parseInt(dniPrest.getText());
      if (formaDePago.isEmpty() || texImpo.getText().isEmpty() || IdAf.getText().isEmpty()
              || Doc.getText().isEmpty() || Tel.getText().isEmpty() || IdPresta.getText().isEmpty() || idemple.getText().isEmpty()) {
        String mensaje = "Llenar todos los campos .";
        UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
        UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
        ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
        return;
      }

      java.util.Date fechaActual = new java.util.Date();
      java.util.Date fechaSeleccionada = FechaOrd.getDate();

      if (fechaSeleccionada == null) {
        String mensaje = "Seleccionar una fecha válida";
        UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
        UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
        ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
        return;
      }

//      if (fechaSeleccionada.before(fechaActual)) {
//        String mensaje = "La fecha seleccionada es anterior a la fecha actual.";
//        UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
//        UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
//        ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
//        JOptionPane.showMessageDialog(this, mensaje, "Advertencia", JOptionPane.PLAIN_MESSAGE, icono);
//        return;
//      }

      LocalDate fecha = fechaSeleccionada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

      Empleado Emple = EmpData.buscarEmpleado(IdE);
      boolean estadoEsp = ActP.getState();
      int IdEs = Integer.parseInt(IdEspec.getText());
      Especialidad Espe = new Especialidad(IdEs, TexEspe.getText(), estadoEsp);
      boolean estadoAfiliado = Act.getState();

      if (!estadoAfiliado) {
        String mensaje = "No puede sacar órdenes, Afiliado Inactivo.";
        UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
        UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
        ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);

        return;
      }

      if (!estadoEsp) {

        String mensaje = "No puede sacar órdenes, Prestador Inactivo.";
        UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
        UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
        ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);

        return;
      }

      OrdenData ordData = new OrdenData();
      List<Orden> ordenesExist = ordData.buscarOrdenesPorAfiliado(IdA);
      for (Orden ordenExistente : ordenesExist) {
        if (ordenExistente.getPrestador().getIdPrestador() == IdP && ordenExistente.getFecha().isEqual(fecha)) {
          String mensaje = "El afiliado ya tiene una ORDEN para el MISMO PRESTADOR en la MISMA FECHA.";
          UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
          UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
          ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
          JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);

          return;
        }
      }
      Afiliado afiliado = new Afiliado(IdA, Nom.getText(), Ape.getText(), dniA, Dom.getText(), Tf, Emple, estadoAfiliado);
      Prestador prestador = new Prestador(IdP, NomP.getText(), ApeP.getText(), dniP, InstP.getText(), DomP.getText(), TelP.getText(), CorreP.getText(), Espe, estadoEsp);

      Orden od = new Orden(fecha, formaDePago, importe, afiliado, prestador);

      OrdenData ord = new OrdenData();
      ord.guardarOrden(od);
//      String mensaje = "Orden guardada exitosamente.";
//      UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
//      UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
//      ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
//      JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.PLAIN_MESSAGE, icono);

//    } catch (NumberFormatException ex) {
//        JOptionPane.showMessageDialog(null, "Datos mal ingresados. Asegúrate de ingresar números válidos en los campos numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception ex) {
      String mensaje = "Error inesperado: ";
      UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
      UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
      ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
      JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
    }
  }//GEN-LAST:event_GenerarOrdActionPerformed


  private void IdPrestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdPrestaActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_IdPrestaActionPerformed

  private void texImpoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texImpoActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_texImpoActionPerformed

  private void IdEspecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdEspecActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_IdEspecActionPerformed

  private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
    // TODO add your handling code here:
    LimpiarForm();
    Orden = null;

  }//GEN-LAST:event_nuevoActionPerformed
  private void LimpiarForm() {
    Doc.setText("");
    Nom.setText("");
    Ape.setText("");
    IdAf.setText("");
    Dom.setText("");
    Tel.setText("");
    Act.setState(false);

    IdPresta.setText("");
    dniPrest.setText("");
    NomP.setText("");
    ApeP.setText("");
    InstP.setText("");
    IdAf.setText("");
    DomP.setText("");
    TelP.setText("");
    CorreP.setText("");

    TexEspe.setText("");
    IdEspec.setText("");
    ActP.setState(false);
    InaP.setState(false);

    FechaOrd.setDate(new Date());
    FdP.setSelectedIndex(0);
    texImpo.setText("");

  }


  private void idempleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idempleActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_idempleActionPerformed

  private void dniPrestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniPrestActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_dniPrestActionPerformed

  private void ListarOrdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListarOrdActionPerformed
    // TODO add your handling code here:
   java.util.Date fechaSeleccionada = FechaListOrd.getDate();
    LocalDate fecha = fechaSeleccionada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

    OrdenData Od = new OrdenData();
    List<Orden> ordenesEnFecha = Od.buscarOrdenesPorFecha(fecha);

    if (ordenesEnFecha.isEmpty()) {
       String mensaje = "No se encontraron ordenes en la fecha seleccionada. ";
      UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
      UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
      ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
      JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
      
    } else {
        for (Orden o : ordenesEnFecha) {
            TLOrd.addRow(new Object[]{o.getIdOrden(), o.getFecha(), o.getFormaDePago(), o.getImporte(), o.getAfiliado().getIdafiliaado(), o.getPrestador().getIdPrestador()});
        }
    }

  }//GEN-LAST:event_ListarOrdActionPerformed

  private void EliLisOrdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliLisOrdActionPerformed
    // TODO add your handling code here:


 
    int fila = TListOrd.getSelectedRow();

    if (fila >= 0) {
  
      int idOrden = (int) TLOrd.getValueAt(fila, 0);

     
      OrdenData Od = new OrdenData();
      Od.eliminarPorFila("idOrden", Integer.toString(idOrden));

   
      TLOrd.removeRow(fila);
    } else {
      String mensaje = "Selecciona una fila de la tabla para eliminar una orden. ";
      UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
      UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
      ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
      JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);

    }


  }//GEN-LAST:event_EliLisOrdActionPerformed

  private void LimpiarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarTablaActionPerformed
    // TODO add your handling code here:
    int filas=TLOrd.getRowCount();
    for(int i=0;i<filas;i++){
      TLOrd.removeRow(0);
    }
    Afibusc.setText("");
    Presbusc1.setText("");
  }//GEN-LAST:event_LimpiarTablaActionPerformed

  private void AfibuscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfibuscActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_AfibuscActionPerformed

  private void Presbusc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Presbusc1ActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_Presbusc1ActionPerformed

    private void dompreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dompreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dompreActionPerformed

    private void telpreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telpreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telpreActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void institucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_institucionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_institucionActionPerformed

    private void dnipreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dnipreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dnipreActionPerformed

    private void nompreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nompreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nompreActionPerformed

    private void apepreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apepreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apepreActionPerformed

    private void dniempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniempActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dniempActionPerformed

    private void nomempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomempActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomempActionPerformed

    private void apeempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apeempActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apeempActionPerformed

    private void telempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telempActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telempActionPerformed

    private void claveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_claveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_claveActionPerformed

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioActionPerformed

    private void contraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contraActionPerformed

    private void domicilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_domicilioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_domicilioActionPerformed

    private void telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoActionPerformed

    private void apellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidoActionPerformed

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void documentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_documentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_documentoActionPerformed

    private void listarAfiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listarAfiMouseClicked
        borrarF();
        try {
            int idafi = Integer.parseInt(Afibusc.getText());
            List <Orden> afi= od.buscarOrdenesPorAfiliado(idafi);
            
           
                if (afi.isEmpty()) {
                    
                    String mensaje = "No existe Afiliado!! ";
                    UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
                    UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
                    ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
                    JOptionPane.showMessageDialog(null, mensaje, "Afiliado no encontrado", JOptionPane.PLAIN_MESSAGE, icono);

                } else {
                     for (Orden o : od.buscarOrdenesPorAfiliado(idafi)) {
                    TLOrd.addRow(new Object[]{o.getIdOrden(), o.getFecha(), o.getFormaDePago(), o.getImporte(), o.getAfiliado().getIdafiliaado(), o.getPrestador().getIdPrestador()});
                }
            }
            
            
            
        } catch (Exception e) {
             String mensaje = "Error al ingresar ID Afiliado ";
      UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
      UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
      ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
      JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
           Afibusc.setText("");
        }
        
        
        
    }//GEN-LAST:event_listarAfiMouseClicked

    private void listarPresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listarPresMouseClicked
        borrarF();
        try {
            int idpre = Integer.parseInt(Presbusc1.getText());
            List<Orden> pres = od.buscarOrdenesPorPrestador(idpre);
            if (pres.isEmpty()) {
                String mensaje = "Prestador no Existe!! ";
                UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
                UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
                ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
                JOptionPane.showMessageDialog(null, mensaje, "Prestador no encontrado", JOptionPane.PLAIN_MESSAGE, icono);
            } else {
                for (Orden o : od.buscarOrdenesPorPrestador(idpre)) {

                    TLOrd.addRow(new Object[]{o.getIdOrden(), o.getFecha(), o.getFormaDePago(), o.getImporte(), o.getAfiliado().getIdafiliaado(), o.getPrestador().getIdPrestador()});

                }
            }
            
            
            
        } catch (Exception e) {
              String mensaje = "Error al ingresar ID Prestador ";
      UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
      UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
      ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
      JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
           Presbusc1.setText("");
        }
        
        
        
    }//GEN-LAST:event_listarPresMouseClicked

    private void GuardarafiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GuardarafiMouseClicked
       
          try{
            AfiliadoData ad= new AfiliadoData();
            EmpleadoData ed=new EmpleadoData();
            if(nombre.getText().isEmpty() || apellido.getText().isEmpty() || domicilio.getText().isEmpty() || documento.getText().isEmpty() || idempleafi.getText().isEmpty()
                    || telefono.getText().isEmpty()){
                String mensaje = "LLenar con todos los datos pot favor!! ";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Datos mal ingresados", JOptionPane.PLAIN_MESSAGE, icono);
            }else{
            int ide=Integer.parseInt(idempleafi.getText());
            int dni=Integer.parseInt(documento.getText());
            int tel=Integer.parseInt(telefono.getText());
            boolean act= activo.getState();
            Empleado e= ed.buscarEmpleado(ide);
            Afiliado a= new Afiliado(nombre.getText(),apellido.getText(),dni,domicilio.getText(),tel,e,act);
            ad.guardarAfiliado(a);
             nombre.setText("");
            apellido.setText("");
            documento.setText("");
            idempleafi.setText("");
            telefono.setText("");
            activo.setState(false);
            domicilio.setText("");
            }

        } catch (NumberFormatException e) {
            String mensaje = "Error al ingresar datos de Afiliado, Ingrese Nuevamente ";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
            
        }
        
        
        
    }//GEN-LAST:event_GuardarafiMouseClicked

    private void jbuscarafiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbuscarafiMouseClicked
         try{
            int ida = Integer.parseInt(idafiliado.getText());
            Afiliado a = afiData.buscarAfiliado(ida);
            if (a != null) {
                documento.setText(Integer.toString(a.getDni()));
                nombre.setText(a.getNombre());
                apellido.setText(a.getApellido());
                idempleafi.setText(Integer.toString(a.getEmpleado().getIdEmpleado()));
                domicilio.setText(a.getDomicilio());
                telefono.setText(Integer.toString(a.getTelefono()));
                if (a.isEstado() == true) {
                    activo.setState(true);
                    inactivo.setState(false);
                } else {
                    inactivo.setState(true);
                    activo.setState(false);
                }
            }
        }catch (NumberFormatException e){
            String mensaje = "Error al ingresar el ID de Afiliado, Ingrese Nuevamente ";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
            idafiliado.setText("");
        }
        
        
        
        
    }//GEN-LAST:event_jbuscarafiMouseClicked

    private void ModificarafiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModificarafiMouseClicked
        try {
            AfiliadoData ad = new AfiliadoData();
            EmpleadoData ed = new EmpleadoData();
            if(activo.getState()== false && inactivo.getState()==false || nombre.getText().isEmpty() || apellido.getText().isEmpty() || domicilio.getText().isEmpty() || documento.getText().isEmpty() || idempleafi.getText().isEmpty()
                    || telefono.getText().isEmpty() || idafiliado.getText().isEmpty()){
                String mensaje = "LLenar con todos los datos pot favor!! ";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Datos mal ingresados", JOptionPane.PLAIN_MESSAGE, icono);
            }else{
            int ide = Integer.parseInt(idempleafi.getText());
            Empleado e = ed.buscarEmpleado(ide);
            int id = Integer.parseInt(idafiliado.getText());
            int tel = Integer.parseInt(telefono.getText());
            int dni = Integer.parseInt(documento.getText());
            boolean act = activo.getState();

            Afiliado a = new Afiliado(id, nombre.getText(), apellido.getText(), dni, domicilio.getText(), tel, e, act);
            ad.modificarAfiliado(a);
              nombre.setText("");
            apellido.setText("");
            documento.setText("");
            idempleafi.setText("");
            telefono.setText("");
            activo.setState(false);
            domicilio.setText("");
            }

        } catch (NumberFormatException e) {
             String mensaje = "Error al ingresar datos a modificar, Revisar Datos ";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
           
        }
    }//GEN-LAST:event_ModificarafiMouseClicked

    private void EliminarafiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EliminarafiMouseClicked
        try {
            AfiliadoData ad = new AfiliadoData();
            int id = Integer.parseInt(idafiliado.getText());

            ad.eliminarAfiliado(id);
             nombre.setText("");
            apellido.setText("");
            documento.setText("");
            idempleafi.setText("");
            telefono.setText("");
            activo.setState(false);
            domicilio.setText("");
        } catch (NumberFormatException e) {
            String mensaje = "Error al ingresar el ID de Afiliado, Ingrese Nuevamente ";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
            idafiliado.setText("");

        }
    }//GEN-LAST:event_EliminarafiMouseClicked

    private void ListarafiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListarafiMouseClicked
         try{
            borrarFafi();

            for(Afiliado a: afiData.listarAfiliado()){
                modelo.addRow(new Object []{a.getIdafiliaado(),a.getNombre(),a.getApellido(),a.getDni(),a.getEmpleado().getIdEmpleado(),a.getDomicilio(),a.getTelefono()});

            }
        }catch (Exception e){
            String mensaje = "Error al Listar Afiliados ";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
        }
    }//GEN-LAST:event_ListarafiMouseClicked

    private void buscarpreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarpreMouseClicked
        try {
            int idpres=Integer.parseInt(idprestador.getText());
            Prestador p=presData.buscarPrestador(idpres);
            if(p != null){
                dnipre.setText(Integer.toString(p.getDni()));
                nompre.setText(p.getNombre());
                apepre.setText(p.getApellido());
                institucion.setText(p.getInstitucion());
                email.setText(p.getEmail());
                telpre.setText(p.getTelefono());
                dompre.setText(p.getDireccion());
                idespe.setText(Integer.toString(p.getEspecialidad().getIdEspecialidad()));
                if(p.isEstado()== true){
                    actpre.setState(true);
                    inapre.setState(false);
                
                }else {
                    actpre.setState(false);
                    inapre.setState(true);
                
                }           
            }           
            
        } catch (NumberFormatException e) {
             String mensaje = "Error al ingresar el ID de Prestador, Ingrese Nuevamente ";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
            idprestador.setText("");
        }
    }//GEN-LAST:event_buscarpreMouseClicked

    private void guardarpreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarpreMouseClicked
        try {
            if(actpre.getState()== false && inapre.getState()==false ||dnipre.getText().isEmpty() || idespe.getText().isEmpty() || nompre.getText().isEmpty() || apepre.getText().isEmpty()
                    || telpre.getText().isEmpty() || dompre.getText().isEmpty() || email.getText().isEmpty()){
                String mensaje = "LLenar con todos los datos pot favor!! ";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Datos mal ingresados", JOptionPane.PLAIN_MESSAGE, icono);
            }else{
            int dni=Integer.parseInt(dnipre.getText());
            int ides=Integer.parseInt(idespe.getText());
            boolean act=actpre.getState();
            Especialidad e= espData.buscarEspecialidadPorId(ides);
            Prestador p=new Prestador(nompre.getText(),apepre.getText(),dni,institucion.getText(),dompre.getText(),telpre.getText(),email.getText(),e,act);
            presData.guardarPrestador(p);
            nompre.setText("");
            apepre.setText("");
            dnipre.setText("");
            idespe.setText("");
            telpre.setText("");
            actpre.setState(false);
            dompre.setText("");
            institucion.setText("");
            email.setText("");
            }
            
            
        } catch (NumberFormatException e) {
             String mensaje = "Error al ingresar datos de Prestador, Revisar Datos ";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
            
        }
        
    }//GEN-LAST:event_guardarpreMouseClicked

    private void modipreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modipreMouseClicked
        try {
            if(actpre.getState()== false && inapre.getState()==false ||dnipre.getText().isEmpty() || idespe.getText().isEmpty() || nompre.getText().isEmpty() || apepre.getText().isEmpty()
                    || telpre.getText().isEmpty() || dompre.getText().isEmpty() || email.getText().isEmpty() || idprestador.getText().isEmpty()){
                String mensaje = "LLenar con todos los datos pot favor!! ";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Datos mal ingresados", JOptionPane.PLAIN_MESSAGE, icono);
            }else{
             int dni=Integer.parseInt(dnipre.getText());
            int ides=Integer.parseInt(idespe.getText());
            int idpre=Integer.parseInt(idprestador.getText());
            boolean act=actpre.getState();
            Especialidad e= espData.buscarEspecialidadPorId(ides);
            Prestador p=new Prestador(idpre,nompre.getText(),apepre.getText(),dni,institucion.getText(),dompre.getText(),telpre.getText(),email.getText(),e,act);
            presData.actualizarPrestador(p);
            nompre.setText("");
            apepre.setText("");
            dnipre.setText("");
            idespe.setText("");
            telpre.setText("");
            actpre.setState(false);
            dompre.setText("");
            institucion.setText("");
            email.setText("");
            }
        } catch (Exception e) {
              String mensaje = "Error al modificar datos de Prestador, Ingrese Nuevamente ";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
            
        }
    }//GEN-LAST:event_modipreMouseClicked

    private void elipreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_elipreMouseClicked
        try {
            int idpre=Integer.parseInt(idprestador.getText());
            presData.eliminarPrestador(idpre);
             nompre.setText("");
            apepre.setText("");
            dnipre.setText("");
            idespe.setText("");
            telpre.setText("");
            actpre.setState(false);
            dompre.setText("");
            institucion.setText("");
            email.setText("");
            
        } catch (Exception e) {
            String mensaje = "Error al ingresar el ID de Prestador, Ingrese Nuevamente ";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
            idprestador.setText("");
        }
        
        
    }//GEN-LAST:event_elipreMouseClicked

    private void listarpreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listarpreMouseClicked
        try {
            borrarFpre();
            for(Prestador p: presData.obtenerPrestadores()){
                pres.addRow(new Object []{p.getIdPrestador(),p.getNombre(),p.getApellido(),p.getInstitucion(),p.getDireccion(),p.getTelefono(),p.getEmail(),p.getEspecialidad().getIdEspecialidad()});
            }
            
            
        } catch (Exception e) {
             String mensaje = "Error al Listar Prestadores ";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
        }
    }//GEN-LAST:event_listarpreMouseClicked

    private void buscarespeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarespeMouseClicked
        try {
            int id=Integer.parseInt(idespecialidad.getText());
            Especialidad e=espData.buscarEspecialidadPorId(id);
            if(e!= null){
                nomespe.setText(e.getNombre());               
            
            }
            if(e.isEstado()== true){
                actespe.setState(true);
                inaespe.setState(false);            
            }else {
                actespe.setState(false);
                inaespe.setState(true);
            }
            
        } catch (Exception e) {
             String mensaje = "Error al ingresar el ID de Especialidad, Ingrese Nuevamente ";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
            idespecialidad.setText("");
            
        }
    }//GEN-LAST:event_buscarespeMouseClicked

    private void modiespeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modiespeMouseClicked
        try {
             if(actespe.getState()== false && inaespe.getState()==false ||idespecialidad.getText().isEmpty() || nomespe.getText().isEmpty()){
                String mensaje = "LLenar con todos los datos pot favor!! ";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Datos mal ingresados", JOptionPane.PLAIN_MESSAGE, icono);
            }else{
            int id=Integer.parseInt(idespecialidad.getText());
            boolean act=actespe.getState();
            String nombre=nomespe.getText();
            Especialidad e=new Especialidad(id,nombre,act);
                       
            espData.actualizarEspecialidad(e);
            idespecialidad.setText("");
            nomespe.setText("");
            actespe.setState(false);
             }
            
            
        } catch (Exception e) {
                String mensaje = "Error al modificar datos de Especialidad, Ingrese Nuevamente ";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
        }
    }//GEN-LAST:event_modiespeMouseClicked

    private void actespeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_actespeItemStateChanged
        
        if(evt.getStateChange()== ItemEvent.SELECTED){
            inaespe.setState(false);
        }
    }//GEN-LAST:event_actespeItemStateChanged

    private void inaespeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_inaespeItemStateChanged
       if(evt.getStateChange()== ItemEvent.SELECTED){
            actespe.setState(false);
        }
    }//GEN-LAST:event_inaespeItemStateChanged

    private void ActPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ActPItemStateChanged
       if(evt.getStateChange()==ItemEvent.SELECTED){
           InaP.setState(false);
       }
    }//GEN-LAST:event_ActPItemStateChanged

    private void InaPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_InaPItemStateChanged
        if(evt.getStateChange()==ItemEvent.SELECTED){
           ActP.setState(false);
       }
    }//GEN-LAST:event_InaPItemStateChanged

    private void activoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_activoItemStateChanged
        if(evt.getStateChange()==ItemEvent.SELECTED){
           inactivo.setState(false);
       }
    }//GEN-LAST:event_activoItemStateChanged

    private void inactivoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_inactivoItemStateChanged
       if(evt.getStateChange()==ItemEvent.SELECTED){
           activo.setState(false);
       }
    }//GEN-LAST:event_inactivoItemStateChanged

    private void actpreItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_actpreItemStateChanged
       if(evt.getStateChange()==ItemEvent.SELECTED){
           inapre.setState(false);
       }
    }//GEN-LAST:event_actpreItemStateChanged

    private void inapreItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_inapreItemStateChanged
       if(evt.getStateChange()==ItemEvent.SELECTED){
           actpre.setState(false);
       }
    }//GEN-LAST:event_inapreItemStateChanged

    private void guardarespeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarespeMouseClicked
        try {
             if(actespe.getState()== false && inaespe.getState()==false || nomespe.getText().isEmpty()){
                String mensaje = "LLenar con todos los datos pot favor!! ";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Datos mal ingresados", JOptionPane.PLAIN_MESSAGE, icono);
            }else{
            boolean act=actespe.getState();
            Especialidad e=new Especialidad(nomespe.getText(),act);
            espData.guardarEspecialidad(e);
            nomespe.setText("");
            actespe.setState(false);
             }
            
            
        } catch (Exception e) {
             String mensaje = "Error al ingresar datos de Especialidad, Revisar Datos ";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
        }
    }//GEN-LAST:event_guardarespeMouseClicked

    private void eliespeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliespeMouseClicked
        try {
            int id=Integer.parseInt(idespecialidad.getText());
            espData.eliminarEspecialidad(id);
             nomespe.setText("");
            actespe.setState(false);
            idespecialidad.setText("");
            
        } catch (Exception e) {
             String mensaje = "Error al ingresar el ID de Especialidad, Ingrese Nuevamente ";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
            idespecialidad.setText("");
        }
    }//GEN-LAST:event_eliespeMouseClicked

    private void listarespeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listarespeMouseClicked
        try {
            borrarFesp();
            for(Especialidad e: espData.listarEspecialidad()){
            
                espec.addRow(new Object []{e.getIdEspecialidad(),e.getNombre()});
            }
            
            
        } catch (Exception e) {
              String mensaje = "Error al Listar Especialidades ";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
        }
    }//GEN-LAST:event_listarespeMouseClicked

    private void buscarempMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarempMouseClicked
        try {
            int id=Integer.parseInt(idempleado.getText());
            Empleado e=EmpData.buscarEmpleado(id);
            if(e != null){
                dniemp.setText(Integer.toString(e.getDni()));
                nomemp.setText(e.getNombre());
                apeemp.setText(e.getApellido());
                usuario.setText(e.getUsuario());
                contra.setText(e.getContra());
                clave.setText(e.getClave());
                telemp.setText(Integer.toString(e.getTel()));
                if(e.isEstado()==true){
                    actemp.setState(true);
                    inaemp.setState(false);
                }else {
                    actemp.setState(false);
                    inaemp.setState(true);
                }
                        
            }          
            
        } catch (Exception e) {
              String mensaje = "Error al ingresar el ID de Empleado, Ingrese Nuevamente ";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
            idempleado.setText("");
        }
    }//GEN-LAST:event_buscarempMouseClicked

    private void guardarempMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarempMouseClicked
        try {
            if(actemp.getState()== false && inaemp.getState()==false || nomemp.getText().isEmpty() || apeemp.getText().isEmpty()
                     || dniemp.getText().isEmpty() || telemp.getText().isEmpty()
                     || usuario.getText().isEmpty() || contra.getText().isEmpty() || clave.getText().isEmpty()){
                String mensaje = "LLenar con todos los datos pot favor!! ";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Datos mal ingresados", JOptionPane.PLAIN_MESSAGE, icono);
            }else{
            int dni=Integer.parseInt(dniemp.getText());
            int tel=Integer.parseInt(telemp.getText());
            boolean act=actemp.getState();
            Empleado e=new Empleado(nomemp.getText(),apeemp.getText(),dni,usuario.getText(),contra.getText(),tel,clave.getText(),act);
            EmpData.guardarEmpleado(e);
             dniemp.setText("");
                nomemp.setText("");
                apeemp.setText("");
                usuario.setText("");
                contra.setText("");
                clave.setText("");
                telemp.setText("");
                actemp.setState(false);
            }
            
        } catch (Exception e) {
             String mensaje = "Error al ingresar datos de Empleado, Revisar Datos ";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono); 
        }
    }//GEN-LAST:event_guardarempMouseClicked

    private void modiempMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modiempMouseClicked
        try {
             if(actemp.getState()== false && inaemp.getState()==false || nomemp.getText().isEmpty() || apeemp.getText().isEmpty()
                     || idempleado.getText().isEmpty() || dniemp.getText().isEmpty() || telemp.getText().isEmpty()
                     || usuario.getText().isEmpty() || contra.getText().isEmpty() || clave.getText().isEmpty()){
                String mensaje = "LLenar con todos los datos pot favor!! ";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Datos mal ingresados", JOptionPane.PLAIN_MESSAGE, icono);
            }else{
            int id=Integer.parseInt(idempleado.getText());
            int dni=Integer.parseInt(dniemp.getText());
            int tel=Integer.parseInt(telemp.getText());
            boolean act=actemp.getState();
            Empleado e=new Empleado(id,nomemp.getText(),apeemp.getText(),dni,usuario.getText(),contra.getText(),tel,clave.getText(),act);
            EmpData.modificarEmpleado(e);
             dniemp.setText("");
                nomemp.setText("");
                apeemp.setText("");
                usuario.setText("");
                contra.setText("");
                clave.setText("");
                telemp.setText("");
                actemp.setState(false);
             }
            
        } catch (Exception e) {
                 String mensaje = "Error al modificar datos de Empleado, Revisar Datos ";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
        }
        
        
    }//GEN-LAST:event_modiempMouseClicked

    private void elimempMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_elimempMouseClicked
        try {
            int id=Integer.parseInt(idempleado.getText());
            EmpData.eliminarEmpleado(id);
              dniemp.setText("");
                nomemp.setText("");
                apeemp.setText("");
                usuario.setText("");
                contra.setText("");
                clave.setText("");
                telemp.setText("");
                actemp.setState(false);
            
        } catch (Exception e) {
              String mensaje = "Error al ingresar el ID de Empleado, Ingrese Nuevamente ";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
            idespecialidad.setText("");
        }
    }//GEN-LAST:event_elimempMouseClicked

    private void actempItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_actempItemStateChanged
         if(evt.getStateChange()==ItemEvent.SELECTED){
           inaemp.setState(false);
       }
    }//GEN-LAST:event_actempItemStateChanged

    private void inaempItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_inaempItemStateChanged
        if(evt.getStateChange()==ItemEvent.SELECTED){
           actemp.setState(false);
       }
    }//GEN-LAST:event_inaempItemStateChanged

    private void listarempMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listarempMouseClicked
        try {
           borrarFemp();
           for(Empleado e: EmpData.listarEmpleado()){
           
               empleado.addRow(new Object []{e.getIdEmpleado(),e.getNombre(),e.getApellido(),e.getDni(),e.getUsuario(),e.getContra(),e.getTel(),e.getClave()});
           }
            
            
            
            
        } catch (Exception e) {
               String mensaje = "Error al Listar Empleados ";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
        }
           
    }//GEN-LAST:event_listarempMouseClicked

  private Prestador elegirPrestadorPorEspecialidad(List<Prestador> prestadores) {
    String[] opciones = new String[prestadores.size()];
    for (int i = 0; i < prestadores.size(); i++) {
      Prestador prestador = prestadores.get(i);
      opciones[i] = prestador.getNombre() + " " + prestador.getApellido();
    }
    String mensaje = "Selección de Prestador";
    UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
    UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
    UIManager.put("OptionPane.buttonFont", new Font("Segoe UI", Font.BOLD, 16));
    UIManager.put("OptionPane.buttonForeground", new Color(204, 204, 0));
    ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
    String seleccion = (String) JOptionPane.showInputDialog(this, mensaje, "Elige un Prestador:", JOptionPane.QUESTION_MESSAGE, icono, opciones, opciones[0]);
    if (seleccion != null) {
      for (Prestador prestador : prestadores) {
        if (seleccion.equals(prestador.getNombre() + " " + prestador.getApellido())) {
          return prestador;
        }
      }
    }

    return null;
  }

  private void cerrarWin() {

    Object[] opciones = {"Si", "NO"};
    String nombre = "¿Está saliendo de MAS SALUD?";
    UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 18));
    UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
// UIManager.put("OptionPane.buttonFont", new Font("Segoe UI", Font.BOLD, 16));
//    UIManager.put("OptionPane.buttonForeground", new Color(204, 204, 0));
    ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
    int seleccion = JOptionPane.showOptionDialog(this, nombre, "Salir ", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icono, opciones, opciones[1]);

    if (seleccion == JOptionPane.YES_OPTION) {
      this.dispose();
    } else {
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
      java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new Menu().setVisible(true);
      }
    });
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Checkbox Act;
    private java.awt.Checkbox ActP;
    private javax.swing.JLabel AfiBus;
    private javax.swing.JTextField Afibusc;
    private javax.swing.JLabel Afil;
    private javax.swing.JTextField Ape;
    private javax.swing.JTextField ApeP;
    private javax.swing.JLabel Apel;
    private javax.swing.JLabel Apel1;
    private javax.swing.JLabel Apel2;
    private javax.swing.JLabel Apel3;
    private javax.swing.JLabel Apel4;
    private javax.swing.JLabel Apel5;
    private javax.swing.JLabel ApelP;
    private javax.swing.JButton BuscarAfi;
    private javax.swing.JButton BuscarEspe;
    private javax.swing.JLabel Corre2;
    private javax.swing.JLabel Corre3;
    private javax.swing.JLabel Corre4;
    private javax.swing.JLabel Corre5;
    private javax.swing.JTextField CorreP;
    private javax.swing.JTextField Doc;
    private javax.swing.JLabel Docu;
    private javax.swing.JTextField Dom;
    private javax.swing.JTextField DomP;
    private javax.swing.JLabel Domi;
    private javax.swing.JLabel Domi1;
    private javax.swing.JLabel Domi2;
    private javax.swing.JLabel Domi3;
    private javax.swing.JLabel DomiP;
    private javax.swing.JButton EliLisOrd;
    private javax.swing.JLabel Eliminarafi;
    private javax.swing.JLabel Empl;
    private javax.swing.JLabel Espe;
    private javax.swing.JLabel Especi;
    private javax.swing.JLabel EstEsp;
    private javax.swing.JLabel EstaA;
    private javax.swing.JPanel FAfi;
    private javax.swing.JPanel FEmp;
    private javax.swing.JPanel FEsp;
    private javax.swing.JPanel FInicio;
    private javax.swing.JPanel FOrd;
    private javax.swing.JPanel FPres;
    private javax.swing.JComboBox<String> FdP;
    private javax.swing.JLabel Fecha;
    private javax.swing.JLabel FechaList;
    private com.toedter.calendar.JDateChooser FechaListOrd;
    private com.toedter.calendar.JDateChooser FechaOrd;
    private javax.swing.JLabel FormdP;
    private javax.swing.JButton GenerarOrd;
    private javax.swing.JLabel Guardarafi;
    private javax.swing.JTextField IdAf;
    private javax.swing.JLabel IdAfil;
    private javax.swing.JLabel IdAfil1;
    private javax.swing.JLabel IdAfil2;
    private javax.swing.JLabel IdAfil3;
    private javax.swing.JLabel IdEspe;
    private javax.swing.JTextField IdEspec;
    private javax.swing.JLabel IdPres;
    private javax.swing.JTextField IdPresta;
    private javax.swing.JLabel Import;
    private java.awt.Checkbox Ina;
    private java.awt.Checkbox InaP;
    private javax.swing.JTextField InstP;
    private javax.swing.JLabel InstiP;
    private javax.swing.JButton LimpiarTabla;
    private javax.swing.JButton ListarOrd;
    private javax.swing.JLabel Listarafi;
    private javax.swing.JLabel Modificarafi;
    private javax.swing.JTextField Nom;
    private javax.swing.JTextField NomP;
    private javax.swing.JLabel Nomb;
    private javax.swing.JLabel Nomb1;
    private javax.swing.JLabel Nomb2;
    private javax.swing.JLabel Nomb3;
    private javax.swing.JLabel Nomb4;
    private javax.swing.JLabel Nomb5;
    private javax.swing.JLabel NombP;
    private javax.swing.JLabel Orden;
    private javax.swing.JLabel Ordenes;
    private javax.swing.JPanel PAfil;
    private javax.swing.JPanel PEmpl;
    private javax.swing.JPanel PEspe;
    private javax.swing.JPanel POrden;
    private javax.swing.JPanel PPrest;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JPanel PanelOt;
    private javax.swing.JLabel PresBus;
    private javax.swing.JTextField Presbusc1;
    private javax.swing.JLabel Prest;
    private javax.swing.JButton Salir;
    private javax.swing.JSeparator Sepa1;
    private javax.swing.JSeparator Sepa2;
    private javax.swing.JSeparator Sepa3;
    private javax.swing.JSeparator Sepa4;
    private javax.swing.JTable TListOrd;
    private javax.swing.JTextField Tel;
    private javax.swing.JTextField TelP;
    private javax.swing.JLabel Telf;
    private javax.swing.JLabel Telf1;
    private javax.swing.JLabel Telf2;
    private javax.swing.JLabel Telf3;
    private javax.swing.JLabel TelfP;
    private javax.swing.JTextField TexEspe;
    private java.awt.Checkbox actemp;
    private java.awt.Checkbox actespe;
    private java.awt.Checkbox activo;
    private java.awt.Checkbox actpre;
    private javax.swing.JLabel afili;
    private javax.swing.JTextField apeemp;
    private javax.swing.JTextField apellido;
    private javax.swing.JTextField apepre;
    private javax.swing.JLabel buscaremp;
    private javax.swing.JLabel buscarespe;
    private javax.swing.JLabel buscarpre;
    private javax.swing.JTextField clave;
    private javax.swing.JTextField contra;
    private javax.swing.JLabel correoP;
    private javax.swing.JLabel dniPres;
    private javax.swing.JTextField dniPrest;
    private javax.swing.JTextField dniemp;
    private javax.swing.JTextField dnipre;
    private javax.swing.JTextField documento;
    private javax.swing.JTextField domicilio;
    private javax.swing.JTextField dompre;
    private javax.swing.JLabel eliespe;
    private javax.swing.JLabel elimemp;
    private javax.swing.JLabel elipre;
    private javax.swing.JTextField email;
    private javax.swing.JLabel espe;
    private javax.swing.JLabel guardaremp;
    private javax.swing.JLabel guardarespe;
    private javax.swing.JLabel guardarpre;
    private javax.swing.JTextField idafiliado;
    private javax.swing.JTextField idemple;
    private javax.swing.JTextField idempleado;
    private javax.swing.JTextField idempleafi;
    private javax.swing.JTextField idespe;
    private javax.swing.JTextField idespecialidad;
    private javax.swing.JTextField idprestador;
    private java.awt.Checkbox inactivo;
    private java.awt.Checkbox inaemp;
    private java.awt.Checkbox inaespe;
    private java.awt.Checkbox inapre;
    private javax.swing.JTextField institucion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel jbuscarafi;
    private javax.swing.JTable jemp;
    private javax.swing.JTable jespe;
    private javax.swing.JTable jtAfi;
    private javax.swing.JTable jtpre;
    private javax.swing.JLabel listarAfi;
    private javax.swing.JLabel listarPres;
    private javax.swing.JLabel listaremp;
    private javax.swing.JLabel listarespe;
    private javax.swing.JLabel listarpre;
    private javax.swing.JLabel logomenu;
    private javax.swing.JLabel modiemp;
    private javax.swing.JLabel modiespe;
    private javax.swing.JLabel modipre;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField nomemp;
    private javax.swing.JTextField nomespe;
    private javax.swing.JTextField nompre;
    private javax.swing.JButton nuevo;
    private javax.swing.JLabel prest;
    private javax.swing.JTextField telefono;
    private javax.swing.JTextField telemp;
    private javax.swing.JTextField telpre;
    private javax.swing.JTextField texImpo;
    private javax.swing.JLabel tituAfil;
    private javax.swing.JLabel tituPrest;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
  private void borrarF() {

        int f = TListOrd.getRowCount() - 1;
        for (; f >= 0; f--) {
            TLOrd.removeRow(f);
        }
    }
  
  private void borrarFafi() {

        int f = jtAfi.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }
   private void borrarFpre() {

        int f = jtpre.getRowCount() - 1;
        for (; f >= 0; f--) {
            pres.removeRow(f);
        }
    }
    private void borrarFesp() {

        int f = jespe.getRowCount() - 1;
        for (; f >= 0; f--) {
            espec.removeRow(f);
        }
    }
    private void borrarFemp() {

        int f = jemp.getRowCount() - 1;
        for (; f >= 0; f--) {
            empleado.removeRow(f);
        }
    }
}