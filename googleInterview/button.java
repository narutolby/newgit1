package google.usefullquestion;1. 给一堆button 1 2 3 4 5 ， 可以按很多次，但是不能有重复，每次按的button可以是多个button的组合，like 1-23-4，

        1-23-4 跟 1-32-4不算重复，1-23-34算重复
    http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=214021&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D2%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D1%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
    
    按按钮，先组合，再全排，然后插 '-'
public static  List<String>  buttonCombine(List<Integer> nums){
             List<String> re = new ArrayList<String>();
             boolean[] used = new boolean[nums.size()];
             help(re,0, new StringBuilder(), used, nums);
             return re;. from: 1point3acres.com/bbs 
        }. more info on 1point3acres.com
        
        public static void help( List<String> r,int level, StringBuilder sb, boolean[] used, List<Integer> nums){
            int size = nums.size();
            if(sb.length()!=0 && sb.charAt(sb.length()-1)!='-'){
                    StringBuilder newsb = new StringBuilder(sb);
                    r.add(newsb.toString());
            }
                if(level == size) return;
            for(int i=0; i<size; i++){
                        if(!used[i]){
                                used[i] = true;
                                sb.append(nums.get(i));-google 1point3acres
                                help(r,level+1, sb, used, nums);
                                sb.deleteCharAt(sb.length()-1);
                                if(level!=size-1){
                                        sb.append(nums.get(i)+"-");
                                        help(r,level+1, sb, used, nums);
                                        sb.delete(sb.length()-2, sb.length());
                                }
                                used[i] = false;
                        }
                }
        }

void CombButtons(string& buttons, int l, int r, int len,
                 vector<string>& button_select, string path) {
  if (path.size() == len). From 1point 3acres bbs
    button_select.push_back(path);
  else {. 鐣欏鐢宠璁哄潧-涓€浜╀笁鍒嗗湴
    for (int i = l; i <= r; i++) {
      path += buttons[i];
      CombButtons(buttons, i + 1, r, len, button_select, path);
      path.erase(path.end() - 1);
. visit 1point3acres.com for more.    }
  }
}. 1point3acres.com/bbs

void PermButtons(string& buttons, int l, int r, vector<string>& button_seq) {
  if (l == r)
    button_seq.push_back(buttons);
  else {
    for (int i = l; i <= r; i++) {
      swap(buttons[i], buttons[l]);
      PermButtons(buttons, l + 1, r, button_seq);
      swap(buttons[i], buttons[l]);
    }. 鐗涗汉浜戦泦,涓€浜╀笁鍒嗗湴
  }
}

void PressButtons(string buttons, int i, int n, vector<string>& res,
                  string path) {
  if (i == n)
    res.push_back(path);
  else {. more info on 1point3acres.com
    path += buttons[i];
    PressButtons(buttons, i + 1, n, res, path);.鐣欏璁哄潧-涓€浜�-涓夊垎鍦�
    if (i + 1 < n) PressButtons(buttons, i + 1, n, res, path + '-');
  }. from: 1point3acres.com/bbs 
}
. 涓€浜�-涓夊垎-鍦帮紝鐙鍙戝竷
int main(int argc, char const* argv[]) {.鐣欏璁哄潧-涓€浜�-涓夊垎鍦�
  string buttons = "123";
  int n = buttons.size();-google 1point3acres
  vector<string> res;
  vector<string> button_seq;
  vector<string> button_select;
  for (int len = 1; len <= n; len++)
    CombButtons(buttons, 0, n - 1, len, button_select, "");
-google 1point3acres  for (auto bs : button_select) PermButtons(bs, 0, bs.size() - 1, button_seq);
  for (auto pb : button_seq) PressButtons(pb, 0, pb.size(), res, "");
  for (auto r : res) cout << r << endl;
  return 0;
}
