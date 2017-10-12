package google.usefullquestion;然后问了 full binary tree （每个node 要么有两个child要么没有）的问题，求给定leaf node数量，生成所有可能的树的结构。
    
我是用 bottom-up DP做的，只有一个leaf的full binary tree只能是一个node，然后有n 个 leaf的full binary tree 是由 有 a 个 leaf 的 left subtree (full binary tree) + b个 leaf 的 right subtree 构成的。然后就这么 构造。复杂度是exponential的
    
    
public int fullTree(int n){
    int[] dp=new int[n+1];
    dp[0]=1;
    dp[1]=1;
    dp[2]=1;
    for(int i=3;i<=n;i++){
        dp[i]=dp[i-1]*(n-1);
    }
    return dp[n];
}
加入一个叶子结点，表示加入一个 
    1
   1 1的结构，所以n-1