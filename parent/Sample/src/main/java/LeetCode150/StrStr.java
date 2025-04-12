package LeetCode150;

import java.util.ArrayList;
import java.util.List;

class StrStr {
    public int strStr(String text, String pattern) {

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


        int n = text.length();

         i = 0 ;
         int j = 0 ;

         List<Integer> found = new ArrayList<>();

         while ( i < n ) {

             if ( text.charAt(i) == pattern.charAt(j) ) {
                 i++;
                 j++;

                 if ( j == size ) {
                     found.add(i-j);
                     j = prefix[j-1];
                 }

             } else {
                 if ( j != 0 ) {
                     j = prefix[j-1];
                 } else {
                     i++;
                 }
             }

         }

         return  found.isEmpty() ? -1 :  found.get(0);

    }


    public static void main(String[] args) {

        StrStr s = new StrStr();

        System.out.println(s.strStr("sadbutsad", "sad"));
    }
}
