
import java.io.Serializable;


public class Inquilino extends Persona implements Serializable{

    private String idInquilino;
    private ContratoAlquiler contrato;

    public Inquilino() {
        super();
    }

    public Inquilino(String idInquilino, String idDepartamento, String fechaInicio, String fechaFin, String nombre, String paterno, String materno, int ci, String fechaNacimiento) {
        super(nombre, paterno, materno, ci, fechaNacimiento);
        this.idInquilino = idInquilino;
        this.contrato = new ContratoAlquiler(idDepartamento, fechaInicio, fechaFin);
    }

    public String getIdInquilino() {
        return idInquilino;
    }

    public void setIdInquilino(String idInquilino) {
        this.idInquilino = idInquilino;
    }

    public ContratoAlquiler getContrato() {
        return contrato;
    }

    public void setContrato(ContratoAlquiler contrato) {
        this.contrato = contrato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

}
