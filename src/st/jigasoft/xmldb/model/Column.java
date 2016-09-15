/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st.jigasoft.xmldb.model;

import st.jigasoft.dbutil.view.ItemDataSet;

/**
 *
 * @author xdata
 */
public class Column implements ItemDataSet {
    
    private final String originalName;
    private String dataBaseName;
    private TypeTreat typeTreat;
    
    public Column(String originalName)
    {
        this.originalName = originalName;
        this.dataBaseName = originalName;
    }

    public Column(String originalName, String dataBaseName) {
        this.originalName = originalName;
        this.dataBaseName = dataBaseName;
    }
    
    
    
    public void setDataBaseName(String dataBaseName) {
        this.dataBaseName = dataBaseName;
    }

    @Override
    public String toString() {
        return dataBaseName;
    }

    public String getOriginalName() {
        return originalName;
    }

    public String getDataBaseName() {
        return dataBaseName;
    }

    public Type getType() {
        return this.typeTreat;
    }

    public void setType(TypeTreat type) {
        this.typeTreat = type;
    }
    
    
}
