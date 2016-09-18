/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st.jigasoft.xmldb.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xdata
 */
public final class TreaterDate extends TypeTreat<Date>{

    private String formatter;
    private SimpleDateFormat dataFormat;
    
    
    public TreaterDate()
    {
        this("DATE");
    }
    
    public  TreaterDate (String name)
    {
        this(name, "yyyyMMdd");
    }
    
    public TreaterDate(String name, String formatter)
    {
        super(name);
        this.setFormatter(formatter);
    }
    
    public void setFormatter(String formatter)
    {
        this.formatter = formatter;
        this.dataFormat = new SimpleDateFormat(formatter);
    }

    public String getFormatter() {
        return formatter;
    }
    
    
    @Override
    public Date treater(Object imputValue) {
        try 
        {
            return this.dataFormat.parse(imputValue.toString());
        } catch (ParseException ex) {
            Logger.getLogger(TreaterDate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean accept(String node, Object value) 
    {
        System.out.println("Testing date node: "+node+" value: "+value);
        return value != null 
                && value instanceof String
                && value.toString().length()>0;
    }
}
