package chapter1;

import java.util.Arrays;

/**
 * Created by Assulan on 4/23/2017.
 */
// O(n logn)
public class Challenge1_8 {
    public static boolean isRotation(String s1, String s2){
        if (s1.length() != s2.length()) return false;
        s1 += s1;
        return s1.contains(s2);
    }

    public static void main(String[] args){
        System.out.println(isRotation("hello", "lohel"));
    }
}
