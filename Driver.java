/* Purpose: Data Structure and Algorithms Lab 5 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 02/25/2016
 * Submitted:  02/25/2016
 * Comment: Application class with i/o attached
 * @author: Tin Buzancic
 * @version: 2016.25.02
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Driver 
{
    public static BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException
    {
        Stack<Object> stack = new Stack<Object>();
        while(true)
        {
            System.out.println("Select from the following menu: ");
            System.out.println("		1. Push item onto stack.");
            System.out.println("		2. Pop item from stack.");
            System.out.println("		3. Display top item from stack.");
            System.out.println("		4. Clear stack.");
            System.out.println("		5. Exit.");
            System.out.print("Make your menu selection now: ");
            String response = bReader.readLine().trim();
            System.out.println(response);
            switch(response)
            {
            case "5":
		System.out.println("You have exited the program.\n");
		System.exit(0);
		break;
            case "1":
                System.out.print("Please enter the name of the item: ");
                String newItem = bReader.readLine().trim();
                System.out.println(newItem);
                stack.push(newItem);
                System.out.println("Item " + newItem + " was successfully pushed onto the stack.\n");
                break;
            case "2":
                if(stack.isEmpty())
                {
                    System.out.println("Stack is empty.\n");
                }
                else
                {
                    System.out.println("Item " + stack.peek() + " was successfully popped from the stack.\n");
                    stack.pop();
                }
                break;
            case "3":
                if(stack.isEmpty())
                {
                    System.out.println("List is empty.\n");
                }
                else
                {
                	System.out.println(stack.toString());
                    System.out.println("Item " + stack.peek() + " is on top of the stack.\n");
                }
                break;
            case "4":
		if(stack.isEmpty())
		{
			System.out.println("List is already empty.\n");
		}
		else
		{
                	System.out.println("Items " + stack.toString() + " have been removed from the stack.\n");
			stack.popAll();
                }
		break;
            default:
		System.out.println("Invalid please try again.\n");
		break;
            }
        }
    }
}
