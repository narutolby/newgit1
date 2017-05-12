import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author boyang.lby
 * @date 5/12/17
 * @description
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        ret.add(new ArrayList<Integer>());
        if(nums == null || nums.length == 0){
            return ret;
        }
        Arrays.sort(nums);
        for(int j=0;j<nums.length;j++){
            int count = 0;
            while(j+count<nums.length && nums[j+count] == nums[j]) count++;
            int len = ret.size();
            for(int i=0;i<len;i++){
                List<Integer> list = ret.get(i);

                List<Integer> newList = new ArrayList<Integer>();
                newList.addAll(list);
                for(int m=0;m<count;m++){
                    newList.add(nums[j+m]);
                    List<Integer> newnewList = new ArrayList<Integer>();
                    newnewList.addAll(newList);
                    ret.add(newnewList);
                }

            }
            j = j + count - 1;
        }
        return ret;
    }

    public static void main(String[]args){
        new SubsetsII().subsetsWithDup(new int[]{1,2,2});
    }
}
