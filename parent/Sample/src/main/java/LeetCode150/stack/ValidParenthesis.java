package LeetCode150.stack;

import java.util.HashMap;
import java.util.Stack;

class ValidParenthesis {
    public boolean isValid(String s) {

        HashMap<Character, Character> mapping  = new HashMap<>();
        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');

        Stack<Character> st = new Stack<>();
        Character t;
        for ( Character ch : s.toCharArray()) {

            switch (ch) {
                case '(':
                case '[':
                case '{':
                    st.push(ch);
                    break;
                case ')':
                case ']':
                case '}':
                    if ( st.isEmpty() ) {
                        return false;
                    }
                    t = st.pop();
                    if ( t != mapping.get(ch)) {
                        return false;
                    }
            }
        }

        return st.isEmpty();
    }
}
