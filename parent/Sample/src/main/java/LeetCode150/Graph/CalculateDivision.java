package LeetCode150.Graph;

import java.util.*;

class CalculateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, DivNode> porter = new HashMap<>();

        for ( int i = 0 ; i < equations.size(); i++ ) {

            String nr = equations.get(i).get(0);
            String dr = equations.get(i).get(1);

            double value = values[i];

            DivNode nrNode = getDivNode(porter, nr);
            DivNode drNode = getDivNode(porter, dr);

            nrNode.addEdge(dr, value);
            drNode.addEdge(nr, 1.0/value);

        }


        int ansSize = queries.size();

        double[] ans = new double[ansSize];

        int i = 0;
        for ( List<String> query : queries ) {

            String nr = query.get(0);
            String dr = query.get(1);

            if ( porter.get(nr) == null || porter.get(dr) == null ) {
                ans[i++] = -1.0;
                continue;
            }

            double div = getDiv( nr, dr, porter);
            ans[i++] = div;


        }

        return ans;

    }

    private double getDiv(String nr, String dr, Map<String, DivNode> porter) {

        DivNode nrNode = porter.get(nr);

        if ( nrNode.edges.containsKey(dr) ) {
            return nrNode.edges.get(dr);
        }

        Set<String> visited = new HashSet<>();

        Queue<DivNode> q = new ArrayDeque<>();
        q.add(nrNode);

        Queue<Double> a = new ArrayDeque<>();
        a.add(1.0);


        while ( !q.isEmpty() ) {

            DivNode node = q.poll();
            double ans = a.poll();

            if ( visited.contains(node.name) ) {
                continue;
            }

            for ( Map.Entry<String, Double> entry : node.edges.entrySet()) {

                if ( entry.getKey().equals(dr) ) {
                    return ans * entry.getValue();
                }

                q.add(porter.get(entry.getKey()));
                a.add(ans * entry.getValue());
            }

            visited.add(node.name);

        }

        return -1.0;

    }

    private DivNode getDivNode(Map<String, DivNode> porter, String name) {

        DivNode requestedNode = porter.get(name);

        if ( requestedNode != null ) {
            return requestedNode;
        }

        requestedNode = new DivNode(name);
        porter.put(name, requestedNode);

        return requestedNode;
    }

    public static class DivNode {

        String name;
        Map<String, Double> edges;

        DivNode(String id) {
            name = id;
            edges = new HashMap<>();
        }

        void addEdge(String dr, double value) {
            edges.put(dr, value);
        }

    }
}
