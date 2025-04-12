package LeetCode150.slidingWindow;

import java.util.HashMap;

class LongestSubstringWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> charsIndex = new HashMap<>();
        int startPosition = 0;
        int prevIndex, currentWindow = 0;
        int max = 0;
        int i = 0;
        for ( i = 0 ; i < s.length(); i++ ) {

            prevIndex = charsIndex.getOrDefault(s.charAt(i), -1);
            if ( prevIndex != -1  && prevIndex >= startPosition ) {
                currentWindow = i - startPosition;
                if (currentWindow > max) {
                    max = currentWindow;
                }
                startPosition = prevIndex + 1;
            }
            charsIndex.put(s.charAt(i),i);

        }

        currentWindow = s.length() - startPosition;

        if (currentWindow > max) {
            max = currentWindow;
        }

        return max;

    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingChars s = new LongestSubstringWithoutRepeatingChars();

        System.out.println(s.lengthOfLongestSubstring("dvdf"));
    }
}
