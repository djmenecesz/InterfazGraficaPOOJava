
import java.io.Serializable;


public class Persona implements Serializable {

    protected String nombre;
    protected String paterno;
    protected String materno;
    protected int ci;
    protected String fechaNacimiento;

    public Persona() {
    }

    public Persona(String nombre, String paterno, String materno, int ci, String fechaNacimiento) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.ci = ci;
        this.fechaNacimiento = fechaNacimiento;
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
