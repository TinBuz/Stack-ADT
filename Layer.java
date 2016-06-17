/* Purpose: Data Structures and Algorithms Lab 5
 * Status: Complete and tested
 * Last Update: 2/24/2016
 * Submitted: 2/25/2016
 * Comment: This holds info about each layer within the stack
 * @author: Tin Buzancic
 * @version: 2016.25.02
 */
public class Layer
{
    private int numItems = 0;
    private double weight = 0.0;

    public Layer(int numItems, double weight)
    {
        this.numItems = numItems;
        this.weight = weight;
    }

    public int getNumItems()
    {
        return this.numItems;
    }

    public void setNumItems(int numItems)
    {
        this.numItems = numItems;
    }

    public double getWeight()
    {
        return this.weight;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }
}
