package alejedrez;

/**
 * Clase Alfil, herencia de Pieza.
 * @author parjimal
 */
public class Alfil extends Pieza {
    /**
     * Constructor que llama al padre.
     * @param color 
     */
    public Alfil(char color){
        super(color,'A');
    }
    /**
     * Método que define el movimiento por clase.
     * @param mov
     * @return si mov es válido o no.
    */
    @Override
    public boolean validoMovimiento(Movimiento mov){
        boolean bool=false;
        if (mov.esDiagonal()){
            bool=true;
        }
        return bool;
    }
    /**
     * Método que dibuja la pieza.
     * @return pieza en formato UNICODE
     */
    @Override
    public char pintarPieza(){
        char pieza;
        if(color=='b'){
            pieza='\u2657';
        }else{
            pieza='\u265D';
        }
        return pieza;
    }
}
