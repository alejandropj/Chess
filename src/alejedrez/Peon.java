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
 * Clase Peon, herencia de Pieza.
 * @author Alejandro Parra Jiménez
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
