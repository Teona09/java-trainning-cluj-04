public class BubbleSort implements SortingStrategy{
    @Override
    public void sort(Integer[] list) {
        int n = list.length;
        for(int i=0;i<n-1;i++)
            for(int j=0;j<n-i-1;j++)
                if(list[j]>list[j+1]){
                    int auxiliar=list[j];
                    list[j]=list[j+1];
                    list[j+1]=auxiliar;
                }
    }
}
