public class Encrypt {
    public static void main(String args[]){
        String s = "if man was meant to stay on the ground god would have given us roots";
        Encrypt encrypt = new Encrypt();
        System.out.println(encrypt.encrypt(s));

    }
    public String encrypt(String s){
        // The basic idea is to count the letters in s, then calculate the sqrt of the length (truncate the decimal
        // part only remain the integer part) to decide how many columns to store the string. Each column is a bucket
        // to store the corresponding column letters. Finally we just join the string in each bucket together to get the final string.
        //Time complexity is O(n), n represents the length of string s. Space complexity is O(n).

        // Count total letters and decide the number of buckets
        int totalLetters = countCharacters(s);
        int root = (int) Math.sqrt(totalLetters);
        int bucket = root + 1;
        if (root*root == totalLetters) {
            bucket = root;
        }
        StringBuilder[] cols = new StringBuilder[bucket];
        //Use a count to mark the index of each letter, then calculate idx as a marker to decide which bucket should the letter go.
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isAlphabetic(c)) {
                continue;
            }
            int idx = count%bucket;
            if (cols[idx] == null) {
                cols[idx] = new StringBuilder();
            }
            cols[idx].append(c);
            count++;
        }
        //Sum each bucket up to get the final string
        StringBuilder res = new StringBuilder();
        for (int i = 0; i< cols.length; i++) {
            if (i == cols.length-1){
                res.append(cols[i].toString());
            }else{
                res.append(cols[i].toString());
                res.append(" ");
            }
        }
        return res.toString();
    }

    private int countCharacters(final String s) {
        if (s == null) return 0;
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i))) {
                total++;
            }
        }
        return total;
    }

}
