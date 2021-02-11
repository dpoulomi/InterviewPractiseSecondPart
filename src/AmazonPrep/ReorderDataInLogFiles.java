package AmazonPrep;

import java.util.Arrays;

public class ReorderDataInLogFiles {


    public static void main(String[] args) {
        // letter log sorting required
        //digit log keep the oroginal order
        String[] logs = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        ReorderDataInLogFiles reorderDataInLogFiles = new ReorderDataInLogFiles();
        logs = reorderDataInLogFiles.reorderLogs(logs);
        Arrays.stream(logs).forEach(e -> System.out.println(e));
    }

    private String[] reorderLogs(String[] logs) {

        Arrays.sort(logs, (log1, log2) -> {
            String parsedLog1 = log1.substring(log1.indexOf(" ") + 1, log1.length());
            String parsedLog2 = log2.substring(log2.indexOf(" ") + 1, log2.length());

            boolean isDigit1 = Character.isDigit(parsedLog1.charAt(0));
            boolean isDigit2 = Character.isDigit(parsedLog2.charAt(0));

            //sorting when both letters
            if (!isDigit1 && !isDigit2) {
                int comparisonResult = parsedLog1.compareTo(parsedLog2);

                if (comparisonResult == 0) {
                    String identifier1 = log1.substring(0, log1.indexOf(" "));
                    String identifier2 = log2.substring(0, log2.indexOf(" "));
                    return identifier1.compareTo(identifier2);
                } else {
                    return comparisonResult;
                }
            }

            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });

        return logs;
    }
}
