public class ArrayCustomIterator {
    private int [] array;
    private int currentIndex;

    public ArrayCustomIterator(int[] arr){
        this.array=arr;
        this.currentIndex=0;
    }

    public boolean hasNext(){
        if(this.currentIndex<this.array.length)
            return true;
        return false;
    }

    public int next(){
        return this.array[this.currentIndex++];
    }

    public static void main(String[] arg){
        int [] arr=new int[]{1,2,3};
        ArrayCustomIterator it= new ArrayCustomIterator(arr);
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
