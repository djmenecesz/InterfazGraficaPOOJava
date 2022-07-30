
import java.io.Serializable;


public class ContratoAlquiler implements Serializable{

    private String idDepartamento;
    private String fechaInicio;
    private String fechaFin;

    public ContratoAlquiler() {
    }

    public ContratoAlquiler(String idDepartamento, String fechaInicio, String fechaFin) {
        this.idDepartamento = idDepartamento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

}
