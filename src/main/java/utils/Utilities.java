package utils;
import dataStructures.CustomLinkedList.CustomLinkedList;

public class Utilities {

    public static double toTwoDecimalPlaces(double number) {
        return (int) (number * 100) / 100.0;
    }

    public static char booleanToYN(boolean booleanToConvert) {
        return booleanToConvert ? 'Y' : 'N';
    }

    public static boolean YNtoBoolean(char charToConvert) {
        return ((charToConvert == 'y') || (charToConvert == 'Y'));
    }

    public static boolean validRange(int numberToCheck, int min, int max) {
        return ((numberToCheck >= min) && (numberToCheck <= max));
    }

    public static boolean validRange(float numbertoCheck, float min, float max, float delta) {
        return ((numbertoCheck >= (min-delta)) && (numbertoCheck <= (max+delta)));

    }

    public static String truncateString(String stringToTruncate, int length){
        if (stringToTruncate != null) {
            if (stringToTruncate.length() <= length) {
                return stringToTruncate;
            } else {
                return stringToTruncate.substring(0, length);
            }
        }
        else
            return null;
    }

    public static boolean validStringlength(String strToCheck, int maxLength){
        if (strToCheck != null ){
            return strToCheck.length() <= maxLength;
        }
        return false;
    }

    public static boolean isValidIndex(CustomLinkedList list, int indexToCheck){
        return ((indexToCheck >= 0) && (indexToCheck < list.size()));
    }
}
