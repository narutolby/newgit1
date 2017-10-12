package google.usefullquestion;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }
            
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
    
    private TreeNode findMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
}
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=146431&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D2%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D1%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

给一个删除树节点的函数，和root，怎么遍历删除整棵树。用了postorder recursion。
问这个程序可能会crash，为什么。  因为recursion太多可能会memory overflow。
问怎么避免，用level order，空间复杂度O(n).
如果还是太大，怎么办，我就不会了，他提示说serialize，我想到了线索化二叉树，但是太难了，不会，postorder iteration也太难了，不会。. 1point3acres.com/bbs
这些复习的时候都看到过，觉得肯定不会考，所以也怨不得别人。
就是楼主想到的Morris Traversal，不过是iterative版本的。

具体做法也就是找每个节点左孩子的最右叶子节点，e.g，当前节点inorder traversal时的predecessor。然后设这个叶子节点的right为当前节点。
移动到左孩子，重复上述步骤。
如果当前节点没有左孩子，那么暂存当前节点的右孩子，删除当前节点，再对右孩子重复以上步骤。


void deleteTree(TreeNode *root) {. From 1point 3acres bbs
TreeNode *cur = root;
while (cur) {
TreeNode *next = cur->left;
if (next == NULL) {
next = cur->right;
delete cur;. Waral 鍗氬鏈夋洿澶氭枃绔�,
} else {
TreeNode *pre = cur->left;. from: 1point3acres.com/bbs
while (pre->right) {
pre = pre->right;.鏈枃鍘熷垱鑷�1point3acres璁哄潧
}
pre->right = cur;
}. from: 1point3acres.com/bbs
cur = next;
}
}
