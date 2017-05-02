package chapter1;

/**
 * Created by Assulan on 4/19/2017.
 */
public class Challenge1_4 {
    public static void replaceSpaces2(char[] s, int n){
        int count = 0;
        for (int i = 0; i < n; i++){
            if (s[i] == ' ') count++;
        }
        int index = count*2 + n - 1;
        for (int i = n-1; i >= 0; i--){
            if (s[i] == ' '){
                s[index] = '0';
                s[index-1] = '2';
                s[index-2] = '%';
                index -= 3;
            }
            else{
                s[index] = s[i];
                index -= 1;
            }
        }
    }

    public static char[] replaceSpaces(char[] s, int n){
        int count = 0;
        for (int i = 0; i < n; i++){
            if (s[i] == ' ') count++;
        }
        int index = count*2 + n - 1;
        for (int i = n-1; i >= 0; i--){
            if (s[i] == ' '){
                s[index] = '0';
                s[index-1] = '2';
                s[index-2] = '%';
                index -= 3;
            }
            else{
                s[index] = s[i];
                index -= 1;
            }
        }
        return s;
    }

    public static void main(String[] args){
        char[] s = {'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'a', ' ', 'b', ' ', ' ', ' ', ' ', ' ', ' '};
        System.out.println(s);
        s = replaceSpaces(s, 11);
        System.out.println(s);
        char[] s2 = {' ', ' ', ' '};
        s2 = replaceSpaces(s2, 1);
        System.out.println(s2);
        char[] s3 = {'a', ' ', 'b', ' ', ' '};
        replaceSpaces2(s3, 3);
        System.out.println(s3);
    }
}
