package MainTest;

import csci152.adt.HashTableMap;
import csci152.adt.Map;
import csci152.impl.*;

public class MapTest {
    public static void main(String[] args) {
        Map map = new BSTMap();

        try {
            System.out.println(map.removeAny());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(map);

        map.define("Anna", 5);
        map.define("Nina", 7);
        map.define("Polina", 1);
        map.define("Antonina", 3);
        map.define("Alima", 9);
        System.out.println(map);

        System.out.println(map.remove("Anna"));
        System.out.println(map);

        map.remove("Pahlava");
        System.out.println(map);

        map.define("Anna", 15);
        map.define("Nina", 77);
        System.out.println(map);

        map.define("Sabrina", 4);
        map.define("Kamila", 3);
        map.define("Madina", 9);
        System.out.println(map);

        try {
            map.removeAny();
            map.removeAny();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(map);

        map.clear();
        System.out.println(map);

        map.define("Antonina", 588);
        map.define("Fatima", 187);
        System.out.println(map);
    }
}
