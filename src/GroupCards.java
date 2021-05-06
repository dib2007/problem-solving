import java.util.*;

public class GroupCards {

    public static void main(String[] args) {
        System.out.println(hasGroupsSizeX(new int[]{1,1,2,2,2,2}));
    }

    public static boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int i : deck) {
            countMap.putIfAbsent(i, 0);
            countMap.put(i, countMap.get(i) + 1);
        }
        int gcd = findGCD(countMap.values(), countMap.size());
        //System.out.println(gcd);
        return gcd>=2;
    }

    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    // Function to find gcd of array of
    // numbers
    static int findGCD(Collection<Integer> set, int n)
    {
        int result = 0;
        for (int element: set){
            result = gcd(result, element);

            if(result == 1)
            {
                return 1;
            }
        }

        return result;
    }
}
