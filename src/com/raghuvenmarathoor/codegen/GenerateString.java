/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raghuvenmarathoor.codegen;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author New User
 */
public class GenerateString {
    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author New User
 */

    
    public String getRawOutput(String musicFilePath){
    
   
        
    try {
           
        ProcessBuilder dirProcess = new ProcessBuilder("C:\\Users\\New User\\Documents\\Project\\Sample Source Codes\\ENMFP_codegen\\codegen.windows.exe",musicFilePath,"10","30");
        Process p=dirProcess.start();
        InputStream stderr = p.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(stderr));
        String line="";
        String codestring="";
        int count=0;
        while((line=br.readLine())!=null)
        {
            
            codestring=codestring+line;
        }
        count=codestring.length();
        System.out.println(codestring+"\ncount:"+count);
        return codestring;
       // File newfile=new File("abc1.txt");
        //newfile.createNewFile();
        //FileOutputStream fos=new FileOutputStream(newfile);
        //while((line=br.readLine())!=null){
          //  fos.write(line.getBytes());
         //   System.out.println(line);
        
        //fos.close();
    
    
        
           

    }catch(Exception e){
        
       System.out.print(e.getMessage());
       return null;
     }
    }

    
}
