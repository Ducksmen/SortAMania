import java.util.Arrays;
import java.util.List;

public class Team2SortCompetition extends SortCompetition{

    private int[] challenge1;
    private String[] challenge2;
    private String query;
    private int[] challenge3;
    private int[][] challenge4;
    private Comparable[] challenge5;
    private Comparable cquery;

    /**
     * Data Set - an array of 10,000 random integers between 0-10000
     * @param challenge1 First challenge array.
     * @return Task: Sort the list and return the median(Round down if double)
     */
    public int challengeOne(int[] challenge1)
    {
        double median;
        for(int i=0;i<challenge1.length;i++)
        {
            int cMin = challenge1[i];
            int x = i - 1;
            while(x>=0 && challenge1[x] > cMin)
            {
                challenge1[x+1] = challenge1[x];
                x--;
            }
            challenge1[x+1] = cMin;
        }
        if(challenge1.length % 2 == 0)
        {
            median = ((double)challenge1[(challenge1.length/2)] + (double)challenge1[(challenge1.length/2) - 1])/2;
        }
        else
        {
            median = (double)challenge1[challenge1.length/2];
        }
        return (int)median;
    }

    /**
     * Data Set - an array of 10,000 random strings (strings will be of length 5)
     * @param challenge2 Array for challenge 2.
     * @param query String to check for.
     * @return Task: Sort the list and determine if it contains a given string, return the index of the first instance of that string, or -1 if not found
     */
    public int challengeTwo(String[] challenge2, String query)
    {
        mergeSortStrings(challenge2);
        if(Arrays.asList(challenge2).contains(query))
        {
            List<String> challenger2 = Arrays.asList(challenge2);
            return (challenger2.indexOf(query));
        }
        else
        {
            return (-1);
        }
    }

    /**
     * Merge Sort for Strings
     * @param string1 Array to be sorted.
     */
    public static void mergeSortStrings(String[] string1)
    {
        int n = string1.length;
        String[] tempstring = new String[n];
        mergeSortStringHelper(string1, 0,n-1,tempstring);
    }

    /**
     * Creates merges calls for recursion.
     * @param string1 Array to be sorted.
     * @param strleft Left.
     * @param strright Right.
     * @param tempstring Temporary array to move elements to.
     */
    public static void mergeSortStringHelper(String[] string1, int strleft, int strright, String[] tempstring)
    {
        if(strleft < strright)
        {
            int strmiddle = (strleft + strright) / 2;
            mergeSortStringHelper(string1, strleft, strmiddle, tempstring);
            mergeSortStringHelper(string1, strmiddle + 1, strright, tempstring);
            mergeStrings(string1, strleft, strmiddle, strright, tempstring);
        }
    }

    /**
     * Merges the String arrays back together.
     * @param string1 Array to be sorted.
     * @param strleft Left.
     * @param strmiddle Middle.
     * @param strright Right.
     * @param tempstring Temp array to move elements to.
     */
    public static void mergeStrings(String[] string1, int strleft, int strmiddle, int strright, String[] tempstring)
    {
        for(int i = strleft; i <= strright; i++)
        {
            tempstring[i] = string1[i];
        }
        int i = strleft;
        int j = strmiddle + 1;
        int k = strleft;
        while(i <= strmiddle && j <= strright)
        {
            if(tempstring[i].compareTo(tempstring[j]) < 0)
            {
                string1[k] = tempstring[i];
                i++;
            }
            else
            {
                string1[k] = tempstring[j];
                j++;
            }
            k++;
        }
        while(i <= strmiddle)
        {
            string1[k] = tempstring[i];
            k++;
            i++;
        }
        while(j <= strright)
        {
            string1[k] = tempstring[j];
            k++;
            j++;
        }
    }

    /**
     * Data Set - a mostly sorted array of 100,000 integers (>75% of elements are in the correct order)
     * @param challenge3 Array for third challenge.
     * @return Task: Sort the list and return the median
     */
    public int challengeThree(int[] challenge3)
    {
        int n = challenge3.length;
        double median;
        for(int i = 1; i < n; i++)
        {
            int key = challenge3[i];
            int j = i - 1;
            while(j >= 0 && challenge3[j] > key)
            {
                challenge3[j + 1] = challenge3[j];
                j = j - 1;
            }
            challenge3[j + 1] = key;
        }
        if(challenge3.length % 2 == 0)
        {
            median = ((double)challenge3[(challenge3.length/2)] + (double)challenge3[(challenge3.length/2) - 1])/2;
        }
        else
        {
            median = (double)challenge3[challenge3.length/2];
        }
        return (int)median;
    }

    /**
     * Data Set - a multi-dimensional array int[1000][1000] all elements are random integers between 0-10000
     * Return the median of the median array
     * @param challenge4 Array for challenge 4.
     * @return Task: Sort each sub-array and then sort the arrays by their median value
     */
    public int challengeFour(int[][] challenge4)
    {
        double median;
        for(int i=0;i<challenge4.length;i++)
        {
            for(int j=0;j<challenge4.length;j++)
            {
                int cMin = challenge4[i][j];
                int x = i - 1;
                while(x>=0 && challenge4[i][j] > cMin)
                {
                    challenge4[i][x+1] = challenge4[i][x];
                    x--;
                }
                challenge4[i][x+1] = cMin;
                }
                if(challenge4.length % 2 == 0)
                {
                    median = ((double)challenge1[(challenge1.length/2)] + (double)challenge1[(challenge1.length/2) - 1])/2;
                }
                else
                {
                    median = (double)challenge1[challenge1.length/2];
                }
                return (int)median;
            }
        }
    }

    /**
     * Data Set - an array of 10,000 objects that implement the comparable interface
     * Hint: You must use a stable sort for this challenge, equivalent objects should stay in the same order.
     * @param challenge5 Array for Challenge 5.
     * @param cquery Object to be found.
     * @return Task: Sort the array by the compareTo method, and determine if it contains the element given. Return the position of the object, or -1 if not found.
     */
    public int challengeFive(Comparable[] challenge5, Comparable cquery)
    {

    }

    /**
     * Basic greeting.
     * @return Greeting.
     */
    public String greeting()
    {
        return "Welcome to Team Super Sorter's Very Cool Omega Sorting Bot";
    }
}
