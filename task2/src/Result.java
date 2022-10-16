public class Result {
    public static int getMinSubsequences(String input_str) {
        // Write your code here
        int count=0;
        int i=1;
        if (i < input_str.length()) do {
            System.out.println(input_str.charAt(1) + " ");
            if (input_str.charAt(i) == input_str.charAt(i - 1)) count = count + 1;
            i++;
        } while (i < input_str.length());
        count++;
        System.out.println(count);
        return count;
    }
}
