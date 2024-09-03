package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{

    public Home() {
        setTitle("AirJourney - Begin Your Journey");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Heading label
        JLabel heading = new JLabel("AirJourney - Begin Your Journey");
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 48)); // Increased font size and bold style
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span the heading across two columns
        gbc.insets = new Insets(20, 0, 40, 0); // More space below the heading
        gbc.anchor = GridBagConstraints.CENTER;
        add(heading, gbc);
        
        // Create buttons for each option
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton flightDetailsButton = new JButton("Flight Details");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(flightDetailsButton, gbc);
        flightDetailsButton.addActionListener(this);
        
        JButton customerDetailsButton = new JButton("Add Customer Details");
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(customerDetailsButton, gbc);
        customerDetailsButton.addActionListener(this);
        
        JButton bookFlightButton = new JButton("Book Flight");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(bookFlightButton, gbc);
        bookFlightButton.addActionListener(this);
        
        JButton journeyDetailsButton = new JButton("Journey Details");
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(journeyDetailsButton, gbc);
        journeyDetailsButton.addActionListener(this);
        
        JButton cancelTicketButton = new JButton("Cancel Ticket");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(cancelTicketButton, gbc);
        cancelTicketButton.addActionListener(this);
        
        JButton boardingPassButton = new JButton("Boarding Pass");
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(boardingPassButton, gbc);
        boardingPassButton.addActionListener(this);
        
        // Setting JFrame properties
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String text = ae.getActionCommand();
        
        if (text.equals("Add Customer Details")) {
            new AddCustomer();
        } else if (text.equals("Flight Details")) {
            new FlightInfo();
        } else if (text.equals("Book Flight")) {
            new BookFlight();
        } else if (text.equals("Journey Details")) {
            new JourneyDetails();
        } else if (text.equals("Cancel Ticket")) {
            new Cancel();
        } else if(text.equals("Boarding Pass")) {
            new BoardingPass();
        }
    }
    
    public static void main(String[] args) {
        new Home();
    }
}
