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
 * Clase Posicion. Determina una fila y columna.
 * @author Alejandro Parra Jiménez
 */
public class Posicion {

    protected int fila;
    protected int columna;

    /**
     * Constructor vacío.
     */
    public Posicion() {

    }

    /**
     * Constructor.
     *
     * @param fila
     * @param columna
     */
    public Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    /**
     * Setter. Establece el atributo fila
     *
     * @param fila
     */
    public void setFila(int fila) {
        this.fila = fila;
    }

    /**
     * Setter. Establece el atributo columna
     *
     * @param columna
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }

    /**
     * Getter.
     *
     * @return fila
     */
    public int getFila() {
        return fila;
    }

    /**
     * Getter.
     *
     * @return columna
     */
    public int getColumna() {
        return columna;
    }

    /**
     * @return Devuelve una posición en un plano bidimensional
     *
     */
    @Override
    public String toString() {
        return "Posicion{" + "fila=" + fila + ", columna=" + columna + '}';
    }

}
