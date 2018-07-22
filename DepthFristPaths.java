
public class DepthFirstPaths {//dfs,深度优先搜索查找图中的路径
     private boolean[] marked;//标记这个顶点是否被调用过
     private int[] edgeTo;//当前结点的父节点，即上一个顶点
     private final int s;//起点，只能被赋值一次
     public DepthFirstPaths(Graph G, int s){
    	 marked=new boolean[G.V()];
    	 edgeTo= new int[G.V()];
    	 this.s=s;//起点赋值
    	 dfs(G,s);// 递归
    	 
     }
     private void dfs(Graph G,int v){
    	 marked[v]=true;//标记当前顶点
    	 for(int w:G.adj(v))//遍历与当前相邻的顶点
    		 if(!marked[v]) {// 如果为标记
    			 edgeTo[w]=v;//记录父结点
    			 dfs(G,s);// 递归
    		 }
     }
     public boolean hasPathTo(int v){
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
