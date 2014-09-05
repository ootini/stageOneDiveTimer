/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stageonedivetimer;

import java.text.*;
import java.io.*;
import java.util.Date;

/**
 *
 * @author dave
 */
public class LogToFile {
    BufferedWriter writer;

    public void openFile() throws IOException {
        Date date = new Date();
        //System.out.println(date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        File file = new File("/home/dave/NetBeansProjects/stageOneDiveTimer/logs/" + dateFormat.format(date) + ".txt");
        //System.out.println(file);
        writer = new BufferedWriter(new FileWriter(file));
    }

    public void writeFile(String diveData) throws IOException {
        writer.write(diveData);

    }

    public void closeFile() throws IOException {
        writer.close();
    }
}