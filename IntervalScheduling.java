/**
 * Interval Scheduling
 * Assignment: HW 3 CS577
 * Author: Jason Lee (jlee967@wisc.edu)
 * 
 */

import java.util.*;

public class IntervalScheduling 
{
    public static void main(String [] args)
    {
        Scanner kb = new Scanner(System.in);

        String lines = kb.nextLine().trim();
        int num = Integer.parseInt(lines);
       
        ArrayList <String[]> instanceList = new ArrayList <String [] > (num);

        for(int i = 1; i <= num; i++)
        {
            lines = kb.nextLine().trim();
            int jobCount = Integer.parseInt(lines);
            int jobKey = 0;

            String [] instance = new String[jobCount]; 

            while(jobKey < jobCount)
            {
                String job = kb.nextLine().trim();
                instance[jobKey] = job;

                jobKey++;
            }

            instanceList.add(instance);
        }

        for(int i = 0; i < instanceList.size(); i++)
        {
            int thisIsTheOtherCount = jobSort(instanceList.get(i));

            System.out.println(thisIsTheOtherCount);
        }

        kb.close();
    }

    private static int jobSort(String [] inst)
    {
        int index = 1;
        int indexCount = 0; 
        int count = 1;
        int [][] t = new int[inst.length][2];

        for(int i = 0; i < inst.length; i++)
        {
            t[i][0] = Integer.parseInt(inst[i].trim().split(" ")[0]);
            t[i][1] = Integer.parseInt(inst[i].trim().split(" ")[1]);

        }

        Arrays.sort(t, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                // TODO Auto-generated method stub
                if(o1[1] > o2[1])
                {
                    return 1;
                }
                else
                {
                    return -1;
                }
            }
        }); // End of sort override
        
        while(index < t.length)
        {
            if(t[indexCount][1] <= t[index][0])
            {
                indexCount = index;
                count++;
            }
            index++;
        }

        return count;
    } // End of jobSort method
}


