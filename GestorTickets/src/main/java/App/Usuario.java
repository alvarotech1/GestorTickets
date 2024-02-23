package App;

public class Usuario {
    private String nombreUsuario;
    private String contraseña;
    private String email;

    public Usuario(String nombreUsuario, String contraseña, String email) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.email = email;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }
    public String getEmail() {
        return email;
    }
}