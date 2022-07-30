
public class ClasePersistenciaArchivos {

    public static void main(String[] args) {
        Persona duenioCondominio = new Persona("Daniel", "Perez", "Mendoza", 111111, "20-10-1995");
        Condominio condominio = new Condominio(duenioCondominio, "Condominio ABC", "Av. Arce", 123456);
        condominio.agregarDepartamento("d1", 1000, 200, "/imagenes/depa1.jpg");
        condominio.agregarDepartamento("d2", 1500, 100, "/imagenes/depa2.jpg");
        condominio.agregarDepartamento("d3", 2000, 200, "/imagenes/depa1.jpg");
        condominio.agregarDepartamento("d4", 2500, 300, "/imagenes/depa3.jpg");
        condominio.agregarDepartamento("d5", 5000.6, 200, "/imagenes/depa2.jpg");

        Inquilino inquilino1 = new Inquilino("i1", "d1", "27-07-2022", "27-08-2022", "Carlos", "Rodriguez", "Apaza", 222222, "07-07-1993");
        Inquilino inquilino2 = new Inquilino("i2", "d2", "20-05-2022", "20-10-2022", "David", "Meneces", "Zelaya", 333333, "20-10-1998");
        condominio.agregarInquilino(inquilino1);
        condominio.agregarInquilino(inquilino2);

        String ruta = "condominio.dat";
        ArchivoCondominio archivoCondominio = new ArchivoCondominio(ruta);
        archivoCondominio.eliminarArchivo();
        archivoCondominio.crearArchivo();
        archivoCondominio.escribirArchivo(condominio);
//        Condominio condominio = archivoCondominio.leerArchivo();
//        System.out.println(condominio.getDepartamentos()[2].getIdDepartamento());

    }
}
