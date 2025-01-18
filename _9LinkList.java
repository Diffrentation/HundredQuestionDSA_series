package HundredQuestionDSA_series;

import java.lang.classfile.components.ClassPrinter.Node;

public class _9LinkList {
     static Node head;
    class Node{
        int val;
        Node next;

        Node(int val){
            this.val=val;
        }

        
        Node(int val,Node next){
            this.val=val;
            this.next=null;
        }

    }
    public static void addFirst(String val){
        Node newNode=new Node(val);
        if(head==null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    public static void main(String[] args) {
        
    }
}
