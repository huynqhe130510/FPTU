
package likedlist_selfmake;

/**
 *
 * @author Dang Quan
 */
public class LikedList_selfmake {

   
    public static void main(String[] args) {
        int []a= {0,1,2,3,4};
        MyList ml = new MyList();
        ml.addManyLast(a);
        ml.Insert(2,11);
        ml.traverse();
    }
    
}
