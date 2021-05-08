/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcoes;

import javax.swing.text.*;

public class LimitNumberCharacters extends PlainDocument {

    private int iMaxLength;

    public LimitNumberCharacters(int maxlen) {
        super();
        iMaxLength = maxlen;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        //if (s == null) return;

        if (iMaxLength <= 0) { // aceitara qualquer no. de caracteres
            super.insertString(offset, str.toUpperCase(), attr);
            return;
        }

        int ilen = (getLength() + str.length());

        if (ilen <= iMaxLength) {
            super.insertString(offset, str.toUpperCase(), attr);   // ...aceita str
        }
    }

}
