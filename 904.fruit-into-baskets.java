import java.util.*;

class Solution {
    public int totalFruit(int[] fruits) {
        if (fruits.length <= 2)
            return fruits.length;
        HashMap<Integer, Integer> window = new HashMap<>();
        int i = 0;
        int max = 0;
        int count = 0;
        for (int j = 0; j < fruits.length; j++) {
            window.put(fruits[j], window.getOrDefault(fruits[j], 0) + 1);
            count++;
            while (window.size() > 2) {
                window.put(fruits[i], window.get(fruits[i]) - 1);
                window.remove(fruits[i], 0);
                i++;
                count--;
            }
            // Integer[] arr = window.values().toArray(new Integer[0]);
            max = Math.max(max, count);
        }
        return max;
    }
}