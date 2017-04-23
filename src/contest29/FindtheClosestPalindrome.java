package contest29;

/**
 * @author boyang.lby
 * @date 4/23/17
 * @description
 */
public class FindtheClosestPalindrome {
    String ret = null;
    Long diff = Long.MAX_VALUE;
    public String nearestPalindromic(String n) {
        if(n == null || n.length() == 0){
            return "";
        }
        if(n.equals("10") || n.equals("11")){
            return "9";
        }
        int m = (n.length()-1 + 0)/2;
        String left = n.substring(0,m+1);
        String nl = left;
        String mirror = mirror(nl,n.length());
        if(!mirror.equals(n)){
            update(n,mirror);
        }
        nl = String.valueOf(Long.parseLong(left) + 1);
        mirror = mirror(nl, n.length());
        update(n,mirror);
        nl = String.valueOf(Long.parseLong(left) - 1);
        mirror = mirror(nl,n.length());
        update(n,mirror);
        return ret;

    }

    public void update(String s,String t){
        Long tmp = Math.abs(Long.parseLong(s) - Long.parseLong(t));
        if(diff > tmp){
            diff = tmp;
            ret = t;
        }else if(diff.equals(tmp) && Long.parseLong(t) < Long.parseLong(ret)){
            ret = t;
        }
    }


    public String mirror(String left,int n){
        int leftn = n%2 == 0 ? n/2 : n/2 + 1;
        StringBuilder sb = new StringBuilder();
        if(left.length() < leftn){
            for(int i=0;i<n-1;i++){
                sb.append("9");
            }
            return sb.toString();
        }
        if(left.length() > leftn){
            sb.append(left);
            for(int i=0;i<n-leftn-1;i++){
                sb.append("0");
            }
            sb.append("1");
            return sb.toString();
        }
        if(n % 2 == 0){
            return left + new StringBuilder(left.substring(0,left.length())).reverse();
        }else{
            return left + new StringBuilder(left.substring(0,left.length()-1)).reverse();
        }
    }

    public static void main(String[]args){
        System.out.println(new FindtheClosestPalindrome().nearestPalindromic("111111111"));
    }
}
