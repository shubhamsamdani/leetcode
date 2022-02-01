// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    private static int[][] getGrap(ArrayList<ArrayList<ArrayList<Integer>>> adj, int V){
        int[][] graph = new int[V][V];
        for(int i = 0; i < adj.size(); i++){
            ArrayList<ArrayList<Integer>> edges = adj.get(i);
            for(ArrayList<Integer> e : edges){
                graph[i][e.get(0)] = e.get(1);
                //graph[e.get(0)][i] = e.get(1);
            }
        }
        
        return graph;
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        int[][] graph = getGrap(adj,V);
        boolean[] visited = new boolean[V];
        int[] dist = new int[V];
        
        for(int i = 0; i < V; i++){
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
        }
        
        //visited[S] = true;
        dist[S] = 0;
        
        
        for(int count = 0; count < V-1; count++){
            int minIdx = getMinDistance(V, dist, visited);
            visited[minIdx] = true;
            
            for(int v = 0; v < V; v++){
                if(!visited[v] && graph[minIdx][v] != 0 &&
                    dist[minIdx] != Integer.MAX_VALUE &&
                    dist[minIdx] + graph[minIdx][v] < dist[v]){
                    dist[v] = dist[minIdx] + graph[minIdx][v];
                }
            }
        }
        return dist;
    }
    
    private static int getMinDistance(int V, int[] dist, boolean[] visited){
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i = 0; i < V; i++){
            if(!visited[i] && dist[i] < min){
                min = dist[i];
                index = i;
            }
        }
        //System.out.println("min is: " + index);
        return index;
    }
}

