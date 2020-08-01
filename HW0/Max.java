public class Max {
    public static void main(String[] args){
        int[] a = new int[] {1,2,3,4};
        System.out.println(max(a));
    }

    private static int max(int[] a){
        int cur_max = a[0];
        for (int i=1; i<a.length; i++){
            cur_max = cur_max>a[i]?cur_max:a[i];
        }
        return cur_max;
    }

}