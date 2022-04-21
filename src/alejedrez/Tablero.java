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

/**
 * Clase Tablero. Crea un array bidimensional de tipo Pieza e imprime dicho
 * array.
 *
 * @author Alejandro Parra Jiménez
 */
public class Tablero {

    /**
     * Array bidimensional tablero, 8 filas, 8 columnas.
     */
    Pieza tablero[][] = new Pieza[8][8];

    /**
     * Constructor. Tablero con objetos tipo Pieza preestablecidos.
     */
    public Tablero() {
        //Creación de Torre
        tablero[0][0] = new Torre('n');
        tablero[0][7] = new Torre('n');
        tablero[7][0] = new Torre('b');
        tablero[7][7] = new Torre('b');
        //Creación de Caballo
        tablero[0][1] = new Caballo('n');
        tablero[0][6] = new Caballo('n');
        tablero[7][1] = new Caballo('b');
        tablero[7][6] = new Caballo('b');
        //Creación Alfil
        tablero[0][2] = new Alfil('n');
        tablero[0][5] = new Alfil('n');
        tablero[7][2] = new Alfil('b');
        tablero[7][5] = new Alfil('b');
        //Creación Dama
        tablero[0][3] = new Dama('n');
        tablero[7][3] = new Dama('b');
        //Creacion Rey
        tablero[0][4] = new Rey('n');
        tablero[7][4] = new Rey('b');
        //Creacion Peones
        for (int i = 0; i < tablero.length; i++) {
            tablero[1][i] = new Peon('n');
            tablero[6][i] = new Peon('b');
        }
    }

    /**
     * Imprime el array Pieza llamando al método pintarPieza() de cada objeto.
     */
    public void pintarTablero(int opcion) {
        if (opcion == 0) {
            System.out.printf("    %2c%2c%2c%2c%2c%2c%2c%2c\n", 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H');
            for (int i = 0; i < tablero.length; i++) {
                for (int j = -1; j < tablero.length; j++) {
                    if (j == -1) {
                        System.out.printf("%d   ", i + 1);
                    } else {
                        if (tablero[i][j] == null) {
                            System.out.printf("%2c", ' ');
                        } else {
                            System.out.printf("%2s", tablero[i][j].toString());
                        }
                    }
                }
                System.out.println("");
            }
        } else {
            System.out.println("    \u2004A\u2004B\u2004C\u2004D\u2004E\u2004F\u2004G\u2004H");
            for (int i = 0; i < tablero.length; i++) {
                for (int j = -1; j < tablero.length; j++) {
                    if (j == -1) {
                        System.out.printf("%d   ", i + 1);
                    } else {
                        if (tablero[i][j] == null) {
                            System.out.printf("%c", '\u2001');
                        } else {
                            System.out.printf("%c", tablero[i][j].pintarPieza());
                        }
                    }
                }
                System.out.println("");
            }
        }
    }

}
