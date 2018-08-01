
public class DepthFirstOrder {
      private boolean marked[];
      private Queue<Integer> pre;
      private Queue<Integer> post;
      private Stack<Integer> reversePost;
      
      public DepthFirstOrder(Digraph G){
    	  pre        =new Queue<Integer>();
    	  post       =new Queue<Integer>();
    	  reversePost=new Stack<Integer>();
          marked =new boolean[G.V()];
          
          for(int v=0;v<G.V();v++)
        	  if(!marked[v]) dfs(G,v); 
       }
      private void dfs(Digraph G,int v){
    	  pre.enqueue(v);//调用前的顺序，顶点加入队列
    	  
    	  marked[v]=true;
    	  for(int w:G.adj(v))
    		  if(!marked[w]) dfs(G,w);
    	  
    	  post.enqueue(v);//顶点调用后的顺序，顶点加入队列
          reversePost.push(v); //放入栈，即调用后顺序的逆顺序
      }
      public Iterable<Integer> pre(){
    	  return pre;
      }
      public Iterable<Integer> post(){
    	  return post;
      }
      public Iterable<Integer> reversePost(){
    	  return reversePost;
      }
        
}
