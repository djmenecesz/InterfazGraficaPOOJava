
public class Periodista extends Persona {

    protected String idPeriodista;
    protected boolean empleado;
    protected double sueldo;

    public Periodista() {
        super();
    }

    public Periodista(String idPeriodista, boolean empleado, double sueldo, String nombre, String fechaNacimiento, int cedulaIdentidad) {
        super(nombre, fechaNacimiento, cedulaIdentidad);
        this.idPeriodista = idPeriodista;
        this.empleado = empleado;
        this.sueldo = sueldo;
    }

    public String getIdPeriodista() {
        return idPeriodista;
    }

    public void setIdPeriodista(String idPeriodista) {
        this.idPeriodista = idPeriodista;
    }

    public boolean isEmpleado() {
        return empleado;
    }

    public void setEmpleado(boolean empleado) {
        this.empleado = empleado;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    @Override
    public String toString() {
        return "Periodista{" + "idPeriodista=" + idPeriodista + ", empleado=" + empleado + ", sueldo=" + sueldo + ","+super.toString() + '}';
    }
    

}
