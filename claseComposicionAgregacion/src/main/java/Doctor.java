
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class Doctor {

    private String idDoctor;
    private String nombres;
    private String especialidad;
    private int numeroCitas;
    private CitaMedica[] citasMedicas = new CitaMedica[100];

    public Doctor() {
        this.idDoctor = "d1";
        this.nombres = "Carlos Perez";
        this.especialidad = "Cirujano";
        this.numeroCitas = 3;
        citasMedicas[0] = new CitaMedica("lunes", "10:30-11:00", false, null);
        citasMedicas[1] = new CitaMedica("lunes", "11:00-11:30", false, null);
        citasMedicas[2] = new CitaMedica("lunes", "12:00-12:30", false, null);
        citasMedicas[2] = new CitaMedica("martes", "12:00-12:30", false, null);
    }

    public Doctor(String idDoctor, String nombres, String especialidad) {
        this.idDoctor = idDoctor;
        this.nombres = nombres;
        this.especialidad = especialidad;
        this.numeroCitas = 0;
    }

    public String getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(String idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getNumeroCitas() {
        return numeroCitas;
    }

    public void setNumeroCitas(int numeroCitas) {
        this.numeroCitas = numeroCitas;
    }

    public CitaMedica[] getCitasMedicas() {
        return citasMedicas;
    }

    public void setCitasMedicas(CitaMedica[] citasMedicas) {
        this.citasMedicas = citasMedicas;
    }

    public void agregarCitaMedica(String diaSemana, String horario, boolean esReservado, String idAsegurado) {
        CitaMedica nuevaCitaMedica = new CitaMedica(diaSemana, horario, esReservado, idAsegurado);
        this.citasMedicas[this.numeroCitas] = nuevaCitaMedica;
        this.numeroCitas++;
    }

    public int numeroCitasDisponibles() {
        int cont = 0;
        for (int i = 0; i < this.numeroCitas; i++) {
            if (!this.citasMedicas[i].isEsReservado()) {
                cont++;
            }
        }
        return cont;
    }

    public DefaultTableModel obtenerCitasMedicas(boolean esReservado, DefaultTableModel modelo) {

        Object[] fila = new Object[3];
        for (int i = 0; i < this.numeroCitas; i++) {
            if (this.citasMedicas[i].isEsReservado() == esReservado) {
                fila[0] = this.citasMedicas[i].getDiaSemana();
                fila[1] = this.citasMedicas[i].getHorario();
                fila[2] = new JButton("Reservar");
                modelo.addRow(fila);
            }
        }
        return modelo;
    }

    public DefaultTableModel obtenerCitasPorAsegurado(DefaultTableModel modelo, String idAsegurado) {
        String[] fila = new String[2];
        for (int i = 0; i < this.numeroCitas; i++) {
            if (this.citasMedicas[i].isEsReservado() && this.citasMedicas[i].getIdAsegurado().equals(idAsegurado)) {
                fila[0] = this.citasMedicas[i].getDiaSemana();
                fila[1] = this.citasMedicas[i].getHorario();
                modelo.addRow(fila);
            }
        }
        return modelo;
    }

    public boolean reservarCitaMedica(String idAsegurado, String dia, String horario) {
        for (int i = 0; i < this.numeroCitas; i++) {
            if (this.citasMedicas[i].getDiaSemana().equals(dia) && this.citasMedicas[i].getHorario().equals(horario)) {
                this.citasMedicas[i].setEsReservado(true);
                this.citasMedicas[i].setIdAsegurado(idAsegurado);
                return true;
            }
        }
        return false;
    }

}
