package level1.first;

import java.util.Arrays;
import java.util.Hashtable;

public class Solution {

    public String solution(String[] participant, String[] completion) {
        Hashtable<String, Integer> participantHashTable = new Hashtable<>();
        Arrays.stream(participant).forEach(key -> {
            if (participantHashTable.containsKey(key)) {
                participantHashTable.put(key, participantHashTable.get(key) + 1);
            } else {
                participantHashTable.put(key, 1);
            }
        });

        Arrays.stream(completion).forEach(key -> {
            if (participantHashTable.containsKey(key)) {
                participantHashTable.put(key, participantHashTable.get(key) - 1);
            }
        });

        for (String key : participantHashTable.keySet()) {
            if (participantHashTable.get(key) > 0) {
                return key;
            }
        }

        return "";
    }

}
