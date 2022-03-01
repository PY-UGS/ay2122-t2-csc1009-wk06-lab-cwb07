import java.util.*;
import java.util.Map.Entry;
import java.util.LinkedHashMap;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(9);
        list.add(11);
        System.out.println("Question 1");
        System.out.println("Before sort: " + list);
        addAndSort(list, 50);
        addAndSort(list, 1);
        System.out.println("After sort: " + list);

        swap(list, 3, 11);
        System.out.println("\nQuestion 2");
        System.out.println("After swap: " + list);

        System.out.println("\nQuestion 3");
        Random rand = new Random();
        LinkedList<Integer> newList = new LinkedList<Integer>();
        for (int i = 0; i < 500; i++) {
            int randomNum = rand.nextInt((9999 - 1000) + 1) + 1000;
            newList.add(randomNum);
        }

        int randomNum2 = rand.nextInt((9999 - 1000) + 1) + 1000;
        System.out.println(findValue(newList, randomNum2));

        //can use linked hash map - preserves order in which it was inserted
        //hash map printed according to key
        System.out.println("\nQuestion 4");
        HashMap m = new HashMap();
        m.put(0,1);
        m.put(1,3);
        m.put(2,5);
        m.put(3,7);
        m.put(4,9);
        m.put(5,11);

        System.out.println("Before sort: " + m);
        System.out.println("After sort: " + addAndSortHash(m, 1));

        System.out.println("\nQuestion 5");
        LinkedHashMap m2 = new LinkedHashMap();
        m2.put(0,1);
        m2.put(1,3);
        m2.put(2,5);
        m2.put(3,7);
        m2.put(4,9);
        m2.put(5,11);
        swapHash(m2, 3, 7);
        System.out.println(m2);

        System.out.println("\nQuestion 6");
        LinkedHashMap m3 = new LinkedHashMap();

        for (int i = 0; i < 500; i++) {
            int randomNum = rand.nextInt((9999 - 1000) + 1) + 1000;
            m3.put(i, randomNum);
        }

        int randomNum3 = rand.nextInt((9999 - 1000) + 1) + 1000;
        System.out.println(findValueHash(m3, randomNum3));
    }

    //Q1
    public static LinkedList<Integer> addAndSort(LinkedList<Integer> l, int value) {
        l.add(value);
        Collections.sort(l);
        return l;
    }

    //Q4
    public static List<Entry<Integer, Integer>> addAndSortHash(HashMap m, int value) {
        m.put(m.size(), value);

        List<Entry<Integer, Integer>> list = new ArrayList<>(m.entrySet());
		list.sort(Entry.comparingByValue());

        // for(Entry<Integer, Integer> entry : list){
        //     m.put(entry.getKey(), entry.getValue());
        // }

        return list;
    }

    //Q2
    public static void swap(LinkedList<Integer> list, int ele1, int ele2) {
        // Getting the positions of the elements
        int index1 = list.indexOf(ele1);
        int index2 = list.indexOf(ele2);

        // Returning if the element is not present in the
        // LinkedList
        if (index1 == -1 || index2 == -1) {
            return;
        }

        // Swapping the elements
        list.set(index1, ele2);
        list.set(index2, ele1);
    }


    //Q5    
    public static void swapHash(LinkedHashMap m, int ele1, int ele2) {
        Set<Integer> keys = m.keySet();
        int index1 = 0;
        int index2 = 0;

        for (Integer key : keys) {
            int value = Integer.valueOf((int)m.get(key));
            if (value == ele1) {
                index1 = key;
            } else if (value == ele2) {
                index2 = key;
            }
            //System.out.println(key + " -- " + m.get(key));
        }

        m.put(index2,ele1);
        m.put(index1,ele2);
    }

    //Q3
    public static int findValue(LinkedList<Integer> list, int value) {
        if (list.contains(value)) {
            return list.indexOf(value);
        } else {
            return -1;
        }
    }

    //Q6
    public static int findValueHash(LinkedHashMap m, int searchValue) {
        if (m.containsValue(searchValue)) {
            int position = 0;

            Set<Integer> keys = m.keySet();

            for (Integer key : keys) {
                int value = Integer.valueOf((int)m.get(key));
                if (value == searchValue) {
                    position = key;
                }
            }
            return position;
        } else {
            return -1;
        }
    }
}