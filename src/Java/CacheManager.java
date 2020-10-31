package Java;

import Java.Cacheable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class CacheManager {
    private static HashMap cacheHashMap = new HashMap();

    static{
        try{

            Thread cleaner = new Thread(new Runnable() {
                int milliSecondSleepTime  = 5000;
                @Override
                public void run() {


                    try {
                    while(true){
                        System.out.println("Scanning For Expired Objects...");
                        Set keySet = cacheHashMap.keySet();
                        Iterator keys = keySet.iterator();
                        while (keys.hasNext()){
                            Object key = keys.next();
                            Cacheable value = (Cacheable)cacheHashMap.get(key);
                            if(value.isExpired()){
                                cacheHashMap.remove(key);
                                System.out.println("Found an Expired Object in the Cache: ID -> "+key.toString());

                            }
                        }

                        Thread.sleep(this.milliSecondSleepTime);
                    }
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    return;

                }
            });
            cleaner.setPriority(Thread.MIN_PRIORITY);
            cleaner.start();
        }catch (Exception e){
            System.out.println("e");
        }
    }

    public CacheManager(){

    }

    public static void putCache(Cacheable object){

        cacheHashMap.put(object.getIdentifier(), object);
    }

    public static Cacheable getCache(Object identifier){
        Cacheable object = (Cacheable)cacheHashMap.get(identifier);
        if(object==null)
            return null;
        if(object.isExpired()){
            cacheHashMap.remove(identifier);
            return null;
        }
        else
            return object;
    }
}
