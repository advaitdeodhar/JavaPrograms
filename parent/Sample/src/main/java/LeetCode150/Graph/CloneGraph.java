package LeetCode150.Graph;


import java.util.*;

class CloneGraph {
    public Node cloneGraph(Node node) {


        if ( node == null ) {
            return null;
        }

        Queue<Node> queue = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();
        queue.add(node);

        Map<Node, Node> porter = new HashMap<>();

        Node retVal = getClonedNode(node, porter);



        while ( !queue.isEmpty() ) {

            Node current = queue.poll();

            if ( visited.contains(current) ) {
                continue;
            }

            Node cloned = porter.get(current);

            for ( Node connection : current.neighbors) {

                Node clonedConnection  = getClonedNode(connection, porter);
                cloned.neighbors.add(clonedConnection);
                queue.add(connection);

            }

            visited.add(current);

        }

        return retVal;

    }

    private Node getClonedNode(Node node, Map<Node, Node> porter) {

        Node cloned = porter.get(node);
        if ( cloned != null ) {
            return cloned;
        }

        cloned = new Node(node.val);

        porter.put(node, cloned);

        return cloned;

    }
}