
public class MyEuler {
    
    int n;
    int [][]a;
    char []vertex = "ABCDEFGH".toCharArray();

    public MyEuler() {
        int [][]b = {
            //1 2 3 4 5 6
             {0,2,0,0},//1
             {2,0,1,1},//2
             {0,1,0,1},//3
             {0,1,1,0},//4
        };
        n = b.length;
        a = b;
    }
    
    public void euler() {
        MyStack m = new MyStack();
        int [] e = new int[20];//chứa đỉnh của đường đi
        int ne = 0; // số phần tử của mảng e
        m.push(1);
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
            System.out.print(vertex[e[i]] + " ");
        }
        System.out.println("");
    }
    
    
}
