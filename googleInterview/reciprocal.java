package google.usefullquestion;给一堆有向边，[1,2], [2,1],[3,4]这样，找到有多少是reciprocal的。给的例子的话就是1.因为1,2两个点有双向的边。
    把edge先排序，[1,2] => [1,2], [2,1] => [1,2]， 然后放到hashmap里，最后返回value=2的key的个数。
    用 (edge[0] + edge[1]) % N_MACHINE，分布到每台机器上做。