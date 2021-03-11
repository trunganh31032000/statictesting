/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhnt.daos;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author  TRUNG ANH
 */
public class MyLog {
    public static void writeLog(String msg, String logName){
        FileWriter w = null;
        try{
            w = new FileWriter(logName, true);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String date = now.format(dtf);
            w.write(date + "\n" + msg + "\n" + dtf + "\n");
        }catch(IOException ex){
            ex.printStackTrace();
        }finally{
            try {
                if(w != null) w.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
    }
}
