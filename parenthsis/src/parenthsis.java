import java.util.*;

public class parenthsis {

    // function to check if brackets are balanced
    static boolean areParaOpen(String expr)
    {
// Using ArrayDeque is faster than using Stack class
        Deque<Character> stack
                = new ArrayDeque<Character>();

// Traversing the Expression
        for (int i = 0; i < expr.length(); i++)
        {
            char x = expr.charAt(i);

            if (x == '(' || x == '[' || x == '{')
            {
// Push the element in the stack
                stack.push(x);
                continue;
            }

// If current character is not opening
// bracket, then it must be closing. So stack
// cannot be empty at this point.
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }

// Check Empty Stack
        return (stack.isEmpty());
    }



    public static void main(String[] args)
    {
        String expr = "{a+b+(d-e-f+d))}";
//Main myObj = new Main();
// Function call
        if (areParaOpen(expr))
            System.out.println("All Parantheses closed and Nested ");
        else
            System.out.println("Not all Parantheses closed and Nested");
    }
}