package model;

import java.util.Calendar;

/**
 * 
 * @author vvulic
 */
public class WelcomeService {
    private Calendar currentDateTime;
    private static final String ERROR_INPUT_NULL = 
            "Error: Value cannot be null";
    
    public WelcomeService(){
        setCurrentDateTime(Calendar.getInstance());
    }
    
    public final Calendar getCurrentDateTime() {
        return currentDateTime;
    }

    public final void setCurrentDateTime(Calendar currentDateTime) throws 
            IllegalArgumentException{
        if(currentDateTime == null){
            throw new IllegalArgumentException(ERROR_INPUT_NULL);
        }
        this.currentDateTime = currentDateTime;
    }
    
    public final String determineTimeOfDay(){
        String timeOfDay = "unknown";
        if(currentDateTime.before(getNoonStartTime())){
            timeOfDay = "morning";
        }
        
        if(currentDateTime.after(getNoonStartTime()) && 
                currentDateTime.before(getEveningStartTime())){
            timeOfDay = "afternoon";
        }
        
        if(currentDateTime.after(getEveningStartTime())){
            timeOfDay = "evening";
        }
        return timeOfDay;
    }
    
    public final String getGreeting(String name) throws 
            IllegalArgumentException{
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException(ERROR_INPUT_NULL);
        }
        return "Good " + determineTimeOfDay() + ", " + name + 
                ". Welcome!";
    }
    
    private Calendar getNoonStartTime(){
        Calendar noonStart = Calendar.getInstance();
        noonStart.set(Calendar.HOUR_OF_DAY, 12);
        noonStart.set(Calendar.MINUTE,0);
        noonStart.set(Calendar.SECOND,0);
        return noonStart;
    }
    
    private Calendar getEveningStartTime(){
        Calendar eveningStart = Calendar.getInstance();
        eveningStart.set(Calendar.HOUR_OF_DAY, 18);
        eveningStart.set(Calendar.MINUTE,0);
        eveningStart.set(Calendar.SECOND,0);
        return eveningStart;
    }
}
