package LeetCode;

class ShortestPalindrome {


    public String shortestPalindrome(String s) {

        StringBuilder temp = new StringBuilder();
        temp.append(s);
        String pattern = s + "#" + temp.reverse().toString();
        int size = pattern.length();

        int[] prefix = new int[size];

        int i = 0 ;

        prefix[i] = 0;
        i = 1;
        int len = 0;

        while ( i < size ) {
            if ( pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                prefix[i] = len;
                i++;
            } else {
                if ( len == 0 ) {
                    prefix[i] = 0;
                    i++;
                } else {
                    len = prefix[len - 1];
                }
            }
        }

        int missingChars  = s.length() - prefix[pattern.length() - 1];

        StringBuilder sb = new StringBuilder();

        for ( int j = 0 ; j < missingChars ; j++ ) {
            sb.append(s.charAt(s.length() - 1 -j));
        }

        sb.append(s);
        return sb.toString();

    }


    public static void main(String[] args) {

        ShortestPalindrome s = new ShortestPalindrome();

        System.out.println(s.shortestPalindrome("aacecaaa"));

    }
}
