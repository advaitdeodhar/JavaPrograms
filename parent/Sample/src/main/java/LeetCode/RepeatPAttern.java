package LeetCode;

class RepeatPAttern {
    public boolean repeatedSubstringPattern(String s) {

        int size = s.length();

        int[] prefix = new int[size];

        int i = 0 ;

        prefix[i] = 0;
        i = 1;
        int len = 0;
        while ( i < size ) {
            if ( s.charAt(i) == s.charAt(len)) {
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

        int lastLen = prefix[s.length() - 1];
        if ( lastLen == 0 ) {
            return false;
        }
        int diff = s.length() - lastLen;
        return (s.length()%diff == 0);


//        while ( lastLen != 0 ) {
//
//            if(lastLen - prefix[lastLen - 1] != diff) {
//                return false;
//            }
//            lastLen = prefix[lastLen - 1];
//        }
//
//        return true;


    }

    public static void main(String[] args) {
        RepeatPAttern s = new RepeatPAttern();
        System.out.println(s.repeatedSubstringPattern("abaababaab"));
    }

}
