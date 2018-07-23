
public class BreadthFirstPaths {
	private boolean[] marked;//又是标记
	private int[] edgeTo;//又是父结点
	private final int s;//又是起点
	
     public BreadthFirstPaths(Graph G, int s){
    	 marked =new boolean[G.V()];//还是构造一个标记的布尔数组，存在为true
    	 edgeTo = new int[G.V()];//父结点
    	 this.s=s;//定义起点
    	 bfs(G,s);//广度搜寻遍历
    	 
    	 
     }
     private void bfs(Graph G, int s){
    	 Queue<Integer> queue=new Queue<Integer>();//创建一个队列，先进先出
    	 marked[s]=true;//标记起点
    	 queue.enqueue(s);//把起点加入队列 
    	 while(!queue.isEmpty()){//如果队列不为空，也就是存在这个起点s
    		 int v= queue.dequeue();// 删去，最开始的点第一次就是s，并把它赋值给v
    		 for(int w:G.adj(v))// 遍历于它相邻的顶点，赋值给w
    			 if(!marked[w]){//如果w没被标记
    				 edgeTo[w]=v;//记录它的父结点
    				 marked[w]=true;//标记它
    				 queue.enqueue(w);//加入队列，递归
    				 
    			 }
    	 }
    	
    	 
     }
     public boolean hasPathTo(int v){//与起点是否连通
		 return marked[v];
	 }
     public Iterable<Integer> pathTo(int v){
    	 if(!hasPathTo(v)) return null;
    	 Stack<Integer> path = new Stack<Integer>();//构造栈
    	 for(int x=v;x!=s;x = edgeTo[x])//获取当前的要输出的路径的终点
    		 path.push(x);//把当前结点压入栈，接着压入父结点，一直压到起点
    	 path.push(s);// 压入起点
    	 return path;//返回栈
    		 
     }
     
	 
}
