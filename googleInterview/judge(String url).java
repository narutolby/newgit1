package google.usefullquestion;给一个list, list里的element如下class, 并给一个API "judge(String url)” 来判断该url是good或bad, 利用此API把list里含有bad url的element删掉, 主要在考会不会使用iterator, iterator.hasNext(), 及iterator.next()

class data{. 1point3acres.com/bbs
    String url;
    int refNum
}
恩 就用iterator.remove, 代码大概类似以下

Iterator<Object> i = objs.iterator();
while (i.hasNext()) {
   Object o = i.next();
    if(!judge(o.url))
        i.remove();
}