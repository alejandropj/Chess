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
 * Clase Dama, herencia de Pieza.
 * @author Alejandro Parra Jiménez
 */
public class Dama extends Pieza {
    /**
     * Constructor que llama al padre
     * @param color 
     */
    public Dama(char color){
        super(color,'D');
    }
    /**
     * Método que define el movimiento por clase.
     * @param mov
     * @return si mov es válido o no.
    */
    @Override
    public boolean validoMovimiento(Movimiento mov){
        boolean bool=false;
        if (mov.esVertical() || mov.esHorizontal() || mov.esDiagonal()){
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
            pieza='\u2655';
        }else{
            pieza='\u265B';
        }
        return pieza;
    }
}
