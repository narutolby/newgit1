package contest95;

import contest54.FallingSquares;

public class StoneGame {
    public boolean stoneGame(int[] piles) {
        int sum = 0;
        for(int i : piles){
            sum += i;
        }
        return helper(piles,0,piles.length-1,0,sum);
    }

    public boolean helper(int [] piles,int start,int end ,int count,int sum){
        if(start == end){
            if(count > sum / 2){
                return true;
            }else{
                return false;
            }
        }
        if(helper(piles,start+1,end,count+piles[start],sum)){
            return true;
        }else{
            return helper(piles,start,end+1,count+piles[end],sum);
        }
    }
    public static void main(String[]args){
        System.out.println(new StoneGame().stoneGame(new int[]{5,3,4,5}));
    }
}


