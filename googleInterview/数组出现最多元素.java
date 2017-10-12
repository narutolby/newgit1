package google.usefullquestion;一个数组，找出出现次数最多的元素。写了个类似counting sort的解法。被问时间和空间复杂度. 鍥磋鎴戜滑@1point 3 acres
二问，怎么做到sublinear的空间复杂度，（这里好像有个voting的算法，以前没写过，一时没想出来）。要了个big hint，被告知可以放宽时间复杂度要求到O(nlgn)，后来进一步提示就是可以先排序。

    
    
    
char[256]
    counting sort统计每个字符出现频率，然后遍历最大的
    
    
    然后先排序，然后双指针，如果结尾的和头的字母一样，相减就是频率最大的了。