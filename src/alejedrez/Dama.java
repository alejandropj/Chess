package alejedrez;

/**
 * Clase Dama, herencia de Pieza.
 * @author parjimal
 */
public class Dama extends Pieza {
    /**
     * Constructor que llama al padre
     * @param color 
     */
    public Dama(char color){
        super(color,'D');
    }
    /**
     * Método que define el movimiento por clase.
     * @param mov
     * @return si mov es válido o no.
    */
    @Override
    public boolean validoMovimiento(Movimiento mov){
        boolean bool=false;
        if (mov.esVertical() || mov.esHorizontal() || mov.esDiagonal()){
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
            pieza='\u2655';
        }else{
            pieza='\u265B';
        }
        return pieza;
    }
}
