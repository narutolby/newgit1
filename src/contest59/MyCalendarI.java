package contest59;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author boyang.lby
 * @date 11/19/17
 * @description
 */
class MyCalendar1 {
    TreeSet<Interval> treeSet = new TreeSet<Interval>(new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    });
    TreeMap<Integer,Integer> treeMap = new TreeMap<Integer,Integer>();
    public MyCalendar1() {

    }

    public boolean book1(int start, int end) {
        if(treeSet.isEmpty()){
            treeSet.add(new Interval(start,end));
            return true;
        }
        Interval newI = new Interval(start,end);
        Interval pre  = treeSet.floor(newI);
        if(pre != null && pre.end > newI.start){
            return false;
        }
        Interval next  = treeSet.ceiling(newI);
        if(next != null && newI.end > next.start){
            return false;
        }
        treeSet.add(newI);
        return true;
    }

    class Interval{
        public int start,end,count = 1,status = 1;

        public Interval(int start,int end){
            this.start = start;
            this.end = end;
        }
        public Interval(int start,int end,int count){
            this(start,end);
            this.count = count;
        }
    }
    public static void main(String[]args){
        MyCalendar1 myCalendar1 = new MyCalendar1();
        System.out.println(myCalendar1.book(20,40));
        System.out.println(myCalendar1.book(43,50));
        System.out.println(myCalendar1.book(27,43));
        System.out.println(myCalendar1.book(5,21));
        System.out.println(myCalendar1.book(30,40));
        System.out.println(myCalendar1.book(14,29));
        System.out.println(myCalendar1.book(3,19));
        System.out.println(myCalendar1.book(3,14));
        System.out.println(myCalendar1.book(25,39));
        System.out.println(myCalendar1.book(6,19));
    }
    public boolean book(int start, int end) {
        if(treeSet.isEmpty()){
            add(new Interval(start,end));
            return true;
        }
        Interval newInterval = new Interval(start,end);
        Interval pre = treeSet.floor(newInterval);
        Interval next = treeSet.higher(newInterval);
        if(pre != null && pre.end > newInterval.start && pre.count == 2){
            return false;
        }
        if(next != null && newInterval.end > next.start && next.count == 2){
            return false;
        }
        updateInterVal(pre, newInterval, treeSet);
        updateInterVal(next, newInterval, treeSet);
        add(newInterval);
        return true;
    }
    void updateInterVal(Interval c,Interval n,TreeSet<Interval> treeSet){
        if(c == null || c.end <= n.start || n.end <= c.start || n.status == 0){
           return;
        }
        int start = c.start;
        int end = c.end;
        if(n.start <= start && n.end <= end){
            treeSet.remove(c);
            c.start = n.end;
            add(new Interval(start,n.end,2));
            n.end = start;
            treeSet.add(c);
        }else if(n.start >= start && n.end <= end){
            add(new Interval(n.start,n.end,2));
            treeSet.remove(c);
            add(new Interval(c.start,n.start));
            add(new Interval(n.end,c.end));
            n.status= 0;
        }else if(n.start<end && n.end>=end){
            treeSet.remove(c);
            add(new Interval(n.start,c.end,2));
            add(new Interval(c.start,n.start));
            n.start = c.end;
        }else{
            treeSet.remove(c);
            c.count = 2;
            add(new Interval(n.start,c.start));
            n.start = c.end;
            treeSet.add(c);
        }
    }

    void add(Interval n){
        if(n.start >= n.end || n.status == 0){
            return;
        }
        treeSet.add(n);
    }

    public boolean book2(int start, int end) {
        int count = 0;
        treeMap.put(start,treeMap.getOrDefault(start,0) + 1);
        treeMap.put(end,treeMap.getOrDefault(end,0) - 1);
        for(Map.Entry<Integer,Integer> entry : treeMap.entrySet()){
            count += entry.getValue();
            if(count > 2){
                treeMap.put(start,treeMap.get(start) - 1);
                treeMap.put(end,treeMap.get(end) + 1);
                return false;
            }
        }
        return true;
    }
}
