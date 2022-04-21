/*
 * Copyright (c) 2022, Alejandro Parra Jiménez
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package alejedrez;

import java.util.Scanner;

/**
 * Clase Tester, llama al resto de clases para ejecutar el programa.
 * @author Alejandro Parra Jiménez
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