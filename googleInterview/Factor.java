package google.usefullquestion;

public class Solution {
    public List<Integer> getFactors(int n) {
        List<Integer> sublist=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        for(int i=1;i<=n;i++){
            if(n%i==0) set.add(i);
        }
        for(Integer i:set){
            sublist.add(i);
        }
        /*
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0){
                if(n/i==i){
                    sub.add(i);
                    continue;
                }
                sub.add(i);
                sub.add(n/i);
            }
        }
        */
        return sublist;
    }
}
254. Factor Combinations
public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, new ArrayList<Integer>(), n, 2);
        return result;
    }
    
    public void helper(List<List<Integer>> result, List<Integer> item, int n, int start){
        if (n <= 1) {
            if (item.size() > 1) {
                result.add(new ArrayList<Integer>(item));
            }
            return;
        }
        
        for (int i = start; i <= n; ++i) {
            if (n % i == 0) {
                item.add(i);
                helper(result, item, n/i, i);
                item.remove(item.size()-1);
            }
        }
    }
}
Efficient program to print all prime factors of a given number
{
// Print the number of 2s that divide n
while (n%2==0)
{
System.out.print(2 + " ");
n /= 2;
}

// n must be odd at this point.  So we can
// skip one element (Note i = i +2)
for (int i = 3; i <= Math.sqrt(n); i+= 2)
{
// While i divides n, print i and divide n
while (n%i == 0)
{
System.out.print(i + " ");
n /= i;
}
}

// This condition is to handle the case whien
// n is a prime number greater than 2
if (n > 2)
System.out.print(n);
}

public static void main (String[] args)
{
int n = 315;
primeFactors(n);
}
