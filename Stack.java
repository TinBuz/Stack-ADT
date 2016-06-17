/*
 * Purpose: Data Structures and Algorithms Lab 5
 * Status: Complete and tested
 * Last update: 2/24/2016
 * SubmittedL: 2/25/2016
 * Comment: Stack class
 * @author: Tin Buzancic
 * @version: 2016.25.02
 */

public class Stack<T> implements StackInterface<T> 
{
    //instance variables

    private T[] items;
    private int top;

    public Stack()
    {
        items = (T[])new Object[3];
        top = -1;
    }

    @Override
    public boolean isEmpty()
    {
        return (top == -1);
    }

    @Override
    public T pop()
    {
        T result = null;
        if(top != -1)
        {
            result = items[top];
            items[top--] = null;
        }
        return result;
    }


    @Override
    public void popAll()
    {
        items = (T[])new Object[3];
        top = -1;
    }

    @Override
    public void push(T newItem) throws StackException
    {
        if(top == items.length - 1)
        {
            resize();
        }
        items[++top] = newItem;
    }

    @Override
    public T peek() throws StackException
    {
        T result = null;
        if(top != -1)
        {
            result = items[top];
        }
        return result;
    }

    public void resize()
    {
        T[] temp = (T[])new Object[(int)(items.length * 1.5)];
        for(int i = 0; i < items.length; i++)
        {
            temp[i] = items[i];
        }
        items = temp;
    }

    public String toString()
    {
        String result = "";
        for(int i = 0; i <= top; i++)
        {
            result += items[i] + " ";
        }
        return result;
    }
}
