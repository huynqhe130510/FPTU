
public class Graph {
    
    //number of vertexs
    int n;
    //Adjacency matrix
    int [][]a;
    char [] vertex = "ABCDEFGHIJK".toCharArray();
    public Graph() {
        int [][] b ={
          //a b c d e f g h i
           {0,1,1,1,0,0,0,0,0},//a
           {1,0,1,1,0,0,0,0,0},//b
           {1,1,0,1,0,0,0,0,0},//c
           {1,1,1,0,0,1,0,0,0},//d
           {0,0,0,0,0,1,0,0,0},//e
           {0,0,0,1,1,0,0,0,0},//f
           {0,0,0,0,0,0,0,1,1},//g
           {0,0,0,0,0,0,1,0,0},//h
           {0,0,0,0,0,0,1,0,0}//i
        };
        a = b;
        n = 9;
    }
    // visit vertex i
    void visit(int i){
        System.out.print(vertex[i] + " ");
    }
    //breadth-first traversal a graph
    void bfs(int i, boolean []c){
        //make all vertexs are unvisited
        for (int j = 0; j < n; j++) {
            c[j] = false;
        }
        MyQueue m = new MyQueue();
        m.enqueue(i);
        c[i] = true;
        while(!m.isEmpty()){
            int k = (int)m.dequeue();
            for (int j = 0; j < n; j++) {
                //chưa thăm j và có cạnh nối giữa k và j
                if(!c[j] && a[k][j] > 0){
                    m.enqueue(j);
                    c[j] = true;
                }
            }
            visit(k);
            
        }
        
    }
    void bfs(){
        boolean [] c = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!c[i]) bfs(i,c);
        }
    }
    void dfs(int i, boolean []c){
        visit(i);c[i] = true;
        for (int j = 0; j < n; j++) {
            if(!c[j] && a[i][j] > 0){
                dfs(j, c);
            } 
        }
    }
    void dfs(){
        boolean []c = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!c[i]) dfs(i, c);
        }
    }
    // path from vetex u to vertex v
    int u,v;
    boolean found = false;
    int []t;
    void dfspath(int i, boolean []c){
        c[i] = true;
        for (int j = 0; j < n; j++) {
            if(!c[j] && a[i][j] > 0){
                t[j]=i;
                if(j == v){
                    found = true;return;
                }
                dfspath(j, c);
            } 
        }
    }
    void path(){
       boolean []c = new boolean[n];
       t = new int[n];
        dfspath(u, c);
        if(found){
            System.out.println("A path from " + vertex[u] + " to " + vertex[v] + ": ");
            int []h = new int[n];
            int m = 0;
            h[m] = v;
            while(u != v){
                v = t[v];
                h[++m] = v;
            }
            for (int i = m; i >= 0; i--) {
                visit(h[i]);
            }
        }
        else {
            System.out.println("A path from " + vertex[u] + " to " + vertex[v] + ": " +"Not found");
        }
    }
    //connectivity
    int []tp;
    int con = 0;
    void dfscon(int i, boolean []c){
        tp[i] = con;
        c[i] = true;
        for (int j = 0; j < n; j++) {
            if(!c[j] && a[i][j] > 0){
                dfscon(j, c);
            } 
        }
    }
    void connectivity(){
        con = 0;
        tp = new int[n];
        boolean []c = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!c[i]){
                con++;
                dfscon(i, c);
            }
        }
        //output connectivity vertexs
        for (int i = 1; i <= con; i++) {
            System.out.println("Connectivity " + i + ":"); 
            for (int j = 0; j < n; j++) {
                if(tp[j] == i) visit(j);
            }
            System.out.println("");
        }
        
    }
    int connectivityCount() {
        int xcon = 0;
        boolean[] c = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!c[i]) {
                xcon++;
                dfscon(i, c);
            }
        }
        return xcon;
    }
    int []deg = new int[20];// mảng lưu số bậc của đỉnh
    //calculate degree ò each vertex
    void calulateDegree() {      
        for (int i = 0; i < n; i++) {
            int d = 0;
            for (int j = 0; j < n; j++) {
                d += a[i][j];
            }
            deg[i] = d;
        }
    }
    // tra ve 1 mang chua index cua vertex theo thu tu tang dan
    public int[] sortedByDegree(){
        calulateDegree();
        int []sortedVertex=new int[n];
        int deg1[] =new int[n];
        for(int i=0;i<n;i++){
            sortedVertex[i]=i;
            deg1[i]=deg[i];
        }
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int x;
                if(deg1[i]>deg[j]){
                    x=deg1[i];
                    deg1[i]=deg1[j];
                    deg1[j]=x;
                    x=sortedVertex[i];
                    sortedVertex[i]=sortedVertex[j];
                    sortedVertex[j]=x;
                }
            }
        }
        return sortedVertex;
    }
}
