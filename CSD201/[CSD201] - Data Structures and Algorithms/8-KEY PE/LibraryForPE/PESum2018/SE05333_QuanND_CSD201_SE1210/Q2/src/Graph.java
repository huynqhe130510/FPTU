/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)============================================
import java.io.*;
import java.util.*;
//-------------------------------------------------------------------------------

public class Graph {

    int[][] a;
    int n;
    char v[];
    int deg[];

    Graph() {
        v = "ABCDEFGHIJKLMNOP".toCharArray();
        deg = new int[20];
        a = new int[20][20];
        n = 0;
    }

    void loadData(int k) //do not edit this function
    {
        RandomAccessFile f;
        int i, j, x;
        String s;
        StringTokenizer t;
        a = new int[20][20];
        try {
            f = new RandomAccessFile("data.txt", "r");
            for (i = 0; i < k; i++) {
                f.readLine();
            }
            s = f.readLine();
            s = s.trim();
            n = Integer.parseInt(s);
            for (i = 0; i < n; i++) {
                s = f.readLine();
                s = s.trim();
                t = new StringTokenizer(s);
                for (j = 0; j < n; j++) {
                    x = Integer.parseInt(t.nextToken().trim());
                    a[i][j] = x;
                }
            }
            f.close();
        } catch (Exception e) {
        }

    }

    void dispAdj() {
        int i, j;
        for (i = 0; i < n; i++) {
            System.out.println();
            for (j = 0; j < n; j++) {
                System.out.printf("%4d", a[i][j]);
            }
        }
    }

    void fvisit(int i, RandomAccessFile f) throws Exception {
        f.writeBytes(" " + v[i]);
    }

    void fdispAdj(RandomAccessFile f) throws Exception {
        int i, j;
        f.writeBytes("n = " + n + "\r\n");
        for (i = 0; i < n; i++) {
            f.writeBytes("\r\n");
            for (j = 0; j < n; j++) {
                f.writeBytes("  " + a[i][j]);
            }
        }
        f.writeBytes("\r\n");
    }

    void breadth(boolean[] en, int i, RandomAccessFile f) throws Exception {
        GQueue q = new GQueue();
        int r, j;
        q.enqueue(i);
        en[i] = true;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            for (j = 0; j < n; j++) {
                if (!en[j] && a[r][j] > 0) {
                    q.enqueue(j);
                    en[j] = true;
                }
            }
        }
    }

    void breadth(int k, RandomAccessFile f) throws Exception {
        boolean[] en = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            en[i] = false;
        }
        breadth(en, k, f);
        for (i = 0; i < n; i++) {
            if (!en[i]) {
                breadth(en, i, f);
            }
        }
    }

    void depth(boolean[] visited, int k, RandomAccessFile f) throws Exception {
        fvisit(k, f);
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                depth(visited, i, f);
            }
        }
    }

    void depth(int k, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        depth(visited, k, f);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                depth(visited, i, f);
            }
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    int count = 0;
    void depth2(boolean[] visited, int k, RandomAccessFile f) throws Exception {
        if (count < 5) {
            fvisit(k, f);
            count++;
        }
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                depth2(visited, i, f);
            }
        }
    }

    void depth2(int k, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        depth2(visited, k, f);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                depth2(visited, i, f);
            }
        }
    }

    void f5() throws Exception {
        loadData(18);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        depth(1, f);
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        depth2(1, f);
        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

//=================================================================
    int INF=99;
     void ijk(int u, int ve,RandomAccessFile f) throws Exception{
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
        while (curr != ve){
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
                //System.out.println("Shortest path does not exsits");
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
        //System.out.println("Shortest path from " + vertex[u] + " to " + vertex[v] + " is " + d[v]);
        int []h = new int[n];
        int hn = 0;
        h[hn]= ve;
        int x, y = u;
        while(u != ve){
            ve = t[ve];
            h[++hn] = ve;
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
        for (int i = 1; i >= 0; i--) {
            // w[k++] = d[h[i]] --> hiện thị ra trọng số
            //System.out.print("-->(" + distfb[k++] + ")" +v[h[i]]);
            fvisit(h[i], f);  
        }
        f.writeBytes("\r\n");
        f.writeBytes(" "+distfb[hn]);
        f.writeBytes("\r\n");
        f.writeBytes(" "+distfb[hn-1]);
        f.writeBytes(" "+distfb[hn]);
        //System.out.println("");
//        for (int i = hn; i >= 0; i--) {
//            visit(h[i]);
//        }
//        System.out.println("");
    }
    void f6() throws Exception {
        loadData(29);
        String fname = "f6.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        // You can use the statement fvisit(i,f); i = 0, 1, 2,...,n-1 to display the vertex i to file f5.txt 
        //  and statement f.writeBytes(" " + k); to write  variable k to the file f5.txt  
        ijk(0, 5, f);
        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

}
