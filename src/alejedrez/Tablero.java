package alejedrez;

/**
 * Clase Tablero. Crea un array bidimensional de tipo Pieza e imprime dicho
 * array.
 *
 * @author ale
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
