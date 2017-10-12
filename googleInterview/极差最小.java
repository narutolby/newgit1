package google.usefullquestion;从一个int arr里面找到k个值使他们的极差最小：
input: [1, 2,10,99,100,-1] k =3
output: [-1,1,2]      2-(-1) = 3

思路：sort之后一个range=k查找，keep最小值