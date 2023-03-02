package org.andy;

import java.util.Scanner;

public class HttpImageStatusCli {
    private final HttpStatusImageDownloader httpStatusImageDownloader;

    public HttpImageStatusCli() {
        this.httpStatusImageDownloader = new HttpStatusImageDownloader();
    }

    public void askStatus() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter HTTP status code to download an image or 'exit' to quit:");
            String input = scanner.nextLine();

            if (input.equals("exit")) {
                break;
            }

            if (!isInputValid(input)) {
                System.out.println("Please enter valid number or 'exit' to quit");
                continue;
            }

            try {
                httpStatusImageDownloader.downloadStatusImage(Integer.parseInt(input));
            } catch (Exception e) {
                System.out.println(e.getMessage());

                continue;
            }

            System.out.println("Image downloaded successfully!");
        }
    }

    private boolean isInputValid(String input) {
        if (input == null) {
            return false;
        }

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
