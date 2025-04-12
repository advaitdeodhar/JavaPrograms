package LeetCode150.Hashmap;

import java.util.HashMap;
import java.util.Map;

class RansomeNote {
    public boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> magCount = new HashMap<>();

        for ( Character c : magazine.toCharArray()) {
            magCount.put(c, magCount.getOrDefault(c,0) + 1);
        }

        Integer count;
        for ( Character c : ransomNote.toCharArray()) {

            count = magCount.getOrDefault(c, 0);

            if ( count == 0 ) {
                return false;
            }
            magCount.put(c, count -1);
        }

        return true;

    }
}