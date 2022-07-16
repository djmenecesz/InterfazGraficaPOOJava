
public class Persona {
    protected String nombre;
    protected String fechaNacimiento;
    protected int cedulaIdentidad;

    public Persona() {
    }
    
    public Persona(String nombre, String fechaNacimiento, int cedulaIdentidad) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.cedulaIdentidad = cedulaIdentidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getCedulaIdentidad() {
        return cedulaIdentidad;
    }

    public void setCedulaIdentidad(int cedulaIdentidad) {
        this.cedulaIdentidad = cedulaIdentidad;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", cedulaIdentidad=" + cedulaIdentidad + '}';
    }
    
}
