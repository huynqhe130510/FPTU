
public class Main {
    
    public static void main(String[] args) {
        
        Graph g = new Graph();
        g.bfs();
        System.out.println("");
        g.dfs();
        System.out.println("");
        //a path from B to H
        g.u = 1;//B
        g.v = 4;//E
        g.path();
        System.out.println("");
        g.connectivity();
          MyDijkstra m = new MyDijkstra();
          m.ijk(0, 5);//from A to F
          System.out.println("");
          MyEuler myE = new MyEuler();
          myE.euler();
        
        g.connectivity();
        System.out.println(g.connectivityCount());
//        int []sort = g.sortedByDegree();
//        
//        for(int i=0;i<sort.length;i++){
//            System.out.print(g.deg[sort[i]]);
//            g.visit(sort[i]);
//        }
//        g.path();
    }
}
