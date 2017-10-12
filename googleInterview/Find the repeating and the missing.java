package google.usefullquestion;http://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
 位运算
void printTwoElements(int arr[], int size)
{
    int i;
    printf("\n The repeating element is");
 
    for(i = 0; i < size; i++)
    {
        if(arr[abs(arr[i])-1] > 0)
            arr[abs(arr[i])-1] = -arr[abs(arr[i])-1];
        else
            printf(" %d ", abs(arr[i]));
    }
 
    printf("\nand the missing element is ");
    for(i=0; i<size; i++)
    {
        if(arr[i]>0)
            printf("%d",i+1);
    }
}