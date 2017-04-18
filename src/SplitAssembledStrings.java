/**
 * @author boyang.lby
 * @date 4/16/17
 * @description
 */
public class SplitAssembledStrings {
    public String splitLoopedString(String[] strs) {
        String ret = "";
        for(int i=0;i<strs.length;i++){
            String str = strs[i];
            String res = new StringBuilder(str).reverse().toString();
            if(str.compareTo(res)<0){
                strs[i] = res;
            }
        }

        for(int i=0;i<strs.length;i++){
            StringBuilder sb = new StringBuilder();
            int j=i;
            while((j = next(j,strs.length))!=i){
                sb.append(strs[j]);
            }
            String sbs = sb.toString();
            String[]ta = new String[]{strs[i],new StringBuilder(strs[i]).reverse().toString()};
            for(String t : ta){
                for(int x = 0;x<t.length();x++){
                    String tmpRet = t.substring(x) + sbs + t.substring(0,x);
                    if(tmpRet.compareTo(ret) > 0){
                        ret = tmpRet;
                    }
                }
            }
        }
        return ret;
    }

    public int next(int i,int len){
        if(i+1>len-1){
            return 0;
        }
        return i+1;
    }
}
