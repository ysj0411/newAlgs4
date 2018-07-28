
public class Digraph {
     private final int V;
     private int E;
     private Bag<Integer>[] adj;
     
     public Digraph(int V){//有向图
    	 this.V=V;
    	 this.E=0;
    	 adj=(Bag<Integer>[]) new Bag[V];//创建一个背包数组
    	 for(int v=0;v<V;v++)
    		 adj[v]=new Bag<Integer>();//构造链接表，每个顶点都有一个
     }
     public int V(){return V;}
     public int E(){return E;}
     public void addEdge(int v,int w){
    	adj[v].add(w);//放入顶点，也就是构造边，两点成边，且唯一，因为是有向图，由出发点确认
    	E++;//边加一
     }
     public Iterable<Integer> adj(int v){
    	 return adj[v];
     }
     public Digraph reverse(){//反向有向图
    	 Digraph R=new Digraph(V);
    	 for(int v=0;v<V;v++)
    		 for(int w:adj(v))
    			 R.addEdge(w, v);
    	 return R;
     }
}
