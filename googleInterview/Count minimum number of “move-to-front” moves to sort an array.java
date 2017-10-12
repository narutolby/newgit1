package google.usefullquestion;http://www.geeksforgeeks.org/count-minimum-number-move-front-moves-sort-array/
int minMoves(int arr[], int n)
{
    // Since we traverse array from end, extected item
    // is initially  n
    int expectedItem = n;
 
    // Taverse array from end
    for (int i=n-1; i >= 0; i--)
    {
        // If current item is at its correct position,
        // decrement the expectedItem (which also means
        // decrement in minimum number of moves)
        if (arr[i] == expectedItem)
            expectedItem--;
    }
 
    return expectedItem;
}