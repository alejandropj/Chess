package alejedrez;

/**
 * Clase Caballo, herencia de Pieza.
 * @author parjimal
 */
public class Caballo extends Pieza{
    /**
     * Constructor que llama al padre.
     * @param color 
     */
    public Caballo(char color){
        super(color,'C');
    }
    /**
     * Método que define el movimiento por clase.
     * @param mov
     * @return si mov es válido o no.
    */
    @Override
    public boolean validoMovimiento(Movimiento mov){
        boolean bool=false;
        if (((Math.abs(mov.saltoHorizontal())==2) && (Math.abs(mov.saltoVertical())==1)) || ((Math.abs(mov.saltoVertical())==2) && Math.abs(mov.saltoHorizontal())==1)){
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
            pieza='\u2658';
        }else{
            pieza='\u265E';
        }
        return pieza;
    }
}
