
public class ClaseHerencia {
    
    public static void main(String[] args) {
        ConductorTV conductorTV = new ConductorTV("ATB", "Deportes", "ctv1", true, 2000, "Carlo Perez", "20-10-1997", 1111111);
        System.out.println("conductorTV = " + conductorTV);
        
        Escritor escritor = new Escritor("ABC", "Noticias", "esc1", true, 2500, "Juan Perez", "05-10-1997", 2222222);
        System.out.println("escritor = " + escritor);
        
        Periodista periodista1 = new ConductorTV("ATB", "Deportes", "ctv1", true, 2000, "Carlo Perez", "20-10-1997", 1111111);
        Periodista periodista2 = new Escritor("ABC", "Noticias", "esc1", true, 2500, "Juan Perez", "05-10-1997", 2222222);
        System.out.println(periodista1 instanceof ConductorTV);
        System.out.println(periodista1 instanceof Escritor);
        System.out.println(periodista2 instanceof Escritor);
        System.out.println(periodista2 instanceof ConductorTV);
        
        ConductorTV conductorTVperiodista = (ConductorTV) periodista1;
        System.out.println(conductorTVperiodista.getClass().getSimpleName());
        System.out.println("conductorTVperiodista = " + conductorTVperiodista);
        
        Escritor escritorPeriodista = (Escritor) periodista2;
        System.out.println("escritorPeriodista = " + escritorPeriodista);
        
    }
}
