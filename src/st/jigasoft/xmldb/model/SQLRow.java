/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st.jigasoft.xmldb.model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import st.jigasoft.dbutil.util.models.ItemTableModel;

/**
 *
 * @author xdata
 */
public class SQLRow implements ItemTableModel
{
    private Map<String, Object> mapValues;
    private boolean visible;
   
    public SQLRow ()
    {
        this.mapValues = new LinkedHashMap<>();
    }

    void put(String field, Object value) {
        this.mapValues.put(field, value);
    }
    
    public Object get(String key)
    {
        return this.mapValues.get(key);
    }

    @Override
    public String toString() {
        return "SQLLine{" + "values=" + mapValues + '}';
    }
    
    public Set<String> getCollumns()
    {
        return Collections.unmodifiableSet(this.mapValues.keySet());
    }

    @Override
    public Object[] values() {
        Object values [] = new Object[this.mapValues.size()];
        int iCount = 0;
        for(String key: this.getCollumns())
            values[iCount++] = this.mapValues.get(key);
        return values;
    }


    @Override
    public Object key() {
        return this;
    }

    @Override
    public boolean isVisible() {
        return this.visible;
    }

    @Override
    public void setVisible(boolean visiblie) {
        this.visible = visiblie;
    }

    @Override
    public void valueSetAt(Object value, String column, int columnIndex) {
        this.mapValues.replace(column, value);
    }

    void replace(String columnKey, Object object) {
        this.mapValues.replace(columnKey, object);
    }

    public int getColumnsCount() {
        return this.mapValues.size();
    }
    
}
