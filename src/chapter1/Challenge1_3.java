package chapter1;

import java.util.Arrays;

/**
 * Created by Assulan on 4/19/2017.
 */
public class Challenge1_3 {
    public String sortAlphabetically(String s){
        char [] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public boolean isPermutation(String s1, String s2){
        if (s1.length() != s2.length()) return false;
        s1 = sortAlphabetically(s1);
        s2 = sortAlphabetically(s2);
        return s1.equals(s2);
    }

    // Assume ASCII, thus 256 characters
    public int[] frequencies(String s){
        int num_ascii = 256;
        int [] freq = new int[num_ascii];
        for (int i = 0; i < s.length(); i++){
            int index = (int) s.charAt(i);
            freq[index]++;
        }
        return freq;
    }

    // count character occurrences
    // Assume ASCII, thus 256 characters
    public boolean isPermutation2(String s1, String s2){
        if (s1.length() != s2.length()) return false;
        int [] freq1 = frequencies(s1);
        int [] freq2 = frequencies(s2);
        for (int i = 0; i < freq1.length; i++){
            if (freq1[i] != freq2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args){
        Challenge1_3 challenge = new Challenge1_3();
        System.out.println(challenge.isPermutation("abc", "bac"));
        System.out.println(challenge.isPermutation("abc", "bac "));
        System.out.println(challenge.isPermutation("abc", "bacd"));

        System.out.println(challenge.isPermutation2("abc", "bac"));
        System.out.println(challenge.isPermutation2("abc", "bac "));
        System.out.println(challenge.isPermutation2("abc", "bacd"));
    }
}
