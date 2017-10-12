package google.usefullquestion;

public class AverageFinder {
    private Stack<Integer> stack
    public void addNum(int num) {
        stack=new Stack<>();
        stack.add(num);
    }

    public double findAverage() {
        int sum=0;
        for(int i=0;i<10;i++){
            sum+=stack.pop();
        }
        return sum/10;
    }
};
