
public class MapInJava {
    public static IntList map(IntUnaryFunction proc, IntList items){
        if (items == null)
            return null;
        else return new IntList(proc.apply(items.head), map(proc, items.tail));
    }


    public static void main (String[] args){
        IntUnaryFunction abs = new Abs(); // Abs implements IntUnaryFunction, and has apply
        IntList x = IntList.list(1,-1,3,4);
        IntList R = map(abs, x);

        R = map(new IntUnaryFunction(){
            public int apply(int x) {return Math.abs(x);}
        }, x);
        
        R = map((int a) -> Math.abs(a), x);
        R = map(Math::abs, x);


        IntList.printIntList(R);
    }
}


