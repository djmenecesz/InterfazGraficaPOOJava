
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
        this.nombre = "ABC";
        this.direccion = "Av. Arce No.1231";
        this.numeroAsegurados = 0;
        this.numeroDoctores = 3;
        this.doctores[0] = new Doctor("d1", "Carlos Perez", "Cirujano");
        this.doctores[1] = new Doctor("d2", "Daniel Meneces", "Cirujano");
        this.doctores[2] = new Doctor("d3", "Ana Flores", "Cirujano");
        this.doctorEncargado = new Doctor("d4", "Joel Mendieta", "Cirujano");
    }

    public Hospital(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = "Av. Arce No.1231";
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

    public void agregarAsegurado(Asegurado nuevoAsegurado) {
        this.asegurados[this.numeroAsegurados] = nuevoAsegurado;
        this.numeroAsegurados++;
    }

    public void agregarDoctor(String idDoctor, String nombreDoctor, String especialidadDoctor) {
        this.doctores[this.numeroDoctores] = new Doctor(idDoctor, nombreDoctor, especialidadDoctor);
        this.numeroDoctores++;
    }

    public void agregarDoctorEncargado(String idDoctor, String nombreDoctor, String especialidadDoctor) {
        Doctor doctor = new Doctor(idDoctor, nombreDoctor, especialidadDoctor);
        this.doctorEncargado = doctor;
    }

    public void agregarCitaMedicaDoctor(int i, CitaMedica nuevaCitaMedica) {
        this.doctores[i].agregarCitaMedica(nuevaCitaMedica);
    }

    public DefaultTableModel obtenerTablaDoctores() {
        String[] columna = {"idDoctor", "Nombre Doctor", "Especialidad Doctor"};
        String[] fila = new String[3];
        DefaultTableModel modelo = new DefaultTableModel(null, columna);

        for (int i = 0; i < this.numeroDoctores; i++) {
            fila[0] = this.doctores[i].getIdDoctor();
            fila[1] = this.doctores[i].getNombres();
            fila[2] = this.doctores[i].getEspecialidad();
            modelo.addRow(fila);
        }
        return modelo;
    }

    public DefaultTableModel obtenerTablaAsegurados() {
        String[] columna = {"id", "nombres", "apellidoPaterno", "apellidoMaterno", "fechaNacimiento"};
        String[] fila = new String[5];
        DefaultTableModel modelo = new DefaultTableModel(null, columna);

        for (int i = 0; i < this.numeroAsegurados; i++) {
            fila[0] = this.asegurados[i].getIdAsegurado();
            fila[1] = this.asegurados[i].getNombres();
            fila[2] = this.asegurados[i].getApellidoPaterno();
            fila[3] = this.asegurados[i].getApellidoMaterno();
            fila[4] = this.asegurados[i].getFechaNacimiento();
            modelo.addRow(fila);
        }
        return modelo;
    }

    public DefaultTableModel obtenerTablaCitasMedicasDisponibles(String idDoctor) {
        DefaultTableModel modelo = null;
        for (int i = 0; i < this.numeroAsegurados; i++) {
            if (idDoctor.equals(this.doctores[i].getIdDoctor())) {
                modelo = this.doctores[i].obtenerCitasMedicasDisponibles();
            }
        }
        return modelo;
    }

    public void reservarCita(String idAsegurado, String idDoctor, String horario, String dia) {
        for (int i = 0; i < this.numeroAsegurados; i++) {
            if (idDoctor.equals(this.doctores[i].getIdDoctor())) {
                CitaMedica[] citas = this.doctores[i].getCitasMedicas();
                for (int j = 0; j < this.doctores[i].getNumeroCitas(); j++) {
                    System.out.println(j);
                    if (citas[j].getDiaSemana().equals(dia) && citas[j].getHorario().equals(horario)) {
                        System.out.println(j);
                        citas[j].setIdAsegurado(idAsegurado);
                        citas[j].setEsReservado(true);
                    }
                }
            }
        }
    }

    public DefaultTableModel obtenerTablaCitasMedicasAsegurado(String idAsegurado) {
        System.out.println("modelo = ");
        String[] columna = {"dia", "horario"};
        String[] fila = new String[2];
        DefaultTableModel modelo = new DefaultTableModel(null, columna);
        for (int i = 0; i < this.numeroDoctores; i++) {
            modelo = this.doctores[i].obtenerCitasMedicasDisponiblesAsegurado(idAsegurado, modelo);
        }
        return modelo;
    }
}
