import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Graph {//图表；即图
	private final int V;  //局部变量，代表的是顶点数，final指的是只能赋值一次
    private int E;//边
    private Bag<Integer>[] adj;//背包数组，即为邻接表
    public Graph(int V){
    	this.V=V;this.E=0;
    	adj=(Bag<Integer>[]) new Bag[V];
    	for (int v=0;v<V;v++)
    		adj[v]=new Bag<Integer>();//adj[v]就是这个背包数组，就是邻接表
    }
    public Graph(In in){
    	this(in.readInt());// 读取V使图初始化
    	int E=in.readInt();//读取E
    	for(int i=0; i<E;i++){//添加边，循环次数为边的数量，此方法是接受了图，只知道总边数和总顶点数
    		int v=in.readInt();//读取一个顶点，因为给的数据时顶点对，所以需要自己构造图
    		int w=in.readInt();//读取另一个顶点
    		addEdge(v,w);//添加他们的边
    	}
    	
    }
    public int V() {return V;}//
	public int E() {return E;}//
    public void addEdge(int v,int w){//
    	adj[v].add(w);//将这w顶点添加到v顶点的链表中，下面反之
    	adj[w].add(v);//
    	E++;//边加一，因为每次都用到两次边所以只要加一
    }
    public Iterable<Integer> adj(int v){
    	return adj[v];
    }
    public static void main(String[] args) {
        In in = new In(args[0]);//
        Graph G = new Graph(in);//
        StdOut.println(G);
    }  	
}
