import java.util.Arrays;

public class DIStringMatching {
    public static int[] diStringMatch(String S) {
        int[] arr = new int[S.length()+1];
        int i = 0;
        int c = S.length();
        int c1 = 0;
        for(char ch : S.toCharArray()) {
            if ('D' == ch) {
                arr[i] = c--;
            } else {
                arr[i] = c1++;
            }
            i++;
        }
        arr[S.length()] = c1;
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(diStringMatch("IDID")));
    }
}
