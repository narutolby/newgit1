package contest63;

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
        if (s == null || numRows == 0 || numRows == 1) {
            return s;
        }
        int groupCount = 2 * (numRows - 1);
        int group = (s.length() - 1) / groupCount + 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < group; j++) {
                int start = j * groupCount;
                if(start + i > s.length()-1){
                    continue;
                }
                sb.append(s.charAt(start + i));
                if (i != 0 && i != numRows - 1) {
                    if (start + 2 * (numRows - 1) - i < s.length()) {
                        sb.append(s.charAt(start + 2 * (numRows - 1) - i));
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
