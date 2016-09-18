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
public abstract class TypeTreat <O> implements Treater<O>, Type{

    private String name;

    public TypeTreat(String name) {
        this.name = name;
    }
    
    @Override
    public String name() {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean accept(String node, Object value) {
        return value != null
                && value instanceof String 
                && value.toString().length()>0;
    }
}
