
public class DirectedCycle {//directed定向的。
	private boolean[] marked;//标记
	private int[] edgeTo;//父顶点，即指向当前点的顶点
	private Stack<Integer> cycle;//栈，因为放入栈后取出会使方向改变，所以可以检测环，相同则环存在，如v-w,如果有环，则w-v放入栈后，取出则为v-w相等
	private boolean[] onStack;//递归调用栈上所有顶点。
	
	public DirectedCycle(Digraph G)
	{
		onStack=new boolean[G.V()];
		edgeTo=new int[G.V()];
		marked =new boolean[G.V()];
		for(int v=0;v<G.V();v++)
			if(!marked[v]) dfs(G,v);//如果未标记当前点，则开始递归
			
		
	}
	private void dfs(Digraph G,int v)
	{
		onStack[v]=true;//标记
        marked[v]=true;
        for(int w:G.adj(v))//v指向的顶点
        	if(this.hasCycle()) return;//如果有环退出循环
        	else if(!marked[w])//当前顶点如果没标记，则深度查询.且不用放入栈中
        	{	edgeTo[w]=v;dfs(G,w);} 
        	else if(onStack[w])//如果已经被标记过，且不再栈中
        	{
        		cycle=new Stack<Integer>();
        		for(int x=v;x!=w;x=edgeTo[x])
        			cycle.push(x);//把当前点插入有向环，一直遍历到已经被标记的那个顶点
        		
        		cycle.push(w);
        		cycle.push(v);
        	}
        onStack[v]=false;//如果未被标记，则记为false
        	
	
	}
	public boolean hasCycle(){
		return cycle!=null;
	}
	public Iterable<Integer> cycle(){
		return cycle;
	}
}
