/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amazon;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author keyur
 */
public class DuplicateWordsInSentence {

    public static void main(String[] args) {
        String test = "This sentence contains two words, one and two";
        Set<String> duplicates = duplicateWords(test);
        System.out.println("input : " + test);
        System.out.println("output : " + duplicates);

        test = "he had Had quite enough of this nonsense";
        duplicates = duplicateWords(test);
        System.out.println("input : " + test);
        System.out.println("output : " + duplicates);
        
        test = "he had had quite enough of this nonsense";
        String firstRepeated = firstRepeatedWord(test);
        System.out.println("input : " + test);
        System.out.println("output : " + firstRepeated);
    }

    /**
     * * Method to find duplicate words in a Sentence or String * @param input
     * String * @return set of duplicate words
     */
    public static Set<String> duplicateWords(String input) {
        if (input == null || input.isEmpty()) {
            return Collections.emptySet();
        }
        Set<String> duplicates = new HashSet<>();
        String[] words = input.split("\\s+");
        Set<String> set = new HashSet<>();
        for (String word : words) {
            if (!set.add(word)) {
                duplicates.add(word);
            }
        }
        return duplicates;
    }
    
    public static String firstRepeatedWord(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        String[] words = input.split("\\s+");
        Set<String> set = new HashSet<>();
        for (String word : words) {
            if (!set.add(word)) {
                return word;
            }
        }
        return null;
    }
}
