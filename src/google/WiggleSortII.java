package google;

public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1){
            return;
        }
        int mid = (nums.length - 1) /2 ;
        quick_group(nums,mid+1,0,nums.length - 1);
        int[]ret = new int[nums.length];
        int i = 0,j = mid+1;
        for(int m=0;m<ret.length;){
            ret[m++] = nums[i++];
            if(m<ret.length){
                ret[m++] = nums[j++];
            }
        }
        for(i=0;i<nums.length;i++){
            nums[i] = ret[i];
        }
    }

    public void quick_group(int[]nums,int n,int l,int r){
        int index = partition(nums,l,r);
        if(index - l + 1 == n){
            return ;
        }else if(index - l + 1 < n){
            quick_group(nums,n - (index - l + 1),index+1,r);
        }else{
            quick_group(nums, n,l,index - 1);
        }
    }

    public int partition(int[]nums,int l,int r){
        if(l == r){
            return l;
        }
        int x = nums[r];
        int i = l - 1;
        for(int j =l;j<=r-1;j++){
            if(nums[j] < x){
                i++;
                swap(nums,i,j);
            }
        }
        swap(nums,i+1,r);
        return i+1;
    }
    public void swap(int[]nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void main(String[]args){
        new WiggleSortII().wiggleSort(new int[]{1, 3, 2, 2, 3, 1});
    }
}
