package contest77;

public class NumberofLinesToWriteString {
    public int[] numberOfLines(int[] widths, String S) {
        int[]ret = new int[2];
        int lines = 0;
        int count = 0;
        char[]chars = S.toCharArray();
        for(int i=0;i<chars.length;i++){
            char c = chars[i];
            int index = c - 'a';
            if(count + widths[index] > 100){
                lines ++;
                count = widths[index];
            }else{
                count += widths[index];
            }
        }
        ret[0] = lines+1;
        ret[1] = count;
        return ret;
    }

    public static void main(String[]args){
        new NumberofLinesToWriteString().numberOfLines(new int[]{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},"abcdefghijklmnopqrstuvwxyz");
    }
}
