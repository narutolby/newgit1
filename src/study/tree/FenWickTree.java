package study.tree;

/**
 * @author boyang.lby
 * @date 1/28/18
 * @description
 * 树状数组
 * 树状数组(Binary Indexed Tree(B.I.T), Fenwick Tree)是一个查询和修改复杂度都为log(n)的数据结构。主要用于查询任意两位之间的所有元素之和，但是每次只能修改一个元素的值；经过简单修改可以在log(n)的复杂度下进行范围修改，但是这时只能查询其中一个元素的值(如果加入多个辅助数组则可以实现区间修改与区间查询)。
这种数据结构（算法）并没有C++和Java的库支持，需要自己手动实现。在Competitive Programming的竞赛中被广泛的使用。树状数组和线段树很像，但能用树状数组解决的问题，基本上都能用线段树解决，而线段树能解决的树状数组不一定能解决。相比较而言，树状数组效率要高很多。


树状数组适用范围：给定区间，求最值，求和，区间单点修改
https://www.jianshu.com/p/bed872d87a43
\
int lowbit(int x)
{
return x&(-x);
}
 起始点从1开始,用c[i]表示树状数组,c[i]索管辖的区域为[i - 2^k + 1,i],k为i尾部的0的个数
 */
public class FenWickTree {
    int[]c;
    int n = c.length;
    int lowbit(int x)
    {
        return x&(-x);
    }
    void update(int i, int x)
    {
        while(i<=n)
        {
            c[i]+=x;
            i+=lowbit(i);//更新父节点
        }
    }
    int sum(int i)
    {
        int res=0;
        while(i>0)
        {
            res+=c[i];
            i-=lowbit(i);
        }
        return res;
    }
}
