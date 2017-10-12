package google.usefullquestion;

public class Solution {
    public int mySqrt(int x) {
        if (x < 0) {
            return -1;
        }
        long start = 1;
        long end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid > x) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (end * end <= x) {
            return (int)end;
        }
        return (int)start;
    }
}
public class Solution {
    public int mySqrt(int x) {
        long r=x;
        while(r*r>x){
            r=(r+x/r)/2;
        }
        return (int)r;
    }
    public double mySqrt(int x,int y) {
        double r=x;
        while(r*r>y+x){
            r=(r+x/r)/2;
        }
        return (double)r;
    }
}
double sq(double x){
    double mx = 32000;
    double mn = 0;
    while(mx - mn > 1e-9){
        double md = (mx + mn) / 2;
        if(md * md > x)
            mx = md;
        else
            mn = md;
    }
    return mx;
}
double 类型：如果精确到。000, *100000  最后除100 double 双精度浮点, 16个点，也就是64位数据。64个大小的东西往32个大小的位置放，肯定是放不下的，肯定就溢出了。
    保留多少位用*1000
记得转换成long型，越界
    
问题： 

Implement int sqrt(int x).
Compute and return the square root of x.
这个问题的解法有很多，但都比不上牛顿插值法简便。 
不过牛顿插值法需要的一定的数学功底。
自己没有在第一时间想到牛顿插值法， 
但幸好该方法的数学推理还有影响，可以看懂解法。
假设x=sqrt(n)，那么可令f(x)=n-x^2， 
求x的值就变成了求f(x)的零点。
牛顿插值法的思想如上图所示（这个图与该函数并不一致，仅作说明用），其中x为最终结果： 
随意在函数曲线上取横坐标为Xn点，以其一阶倒数为斜率，做一条直线， 
该直线与X轴的交点记为Xn+1。
然后，在函数曲线上取横坐标为Xn+1点，再以其一阶倒数为斜率，做一条直线， 
该直线与X轴的交点记为Xn+2。
不断按上面的方式进行下去，最后的结果将逼近实际结果x。
假设f(x)是关于X的函数，求出f(x)的一阶导，即斜率: 
简化等式可得到: 
不断按上面的方式进行下去，最后的结果将逼近实际结果x。
现在我也只记得这么做可以得到结果，具体的原理已经忘了，感兴趣的朋友可以百度一下。 
假设f(x)是关于X的函数，求出f(x)的一阶导，即斜率: 
简化等式可得到: 
