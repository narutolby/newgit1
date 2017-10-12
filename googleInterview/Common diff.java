package google.usefullquestion;给两个字符串
s1 [1,2,3,4]
s2 [1,3,4,5]
返回
common:[1, 3, 4]
diff:[2,5]
public class Main {
	public static void main(String[] args) {
		//nums are sorted.
		int[] nums1={1,1,1,2,2,2,2,3,3,4,4,4};
		int[] nums2={1,1,3,3,4,4,4,5,5,5,5,5,5,5,5};
		List<List<Integer>> res=test(nums1,nums2);
		for(int i=0;i<res.size();i++){
			System.out.println(res.get(i));
		}
		
    }
	 public static List<List<Integer>> test(int[] nums1, int[] nums2) {
		 List<List<Integer>> res = new ArrayList<>();
	     List<Integer> diff = new ArrayList<>();
	     List<Integer> common = new ArrayList<>();
	     res.add(diff); res.add(common);
	     int p1 = 0;
	     int p2 = 0;
	     while(p1<nums1.length || p2<nums2.length){
	    	 if(p2 == nums2.length || ( p1 < nums1.length && nums1[p1] < nums2[p2])){
                 diff.add(nums1[p1++]);            
             }else if(p1 == nums1.length || nums1[p1] > nums2[p2]){
            	 diff.add(nums2[p2++]);
             }else{
            	 common.add(nums1[p1]);
            	 p1++; p2++;
	         }
	    	 while(p1 > 0 && p1 < nums1.length && nums1[p1] == nums1[p1-1]) p1++;
             while(p2 > 0 && p2 < nums2.length && nums2[p2] == nums2[p2-1]) p2++;
	        }
	        return res;
	 }
}
