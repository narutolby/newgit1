package google.usefullquestion;一问，给一个string,一个整数k,把string 切成k份让每一份的首字母都不一样。只需返回一个结果。
    能不能切需要确定不同字母的个数是否大于k.我做的很naive,找出不同字母的第一次出现的位置，然后排序，然后按照要求切就可以了。
    
    
    
    用hashset，每遍历到一个不通的字母，加入到hashset，一直加到k个，如果小于k，返回false，最后便利hashset存起来