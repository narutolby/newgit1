package google.usefullquestion;给一个root和各种边
http://www.cnblogs.com/skywang12345/p/3711504.html
https://github.com/wangkuiwu/datastructs_and_algorithm/blob/master/source/graph/kruskal/udg/java/ListUDG.java


public void kruskal() {
    int index = 0;                      // rets数组的索引
    int[] vends = new int[mEdgNum];     // 用于保存"已有最小生成树"中每个顶点在该最小树中的终点。
    EData[] rets = new EData[mEdgNum];  // 结果数组，保存kruskal最小生成树的边
    EData[] edges;                      // 图对应的所有边

    // 获取"图中所有的边"
    edges = getEdges();
    // 将边按照"权"的大小进行排序(从小到大)
    sortEdges(edges, mEdgNum);

    for (int i=0; i<mEdgNum; i++) {
        int p1 = getPosition(edges[i].start);      // 获取第i条边的"起点"的序号
        int p2 = getPosition(edges[i].end);        // 获取第i条边的"终点"的序号

        int m = getEnd(vends, p1);                 // 获取p1在"已有的最小生成树"中的终点
        int n = getEnd(vends, p2);                 // 获取p2在"已有的最小生成树"中的终点
        // 如果m!=n，意味着"边i"与"已经添加到最小生成树中的顶点"没有形成环路
        if (m != n) {
            vends[m] = n;                       // 设置m在"已有的最小生成树"中的终点为n
            rets[index++] = edges[i];           // 保存结果
        }
    }