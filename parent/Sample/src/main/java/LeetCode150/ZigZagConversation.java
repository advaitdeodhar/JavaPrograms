package LeetCode150;

class ZigZagConversation {
    public String convert(String s, int numRows) {

        StringBuilder[] output = new StringBuilder[numRows];

        int snippetCount = 2 * numRows - 2;
        int[] snippet;
        if ( numRows == 1 ) {
            snippet = new int[]{0};
            snippetCount = 1;
            output[0] = new StringBuilder();
        } else {
            snippet = new int[snippetCount];
            int ss = 0;
            for ( int i = 0; i < numRows; i++) {
                snippet[ss++] = i;
                output[i] = new StringBuilder();
            }

            for ( int i = numRows - 2; i >= 1 ; i-- ) {
                snippet[ss++] = i;
            }
        }

        int current = 0 ;

        for ( Character c : s.toCharArray()) {
            output[snippet[current]].append(c);
            current = (current + 1) % snippetCount;
        }

        StringBuilder ans = new StringBuilder();
        for ( int i = 0 ; i < numRows; i++ ) {
            ans.append(output[i].toString());
        }

        return ans.toString();

    }

    public static void main(String[] args) {
        ZigZagConversation s = new ZigZagConversation();
        System.out.println(s.convert("PAYPALISHIRING", 1));
    }
}
