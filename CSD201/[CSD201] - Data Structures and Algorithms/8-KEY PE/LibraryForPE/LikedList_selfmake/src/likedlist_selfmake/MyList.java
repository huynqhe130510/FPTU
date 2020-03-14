
package likedlist_selfmake;


public class MyList {
    Node head,tail;
    MyList(){
        head=tail=null;
    }
    boolean isEmpty(){
        return(head==null);
    }
    void clear(){
        head=tail=null;
    }
     public Node getNode(int x){
        int c=0;
        Node p=head;
        while(c<x && p!=null){
            p=p.next;
            c++;
        }
        return p;
    }
    void addLast(int x){
        Node q=new Node(x);
        if(isEmpty()){
            head=tail=q;return;
        }
        tail.next=q;
        q.next=null;
        tail=q;
    }
    void addFirst(int x){
        Node q=new Node(x);
        if(isEmpty()){
            head=tail=q;return;
        }
        q.next=head;
        head=q;
    }
    //add value val after xth Node
    void Insert(int x, int val){
        
        Node q = new Node(val);
        Node p=getNode(x);
        if(p==null) return;
        if(isEmpty()){
            head=tail=q;return;
        }
        else {
            q.next=p.next;
            p.next=q;
            if(p==tail) tail=q;
            
        }    
    }
    void addManyFirst(int []a){
        for(int i=0;i<a.length;i++){
            addFirst(a[i]);
        }
    }
    void addManyLast(int []a){
        for(int i=0;i<a.length;i++){
            addLast(a[i]);
        }
    }
    void traverse(){
        Node p= head;
        while(p!=null){
            System.out.print(p.infor+" ");
            p=p.next;
        }
    }
    void DeleteFirst(){
        if(isEmpty()){
            return;
        }
        
        Node p;
        p=head;
        head=head.next;
        p.next=null;
    }
    void DeleteLast(){
        if(isEmpty()){ return;}
        Node p;
        p=head;
        while(p.next!=tail){
            p=p.next;
        }
            p.next=null;
            tail=p;
    }
   
    //delete xth node 
    void remove(int k){
        if(isEmpty()){ return;}
        if (k == 0) {
            Node p = head;
            head = head.next;
            p.next = null;
        } else { 
            Node p = getNode(k);
            if (p == null) {
                return;
            }
            Node q = getNode(k - 1);
            //remove p
            q.next = p.next;
            p.next = null;
            if (p == tail) {
                tail = q;
            }
        }    
    }
    public Node search(int x) {
        Node p = head;
        while (p != null) {
            if (p.infor==x) {
                break;
            }
            p = p.next;
        }
        return p;
    }
}
