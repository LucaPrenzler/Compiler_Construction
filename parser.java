
import java.util.ArrayList;
import java.util.Iterator;




public class parser 
{

    public ArrayList<String> lexarArr = new ArrayList<String>();
    
    public Iterator<String> it;
    public int x;

    public ParserNode hNode = null;
    Node tokens;
    String scope = "0";
    int s=1;
    int p=1;
    public int newName=0;
    public int newProcedure=0;
    public boolean flagfor=false;
    String procScope = "0";
    Boolean error;


    //practical 4 variables used and declared 

    public ArrayList<ParserNode> variablesUsed = new ArrayList<ParserNode>();
    public ArrayList<ParserNode> procedureNames = new ArrayList<ParserNode>();
    public ArrayList<ParserNode> callNames = new ArrayList<ParserNode>();
    



    public parser(LinkedList list , Boolean Error)
    {
        x=0;
        list.insert(list, list.size, "End", "$");
        tokens=list.head;
        this.error = Error;
        list.printList(list);
       //System.out.println(list.size);
        S();

        hNode.printTest();   
    }
   
    public void match(String in, ParserNode n)
    {
        
        if (in.equals(tokens.getCode()) && tokens.next!=null) 
        {
             
            ParserNode node = new ParserNode(in, n, true , scope , procScope);
            n.addChild(node);
            tokens=tokens.next;
            
        }
        else if (in.equals("$") && tokens.next==null) {

            ParserNode node = new ParserNode(in, n, true , scope , procScope);
            n.addChild(node);
            end();
        }
        else
        {
            error(tokens.getCode());
        }
       
        
    }

    

    public void matchType(String in, ParserNode n)
    {
        if (in.equals(tokens.getType()) && tokens.next!=null) 
        {
            
            ParserNode node = new ParserNode(tokens.getCode(), n, true , scope , procScope);
            n.addChild(node);
            tokens=tokens.next;
            
        }
        else if (in.equals("$") && tokens.next==null) 
        {

            ParserNode node = new ParserNode(in, n, true , scope , procScope);
            n.addChild(node);
            end();
        }
        else 
        {
            error(tokens.getCode());
        }
        
    }
   
   

    public void end()
    {
        System.out.println("SUCCESS !!!");
       
    }
   
    public void S()
    {
       
        hNode = new ParserNode("Start", null, false , scope , procScope);
        ParserNode node = hNode;
        
        if(tokens.getCode().matches("halt") || tokens.getCode().matches("input") || tokens.getCode().matches("output") || tokens.getCode().matches("if") || tokens.getCode().matches("while") || tokens.getCode().matches("for")  && tokens.next!=null)
        {
          A(node); match("$" , node );

        }
        else if(tokens.getType().matches("Variable") && tokens.next!=null)
        {
            A(node); match("$" , node );
        }
        else if(tokens.getCode().matches("$"))
        {
            match("$", node);
        }
       
        return;
    }

    
    public void A(ParserNode p)
    {
        
        ParserNode node = new ParserNode("PROG", p, false , scope , procScope);
        p.addChild(node);
        if(tokens.getCode().matches("halt") || tokens.getCode().matches("input") || tokens.getCode().matches("output") || tokens.getCode().matches("if") || tokens.getCode().matches("while") || tokens.getCode().matches("for")  && tokens.next!=null)
        {
          C(node);AA(node);
        }
        else if(tokens.getType().matches("Variable") && tokens.next!=null)
        {
            C(node);AA(node);
        }
        else if(tokens.getCode().matches("$"))
        {
            match("$", node);
        }
        else
        {
            error(tokens.getCode());
        }
       
        return;

    }

