package google.usefullquestion;大致是给定一个二叉树，有其中一条枝连错了，让我找到这个错误的枝的node，删掉这个node并返回根节点。
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=225024&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D2%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3048%5D%5Bvalue%5D%3D3%26searchoption%5B3048%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D1%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
public TreeNode main(TreeNode root){
    if(root==null) return null;
    HashSet<TreeNode> set=new HashSet<>();
    dfs(root,set);
    return root;
}
public void helper(TreeNode root,HashSet<TreeNode> set){
    if(root!=null){
        set.add(root);
    }
    if(root.left!=null){
        if(!set.contain(root.left))
            helper(root.left,set);
        else{
            root.left==null;
            return;
        }
    }
    //right和left一样
    if(root.right!=null) helper(root.right,set);
}