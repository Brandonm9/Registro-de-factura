package Codigo;

import java.security.SecureRandom;
import java.util.Random;

public class Cliente {
    String Id,nombre,direccion,Correo;
    int numTelefono;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int LENGTH = 8;
    private final Random random = new SecureRandom();

    public Cliente(String id, String nombre, String direccion, String correo, int numTelefono) {
        this.Id = generadorDeId();
        this.nombre = nombre;
        this.direccion = direccion;
        Correo = correo;
        this.numTelefono = numTelefono;
    }

    public Cliente(String nombre, String id) {
        this.nombre = nombre;
        this.Id = generadorDeId();
    }
    public String generadorDeId() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < LENGTH; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public int getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(int numTelefono) {
        this.numTelefono = numTelefono;
    }
}
