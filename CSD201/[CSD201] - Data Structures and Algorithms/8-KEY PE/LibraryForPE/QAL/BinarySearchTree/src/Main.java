
public class Main {

    public static void main(String[] args) {
        int[] a = {60, 50, 90, 40, 70, 120, 45};
        BSTree b = new BSTree();
        for (int x : a) {
            b.insert(x);
        }
        b.bfs(b.root);
        System.out.println("");
//        b.preoder(b.root);
//        System.out.println("");
//        b.inoder(b.root);
//        System.out.println("");
//        b.deleteByCopy(8);
//        b.bfs(b.root);
        b.banlance(b.root);
        b.bfs(b.root);
        System.out.println("");
    
    }
}
