public class Node {
   
    int num=0;
    String type;
    String code;
    Node next;

    // Constructor
    public Node()
    {
        num=0;
        next=null;
    }

    public Node(int n , String t , String c)
    {
        this.num=n;
        this.type=t;
        this.code=c;
        this.next=null;
    }

    int getNum()
    {
        return num;
    }

    String getType()
    {
        return type;
    }
    String getCode()
    {
        return code;
    }
}