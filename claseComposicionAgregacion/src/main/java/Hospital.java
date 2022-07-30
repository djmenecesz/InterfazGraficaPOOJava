
import javax.swing.table.DefaultTableModel;

public class Hospital {

    private String nombre;
    private String direccion;
    private int numeroAsegurados;
    private Asegurado[] asegurados = new Asegurado[100];
    private int numeroDoctores;
    private Doctor[] doctores = new Doctor[100];
    private Doctor doctorEncargado;

    public Hospital() {
        this.nombre = "Hospital Central";
        this.direccion = "Av. Arce";
        this.numeroAsegurados = 0;
        this.numeroDoctores = 0;
    }

    public Hospital(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numeroAsegurados = 0;
        this.numeroDoctores = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumeroAsegurados() {
        return numeroAsegurados;
    }

    public void setNumeroAsegurados(int numeroAsegurados) {
        this.numeroAsegurados = numeroAsegurados;
    }

    public Asegurado[] getAsegurados() {
        return asegurados;
    }

    public void setAsegurados(Asegurado[] asegurados) {
        this.asegurados = asegurados;
    }

    public int getNumeroDoctores() {
        return numeroDoctores;
    }

    public void setNumeroDoctores(int numeroDoctores) {
        this.numeroDoctores = numeroDoctores;
    }

    public Doctor[] getDoctores() {
        return doctores;
    }

    public void setDoctores(Doctor[] doctores) {
        this.doctores = doctores;
    }

    public Doctor getDoctorEncargado() {
        return doctorEncargado;
    }

    public void setDoctorEncargado(Doctor doctorEncargado) {
        this.doctorEncargado = doctorEncargado;
    }

    public void agregarDoctor(Doctor nuevoDoctor) {
        this.doctores[this.numeroDoctores] = nuevoDoctor;
        this.numeroDoctores++;
    }

    public void agregarAsegurado(Asegurado nuevoAsegurado) {
        this.asegurados[this.numeroAsegurados] = nuevoAsegurado;
        this.numeroAsegurados++;
    }

    public DefaultTableModel obeterDatosCitasMedicasDoctor(String idDoctor) {
        String[] columna = {"Dia", "Horario", "Reservar"};
        DefaultTableModel modelo = new DefaultTableModel(null, columna) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        for (int i = 0; i < this.numeroDoctores; i++) {
            if (this.doctores[i].getIdDoctor().equals(idDoctor)) {
                modelo = this.doctores[i].obtenerCitasMedicas(false, modelo);
            }
        }
        return modelo;
    }

    public DefaultTableModel obeterDatosCitasMedicasAsegurado(String idAsegurado) {
        String[] columna = {"Dia", "Horario"};
        String[] fila = new String[2];
        DefaultTableModel modelo = new DefaultTableModel(null, columna);
        for (int i = 0; i < this.numeroDoctores; i++) {
            modelo = this.doctores[i].obtenerCitasPorAsegurado(modelo, idAsegurado);
        }
        return modelo;
    }

    public DefaultTableModel obeterDatosDoctores() {
        String[] columna = {"Id doctor", "Nombres", "Especialidad", "Citas Disponibles"};
        String[] fila = new String[4];

        DefaultTableModel modelo = new DefaultTableModel(null, columna);
        for (int i = 0; i < this.numeroDoctores; i++) {
            fila[0] = this.doctores[i].getIdDoctor();
            fila[1] = this.doctores[i].getNombres();
            fila[2] = this.doctores[i].getEspecialidad();
            fila[3] = this.doctores[i].numeroCitasDisponibles() + "";
            modelo.addRow(fila);
        }
        return modelo;
    }

    public DefaultTableModel obeterDatosAsegurado() {
        String[] columna = {"Id Asegurado", "Nombres", "Fecha Nacimiento"};
        String[] fila = new String[3];

        DefaultTableModel modelo = new DefaultTableModel(null, columna);
        for (int i = 0; i < this.numeroAsegurados; i++) {
            fila[0] = this.asegurados[i].getIdAsegurado();
            fila[1] = this.asegurados[i].getNombres() + " "
                    + this.asegurados[i].getApellidoPaterno() + " "
                    + this.asegurados[i].getApellidoMaterno();
            fila[2] = this.asegurados[i].getFechaNacimiento();
            modelo.addRow(fila);
        }
        return modelo;
    }

    public boolean reservarCitaMedica(String idAsegurado, String idDoctor, String dia, String horario) {
        for (int i = 0; i < this.numeroDoctores; i++) {
            if (this.doctores[i].getIdDoctor().equals(idDoctor)) {
                return this.doctores[i].reservarCitaMedica(idAsegurado, dia, horario);
            }
        }
        return false;
    }

}
