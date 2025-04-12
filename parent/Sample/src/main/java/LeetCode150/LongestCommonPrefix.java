package LeetCode150;

class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        int count = strs.length;

        int minLength = Integer.MAX_VALUE;
        for ( int i = 0; i < count ; i++ ) {
            if ( strs[i].length() < minLength ) {
                minLength = strs[i].length();
            }
        }
        StringBuilder s = new StringBuilder();
        for ( int i = 0; i < minLength; i++ ) {
            char c = strs[0].charAt(i);
            boolean matched = true;
            for ( int j = 1; j < count; j++ ) {
                matched = matched && (strs[j].charAt(i) == c);
            }
            if ( matched ) {
                s.append(c);
            } else {
                break;
            }

        }
        return s.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix s = new LongestCommonPrefix();
        System.out.println(s.longestCommonPrefix(new String[]{"advait", "advitya", "adviti"}));
    }
}
