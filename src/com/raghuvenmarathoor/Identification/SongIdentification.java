/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raghuvenmarathoor.Identification;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author New User
 */
public class SongIdentification {
    public SongIdentification(File songFile){
        try {  
            CheckCRC crcOfFile = new CheckCRC(songFile);
            long current = crcOfFile.getCRC();
            JOptionPane.showMessageDialog(null, current);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    
}
