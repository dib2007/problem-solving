import java.util.*;

public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Edge>> adjacency = new HashMap<>();
        int i = 0;
        for (List<String> equation : equations) {
            adjacency.putIfAbsent(equation.get(0), new ArrayList<>());
            adjacency.get(equation.get(0)).add(new Edge(equation.get(1), values[i]));
            adjacency.putIfAbsent(equation.get(1), new ArrayList<>());
            adjacency.get(equation.get(1)).add(new Edge(equation.get(0), 1 / values[i]));
            i++;
        }
        double[] result = new double[queries.size()];
        for (int j = 0; j < queries.size(); j++) {
            result[j] = findPathWeight(adjacency, queries.get(j).get(0), queries.get(j).get(1));
        }
        return result;
    }

    private double findPathWeight(Map<String, List<Edge>> adjacency, String start, String end) {
        Set<String> visited = new HashSet<>();
        return findPathWeightInternal(adjacency, start, end, visited, 1);
    }

    private double findPathWeightInternal(Map<String, List<Edge>> adjacency, String start, String end, Set<String> visited, double currentCost) {
        if (start.equals(end) && adjacency.get(start) != null) return currentCost;
        List<Edge> edges = adjacency.get(start);
        if (edges != null)
            for (Edge edge : edges) {
                if (!visited.contains(edge.target)) {
                    visited.add(edge.target);
                    double cost = findPathWeightInternal(adjacency, edge.target, end, visited, currentCost * edge.weight);
                    if (cost != -1) return cost;
                }
            }
        return -1;
    }


    static class Edge {
        String target;
        double weight;

        public Edge(String target, double weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        EvaluateDivision ed = new EvaluateDivision();
        List<String> strs1 = new ArrayList<>();
        List<String> strs2 = new ArrayList<>();
        strs1.add("a");
        strs1.add("b");
        strs2.add("b");
        strs2.add("c");
        double[] values = new double[]{2.0, 3.0};
        List<List<String>> lists = new ArrayList<>();
        lists.add(strs1);
        lists.add(strs2);
        List<List<String>> queries = new ArrayList<>();
        List<String> q1 = new ArrayList<>();
        List<String> q2 = new ArrayList<>();
        List<String> q3 = new ArrayList<>();
        List<String> q4 = new ArrayList<>();
        List<String> q5 = new ArrayList<>();
        q1.add("a");
        q1.add("c");
        q2.add("b");
        q2.add("a");
        q3.add("a");
        q3.add("e");
        q4.add("a");
        q4.add("a");
        q5.add("x");
        q5.add("x");
        queries.add(q1);
        queries.add(q2);
        queries.add(q3);
        queries.add(q4);
        queries.add(q5);
        System.out.println(Arrays.toString(ed.calcEquation(lists, values, queries)));
    }
}
