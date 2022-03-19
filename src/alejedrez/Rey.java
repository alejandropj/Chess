package alejedrez;

/**
 * Clase Rey, herencia de Pieza.
 * @author parjimal
 */
public class Rey extends Pieza{
    /**
     * Constructor que llama al padre.
     * @param color 
     */
    public Rey(char color){
        super(color,'R');
    }
    /**
     * Método que define el movimiento por clase.
     * @param mov
     * @return si mov es válido o no.
    */
    @Override
    public boolean validoMovimiento(Movimiento mov){
        boolean bool=false;
        if ((Math.abs(mov.saltoHorizontal()) ==1 || Math.abs(mov.saltoVertical()) ==1) && (mov.esVertical() ||  mov.esHorizontal() || mov.esDiagonal() )){
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
            pieza='\u2654';
        }else{
            pieza='\u265A';
        }
        return pieza;
    }
}
