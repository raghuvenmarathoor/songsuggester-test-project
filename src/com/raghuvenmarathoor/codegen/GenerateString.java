/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raghuvenmarathoor.codegen;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

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
        JOptionPane.showMessageDialog(null, codestring);
        Object jsonobj = JSONValue.parse(codestring);
        JSONArray jsonarr = (JSONArray) jsonobj;
        JSONObject jobj =(JSONObject) jsonarr.get(0);
        codestring = jobj.get("code").toString();
        JOptionPane.showMessageDialog(null,codestring);
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

//    private static String identifyThisSong(java.lang.String codeString) {
//        com.raghuvenmarathoor.songidentify.SongIdentify_Service service = new com.raghuvenmarathoor.songidentify.SongIdentify_Service();
//        com.raghuvenmarathoor.songidentify.SongIdentify port = service.getSongIdentifyPort();
//        return port.identifyThisSong(codeString);
//    }
//
  public String getIdentifiedDetails(String codeString){
        String result = identifyThisSong(codeString);
        JOptionPane.showMessageDialog(null, result);
//           int i =0, firstPoint = 0 ,secondPoint = 0;
//           String secndstr = "";
//           while(i<result.length()){
//               if(result.charAt(i)=='['){
//    
//                   firstPoint = i;
//}
//               if(result.charAt(i)==']'){
//                   
//                   secondPoint = i;
//               }
//               i++;
//               
//           }
//         secndstr = result.substring(firstPoint, secondPoint+1);
//         JOptionPane.showMessageDialog(null, "result: "+result);
//         System.out.println(result);
//         Object jsonObj = JSONValue.parse(result);
//         JSONObject jsobj = (JSONObject) jsonObj;
//         
//         
//        //JSONArray jsonArr = (JSONArray)jsonObj;
//         //JSONObject jsonob =(JSONObject) jsonArr.get(0);
//         JSONObject temp =(JSONObject) jsobj.get("status");
//         result = result +"\n id :" + temp.toJSONString();
//         
         return result;
      //return new TestIdentification().getResult(codeString);
    }
//
//    private static String identifyThisSong_1(java.lang.String codeString) {
//        com.raghuvenmarathoor.songidentify.SongIdentify_Service service = new com.raghuvenmarathoor.songidentify.SongIdentify_Service();
//        com.raghuvenmarathoor.songidentify.SongIdentify port = service.getSongIdentifyPort();
//        return port.identifyThisSong(codeString);
//    }

    private static String identifyThisSong(java.lang.String codeString) {
        com.raghuvenmarathoor.webservices.SongIdentify_Service service = new com.raghuvenmarathoor.webservices.SongIdentify_Service();
        com.raghuvenmarathoor.webservices.SongIdentify port = service.getSongIdentifyPort();
        return port.identifyThisSong(codeString);
    }

    
    
}
