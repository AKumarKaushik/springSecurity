package java4_Assgnmnt;

import java.util.Stack;
public class Q7_Stack extends Stack<Integer>
{
    Stack<Integer> min = new Stack<>();
    void push(int x)
    {
        if(isEmpty() == true)
        {
            super.push(x);
            min.push(x);
        }
        else
        {
            super.push(x);
            int y = min.pop();
            min.push(y);
            if(x < y)
                min.push(x);
            else
                min.push(y);
        }
    }

    public Integer pop()
    {
        int x = super.pop();
        min.pop();
        return x;
    }
    /* Method to get minimum element from it. */
    int getMin()
    {
        int x = min.pop();
        min.push(x);
        return x;
    }
    /* Driver program to test NewStack methods */
    public static void main(String[] args)
    {
        Q7_Stack s = new Q7_Stack();
        s.push(15);
        s.push(2);
        s.push(1);
        s.push(20);
        s.push(60);
        System.out.println("Elements after push operation : "+ s);
        //System.out.println(s.getMin());
        s.pop();
        System.out.println("Elements in stack after a pop operation:"+ s);
        System.out.println(" Min element is: "+ s.getMin());
    }
}
