import java.util.ArrayList;

/**
 * ParserNode
 */
public class ParserNode {

    public String value;
    public ParserNode parent;
    public ArrayList<ParserNode> children = new ArrayList<ParserNode>();
    public boolean isTerminalNode = false;
    public ParseTreeSize size;
    public int index;
    public int level;
    public int parentVal;
    public boolean namingError;
    public boolean forvar;
    public  String scopeValue;
    public String newName ;
    public boolean forFlag;
    public boolean call;
    public String Procscope;
    public String typeInfo;
    public String valueInfo;
   


    public ParserNode(String value, ParserNode parent, boolean isTerminal , String scope , String procScope)
    {
        this.value = value;
        this.parent = parent;
        this.isTerminalNode = isTerminal;
        this.namingError = false;
        this.forvar=false;
        this.Procscope=procScope;
       

        if (parent == null) {
            size = new ParseTreeSize();
            index = size.getNum();
            level = 0;
        }
        else
        {
            size = parent.size;
            index = size.getNum();
            level = parent.level + 1;
            parentVal = parent.level;
        }

       

    }

    public void addChild(ParserNode c)
    {
        children.add(c);
    }
    

    public void printTest()
    {
        
        
        if (parent == null) {
            //System.out.println("Num: " + index + " Value: " + value + " Scope"+ scopeValue  );
            System.out.println("Num: " + index + " Value: " + value+ " Parent "+ "null" +" NumOf children: " + children.size() );
        } else 
        {
            
            System.out.println("Num: " + index + " Value: " + value+ " Parent "+ parent.value +" NumOf children: " + children.size()  );
        }



        if (!isTerminalNode) {
            for (ParserNode parserNode : children) {
                parserNode.printTest();
            }
        }
    }

    
    public void ChangeNodeError(int id )
    {
      
       

       if(index==id)
       {
           namingError=true;
        
       }

        if (!isTerminalNode) 
        {
            for (ParserNode parserN : children) 
            {
                parserN.ChangeNodeError(id);
            }
        }
    }
  
    
    public ParserNode getNodeS(int id)
      {
        
        
        if(index==id)
        {
            
             return  this;
             
            
        }
         
        if (!isTerminalNode) 
        {
            for (ParserNode parserN : children) 
            {
                parserN.getNodeS( id  );
            }
        }
    

      return null;
      
    }
  
   

   
}