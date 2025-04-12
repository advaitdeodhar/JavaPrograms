package LeetCode150.Hashmap;

import java.util.*;

class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
//        Map<Character, Integer> sCount = new LinkedHashMap<>();
//
//        for ( Character c : s.toCharArray()) {
//            sCount.put(c, sCount.getOrDefault(c,0) + 1);
//        }
//
//        Map<Character, Integer> tCount = new LinkedHashMap<>();
//
//        for ( Character c : t.toCharArray()) {
//            tCount.put(c, tCount.getOrDefault(c,0) + 1);
//        }
//
//        List<Integer> sList = sCount.values().stream().toList();
//        List<Integer> tList = tCount.values().stream().toList();
//
//        for ( int i = 0 ; i < sList.size() ; i++ ) {
//            if ( sList.get(i) != tList.get(i) ) {
//                return false;
//            }
//        }
//
//        return true;

        Map<Character, Character> charMap = new HashMap<>();
        Set<Character> used = new HashSet<>();

        Character mapped;
        for ( int i = 0 ; i < s.length(); i++ ) {

            mapped = charMap.get(s.charAt(i));
            if ( mapped == null ) {
                if ( used.contains(t.charAt(i))) {
                    return false;
                }
                charMap.put(s.charAt(i), t.charAt(i));
                used.add(t.charAt(i));
                continue;
            }
            if ( mapped != t.charAt(i)) {
                return false;
            }

        }

        return true;

    }
}
