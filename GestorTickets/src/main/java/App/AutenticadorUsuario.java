package App;

import java.util.List;

public class AutenticadorUsuario {
	


	public static boolean autenticarUsuario(String nombreUsuario, String contraseña) {
        List<Usuario> usuarios = CSVReader.leerUsuariosDesdeCSV();
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContraseña().equals(contraseña)) {
                
                return true;
            }
        }
        return false;
    }
}
