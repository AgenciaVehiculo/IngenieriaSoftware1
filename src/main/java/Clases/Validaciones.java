/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Kur013
 */
public class Validaciones {
    
    
    public boolean validacionTresLetras(String aux){
         Pattern pat = Pattern.compile("(?i)(.*aaa.*|.*bbb.*|.*ccc.*|.*ddd.*|.*eee.*|.*fff.*|.*ggg.*|.*hhh.*|.*iii.*|.*jjj.*|.*kkk.*|.*lll.*|.*mmm.*|.*nnn.*|.*ooo.*|.*ppp.*|.*qqq.*|.*rrr.*|.*sss.*|.*ttt.*|.*uuu.*|.*vvv.*|.*www.*|.*xxx.*|.*yyy.*|.*zzz.*)");
            Matcher mat = pat.matcher(aux);
            
            if(mat.matches()){
                //JOptionPane.showMessageDialog(null, "Por favor, ingrese la marca valida","Error",JOptionPane.ERROR_MESSAGE);
                return true;   
            }
            else{
               return false; 
            }
    }
    
    public static boolean validacionDecimales(String texto){
        Pattern pat = Pattern.compile("^\\d*\\.?\\d*$");
        Matcher mat = pat.matcher(texto);
       
        if(mat.matches()){
            return true;
        }
        else{
            return false;
        }
       
    }
    
    
    
}
