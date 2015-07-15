package susanhenr.com.proyectojedi;

/**
 * Created by susanhenriquez on 14/7/15.
 */
public class Jugador {

    private String nombre;
    private int puntuacion;

    Jugador( String nombre, int puntuacion){

        this.nombre = nombre;
        this.puntuacion = puntuacion;

    }
    Jugador(){

    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String name) {
        this.nombre = name;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}

