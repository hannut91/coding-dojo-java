package app;

import java.util.Arrays;
import java.util.HashMap;

public class App {
    public static String run(int[] numbers, String hand) {
        HashMap<String, int[]> matrix = new HashMap();
        matrix.put("*", new int[]{0, 0});
        matrix.put("0", new int[]{1, 0});
        matrix.put("#", new int[]{2, 0});
        matrix.put("7", new int[]{0, 1});
        matrix.put("8", new int[]{1, 1});
        matrix.put("9", new int[]{2, 1});
        matrix.put("4", new int[]{0, 2});
        matrix.put("5", new int[]{1, 2});
        matrix.put("6", new int[]{2, 2});
        matrix.put("1", new int[]{0, 3});
        matrix.put("2", new int[]{1, 3});
        matrix.put("3", new int[]{2, 3});
        int[] leftHand = {0, 0};
        int[] rightHand = {2, 0};

        return result(leftHand, rightHand, hand, numbers, "");
    }

    public static String result(
            int[] left,
            int[] right,
            String hand,
            int[] numbers,
            String output
    ) {
        HashMap<String, int[]> matrix = new HashMap();
        matrix.put("*", new int[]{0, 0});
        matrix.put("0", new int[]{1, 0});
        matrix.put("#", new int[]{2, 0});
        matrix.put("7", new int[]{0, 1});
        matrix.put("8", new int[]{1, 1});
        matrix.put("9", new int[]{2, 1});
        matrix.put("4", new int[]{0, 2});
        matrix.put("5", new int[]{1, 2});
        matrix.put("6", new int[]{2, 2});
        matrix.put("1", new int[]{0, 3});
        matrix.put("2", new int[]{1, 3});
        matrix.put("3", new int[]{2, 3});

        if (numbers.length == 0) {
            return output;
        }

        int number = numbers[0];
        int[] target = matrix.get(Integer.toString(number));

        String movingHand = whichHand(left, right, number, hand);
        if (movingHand == "L") {
            left = target;
        } else {
            right = target;
        }

        return result(
                left,
                right,
                hand,
                Arrays.copyOfRange(numbers, 1, numbers.length),
                output + movingHand
        );
    }

    public static String whichHand(
            int[] left, int[] right, int number, String hand
    ) {
        if (number == 3 || number == 6 || number == 9) {
            return "R";
        }

        if (number == 1 || number == 4 || number == 7) {
            return "L";
        }

        int leftDistance = calculateDistance(left, number);
        int rightDistance = calculateDistance(right, number);
        if (leftDistance < rightDistance) {
            return "L";
        } else if (leftDistance > rightDistance) {
            return "R";
        } else {
            if (hand == "left") {
                return "L";
            } else {
                return "R";
            }
        }
    }

    public static int calculateDistance(int[] position, int number) {
        HashMap<String, int[]> matrix = new HashMap();
        matrix.put("*", new int[]{0, 0});
        matrix.put("0", new int[]{1, 0});
        matrix.put("#", new int[]{2, 0});
        matrix.put("7", new int[]{0, 1});
        matrix.put("8", new int[]{1, 1});
        matrix.put("9", new int[]{2, 1});
        matrix.put("4", new int[]{0, 2});
        matrix.put("5", new int[]{1, 2});
        matrix.put("6", new int[]{2, 2});
        matrix.put("1", new int[]{0, 3});
        matrix.put("2", new int[]{1, 3});
        matrix.put("3", new int[]{2, 3});

        int[] target = matrix.get(Integer.toString(number));

        return Math.abs(target[0] - position[0])
                + Math.abs(target[1] - position[1]);
    }
}
