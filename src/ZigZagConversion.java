/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0){
            return s;
        }
        int groupCount  = numRows * 2 - 2;
        int groupNum = (s.length() - 1) / groupCount + 1;
        StringBuilder sb = new StringBuilder();
        for(int j=0;j<numRows;j++){
            for(int i=0;i<groupNum;i++){
            int start = i * groupCount;
                if(start + j < s.length()){
                    sb.append(s.charAt(start+j));
                }
                if(j > 0 && j < numRows - 1){
                    if(start + j + numRows - 1 < s.length()){
                        sb.append(s.charAt(start+j + numRows - 1));
                    }
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[]args){
        System.out.println(new ZigZagConversion().convert("PAYPALISHIRING",3));
    }
}
