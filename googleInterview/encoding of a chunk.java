package google.usefullquestion;

public static String helper(String str){
		int sum=0;
		int i=0;
		while(str.charAt(i)!='\\'){
			int cur=str.charAt(i)-'0';
			if(cur>=0&&cur<=9){
				sum=sum*10+cur;
				i++;
			}else return null;
		}
		if(str.length()!=(i+sum+8)) return null;
		if(!str.substring(i, i+5).equals("\r\n")){
			return null;
		}else i=i+4;
		String res=str.substring(i,i+sum);
		i=i+sum;
		if(!str.substring(i, i+5).equals("\r\n")){
			return null;
		}else return res;
		
	}