/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raghuvenmarathoor.Identification;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.CRC32;

/**
 *
 * @author New User
 */
public class CheckCRC {
    CRC32 crcCode = null;
    public CheckCRC(File songFile) throws FileNotFoundException, IOException{
        
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        FileInputStream fis = new FileInputStream(songFile);
        int curVal = 0;
        while((curVal = fis.read()) != -1){
          bos.write(curVal);  
        }
        bos.flush();
        byte[] byteArray = bos.toByteArray();
        crcCode = new CRC32();
        crcCode.update(byteArray);
        
    }
    
    public long getCRC(){
        long crccodeInt = 0; 
        return crccodeInt = crcCode.getValue();
    }
    
    public String getIdentification(){
        String trackID = "";
        return trackID;
    }
}
