public class Test {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,4,3,5};
        int i=1;
        int j=4;
        System.out.println("----交换前-----");
        System.out.println(arr[i]);
        System.out.println(arr[j]);
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
        System.out.println("----交换后-----");
        System.out.println(arr[i]);
        System.out.println(arr[j]);
    }
}
