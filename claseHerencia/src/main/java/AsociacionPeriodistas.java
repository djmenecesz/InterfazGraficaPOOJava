
import javax.swing.table.DefaultTableModel;


public class AsociacionPeriodistas {

    private String fechaFundacion;
    private int numeroPeriodistas;
    private String[][] periodistas = new String[100][9];

    public AsociacionPeriodistas(String fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
        this.numeroPeriodistas = 3;
        this.periodistas[0][0] = "ConductorTV";
        this.periodistas[0][1] = "Juan Perez";
        this.periodistas[0][2] = "10-10-1998";
        this.periodistas[0][3] = "1111";
        this.periodistas[0][4] = "ctv1";
        this.periodistas[0][5] = "true";
        this.periodistas[0][6] = "2000";
        this.periodistas[0][7] = "ATB";
        this.periodistas[0][8] = "Programa ABC";

        this.periodistas[1][0] = "ConductorTV";
        this.periodistas[1][1] = "Alan Brito";
        this.periodistas[1][2] = "20-10-1998";
        this.periodistas[1][3] = "2222";
        this.periodistas[1][4] = "ctv2";
        this.periodistas[1][5] = "false";
        this.periodistas[1][6] = "2500";
        this.periodistas[1][7] = "Red UNO";
        this.periodistas[1][8] = "Programa QWE";

        this.periodistas[2][0] = "Escritor";
        this.periodistas[2][1] = "Darah Flores";
        this.periodistas[2][2] = "10-09-1997";
        this.periodistas[2][3] = "3333";
        this.periodistas[2][4] = "esc1";
        this.periodistas[2][5] = "true";
        this.periodistas[2][6] = "2450";
        this.periodistas[2][7] = "La Razon";
        this.periodistas[2][8] = "Deportes";
    }

    public String getFechaFundacion() {
        return fechaFundacion;
    }

    public int getNumeroPeriodistas() {
        return numeroPeriodistas;
    }

    public String[][] getPeriodistas() {
        return periodistas;
    }

    public DefaultTableModel obtenerDatosPeriodista(){
        String[] columna = {"NOMBRE","FECHA_NACIMINETO","CI","ID_PERIODISTA","EMPLEADO","SUELDO","DATOS_EXTRA"};
        String[] fila = new String[7];
        DefaultTableModel modelo = new DefaultTableModel(null, columna);
        for (int i = 0; i < this.numeroPeriodistas; i++) {
            fila[0] = this.periodistas[i][1];
            fila[1] = this.periodistas[i][2];
            fila[2] = this.periodistas[i][3];
            fila[3] = this.periodistas[i][4];
            fila[4] = this.periodistas[i][5];
            fila[5] = this.periodistas[i][6];
            fila[6] = this.periodistas[i][7]+" - "+this.periodistas[i][8];
            modelo.addRow(fila);
        }
        return modelo;
    }
    
    public DefaultTableModel obtenerDatosPeriodista(String tipoPeriodista){
        String[] columna = {"NOMBRE","FECHA_NACIMINETO","CI","ID_PERIODISTA","EMPLEADO","SUELDO","DATOS_EXTRA"};
        String[] fila = new String[7];
        DefaultTableModel modelo = new DefaultTableModel(null, columna);
        for (int i = 0; i < this.numeroPeriodistas; i++) {
            if(this.periodistas[i][0].equals(tipoPeriodista)){
                fila[0] = this.periodistas[i][1];
                fila[1] = this.periodistas[i][2];
                fila[2] = this.periodistas[i][3];
                fila[3] = this.periodistas[i][4];
                fila[4] = this.periodistas[i][5];
                fila[5] = this.periodistas[i][6];
                fila[6] = this.periodistas[i][7] + " - " + this.periodistas[i][8];
                modelo.addRow(fila);
            }
        }
        return modelo;
    }
    
    public void agregarPeriodista(Periodista periodista) {
        this.periodistas[this.numeroPeriodistas][0] = periodista.getClass().getSimpleName();
        this.periodistas[this.numeroPeriodistas][1] = periodista.getNombre();
        this.periodistas[this.numeroPeriodistas][2] = periodista.getFechaNacimiento();
        this.periodistas[this.numeroPeriodistas][3] = periodista.getCedulaIdentidad() + "";
        this.periodistas[this.numeroPeriodistas][4] = periodista.getIdPeriodista();
        this.periodistas[this.numeroPeriodistas][5] = periodista.isEmpleado() + "";
        this.periodistas[this.numeroPeriodistas][6] = periodista.getSueldo() + "";
        
        if (periodista instanceof ConductorTV) {
            ConductorTV datosConductorTV = (ConductorTV) periodista;
            this.periodistas[this.numeroPeriodistas][7] = datosConductorTV.getCasaTelevisa();
            this.periodistas[this.numeroPeriodistas][8] = datosConductorTV.getPrograma();
        } else {
            Escritor datosConductorTV = (Escritor) periodista;
            this.periodistas[this.numeroPeriodistas][7] = datosConductorTV.getNombrePeriodico();
            this.periodistas[this.numeroPeriodistas][8] = datosConductorTV.getSector();
        }
        this.numeroPeriodistas++;

    }
}
