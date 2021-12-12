package level1.second;

import java.util.Arrays;
import java.util.Stack;

public class Solution2 {

    private int result = 0;
    private Stack<Integer> basket = new Stack<>();

    public int solution(int[][] board, int[] moves) {

        Arrays.stream(moves).forEach(position -> {
            int positionValue = getAndClearPositionTopValue(board, position);
            if (positionValue != 0) {
                if (basket.isEmpty()) {
                    basket.push(positionValue);
                } else {
                    if (basket.peek().equals(positionValue)) {
                        basket.pop();
                        result += 2;
                    } else {
                        basket.push(positionValue);
                    }
                }
            }
        });

        return result;
    }

    private int getAndClearPositionTopValue(int[][] board, int position) {
        position--;
        for (int i = 0; i < board.length; i++) {
            if (board[i][position] != 0) {
                int positionValue = board[i][position];
                board[i][position] = 0;
                return positionValue;
            }
        }
        return 0;
    }

}
