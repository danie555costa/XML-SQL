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
public class TreaterInteger extends TypeTreat<Number>{

    public TreaterInteger(String name) {
        super(name);
    }
    
    @Override
    public Number treater(Object imputValue) {
        return Integer.valueOf(imputValue.toString());
    }

    @Override
    public boolean accept(String node, Object value) {
        return value != null 
                && value instanceof String
                && value.toString().length()>0;
    }

}
