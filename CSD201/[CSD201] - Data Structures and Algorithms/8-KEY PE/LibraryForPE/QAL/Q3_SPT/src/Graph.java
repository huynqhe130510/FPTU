/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;
//-------------------------------------------------------------------------------

class Graph {

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
            f = new RandomAccessFile("graph.txt", "r");
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

    void fvisit(int i, RandomAccessFile f) throws Exception {
        f.writeBytes(" " + v[i]);
    }

    void fvisitDeg(int i, RandomAccessFile f) throws Exception {
        f.writeBytes(" " + v[i] + "(" + deg[i] + ")");
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

    void fbreadth(boolean[] en, int i, RandomAccessFile f) throws Exception {
        MyQueue q = new MyQueue();
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

    void fbreadth(int k, RandomAccessFile f) throws Exception {
        boolean[] en = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            en[i] = false;
        }
        fbreadth(en, k, f);
        for (i = 0; i < n; i++) {
            if (!en[i]) {
                fbreadth(en, i, f);
            }
        }
    }

    void fdepth(boolean[] visited, int k, RandomAccessFile f) throws Exception {
        fvisit(k, f);
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                fdepth(visited, i, f);
            }
        }
    }

    void fdepth(int k, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        fdepth(visited, k, f);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                fdepth(visited, i, f);
            }
        }

    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
//=================================================================
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

    void fbreadthf1(boolean[] en, int i, RandomAccessFile f) throws Exception {
        MyQueue q = new MyQueue();
        int r, j;
        q.enqueue(i);
        en[i] = true;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisitDeg(r, f);
            for (j = 0; j < n; j++) {
                if (!en[j] && a[r][j] > 0) {
                    q.enqueue(j);
                    en[j] = true;
                }
            }
        }
    }

    void fbreadthf1(int k, RandomAccessFile f) throws Exception {
        boolean[] en = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            en[i] = false;
        }
        fbreadthf1(en, k, f);
        for (i = 0; i < n; i++) {
            if (!en[i]) {
                fbreadthf1(en, i, f);
            }
        }
    }

    void f1() throws Exception {
        loadData(10);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        fbreadth(0, f123);// fbreadth first traverse from the vertex 0 (A)
        f123.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        calulateDegree();
        fbreadthf1(0, f123);

        //-------------------------------------------------------------------------------------
        f123.writeBytes("\r\n");
        f123.close();
    }

//=================================================================
     void fdepthf2(boolean[] visited, int k, RandomAccessFile f) throws Exception {
        fvisitDeg(k, f);
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                fdepthf2(visited, i, f);
            }
        }
    }

    void fdepthf2(int k, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        fdepthf2(visited, k, f);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                fdepthf2(visited, i, f);
            }
        }

    }
    void f2() throws Exception {
        loadData(10);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        fdepth(0, f123);// fdepth first traverse from the vertex 0 (A)
        f123.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        calulateDegree();
        fdepthf2(0, f123);

        //-------------------------------------------------------------------------------------
        f123.writeBytes("\r\n");
        f123.close();
    }

//=================================================================
     int con = 0;
    void dfscon(int i, boolean []c){
        c[i] = true;
        for (int j = 0; j < n; j++) {
            if(!c[j] && a[i][j] > 0){
                dfscon(j, c);
            } 
        }
    }
    void connectivity(){
        con = 0;
        boolean []c = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!c[i]){
                con++;
                dfscon(i, c);
            }
        }
    }
    void f3() throws Exception {
        loadData(21);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        fdispAdj(f123);
        f123.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        connectivity();
        int k = con;
        f123.writeBytes(" k = " + k + "\r\n"); 

        //-------------------------------------------------------------------------------------
        f123.writeBytes("\r\n");
        f123.close();
    }

