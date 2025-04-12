package LeetCode150;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger13 {

        Map<Character, Integer> rToI;
        public RomanToInteger13() {
            rToI = new HashMap<>();

            rToI.put('I', 1);
            rToI.put('V', 5);
            rToI.put('X', 10);
            rToI.put('L', 50);
            rToI.put('C', 100);
            rToI.put('D', 500);
            rToI.put('M', 1000);
        }

        public int romanToInt(String s) {

            char[] data = s.toCharArray();

            int previous = 0;

            int ans = rToI.get(data[previous]);

            for ( int i = 1; i < data.length ; i++ ) {
                previous = i - 1;
                char current = data[i];
                int prevValue = rToI.get(data[previous]);
                int currentValue = rToI.get(current);

                if ( prevValue < currentValue ) {
                    ans -= prevValue;
                    currentValue -= prevValue;
                }
                ans += currentValue;

            }

            return ans;
        }

    public static void main(String[] args) {
            RomanToInteger13 s = new RomanToInteger13();
        System.out.println(s.romanToInt("IV"));
    }
}
