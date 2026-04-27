package dao;

import db.DBConnection;
import model.Listing;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListingDAO {

    public void addListing(String title, String location, double price) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO listings(title, location, price) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, title);
            ps.setString(2, location);
            ps.setDouble(3, price);

            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Listing> getAllListings() {
        List<Listing> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM listings");

            while (rs.next()) {
                list.add(new Listing(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("location"),
                        rs.getDouble("price")
                ));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateListing(int id, String title, String location, double price) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "UPDATE listings SET title=?, location=?, price=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, title);
            ps.setString(2, location);
            ps.setDouble(3, price);
            ps.setInt(4, id);

            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteListing(int id) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "DELETE FROM listings WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}