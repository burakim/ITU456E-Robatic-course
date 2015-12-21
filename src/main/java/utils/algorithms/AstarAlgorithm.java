package utils.algorithms;

import model.Node;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Created by BurakMac on 21/12/15.
 */
public class AstarAlgorithm {

    private PriorityQueue<Node> priorityQueue;
    private HashMap<Node,Node> came_from = new HashMap<>();
    private HashMap <Node, Integer> cost_so_far = new HashMap<>();

    public Stack<Node> Search(Node beginingNode, Node goal)
    {
        Stack<Node> path = new Stack<>();
        Comparator<Node> comparator = new NodeComparator();

        priorityQueue  = new PriorityQueue<Node>(10,comparator);
        priorityQueue.add(beginingNode);
        came_from.put(beginingNode,null);
        cost_so_far.put(beginingNode,0);

        while (priorityQueue.size()!=0){
            Node current = priorityQueue.remove();
            if(current == goal)
            {
                Node searched = goal;
                while(came_from.get(searched) != null)
                {
                    path.add(came_from.get(searched));
                    searched = came_from.get(searched);
                }
                System.out.print("dklajsda");
                break;
            }
            for(Node child: current.getChildren() ) {
                if (child != null) {
                    int new_cost = cost_so_far.get(current) + 1;
                    if (!(cost_so_far.keySet().contains(child)) || (new_cost < cost_so_far.get(child))) {
                        cost_so_far.put(child, new_cost);
                        int priority = new_cost + 0;
                        child.setCost(priority);
                        priorityQueue.add(child);
                        came_from.put(child, current);
                    }
                }
            }
        }
        return path;
    }

    public class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node x, Node y) {
            // Assume neither string is null. Real code should
            // probably be more robust
            // You could also just return x.length() - y.length(),
            // which would be more efficient.
            if (x.getCost() < y.getCost()) {
                return -1;
            }
            if (x.getCost() > y.getCost()) {
                return 1;
            }
            return 0;
        }
    }
}
