package google.usefullquestion;一个二叉树加入一条边变成一个图，给这个图要找出加入的边，答案不唯一。


Prim方法
设N=(V,{E})是连通网，TE是N上最小生成树中边的集合：
（1）初始令U={u0},(u0属于V), TE=NULL
（2）在所有u属于U,v属于V-U的边(u,v)属于E中，找一条代价最小的边(u0,v0)
（3）将(u0,v0)并入集合TE，同时v0并入U
（4）重复上述操作直至U=V为止，则T=(V,{TE})为N的最小生成树
    
    
    http://blog.csdn.net/matrix_laboratory/article/details/11879127

用最小生成树算法，但去掉最小的权值，最后剩下的那条边，就是结果