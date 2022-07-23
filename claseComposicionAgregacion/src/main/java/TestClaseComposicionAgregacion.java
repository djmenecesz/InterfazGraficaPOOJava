
public class TestClaseComposicionAgregacion {
    
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        
        Asegurado asegurado = new Asegurado("1", "Darah", "Flores", "Flores", "20/10/1998");
        CitaMedica citaMedica = new CitaMedica("lunes", "10:00-10:30", false, null);
        
        hospital.agregarCitaMedicaDoctor(0, citaMedica);
        hospital.agregarAsegurado(asegurado);
        hospital.agregarDoctor("4", "Erick Rodriguez", "prueba");
        
    }
}
