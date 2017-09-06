public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder ret = new StringBuilder();
        while(n > 0){
            n--;
            ret = ret.append((char)('A' + n % 26 ));
            n = n / 26 ;
        }
        return ret.reverse().toString();
    }
}
