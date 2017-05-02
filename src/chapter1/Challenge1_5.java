package chapter1;

/**
 * Created by Assulan on 4/23/2017.
 */
public class Challenge1_5 {
    // Assume ASCII string
    public static String compress(String s){
        char[] s2 = new char[s.length()];
        int index = 0;
        int count = 1;
        char last = s.charAt(0);
        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i) == last){
                count++;
            }
            else{
                if (index > s.length()-1) return s;
                s2[index++] = last;
                char[] nums = String.valueOf(count).toCharArray();
                for(int j = 0; j < nums.length; j++){
                    if (index > s.length()-1) return s;
                    s2[index++] = nums[j];
                }
                count = 1;
                last = s.charAt(i);
            }
        }
        if (index > s.length()-1) return s;
        s2[index++] = last;
        char[] nums = String.valueOf(count).toCharArray();
        for(int j = 0; j < nums.length; j++){
            if (index > s.length()-1) return s;
            s2[index++] = nums[j];
        }
        s2[index] = '\0';
        String result = new String(s2);
        return result;

    }

    public static void main(String[] args){
        System.out.println(compress("aabbccc"));
        System.out.println(compress("abc"));
        System.out.println(compress("a"));
        System.out.println(compress("aaaab"));
    }
}
