package bytedance;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author boyang.lby
 * @date 7/18/19
 * @description
 * 最长连续子序列
描述信息
题目：

给定一个整形数组长度为n

求构造出子序列连续并且长度最大，要求子序列有顺序。

连续定义序列 [x, x+1, ..., x+k-1] ，长度是k

例如数组 [5, 3, 1, 2, 4] 的子序列 正确的表述例子， [3] [5,3, 1, 2, 4] [5, 1, 4] 但是 [1, 3] 不是，因为要按照从左往右顺序 [3, 1] 是正确的子序列。

输入：

n个整数，1<= n <= 200000

a1, a2, ..., an (1<= ai <= 10^9 ）

输出：

k

任意一个可以组成最大长度的连续子序列的数组元素下标 数组，下标按照递增排列

Example：

input

7

3 3 4 7 5 6 8

output

4

2 3 5 6

-----------

input

16

6 7 8 3 4 5 9 10 11 6 7 8 9 6 10 11

output

9

4 5 6 10 11 12 13 15 16

---------

input

4

10 9 8 7

output

1

1

---------

input

9

6 7 8 3 4 5 9 10 11

output

6

1 2 3 7 8 9

参考答案
复杂度 O(n)
设 zip[input[i] , i] 为以 数组元素为key， 下标为value

设以i 下标为结尾的数组 最大子序列 cnt[i] ,

如果[0, ..., i+1] 序列里存在 inputs[i+1]-1 ，

那么 cnt[i+1] = cnt[zip[inputs[i+1]-1]] + 1 相等于把前面的片段接起来
 */
public class MaxLongSequnce {
    static  int length;
    static int[] inputs;
    static int[] solve() {
        int id = 0;
        // key 数组元素 value 数组下标
        // [6, 0] [7,1] [8, 2] [3, 3] [4, 4] [5, 5] [9, 6] [10, 7] [11, 8]
        Map<Integer, Integer> zip = new HashMap<>();
        // 记录节点
        // [0, <0, 6>] [1, <1, 7>] [2, <2, 8>] [3, <3, 3>] [4, <4, 4>] [5, <5, 5>] [6, <6, 9>] [7, <7, 10>] [8, <8, 11>]
        Map<Integer, Node> rev = new HashMap<>();
        // 记录上一个连续数字的节点序号
        // [1, 0] [2, 1] [4, 3] [5, 4] [6, 2] [7, 6] [8, 7]
        int[] path = new int[length]; // index -> index
        Arrays.fill(path, -1);
        // 以id(以0为下标的序号) 结尾的连续数组序列的最大次数
        // [0, 1] [1, 2] [2, 3] [3, 1] [4, 2] [5, 3] [6, 4] [7, 5] [8, 6]
        int[] cnt = new int[200000]; // id -> count

        for (int i = 0; i < length; i++) {
            int a = inputs[i];

            zip.put(a, id);
            rev.put(id, new Node(i, a));
            id++;

            if( zip.containsKey(a-1) ) {
                int prev = zip.get(a-1);
                path[i] = rev.get(prev).i;
                cnt[zip.get(a)] = cnt[zip.get(a-1)]+1;
            } else {
                cnt[zip.get(a)] = 1;
            }
        }

        int max = 0;
        int maxid = -1;
        for (int i = 0; i < cnt.length; i++) {
            if( cnt[i] > max ) {
                maxid = i; // maxid = 8
                max = cnt[i]; // max = 6
            }
        }
        int[] ans = new int[max];
        ans[max-1] = rev.get(maxid).i; // ans[5] = 8

        // 4 ->
        // 4 -> 0
        for (int i = max-2; i >=0; i--) {
            ans[i] = path[ans[i+1]];
            // ans[4] = path[ans[5]] = path[8] = 7
            // ans[3] = path[ans[4]] = path[7] = 6
            // ans[2] = path[ans[3]] = path[6] = 2
            // ans[1] = path[ans[2]] = path[2] = 1
            // ans[0] = path[ans[1]] = path[1] = 0
        }

        for (int i = 0; i < max; i++) {
            ans[i]++;
            // 0 1 2 6 7 8 => 1 2 3 7 8 9
        }
        return ans;
    }

    static class Node {
        int i, a;

        public Node(int i, int a) {
            this.i = i;
            this.a = a;
        }
    }

    static void printSingleLine(int[] array) {
        PrintWriter pw = new PrintWriter(System.out);
        for (int i = 0; i < array.length; i++) {
            if (i != 0) pw.print(" ");
            pw.print(array[i]);
        }
        pw.println();
        pw.flush();
    }


    public static int anotherMethod(int[]array){
        int maxLen = 0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        Map<Integer,Integer> path = new HashMap<Integer,Integer>();
        for (int i:array){
            if (!map.containsKey(i-1)){
                map.put(i,1);
                path.put(i,-1);
            }else{
                if (map.containsKey(i)){
                    map.put(i,Math.max(map.get(i),map.get(i-1)+1));

                }else{
                    //path.put(i,);
                }
            }
            maxLen = Math.max(maxLen,map.get(i));
        }
        return maxLen;
    }

    public static void main(String[]args){
        anotherMethod(new int[]{6,7,8,3,4,5,9,10,11});
    }
}
