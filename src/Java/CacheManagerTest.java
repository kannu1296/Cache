package Java;

public class CacheManagerTest {
    public static void main(String args[]){

        CacheManagerTest test1 = new CacheManagerTest();

        String obj1 = "A";


        CachedObject co1 = new CachedObject(obj1, new Long(1), 1);


        CacheManager.putCache(co1);


        CachedObject o1 = (CachedObject)CacheManager.getCache(new Long(1));


        if(o1 == null)
            System.out.println("OOPS!  Object not Found In The Cache : ID -> "+ o1.getIdentifier().toString());
        else
            System.out.println("SUCCESS! " + o1.getObject());


    }
}
