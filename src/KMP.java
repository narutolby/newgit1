/**
 * @author boyang.lby
 * @date 11/12/17
 * @description
 */
public class KMP {
    public static int[] getNext(String ps)
    {
        char[] strKey = ps.toCharArray();
        int[] next = new int[strKey.length];

        // 初始条件
        int j = 0;
        int k = -1;
        next[0] = -1;

        // 根据已知的前j位推测第j+1位
        while (j < strKey.length - 1)
        {
            if (k == -1 || strKey[j] == strKey[k])
            {
                next[++j] = ++k;
            }
            else
            {
                k = next[k];
            }
        }

        return next;
    }
    public static void main(String[]args){
        KMP.getNext("aaaa");
    }
}
