package bmsbackend;

import java.sql.*;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;



public class BookYourMovieSystem {
    Scanner sc = new Scanner(System.in);

    public void displayMovies() {
        try {
            Connection con = Databaseconfigure.getconnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Movies");
            System.out.println("Available---Movies");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("movie_id") + " - " + rs.getString("title")+" - "+
                                rs.getString("lang")+" - "+rs.getString("genere")+" - "+
                                rs.getInt("duration")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void displaytheater(String cityname){

        try{
            Connection con = Databaseconfigure.getconnection();
            PreparedStatement stm = con.prepareStatement("Select * from Theaters where city=?");
            stm.setString(1,cityname);
            ResultSet rs= stm.executeQuery();
            System.out.println("Available Theater in selected  city"+ " "+cityname);
            while (rs.next()){
                System.out.println(
                        rs.getInt("theater_id")+" - "+rs.getString("name")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }


    }public void displayshows(int theaterID,int movieid){
        try{
            Connection con = Databaseconfigure.getconnection();
            PreparedStatement stm=con.prepareStatement("Select * from Shows where theater_id=? and movie_id=?");
            stm.setInt(1,theaterID);
            stm.setInt(2,movieid);
            ResultSet rs = stm.executeQuery();

            System.out.println("Available show");

            while (rs.next()){
                System.out.println(
                        rs.getInt("show_id")+" - "+rs.getString("show_time")
                                +" - "+rs.getString("timing")+" - "+rs.getInt("available_seat"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void displaybookticket(int userId, int showId, List<String> selectedseat){
        try {
            Connection con = Databaseconfigure.getconnection();
            con.setAutoCommit(false);

            //check if seats available;
            boolean alradybookedseat = false;
            for (String seat : selectedseat) {
                PreparedStatement stm = con.prepareStatement("Select * from Seat where seat_number = ? and show_id =?");
                stm.setString(1, seat);
                stm.setInt(2, showId);
                ResultSet rs = stm.executeQuery();

                if (rs.next() && rs.getBoolean("is_booked")) {
                    alradybookedseat = true;
                    System.out.println("seat" + "is already booked Choose anthore seat");
                }
            }
            if (alradybookedseat) {
                System.out.println("Booking failed Some");
                con.rollback();
                return;
            }



            for(String seat:selectedseat){
                PreparedStatement stm = con.prepareStatement("UPDATE Seat SET is_booked = true WHERE show_id = ? AND seat_number = ?");
                stm.setInt(1, showId);
                stm.setString(2,seat );




                stm.executeUpdate();



            }
            double seatprice =200;
            double total_amount =selectedseat.size()*seatprice;
            PreparedStatement stm = con.prepareStatement("insert into Bookings(user_id,show_id,seat_booked,total_price) values(?,?,?,?)");
             stm.setInt(1,userId);
             stm.setInt(2,showId);
            stm.setString(3, String.join(",", selectedseat));





            stm.setDouble(4, total_amount);
            stm.executeUpdate();
             con.commit();
            System.out.println("Booking Successful. Seats: " + selectedseat+"totalamount"+total_amount);

        }
        catch(SQLException e){
            e.printStackTrace();
        }


    }public void displayAllShows() {
        try {
            Connection con = Databaseconfigure.getconnection();
            String sql = "SELECT t.city, t.theater_id, t.name AS theater_name, "
                    + "m.movie_id, m.title AS movie_name, "
                    + "s.show_id, s.show_time, s.timing, s.available_seat "
                    + "FROM Theaters t "
                    + "JOIN Shows s ON t.theater_id = s.theater_id "
                    + "JOIN Movies m ON s.movie_id = m.movie_id "
                    + "ORDER BY t.city, theater_name, movie_name, s.show_id";

            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            System.out.println("CITY | THEATER | MOVIE | SHOW | TIME | TIMING | AVAILABLE SEATS");
            System.out.println("----------------------------------------------------------------------");

            while (rs.next()) {
                System.out.println(
                        rs.getString("city") + " | " +
                                rs.getInt("theater_id") + " | " +
                                rs.getString("theater_name") + " | " +
                                rs.getInt("movie_id") + " | " +
                                rs.getString("movie_name") + " | " +
                                rs.getInt("show_id") + " | " +
                                rs.getString("show_time") + " | " +
                                rs.getString("timing") + " | " +
                                rs.getInt("available_seat")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }public void  cancelticket(int bookingId) {
        try {
            Connection con = Databaseconfigure.getconnection();
            con.setAutoCommit(false);

            // 1. Get booking details
            PreparedStatement stm = con.prepareStatement(
                    "SELECT show_id, seat_booked FROM Bookings WHERE booking_id = ?");
            stm.setInt(1, bookingId);
            ResultSet rs = stm.executeQuery();

            if (!rs.next()) {
                System.out.println(" Booking ID not found!");





                return;
            }

            int showId = rs.getInt("show_id");
            String seats = rs.getString("seat_booked");
            List<String> seatList = Arrays.asList(seats.split(","));

            // 2. Free seats
            for (String seat : seatList) {
                PreparedStatement free = con.prepareStatement(
                        "UPDATE Seat SET is_booked = 0 WHERE show_id = ? AND seat_number = ?");
                free.setInt(1, showId);
                free.setString(2, seat.trim());
                free.executeUpdate();
            }

            // 3. Delete booking
            PreparedStatement del = con.prepareStatement(
                    "DELETE FROM Bookings WHERE booking_id = ?");
            del.setInt(1, bookingId);
            del.executeUpdate();

            con.commit();
            System.out.println("✔ Ticket cancelled successfully for seats " + seats);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}