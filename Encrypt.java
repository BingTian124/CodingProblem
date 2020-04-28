import java.util.ArrayList;
import java.util.*;

public class Encrypt {
    public static void main(String args[]){
        String s = "if ";
        System.out.println(encrypt(s));

    }
    public static String encrypt(String s){
        // The basic idea is extract the words in s, then calculate the sqrt of the length (truncate the decimal
        // part only remain the integer part) to decide the dimension to store the string. Put the string into such
        // a dimension area, then read by columns and out put the final encrypt result.
        //Time complexity is O(n), n represents the length of string s. Space complexity is O(n).

        //Remove the space in s and get the length of the string
        StringBuilder sb = new StringBuilder();
        String[] seg = s.split("[ ]+");
        for (String str : seg){
            if (str != ""){
                sb.append(str);
            }
        }
        int len = sb.length();
        //Do the sqrt operation and decide the dimension of the matrix to store the string
        int low = sqrt(len);
        int up = low+1;
        if (low*low == len){
            up = low;
        }
        if (low*up < len){
            low = up;
        }
        //First encrypt the string to list res according to the dimension mentioned above
        List<String> res = new ArrayList<>();
        int lastLine = 0;
        for (int i = 0; i<len; i+=up){
            if (i+up > len-1){
                res.add(sb.substring(i));
                lastLine = sb.substring(i).length();//Record the length of the last line
            }else{
                res.add(sb.substring(i, i+up));
            }
        }
        //Next read the final result by columns
        StringBuilder result = new StringBuilder();
        for (int col = 0; col<up; col++){
            StringBuilder vertical = new StringBuilder();
            for (int row = 0; row<low; row++){
                if (col>lastLine-1 && row == low-1){//If the col is beyond the length of last line
                    continue;                       //&& at the last line, we do nothing but continue
                }else{
                    vertical.append(res.get(row).charAt(col));
                }
            }
            vertical.append(" ");
            result.append(vertical);
        }
        return result.toString();
    }
    public static int sqrt(int x){
        if (x == 0) return 0;
        if (x == 1) return 1;
        long l = 1, r = x;
        while (l<r) {
            long mid = l+(r-l+1)/2;
            if (mid*mid <= x){
                l = mid;
            }else{
                r = mid-1;
            }
        }
        return (int) l;
    }

}
