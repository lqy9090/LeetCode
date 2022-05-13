package competition;

public class Main {

    public void giveGem(){
        Solution solution = new Solution();
        int[] gem = {0,0,0,0};
        int[][] operation = {{1,2},{3,1},{1,2}};
        int res = solution.giveGem(gem, operation);
        System.out.println(res);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.giveGem();
    }

}