    public void AA(ParserNode node)
    {
        
         if(tokens.getCode().equalsIgnoreCase(";") && tokens.next!=null)
         {
            match(";" , node); PD(node);
         }
         else if(tokens.getCode().matches("$"))
        {
            match("$", node);
        }
        else
        {
            E(node);
        }
         return;
    }
    public void F(ParserNode p)
    {
        
        ParserNode node = new ParserNode("PROG_DEFINITION", p, false , scope , procScope);
        p.addChild(node);
        if(tokens.getCode().matches("proc") && tokens.next!=null)
         {
            PD(node);
         }
         else if(tokens.getCode().matches("$"))
        {
            match("$", node);
        }
        else
        {
            E(node);
        }
         return;
        
    }
    public void PD(ParserNode p)
    {
       
        ParserNode node = new ParserNode("PROC", p, false , scope , procScope);
        p.addChild(node);
        
        if(tokens.getCode().matches("proc") && tokens.next!=null)
         {
           
            match("proc" , node);
            matchType("Variable" , node); match("{", node); A(node) ; match("}", node);F(node);
          
         }
         else if(tokens.getCode().matches("$"))
        {
            match("$", node);
        }
        else
        {
            error(tokens.getCode());
        }
         return;
    }
    public void C(ParserNode p)
    {
        
        ParserNode node = new ParserNode("CODE", p, false  , scope , procScope);
        p.addChild(node);
        if(tokens.getCode().matches("halt") || tokens.getCode().matches("input") || tokens.getCode().matches("output") || tokens.getCode().matches("if") || tokens.getCode().matches("while") || tokens.getCode().matches("for") && tokens.next!=null)
         {
           I(node); CC(node);
         }
         else if(tokens.getType().matches("Variable") && tokens.next!=null)
        {
            I(node); CC(node);
        }
        else if(tokens.getCode().matches("$"))
        {
            match("$", node);
        }
        else
        {
            E(node);
        }
         return;
    }
    public void CC(ParserNode node)
    {
        
        if(tokens.getCode().matches(";") && tokens.next!=null)
         {
            if(tokens.next.getCode().equalsIgnoreCase("proc"))
            {
                return;
            }
            else if(tokens.next.getCode().equalsIgnoreCase("$"))
            {
                error(tokens.getCode());
            }
            else
            {
                match(";" , node); C(node);
            }
            
         }
         else if(tokens.getCode().matches("$"))
        {
            match("$", node);
        }
        else
        {
            E(node);
        }
         return;
        
    }
    public void I(ParserNode p)
    {
        
        ParserNode node = new ParserNode("INSTRUCTION", p, false , scope , procScope);
        p.addChild(node);
        if(tokens.getCode().matches("halt") && tokens.next!=null)
         {
            match("halt", node);
         }
         else if(tokens.getCode().matches("input") || tokens.getCode().matches("output") && tokens.next!=null)
         {
             O(node);
         }
         else if(tokens.getType().matches("Variable") && tokens.next!=null)
        {
            if(tokens.next.getCode().equals("="))
            {
                AS(node);
            }
            else
            {
                L(node);
            }
            
        }
         else if(tokens.getCode().matches("if")&& tokens.next!=null)
         {
             CB(node);
         }
         else if(tokens.getCode().matches("while") || tokens.getCode().matches("for") && tokens.next!=null)
         {
             CL(node);
         }
         else if(tokens.getCode().matches("$"))
        {
            match("$", node);
        }
        else
        {
            error(tokens.getCode());
        }
         return;
        
    }
    public void O(ParserNode p)
    {
        
        ParserNode node = new ParserNode("IO", p, false , scope ,procScope);
        p.addChild(node);
        if(tokens.getCode().matches("input")&& tokens.next!=null)
        {
            match("input" , node); match("(" , node); V(node); match(")" , node);
        }
        else if(tokens.getCode().matches("output")&& tokens.next!=null)
        {
            match("output", node); match("(" , node); V(node); match(")" , node);
        }
        else if(tokens.getCode().matches("$"))
        {
            match("$", node);
        }
        else
        {
            error(tokens.getCode());
        }
        return;
    }
    public void V(ParserNode p)
    {
       
        ParserNode node = new ParserNode("VAR", p, false , scope , procScope);
        p.addChild(node);
        if(tokens.getType().matches("Variable"))
        {
            
            matchType("Variable" , node);
        }
        else if(tokens.getCode().matches("$"))
        {
            match("$", node);
        }
        else
        {
            error(tokens.getCode());
        }
        return;
    }

