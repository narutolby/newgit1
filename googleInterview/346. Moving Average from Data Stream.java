package google.usefullquestion;

public class MovingAverage {
    private int [] window;
    private int n, insert;
    private long sum;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        window = new int[size];
        insert = 0;
        sum = 0;
    }
    
    public double next(int val) {
        if (n < window.length)  n++;
        sum -= window[insert];
        sum += val;
        window[insert] = val;
        insert = (insert + 1) % window.length;
        
        return (double)sum / n;
    }
}
public class MovingAverage {

	Deque<Integer> dq;
	int size;
	int sum;
	public MovingAverage(int size) {
		dq = new LinkedList<>();
		this.size = size;
		this.sum = 0;
	}

	public double next(int val) {
		if (dq.size() < size) {
			sum += val;
			dq.addLast(val);
			return (double) (sum / dq.size());
		} else {
			int temp = dq.pollFirst();
			sum -= temp;
			dq.addLast(val);
			sum += val;
			return (double) (sum / size);
		}
	}

}
follow-up: 如果相当的多，而且窗口的range很大，大到任何数据结构都装不下，要求in-place 
   - 答：把所有的数字分成很多组，记录每组的平均值存在一个bucket数组里