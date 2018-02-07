import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BullsandCows {
    public String getHint(String secret, String guess) {
        if (secret == null || secret.length() == 0 || guess == null || guess.length() == 0){
            return "";
        }
        int bulls = 0,cows = 0;
        char[]schars = secret.toCharArray();
        char[]gchars = guess.toCharArray();
        Set<Integer> set = new HashSet<>();
        int[]table = new int[10];
        for(int i=0;i<schars.length;i++){
            if(schars[i] == gchars[i]){
                bulls++;
            }else{
                set.add(i);
                table[schars[i]-'0']++;
            }
        }
        for(Iterator<Integer> iterator = set.iterator();iterator.hasNext();){
            int index = iterator.next();
            if(table[gchars[index]-'0'] !=0){
                cows++;
                table[gchars[index]-'0']--;
            }
        }
        return bulls+"A"+cows+"B";
    }

    public static void main(String[]args){
        new BullsandCows().getHint("011","110");
    }
}
