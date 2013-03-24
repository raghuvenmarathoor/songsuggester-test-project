/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raghuvenmarathoor.mp3player;

import java.awt.Dialog;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

/**
 *
 * @author New User
 */
public class PlayListItem implements java.io.Serializable{
    
     String songFileName;
    
     String songPath;
     String songInfo;
     PlayListItem(File mp3File){
        try {
            songFileName = mp3File.getName();
            songPath = mp3File.getAbsolutePath();
            MP3File mp3=(MP3File)AudioFileIO.read(mp3File);
            Tag tag=mp3.getTag();
            
            //songInfo = tag.getFirst(FieldKey.TITLE);
            songInfo = tag.getFirst(FieldKey.TITLE) + " - " + tag.getFirst(FieldKey.ARTIST);
            //JOptionPane.showMessageDialog(null, songInfo+" "+ songPath);
        } catch (CannotReadException ex) {
            Logger.getLogger(PlayListItem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PlayListItem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TagException ex) {
            Logger.getLogger(PlayListItem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ReadOnlyFileException ex) {
            Logger.getLogger(PlayListItem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidAudioFrameException ex) {
            Logger.getLogger(PlayListItem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getSongInfo(){
        return songInfo;
    }
    public String getSongPath(){
        return songPath;
    }
    public String getSongFileName(){
        return songFileName;
    }
}
