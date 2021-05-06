import java.util.*;

public class LonPressedName {

    public static boolean isLongPressedName(String name, String typed) {
        List<Node> nameCharCountList = new ArrayList<>();
        List<Node> typedCharCountList = new ArrayList<>();

        char prevChar = name.charAt(0);
        int count = 0;
        for (int i=0;i<name.length();i++) {
            if (prevChar == name.charAt(i)) {
                count++;
            } else {
                nameCharCountList.add(new Node(prevChar, count));
                count = 1;
            }
            prevChar = name.charAt(i);
        }
        nameCharCountList.add(new Node(prevChar, count));
        prevChar = typed.charAt(0);
        count = 0;
        for (int i=0;i<typed.length();i++) {
            if (prevChar == typed.charAt(i)) {
                count++;
            } else {
                typedCharCountList.add(new Node(prevChar, count));
                count = 1;
            }
            prevChar = typed.charAt(i);
        }
        typedCharCountList.add(new Node(prevChar, count));
//        System.out.println(nameCharCountList);
//        System.out.println(typedCharCountList);
        if (nameCharCountList.size() != typedCharCountList.size()) return false;
        for (int i = 0;i<nameCharCountList.size();i++) {
            if(nameCharCountList.get(i).ch != typedCharCountList.get(i).ch
                    || nameCharCountList.get(i).count > typedCharCountList.get(i).count)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isLongPressedName("a", "b"));
    }

    public static class Node {
        char ch;
        int count;

        Node(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "ch=" + ch +
                    ", count=" + count +
                    '}';
        }
    }
}
