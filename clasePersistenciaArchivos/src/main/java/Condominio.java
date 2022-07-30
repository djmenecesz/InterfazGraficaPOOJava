
import java.awt.Image;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class Condominio implements Serializable {

    private Persona duenio;
    private String nombreCondominio;
    private String direccion;
    private int telefono;
    private int nroDepartamentos;
    private Departamento[] departamentos = new Departamento[100];
    private int nroInquilinos;
    private Inquilino[] inquilinos = new Inquilino[100];

    public Condominio() {
    }

    public Condominio(Persona duenio, String nombreCondominio, String direccion, int telefono) {
        this.duenio = duenio;
        this.nombreCondominio = nombreCondominio;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nroDepartamentos = 0;
        this.nroInquilinos = 0;
    }

    public void agregarDepartamento(String idDepartamento, double costo, double superficie, String rutaImagen) {
        this.departamentos[this.nroDepartamentos] = new Departamento(idDepartamento, costo, superficie, rutaImagen);
        this.nroDepartamentos++;
    }

    public void agregarInquilino(Inquilino inquilino) {
        this.inquilinos[this.nroInquilinos] = inquilino;
        this.nroInquilinos++;
    }

    public Persona getDuenio() {
        return duenio;
    }

    public void setDuenio(Persona duenio) {
        this.duenio = duenio;
    }

    public String getNombreCondominio() {
        return nombreCondominio;
    }

    public void setNombreCondominio(String nombreCondominio) {
        this.nombreCondominio = nombreCondominio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getNroDepartamentos() {
        return nroDepartamentos;
    }

    public void setNroDepartamentos(int nroDepartamentos) {
        this.nroDepartamentos = nroDepartamentos;
    }

    public Departamento[] getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Departamento[] departamentos) {
        this.departamentos = departamentos;
    }

    public int getNroInquilinos() {
        return nroInquilinos;
    }

    public void setNroInquilinos(int nroInquilinos) {
        this.nroInquilinos = nroInquilinos;
    }

    public Inquilino[] getInquilinos() {
        return inquilinos;
    }

    public void setInquilinos(Inquilino[] inquilinos) {
        this.inquilinos = inquilinos;
    }

    public String getFullName() {
        return this.duenio.getNombre() + " " + this.duenio.getPaterno() + " " + this.duenio.getMaterno();
    }

    public DefaultTableModel obtenerDepartamentos() {
        String[] columna = {"idDepartamento", "Costo", "Superficie", "Imagen", "Alquilar"};
        Object[] fila = new Object[5];
        DefaultTableModel modelo = new DefaultTableModel(null, columna);
        for (int i = 0; i < this.nroDepartamentos; i++) {
            JLabel imagen = new JLabel(obtenerIcono(70, 70, this.departamentos[i].getRutaImagen()));
            JButton alquilar = new JButton("Alquilar");
            fila[0] = this.departamentos[i].getIdDepartamento();
            fila[1] = this.departamentos[i].getCosto();
            fila[2] = this.departamentos[i].getSuperficie();
            fila[3] = imagen;
            fila[4] = alquilar;
            modelo.addRow(fila);
        }
        return modelo;
    }

    public ImageIcon obtenerIcono(int ancho, int alto, String ruta) {
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(ruta));
        Image image = imageIcon.getImage();
        image = image.getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        return imageIcon;
    }

    public Departamento obtenerCondominioPorId(String idDepa) {
        for (int i = 0; i < this.nroDepartamentos; i++) {
            if (this.departamentos[i].getIdDepartamento().equals(idDepa)) {
                return this.departamentos[i];
            }
        }
        return null;
    }

    public boolean esAlquilado(String idDepa) {
        for (int i = 0; i < this.nroInquilinos; i++) {
            if (this.inquilinos[i].getContrato().getIdDepartamento().equals(idDepa)) {
                return true;
            }
        }
        return false;
    }

    public DefaultTableModel obtenerInquilinos() {
        String[] columna = {"idInquiino", "Nombre", "Fecha Nacimiento", "CI", "IdDepartamento", "FechaInicio - FechaFin"};
        String[] fila = new String[6];
        DefaultTableModel modelo = new DefaultTableModel(null, columna);
        for (int i = 0; i < this.nroInquilinos; i++) {
            fila[0] = this.inquilinos[i].getIdInquilino();
            fila[1] = this.inquilinos[i].getNombre() + " " + this.inquilinos[i].getPaterno() + " " + this.inquilinos[i].getMaterno();
            fila[2] = this.inquilinos[i].getFechaNacimiento();
            fila[3] = this.inquilinos[i].getCi() + "";
            fila[4] = this.inquilinos[i].getContrato().getIdDepartamento();
            fila[5] = this.inquilinos[i].getContrato().getFechaInicio() + " - " + this.inquilinos[i].getContrato().getFechaFin();
            modelo.addRow(fila);
        }
        return modelo;
    }

}
