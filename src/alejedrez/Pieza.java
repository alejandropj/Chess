package alejedrez;
/**
 * Clase Pieza, padre de Peon, Torre, Dama, Caballo y Alfil. Es usada por Tablero.
 * @author ale
 */
public abstract class Pieza {
    protected char color;
    protected char nombre;
    
    /**
     * Constructor.
     * @param color 
     */
    public Pieza(char color){
        this.color=color;
    }
    /**
     * Constructor.
     * @param color
     * @param nombre 
     */
    public Pieza(char color,char nombre){
        this.color=color;
        this.nombre=nombre;
    }
    /**
     * Getter.
     * @return color
     */
    public char getColor(){
        return color;
    }
    /**
     * Método que define el movimiento por clase.
     * @param mov
     * @return si mov es válido o no.
     */
    public abstract boolean validoMovimiento(Movimiento mov);
    /**
     * Método que dibuja la pieza.
     * @return pieza en formato UNICODE
     */
    public abstract char pintarPieza();
    /**
     * Método que imprime la pieza en texto básico.
     * @return pieza en formato ASCII
     */
    @Override
    public String toString(){
        return nombre+""+color;
    }
}
