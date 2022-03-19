package alejedrez;

/**
 * Clase Posicion. Determina una fila y columna.
 * @author ale
 */
public class Posicion {

    protected int fila;
    protected int columna;

    /**
     * Constructor vacío.
     */
    public Posicion() {

    }

    /**
     * Constructor.
     *
     * @param fila
     * @param columna
     */
    public Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    /**
     * Setter. Establece el atributo fila
     *
     * @param fila
     */
    public void setFila(int fila) {
        this.fila = fila;
    }

    /**
     * Setter. Establece el atributo columna
     *
     * @param columna
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }

    /**
     * Getter.
     *
     * @return fila
     */
    public int getFila() {
        return fila;
    }

    /**
     * Getter.
     *
     * @return columna
     */
    public int getColumna() {
        return columna;
    }

    /**
     * @return Devuelve una posición en un plano bidimensional
     *
     */
    @Override
    public String toString() {
        return "Posicion{" + "fila=" + fila + ", columna=" + columna + '}';
    }

}
