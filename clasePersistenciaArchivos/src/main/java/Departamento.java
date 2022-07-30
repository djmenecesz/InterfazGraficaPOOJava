
import java.io.Serializable;

public class Departamento implements Serializable {

    private String idDepartamento;
    private double costo;
    private double superficie;
    private String rutaImagen;

    public Departamento() {
    }

    public Departamento(String idDepartamento, double costo, double superficie, String rutaImagen) {
        this.idDepartamento = idDepartamento;
        this.costo = costo;
        this.superficie = superficie;
        this.rutaImagen = rutaImagen;
    }

    public String getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    @Override
    public String toString() {
        return "Departamento{" + "idDepartamento=" + idDepartamento + ", costo=" + costo + ", superficie=" + superficie + ", rutaImagen=" + rutaImagen + '}';
    }

}
