package susanhenr.com.proyectojedi;

/**
 * Created by susanhenriquez on 14/7/15.
 */
public class Jugador {

    private String nombre;
    private String puntuacion;

    Jugador( String nombre, String puntuacion){

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

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }
}

