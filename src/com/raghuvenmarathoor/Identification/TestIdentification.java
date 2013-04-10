/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raghuvenmarathoor.Identification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author New User
 */
public class TestIdentification {
    
     String result = "";
    public String getResult(String codeString){
        
        try{
      HttpClient client = new DefaultHttpClient();
    //HttpGet request = new HttpGet("http://developer.echonest.com/api/v4/song/identify?api_key=YQE6A7AAMXHDYPC2R&code="+codeString);
          //  JOptionPane.showMessageDialog(null, "http://developer.echonest.com/api/v4/song/identify?api_key=YQE6A7AAMXHDYPC2R&code="+codeString);
            //HttpGet request = new HttpGet("http://developer.echonest.com/api/v4/song/identify?api_key=YQE6A7AAMXHDYPC2R&code="+codeString);
      HttpGet request = new HttpGet("http://www.google.com");
    HttpResponse response = client.execute(request);

    // Get the response
    BufferedReader rd = new BufferedReader
      (new InputStreamReader(response.getEntity().getContent()));
       
    String line = "";
    while ((line = rd.readLine()) != null) {
      result = result + line;
    } 
            
            
        } catch (IOException ex) {
           JOptionPane.showMessageDialog(null,ex.getCause());
        } 
        return result;
}
}
