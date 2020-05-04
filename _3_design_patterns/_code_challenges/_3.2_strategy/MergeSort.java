public class MergeSort implements SortingStrategy {
    //iterative merge sort
    @Override
    public void sort(Integer[] list) {
       if(list==null)
           return;
       if(list.length>1){
           int middle=list.length/2;

           Integer[] left=new Integer[middle];
           System.arraycopy(list, 0, left, 0, middle);

           Integer[] right=new Integer[list.length-middle];
           System.arraycopy(list, middle, right, 0, list.length - middle);

           sort(left);
           sort(right);
           merge(list,left,right);
       }
    }

    public void merge(Integer[] array, Integer[]left, Integer[] right){
        int i=0;
        int j=0;
        int k=0;
        while(i<left.length && j<right.length)
            if(left[i]<right[j])
                array[k++]=left[i++];
            else
                array[k++]=right[j++];
        while(i<left.length)
            array[k++]=left[i++];
        while(j<right.length)
            array[k++]=right[j++];
    }
}

