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
    public static int degree(Graph G,int v){//度数，即依附于它的边的总数
    	int degree =0;
    	for(int w:G.adj(v)) degree++;//遍历与它相邻的顶点，即为度数
    	return degree;
    	
    }
    public static int maxDegree(Graph G){//最大度数
    	int max=0;
    	for(int v=0;v<G.V();v++)
    		if(degree(G,v)>max)//各顶点度数比较
    			max=degree(G,v);
    	return max;
    }
    public static double avgDegree(Graph G){
    	return 2.0*G.E()/G.V();//因为两个顶点公用一条边，所以要先乘2
    }
    public static int numberOFSelfLoops(Graph G){//自环数
    	int count = 0;//计数器
    	for(int v=0;v<G.V();v++)
    		for(int w: G.adj(v))
    			if(v==w) count++;//这和添加顶点链表有关，v加到w中，w又加到v中所以自环时就会把边记录两次即v==w，w==v
    	return count/2;
    }
    public String toString(){//用字符串表示图
    	String s=V + " vertics" + E + "edges\n";//几个顶点，几条边
    	for ( int v= 0;v<V;v++)//外循环次数为顶点数
    	{
    		s+=v+" :";//不同顶点显示，举例就是0：下方就是把他相邻的顶点都显示出来
    		for(int w : this.adj(v))//显示与当前顶点相邻的顶点
    			s+=w+"  ";
    		s+="\n";//结果就如0:1 2 3 4 5(：后面为相邻的顶点）。循环为行hang
    	}
    	return s;
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

