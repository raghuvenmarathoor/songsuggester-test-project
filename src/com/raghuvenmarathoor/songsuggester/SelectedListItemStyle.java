/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raghuvenmarathoor.songsuggester;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 *
 * @author New User
 */
public class SelectedListItemStyle extends DefaultListCellRenderer{
    int cellIndex = 0;
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component comp = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if(index == PlayerFrame.playlistPointer ){
            Color myColor = new Color(240,216,230);
            comp.setBackground(myColor);
            Font font = new Font(comp.getFont().getName(),Font.BOLD,comp.getFont().getSize()+2);
           
            comp.setFont(font);
            comp.setForeground(Color.BLACK);
            
            
        }
        return comp;
    }
   
    
}