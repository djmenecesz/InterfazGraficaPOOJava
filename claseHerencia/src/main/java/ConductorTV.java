
public class ConductorTV extends Periodista {

    private String casaTelevisa;
    private String programa;

    public ConductorTV() {
        super();
    }

    public ConductorTV(String casaTelevisa, String programa, String idPeriodista, boolean empleado, double sueldo, String nombre, String fechaNacimiento, int cedulaIdentidad) {
        super(idPeriodista, empleado, sueldo, nombre, fechaNacimiento, cedulaIdentidad);
        this.casaTelevisa = casaTelevisa;
        this.programa = programa;
    }

    public String getCasaTelevisa() {
        return casaTelevisa;
    }

    public void setCasaTelevisa(String casaTelevisa) {
        this.casaTelevisa = casaTelevisa;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    @Override
    public String toString() {
        return "ConductorTV{" + "casaTelevisa=" + casaTelevisa + ", programa=" + programa + ","+super.toString()+'}';
    }
    

}
