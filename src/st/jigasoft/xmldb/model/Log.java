/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st.jigasoft.xmldb.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author xdata
 */
public class Log extends PrintStream{
    private OnPrint onPrint;
   
    public Log(OutputStream out) {
        super(out);
    }

    public Log(OutputStream out, boolean autoFlush) {
        super(out, autoFlush);
    }

    public Log(OutputStream out, boolean autoFlush, String encoding) throws UnsupportedEncodingException {
        super(out, autoFlush, encoding);
    }

    public Log(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    public Log(String fileName, String csn) throws FileNotFoundException, UnsupportedEncodingException {
        super(fileName, csn);
    }

    public Log(File file) throws FileNotFoundException {
        super(file);
    }

    public Log(File file, String csn) throws FileNotFoundException, UnsupportedEncodingException {
        super(file, csn);
    }
    
    public void setOnPrint(OnPrint onPrint)
    {
        this.onPrint = onPrint;
    }

    @Override
    public void println(Object x) {
        this.onPrint.acceptln(x);
//        super.println(x); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void println(String x) {
        this.onPrint.acceptln(x);
//        super.println(x); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void println(char[] x) {
        this.onPrint.acceptln(x);
//        super.println(x); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void println(double x) {
        this.onPrint.acceptln(x);
        super.println(x); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void println(float x) {
        this.onPrint.acceptln(x);
//        super.println(x); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void println(long x) {
        this.onPrint.acceptln(x);
//        super.println(x); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void println(int x) {
        this.onPrint.acceptln(x);
//        super.println(x); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void println(char x) {
        this.onPrint.accept(x);
//        super.println(x); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void println(boolean x) {
        this.onPrint.acceptln(x);
//        super.println(x); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void println() {
        this.onPrint.acceptln();
//        super.println(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void print(Object obj) {
        this.onPrint.accept(obj);
//        super.print(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void print(String s) {
        this.onPrint.accept(s);
//        super.print(s); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void print(char[] s) {
        this.onPrint.accept(s);
//        super.print(s); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void print(double d) {
        this.onPrint.accept(d);
//        super.print(d); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void print(float f) {
        this.onPrint.accept(f);
//        super.print(f); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void print(long l) {
        this.onPrint.accept(l);
//        super.print(l); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void print(int i) {
        this.onPrint.accept(i);
//        super.print(i); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void print(char c) {
        this.onPrint.accept(c);
//        super.print(c); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void print(boolean b) {
        this.onPrint.accept(b);
//        super.print(b); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
