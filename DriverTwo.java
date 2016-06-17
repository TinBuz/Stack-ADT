/*
 * Purpose: Data Structures and Algorithms Lab 5 Problem 2
 * Status: Complete and tested
 * Last Update: 2/24/2016
 * Submitted: 2/25/2016
 * Comment: Applcation class with i/o attached
 * @author: Tin Buzancic
 * @version: 2016.25.02
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class DriverTwo
{
    private static BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException
    {
	Stack<Layer> bag = new Stack<Layer>();
	Stack<Double> sampleBag = new Stack<Double>();
        int layers = 0;
        int sampleItems = 0;
        double bagWeight = 0.0;
        double sampleBagWeight = 0.0;
        DecimalFormat df = new DecimalFormat("##.##");

        while(true)
        {
            System.out.println("Select from the following menu: ");
            System.out.println("		1. Place a layer of item(s) in the bag.");
            System.out.println("		2. Remove a layer of item(s) from the bag.");
            System.out.println("		3. Display the weight of the bag.");
            System.out.println("		4. Display the number of layers in the bag.");
            System.out.println("		5. Display the number of items and the weight of the sample bag.");
            System.out.println("		6. Remove an item from the sample bag.");
            System.out.println("		7. Empty the sample bag.");
            System.out.println("		8. Exit");
            System.out.print("Make your menu selection now: ");
            String response = bReader.readLine().trim();
            System.out.println(response);
            switch(response)
            {
            case "8":
                System.out.println("You have exited. Thank you.\n");
                System.exit(0);
                break;
            case "1":
                System.out.print("Enter number of items to place in the bag: ");
                int numItems = Integer.parseInt(bReader.readLine().trim());
                System.out.println(numItems);
                System.out.print("Enter weight of item (lb): ");
                double weight = Double.parseDouble(bReader.readLine().trim());
                System.out.println(weight);
                Layer newestLayer = new Layer(numItems, weight);
                bag.push(newestLayer);
                System.out.println(numItems + " items weighing " + (df.format(weight)) + " lbs have been placed in the bag.\n");
                layers++;
                double plusBagWeight = bag.peek().getNumItems() * bag.peek().getWeight();
                bagWeight += plusBagWeight;
                break;
            case "2":
                if(bag.isEmpty())
                {
                    System.out.println("ERROR: Empty Bag.\n");
                }
                else
                {
                    bagWeight -= (bag.peek().getNumItems() * bag.peek().getWeight());
                    System.out.println(bag.peek().getNumItems() + " item(s) have been removed from the bag.\n");
		    System.out.print("Would you like to store a sample from the layer?(Y/N) : ");
    		    response = bReader.readLine().trim();
    		    System.out.println(response);
    		    if(response.equalsIgnoreCase("Y"))
    		    {
        		sampleBag.push(bag.peek().getWeight());
        		System.out.println("Sample Stored.\n");
        		sampleItems++;
			sampleBagWeight += sampleBag.peek();
    		    }
                    bag.pop();
                    layers--;
                }
		break;
            case "3":
                if(bag.isEmpty())
                {
                    System.out.println("The bag is empty: Weight is 0 lbs.\n");
                }
                else
                {
                    System.out.println("The weight of the bag is " + df.format(bagWeight) + " lbs.\n");
                }
                break;
            case "4":
                if(bag.isEmpty())
                {
                    System.out.println("The bag is empty: No Layers.\n");
                }
                else
                {
                    System.out.println("The number of layers in the bag is " + layers + ".\n");
                }
                break;
            case "5":
                if(sampleBag.isEmpty())
                {
                    System.out.println("The sample bag is empty: No Items.\n");
                }
                else
                {
                    System.out.println("The number of items in the sample bag is " + sampleItems + ".\nThe sample bag weights " + df.format(sampleBagWeight) + " lbs.\n");
                }
		break;
            case "6":
                if(sampleBag.isEmpty())
                {
                    System.out.println("ERROR: Empty sample bag.\n");
                }
                else
                {
                    System.out.println("An item weighing " + df.format(sampleBag.peek()) + " lbs has been removed from the sample bag.\n");
                    sampleItems--;
                    sampleBagWeight -= sampleBag.peek();
                    sampleBag.pop();
                }
                break;
            case "7":
                if(sampleBag.isEmpty())
                {
                    System.out.println("ERROR: Empty sample bag.\n");
                }
                else
                {
                    sampleItems = 0;
                    sampleBagWeight = 0.0;
                    sampleBag.popAll();
                    System.out.println("The sample bag has been emptied.\n");
                }
                break;
            default:
                System.out.println("Not valid. Please enter again.\n");
                break;
            }
        }
    }
}
