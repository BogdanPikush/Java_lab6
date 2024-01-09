package org.example;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingTest {

    @Test
    public void testBookSeats() {
        char[][][] hall = Initialization.initializeHall(3, 3, 1);

        Booking.bookSeats(hall, 0, new int[]{0, 1}, 0);

        assertEquals('1', hall[0][0][0]);
        assertEquals('1', hall[0][0][1]);
        assertEquals('O', hall[0][0][2]);
    }

    @Test
    public void testCancelBooking() {
        char[][][] hall = Initialization.initializeHall(3, 3, 1);
        Booking.bookSeats(hall, 0, new int[]{0, 1}, 0);

        Booking.cancelBooking(hall, 0, new int[]{0, 1}, 0);

        assertEquals('O', hall[0][0][0]);
        assertEquals('O', hall[0][0][1]);
        assertEquals('O', hall[0][0][2]);
    }

    @Test
    public void testCheckAvailability() {
        char[][][] hall = Initialization.initializeHall(3, 3, 1);

        assertTrue(Booking.checkAvailability(hall, 0, 2, 0));
        assertFalse(Booking.checkAvailability(hall, 0, 4, 0));
    }

    @Test
    public void testCheckAvailabilityInvalidIndices() {
        char[][][] hall = Initialization.initializeHall(3, 3, 1);

        assertFalse(Booking.checkAvailability(hall, -1, 2, 0));
        assertFalse(Booking.checkAvailability(hall, 0, 2, 1));
    }
}


