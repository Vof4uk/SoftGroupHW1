package ua.mykytenko;

public class PhoneBot {
    public static void main(String[] args) {
        makeCall(4);
        makeCall(8);
        makeCall(22);
    }
    public static void makeCall(int hoursSinceMidnight) {
        if(hoursSinceMidnight >= 8 && hoursSinceMidnight <= 21 ) {
            System.out.println("Привет");
        }
        else{
            System.out.println("Абонент отдыхает");
        }
    }
}
