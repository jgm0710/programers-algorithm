package level1.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {

    private Stack<Integer> basket = new Stack<>();
    private Integer result = 0;
    private List<Stack<Integer>> boardStacks = new ArrayList<>();

    public int solution(int[][] board, int[] moves) {

        //column 0 -> length 순으로 stack 생성
        for (int i = 0; i < board[0].length; i++) {
            Stack<Integer> column = new Stack<>();
            // length -> 0 순으로 row 생성
            for (int j = board.length - 1; j >= 0; j--) {
                int doll = board[j][i];
                if (doll != 0) {
                    column.push(doll);
                }
            }
            boardStacks.add(column);
        }

        Arrays.stream(moves).forEach(position -> {
            // position 은 1 부터 시작하고, list 는 0 부터 시작하므로 -1
            position--;
            Stack<Integer> column = boardStacks.get(position);

            if (basket.isEmpty()) {
                if (!column.isEmpty()) {
                    basket.push(column.pop());
                }
            }else {
                if (!column.isEmpty()) {
                    if (basket.peek().equals(column.peek())) {
                        basket.pop();
                        column.pop();
                        result += 2;
                    } else {
                        basket.push(column.pop());
                    }
                }
            }
        });

        return result;
    }

}
