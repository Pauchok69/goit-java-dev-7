package org.andy;

public class Main {
    public static void main(String[] args) {
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();

        try {
            System.out.println("httpStatusChecker.getStatusImage(200) = " + httpStatusChecker.getStatusImage(404));
            System.out.println("httpStatusChecker.getStatusImage(11111) = " + httpStatusChecker.getStatusImage(11111));
            System.out.println("httpStatusChecker.getStatusImage(200) = " + httpStatusChecker.getStatusImage(200));


        } catch (Exception e) {
            System.out.println("e = " + e);
        }
    }
}
