package alejedrez;

/**
 * Clase Peon, herencia de Pieza.
 * @author parjimal
 */
public class Peon extends Pieza{
    protected int conteoMov;
    /**
     * Constructor que llama al padre.
     * @param color 
     */
    public Peon(char color){
        super(color,'P');
        conteoMov=0;
    }
    /**
     * Método que define el movimiento por clase. Además, lleva la cuenta del movimiento inicial<br>
     * de esta manera, el peón puede moverse 2 posiciones como su primer movimiento, pero nunca más después.
     * @param mov
     * @return si mov es válido o no.
    */
    @Override
    public boolean validoMovimiento(Movimiento mov){
        boolean bool=false;
        if(color=='b'){ //blancas
            if(mov.esVertical() && !mov.esHorizontal() && mov.saltoVertical() == 2){
                if(conteoMov==0){
                    conteoMov++;
                    bool=true;
                }
                else{
                    bool=false;
                }
            }else if(mov.esVertical() && !mov.esHorizontal() && mov.saltoVertical()==1){
                    conteoMov++;
                    bool=true;
            }else{
                bool=false;
            }
        }
        else{ //negras
            if(mov.esVertical() && mov.saltoVertical() == -2){
                if(conteoMov==0){
                    conteoMov++;
                    bool=true;
                }
                else{
                    bool=false;
                }
            }else if(mov.esVertical() && mov.saltoVertical()== -1){
                    conteoMov++;
                    bool=true;
            }else{
                bool=false;
            }
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
            pieza='\u2659';
        }else{
            pieza='\u265F';
        }
        return pieza;
    }
}
