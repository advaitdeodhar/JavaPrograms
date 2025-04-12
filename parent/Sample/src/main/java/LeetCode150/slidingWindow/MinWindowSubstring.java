package LeetCode150.slidingWindow;

import java.util.HashMap;

class MinWindowSubstring {
    public String minWindow(String s, String t) {

        int lenS = s.length();
        int lenP = t.length();

        if ( lenS < lenP ) {
            return "";
        }

        HashMap<Character, Integer> sourceHash = new HashMap<>();
        HashMap<Character, Integer> patHash = new HashMap<>();

        for ( int i = 0 ; i < lenP; i++ ) {
            patHash.put(t.charAt(i), patHash.getOrDefault(t.charAt(i), 0) + 1);
        }

        int right = 0;
        int left = 0;
        char current;
        int patCount;
        int scount;
        int matched = 0;

        int minWindowSize = Integer.MAX_VALUE;
        int windowSize;
        int startIndex = 0;
        while( right < lenS ) {

            current = s.charAt(right);
            patCount = patHash.getOrDefault(current,0);

            if ( patCount > 0 ) {
                scount = sourceHash.getOrDefault(current, 0);

                if ( scount < patCount ) {
                    matched++;
                }
                sourceHash.put(current, scount + 1);
            }

            if ( matched == lenP ) {

                current = s.charAt(left);
                patCount = patHash.getOrDefault(current, 0);
                scount = sourceHash.getOrDefault(current, 0);

                while ( patCount == 0 || patCount < scount) {

                        sourceHash.put(current, scount - 1);
                        left++;
                        current = s.charAt(left);
                        patCount = patHash.getOrDefault(current, 0);
                        scount = sourceHash.getOrDefault(current, 0);

                }

                windowSize = right - left + 1;

                if ( windowSize < minWindowSize ) {
                    minWindowSize = windowSize;
                    startIndex = left;
                }

            }
            right++;
        }

        if ( matched < lenP ) {
            return "";
        }
        return ( s.substring(startIndex, startIndex + minWindowSize));
    }

    public static void main(String[] args) {
        MinWindowSubstring s = new MinWindowSubstring();
        System.out.println(s.minWindow("A", "B"));
    }
}
