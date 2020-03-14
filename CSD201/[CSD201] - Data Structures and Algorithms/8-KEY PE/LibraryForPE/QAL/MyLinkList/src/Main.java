
public class Main {
    public static void main(String[] args) {
        MyList m = new MyList();
//        m.addFist(new Color("Blue", 128));
//        m.addFist(new Color("Red", 12));
//        m.addLast(new Color("Green", 12));
//        m.addLast(new Color("Black", 18));
        m.traversal();
        System.out.println("--------------");
        // remove tail
        //m.remove(m.size() - 1);
        //m.reverse();
        m.removeSecond();
        for (int i = 0; i < m.size(); i++) {
            System.out.println(m.getNode(i).info);
        }
    }
}
