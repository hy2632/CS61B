public class RengBeiZi {
    
    
    // W(n, k) = 1 + min{max(W(n -1, x -1), W(n, k - x))}, x in {2, 3, ……，k}
    // 其中x是第一次的测试的楼层位置
    // 其中W(1,k) = k（相当于 1 个杯子测试 k 层楼问题），W(0,k) = 0，W(n, 0) = 0
    static int DroppingCups(int cups, int floors) {
        int i, j, k, t, max;
        int[][] temp = new int[cups + 1][floors + 1];

        for (i = 0; i < floors + 1; ++i) {
            temp[0][i] = 0;
            temp[1][i] = i;
        }

        for (i = 2; i < cups + 1; ++i) {
            temp[i][0] = 0;
            temp[i][1] = 1;
        }

        for (i = 2; i < cups + 1; ++i) {
            for (j = 2; j < floors + 1; ++j) {
                for (k = 1, max = Integer.MAX_VALUE; k < j; ++k) {
                    t = temp[i][j - k] > temp[i - 1][k - 1] ? temp[i][j - k] : temp[i - 1][k - 1];
                    if (max > t) {
                        max = t;
                    }
                }
                temp[i][j] = max + 1;
            }
        }
        return temp[cups][floors];
    }

    public static void main(String[] args){
        int cups = 2, floors = 100;
        System.out.println(DroppingCups(cups, floors));
    }
}
