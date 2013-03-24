/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raghuvenmarathoor.mp3player;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author New User
 */


public class PlayListManager implements java.io.Serializable{
    ArrayList<PlayListItem> playList;
    PlayListItem newSong;
    
    public int currentPointer = 0;
    
    public PlayListManager(){
        playList = new ArrayList<PlayListItem>();
    }
    public void addToPlaylist(String mp3File){
        File songFile=new File(mp3File);
        
        newSong = new PlayListItem(songFile);
        try{
            playList.add(newSong);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Playlist Error:" + e.getStackTrace());
        }
        
    }
    public PlayListItem extractFromPlaylist(int index){
        return playList.get(index);
    }
    public int getPlayListLength(){
        return playList.size();
    }
    public void removeFromPlayList(int index){
        playList.remove(index);
    }
    public void currentIndex(int index){
        currentPointer = index;
    }
        
    
    
    
}
