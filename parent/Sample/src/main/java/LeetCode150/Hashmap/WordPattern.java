package LeetCode150.Hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class WordPattern {
    public boolean wordPattern(String pattern, String s) {

        Map<Character, String> charMap = new HashMap<>();
        Set<String> used = new HashSet<>();

        String[] t = s.split(" ");

        if ( t.length != pattern.length()) {
            return false;
        }

        String mapped;
        for ( int i = 0 ; i < pattern.length(); i++ ) {

            mapped = charMap.get(pattern.charAt(i));
            if ( mapped == null ) {
                if ( used.contains(t[i])) {
                    return false;
                }
                charMap.put(pattern.charAt(i), t[i]);
                used.add(t[i]);
                continue;
            }
            if ( !mapped.equals(t[i]) ) {
                return false;
            }

        }

        return true;

    }

    public static void main(String[] args) {

        WordPattern s = new WordPattern();

        System.out.println(s.wordPattern("abba", "dog cat cat dog"));

    }
}