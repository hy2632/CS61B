public class hanoitower {
    public static void hanoi(int n, String source, String temp, String target){
        if (n == 1){
            move (n, source, target);
        } else {
            hanoi (n - 1, source, target, temp);
            move (n, source, target);
            hanoi (n - 1, temp, source, target);
        }
    }

    //盘子n的从sourceTower->targetTower的移动
    private static void move(int n, String sourceTower, String targetTower) {
        System.out.println("第" + n + "号盘子 move:" + sourceTower + "--->" + targetTower);
    }


    public static void main (String[] args){
        hanoi(3, "A", "B", "C");
    }
}
