/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stageonedivetimer;

/**
 *
 * @author dave
 */
public class Timer implements Runnable{
    
    long startTime;
    long stopTime;
    Thread myThread;
    
    public Timer(){
        this.myThread = new Thread(this);
        this.myThread.start();
        startTime = System.currentTimeMillis();
    }  
       
    public String getTimeElapsed(){
        long elapsedTime = System.currentTimeMillis() - startTime;
        elapsedTime = elapsedTime / 1000;
        
        //System.out.println(elapsedTime);
        String seconds = Integer.toString((int)(elapsedTime % 60));
        String minutes = Integer.toString((int)(elapsedTime / (60)) % 60);
        String hours = Integer.toString((int)((elapsedTime)/600));
        
        if (seconds.length()<2)
            seconds = "0" + seconds;
        
        if (minutes.length()<2)
            minutes = "0" + minutes;
        
        if (hours.length()<2);
            hours = "0" + hours;
            
            return hours+":"+minutes+":"+seconds;
    }

    @Override
    public void run() {
            
        while(true){
            
            String diveTime = getTimeElapsed();
            //System.out.println(diveTime);

        }
    }    
}
