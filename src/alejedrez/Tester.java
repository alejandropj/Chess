package alejedrez;

import java.util.Scanner;

/**
 * Clase Tester, llama al resto de clases para ejecutar el programa.
 * @author ale
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // OBJETOS NECESARIOS EN MAIN
        Tablero tablero = new Tablero();
        Juego juego = new Juego();
        Scanner teclado = new Scanner (System.in);
        int conteo = 1;
        int opcion=3;
        
        do{
            System.out.println("Introduce la versión que desee jugar(Letras-0, Visual-1):");
            opcion=teclado.nextInt();
        }while(!(opcion==0 || opcion==1));
        

        // EJECUCCIÓN
        do{
            tablero.pintarTablero(opcion);
            System.out.println("");
            //TURNO
            if (juego.elTurno) {
                System.out.print(conteo+". Turno de blancas. ");
            } else {
                System.out.print(conteo+". Turno de negras. ");
            }
            //MOVIMIENTO
            Movimiento mov = juego.jugada(tablero);
            juego.alterarPieza(tablero, mov);
            
            if (juego.isTurno()) {
                juego.setTurno(false);
            }else {
                juego.setTurno(true);
                conteo++;
        }
        }while(juego.jaqueMate(tablero)==false);
           
        System.out.println("Fin de juego.");
        
    }
    
}