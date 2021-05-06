public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        int maxCenter = 0;
        int maxSize = 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<s.length();i++) {
            stringBuilder.append(s.charAt(i));
            if(i!=s.length()-1) stringBuilder.append('_');
        }
        s = stringBuilder.toString();
        System.out.println(s);
        int[] larr=new int[s.length()];
        for (int center=1;center<s.length()-1;center++) {
            int f = center-1;
            int b = center+1;
            int temp = 1;
            while (f>=0 && b<s.length() && s.charAt(f) == s.charAt(b)) {
                if (s.charAt(f) != '_') temp+=2;
                f--;
                b++;
                if(temp>maxSize) {
                    maxCenter = center;
                    maxSize = temp;
                }
            }
            larr[center] = temp;
        }
        System.out.println(maxCenter);
        System.out.println(maxSize);
        System.out.println(s.substring(maxCenter-(maxSize/2), maxCenter+(maxSize/2)+1));
        return s.replace("_", "").substring(maxCenter/2-(maxSize/2), maxCenter/2+(maxSize/2)+1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abb"));
    }
}
