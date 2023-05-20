class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Map<String,Double>> graph = buildGraph(equations, values);
        double[] res = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            List<String> query = queries.get(i);
            
            String src = query.get(0);
            String dest = query.get(1);
            
            if(src.equals(dest)){
                if(graph.containsKey(src)){
                    res[i] = 1.0;
                } else{
                    res[i] = -1.0;
                }
                
                continue;
            }
            
            Set<String> visited = new HashSet<String>();
            double ans = dfs(graph,src,dest,visited);
            res[i] = ans;
        }
        
        return res;
    }
    
    private double dfs(Map<String, Map<String,Double>> graph, String src, String dest, Set<String> visited ){
        Map<String,Double> m1 = graph.get(src);
        if(m1 == null){
            return -1.0;
        }
        
        visited.add(src);
        
        if(m1.containsKey(dest)){
            return m1.get(dest);
        }
        
        for(Map.Entry<String,Double> m : m1.entrySet()){
            String key = m.getKey();
            if(!visited.contains(key)){
                double ans = dfs(graph,key,dest,visited);
                
                if(ans != -1.0){
                    return ans * m.getValue();
                }
            }
        }
        
        return -1.0;
    }
    
    private Map<String,Map<String,Double>> buildGraph(List<List<String>> equations, double[] values){
        Map<String,Map<String,Double>> graph = new HashMap<>();
        
        int i = 0;
        for(List<String> eq : equations){
            String src = eq.get(0);
            String dest = eq.get(1);
            double val = values[i];
            
            Map<String,Double> m1 = graph.getOrDefault(src,new HashMap<>());
            m1.put(dest,val);
            
            graph.put(src,m1);
            
            Map<String,Double> m2 = graph.getOrDefault(dest,new HashMap<>());
            m2.put(src,1/val);
            
            graph.put(dest,m2);
            
            i++ ;
        }
        
        return graph;
    }
}