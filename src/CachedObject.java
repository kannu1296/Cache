import java.util.Calendar;
import java.util.Date;

public class CachedObject implements Cacheable {
    private Date dateofExpiration = null;
    private Object identifier = null;
    public Object object = null;

    public CachedObject(Object obj,Object id, int minutesToLive){
        this.object = obj;
        this.identifier = id;
        if(minutesToLive != 0){
            dateofExpiration = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(dateofExpiration);
            cal.add(cal.MINUTE, minutesToLive);
            dateofExpiration = cal.getTime();
        }
    }

    @Override
    public boolean isExpired() {
        if(dateofExpiration != null){
            if(dateofExpiration.before(new Date())){
                System.out.println("Expired from Cache! EXPIRE TIME: " + dateofExpiration.toString() + " CURRENT TIME: " +
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


}
