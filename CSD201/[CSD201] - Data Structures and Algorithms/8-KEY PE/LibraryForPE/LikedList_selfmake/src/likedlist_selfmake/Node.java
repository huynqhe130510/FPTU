/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package likedlist_selfmake;

/**
 *
 * @author Dang Quan
 */
public class Node {
    int infor;
    Node next;
    public Node(int x){
        this.infor=x;
        next=null;
    }
    public Node(int x, Node p){
        this.infor=x;
        this.next= p;
    }
    
}
