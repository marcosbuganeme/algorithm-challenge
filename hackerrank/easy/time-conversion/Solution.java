import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {

        // Extract the period (AM/PM)
        String period = s.substring(s.length() - 2);

        // Extract the hour part
        String hourString = s.substring(0, 2);

        int hour = Integer.parseInt(hourString);

        // Convert hour based on period
        if (period.equals("AM")) {
            if (hour == 12) {
                hour = 0; // Midnight case
            }
        } else if (period.equals("PM")) {
            if (hour != 12) {
                hour += 12; // PM case
            }
        }

        // Format the hour part to two digits
        String newHourString = String.format("%02d", hour);

        // Construct the new time string in 24-hour format
        String militaryTime = newHourString + s.substring(2, s.length() - 2);

        return militaryTime;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
