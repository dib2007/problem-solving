import java.util.*;

public class FindRoot {

    private static class Node {
        int data;
        Integer left;
        Integer right;
        Integer parent;

        public Node(int data, Integer left, Integer right, Integer parent) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }

    public static int findRoot(List<List<Integer>> nodes) {
        // Write your code here
        Map<Integer, Node> nodeMap = new HashMap<>();
        nodeMap.put(nodes.get(0).get(0), new Node(nodes.get(0).get(0), nodes.get(0).get(1), nodes.get(0).get(2), null));
        Node parent = nodeMap.get(nodes.get(0).get(0));
        for (int i=1;i<nodes.size();i++) {
            if(nodeMap.containsKey(nodes.get(i).get(0))) {
                nodeMap.get(nodes.get(i).get(0)).parent = parent.data;
            } else {
                nodeMap.put(nodes.get(i).get(0), new Node(nodes.get(0).get(0), nodes.get(0).get(1), nodes.get(0).get(2), parent.data));
            }
        }
        Node root = null;
        int rootCount = 0;
        for (Node node : nodeMap.values()) {
            if(node.parent == null) {
                rootCount++;
                root = node;
            }
        }
        if(rootCount != 1) {
            return -1;
        }
        List<Integer> result = new ArrayList<>();
        preOrder(root, nodeMap, result, new HashSet<>());
        if(result.size() < nodes.size()) return -1;
        int prev = result.get(0);
        for (int i=1;i<result.size();i++) {
            if(prev>result.get(i)) return -1;
            prev = result.get(i);
        }
        return root.data;
    }

    private static void preOrder(Node node, Map<Integer, Node> nodeMap, List<Integer> result, Set<Integer> trav) {
        if(node.left != null && node.left != -1) {
            preOrder(nodeMap.get(node.left), nodeMap, result, trav);
        }
        if(trav.contains(node.data)) return;
        result.add(node.data);
        trav.add(node.data);
        if(node.right != null && node.right != -1) {
            preOrder(nodeMap.get(node.right), nodeMap, result, trav);
        }
    }

    public static void main(String[] args) {
    }
}
