package level1.fifth;

public class Solution {

    private final String SPECIAL_CHAR_PATTERN = "~!@#$%^&*()=+[{]}:?,<>/";

    public String solution(String new_id) {

        String step1 = toLowerCase(new_id);
        String step2 = removeSpecialCharacter(step1);
        String step3 = reduceDot(step2);
        String step4 = removeEndpointDots(step3);

        String step5 = isEmptyStringThenReturnA(step4);
        String step6 = cutStringAndRemoveEndDot(step5);

        return ifShortLengthThenCopyLastWord(step6);
    }

    private String ifShortLengthThenCopyLastWord(String step6) {
        int step6Length = step6.length();
        if (step6Length <= 2) {
            String lastString = step6.substring(step6Length - 1);
            return step6 + lastString.repeat(3 - step6Length);
        }
        return step6;
    }

    private String cutStringAndRemoveEndDot(String step5) {
        String step6 = step5;
        if (step5.length() > 15) {
            step6 = step5.substring(0, 15);
        }
        if (step6.endsWith(".")) {
            step6 = step6.substring(0, step6.length() - 1);
        }
        return step6;
    }

    private String isEmptyStringThenReturnA(String step4) {
        if (step4.isEmpty()) {
            return "a";
        }
        return step4;
    }

    private String removeEndpointDots(String step3) {
        int startIndex = 0;
        int endIndex = step3.length();

        if (step3.startsWith(".")) {
            startIndex++;
        }
        if (step3.endsWith(".")) {
            endIndex--;
        }

        if (startIndex > endIndex) {
            return "";
        }

        return step3.substring(startIndex, endIndex);
    }

    private String reduceDot(String step2) {
        String step3 = step2;

        while (true) {
            if (!step3.contains("..")) {
                return step3;
            } else {
                step3 = step3.replace("..", ".");
            }
        }
    }

    private String removeSpecialCharacter(String step1) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = step1.toCharArray();
        for (char ch : chars) {
            if (isSpecialCharacter(ch)) {
                continue;
            }
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }

    private boolean isSpecialCharacter(char ch) {
        return SPECIAL_CHAR_PATTERN.contains(String.valueOf(ch));
    }

    private String toLowerCase(String new_id) {
        return new_id.toLowerCase();
    }

}

