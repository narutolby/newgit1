import java.util.ArrayList;
import java.util.List;

/**
 * @author boyang.lby
 * @date 4/8/17
 * @description
 */
public class PopulatingNextRightPointersinEachNodeII {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        List<List<TreeLinkNode>> list = new ArrayList<>();
        List<TreeLinkNode> elementList = new ArrayList<>();
        elementList.add(root);
        list.add(elementList);
        for(int i=0;i<list.size();i++){
            List<TreeLinkNode> t = new ArrayList<>();
            List<TreeLinkNode> e = list.get(i);
            for(int j=0;j<e.size();j++){
                if(j == e.size()-1){
                    e.get(j).next = null;
                }else{
                    e.get(j).next = e.get(j+1);
                }

                if(e.get(j).left != null){
                    t.add(e.get(j).left);

                }
                if(e.get(j).right != null){
                    t.add(e.get(j).right);

                }

            }
            if(!t.isEmpty()){
                list.add(t);
            }

        }
    }
}
