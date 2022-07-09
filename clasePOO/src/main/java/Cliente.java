
public class Cliente {

    private int idCliente;
    private String nombre;
    private String paterno;
    private String materno;
    private String fechaNacimiento;
    private int numeroCuenta;

    public Cliente() {
        this.idCliente = 4;
        this.nombre = "David";
        this.paterno = "Meneces";
        this.materno = "Zelaya";
        this.fechaNacimiento = "10/10/2000";
        this.numeroCuenta = 123123;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", paterno=" + paterno + ", materno=" + materno + ", fechaNacimiento=" + fechaNacimiento + ", numeroCuenta=" + numeroCuenta + '}';
    }

    public String getVocalesNombre() {
        String[] vocales = {"a", "e", "i", "o", "u"};
        String vocalesNombre = "";
        for (String vocal : vocales) {
            if (this.nombre.contains(vocal)) {
                vocalesNombre += vocal + ",";
            }
        }
        return vocalesNombre;
    }

    public boolean verificarIdClientePrimo() {
        // idCliente = 2
        if (this.idCliente == 1) {
            return false;
        }
        for (int i = 2; i <= (this.idCliente / 2); i++) {
            if (this.idCliente % i == 0) {
                return false;
            }
        }
        return true;
    }

    public String getAnioNacimiento() {
        String[] datosFecha = this.fechaNacimiento.split("/");
        return datosFecha[2];
    }

}
