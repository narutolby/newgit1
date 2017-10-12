package google.usefullquestion;一个intstream，已经实现了hasnext 和next 函数，我可以直接调用，让我实现一个新的类Uniontwostream（streamA,streamB）的hasnext 和next的函数，这里有一点要考虑的就是如果两个stream中有重复元素，不能重复输出。

public void unionTwoStream(IntStream streamA,IntStream streamB){
    HashSet<IntStream> set=new HashSet<>();
    IntStream newInt=new InteStream<>();
    while(streamA.hasnext() && streamB.hasnext){
        
    }
}