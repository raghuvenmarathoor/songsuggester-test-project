/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raghuvenmarathoor.mp3player;
//import com.raghuvenmarathoor.mp3player.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.player.Player;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
/**
 *
 * @author New User
 */
public class MyPlayer extends Thread{
    
    private File filename;
    //public static BasicPlayer myplayer;
    BasicPlayer bplayer;
    public static Player myplay;
   public MyPlayer(File mp3File){
        try {
            filename=mp3File;
            bplayer = new BasicPlayer();
            bplayer.open(mp3File);
            
            bplayer.play();
        } catch (BasicPlayerException ex) {
            Logger.getLogger(MyPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   public MyPlayer(){
       
   }
    
    public void play(){
        try{
            
            //myplay.play();
        }
        catch(Exception e){
            System.out.println("hello"+ e.getCause());
        }
    }
    @Override
    public void run()
    {
        try{
            //FileInputStream fis=new FileInputStream(filename);
            //BufferedInputStream bis=new BufferedInputStream(fis);
            //myplay=new Player(bis);
            //myplay.play();
            bplayer.play();
            //Thread.sleep(2000);
            //myplay.play();
    
        }
        
        catch(Exception e){
            System.out.println("run in thread:"+e.getStackTrace());
        }
    }
    public static void pause()
        {
        try {
           // MyPlayer.
            MyPlayer.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MyPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
}
