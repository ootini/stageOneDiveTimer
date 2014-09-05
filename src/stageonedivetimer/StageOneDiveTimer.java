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
        
        LogToFile newLogFile = new LogToFile();
        newLogFile.openFile();
        while (diveStatus.equals("Diving")) {
            
            boolean writing = true;

            while (writing){
                String timeData = newTimer.getTimeElapsed();
                double depthData = newDepthGauge.getCurrentDepth();

                String diveData = "Time Stamp: " + timeData + "\n" + "Depth: " + depthData;
                            
                //System.out.println(diveData);
                newLogFile.writeFile(diveData);
                try {
                    Thread.sleep(1000); // Sleep for 1 sec 
                } 
                catch (InterruptedException e) {
                    
                }               
            }
        }
    }
}
