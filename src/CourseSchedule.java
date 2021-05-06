import java.util.*;

public class CourseSchedule {

    //https://leetcode.com/problems/course-schedule/

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int[] dep : prerequisites) {
            adjacencyList.putIfAbsent(dep[0], new ArrayList<>());
            adjacencyList.get(dep[0]).add(dep[1]);
        }
        Set<Integer> visited = new HashSet<>();
        Set<Integer> path = new HashSet<>();
        for(int node : adjacencyList.keySet()) {
            if(!visited.contains(node) && hasCycle(adjacencyList, node, visited, path)) return false;
        }
        return true;
    }

    private static boolean hasCycle(Map<Integer, List<Integer>> adjacencyList, int node, Set<Integer> visited, Set<Integer> path) {
        if (path.contains(node)) return true;
        if (visited.contains(node)) return false;
        if (!adjacencyList.containsKey(node)) return false;
        path.add(node);
        for (int child : adjacencyList.get(node)) {
            if(hasCycle(adjacencyList, child, visited, path)) return true;
        }
        visited.add(node);
        path.remove(node);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canFinish(5, new int[][]{{1,0}, {0,2}}));
    }

}
