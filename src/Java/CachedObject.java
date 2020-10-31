package Java;

import Java.Cacheable;

import java.util.Calendar;
import java.util.Date;

public class CachedObject implements Cacheable {
    private Date timeofExpiration = null;
    private Object identifier = null;
    private Object object = null;

    public CachedObject(Object obj,Object id, int minutesToLive){
        this.object = obj;
        this.identifier = id;
        if(minutesToLive != 0){
            timeofExpiration = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(timeofExpiration);
            cal.add(cal.MINUTE, minutesToLive);
            timeofExpiration = cal.getTime();
        }
    }

    @Override
    public boolean isExpired() {
        if(timeofExpiration != null){
            if(timeofExpiration.before(new Date())){
                System.out.println("Expired from Cache! EXPIRE TIME: " + timeofExpiration.toString() + " CURRENT TIME: " +
                (new java.util.Date()).toString());
                return true;
            }
            else{
                //System.out.println("Not Expired");
                return false;
            }
        }
        else
            return false;
    }

    @Override
    public Object getIdentifier() {
        return identifier;
    }

    public Object getObject(){
        return this.object;
    }


}
