package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Helps to map words for sorted representations
        Map<String, List<String>> answerHelper = new HashMap<>();

        // Answer
        List<List<String>> answer = new ArrayList<>();

        for ( String word : strs ) {

            // Get the sorted representation
            String representation = getRepresentation(word);

            // Add the word for the identified representation. It is possible that same representation
            // is already found , so it needs to add it in the value list.
            List<String> sameRep = answerHelper.get(representation);
            if ( sameRep == null ) {
                sameRep = new ArrayList<String>();
                answerHelper.put(representation, sameRep);
            }
            sameRep.add(word);

        }

        // Gather all the values to return
        for ( Map.Entry<String, List<String>> entry : answerHelper.entrySet() ) {
            answer.add(entry.getValue());
        }

        return answer;

    }

    public String getRepresentation(String word) {

        // counters for all alphabets;
        int[] counts = new int[26];

        // increment occurance of each alphabet in the counts array.
        for ( int i = 0; i < word.length() ; i++ ) {
            counts[word.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        // Create a string using string builder by appending chars from 'a' to 'z'
        // using the counts array
        for ( int i = 0 ; i < 26; i++ ) {
            for ( int j = 0 ; j < counts[i]; j++ ) {
                sb.append('a' +  i);
            }
        }

        return sb.toString();

    }
}