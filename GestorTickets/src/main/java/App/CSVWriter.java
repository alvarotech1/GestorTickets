package App;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter {

    private static final String CSV_SEPARATOR = ",";

    public static void escribirUsuariosEnCSV(List<Usuario> usuarios) {
        String csvFile = "src/main/java/App/usuarios.csv";

        try (FileWriter writer = new FileWriter(csvFile)) {
            for (Usuario usuario : usuarios) {
                writer.append(usuario.getNombreUsuario());
                writer.append(CSV_SEPARATOR);
                writer.append(usuario.getContraseña());
                writer.append(CSV_SEPARATOR);
                writer.append(usuario.getEmail());
                writer.append("\n");
            }

            System.out.println("¡Archivo CSV creado exitosamente!");

        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo CSV: " + e.getMessage());
        }
    }
    
    public static void escribirVuelosEnCSV(List<Vuelo> vuelos) {
        String csvFile = "src/main/java/App/vuelos.csv";

        try (FileWriter writer = new FileWriter(csvFile)) {
            for (Vuelo vuelo : vuelos) {
                writer.append(String.valueOf(vuelo.getId()));
                writer.append(CSV_SEPARATOR);
                writer.append(vuelo.getOrigen());
                writer.append(CSV_SEPARATOR);
                writer.append(vuelo.getDestino());
                writer.append(CSV_SEPARATOR);
                writer.append(vuelo.getFecha());
                writer.append(CSV_SEPARATOR);
                writer.append(vuelo.getHora());
                writer.append(CSV_SEPARATOR);
                writer.append(vuelo.getClase());
                writer.append(CSV_SEPARATOR);
                writer.append(String.valueOf(vuelo.getPrecio()));
                writer.append(CSV_SEPARATOR);
                writer.append(String.valueOf(vuelo.getAsientos()));
                writer.append("\n");
            }

        

        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo CSV: " + e.getMessage());
        }
    }
}
