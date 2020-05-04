import java.util.Arrays;

public class Sample {
    public static void displaySorted(SortingStrategy strategy, Integer[] array){
        strategy.sort(array);
        for(int i=0;i<array.length;i++)
            System.out.print(array[i]+" ");
        System.out.println();
    }

    public static void main(String[] arg){
        Integer[] arr= new Integer[]{1,4,5,2,3,6,9,8,7};
        Integer[] copy01OfArr= Arrays.copyOf(arr,arr.length);
        Integer[] copy02OfArr= Arrays.copyOf(arr,arr.length);

        displaySorted(new BubbleSort(), copy01OfArr);
        displaySorted(new MergeSort(), copy02OfArr);
    }
}
