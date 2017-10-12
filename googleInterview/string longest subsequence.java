package google.usefullquestion;给你一个字典，一个string，找出字典中这个string的最长subsequence，面试官一直在强调这个dict很大。我想了一下说可以iterate through all the subsequences of the string。进一步，我说我们可以先找出dict中最长word的长度 L ，然后只iterate through长度为1～L的subsequence。

    
    
    
    
    
    先找出dict中最长word的长度 L ，然后只iterate through长度为1～L的subsequence。然后trie tree