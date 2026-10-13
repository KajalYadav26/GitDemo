package utils;

import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

    public static void saveBookingId(String bookingId) {

        try {
            FileWriter writer =
                    new FileWriter("BookingDetails.txt");

            writer.write("Booking ID : " + bookingId);

            writer.close();

            System.out.println(
                    "Booking ID saved successfully."
            );

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}