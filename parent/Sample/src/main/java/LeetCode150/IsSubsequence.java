package LeetCode150;

class IsSubsequence {
    public boolean isSubsequence(String s, String t) {

        int i = 0;
        int j = 0;

        if (s.isEmpty()) {
            return true;
        }

        while ( j < t.length() ) {

            if ( s.charAt(i) == t.charAt(j)) {
                i++;
                if ( i == s.length()) {
                    return true;
                }
            }
            j++;
        }
        return false;

    }
}
