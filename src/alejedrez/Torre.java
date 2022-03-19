package alejedrez;

/**
 * Clase Torre, herencia de Pieza.
 * @author ale
 */
public class Torre extends Pieza {
    /**
     * Constructor que llama al padre.
     * @param color 
     */
    public Torre(char color){
        super(color,'T');
    }
    /**
     * Método que define el movimiento por clase.
     * @param mov
     * @return si mov es válido o no.
    */
    @Override
    public boolean validoMovimiento(Movimiento mov){
        boolean bool=false;
        if (mov.esVertical() || mov.esHorizontal() ){
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
            pieza='\u2656';
        }else{
            pieza='\u265C';
        }
        return pieza;
    }

}
