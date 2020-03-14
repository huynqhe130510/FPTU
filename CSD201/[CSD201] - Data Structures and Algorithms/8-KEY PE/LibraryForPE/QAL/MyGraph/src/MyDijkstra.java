/* 
    - d[i]: đường đi ngắn nhất từ u đến i;
    - h[3] = A | w[0] = 0 ( A --> A)
      h[2] = B | w[1] = 3 ( A --> B)
      h[1] = C | w[2] = 8 ( B --> C)
      h[0] = D | w[3] = 3 ( C --> D)
      hn = 4   | wn = 4 
      (số đỉnh)| (số đường đi từ đỉnh này sang đỉnh kia)
*/
public class MyDijkstra {
    
    //weight - matrix;
    int [][]a;
    int n;
    char [] vertex = "ABCDEFGHI".toCharArray();
    //visit vertex 
    void visit(int i){
        System.out.print(vertex[i] + " ");
    }
    int INF = 99;
    public MyDijkstra(){
        int [][]b= {
            //a b c  d   e  f 
             {0,7,9,INF,16,INF},//a
             {7,0,12,17,INF,INF},//b
             {9,12,0,13,2,INF},//c
             {INF,17,13,0,INF,6},//d
             {16,INF,2,INF,0,9},//e
             {INF,INF,INF,6,9,0}//f
        };
        a = b;
        n = a.length;
    }
    
    void ijk(int u, int v){
        //d[i] shortest path from u to v
        int [] d = new int [n];
        //t[i] = j --> before vertex i is j
        int [] t = new int[n];
        //c[i] = true --> vertex i is selected;
        boolean []c = new boolean[n];
        //step 0
        for (int i = 0; i < n; i++) {
            d[i] = a[u][i];
            t[i] = u;
        }
        int curr = u;
        while (curr != v){
            //tìm k là đỉnh mà chi phí từ u đến k là nhỏ nhất
            int k = -1, min = INF;
            //tìm min trên mảng d & tìm đỉnh curr
            for (int i = 0; i < n; i++) {
                if(!c[i] && d[i] < min){
                    min = d[i];
                    k = i;
                }
            }
            if(min == INF){
                System.out.println("Shortest path does not exsits");
                return;
            }
            //chọn đỉnh k là đỉnh kế tiếp
            c[k] = true; curr = k;
            //tính lại d và t
            for (int i = 0; i < n; i++) {
                if(d[i] > d[k] + a[k][i]){
                    d[i] = d[k] + a[k][i];
                    t[i] = k;
                }
            }
            
        }
        //tìm đường đi từ v đến u
        System.out.println("Shortest path from " + vertex[u] + " to " + vertex[v] + " is " + d[v]);
        int []h = new int[n];
        int hn = 0;
        h[hn]= v;
        int x, y = u;
        while(u != v){
            v = t[v];
            h[++hn] = v;
        }
       
        int []w = new int[n];
        int []distfb = new int[n]; // distance from the start vertex in Dijkstra path
        int wn = -1;   
         //hiện trị trọng số mỗi bước đi
        for (int i = hn; i >= 0; i--) {
            x = y;
            y = h[i];
            w[++wn] = a[x][y];          
        }
        for(int i=0;i<=hn;i++){
            distfb[i]=0;
            for(int j=0;j<=i;j++){
                distfb[i]+=w[j];
            }
        }
        int k = 0; // không hiện thị trọng số của đỉnh đầu tiên(u)
        for (int i = hn; i >= 0; i--) {
            // w[k++] = d[h[i]] --> hiện thị ra trọng số
            System.out.print("-->(" + distfb[k++] + ")" +vertex[h[i]]);
        }
        System.out.println("");
        
//        for (int i = hn; i >= 0; i--) {
//            visit(h[i]);
//        }
//        System.out.println("");
    }
    
}
