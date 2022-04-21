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
 * Clase Movimiento. Calcula un movimiento a partir de una Posición. Dependencia a Posición.
 * @author Alejandro Parra Jiménez
 */
public class Movimiento {
    protected Posicion posInicial;
    protected Posicion posFinal;
    
    /**
     * Constructor vacío.
     */
    public Movimiento(){

    }
    /**
     * Constructor.
     * @param posInicial
     * @param posFinal 
     */
    public Movimiento(Posicion posInicial, Posicion posFinal){
        this.posInicial=posInicial;
        this.posFinal=posFinal;
    }
    /**
     * Devuelve si ha habido un cambio en fila.
     * @return boolean(bool)
     */
    public boolean esVertical(){
        boolean bool=false;
        if(posInicial.fila!=posFinal.fila){
            bool=true;
        }
        return bool;
    }
    /**
     * Devuelve si ha habido un cambio en columna.
     * @return boolean(bool)
     */
    public boolean esHorizontal(){
        boolean bool=false;
        if(posInicial.columna!=posFinal.columna){
            bool=true;
        }
        return bool;
    }
    
    /**
     * Devuelve el salto horizontal y su signo.
     * @return int(num)
     */
    public int saltoHorizontal(){
        int num=0;
        num=posInicial.columna - posFinal.columna;
        return num;
    }
    /**
     * Devuelve el salto vertical y su signo.
     * @return int(num)
     */
    public int saltoVertical(){
        int num=0;
        num=posInicial.fila - posFinal.fila;
        return num;
    }
    
    /**
     * Devuelve si valor absoluto del salto vertical y horizontal son iguales.
     * @return boolean(bool)
     */
    public boolean esDiagonal(){
        boolean bool=false;
        if(Math.abs(saltoHorizontal()) == Math.abs(saltoVertical())){
            bool=true;
        }
        return bool;
    }
    
}
