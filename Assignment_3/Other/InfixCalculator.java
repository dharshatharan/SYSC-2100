public class InfixCalculator
    {
        private StackListBased stack; 
        private String infix; 
        private String postfix; 
        private int result; 
    
        /**
         * Constructor for objects of class InfixCalculator
         */
        public InfixCalculator(String input)
        {
            stack = new StackListBased(); 
            infix = input + " ";
            postfix = ""; 
            result = 0;
        }
    
        /**
         * 
         */
        public void evaluateInfix()
        {
            convertPostfix();
            result = getPostfix();
            printOperation();
        }
        
        /**
         * 
         */
        public void convertPostfix()
        {
            int i = 0; 
            String j = "";  
            String next = ""; 

            while(i < infix.length()) 
            {
                j = Character.toString(infix.charAt(i)); 
                if(isOperand(j)){
                    next = Character.toString(infix.charAt(i+1));
                    postfix = postfix + j;
                    while(isOperand(next)){ 
                        postfix = postfix + next;
                        i++;
                        next = Character.toString(infix.charAt(i+1));
                    }
                    postfix = postfix + " "; 
                    
                } else if(j.equals("("))
                {
                    stack.push(j); 
                } else if(j.equals(")"))
                {
                    while (!stack.peek().equals("("))
                    {
                        postfix = postfix + stack.pop()+" "; 
                    }
                    stack.pop();  
                } else if(isOperator(j))
                {
                    while (!stack.isEmpty() &&!stack.peek().equals("(")
                                && precedence(j) <= precedence((String) stack.peek()))
                    {
                        postfix = postfix + stack.pop()+" "; 
                    }
                    stack.push(j); 
                }
                i++;
            }
            
            while (!stack.isEmpty())
            {
                
                postfix = postfix + stack.pop()+" ";
            }
        }
        
        /**
         * 
         * @return int
         */
        public int getPostfix()
        {
            int operand1;
            int operand2;
            int i = 0;
            String j = ""; 
            int temp = 0;
            while(i < postfix.length()) 
            {
                j = Character.toString(postfix.charAt(i));
                if(isOperand(j)){
                    
                    
                    String next = Character.toString(postfix.charAt(i+1));
                    while(isOperand(next)){
                        j = j + next;
                        i++;
                        next = Character.toString(postfix.charAt(i+1));
                    }
                    
                    stack.push(Integer.parseInt(j)); 
                } else if (isOperator(j)) {
                    operand2 = (Integer) stack.pop();
                    operand1 = (Integer) stack.pop();
                    
                    if (j.equals("/"))
                    {
                        temp = operand1 / operand2;
                    }
                    if (j.equals("*"))
                    {
                        temp = operand1 * operand2;
                    }
                    if (j.equals("+"))
                    {
                        temp = operand1 + operand2;
                    }
                    if (j.equals("-"))
                    {
                        temp = operand1 - operand2;
                    }
                    
                    stack.push(temp); 
                }
                i++;
            }
            return temp;
        }
        
        /** 
         * 
         * @return boolean,
         */
        private boolean isOperand(String value)
        {
            return (value.equals("0")|value.equals("1")|value.equals("2")|value.equals("3")|value.equals("4")|
                    value.equals("5")|value.equals("6")|value.equals("7")|value.equals("8")|value.equals("9"));
        }
        
        /**
         * 
         * 
         * @return boolean
         */
        public boolean isOperator(String value)
        {
            return (value.equals("+")|value.equals("-")|value.equals("*")|value.equals("/"));
        }
        
        /**
         * 
         */
        private void printOperation()
        {
            System.out.println("infix: " + infix);
            System.out.println("postfix: " + postfix);
            System.out.println("result: " + result);
        }
        
        /**
         * 
         * @return boolean
         */
        private int precedence(String op)
        {
           if (op.equals("+")|op.equals("-"))
           {
               return 0;
           } else if (op.equals("*")|op.equals("/")){
               return 1;
           }
           return -1;
        }
}