    public void L(ParserNode p)
    {
        
        ParserNode node = new ParserNode("CALL", p, false , scope , procScope);
        p.addChild(node);
        if(tokens.getType().matches("Variable"))
        {
            matchType("Variable" , node);
        }
        else if(tokens.getCode().matches("$"))
        {
            match("$", node);
        }
        else
        {
            
            error(tokens.getCode());
            
        }
        return;
    }
    public void AS(ParserNode p)
    {
        
        ParserNode node = new ParserNode("ASSIGN", p, false , scope , procScope);
        p.addChild(node);
        if(tokens.getType().matches("Variable") && tokens.next!=null)
        {
            
            V(node); 
            match("=" , node); ASS(node);
        }
        else if(tokens.getCode().matches("$"))
        {
            match("$", node);
        }
        else
        {
            error(tokens.getCode());
        }
        return;
    }
    public void ASS(ParserNode node)
    {
        
        if(tokens.getType().matches("Variable") && tokens.next!=null)
        {
           V(node);
        }
        else if(tokens.getType().matches("String") && tokens.next!=null)
        {
            matchType("String" , node);
        }
        else if(tokens.getType().matches("Number") || tokens.getCode().matches("sub") || tokens.getCode().matches("add") || tokens.getCode().matches("mult") && tokens.next!=null)
        {
            N(node);
        }
        else if(tokens.getCode().matches("$"))
        {
            match("$", node);
        }
        else
        {
            error(tokens.getCode());
        }
        return;
        
    }

    public void N(ParserNode p)
    {
        
        ParserNode node = new ParserNode("NUMBER", p, false , scope , procScope);
        p.addChild(node);
        if(tokens.getType().matches("Number")&& tokens.next!=null)
        {
            matchType("Number" , node); 
        }
        else if(tokens.getCode().matches("sub") || tokens.getCode().matches("add") || tokens.getCode().matches("mult")&& tokens.next!=null)
        {
            CA(node);
        }
        else if(tokens.getType().equalsIgnoreCase("Variable"))
        {
            V(node);
        }
        else if(tokens.getCode().matches("$"))
        {
            match("$", node);
        }
        else
        {
            error(tokens.getCode());
        }
        return;
        
    }
    public void CA(ParserNode p)
    {
        
        ParserNode node = new ParserNode("CALC", p, false , scope , procScope);
        p.addChild(node);
        if(tokens.getCode().matches("sub")&& tokens.next!=null)
        {
            match("sub" , node); match("(" , node); N(node); match("," , node); N(node); match(")" , node);
        }
        else if(tokens.getCode().matches("add")&& tokens.next!=null)
        {
            match("add", node); match("(" , node); N(node); match("," , node); N(node); match(")" , node);
        }
        else if(tokens.getCode().matches("mult")&& tokens.next!=null)
        {
            match("mult" , node); match("(", node); N(node); match("," , node); N(node); match(")" , node);
        }
        else if(tokens.getCode().matches("$"))
        {
            match("$", node);
        }
        else
        {
            error(tokens.getCode());
        }
        return;
    }

    public void CB(ParserNode p)
    {
        
        ParserNode node = new ParserNode("CONDITIONAL_BRANCH", p, false , scope , procScope);
        p.addChild(node);
        if(tokens.getCode().matches("if")&& tokens.next!=null)
        {
           match("if" , node); match("(" , node); B(node); match(")" , node); match("then" , node); match("{" , node) ; C(node); match("}" , node); CBB(node); 
        }
        else if(tokens.getCode().matches("$"))
        {
            match("$", node);
        }
        
        return;
    }
    public void CBB(ParserNode node)
    {
        
        if(tokens.getCode().matches("else")&& tokens.next!=null)
        {
            match("else" , node) ; match("{" , node) ;  C(node) ; match("}" , node);
        }
        else if(tokens.getCode().matches("$"))
        {
            match("$", node);
        }
        else
        {
            E(node);
        }
        
        
        return;
        
    }
    
