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
    int tracklength = 0 ;
    BasicController control = null;
    PlayerFrame playerFrame = null;
    long fileSize = 0;
    boolean elapsedTimeFlag = false;
    int infosize = 0;
    @Override
    public void opened(Object o, Map map) {
       // JOptionPane.showMessageDialog(null, "Opened");
       // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void progress(int i, long l, byte[] bytes, Map map) {
        double percent = 0;
        
        if(elapsedTimeFlag == true){
              infosize = i;
              JOptionPane.showMessageDialog(null, "Information size:"+infosize);
              elapsedTimeFlag = false;
          }
      if(playerFrame != null){
           percent = (double) (i - infosize)/(fileSize - infosize);
          int sliderPos =(int) (percent * (double)1000);
          //System.out.println("percent:"+percent+"sliderpos:"+ sliderPos+"\n");
//          if(sliderPos >= 1){
//          JOptionPane.showMessageDialog(null, "Slider Position:"+ sliderPos);
//          }
          
          playerFrame.setElapsedTime((int) (percent * (double)tracklength ));
          //JOptionPane.showMessageDialog(null,(int) (percent * (double)tracklength ) );
          playerFrame.setSliderPosition(sliderPos);
      }
        System.out.println("\nvalues i = "+i+" l ="+ l + "filesize :"+ fileSize+ "percent :"+ percent );
        //JOptionPane.showMessageDialog(null, "Progress");
      //  throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void stateUpdated(BasicPlayerEvent bpe) {
        //JOptionPane.showMessageDialog(null,"STATE UPDATED:\n" + bpe.getCode());
       if(bpe.getCode() == BasicPlayerEvent.EOM){
           JOptionPane.showMessageDialog(null, "EOM");
           if(PlayerFrame.play == true){
               playerFrame.playNextSong();
               
           }
           if(bpe.getCode() == BasicPlayerEvent.SEEKED){
               JOptionPane.showMessageDialog(null, "Seeked");
               System.out.println(bpe.getPosition());
           }
           if(bpe.getCode() == BasicPlayerEvent.SEEKING){
              System.out.println("seeking");// JOptionPane.showMessageDialog(null, "seeking");
           }
           if(bpe.getCode() == BasicPlayerEvent.PAUSED){
               JOptionPane.showMessageDialog(null, bpe.getPosition());
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
             // control.seek(10000);
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
    
    public void seek(long seekPosition){
        try {
            //JOptionPane.showMessageDialog(null, seekPosition+"/"+fileSize);
            control.seek(seekPosition);
        } catch (BasicPlayerException ex) {
            Logger.getLogger(BasicPlayerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void play(String fileName,PlayerFrame playerObj,int tracklength){
         player=new BasicPlayer();
         playerFrame = playerObj;
         elapsedTimeFlag = true;
         this.tracklength = tracklength;
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
