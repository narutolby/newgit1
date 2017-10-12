package google.usefullquestion;given 2 interger arrays, return the sum of the digits in array
eg, [1,2,3] + [5] = [1,2,8]
    public static int helper(int[] num1,int[] num2){
		StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length - 1, j = num2.length - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int x = i < 0 ? 0 : num1[i];
            int y = j < 0 ? 0 : num2[j];
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return Integer.parseInt(sb.reverse().toString());
	}
这是返回int的方法，如果是返回数组，就再后面加几行就行，把string一个个转到int数组里