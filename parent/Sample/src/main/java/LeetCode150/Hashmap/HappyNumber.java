package LeetCode150.Hashmap;

import java.util.HashSet;
import java.util.Set;

class HappyNumber {
    public boolean isHappy(int n) {

        Set<Integer> visited = new HashSet<>();
        while ( n > 3 && !visited.contains(n)) {
            visited.add(n);
            n = sumOfSquareOfDigits(n);
        }

        return n==1;

    }

    private int sumOfSquareOfDigits(int n) {

        int ans = 0 ;
        int digit;
        while ( n > 9 ) {
            digit = n % 10;
            ans += (digit * digit);
            n = n / 10;
        }
        ans += ( n* n );

        return ans;

    }

    public static void main(String[] args) {
        HappyNumber s = new HappyNumber();
        System.out.println(s.isHappy(4));
    }
}
