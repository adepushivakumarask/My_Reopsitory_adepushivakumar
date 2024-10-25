package casestydy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class HotelRoomBookingSystem {

    static int[] roomNumbers = new int[100];
    static boolean[] roomAvailability = new boolean[100];
    static String[] guestNames = new String[100];
    static String[] bookingHistory = new String[100];
    static LocalDateTime[] checkInTimes = new LocalDateTime[100];
    static LocalDateTime[] checkOutTimes = new LocalDateTime[100];
    static int roomCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        initializeRooms();

        while (!exit) {
            System.out.println("\n--- Hotel Room Booking System ---");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Check-in Guest");
            System.out.println("4. Check-out Guest");
            System.out.println("5. Generate Room Occupancy Report");
            System.out.println("6. View Booking History");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    viewAvailableRooms();
                    break;
                case 2:
                    bookRoom(scanner);
                    break;
                case 3:
                    checkInGuest(scanner);
                    break;
                case 4:
                    checkOutGuest(scanner);
                    break;
                case 5:
                    generateOccupancyReport();
                    break;
                case 6:
                    viewBookingHistory();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
        scanner.close();
    }

    // initialize room numbers and set all rooms as available
    public static void initializeRooms() {
        int roomNumber = 101;
        for (int i = 0; i < 10; i++) {
            roomNumbers[i] = roomNumber;
            roomAvailability[i] = true;
            guestNames[i] = "";
            bookingHistory[i] = "";
            checkInTimes[i] = null;
            checkOutTimes[i] = null;

            if (roomNumber % 100 == 4) {
                roomNumber += 97;
            } 
            else {
                roomNumber++;
            }
        }
        roomCount = 10;
    }

    // view available rooms with booking status
    public static void viewAvailableRooms() {
        System.out.println("\n--- Available Rooms ---");
        boolean anyAvailable = false;
        for (int i = 0; i < roomCount; i++) {
            if (roomAvailability[i]) {
                System.out.println(roomNumbers[i]);
                anyAvailable = true;
            } else {
                System.out.println(roomNumbers[i] + " (Booked)");
            }
        }
        if (!anyAvailable) {
            System.out.println("No rooms available.");
        }
    }

 // book a room
    public static void bookRoom(Scanner scanner) {
        System.out.print("Enter room number to book: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine();  // consume newline
        int roomIndex = findRoom(roomNumber);

        if (roomIndex != -1 && roomAvailability[roomIndex]) {
            System.out.print("Enter guest name for booking: ");
            String guestName = scanner.nextLine();
            guestNames[roomIndex] = guestName;
            roomAvailability[roomIndex] = false;

            // booking time
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            bookingHistory[roomIndex] = dtf.format(now);

            System.out.println("Room " + roomNumber + " booked successfully for " + guestName + ".");
        } 
        else if (roomIndex != -1) {
            System.out.println("Room " + roomNumber + " is already occupied.");
        } 
        else {
            System.out.println("Room not found.");
        }
    }


    
 // check in a guest
    public static void checkInGuest(Scanner scanner) {
        System.out.print("Enter room number to check in: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); 
        int roomIndex = findRoom(roomNumber);

        if (roomIndex != -1 && !roomAvailability[roomIndex]) {
            System.out.println("Guest " + guestNames[roomIndex] + " has successfully checked into " + roomNumber + ".");
            // Record check-in time
            checkInTimes[roomIndex] = LocalDateTime.now();
        } 
        else if (roomIndex != -1) {
            System.out.println("Room " + roomNumber + " is not yet booked.");
        } 
        else {
            System.out.println("Room not found.");
        }
    }

    // check out a guest and record check-out time
    public static void checkOutGuest(Scanner scanner) {
        System.out.print("Enter room number to check out: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); 
        int roomIndex = findRoom(roomNumber);

        if (roomIndex != -1 && !roomAvailability[roomIndex]) {
            System.out.println("Guest " + guestNames[roomIndex] + " has checked out from " + roomNumber + ".");
            // Record check-out time
            checkOutTimes[roomIndex] = LocalDateTime.now();

            // room as available again
            roomAvailability[roomIndex] = true;  
            guestNames[roomIndex] = ""; 
        } else if (roomIndex != -1) {
            System.out.println("Room " + roomNumber + " is already available.");
        } else {
            System.out.println("Room not found.");
        }
    }

    
    //generate a room occupancy report
    public static void generateOccupancyReport() {
        System.out.println("\n--- Room Occupancy Report ---");
        boolean anyOccupied = false;
        for (int i = 0; i < roomCount; i++) {
            if (!roomAvailability[i]) {
                System.out.println(roomNumbers[i] + " - Occupied by: " + guestNames[i]);
                anyOccupied = true;
            }
        }
        if (!anyOccupied) {
            System.out.println("No rooms are currently occupied.");
        }
    }

 // view booking history
    public static void viewBookingHistory() {
        System.out.println("\n--- Booking History ---");
        boolean hasHistory = false;

        for (int i = 0; i < roomCount; i++) {
            if (bookingHistory[i] != null && !bookingHistory[i].isEmpty()) {
                
                System.out.println(roomNumbers[i] + ": " + guestNames[i]);
              
                System.out.println("        > " + guestNames[i] + " booked at " + bookingHistory[i]);
                
                if (checkInTimes[i] != null) {
                    System.out.println("        > " + guestNames[i] + " check-in at " + checkInTimes[i].format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
                } 
                else {
                    System.out.println("        > check-in at (not yet checked in)");
                }

                if (checkOutTimes[i] != null) {
                    System.out.println("        > " + guestNames[i] + " check-out at " + checkOutTimes[i].format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
                } 
                else {
                    System.out.println("        > check-out at (not yet checked out)");
                }

                hasHistory = true;
            }
        }

        if (!hasHistory) {
            System.out.println("No booking history available.");
        }
    }


    //find a room by its number
    public static int findRoom(int roomNumber) {
        for (int i = 0; i < roomCount; i++) {
            if (roomNumbers[i] == roomNumber) {
                return i;
            }
        }
        return -1;
    }
}