package competition;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public int giveGem(int[] gem, int[][] operations) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < operations.length; i++) {
            int[] operation = operations[i];
            int x = operation[0];
            int y = operation[1];
            int i1 = gem[x] / 2;
            gem[x] -= i1;
            gem[y] += i1;
        }

        for (int i = 0; i < gem.length; i++) {
            max = Math.max(max, gem[i]);
            min = Math.min(min, gem[i]);
        }
//        System.out.println(Arrays.toString(gem));
        return max - min;
    }

    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        int satiety = 0, delicious = 0;
        for (int j = 0; j < cookbooks.length; j++) {
            int[] lastMaterials = materials;
            int[] lastMaterials2 = lastMaterials;
            int flag = 0;
            for (int i = 0; i < cookbooks[j].length; i++) {
                if (lastMaterials[i] > cookbooks[j][i]) {
                    lastMaterials[i] -= cookbooks[j][i];
                } else {
                    lastMaterials = lastMaterials2;
                    flag = 1;
                    continue;
                }
            }
            if (flag == 0) {
                satiety += attribute[j][0];
                delicious += attribute[j][1];
            }
        }

        return 0;
    }
}
