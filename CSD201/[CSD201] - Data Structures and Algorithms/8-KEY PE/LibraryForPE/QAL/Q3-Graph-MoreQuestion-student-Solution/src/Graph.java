/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;
//-------------------------------------------------------------------------------
class Graph
 {int [][] a; int n;
  char v[];
  int deg[];
  Graph()
    {v = "ABCDEFGHIJKLMNOP".toCharArray();
     deg = new int[20];
     a = new int[20][20];
     n = 0;
    }

  void loadData(int k)  //do not edit this function
   {RandomAccessFile f;int i,j,x;
    String s;StringTokenizer t;
    a = new int[20][20];
    try {
     f = new RandomAccessFile("graph.txt","r");
     for(i=0;i<k;i++) f.readLine();
     s = f.readLine();s = s.trim();
     n = Integer.parseInt(s);
     for(i=0;i<n;i++)
       {s = f.readLine();s = s.trim();
        t = new StringTokenizer(s);
        for(j=0;j<n;j++) 
          {x = Integer.parseInt(t.nextToken().trim());
           a[i][j] = x;
          }
       }
     f.close();
     }
    catch(Exception e) {}

   }

  void fvisit(int i, RandomAccessFile f) throws Exception
   {f.writeBytes(" "+v[i]);
   }

  void fvisitDeg(int i, RandomAccessFile f) throws Exception
   {f.writeBytes(" "+v[i]+"("+deg[i]+")");
   }

 void fdispAdj(RandomAccessFile f) throws Exception 
   {int i,j;
    f.writeBytes("n = "+n+"\r\n");
    for(i=0;i<n;i++)
     {f.writeBytes("\r\n");
      for(j=0;j<n;j++)  f.writeBytes("  " + a[i][j]);
     }
    f.writeBytes("\r\n");
   }

  void fbreadth(boolean [] en, int i, RandomAccessFile f) throws Exception
   {MyQueue q = new MyQueue();
    int r,j;
    q.enqueue(i); en[i]=true;
    while(!q.isEmpty())
     {r = q.dequeue();
      fvisit(r,f);
      for(j=0;j<n;j++)
       {if(!en[j] && a[r][j]>0) {q.enqueue(j);en[j]=true;}
       }
     }
   }

  void fbreadth(int  k, RandomAccessFile f) throws Exception
   {boolean [] en = new boolean[20];
    int i;
    for(i=0;i<n;i++) en[i]=false;
    fbreadth(en,k,f);
    for(i=0;i<n;i++) if(!en[i]) fbreadth(en,i,f);
   }

  void fdepth(boolean [] visited,int k, RandomAccessFile f) throws Exception
   {fvisit(k,f);visited[k]=true;
    for(int i=0;i<n;i++)
      {if(!visited[i] && a[k][i]>0) fdepth(visited,i,f);
      }
   }
  void fdepth(int k, RandomAccessFile f) throws Exception
   {boolean [] visited = new boolean[20];
    int i;
    for(i=0;i<n;i++) visited[i]=false;
    fdepth(visited,k,f);
    for(i=0;i<n;i++) 
       if(!visited[i]) fdepth(visited,i,f);

   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
//=================================================================
  
   void fbreadthf1(boolean [] en, int i, RandomAccessFile f) throws Exception
   {MyQueue q = new MyQueue();
    int r,j;
    q.enqueue(i); en[i]=true;
    while(!q.isEmpty())
     {
      r = q.dequeue();
      count++;
      if(count > 4) return;
      fvisit(r,f);
      
      for(j=0;j<n;j++)
       {if(!en[j] && a[r][j]>0) {q.enqueue(j);en[j]=true;}
       }
     }
   }

   int count = 0;
   
  void fbreadthf1(int  k, RandomAccessFile f) throws Exception
   {boolean [] en = new boolean[20];
    int i;
    for(i=0;i<n;i++) en[i]=false;
    fbreadthf1(en,k,f);
    for(i=0;i<n;i++) if(!en[i]) fbreadthf1(en,i,f);
   }
  
  
  void f1() throws Exception
   {loadData(10);
    String fname = "f1.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    fbreadth(0,f123);// fbreadth first traverse from the vertex 0 (A)
    f123.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
       fbreadthf1(0, f123);
     
    //-------------------------------------------------------------------------------------
    f123.writeBytes("\r\n");
    f123.close();
   }

//=================================================================
  
  void calculateDegree() {
      for (int i = 0; i < n; i++) {
          int d = 0;
          for (int j = 0; j < n; j++) {
              d += a[i][j];
          }
          deg[i] = d;
      }
  }
  
  void fdepthf2(boolean [] visited,int k, RandomAccessFile f) throws Exception
   {
    if(deg[k] % 2 == 0)   
        fvisitDeg(k,f);
    visited[k]=true;
    for(int i=0;i<n;i++)
      {if(!visited[i] && a[k][i]>0) fdepthf2(visited,i,f);
      }
   }
  void fdepthf2(int k, RandomAccessFile f) throws Exception
   {boolean [] visited = new boolean[20];
    int i;
    for(i=0;i<n;i++) visited[i]=false;
    fdepthf2(visited,k,f);
    for(i=0;i<n;i++) 
       if(!visited[i]) fdepthf2(visited,i,f);

   }
  
  
  void f2() throws Exception
   {loadData(10);
    String fname = "f2.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    fdepth(0,f123);// fdepth first traverse from the vertex 0 (A)
    f123.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
     calculateDegree();
     fdepthf2(0, f123);
    //-------------------------------------------------------------------------------------
    f123.writeBytes("\r\n");
    f123.close();
   }

//=================================================================
  
  int con = 0;
    void dfscon(int i, boolean [] c) {  
        c[i] = true;
        for (int j = 0; j < n; j++) {
            if(!c[j] && a[i][j] > 0) {
                dfscon(j,c);
            }
        }
    }
    void connectivity() {
        con = 0;
        boolean [] c = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!c[i]) {
                con++;
                dfscon(i, c);
            }
        }
    }
  
  void f3() throws Exception
   {loadData(21);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    fdispAdj(f123);
    f123.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

    connectivity();
    int k = con;
    f123.writeBytes("k = "+ k + "\r\n");
    //-------------------------------------------------------------------------------------
    f123.writeBytes("\r\n");
    f123.close();
   }

