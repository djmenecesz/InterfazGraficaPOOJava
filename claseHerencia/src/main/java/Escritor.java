
public class Escritor extends Periodista {

    private String nombrePeriodico;
    private String sector;

    public Escritor() {
        super();
    }

    public Escritor(String nombrePeriodico, String sector, String idPeriodista, boolean empleado, double sueldo, String nombre, String fechaNacimiento, int cedulaIdentidad) {
        super(idPeriodista, empleado, sueldo, nombre, fechaNacimiento, cedulaIdentidad);
        this.nombrePeriodico = nombrePeriodico;
        this.sector = sector;
    }

    public String getNombrePeriodico() {
        return nombrePeriodico;
    }

    public void setNombrePeriodico(String nombrePeriodico) {
        this.nombrePeriodico = nombrePeriodico;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    @Override
    public String toString() {
        return "Escritor{" + "nombrePeriodico=" + nombrePeriodico + ", sector=" + sector + "," + super.toString() + '}';
    }

}
