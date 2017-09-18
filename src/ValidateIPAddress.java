/**
 * @author boyang.lby
 * @date 9/16/17
 * @description
 */

/**
 * Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.
 *
 * IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each
 * ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
 *
 * Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.
 *
 * IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The
 * groups are separated by colons (":").
 * For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. Also, we could omit some leading
 * zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones,
 * so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).
 *
 * However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons
 * (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.
 *
 * Besides, extra leading zeros in the IPv6 is also invalid. For example, the address
 * 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.
 *
 * Note: You may assume there is no extra space or special characters in the input string.
 *
 * Example 1:
 * Input: "172.16.254.1"
 *
 * Output: "IPv4"
 *
 * Explanation: This is a valid IPv4 address, return "IPv4".
 * Example 2:
 * Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"
 *
 * Output: "IPv6"
 *
 * Explanation: This is a valid IPv6 address, return "IPv6".
 * Example 3:
 * Input: "256.256.256.256"
 *
 * Output: "Neither"
 *
 * Explanation: This is neither a IPv4 address nor a IPv6 address.
 */
public class ValidateIPAddress {
    public String validIPAddress(String ip) {
        if(checkIpv4(ip)){
            return "IPv4";
        }
        if(checkIpv6(ip)){
            return "IPv6";
        }
        return "Neither";
    }

    public boolean checkIpv4(String ip){
        if(ip == null || ip.length() == 0){
            return false;
        }
        ip = ip + ".";
        int count = 0;
        for(int i=0;i<ip.length();){
            int i0 = i;
            while(i0<ip.length() && ip.charAt(i0) != '.'){
                i0++;
            }
            String segment = ip.substring(i,i0);
            count++;
            if(segment.length() == 0 || segment.length()>3){
                return false;
            }
            if(segment.length() > 1 && segment.charAt(0) == '0'){
                return false;
            }
            for(int j=0;j<segment.length();j++){
                if(segment.charAt(j)<'0' || segment.charAt(j)>'9'){
                    return false;
                }
            }
            if(Integer.valueOf(segment) > 255){
                return false;
            }
            i = i0+1;
        }
        if(count != 4){
            return false;
        }
        return true;
    }
    public boolean checkIpv6(String ip){
        if(ip == null || ip.length() == 0){
            return false;
        }
        int count = 0;
        ip = ip + ':';
        for(int i=0;i<ip.length();){
            int i0 = i;
            while(i0<ip.length() && ip.charAt(i0) != ':'){
                i0++;
            }
            String segment = ip.substring(i,i0);
            count++;
            if(segment.length() == 0 || segment.length() > 4){
                return false;
            }
            for(int j=0;j<segment.length();j++){
                char c = segment.charAt(j);
                if(!(c>='0' && c<='9') && !(c>='a' && c<='f') && !(c>='A' && c<='F')){
                    return false;
                }
            }
            i = i0 + 1;
        }
        if(count != 8){
            return false;
        }
        return true;
    }
}
