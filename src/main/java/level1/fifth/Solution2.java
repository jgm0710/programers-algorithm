package level1.fifth;

import java.util.regex.Pattern;

public class Solution2 {

    public String solution(String new_id) {

        String step1 = new_id.toLowerCase();
        String step2 = step1.replaceAll("[^a-z0-9-_.]", "");
        String step3 = step2.replaceAll("\\.+", ".");
        String step4 = step3.replaceAll("(^\\.)|(\\.$)", "");
        String step5 = step5(step4);
        String step6 = step6(step5);
        return step7(step6);
    }

    private String step7(String step6) {
        if (step6.length() <= 2) {
            String lastString = step6.substring(step6.length() - 1);

            return step6 + lastString.repeat(3 - step6.length());
        }

        return step6;
    }

    private String step6(String step5) {
        if (step5.length() > 15) {
            String step6 = step5.substring(0, 15);
            return step6.replaceAll("\\.+$", "");
        }
        return step5;
    }

    private String step5(String step4) {
        if (step4.isEmpty()) {
            return "a";
        }
        return step4;
    }

}
