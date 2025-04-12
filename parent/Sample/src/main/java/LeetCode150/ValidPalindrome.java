package LeetCode150;

class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int i = 0 ; int j = s.length() - 1;
        char c1, c2;
        while ( i < j ) {

            c1 = s.charAt(i);
            c2 = s.charAt(j);

            if ( !Character.isAlphabetic(c1) && !Character.isDigit(c1)) {
                i++;
                continue;
            }

            if ( !Character.isAlphabetic(c2) &&  !Character.isDigit(c2)) {
                j--;
                continue;
            }

            if ( Character.toLowerCase(c1) != Character.toLowerCase(c2) ) {
                return false;
            }
            i++;
            j--;

        }

        return true;
    }
}