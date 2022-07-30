
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ArchivoCondominio {

    private String ruta;

    public ArchivoCondominio(String ruta) {
        this.ruta = ruta;
    }

    public void crearArchivo() {
        try {
            File archivo = new File(ruta);
            if (archivo.exists()) {
                String opcion = "";
                if (opcion.equals("s")) {
                    archivo.delete();
                }
                System.out.println("El archivo ya existe");
            } else {
                archivo.createNewFile();
                System.out.println("Archivo Creado");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarArchivo() {
        try {
            File archivo = new File(ruta);
            archivo.delete();
            System.out.println("Arvhivo Eliminado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Condominio leerArchivo() {
        Condominio condominio = null;
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(ruta);
            objectInputStream = new ObjectInputStream(fileInputStream);
            while (true) {
                condominio = (Condominio) objectInputStream.readObject();
            }
        } catch (Exception e) {
            System.out.println("Fin archivo");
        } finally {
            try {
                fileInputStream.close();
            } catch (Exception e) {
            }
        }
        return condominio;
    }

    public void escribirArchivo(Condominio nuevoCondominio) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileOutputStream = new FileOutputStream("archTemp.dat");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            fileInputStream = new FileInputStream(ruta);
            objectInputStream = new ObjectInputStream(fileInputStream);
            while (true) {
                Condominio condominio = (Condominio) objectInputStream.readObject();
                objectOutputStream.writeObject(condominio);
            }
        } catch (Exception e) {
            try {
                objectOutputStream.writeObject(nuevoCondominio);
                System.out.println("Objeto agregardo con exito");
                fileInputStream.close();
                fileOutputStream.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            File arvhivoOriginal = new File(ruta);
            File arvhivoTemporal = new File("archTemp.dat");
            arvhivoOriginal.delete();
            arvhivoTemporal.renameTo(arvhivoOriginal);
        }
    }

    public void editarArchivo(Condominio condominioEditado) {
        eliminarArchivo();
        crearArchivo();
        escribirArchivo(condominioEditado);
        System.out.println("Archivo Editado...");
    }

}
