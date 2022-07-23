
public class CitaMedica {

    private String diaSemana;
    private String horario;
    private boolean esReservado;
    private String idAsegurado;

    public CitaMedica() {
    }

    public CitaMedica(String diaSemana, String horario, boolean esReservado, String idAsegurado) {
        this.diaSemana = diaSemana;
        this.horario = horario;
        this.esReservado = esReservado;
        this.idAsegurado = idAsegurado;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public boolean isEsReservado() {
        return esReservado;
    }

    public void setEsReservado(boolean esReservado) {
        this.esReservado = esReservado;
    }

    public String getIdAsegurado() {
        return idAsegurado;
    }

    public void setIdAsegurado(String idAsegurado) {
        this.idAsegurado = idAsegurado;
    }

}
