package google.usefullquestion;第一轮：设计一个相当于家谱的class，实现3个函数. 鐣欏鐢宠璁哄潧-涓€浜╀笁鍒嗗湴
void birth(string parentname, string childname)
void death(string name)
vector<string> orderofsuccession()
假设每个parent能够有无数个孩子，不考虑结婚的问题，每个孩子都只有一个parent。第三个函数就是按照顺序输出每一个还活着的人。. 1point3acres.com/bbs
楼主想了想就说用树+haspmap来实现，同时自己定义了TreeNode的结构。后来有几个follow-up
1）如果每个人有年龄，输出是同一代的人按照年龄排序
2 ) 输出的顺序换成先输出年龄最大人，然后输出此人的所有孩子，再输出同一代比他年龄小的人. 鍥磋鎴戜滑@1point 3 acres
3 ) 如果这个家族人特别多，没法用queue来存储进行level order traverse怎么办。答：类似LC116，给每个treenode加一个next指针. 1p
public class TreeNode implements Serializable {
    private int parentId;
    private int selfId;
    protected String nodeName;
    protected Object obj;
    protected TreeNode parentNode;
    protected List<TreeNode> childList;
014
 
015
    public TreeNode() {
016
        initChildList();
017
    }
018
 
019
    public TreeNode(TreeNode parentNode) {
020
        this.getParentNode();
021
        initChildList();
022
    }
023
 
024
    public boolean isLeaf() {
025
        if (childList == null) {
026
            return true;
027
        } else {
028
            if (childList.isEmpty()) {
029
                return true;
030
            } else {
031
                return false;
032
            }
033
        }
034
    }
    /* 插入一个child节点到当前节点中 */
037
    public void addChildNode(TreeNode treeNode) {
038
        initChildList();
039
        childList.add(treeNode);
040
    }
041
 
042
    public void initChildList() {
043
        if (childList == null)
044
            childList = new ArrayList<TreeNode>();
045
    }
046
 
047
    public boolean isValidTree() {
048
        return true;
049
    }
050
 
051
    /* 返回当前节点的父辈节点集合 */
052
    public List<TreeNode> getElders() {
053
        List<TreeNode> elderList = new ArrayList<TreeNode>();
054
        TreeNode parentNode = this.getParentNode();
055
        if (parentNode == null) {
056
            return elderList;
057
        } else {
058
            elderList.add(parentNode);
059
            elderList.addAll(parentNode.getElders());
060
            return elderList;
061
        }
062
    }
063
 
064
    /* 返回当前节点的晚辈集合 */
065
    public List<TreeNode> getJuniors() {
066
        List<TreeNode> juniorList = new ArrayList<TreeNode>();
067
        List<TreeNode> childList = this.getChildList();
068
        if (childList == null) {
069
            return juniorList;
070
        } else {
071
            int childNumber = childList.size();
072
            for (int i = 0; i < childNumber; i++) {
073
                TreeNode junior = childList.get(i);
074
                juniorList.add(junior);
075
                juniorList.addAll(junior.getJuniors());
076
            }
077
            return juniorList;
078
        }
079
    }
080
 
081
    /* 返回当前节点的孩子集合 */
082
    public List<TreeNode> getChildList() {
083
        return childList;
084
    }
085
 
086
    /* 删除节点和它下面的晚辈 */
087
    public void deleteNode() {
088
        TreeNode parentNode = this.getParentNode();
089
        int id = this.getSelfId();
090
 
091
        if (parentNode != null) {
092
            parentNode.deleteChildNode(id);
093
        }
094
    }
095
 
096
    /* 删除当前节点的某个子节点 */
097
    public void deleteChildNode(int childId) {
098
        List<TreeNode> childList = this.getChildList();
099
        int childNumber = childList.size();
100
        for (int i = 0; i < childNumber; i++) {
101
            TreeNode child = childList.get(i);
102
            if (child.getSelfId() == childId) {
103
                childList.remove(i);
104
                return;
105
            }
106
        }
107
    }
108
 
109
    /* 动态的插入一个新的节点到当前树中 */
110
    public boolean insertJuniorNode(TreeNode treeNode) {
111
        int juniorParentId = treeNode.getParentId();
112
        if (this.parentId == juniorParentId) {
113
            addChildNode(treeNode);
114
            return true;
115
        } else {
116
            List<TreeNode> childList = this.getChildList();
117
            int childNumber = childList.size();
118
            boolean insertFlag;
119
 
120
            for (int i = 0; i < childNumber; i++) {
121
                TreeNode childNode = childList.get(i);
122
                insertFlag = childNode.insertJuniorNode(treeNode);
123
                if (insertFlag == true)
124
                    return true;
125
            }
126
            return false;
127
        }
128
    }
129
 
130
    /* 找到一颗树中某个节点 */
131
    public TreeNode findTreeNodeById(int id) {
132
        if (this.selfId == id)
133
            return this;
134
        if (childList.isEmpty() || childList == null) {
135
            return null;
136
        } else {
137
            int childNumber = childList.size();
138
            for (int i = 0; i < childNumber; i++) {
139
                TreeNode child = childList.get(i);
140
                TreeNode resultNode = child.findTreeNodeById(id);
141
                if (resultNode != null) {
142
                    return resultNode;
143
                }
144
            }
145
            return null;
146
        }
147
    }
148
 
149
    /* 遍历一棵树，层次遍历 */
150
    public void traverse() {
151
        if (selfId < 0)
152
            return;
153
        print(this.selfId);
154
        if (childList == null || childList.isEmpty())
155
            return;
156
        int childNumber = childList.size();
157
        for (int i = 0; i < childNumber; i++) {
158
            TreeNode child = childList.get(i);
159
            child.traverse();
160
        }
161
    }
162
 
163
    public void print(String content) {
164
        System.out.println(content);
165
    }
166
 
167
    public void print(int content) {
168
        System.out.println(String.valueOf(content));
169
    }
170
 
171
    public void setChildList(List<TreeNode> childList) {
172
        this.childList = childList;
173
    }
174
 
175
    public int getParentId() {
176
        return parentId;
177
    }
178
 
179
    public void setParentId(int parentId) {
180
        this.parentId = parentId;
181
    }
182
 
183
    public int getSelfId() {
184
        return selfId;
185
    }
186
 
187
    public void setSelfId(int selfId) {
188
        this.selfId = selfId;
189
    }
190
 
191
    public TreeNode getParentNode() {
192
        return parentNode;
    }
    public void setParentNode(TreeNode parentNode) {
        this.parentNode = parentNode;
    }
    public String getNodeName() {
        return nodeName;
    }
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }
    public Object getObj() {
        return obj;
    }
    public void setObj(Object obj) {
        this.obj = obj;
    }
}
