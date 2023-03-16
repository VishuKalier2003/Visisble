/* There are n people standing in a queue, and they numbered from 0 to n - 1 in left to right order... You are given an array heights of distinct integers where heights[i] represents the height of the ith person... A person can see another person to their right in the queue if everybody in between is shorter than both of them... Return an array answer of length n where answer[i] is the number of people the ith person can see to their right in the queue... 
 * Eg 1: queue = [10,6,8,5,11,9]         Output = [3,1,2,1,1,0]
 * Eg 2: queue = [5,1,2,3,10]            Output = [4,1,1,1,0]
 * Eg 3: queue = [6,4,11,5,7,15,1]       Output = [2,1,3,1,1,1,0]
*/
import java.util.*;
public class Visible
{
    public int[] Visibility(int heights[])
    {
        int ans[] = new int[heights.length];
        Stack<Integer> stack = new Stack<Integer>();    // Using it as a Monotonic Stack...
        for(int i = heights.length-1; i >= 0; --i)
        {   // Iterating through the Array...
            while(!stack.isEmpty() && heights[i] > stack.peek())   // If a person at left is taller than right, that person will obstruct the view of others from the left...
            {
                stack.pop();
                ++ans[i];     // Incrementing the number of people visible...
            }
            if(!stack.isEmpty())
                ans[i]++;         // The shorter one on left can see the taller ones...
            stack.push(heights[i]);
        }
        return ans;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x;
        System.out.print("Enter the number of People in the Queue : ");
        x = sc.nextInt();
        int people[] = new int[x];
        for(int i = 0; i < people.length; i++)
        {
            System.out.print("Enter the height of the "+(i+1)+" th Person : ");
            people[i] = sc.nextInt();
        }
        Visible visible = new Visible();         // Object creation...
        people = visible.Visibility(people);      // Function call...
        System.out.println("The Number of People Visible Array : ");
        for(int i = 0; i < people.length; i++)
            System.out.print(people[i]+", ");
        sc.close();
    }
}

// Time Complexity  - O(n) time...
// Space Complexity - O(n) space...

/* DEDUCTIONS :- 
 * 1. We can Traverse from right to left, and if a person at left is found taller than the person at right, that person will obstruct the view of other person at left...
 * 2. Also, if the person at far left, is taller than the person at present index, it can view all the people unless a taller one is found...
 * 3. Using an Increasing Monotonic Stack, to store the heights os people in increasing fashion at particular index, will solve the problem effectively...
*/