//=================================================================
    char [] vertex = v;
     void ijk(int u, int v, RandomAccessFile f123) throws Exception{
         vertex = this.v;
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
        int INF = 99;
        while (curr != v){
            //tìm k là đỉnh mà chi phí từ u đến k là nhỏ nhất
            int k = -1, min = INF;
            //tìm min trên mảng d
            for (int i = 0; i < n; i++) {
                if(!c[i] && d[i] < min){
                    min = d[i];
                    k = i;
                }
            }
            if(min == INF){
                f123.writeBytes("Shortest path does not exsits");
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
        f123.writeBytes("Shortest path from " + vertex[u] + " to " + vertex[v] + " is " + d[v]);
        int []h = new int[n];
        int hn = 0;
        h[hn]= v;
        int x, y = v;
        while(u != v){
            v = t[v];
            h[++hn] = v;
        }
        //hiện trị trọng số mỗi bước đi
        int []w = new int[n];
        int wn = -1;
        for (int i = hn; i >= 0; i--) {
            x = y;
            y = h[i];
            w[++wn] = a[x][y];
            
        }
        int k = 1; // không hiện thị trọng số của đỉnh đầu tiên(u)
        f123.writeBytes("\r\n" +vertex[h[hn]]);//in ra đỉnh đầu tiên(A)
        for (int i = hn - 1; i >= 0; i--) {
            // w[k++] = d[h[i]] --> hiện thị ra trọng số
            f123.writeBytes("-->(" + w[k++] + ")" +vertex[h[i]]);
        }
            f123.writeBytes("\r\n");
     }
    void f4() throws Exception {
        loadData(33);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        ijk(0, 5, f123);

        //-------------------------------------------------------------------------------------
        f123.writeBytes("\r\n");
        f123.close();
    }

//=================================================================
    boolean isUndriected(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(a[i][j] != a[j][i]) return false;
            }
        }
        return true;
    }
    boolean isEvenDegree(){
        calulateDegree();
        for (int i = 0; i < n; i++) {
            if(deg[i] % 2 !=0) return false;
        }
        return true;
    }
    boolean isConnected(){
        con = 0;
        connectivity();
        return con == 1;
    }
    void checkEulerCycle(RandomAccessFile f123) throws Exception{
        if(isUndriected()) f123.writeBytes("The graph is undirected.\r\n");
        else f123.writeBytes("The graph is not undirected.\r\n");
        if(isConnected()) f123.writeBytes("The graph is connected.\r\n");
        else f123.writeBytes("The graph is not connected.\r\n");
        if(isEvenDegree()) f123.writeBytes("All vertices have even degree.\r\n"); 
        else f123.writeBytes("The graph has a vertex with odd degree.\r\n");
        if(isConnected() && isEvenDegree() && isUndriected()) 
            f123.writeBytes("Conditions for Euler's cycle are satisfied.\r\n");
        else
            f123.writeBytes("Conditions for Euler's cycle are not satisfied.\r\n");
    }

    void f5() throws Exception {//You do not need to edit this file
        //Your task is to complete the checkEulerCycle(...) function above only
        loadData(42);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");

        checkEulerCycle(f123);
        loadData(49);
        f123.writeBytes("\r\n");
        checkEulerCycle(f123);

        f123.writeBytes("\r\n");
        f123.close();
    }

//=================================================================
     public void euler(RandomAccessFile f123) throws Exception{
         vertex = this.v;
        MyStack m = new MyStack();
        int [] e = new int[20];//chứa đỉnh của đường đi
        int ne = 0; // số phần tử của mảng e
        m.push(0);
        while(!m.isEmpty()){
            int r = (int)m.top();
            // nếu r là độc lập thì thả vào e
            int i = 0;
            while(i < n && a[r][i] == 0) i++;
            if(i == n) {
                e[ne] = r; ne++;m.pop();
            }else{
                m.push(i);
                a[r][i]--;
                a[i][r]--;
            }
        }
        //ouput euler cycle
        for (int i = 0; i < ne; i++) {
            f123.writeBytes(vertex[e[i]] + " ");
        }
        f123.writeBytes("\r\n");
    }
    
    void f6() throws Exception {
        loadData(42);
        String fname = "f6.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        euler(f123);

        //-------------------------------------------------------------------------------------
        f123.writeBytes("\r\n");
        f123.close();
    }

}
//=================================================================
