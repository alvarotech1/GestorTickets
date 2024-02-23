package App;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {


    public static List<Usuario> leerUsuariosDesdeCSV() {
        List<Usuario> usuarios = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("src/main/java/App/usuarios.csv"))) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] datosUsuario = linea.split(",");

                if (datosUsuario.length == 3) {
                    String nombreUsuario = datosUsuario[0].trim();
                    String contraseña = datosUsuario[1].trim();
                    String email = datosUsuario[2].trim();
                    Usuario usuario = new Usuario(nombreUsuario, contraseña,email);
                    usuarios.add(usuario);
                } else {
                    System.out.println("Error en el formato de la línea: 1" + linea);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        }

        return usuarios;
    }

    public static List<Vuelo> leerVuelosDesdeCSV() {
        List<Vuelo> vuelos = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("src/main/java/App/vuelos.csv"))) {
        	
        	while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] datosVuelo = linea.split(",");

                if (datosVuelo.length == 8) {
                    int id = Integer.parseInt(datosVuelo[0].trim());
                    String origen = datosVuelo[1].trim();
                    String destino = datosVuelo[2].trim();
                    String fecha = datosVuelo[3].trim();
                    String hora = datosVuelo[4].trim();
                    String clase = datosVuelo[5].trim();
                    double precio = Double.parseDouble(datosVuelo[6].trim());
                    int asientos = Integer.parseInt(datosVuelo[7].trim());

                    Vuelo vuelo = new Vuelo(id, origen, destino, fecha, hora, clase, precio, asientos);
                    vuelos.add(vuelo);
                } else {
                    System.out.println("Error en el formato de la línea: 2" + linea);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        }

        return vuelos;
    }
}
   
    



