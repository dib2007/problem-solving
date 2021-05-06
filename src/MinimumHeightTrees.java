import java.util.*;

public class MinimumHeightTrees {

    //https://leetcode.com/problems/minimum-height-trees/submissions/
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges.length == 0) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            return list;
        }
        Map<Integer, List<Node>> degreeMap = new HashMap<>();
        Set<Integer> currentNodes = new HashSet<>();
        for (int[] edge : edges) {
            degreeMap.putIfAbsent(edge[0], new ArrayList<>());
            degreeMap.get(edge[0]).add(new Node(edge[1]));
            degreeMap.putIfAbsent(edge[1], new ArrayList<>());
            degreeMap.get(edge[1]).add(new Node(edge[0]));
            currentNodes.add(edge[0]);
            currentNodes.add(edge[1]);
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        Queue<Integer> tempQueue = new ArrayDeque<>();
        if (currentNodes.size() > 2)
            for (Map.Entry<Integer, List<Node>> entry : degreeMap.entrySet()) {
                if (entry.getValue().size() == 1) {
                    tempQueue.add(entry.getKey());
                    visited.add(entry.getKey());
                    //currentNodes.remove(entry.getKey());
                }
            }
        while(currentNodes.size()>3) {
            queue = tempQueue;
            tempQueue = new ArrayDeque<>();
            while (!queue.isEmpty()) { //TODO here
                //if(queue.isEmpty()) queue = tempQueue;
                int node = queue.poll();
                currentNodes.remove(node);
                List<Node> adjacentNodes = degreeMap.get(node);
                for (Node an : new ArrayList<>(adjacentNodes)) {
                    degreeMap.get(an.id).remove(new Node(node));
                    if (!visited.contains(an.id) && degreeMap.get(an.id).size() == 1) {
                        tempQueue.add(an.id);
                        visited.add(an.id);
                    }
                }
            }
        }

        if (currentNodes.size() == 3) {
            currentNodes.remove(tempQueue.poll());
            currentNodes.remove(tempQueue.poll());
        }
        return new ArrayList<>(currentNodes);
    }

    static class Node {
        int id;

        public Node(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return id == node.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    public static void main(String[] args) {
        findMinHeightTrees(6, new int[][]{{0,1},{0,2}}).forEach(System.out::println);
    }

}
