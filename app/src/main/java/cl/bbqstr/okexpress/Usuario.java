package cl.bbqstr.okexpress;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Usuario implements Serializable {
    String nombre, user, password, apellido, fechaDeNacimiento, rut;

    public Usuario(String nombre, String user, String password, String apellido, String fechaDeNacimiento, String rut) {
        this.nombre = nombre;
        this.user = user;
        this.password = password;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public String getRut() {
        return rut;
    }
}