    public void E(ParserNode p)
    {
        
      return;
        
    }
   

  
   
    
    public void B(ParserNode p)
    {
        //System.out.println("B");
        ParserNode node = new ParserNode("BOOL", p, false , scope , procScope);
        p.addChild(node);
        if( tokens.getCode().equalsIgnoreCase("(") && tokens.next != null)
        {
             match("(" , node); V(node); VV(node);
        }
        else if (tokens.getCode().matches("eq") && tokens.next!=null)
        {
            match("eq" , node); match("(" , node); BB(node);
        }
        else if(tokens.getCode().matches("not") && tokens.next!=null)
        {
            match("not" , node); B(node);
        }
        else if(tokens.getCode().matches("and") && tokens.next!=null)
        {
            match("and" , node); match("(" , node); B(node); match("," , node); B(node); match(")" , node);
        }
        else if(tokens.getCode().matches("or") && tokens.next!=null)
        {
            match("or" , node); match("(", node); B(node); match("," , node); B(node); match(")" , node);
        }
        else if(tokens.getCode().matches("$"))
        {
            match("$", node);
        }
        else
        {
            error(tokens.getCode());
        }
        return;
        
    }
    
   
    public void BB(ParserNode node)
    {
       
        if(  tokens.getCode().equalsIgnoreCase("(") || tokens.getCode().matches("eq") ||  tokens.getCode().matches("not") || tokens.getCode().matches("and") || tokens.getCode().matches("or") && tokens.next!=null)
        {
            B(node); match("," , node); B(node); match(")" , node);
        } 
        else if(tokens.getType().matches("Variable") && tokens.next!=null)
        {
            V(node); match("," , node); 
            if(tokens.getType().matches("Variable"))
            {
                V(node);
            }
            else if(tokens.getType().matches("Number"))
            {
                N(node);
            }
            match(")" , node);
            
        }
        else if (tokens.getType().matches("Number")||tokens.getCode().matches("sub") || tokens.getCode().matches("add") || tokens.getCode().matches("mult") && tokens.next!=null)
        {
            N(node);match("," , node); N(node); match(")" , node);
        }
        else if(tokens.getCode().matches("$"))
        {
            match("$", node);
        }
        return;
    }
    
    public void VV(ParserNode node)
    {
        
        if(tokens.getCode().matches("<") && tokens.next!=null)
        {
            match("<" , node); V(node); match(")" , node);
        }
        else if(tokens.getCode().matches(">") && tokens.next!=null)
        {
            match(">" , node); V(node); match(")" , node);
        }
        else if(tokens.getCode().matches("$"))
        {
            match("$", node);
        }
        return;
    }
    public void CL(ParserNode p)
    {
       
        ParserNode node = new ParserNode("CONDITIONAL_LOOP", p, false , scope , procScope);
        p.addChild(node);
        if(tokens.getCode().matches("while") && tokens.next!=null)
        {
            match("while" , node); match("(" , node); B(node); match(")" , node); match("{" , node); C(node); match("}" , node);
        }
        else if(tokens.getCode().matches("for") && tokens.next!=null)
        {
            match("for" , node);match("(" , node); V(node); match("=" , node); match("0" , node); match(";" , node); V(node); match("<" , node); V(node); match(";" , node); 
            V(node); match("=" , node); match("add" , node);match("(" , node); V(node); match("," , node); match("1" , node); match(")" , node); match(")" , node);match("{" , node); C(node); match("}" , node);
        }
        else if(tokens.getCode().matches("$"))
        {
            match("$", node);
        }
        else
        {
            error(tokens.getCode());
        }
        return;
    }

   public void error(String p)
    {
       System.out.println("Syntax error encountered at "+p+" token. Tree generated before the error is: ");
       //hNode.printNode();
       hNode.printTest();
       //System.exit(0);
      
    }

    

   
   
   

    
}
