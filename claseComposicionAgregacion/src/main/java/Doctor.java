
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class Doctor {

    private String idDoctor;
    private String nombres;
    private String especialidad;
    private int numeroCitas;
    private CitaMedica[] citasMedicas = new CitaMedica[100];

    public Doctor() {
        this.numeroCitas = 0;
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

    public void agregarCitaMedica(CitaMedica citaMedica) {
        this.citasMedicas[this.numeroCitas] = citaMedica;
        this.numeroCitas++;
    }

    public DefaultTableModel obtenerCitasMedicasDisponibles() {
        String[] columna = {"dia", "horario", "Reservar"};
        Object[] fila = new Object[3];
        DefaultTableModel modelo = new DefaultTableModel(null, columna) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        for (int i = 0; i < this.getNumeroCitas(); i++) {
            if (!this.citasMedicas[i].isEsReservado()) {
                fila[0] = this.citasMedicas[i].getDiaSemana();
                fila[1] = this.citasMedicas[i].getHorario();
                JButton botonReservar = new JButton("Reservar");
                fila[2] = botonReservar;
                modelo.addRow(fila);
            }
        }
        return modelo;
    }

    public DefaultTableModel obtenerCitasMedicasDisponiblesAsegurado(String idAsegurado, DefaultTableModel modelo) {
        String[] fila = new String[2];
        for (int i = 0; i < this.getNumeroCitas(); i++) {
            if (this.citasMedicas[i].isEsReservado() && this.citasMedicas[i].getIdAsegurado().equals(idAsegurado)) {
                fila[0] = this.citasMedicas[i].getDiaSemana();
                fila[1] = this.citasMedicas[i].getHorario();
                modelo.addRow(fila);
            }
        }
        return modelo;
    }

}
