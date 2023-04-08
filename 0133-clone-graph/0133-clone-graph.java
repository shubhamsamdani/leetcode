/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        
        if(node == null){
            return null;
        }
        Node res = new Node(node.val);
        Queue<Node> q = new LinkedList<>();
        HashMap<Node,Node> map = new HashMap<>();
        
        map.put(node,res);
        q.offer(node);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                Node orgNode = q.poll();
                for(Node child : orgNode.neighbors){
                    if(!map.containsKey(child)){
                        Node newChild = new Node(child.val);
                        q.offer(child);
                        map.put(child,newChild);
                    }
                    Node newList = map.get(orgNode);
                    newList.neighbors.add(map.get(child));
                }
            }
        }
          return map.get(node);  
    }
}