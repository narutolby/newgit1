package contest33;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author boyang.lby
 * @date 5/21/17
 * @description
 */
/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
public class FileSystem {

    Node root = null;

    public FileSystem() {
        root = new Node();
        root.name = "/";
    }

    public List<String> ls(String path) {
        List<String>  retList = new ArrayList<String>();
        if(path.equals("/")){
            retList.addAll(root.map.keySet());
        }else{
            String[]pathArray = path.substring(1).split("/");
            Node pnode = root;
            for(String p : pathArray){
                pnode = pnode.map.get(p);
            }
            if(!pnode.type.equals("f")){
                retList.addAll(pnode.map.keySet());
            }else{
                retList.add(pnode.name);
            }

        }
        return retList;
    }

    public void mkdir(String path) {
        if(path.equals("/")){
            return;
        }
        String[]pathArray = path.substring(1).split("/");
        Node pnode = root;
        for(String p : pathArray){
            if(pnode.map.containsKey(p)){
                pnode = pnode.map.get(p);
            }else{
                Node newNode = new Node();
                newNode.name = p;
                pnode.map.put(p,newNode);
                pnode = newNode;
                newNode.type = "d";
            }
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[]pathArray = filePath.substring(1).split("/");
        Node pnode = root;
        mkdir(filePath);
        for(String p : pathArray){
            if(pnode.map.containsKey(p)){
                pnode = pnode.map.get(p);
            }
        }
        pnode.type = "f";
        pnode.content.append(content);
    }

    public String readContentFromFile(String filePath) {
        String[]pathArray = filePath.substring(1).split("/");
        Node pnode = root;
        for(String p : pathArray){
            if(pnode.map.containsKey(p)){
                pnode = pnode.map.get(p);
            }
        }
        return pnode.content.toString();
    }


    class Node{
        String name;
        Map<String,Node> map = new TreeMap<String,Node>();
        StringBuilder content = new StringBuilder();
        String type = "";
    }
}