//=================================================================
  
  char [] vertex;
  void ijkf4(int u, int v, RandomAccessFile f123) 
          throws Exception {
      vertex = this.v;
        //d[i] shortest path from u to i
        int [] d = new int[n];
        //t[i]= j -> before vertex i is j
        int []t = new int[n];
        //c[i] = true -> vertex i is selected
        boolean []c = new boolean[n];
        //step 0
        for (int i = 0; i < n; i++) {
            d[i] = a[u][i];
            t[i] = u;
        }
        int curr = u;
        int INF = 99;
        while(curr != v) {
            //tim k la dinh ma chi phi tu u den k la nho nhat
            //tim min tren mang d
            int k = -1, min = INF;
            for (int i = 0; i < n; i++) {
                if(!c[i] && d[i] < min) {
                    min = d[i];k = i;
                }
            }
            if(min == INF) {
                f123.writeBytes("Shortest path does not exists");
                return;
            }
            //chon dinh k la dinh ke tiep
            c[k] = true;curr = k;
            //tinh lai d va t
            for (int i = 0; i < n; i++) {
                if(d[i] > d[k] + a[k][i] && !c[i]) {
                    d[i] = d[k] + a[k][i];
                    t[i] = k;
                }
            }
        }
        //tim duong di tu v den u
        vertex = this.v;
        f123.writeBytes("The length of Shortest path from " + vertex[u] + "to "
        + vertex[v] + " is " + d[v]);
        int []h = new int[n];
        int hn = 0;
        h[hn] = v;
        int x, y = v;
        while(u != v) {
            v = t[v];
            h[++hn] = v;
        }
        //hien thi trong so moi buoc di
        int [] w = new int[n];
        int wn = -1;
        for(int i = hn; i >= 0; i--) {
            x = y;
            y = h[i];
            w[++wn] = a[x][y];
        }
//        int k = 1;//khong hien thi trong so dinh dau tien (u)
        f123.writeBytes("\r\n"+vertex[h[hn]]);
        for (int i = hn - 1; i >= 0; i--) {
            //d[h[i]]
            f123.writeBytes("->("+d[h[i]]+")" + vertex[h[i]]);
        }
        f123.writeBytes("\r\n");
    }
  
  void f4() throws Exception
   {loadData(33);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
       ijkf4(0, 5, f123);

    //-------------------------------------------------------------------------------------
    f123.writeBytes("\r\n");
    f123.close();
   }

