import java.util.*;

public class Lexicography {

    public static String findLexSmallestString(String s, int a, int b) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.add(s);
        visited.add(s);
        String min = s;
        while(!queue.isEmpty()) {
            String front = queue.poll();
            min = min.compareTo(front)>0?front:min;
            String op1 = applyOp1(front, a);
            String op2 = applyOp2(front, b);
            if(!visited.contains(op1)) {
                queue.add(op1);
                visited.add(op1);
            }
            if(!visited.contains(op2)){
                queue.add(op2);
                visited.add(op2);
            }
        }
        return min;
    }

    public static String applyOp1(String s, int a) {
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<s.length();i++) {
            if (i%2==1) builder.append((Integer.parseInt(String.valueOf(s.charAt(i)))+a)%10);
            else builder.append(s.charAt(i));
        }
        //System.out.println("op1 : " + s + " : " + builder.toString());
        return builder.toString();
    }

    public static String applyOp2(String s, int b) {
        char[] builder = new char[s.length()];
        for (int i=0;i<s.length();i++) {
            builder[(i+b)%s.length()] = s.charAt(i);
        }
        String result = String.join("", String.valueOf(builder));
        //System.out.println("op2 : " + s + " : " + result);
        return result;
    }

    private int compareLexicographically(String str1, String str2) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(findLexSmallestString("5525", 9, 2));
        //System.out.println(applyOp2("5525", 2));
    }


}
