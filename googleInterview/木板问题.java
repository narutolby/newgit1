package google.usefullquestion;二维列表，每行是一串数字，代表一块完整的木板的长度，每一行都是许多木板拼在一起，
比如[[6 8 11], [5, 5, 6, 9],...]就表示第一行三块木板是6 8 10, 第二行四块木板是5 5 6 9。每一行所有木板的总长度一样。
要找一个位置从上到下切所有行，使得破坏的完整木板数量最少。
    
    找到所有木板中间结束的点，统计频率最高的，就是切点