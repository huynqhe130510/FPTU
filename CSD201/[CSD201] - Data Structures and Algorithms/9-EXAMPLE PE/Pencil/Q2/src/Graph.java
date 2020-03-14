/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)============================================
import java.io.*;
import java.util.*;
//-------------------------------------------------------------------------------
public class Graph
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
     f = new RandomAccessFile("data.txt","r");
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

  void dispAdj()
   {int i,j;
    for(i=0;i<n;i++)
     {System.out.println();
      for(j=0;j<n;j++)
        System.out.printf("%4d",a[i][j]);
     }
   }

  void fvisit(int i, RandomAccessFile f) throws Exception
   {f.writeBytes(" "+v[i]);
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

  void breadth(boolean [] en, int i, RandomAccessFile f) throws Exception
   {GQueue q = new GQueue();
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

  void breadth(int  k, RandomAccessFile f) throws Exception
   {boolean [] en = new boolean[20];
    int i;
    for(i=0;i<n;i++) en[i]=false;
    breadth(en,k,f);
    for(i=0;i<n;i++) if(!en[i]) breadth(en,i,f);
   }

 void depth(boolean [] visited,int k, RandomAccessFile f) throws Exception
   {fvisit(k,f);visited[k]=true;
    for(int i=0;i<n;i++)
      {if(!visited[i] && a[k][i]>0) depth(visited,i,f);
      }
   }
  void depth(int k, RandomAccessFile f) throws Exception
   {boolean [] visited = new boolean[20];
    int i;
    for(i=0;i<n;i++) visited[i]=false;
    depth(visited,k,f);
    for(i=0;i<n;i++) 
       if(!visited[i]) depth(visited,i,f);
   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
  void f5() throws Exception
   {loadData(18);
    String fname = "f5.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    depth(1,f);
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
  int count3 =0;
  void depth2(boolean [] visited,int k, RandomAccessFile f) throws Exception
   {
       if(count3++<5) fvisit(k,f);
   visited[k]=true;
    for(int i=0;i<n;i++)
      {if(!visited[i] && a[k][i]>0) depth2(visited,i,f);
      }
   }
  void depth2(int k, RandomAccessFile f) throws Exception
   {boolean [] visited = new boolean[20];
    int i;
    for(i=0;i<n;i++) visited[i]=false;
    depth2(visited,k,f);
    for(i=0;i<n;i++) 
       if(!visited[i]) depth2(visited,i,f);
   }

//=================================================================
  void f6() throws Exception
   {loadData(29);
    String fname = "f6.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    f.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
      // You can use the statement fvisit(i,f); i = 0, 1, 2,...,n-1 to display the vertex i to file f5.txt 
      //  and statement f.writeBytes(" " + k); to write  variable k to the file f5.txt  

       dijkstra(0, 5, f);

    //-------------------------------------------------------------------------------------
    f.writeBytes("\r\n");
    f.close();
   }
  void dijkstra(int fro, int to, RandomAccessFile f) throws IOException {
    boolean [] S = new boolean[n];
    int [] d = new int[n];
    int [] p = new int[n];
    int INF = 999;
    int i,j,k, t;
    for(i=0;i<n;i++) {
      S[i] = false;
      d[i] = a[fro][i];
      p[i] = fro;
    }
    S[fro] = true;
    while(true) {
      // find d[k] = min {d[i}}
      t = INF; k=-1;
      for(i=0;i<n;i++) {
        if(S[i]==true) continue;
        if(d[i]<t) {
          t = d[i];
          k = i;
        }
      }
      if(k==-1) {
        return;
      }
      // add k to S
      S[k] = true;
      if(k==to) break;
      // update d[i] & p[i]
      for(i=0;i<n;i++) {
       if(S[i]==true) continue;
       if(d[i] > d[k] + a[k][i]) {
          d[i] = d[k] + a[k][i];
          p[i] = k;
        }
      }
    }
    i = to;
    GStack s = new GStack();//store vertex
    ArrayList points = new ArrayList();//store distance
    while(true) {
      s.push(i);
      if(i==fro) break;
      i = p[i];
    }
//print line 1: vertex, line2 : distance

    while(!s.isEmpty()) {
      i = s.pop();
      points.add(i);
    }
    for (int l = 0; l < points.size(); l++)  if(l==3|| l==5) f.writeBytes(v[l]+" ");//print vertex
//    
    f.writeBytes("\n");
    f.writeBytes(d[to]+"");
    f.writeBytes("\n");
    
//print (0)A->(9)C->(2)F->(9)E
   for (int l = 0; l < points.size(); l++)   
       if(l==3|| l==5)
       f.writeBytes(d[(int)points.get(l)]+ " ");//print distance
    f.writeBytes("\n");
  }


}