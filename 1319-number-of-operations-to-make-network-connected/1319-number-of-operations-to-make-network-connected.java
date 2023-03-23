class Solution {
    public int makeConnected(int n, int[][] conn) {
        boolean visited[] = new boolean[n];
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        
        int edgeCount = 0;
        for(int i = 0; i < conn.length; i++){
            edgeCount++ ;
            int first = conn[i][0];
            int sec = conn[i][1];
            
            List<Integer> nodes = graph.get(first);
            nodes.add(sec);
            
            List<Integer> nodes1 = graph.get(sec);
            nodes1.add(first);
        }
        
        if(edgeCount < n - 1){
            return -1;
        }
        
        
        int count = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                count++ ;
                //System.out.println("i is: " + i);
                dfs(graph,visited,i);
            }
        }
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                count++ ;
            }
        }
        
        return count - 1;
    }
    
    private void dfs(List<List<Integer>> graph, boolean[] visited, int i){
        visited[i] = true;
        for(int node : graph.get(i)){
            if(!visited[node]){
                dfs(graph,visited,node);
            }
        }
    }
}