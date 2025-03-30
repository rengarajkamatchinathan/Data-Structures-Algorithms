import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ToposortKahnsAlg {
    static List<Integer> toposort(ArrayList<ArrayList<Integer>> adj, int V){
        List<Integer> res = new ArrayList<>();
        int indegree[] = new int[V];
        boolean vis[] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        // Trace indegree's
        for(int i=0;i<V;i++){
            for(int j : adj.get(i)){
                indegree[j]++;
            }
        }

        // Put 0 indegree in the queue
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        //Iterate Queue 
        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);

            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        System.out.println(toposort(adj, V));
        
    }
}
