public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i<strs[0].length()) {
            char ch = strs[0].charAt(i);
            boolean allMatch = true;
            for (String str : strs) {
                if (str.length() >= i + 1 && str.charAt(i) == ch) continue;
                allMatch = false;
                break;
            }
            if (allMatch) {
                i++;
                builder.append(ch);
            } else break;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"dog", "do", "dog"}));
    }

}
