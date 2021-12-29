package level1.seventh;

public class SeventhSolution {

    private int leftHandPosition = -1;
    private int rightHandPosition = -2;

    private StringBuilder result = new StringBuilder();

    private final int[][] keyPad = initKeyPad();

    class Coords {
        int x;
        int y;

        public Coords(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public String solution(int[] numbers, String hand) {

        for (int targetPosition : numbers) {
            if (targetPosition == 1 || targetPosition == 4 || targetPosition == 7) {
                moveLeftHand(targetPosition);
            } else if (targetPosition == 3 || targetPosition == 6 || targetPosition == 9) {
                moveRightHand(targetPosition);
            } else {
                int leftHandDistance = calculateDistance(targetPosition, leftHandPosition);
                int rightHandDistance = calculateDistance(targetPosition, rightHandPosition);

                if (leftHandDistance == rightHandDistance) {
                    if (hand.equals("left")) {
                        moveLeftHand(targetPosition);
                    } else {
                        moveRightHand(targetPosition);
                    }
                } else if (leftHandDistance < rightHandDistance) {
                    moveLeftHand(targetPosition);
                } else {
                    moveRightHand(targetPosition);
                }
            }
        }

        return result.toString();
    }

    private void moveRightHand(int number) {
        result.append("R");
        rightHandPosition = number;
    }

    private void moveLeftHand(int number) {
        result.append("L");
        leftHandPosition = number;
    }

    private Coords getCoordsFromIndex(int index) {
        for (int i = 0; i < keyPad.length; i++) {
            for (int j = 0; j < keyPad[0].length; j++) {
                if (keyPad[i][j] == index) {
                    return new Coords(i, j);
                }
            }
        }
        return null;
    }

    private int calculateDistance(int targetPosition, int handPosition) {
        Coords targetCoords = getCoordsFromIndex(targetPosition);
        Coords handCoords = getCoordsFromIndex(handPosition);

        int dv1 = calculateDifferenceValue(targetCoords.x, handCoords.x);
        int dv2 = calculateDifferenceValue(targetCoords.y, handCoords.y);

        return dv1 + dv2;
    }

    private int calculateDifferenceValue(int x, int x1) {
        int result = x - x1;
        if (result < 0) {
            return result * -1;
        }
        return result;
    }

    private int[][] initKeyPad() {
        int keyPadNum = 1;
        int[][] keyPad = new int[4][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                keyPad[i][j] = keyPadNum++;
            }
        }
        keyPad[3][0] = -1;
        keyPad[3][1] = 0;
        keyPad[3][2] = -2;

        return keyPad;
    }

}
