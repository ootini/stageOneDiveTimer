/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stageonedivetimer;

import java.io.IOException;

/**
 *
 * @author dave
 */
public class StageOneDiveTimer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        StatusManager newstatusManager = new StatusManager();
        String diveStatus = newstatusManager.getStatus();
        
        //Instantiate the depth gauge
        DepthGauge newDepthGauge = new DepthGauge();

        //Instantiate the stop watch
        Timer newTimer = new Timer();
        
        //Instantiate logging facility
        
        LogToFile newLogFile = new LogToFile();
        newLogFile.openFile();
        int x = 0;


        while (diveStatus.equals("Diving")) {
            
            
            boolean writing = true;

            while (writing){
                if (x < 11) {
                    String timeData = newTimer.getTimeElapsed();
                    //System.out.println(timeData);

                    double depthData = newDepthGauge.depthArray1[x];
                    //System.out.println(x);

                    String diveData = "Time Stamp: " + timeData + "\n" + "Depth: " + depthData + "\n";

                    System.out.println(diveData);
                    newLogFile.writeFile(diveData);
                    try {
                        Thread.sleep(1000); // Sleep for 1 sec 
                    } 
                    catch (InterruptedException e) {
                    }
                    x++;
                } 
                else {
                    newLogFile.closeFile();
                }
            }
        }       
    }
}
