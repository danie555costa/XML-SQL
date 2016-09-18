/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st.jigasoft.xmldb.model;

/**
 *
 * @author xdata
 */
public class TreaterNull implements Treater<Object> {

    @Override
    public Object treater(Object imputValue) {
        return null;
    }

    @Override
    public boolean accept(String node, Object value) {
        return value == null
                ||(value instanceof String 
                     && value.toString().length() == 0);
    }
    
}
