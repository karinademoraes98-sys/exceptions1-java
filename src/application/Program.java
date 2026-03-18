package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		IO.print("Room Number: ");
		int Number = sc.nextInt();
		IO.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		IO.print("check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			IO.println("Error in reservation: Check-out date must be after check-in date");

		} else {
			Reservation reservation = new Reservation(Number, checkIn, checkOut);
			IO.println("Reservation: " + reservation);

			IO.println("Enter data to udat the reservation: ");
			IO.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			IO.print("check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			Date now = new Date();
			
			
			reservation.updateDates(checkIn, checkOut);
			IO.println("Reservation: " + reservation);
		}

		sc.close();
	}

}
