package alejedrez;

import java.util.Scanner;

/**
 * Clase Juego. Contiene métodos que controlan la lógica del proyecto. Usa principalmente a Tablero y Movimiento.
 * @author parjimal
 */
public class Juego {
    protected boolean elTurno;
    /**
     * Constructor. Establece elTurno en TRUE
     */
    public Juego(){
        elTurno=true;
    }
    /**
     * Devuelve el turno, siendo TRUE de blancas, y FALSE de negras.
     * @return 
     */
    public boolean isTurno() {
        return elTurno;
    }

    /**
     * Establece el turno.
     * @param elTurno 
     */
    public void setTurno(boolean elTurno){
        this.elTurno=elTurno;
    }
    
    
    /**
     * Método que maneja y crea las clases Movimiento y Posición.<br>
     * Se encarga de la correcta ejecución del ajedrez(control de errores y movimientos),<br>
     * invocando a los métodos traduccionJugada(), lecturaJugada()<br> 
     * y controlErrores(Tablero,Movimiento)
     * @param tablero
     * @return Movimiento(mov)
     */
    public Movimiento jugada(Tablero tablero){ //control de errores
        boolean interruptor = true;
        Movimiento mov = new Movimiento();
        do{
            int arr[] = traduccionJugada();        
            Posicion posIn = new Posicion(arr[1],arr[0]);
            Posicion posFin = new Posicion(arr[3],arr[2]);
            mov.posInicial=posIn;
            mov.posFinal=posFin;
            interruptor= controlErrores(tablero,mov);
        }while(interruptor==false);
        return mov;
    }
    /**
     * Método que se encarga de mover y eliminar piezas sobre tablero
     * @param tablero
     * @param mov
     * @return Tablero alterado
     */
    public Tablero alterarPieza(Tablero tablero,Movimiento mov){
        if(tablero.tablero[mov.posFinal.fila][mov.posFinal.columna] == null){
                tablero.tablero[mov.posFinal.fila][mov.posFinal.columna] = tablero.tablero[mov.posInicial.fila][mov.posInicial.columna];
                tablero.tablero[mov.posInicial.fila][mov.posInicial.columna]=null;
        }
        else{
                tablero.tablero[mov.posFinal.fila][mov.posFinal.columna] = tablero.tablero[mov.posInicial.fila][mov.posInicial.columna];
                tablero.tablero[mov.posInicial.fila][mov.posInicial.columna]=null;
        }
        return tablero;
    }
    /**
     * Método que analiza el valor ponderado de las piezas de cada color.
     * @param tablero
     * @return continuación o fin de fuego.
     */
    public boolean jaqueMate(Tablero tablero){
        boolean end=false;
        int ponderadoBlancas=0, ponderadoNegras=0;
        for (int i = 0; i < tablero.tablero.length; i++) {
            for (int j = 0; j < tablero.tablero.length; j++) {
                if(tablero.tablero[i][j] != null && tablero.tablero[i][j].color=='b' && !tablero.tablero[i][j].getClass().getSimpleName().equalsIgnoreCase("Rey")){
                    switch (tablero.tablero[i][j].getClass().getSimpleName().toLowerCase()){
                        case "peon":
                            ponderadoBlancas=ponderadoBlancas+1;
                            break;
                        case "caballo":
                            ponderadoBlancas=ponderadoBlancas+3;
                            break;
                        case "alfil":
                            ponderadoBlancas=ponderadoBlancas+3;
                            break;
                        case "torre":
                            ponderadoBlancas=ponderadoBlancas+5;
                            break;
                        case "dama":
                            ponderadoBlancas=ponderadoBlancas+9;
                            break;
                    }
                }
                else if(tablero.tablero[i][j] != null && tablero.tablero[i][j].color=='n' && !tablero.tablero[i][j].getClass().getSimpleName().equalsIgnoreCase("Rey")){
                    switch (tablero.tablero[i][j].getClass().getSimpleName().toLowerCase()){
                        case "peon":
                            ponderadoNegras=ponderadoNegras+1;
                            break;
                        case "caballo":
                            ponderadoNegras=ponderadoNegras+3;
                            break;
                        case "alfil":
                            ponderadoNegras=ponderadoNegras+3;
                            break;
                        case "torre":
                            ponderadoNegras=ponderadoNegras+5;
                            break;
                        case "dama":
                            ponderadoNegras=ponderadoNegras+9;
                            break;
                    }
                }
            }
        
        }
        if(ponderadoBlancas<=20){
            end=true;
        } else if(ponderadoNegras<=20){
            end=true;
        }
        return end;
    }
    /**
     * Método que, dado un movimiento, recorre el array tablero<br>
     * analizando si existe una pieza desde posInicial+1 hasta posFinal-1.<br>
     * Hace una excepción para clase Caballo y se basa en los 3 tipos<br>
     * de movimientos.
     * @param tablero
     * @param mov
     * @return si existe una pieza o no.
     */
    public boolean hayPiezasEntre(Tablero tablero, Movimiento mov){
        boolean interruptor=false;
        
        if(tablero.tablero[mov.posInicial.fila][mov.posInicial.columna].getClass().getSimpleName().equalsIgnoreCase("Caballo")){
            interruptor=false;
        }
        //VERTICAL
        else if(mov.esVertical() && !mov.esHorizontal() ){
                if(mov.saltoVertical()>0){ //salto positivo
                    interruptor = false;
                    for (int i = mov.posInicial.fila+1; i < mov.posFinal.fila && interruptor==false; i++) {
                        if(tablero.tablero[i][mov.posInicial.columna]!=null){
                            interruptor=true;
                        }
                    }
                }
                else{ //salto negativo
                    interruptor = false;
                    for (int i = mov.posInicial.fila-1; i > mov.posFinal.fila && interruptor==false; i--) {
                        if(tablero.tablero[i][mov.posInicial.columna]!=null){
                            interruptor=true;
                        }
                    }
                }
            //HORIZONTAL
            }else if(mov.esHorizontal() && !mov.esVertical()){
                if(mov.saltoHorizontal()>0){ //salto positivo
                    interruptor = false;
                    for (int i = mov.posInicial.columna+1; i < mov.posFinal.columna && interruptor==false; i++) {
                        if(tablero.tablero[mov.posInicial.fila][i]!=null){
                            interruptor=true;
                        }
                    }
                }
                else{ //salto negativo
                    interruptor = false;
                    for (int i = mov.posInicial.columna-1; i > mov.posFinal.columna && interruptor==false; i--) {
                        if(tablero.tablero[mov.posInicial.fila][i]!=null){
                            interruptor=true;
                        }
                    }
                }
            //DIAGONAL
            }else if(mov.esVertical() ){
                if(mov.saltoVertical()>0 && mov.saltoHorizontal()>0){ //ver+ hor+
                    interruptor = false;
                    int i = mov.posInicial.fila+1;
                    int j = mov.posInicial.columna+1;
                    while(i<mov.posFinal.fila && interruptor==false){
                        if(tablero.tablero[i][j]!=null){
                            interruptor=true;
                        }
                        i++;
                        j++;
                    }
                }else if(mov.saltoVertical()>0 && mov.saltoHorizontal()<0){ //ver+ hor-
                    interruptor = false;
                    int i = mov.posInicial.fila+1;
                    int j = mov.posInicial.columna-1;
                    while(i<mov.posFinal.fila && interruptor==false){
                        if(tablero.tablero[i][j]!=null){
                            interruptor=true;
                        }
                        i++;
                        j--;
                    }
                }else if(mov.saltoVertical()<0 && mov.saltoHorizontal()>0){ //ver- hor+
                    interruptor = false;
                    int i = mov.posInicial.fila-1;
                    int j = mov.posInicial.columna+1;
                    while(i>mov.posFinal.fila && interruptor==false){
                        if(tablero.tablero[i][j]!=null){
                            interruptor=true;
                        }
                        i--;
                        j++;
                    }
                }else if(mov.saltoVertical()<0 && mov.saltoHorizontal()<0){ //ver- hor-
                    interruptor = false;
                    int i = mov.posInicial.fila-1;
                    int j = mov.posInicial.columna-1;
                    while(i>mov.posFinal.fila && interruptor==false){
                        if(tablero.tablero[i][j]!=null){
                            interruptor=true;
                        }
                        i--;
                        j--;
                    }
                }
            }
        if(interruptor==true){ //que haya una pieza en medio
            System.out.println("Error. Existe una pieza en medio.");
            interruptor=false;
        }
        else{
            interruptor=true;
        }
        return interruptor;
    }
    /**
     * Método que analiza el movimiento, la pieza y su color,<br>
     * aplicando las reglas del Ajedrez. Invoca al método hayPiezasEntre(Tablero,Movimiento)
     * @param tablero
     * @param mov
     * @return si existe algún error con el movimiento o no.
     */
    public boolean controlErrores(Tablero tablero, Movimiento mov){
        boolean interruptor=false;
        if (tablero.tablero[mov.posInicial.fila][mov.posInicial.columna] == null) {
            System.out.println("Error, no existe pieza en la posición indicada");
        } else if ((tablero.tablero[mov.posInicial.fila][mov.posInicial.columna].getColor() == 'n' && elTurno) || (tablero.tablero[mov.posInicial.fila][mov.posInicial.columna].getColor() == 'b' && elTurno == false)) {
            System.out.println("Error, mueve una pieza de tu color");
        } else if (tablero.tablero[mov.posFinal.fila][mov.posFinal.columna] != null && tablero.tablero[mov.posInicial.fila][mov.posInicial.columna].getColor() == tablero.tablero[mov.posFinal.fila][mov.posFinal.columna].getColor()) {
            System.out.println("Error, no puedes tener 2 piezas tuyas en una misma casilla");
        } else if(tablero.tablero[mov.posFinal.fila][mov.posFinal.columna] != null && tablero.tablero[mov.posFinal.fila][mov.posFinal.columna].getClass().getSimpleName().equalsIgnoreCase("Rey")){
            System.out.println("Error, no puedes comerte al Rey.");
        } else if(tablero.tablero[mov.posInicial.fila][mov.posInicial.columna].getClass().getSimpleName().equalsIgnoreCase("Peon") && tablero.tablero[mov.posFinal.fila][mov.posFinal.columna]!=null){
            if(tablero.tablero[mov.posInicial.fila][mov.posInicial.columna].getColor()=='n' && mov.esDiagonal() && mov.saltoVertical()==-1){
                interruptor=true;
            }else if(tablero.tablero[mov.posInicial.fila][mov.posInicial.columna].getColor()=='b' && mov.esDiagonal() && mov.saltoVertical()==1){
                interruptor=true;
            }
        } 
        else if(tablero.tablero[mov.posInicial.fila][mov.posInicial.columna].validoMovimiento(mov)==false){
            System.out.println("Error, la pieza no puede hacer ese movimiento");
        }  else{
            interruptor=hayPiezasEntre(tablero,mov);
        }
        return interruptor;
    }
    
