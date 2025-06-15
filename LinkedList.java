
 
// Java program to implement
// a Singly Linked List
public class LinkedList {
    
    int size;
 
    Node head; // head of list
    public LinkedList()
    {
        size=0;
    }
 
    public int getSize()
    {
        return size;
    }

    public String getStringAt(int a)
    {
        Node curr=head;
        String found="";
        if(a <= size)
        {
           for(int i = 0 ; i<size ; i++)
           {
               if(a==i)
               {
                   found= curr.code;
               }
               else
               {
                      curr=curr.next;
               }
               
           }
        }
        else
        {
          return ("Linked list out of bouds");
        }
        return found;
    }
 
    // Method to insert a new node
    public LinkedList insert(LinkedList list, int data , String type , String code)
    {
        size++;
        // Create a new node with given data
        Node new_node = new Node(data,type,code);
        new_node.next = null;

    
 
        // If the Linked List is empty,
        // then make the new node as head
        if (list.head == null) {
            list.head = new_node;
        }
        else {
            // Else traverse till the last node
            // and insert the new_node there
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
 
            // Insert the new_node at last node
            last.next = new_node;
        }
 
        // Return the list by head
        return list;
    }
 
    // Method to print the LinkedList.
    public void printList(LinkedList list)
    {
        Node currNode = list.head;
 
        System.out.println("LinkedList: ");
 
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.println("T"+currNode.getNum() + "\t"+"Token Class: "+currNode.getType()+"\t"+"Input snippet: "+currNode.getCode());
 
            // Go to next node
            currNode = currNode.next;
        }
 
        System.out.println();
    }
 
    

}