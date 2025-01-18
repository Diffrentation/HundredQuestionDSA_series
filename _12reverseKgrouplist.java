public package HundredQuestionDSA_series;

class _12reverseKgrouplist {
    public class node {
        int data;
        node next;
        static node head;
        node(int data,node next){
            this.data=data;
            this.next=null;
        }
        public static int len(node head){
            int count;
                    if(head==null){
                        return (Integer) null;
                    }
                    while(head!=null){
                        count++;
                        head=head.next;
                    }
                    return count;
                }
                public static node reverseGroup(node head,int k){
                    int p;
                    int N=len(head);
                    int group=N/k;
                    node prevhead=null;
                    node currhead=head;
                    node anshead=null;
                    for(int i=0;i<group;i++){
                        node prev=null;
                        node curr=head;
                        node nextnode=null;
                        for(int j=0;j<k;j++){
                            nextnode=curr.next;
                            curr.next=prev;
                            prev=curr;
                            curr=nextnode;
                        }
                        if(prevhead==null){
                            anshead=prev;
                        }
                        else{
                            prevhead.next=prev;
                        }
                        prevhead=currhead;
                        currhead=curr;
                    }
                   
        }
        
    }

    public static void main(String[] args) {
        
    }
}