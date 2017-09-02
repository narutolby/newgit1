package airbnb.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author boyang.lby
 * @date 8/20/17
 * @description
 */
public class FindTheNumber {
    static String findNumber(int[] arr, int k) {
        Arrays.sort(arr);
        if(Arrays.binarySearch(arr,k)>=0){
               return "YES";
        }
        return "NO";

    }


    static int[] oddNumbers(int l, int r) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=l;i<=r;i++){
            if(i % 2 == 1){
                list.add(i);
            }
        }
        int[]ret = new int[list.size()];
        for(int i=0;i<list.size();i++){
            ret[i] = list.get(i);
        }
        return ret;
    }


    static String[] paginate(int num, String[] results) {
        if(num <= 0 || results == null || results.length == 0){
            return new String[]{};
        }
        LinkedList<HostEntry> linkedList = new LinkedList<HostEntry>();
        List<String> retList = new ArrayList<String>();
        for(String entry : results){
            linkedList.add(new HostEntry(entry.split(",")[0],entry));
        }
        int pageCount = (results.length - 1)/num + 1;
        Set<String> onePageSet = new HashSet<String>();
        for(int i=0;i<pageCount;i++){
            onePageSet.clear();
            int perPageCount = 0;
            for(Iterator<HostEntry> iterator = linkedList.iterator();iterator.hasNext();){
                if(perPageCount == num){
                    break;
                }
                HostEntry hostEntry = iterator.next();
                if(!onePageSet.contains(hostEntry.getHostId())){
                    retList.add(hostEntry.getEntry());
                    onePageSet.add(hostEntry.getHostId());
                    iterator.remove();
                    perPageCount++;
                }
            }
            while(perPageCount<num && !linkedList.isEmpty()){
                retList.add(linkedList.removeFirst().getEntry());
                perPageCount++;
            }
            if(!linkedList.isEmpty()){
                retList.add("");
            }
        }
        return retList.toArray(new String[]{});
    }
    static class HostEntry{
        String hostId;
        String entry;

        public HostEntry(){}

        public HostEntry(String hostId,String entry){
            this.hostId = hostId;
            this.entry= entry;
        }

        public String getHostId() {
            return hostId;
        }

        public void setHostId(String hostId) {
            this.hostId = hostId;
        }

        public String getEntry() {
            return entry;
        }

        public void setEntry(String entry) {
            this.entry = entry;
        }
    }
}
