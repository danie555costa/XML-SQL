/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st.jigasoft.xmlsql.view;

import java.awt.Color;
import java.awt.Component;
import st.jigasoft.dbutil.view.ItemDataSet;
import st.jigasoft.dbutil.view.ItemViewList;
import st.jigasoft.xmldb.model.Column;
import st.jigasoft.xmldb.model.Type;
import st.jigasoft.xmldb.model.TypeTreat;

/**
 *
 * @author xdata
 */
public class CollumnView extends javax.swing.JPanel implements ItemViewList{
    private boolean openDetais;
    private Column column;
    private boolean selected;
    
    private Color UNSELECTD = new Color(250, 251, 252);
    private Color SELECTED = new Color(0, 163, 255);
    private PanelTreater panelTreater;

    /**
     * Creates new form PanelTreater
     */
    public CollumnView() {
        initComponents();
        this.openDetais = false;
    }
    
    public void setPanelTreat(PanelTreater panelTreater)
    {
        this.panelTreater = panelTreater;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        columnName = new javax.swing.JLabel();
        columnType = new javax.swing.JLabel();
        selection = new javax.swing.JPanel();

        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        columnName.setText("Attribute Name");

        columnType.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        columnType.setText("Type");

        selection.setBackground(new java.awt.Color(0, 163, 255));

        javax.swing.GroupLayout selectionLayout = new javax.swing.GroupLayout(selection);
        selection.setLayout(selectionLayout);
        selectionLayout.setHorizontalGroup(
            selectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        selectionLayout.setVerticalGroup(
            selectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(selection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(columnName, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(columnType)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(columnName)
                    .addComponent(columnType))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(selection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel columnName;
    private javax.swing.JLabel columnType;
    private javax.swing.JPanel selection;
    // End of variables declaration//GEN-END:variables

    private void openCloseDetais() {
        this.openDetais = !this.openDetais;
    }
    
    
   
    @Override
    public void bind(ItemDataSet dataSet) {
        this.column = (Column) dataSet;
        this.columnName.setText(this.column.getDataBaseName());
        if(this.column.getType() != null)
            this.columnType.setText(this.column.getType().name());
        else
        {
            this.column.setType(this.panelTreater.getDefaultTreat());
        }
    }

    @Override
    public Component getComponent() {
        return this;
    }

    @Override
    public boolean isSelected() {
        return this.selected;
    }

    @Override
    public void setSelectd(boolean selected) {
        
        this.selected = selected;
        
        if(selected)
        {
            this.selection.setBackground(SELECTED);
            if(panelTreater != null)
                this.panelTreater.onTreatCollumn(this);
        }
        else{
            this.selection.setBackground(UNSELECTD);
        }
        
    }

    void dataBaseText(String text) {
        this.column.setDataBaseName(text);
    }

    void setType(TypeTreat type) {
        this.column.setType(type);
    }

    Type getType() {
        return this.column.getType();
    }

    String getOriginalName() {
        return this.column.getOriginalName();
    }

    String getDataBaseName() {
        return this.column.getDataBaseName();
    }
}
