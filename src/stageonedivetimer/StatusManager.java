/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stageonedivetimer;

/**
 *
 * @author dave
 */
public class StatusManager {
    
    public static final String NOT_DIVING = "Not Diving";
    public static final String DIVING = "Diving";
    
         String status;
         
         public StatusManager (){
             this.status=NOT_DIVING;
         }
    
    public String getStatus() {
        return status;
    }   
}
