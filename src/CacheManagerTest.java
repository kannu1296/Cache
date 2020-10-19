public class CacheManagerTest {
    public static void main(String args[]){

        CacheManagerTest test1 = new CacheManagerTest();

        String obj1 = new String("A");
        String obj2 = new String("B");

        CachedObject co1 = new CachedObject(obj1, new Long(1), 1);
        CachedObject co2 = new CachedObject(obj2, new Long(2), 2);

        CacheManager.putCache(co1);
        CacheManager.putCache(co2);

        CachedObject o1 = (CachedObject)CacheManager.getCache(new Long(1));
        CachedObject o2 = (CachedObject)CacheManager.getCache(new Long(2));

        if(o1 == null)
            System.out.println("OOPS!  Object not Found In The Cache : ID -> "+ o1.getIdentifier().toString());
        else
            System.out.println("SUCCESS! " + ((String)o1.object).toString());

        if(o2 == null)
            System.out.println("OOPS!  Object not Found In The Cache : ID -> "+ o2.getIdentifier().toString());
        else
            System.out.println("SUCCESS! " + ((String)o2.object).toString());
    }
}
