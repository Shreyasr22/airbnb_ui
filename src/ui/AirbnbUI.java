package ui;

import dao.ListingDAO;
import model.Listing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class AirbnbUI extends JFrame {

    JTextField titleField, locationField, priceField, idField;
    JTable table;
    DefaultTableModel model;
    ListingDAO dao = new ListingDAO();

    public AirbnbUI() {
        setTitle("Airbnb CRUD App");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // 🔹 MAIN PANEL (VERTICAL STACK)
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // 🔹 FORM PANEL
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        formPanel.add(new JLabel("ID (for update/delete):"));
        idField = new JTextField();
        formPanel.add(idField);

        formPanel.add(new JLabel("Title:"));
        titleField = new JTextField();
        formPanel.add(titleField);

        formPanel.add(new JLabel("Location:"));
        locationField = new JTextField();
        formPanel.add(locationField);

        formPanel.add(new JLabel("Price:"));
        priceField = new JTextField();
        formPanel.add(priceField);

        // 🔹 BUTTON PANEL
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));

        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");
        JButton viewBtn = new JButton("View");

        buttonPanel.add(addBtn);
        buttonPanel.add(updateBtn);
        buttonPanel.add(deleteBtn);
        buttonPanel.add(viewBtn);

        // 🔹 TABLE
        model = new DefaultTableModel(new String[]{"ID", "Title", "Location", "Price"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // 🔹 ADD TO MAIN PANEL
        mainPanel.add(formPanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(scrollPane);

        add(mainPanel);

        // 🔹 BUTTON ACTIONS
        addBtn.addActionListener(e -> {
            dao.addListing(
                    titleField.getText(),
                    locationField.getText(),
                    Double.parseDouble(priceField.getText())
            );
            JOptionPane.showMessageDialog(this, "Added!");
            loadTable();
        });

        updateBtn.addActionListener(e -> {
            dao.updateListing(
                    Integer.parseInt(idField.getText()),
                    titleField.getText(),
                    locationField.getText(),
                    Double.parseDouble(priceField.getText())
            );
            JOptionPane.showMessageDialog(this, "Updated!");
            loadTable();
        });

        deleteBtn.addActionListener(e -> {
            dao.deleteListing(Integer.parseInt(idField.getText()));
            JOptionPane.showMessageDialog(this, "Deleted!");
            loadTable();
        });

        viewBtn.addActionListener(e -> loadTable());
    }

    private void loadTable() {
        model.setRowCount(0);
        List<Listing> list = dao.getAllListings();

        for (Listing l : list) {
            model.addRow(new Object[]{
                    l.getId(),
                    l.getTitle(),
                    l.getLocation(),
                    l.getPrice()
            });
        }
    }
}