package google.usefullquestion;设计一个HistroricMap：
HistroricMap hmap();. 1point 3acres 璁哄潧
hmap.insert("foo",1)  at time 1;
hmap.insert("foo", 2) at time 5;
hmap.at("foo",3)=1; （第二个参数代表时间）
hmap.at("foo",5)=2;

就是每一个key在输入到map里的时候还对应一个时间，然后可以读取每一个key在每一时刻对应的value；
楼主一开始设计的是用unordered_map<string,map<int,int>> 存东西；
复杂度是存的O(log T)，取得复杂度也是O(log T)
让我想了好多test case，最后问了个bonus的问题。说如何把存的复杂度变成O(1)，取的复杂度还是O(log T)，想了想说其实unordered_map<string,vector<pair<int,int>>> 就可以了。因为输入的时间一定是递增的，所以在进行取值操作的时候只要用binary search就可以找到每一时刻这个key对应的value。
