package Java;

import Java.LFUCache;

import java.lang.String;

public class LFUCacheTest {
    public static void main(String[] args) {
        LFUCache obj = new LFUCache(3);

        obj.set(new Integer(1), new String("Karan"));
        obj.set(new Integer(2), new String("Bhaumik"));
        obj.set(new Integer(3), new String("Ruchin"));

        System.out.println(obj.get(1));
        System.out.println(obj.get(2));
        System.out.println(obj.get(3));

        obj.set(new Integer(2), new String("Harshit"));
        obj.set(new Integer(4), new String("Amit"));

        System.out.println(obj.get(2));
        System.out.println(obj.get(1));
        System.out.println(obj.get(4));

    }
}
