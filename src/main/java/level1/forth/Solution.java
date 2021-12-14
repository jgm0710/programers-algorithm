package level1.forth;

public class Solution {

    public int[] solution(int[] lottos, int[] win_nums) {
        int matchCount = 0;
        int zeroCount = 0;

        for (int i = 0; i < lottos.length; i++) {
            int lottoNum = lottos[i];

            if (lottoNum == 0) {
                zeroCount++;
            } else {
                for (int j = 0; j < win_nums.length; j++) {
                    int winNum = win_nums[j];

                    if (winNum == lottoNum) {
                        matchCount++;
                        break;
                    }
                }
            }
        }

        int maxRank = calculateRank(matchCount + zeroCount);
        int minRank = calculateRank(matchCount);

        return new int[]{maxRank, minRank};
    }

    private int calculateRank(int matchCount) {
        if (matchCount >= 2 && matchCount <= 6) {
            return 7 - matchCount;
        } else {
            return 6;
        }
    }

}
