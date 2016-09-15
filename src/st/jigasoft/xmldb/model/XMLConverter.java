/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st.jigasoft.xmldb.model;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xdata
 */
public class XMLConverter implements Converter{
    
   
    private OnProcess onProcess;
    
    public XMLConverter ()
    {
    }
    
    public void setOnProcess(OnProcess onProcess)
    {
        this.onProcess = onProcess;
    }
   
    
    
    

    @Override
    public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext mc)
    {
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext uc) {
        SQLRow lLine =  new SQLRow();
        Object value;
        String field;
        
        while(reader.hasMoreChildren())
        {
            reader.moveDown();
            value = reader.getValue();
            field = reader.getNodeName();
            reader.moveUp();      
            lLine.put(field, value);
        }
        if(this.onProcess != null) this.onProcess.accept(lLine);
        
        return lLine;
    }

    @Override
    public boolean canConvert(Class type) 
    {
        return SQLRow.class.isAssignableFrom(type);
    }
}
