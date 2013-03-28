/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raghuvenmarathoor.mp3player;

import com.raghuvenmarathoor.songsuggester.PlayerFrame;
import java.io.File;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;

/**
 *
 * @author New User
 */
public class BasicPlayerTest implements BasicPlayerListener{
    
    BasicPlayer player = null;
    double playerVolume = 0;
    
    BasicController control = null;
    PlayerFrame playerFrame = null;
    long fileSize = 0;
    @Override
    public void opened(Object o, Map map) {
       // JOptionPane.showMessageDialog(null, "Opened");
       // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void progress(int i, long l, byte[] bytes, Map map) {
      
        System.out.println("\nvalues i = "+i+" l ="+ l + "filesize :"+ fileSize );
        //JOptionPane.showMessageDialog(null, "Progress");
      //  throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void stateUpdated(BasicPlayerEvent bpe) {
        //JOptionPane.showMessageDialog(null,"STATE UPDATED:\n" + bpe.getCode());
       if(bpe.getCode() == BasicPlayerEvent.SEEKED){
           JOptionPane.showMessageDialog(null, "seek");
           if(PlayerFrame.play == true){
               playerFrame.playNextSong();
               
           }
       }
       // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setController(BasicController bc) {
       // throw new UnsupportedOperationException("Not supported yet.");
    }
    public void pause(){
        try {
            control.pause();
        } catch (BasicPlayerException ex) {
            Logger.getLogger(BasicPlayerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void stop(){
        try {
          if(control!=null){
            control.stop();
            control = null;
          }
        } catch (BasicPlayerException ex) {
            Logger.getLogger(BasicPlayerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void resume(){
        try {
            control.resume();
        } catch (BasicPlayerException ex) {
            Logger.getLogger(BasicPlayerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void play(String fileName,PlayerFrame playerObj){
         player=new BasicPlayer();
         playerFrame = playerObj;
         control=(BasicController)player;
        player.addBasicPlayerListener(this);
        try{
            File newFile=new File(fileName);
            fileSize = newFile.length();
            control.open(newFile);
           // control.setGain(0.5);
            control.play();
           }catch(BasicPlayerException e){
            System.out.println(e.getCause());
             }
    }
    public void setVolume(double volume){
        
            playerVolume = volume;
            if(control != null){
            try{
                //JOptionPane.showMessageDialog(null,"VOlume"+ volume);
                control.setGain(volume);
            } catch(BasicPlayerException ex){
                JOptionPane.showMessageDialog(null, "Volume changing error:" + ex.getMessage());
            }
            }
    }
}
