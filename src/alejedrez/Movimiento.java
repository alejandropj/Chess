
package alejedrez;

/**
 * Clase Movimiento. Calcula un movimiento a partir de una Posición. Dependencia a Posición.
 * @author ale
 */
public class Movimiento {
    protected Posicion posInicial;
    protected Posicion posFinal;
    
    /**
     * Constructor vacío.
     */
    public Movimiento(){

    }
    /**
     * Constructor.
     * @param posInicial
     * @param posFinal 
     */
    public Movimiento(Posicion posInicial, Posicion posFinal){
        this.posInicial=posInicial;
        this.posFinal=posFinal;
    }
    /**
     * Devuelve si ha habido un cambio en fila.
     * @return boolean(bool)
     */
    public boolean esVertical(){
        boolean bool=false;
        if(posInicial.fila!=posFinal.fila){
            bool=true;
        }
        return bool;
    }
    /**
     * Devuelve si ha habido un cambio en columna.
     * @return boolean(bool)
     */
    public boolean esHorizontal(){
        boolean bool=false;
        if(posInicial.columna!=posFinal.columna){
            bool=true;
        }
        return bool;
    }
    
    /**
     * Devuelve el salto horizontal y su signo.
     * @return int(num)
     */
    public int saltoHorizontal(){
        int num=0;
        num=posInicial.columna - posFinal.columna;
        return num;
    }
    /**
     * Devuelve el salto vertical y su signo.
     * @return int(num)
     */
    public int saltoVertical(){
        int num=0;
        num=posInicial.fila - posFinal.fila;
        return num;
    }
    
    /**
     * Devuelve si valor absoluto del salto vertical y horizontal son iguales.
     * @return boolean(bool)
     */
    public boolean esDiagonal(){
        boolean bool=false;
        if(Math.abs(saltoHorizontal()) == Math.abs(saltoVertical())){
            bool=true;
        }
        return bool;
    }
    
}