//=================================================================
  
  void ijkf5(int u, int v, RandomAccessFile f123) 
          throws Exception {
      vertex = this.v;
        //d[i] shortest path from u to i
        int [] d = new int[n];
        //t[i]= j -> before vertex i is j
        int []t = new int[n];
        //c[i] = true -> vertex i is selected
        boolean []c = new boolean[n];
        //step 0
        for (int i = 0; i < n; i++) {
            d[i] = a[u][i];
            t[i] = u;
        }
        int curr = u;
        int INF = 99;
        while(curr != v) {
            //tim k la dinh ma chi phi tu u den k la nho nhat
            //tim min tren mang d
            int k = -1, min = INF;
            for (int i = 0; i < n; i++) {
                if(!c[i] && d[i] < min) {
                    min = d[i];k = i;
                }
            }
            if(min == INF) {
                f123.writeBytes("Shortest path does not exists");
                return;
            }
            //chon dinh k la dinh ke tiep
            c[k] = true;curr = k;
            //tinh lai d va t
            for (int i = 0; i < n; i++) {
                if(d[i] > d[k] + a[k][i] && !c[i]) {
                    d[i] = d[k] + a[k][i];
                    t[i] = k;
                }
            }
        }
        //tim duong di tu v den u
        vertex = this.v;
        //f123.writeBytes("The length of Shortest path from " + vertex[u] + "to "
        //+ vertex[v] + " is " + d[v]);
        int []h = new int[n];
        int hn = 0;
        h[hn] = v;
        int x, y = v;
        while(u != v) {
            v = t[v];
            h[++hn] = v;
        }
        //hien thi trong so moi buoc di
        int [] w = new int[n];
        int wn = -1;
        for(int i = hn; i >= 0; i--) {
            x = y;
            y = h[i];
            w[++wn] = a[x][y];
        }
//        int k = 1;//khong hien thi trong so dinh dau tien (u)
        
        f123.writeBytes("\r\n"+d[h[hn-3]]+"\r\n");
        for (int i = hn; i >= hn - 3; i--) {
            //d[h[i]]
            f123.writeBytes(""+vertex[h[i]]+" ");
        }
        f123.writeBytes("\r\n");
    }
  
  void f5() throws Exception
   {loadData(33);
    String fname = "f5.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
       ijkf5(0, 5, f123);

    //-------------------------------------------------------------------------------------
    f123.writeBytes("\r\n");
    f123.close();
   }

//=================================================================
  
  void ijkf6(int u, int v, RandomAccessFile f123) 
          throws Exception {
      vertex = this.v;
        //d[i] shortest path from u to i
        int [] d = new int[n];
        //t[i]= j -> before vertex i is j
        int []t = new int[n];
        //c[i] = true -> vertex i is selected
        boolean []c = new boolean[n];
        //step 0
        for (int i = 0; i < n; i++) {
            d[i] = a[u][i];
            t[i] = u;
        }
        int curr = u;
        int INF = 99;
        while(curr != v) {
            //tim k la dinh ma chi phi tu u den k la nho nhat
            //tim min tren mang d
            int k = -1, min = INF;
            for (int i = 0; i < n; i++) {
                if(!c[i] && d[i] < min) {
                    min = d[i];k = i;
                }
            }
            if(min == INF) {
                f123.writeBytes("Shortest path does not exists");
                return;
            }
            //chon dinh k la dinh ke tiep
            c[k] = true;curr = k;
            //tinh lai d va t
            for (int i = 0; i < n; i++) {
                if(d[i] > d[k] + a[k][i] && !c[i]) {
                    d[i] = d[k] + a[k][i];
                    t[i] = k;
                }
            }
        }
        //tim duong di tu v den u
        vertex = this.v;
       
        int []h = new int[n];
        int hn = 0;
        h[hn] = v;
        int x, y = v;
        while(u != v) {
            v = t[v];
            h[++hn] = v;
        }
        //hien thi trong so moi buoc di
        int [] w = new int[n];
        int wn = -1;
        for(int i = hn; i >= 0; i--) {
            x = y;
            y = h[i];
            w[++wn] = a[x][y];
        }
//        int k = 1;//khong hien thi trong so dinh dau tien (u)
        f123.writeBytes("\r\n"+(hn + 1));
        f123.writeBytes("\r\n"+d[h[0]]);
        f123.writeBytes("\r\n");
        w[0] = 0;
        for (int i = 0; i <= wn; i++) {
          f123.writeBytes(" "+w[i]);
         }
        f123.writeBytes("\r\n");
        for (int i = hn; i >= 0; i--) {
            //d[h[i]]
            f123.writeBytes(" " +vertex[h[i]]);
        }
        f123.writeBytes("\r\n");
    }
  
  
  void f6() throws Exception
   {loadData(33);
    String fname = "f6.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

       ijkf6(0, 5, f123);
    //-------------------------------------------------------------------------------------
    f123.writeBytes("\r\n");
    f123.close();
   }

}
//=================================================================
