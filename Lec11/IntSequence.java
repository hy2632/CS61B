class IntSequence implements Comparable<IntSequence>{
    private int[] myValues;
    private int myCount;
    public int get(int k) { return myValues[k]; }

    @Override
    public int compareTo(IntSequence x) {
        // IntSequence x = (IntSequence) obj;
        for (int i = 0; i < myCount && i < x.myCount; i++){
            if (myValues[i] < x.myValues[i]) {
                return -1;
            } else if (myValues[i] > x.myValues[i]) {
                return 1;
            }
        }
        return myCount - x.myCount;
    }

}
