package Java;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
    private HashMap cache ;    //Used to store key and value
    private HashMap<Object, Integer> keyCount;       //Used to store key and Number of times they have used
    private HashMap<Integer, LinkedHashSet> countList ;     //used to store list of keys used same number of times
    private int capacity;       //Cache Capacity
    private int min = -1;

    //Constructor to initialize cache
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap();
        this.keyCount = new HashMap();
        this.countList = new HashMap();
        countList.put(1, new LinkedHashSet());
    }

    //function to insert value in cache
    public void set(Object key, Object value){


        if(capacity<=0)
            return;

        //Check if key already exist
        if(cache.containsKey(key)){
            cache.put(key, value);
            get(key);
            return;
        }

        //Check if Cache is full, then remove LFU element
        if(cache.size() >= capacity){
            Object lfuElement = countList.get(min).iterator().next();
            countList.get(min).remove(lfuElement);
            keyCount.remove(lfuElement);
            cache.remove(lfuElement);
        }

        //If key is new then insert, and set min to 1
        cache.put(key, value);
        keyCount.put(key, 1);
        countList.get(1).add(key);
        min = 1;

    }

    //function to get value from cache
    public Object get(Object key){

        //Check is key exist
        if(!cache.containsKey(key))
            return null;

        int count = keyCount.get(key);
        keyCount.put(key, count+1);
        countList.get(count).remove(key);

        if(count == min && countList.get(count).size() == 0)
            min++;
        if(!countList.containsKey(count+1))
            countList.put(count+1, new LinkedHashSet());
        countList.get(count+1).add(key);
        return cache.get(key);
    }

}
