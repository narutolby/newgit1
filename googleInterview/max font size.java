package google.usefullquestion;Given a screen with a given width, height and supported min/max font size, determine the max font a given string can be displayed in. Word or character can’t be broken. Imagine a method getWidth(char c, int fontSize) and getHeight(int fontSize) are given

    二分搜[minFont, maxFont]这个范围
找到mid，把string里的都按mid font放到screen中，放不下，往左，放下，往右