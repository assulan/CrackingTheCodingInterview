package chapter1;

import java.util.HashMap;

/**
 * Created by Assulan on 4/18/2017.
 */
public class Challenge1_1 {
    public boolean hasUniqueChars(String s){
        s = s.toLowerCase();
        if (s.length() == 0) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if (map.containsKey(c)) return false;
            map.put(c, 1);
        }
        return true;
    }

    // Assume all chars are lower case ASCII
    public boolean hasUniqueChars2(String s){
        s = s.toLowerCase();
        if (s.length() == 0) return false;
        int checker = 0; // bit array
        for(int i = 0; i < s.length(); i++){
            int val = s.charAt(i) - (int)'a';
            // bitwise end
            if ((checker & (1 << val)) > 0) return false;
            checker = checker | (1 << val);
        }
        return true;
    }

    public static void main(String[] args){
        Challenge1_1 challenge = new Challenge1_1();
        System.out.println(challenge.hasUniqueChars(""));
        System.out.println(challenge.hasUniqueChars("a"));
        System.out.println(challenge.hasUniqueChars("helo"));
        System.out.println(challenge.hasUniqueChars("hello"));
        System.out.println(challenge.hasUniqueChars2("hello"));
        System.out.println(challenge.hasUniqueChars2("helo"));
    }
}
