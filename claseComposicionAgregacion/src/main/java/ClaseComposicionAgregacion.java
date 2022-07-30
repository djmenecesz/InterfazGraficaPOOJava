
public class ClaseComposicionAgregacion {

    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Doctor doctor1 = new Doctor("d1", "Carlos Perez", "Cirujano");
        Doctor doctor2 = new Doctor("d1", "Carlos Perez", "Cirujano");
        Doctor doctor3 = new Doctor("d1", "Carlos Perez", "Cirujano");

        doctor1.agregarCitaMedica("lunes", "10:30-11:00", false, null);
        doctor1.agregarCitaMedica("lunes", "11:00-11:30", false, null);
        doctor1.agregarCitaMedica("martes", "10:30-11:00", false, null);
        doctor1.agregarCitaMedica("martes", "11:00-11:30", false, null);
        doctor2.agregarCitaMedica("mircoles", "10:30-11:00", false, null);
        doctor2.agregarCitaMedica("mircoles", "11:00-11:30", false, null);
        doctor2.agregarCitaMedica("jueves", "10:30-11:00", false, null);
        doctor1.agregarCitaMedica("lunes", "10:30-11:00", true, "a1");
        doctor1.agregarCitaMedica("lunes", "11:00-11:30", false, null);
        doctor1.agregarCitaMedica("martes", "10:30-11:00", false, null);
        doctor1.agregarCitaMedica("martes", "11:00-11:30", false, null);

        Asegurado asegurado1 = new Asegurado("a1", "David", "Meneces", "Zelaya", "20-10-1998");
        Asegurado asegurado2 = new Asegurado("a2", "Ana", "Rodriguez", "Perez", "21-09-1997");
        Asegurado asegurado3 = new Asegurado("a3", "Erick", "Rodriguez", "Apaza", "07-07-1999");

        hospital.agregarDoctor(doctor1);
        hospital.agregarDoctor(doctor2);
        hospital.agregarDoctor(doctor3);

        hospital.agregarAsegurado(asegurado1);
        hospital.agregarAsegurado(asegurado2);
        hospital.agregarAsegurado(asegurado3);

        System.out.println(hospital.getAsegurados()[0].getNombres());
        System.out.println(hospital.getDoctores()[0].getNombres());
    }
}
