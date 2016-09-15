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
public class TreatText extends TypeTreat<String>{

    public TreatText()
    {
        super("TEXT");
    }
    
    public TreatText(String name) {
        super(name);
    }

    @Override
    public String treater(Object imputValue) {
        return imputValue.toString();
    }

    @Override
    public boolean accept(String node, Object value) {
        return value != null
                && value instanceof String;
    }
    
}
