package LeetCode150.Hashmap;

import java.util.HashMap;
import java.util.Map;

class Anagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> magCount = new HashMap<>();

        if ( s.length() != t.length() ) {
            return false;
        }

        for (Character c : s.toCharArray()) {
            magCount.put(c, magCount.getOrDefault(c, 0) + 1);
        }

        Integer count;
        for (Character c : t.toCharArray()) {

            count = magCount.getOrDefault(c, 0);

            if (count == 0) {
                return false;
            }
            magCount.put(c, count - 1);
        }




        return true;

    }
}



