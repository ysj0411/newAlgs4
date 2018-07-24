
public class CC {
     private boolean[] marked;
     private int[] id;//同一连通分量索引相同，相当于一个集合，一个子图
     private int count;//连通分量数
     public CC(Graph G){
    	 marked=new boolean[G.V()];
    	 id = new int[G.V()];
    	 for ( int s=0; s<G.V();s++)
    		 if(!marked[s]){//从各个子图的顶点开始循环
    			 dfs(G,s);
    			 count++;//从0开始
    		 }
     }
     private void dfs(Graph G,int v){
    	 marked[v]=true;// 又是标记
    	 id[v]=count;//相同的分量
    	 for(int w:G.adj(v))//w遍历v的各个相邻顶点
    		 if(!marked[w])
    			 dfs(G,w);//去标记，直到不能标记为止
     }
     public boolean connected(int v,int w){
    	 return id[v]==id[w];//返回是否相通
     }
     public int id(int v){
    	 return id[v];
     }
     public int count(){
    	 return count;
     }
     
}
