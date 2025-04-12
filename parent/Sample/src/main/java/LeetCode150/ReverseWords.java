package LeetCode150;

import java.util.ArrayList;
import java.util.List;

class ReverseWords {
    public String reverseWords(String s) {

        StringBuilder word = new StringBuilder();

        List<String> words = new ArrayList<>();


        for (Character c : s.toCharArray()) {
            if ( c == ' ') {
                if (!word.isEmpty()) {
                    words.add(word.toString());
                    word = new StringBuilder();
                }
                continue;
            }
            word.append(c);
        }

        if (!word.isEmpty()) {
            words.add(word.toString());
            word = new StringBuilder();
        }

        StringBuilder ans = new StringBuilder();

        for ( int i = words.size() - 1; i > 0; i-- ) {
            ans.append(words.get(i));
            ans.append(' ');
        }

        ans.append(words.get(0));
        return ans.toString();

    }

    public static void main(String[] args) {
        ReverseWords s = new ReverseWords();

        System.out.println(s.reverseWords(" Adm             Bombay "));
    }
}
