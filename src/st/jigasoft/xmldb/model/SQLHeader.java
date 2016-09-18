/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st.jigasoft.xmldb.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author xdata
 */
public class SQLHeader {
    private String tableName;
    private Map<String, Column> mapCollumns;
    private String inserSql;
    private List<Treater> listTreaterValues;
    private String docTagTable;
    
    
    public  SQLHeader()
    {
        this.mapCollumns = new LinkedHashMap<>();
        this.listTreaterValues = new ArrayList<>();
    }
    
    public void newDocument(String docTagTable)
    {
        this.docTagTable = docTagTable;
        this.tableName = docTagTable;
        this.mapCollumns.clear();
    }
    
    public void replaceTableName(String tableName)
    {
        this.tableName = tableName;
    }
    
    public void addTreaterValue(Treater treater)
    {
        this.listTreaterValues.add(treater);
    }
    
    public void accept(SQLRow lLine)
    {
        this.mapCollumns.clear();
        lLine.getCollumns().stream().forEach((coll) -> {
            mapCollumns.put(coll, new Column(coll));
        });
    }
    
    public Collection<Column> getColumns()
    {
        return Collections.unmodifiableCollection(mapCollumns.values());
    }
    
    public void generateInsertSQL()
    {
        this.inserSql = "INSERT INTO "+this.tableName+ "(";
        String interogations= "";
        Set<String> list = this.mapCollumns.keySet();
        
        int count = 0;
        for(String coll: list)
        {
            this.inserSql += this.mapCollumns.get(coll).getDataBaseName();
            interogations += '?';
            if(count+1 < list.size())
            {
                this.inserSql += ", ";
                interogations += ", ";
            }
            count ++;
        }
        
        this.inserSql += ") VALUES ("+interogations+")";
    }
    
    public String getSql()
    {
        return this.inserSql;
    }
    
    
    @Override
    public String toString() {
        return "SQLHeader{" + "tableName=" + tableName + ", mapCollumns=" + mapCollumns + '}';
    }

    public Object[] prepare(SQLRow sqll)  {
        return this.treat(sqll);
    }

    public String [] columnAsTable() {
        String [] collumn = new String[this.mapCollumns.size()];
        int iCount = 0;
        for(Column c: this.getColumns())
            collumn[iCount++] = c.getOriginalName();
        return collumn;
    }

    public Object [] treat(SQLRow sqll) {
        Object[] rowObj = new Object[this.mapCollumns.size()];
        Object object;
        int iCount =0;
        for(String columnKey: this.mapCollumns.keySet())
        {
            
            Column column = this.mapCollumns.get(columnKey);
            TypeTreat treater = (TypeTreat) column.getType();
            
            object = sqll.get(columnKey);
            
            for(Treater t: this.listTreaterValues)
            {
                if(t.accept(columnKey, object))
                    object = t.treater(object);
            }
            
            if(treater.accept(columnKey, object))
                object = treater.treater(object);
            
            rowObj[iCount ++] = object;
        }
        return  rowObj;
    }
}
