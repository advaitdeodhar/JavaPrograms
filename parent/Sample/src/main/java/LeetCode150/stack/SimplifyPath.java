package LeetCode150.stack;

import java.util.Stack;

class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();

        String[] parts = path.split("/");

        StringBuilder sb = new StringBuilder();
        for ( String part : parts ) {

            if (part.isEmpty() || part.equals(".")) {
                continue;
            }

            if ( part.equals("..")) {
                if ( !st.isEmpty() ) {
                    st.pop();
                }

            } else {
                st.push(part);
            }

        }

        while ( !st.isEmpty() ) {
            sb.insert(0, st.pop());
            sb.insert(0,"/");
        }

        if (sb.isEmpty()) {
            sb.append("/");
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        SimplifyPath s = new SimplifyPath();
        System.out.println(s.simplifyPath("/../"));
    }
}