

public class States 
{
    public enum State 
    {


        S1(false),
        S2(false),
        S3(false),
        S4(false),
        S5(false),
        S6(false),
        S7(false),
        S8(false),
        S9(true),
        S10(false),
        S11(false),
        S12(false),
        S13(false),
        S14(false),
        S15(false),
        S16(false),
        S17(false),
        S18(false),
        S19(false),
        S20(false),
        S21(false),
        S22(false),
        S23(false),
        S24(false),
        S25(false),
        S26(false),
        S27(false),
        S28(false),
        S29(false),
        S30(false),
        S31(false),
        S32(false),
        S33(false),
        S34(false),
        SA(false),

        SE(false),
        SS(false);
        

        public final Boolean dfaState;

        private State(Boolean s)
        {
            this.dfaState=s;
        }

    }

    public State currentState;
    public int numberOfChars=0;

    public States()
    {
        currentState=State.S1;
    }

    public void resetDFA()
    {
        currentState=State.S1;
    }

    public void runThroughStates(State s , char c )
    {
        State curstate = s;

        switch(curstate)
        {
            case S1 :
            {
                numberOfChars=0;
               if(c == ',' || c == ';' || c == '{' || c == '}' || c == '(' || c == ')' || c == '=' || c == '<' || c == '>' )
               {
                     currentState=State.S9;
               }
               else if(c == ' ' || c == '\n' || c == '\t')
               {
                   resetDFA();
               }
               else if(c== '0')
               {
                   currentState=State.S33;
               }
               else if(  c == '1' || c == '2' || c == '3' ||c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9')
               {
                   currentState=State.S10;
               }
               else if(c == '-')
               {
                   currentState=State.S27;
               }
               else if(c == 'n')
               {
                   currentState=State.S3;
               }
               else if(c == 'i')
               {
                   currentState=State.S32;
               }
               else if(c == 'o')
               {
                   currentState=State.S4;
               }
               else if(c == 'm')
               {
                   currentState=State.S2;
               }
               else if(c == 'h')
               {
                   currentState=State.S31;
               }
               else if(c == 'e')
               {
                   currentState=State.S29;
               }
               else if(c == 's')
               {
                   currentState=State.S6;
               }
               else if(c == 'a')
               {
                   currentState=State.S28;
               }
               else if(c == 'f')
               {
                   currentState=State.S30;
               }
               else if(c == 'p')
               {
                   currentState=State.S5;
               }
               else if(c == 't')
               {
                   currentState=State.S7;
               }
               else if(c == 'w')
               {
                   currentState=State.S8;
               }
               else if(c == 'b' || c == 'c' || c == 'd' || c == 'g' || c == 'j' || c == 'k' || c == 'l' || c == 'q' || c == 'r' || c == 'u' || c == 'v'|| c == 'x' || c == 'y' || c == 'z')
               {
                   currentState=State.S34;
               }
               else if(c=='"')
               {
                   currentState=State.SA;
               }
               else
               {
                   currentState=State.SE;
               }
               
               
            }
            break;
            case S2:
            {
                if(c == 'u')
                {
                    currentState=State.S14;
                }
                else if(Character.toString(c).matches("[0-9]") || Character.toString(c).matches("[a-z]"))
                {
                    currentState=State.S34;
                }
                else
                {
                    currentState=State.SE; 
                }

            }
            break;
            case S3:
            {
                if(c == 'o')
                {
                    currentState=State.S16;
                }
                else if(Character.toString(c).matches("[0-9]") || Character.toString(c).matches("[a-z]"))
                {
                    currentState=State.S34;
                }
                else
                {
                    currentState=State.SE;
                }
            }
            break;
            case S4:
            {
                if(c == 'u')
                {
                    currentState=State.S17;
                }
                else if( c == 'r')
                {
                   currentState=State.S9;
                }
                else if(Character.toString(c).matches("[0-9]") || Character.toString(c).matches("[a-z]"))
                {
                    currentState=State.S34;
                }
                else
                {
                    currentState=State.SE;
                }
            }
            break;
            case S5:
            {
                if(c == 'r')
                {
                    currentState=State.S18;
                }
                else if(Character.toString(c).matches("[0-9]") || Character.toString(c).matches("[a-z]"))
                {
                    currentState=State.S34;
                }
                else
                {
                    currentState=State.SE;
                }
            }
            break;
            case S6:
            {
                if(c == 'u')
                {
                    currentState=State.S19;
                }
                else if(Character.toString(c).matches("[0-9]") || Character.toString(c).matches("[a-z]"))
                {
                    currentState=State.S34;
                }
                else
                {
                    currentState=State.SE;
                }

            }
            case S7:
            {
                if(c == 'h')
                {
                    currentState=State.S20;
                }
                else if(Character.toString(c).matches("[0-9]") || Character.toString(c).matches("[a-z]"))
                {
                    currentState=State.S34;
                }
                else
                {
                    currentState=State.SE;
                }

            }
            break;
            case S8:
            {
                if(c == 'h')
                {
                    currentState=State.S21;
                }
                else if(Character.toString(c).matches("[0-9]") || Character.toString(c).matches("[a-z]"))
                {
                    currentState=State.S34;
                }
                else
                {
                    currentState=State.SE;
                }
            }
            break;
            case S9:
            {
              //create a token and reset 
              numberOfChars=0;
              if(Character.toString(c).matches("[0-9]") || Character.toString(c).matches("[a-z]"))
              {
                  currentState=State.S34;
                  //System.out.println("Here");
              }
              else
              {
                resetDFA();
              }
                
               
              
            }
            break;
            case S10:
            {
              //split into more numbers 
              if(Character.toString(c).matches("[0-9]"))
              {
                  currentState=State.S10;
              }
              else if(c==' '|| c=='\n' || c=='\r' )
              {
                currentState=State.S9;
              }
              else
              {
                   currentState=State.SE;
              }
            }
            break;
            case S11:
            {
                if(c == 'd')
                {
                    currentState=State.S9;
                }
                else if(Character.toString(c).matches("[0-9]") || Character.toString(c).matches("[a-z]"))
                {
                    currentState=State.S34;
                }
                else
                {
                    currentState=State.SE;
                }
            }
            break;
            case S12:
            {
                if(c == 's')
                {
                    currentState=State.S22;
                }
                else if(Character.toString(c).matches("[0-9]") || Character.toString(c).matches("[a-z]"))
                {
                    currentState=State.S34;
                }
                else
                {
                    currentState=State.SE;
                }
            }
            break;
            case S13:
            {
                if(c == 'r')
                {
                    currentState=State.S9;
                }
                else if(Character.toString(c).matches("[0-9]") || Character.toString(c).matches("[a-z]"))
                {
                    currentState=State.S34;
                }
                else
                {
                    currentState=State.SE;
                }
            }
            break;
            case S14:
            {
                if(c == 'l')
                {
                    currentState=State.S16;
                }
                else if(Character.toString(c).matches("[0-9]") || Character.toString(c).matches("[a-z]"))
                {
                    currentState=State.S34;
                }
                else
                {
                    currentState=State.SE;
                }
            }
            break;
            case S15:
            {
                if(c == 'p')
                {
                    currentState=State.S23;
                }
                else if(Character.toString(c).matches("[0-9]") || Character.toString(c).matches("[a-z]"))
                {
                    currentState=State.S34;
                }
                else
                {
                    currentState=State.SE;
                }
            }
            break;
            case S16:
            {
                if(c == 't')
                {
                    currentState=State.S9;
                }
                else if(Character.toString(c).matches("[0-9]") || Character.toString(c).matches("[a-z]"))
                {
                    currentState=State.S34;
                }
                else
                {
                    currentState=State.SE;
                }
            }
            break;
            case S17:
            {
                if(c == 't')
                {
                    currentState=State.S15;
                }
                else if(Character.toString(c).matches("[0-9]") || Character.toString(c).matches("[a-z]"))
                {
                    currentState=State.S34;
                }
                else
                {
                    currentState=State.SE;
                }
            }
            break;
            case S18:
            {
                if(c == 'o')
                {
                    currentState=State.S24;
                }
                else if(Character.toString(c).matches("[0-9]") || Character.toString(c).matches("[a-z]"))
                {
                    currentState=State.S34;
                }
                else
                {
                    currentState=State.SE;
                }
            }
            break;
            case S19:
            {
                if(c == 'b')
                {
                    currentState=State.S9;
                }
                else if(Character.toString(c).matches("[0-9]") || Character.toString(c).matches("[a-z]"))
                {
                    currentState=State.S34;
                }
                else
                {
                    currentState=State.SE;
                }

            }
            break; 
            case S20:
            {
                if(c == 'e')
                {
                    currentState=State.S25;
                }
                else if(Character.toString(c).matches("[0-9]") || Character.toString(c).matches("[a-z]"))
                {
                    currentState=State.S34;
                }
                else
                {
                    currentState=State.SE;
                }
            }
            break;
            case S21:
            {
                if(c == 'i')
                {
                    currentState=State.S26;
                }
                else if(Character.toString(c).matches("[0-9]") || Character.toString(c).matches("[a-z]"))
                {
                    currentState=State.S34;
                }
                else
                {
                    currentState=State.SE;
                }
            }
            break;
            case S22:
            {
                if(c == 'e')
                {
                    currentState=State.S9;
                }
                else if(Character.toString(c).matches("[0-9]") || Character.toString(c).matches("[a-z]"))
                {
                    currentState=State.S34;
                }
                else
                {
                    currentState=State.SE;
                }

            }
            break;
            case S23:
            {
                if(c == 'u')
                {
                    currentState=State.S16;
                }
                else if(Character.toString(c).matches("[0-9]") || Character.toString(c).matches("[a-z]"))
                {
                    currentState=State.S34;
                }
                else
                {
                    currentState=State.SE;
                }

            }
            break;
            case S24:
            {
                if(c == 'c')
                {
                    currentState=State.S9;
                }
                else if(Character.toString(c).matches("[0-9]") || Character.toString(c).matches("[a-z]"))
                {
                    currentState=State.S34;
                }
                else
                {
                    currentState=State.SE;
                }

            }
            break;
            case S25:
            {

                if(c == 'n')
                {
                    currentState=State.S9;
                }
                else if(Character.toString(c).matches("[0-9]") || Character.toString(c).matches("[a-z]"))
                {
                    currentState=State.S34;
                }
                else
                {
                    currentState=State.SE;
                }

            }
            break;
            case S26:
            {
                if(c == 'l')
                {
                    currentState=State.S22;
                }
                else if(Character.toString(c).matches("[0-9]") || Character.toString(c).matches("[a-z]"))
                {
                    currentState=State.S34;
                }
                else
                {
                    currentState=State.SE;
                }

            }
            break;
            case S27:
            {
                if(c == '1' || c == '2' || c == '3' ||c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9')
               {
                   currentState=State.S10;
               }
               else
               {
                currentState=State.SE;  
               }

            }
            break;
            case S28:
            {
                if(c == 'd' || c == 'n')
                {
                    currentState=State.S11;
                }
                else if(Character.toString(c).matches("[0-9]") || Character.toString(c).matches("[a-z]"))
                {
                    currentState=State.S34;
                }
                else
                {
                    currentState=State.SE;
                }
            }
            break;
            case S29:
            {
                if(c == 'l')
                {
                    currentState=State.S12;
                }
                else if(c=='q')
                {
                    currentState=State.S9;
                }
                else if(Character.toString(c).matches("[0-9]") || Character.toString(c).matches("[a-z]"))
                {
                    currentState=State.S34;
                }
                else
                {
                    currentState=State.SE;
                }

            }
            break;
            case S30:
            {
                if(c == 'o')
                {
                    currentState=State.S13;
                }
                else if(Character.toString(c).matches("[0-9]") || Character.toString(c).matches("[a-z]"))
                {
                    currentState=State.S34;
                }
                else
                {
                    currentState=State.SE;
                }
            }
            break;
            case S31:
            {
                if(c == 'a')
                {
                    currentState=State.S14;
                }
                else if(Character.toString(c).matches("[0-9]") || Character.toString(c).matches("[a-z]"))
                {
                    currentState=State.S34;
                }
                else
                {
                    currentState=State.SE;
                }

            }
            break;
            case S32:
            {
                if(c == 'f')
                {
                    currentState=State.S9;
                }
                else if(c == 'n')
                {
                    currentState=State.S15;
                }
                else if(Character.toString(c).matches("[0-9]") || Character.toString(c).matches("[a-z]"))
                {
                    currentState=State.S34;
                }
                else
                {
                    currentState=State.SE;
                }

            }
            break;
            case S33:
            {
                if(Character.toString(c).matches("[0-9]"))
               {
                  currentState=State.SE;
               }
               else
               {
                   currentState=State.S9;
               }

            }
            break;
            case S34:
            {
                
                if(Character.toString(c).matches("[0-9]") || Character.toString(c).matches("[a-z]"))
                {
                    currentState=State.S34;
                }
                else
                {
                  currentState=State.S9;
                }

            }
            break;
            case SE:
            {
                numberOfChars=0;
                if(c==' ' || c=='\n' || c=='\r' )
                {
                    resetDFA();
                }
                else
                {
                    currentState=State.SE;
                }

            }
            break;
            case SA:
            {
                
                
                 if(numberOfChars<=8)
                 {
                    
                    if(c=='"')
                    {
                        //System.out.println("VALID");
                        currentState=State.S9;
                        
   
                    }
                    else if(Character.toString(c).matches("[0-9]") || Character.toString(c).matches("[a-z]"))
                    {
                        currentState=State.SA;
                    }
                    else if(c==' ')
                    {
                        currentState=State.SA;
                    }
                    else
                    {
                        currentState=State.SE;

                    }
                    
                 }
                 
                
                 else
                 {
                    currentState=State.SS;
                 }
                 //System.out.println(numberOfChars);
               numberOfChars++;  
                 
            }
            break;
            case SS:
            {
                numberOfChars=0;
                if(c==' ' || c=='\n' || c=='\r' )
                {
                    resetDFA();
                }
                else
                {
                    currentState=State.SS;
                }
            }
        }
    }
        
    
}
