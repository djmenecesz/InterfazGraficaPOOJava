
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author David
 */
public class Banco {

    private String nombre;
    private String sigla;
    private String duenio;
    private int numeroClientes;
    private String[][] clientes = new String[100][5];

    public Banco() {
        this.nombre = "Banco Central de Boivia";
        this.sigla = "BCB";
        this.duenio = "Alan Brito";
        this.numeroClientes = 4;
        //corriente, ahorro
        this.clientes[0][0] = "111111";
        this.clientes[0][1] = "David Meneces";
        this.clientes[0][2] = "123123";
        this.clientes[0][3] = "corriente";
        this.clientes[0][4] = "1000";

        this.clientes[1][0] = "222222";
        this.clientes[1][1] = "Carlos Perez";
        this.clientes[1][2] = "234234";
        this.clientes[1][3] = "ahorro";
        this.clientes[1][4] = "3000";
        
        this.clientes[2][0] = "333333";
        this.clientes[2][1] = "Ana Loaiza";
        this.clientes[2][2] = "345345";
        this.clientes[2][3] = "ahorro";
        this.clientes[2][4] = "2000";
        
        this.clientes[3][0] = "444444";
        this.clientes[3][1] = "David Meneces";
        this.clientes[3][2] = "456456";
        this.clientes[3][3] = "corriente";
        this.clientes[3][4] = "1500";
    }

    public Banco(String nombre, String sigla, String duenio, int numeroClientes) {
        this.nombre = nombre;
        this.sigla = sigla;
        this.duenio = duenio;
        this.numeroClientes = numeroClientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDuenio() {
        return duenio;
    }

    public void setDuenio(String duenio) {
        this.duenio = duenio;
    }

    public int getNumeroClientes() {
        return numeroClientes;
    }

    public void setNumeroClientes(int numeroClientes) {
        this.numeroClientes = numeroClientes;
    }

    public String[][] getClientes() {
        return clientes;
    }

    public void setClientes(String[][] clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {

        return "Banco{" + "\n\tnombre=" + nombre + ", \n\tsigla=" + sigla + ", \n\tduenio=" + duenio + ", \n\tnumeroClientes=" + numeroClientes + ", \n\tclientes= [\n" + getDatosCliente() + "\n]\n}";
    }

    public DefaultTableModel obtenerDatosUsuario() {
        String[] columnas = {"ID", "NOMBRE", "CUENTA", "TIPO CUENTA", " SALDO"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        String[] fila = new String[5];
        for (int i = 0; i < this.numeroClientes; i++) {
            fila[0] = this.clientes[i][0];
            fila[1] = this.clientes[i][1];
            fila[2] = this.clientes[i][2];
            fila[3] = this.clientes[i][3];
            fila[4] = this.clientes[i][4];
            modelo.addRow(fila);
        }
        return modelo;
    }

    public DefaultTableModel obtenerDatosUsuario(String idCliente) {
        String[] columnas = {"ID", "NOMBRE", "CUENTA", "TIPO CUENTA", " SALDO"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        String[] fila = new String[5];
        for (int i = 0; i < this.numeroClientes; i++) {
            if (this.clientes[i][0].equals(idCliente)) {
                fila[0] = this.clientes[i][0];
                fila[1] = this.clientes[i][1];
                fila[2] = this.clientes[i][2];
                fila[3] = this.clientes[i][3];
                fila[4] = this.clientes[i][4];
                modelo.addRow(fila);
                return modelo;
            }
        }
        return modelo;
    }

    public DefaultTableModel obtenerDatosUsuario(String nombre, String tipoCuenta) {
        String[] columnas = {"ID", "NOMBRE", "CUENTA", "TIPO CUENTA", " SALDO"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        String[] fila = new String[5];
        for (int i = 0; i < this.numeroClientes; i++) {
            if (this.clientes[i][1].equals(nombre) && this.clientes[i][3].equals(tipoCuenta)) {
                fila[0] = this.clientes[i][0];
                fila[1] = this.clientes[i][1];
                fila[2] = this.clientes[i][2];
                fila[3] = this.clientes[i][3];
                fila[4] = this.clientes[i][4];
                modelo.addRow(fila);
            }
        }
        return modelo;
    }
    
    public void agregarCliente(String id, String nombre, String cuenta, String tipoCuenta, String saldo){
        this.clientes[numeroClientes][0]=id;
        this.clientes[numeroClientes][1]=nombre;
        this.clientes[numeroClientes][2]=cuenta;
        this.clientes[numeroClientes][3]=tipoCuenta;
        this.clientes[numeroClientes][4]=saldo;
        this.numeroClientes++;
    }

    public String getDatosCliente() {
        String listaClientes = "";
        String datosCliente = "\n\tCliente = {\n\t\tid=%s, \n\t\tnombre=%s, \n\t\tcuenta=%s, \n\t\ttipoCuenta=%s, \n\t\tsaldo=%s}";
        for (int i = 0; i < this.numeroClientes; i++) {
            String cliente = String.format(datosCliente,
                    this.clientes[i][0],
                    this.clientes[i][1],
                    this.clientes[i][2],
                    this.clientes[i][3],
                    this.clientes[i][4]);
            if (i < this.numeroClientes - 1) {
                listaClientes = listaClientes + cliente + ",";
            } else {
                listaClientes = listaClientes + cliente;
            }
        }
        return listaClientes;
    }

}
