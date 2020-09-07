public class comparable{
    public static Comparable max(Comparable[] A) {
        if (A.length == 0) return 0;
        Comparable result; result = A[0];
        for (int i = 1; i < A.length; i++){
            if (result.compareTo(A[i]) < 0) result = A[i];
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(max(new String[] {"a", "b", "c"}));
    }
}