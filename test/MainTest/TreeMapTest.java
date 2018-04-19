package MainTest;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {

        Map map = new TreeMap();

        map.put("Anna", 5);
        map.put("Nina", 7);
        map.put("Polina", 1);
        map.put("Antonina", 3);
        map.put("Alima", 9);
        System.out.println(map);

        System.out.println(map.remove("Anna"));
        System.out.println(map);

        map.remove("Pahlava");
        System.out.println(map);

        map.put("Anna", 15);
        map.put("Nina", 77);
        System.out.println(map);

        map.put("Sabrina", 4);
        map.put("Kamila", 3);
        map.put("Madina", 9);
        System.out.println(map);


        map.clear();
        System.out.println(map);

        map.put("Antonina", 588);
        map.put("Fatima", 187);
        System.out.println(map);
    }

}
