import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author boyang.lby
 * @date 2/17/17
 * @description
 */
public class Java8Test {

    public static void main(String[]args){
        List<Integer> list = new ArrayList<>();
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        Collections.sort(list,(x,y) ->{
            return x - y;
        });
    }
}
