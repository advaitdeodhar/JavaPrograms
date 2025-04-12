import java.util.HashSet;
import java.util.Set;

public class TestOne {

    public static void main(String[] args) {

        String input = "aab";

        printAllPerm(input, "");

    }

    private static void printAllPerm(String input, String s) {

        if ( input.isEmpty() ) {
            System.out.println(s);
        }

        Set<Character> visited = new HashSet<>();

        for ( int i = 0 ; i < input.length(); i++ ) {

            char c = input.charAt(i);

            if ( visited.add(c) ) {

                String rest = input.substring(0, i) + input.substring(i + 1);

                printAllPerm(rest, s + c);
            }
        }
    }
}
