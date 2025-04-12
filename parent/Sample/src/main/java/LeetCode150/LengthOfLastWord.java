package LeetCode150;

class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        char[] data = s.toCharArray();
        int i;
        int ans = 0;
        boolean started = false;
        for ( i = data.length - 1 ; i >= 0; i-- ) {
            if ( data[i] == ' ' ) {
                if ( started ) {
                    break;
                }
            } else {
                started = true;
                ans++;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        LengthOfLastWord s = new LengthOfLastWord();
        System.out.println(s.lengthOfLastWord("Hello World "));
    }
}
