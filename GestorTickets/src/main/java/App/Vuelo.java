package App;

public class Vuelo {
    private int id;
    private String origen;
    private String destino;
    private String fecha;
    private String hora;
    private String clase;
    private double precio;
    private int asientos;

    public Vuelo(int id, String origen, String destino, String fecha, String hora, String clase, double precio, int asientos) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.hora = hora;
        this.clase = clase;
        this.precio = precio;
        this.asientos = asientos;
    }

    public int getId() {
        return id;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getClase() {
        return clase;
    }

    public double getPrecio() {
        return precio;
    }

    public int getAsientos() {
        return asientos;
    }
    
  

    @Override
    public String toString() {
        return "Vuelo{" +
                "id=" + id +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", clase='" + clase + '\'' +
                ", precio=" + precio +
                ", asientos=" + asientos +
                '}';
    }
}
