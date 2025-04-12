package LeetCode150;

import java.util.ArrayList;
import java.util.List;

class TextJustification {

    class Line {

        List<String> words;
        int wordCount;
        int leftSpaces;
        int String;
        int max;

        public boolean add(String word) {
            if ( leftSpaces >= word.length() ) {
                words.add(word);
                leftSpaces -= word.length();

                if ( leftSpaces > 0 ) {
                    leftSpaces--;
                }
                return true;

            }
            return false;

        }

        public Line(int spaces) {
            max = spaces;
            leftSpaces = spaces;
            words = new ArrayList<>();
        }

        public String getAnswer(boolean b) {

            int size = 0;

            for ( String word : words ) {
                size += word.length();
            }
            size += words.size() - 1;

            leftSpaces = max - size;

            StringBuilder s = new StringBuilder();
            int gaps = words.size() - 1;

            int spaces = 0;
            for ( int i = 0; i < words.size() - 1; i++ ) {
                s.append(words.get(i));
                s.append(' ');
                spaces = b ? (leftSpaces/gaps) + ((leftSpaces % gaps) > i ? 1 : 0) : 0;

                s.append(" ".repeat(Math.max(0, spaces)));
            }
            s.append(words.get(words.size()-1));

            s.append(" ".repeat(max - s.length()));

            return s.toString();


        }
    }
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> ans = new ArrayList<>();
        List<Line> ansLines = new ArrayList<>();
        int i = 0;

        Line currentLine = new Line(maxWidth);
        ansLines.add(currentLine);

        while ( i < words.length ) {

            if ( currentLine.add(words[i]) ) {
                i++;
            } else {
                currentLine = new Line(maxWidth);
                ansLines.add(currentLine);
            }

        }

        for ( i = 0 ; i < ansLines.size() - 1; i++ ) {
            ans.add(ansLines.get(i).getAnswer(true));
        }

        ans.add(ansLines.get(ansLines.size()-1).getAnswer(false));

        return ans;
    }

    public static void main(String[] args) {
        TextJustification s = new TextJustification();
        System.out.println(s.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
    }
}