       /**
     * Método que lee la jugada en String y realiza
     * un control de entrada de la longitud. <br><br>
     * @return jugada en String
     */
    public String lecturaJugada(){
        Scanner sc = new Scanner (System.in);
        String jugada = new String();
        
        //Control de entrada que nos cuenta la longitud.
        do{
        System.out.println("Introduce jugada(ejemplo A2A3): ");
        jugada = sc.nextLine();
        }while(jugada.length() != 4);
        return jugada.toUpperCase();
    }
    /**
     * Crea char letras[], que contendrá cada dígito del método lecturaJugada(), <br>
     * e int posiciones[] de 4 posiciones, que transformará de letras[] en valores del 0-7.
     * <br>Además de un control de las posiciones, se repetirá si los valores sobrepasan el rango del 0-7.
     * @return Array de 4 posiciones, de valores 0 al 7.
     */
    public int[] traduccionJugada(){
        int posiciones []= new int[4];
        boolean interruptor=false;
        //Control de los valores de posiciones, que estén del 0-7
        do{
            char letras[]= lecturaJugada().toCharArray();
            interruptor=false;
            for (int i = 0; i < letras.length && interruptor==false; i++) {
            interruptor=false;
            if((int)letras[i]>=65 && (int)letras[i]<=72){//letras(columnas)
                posiciones[i] = (int) (letras[i]-65);
            }
            else if((int)letras[i]>=49 && (int)letras[i]<=56){//numeros(filas)
                posiciones[i] = (int) (letras[i]-49);
            }
            else{//control de entrada
                interruptor=true;
                System.out.println("Error. Introduce un movimiento correcto.");
            }
        }
        }while(interruptor==true);
        return posiciones;
    }
    
}
