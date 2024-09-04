package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    public Home() {
        setTitle("AirJourney - Begin Your Journey");
        
        // Setting layout and background color
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        getContentPane().setBackground(Color.WHITE); // Setting background to white
        
        // Heading label
        JLabel heading = new JLabel("AirJourney - Begin Your Journey");
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 48)); // Increased font size and bold style
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span the heading across two columns
        gbc.insets = new Insets(20, 20, 40, 20); // More space around the heading
        gbc.anchor = GridBagConstraints.CENTER;
        add(heading, gbc);

        // Create buttons for each option
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 20, 10, 20); // Set padding for buttons
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton flightDetailsButton = new JButton("Flight Details");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(flightDetailsButton, gbc);
        flightDetailsButton.addActionListener(this);

        JButton customerDetailsButton = new JButton("Add Customer Details");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(customerDetailsButton, gbc);
        customerDetailsButton.addActionListener(this);

        JButton bookFlightButton = new JButton("Book Flight");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(bookFlightButton, gbc);
        bookFlightButton.addActionListener(this);

        JButton journeyDetailsButton = new JButton("Journey Details");
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(journeyDetailsButton, gbc);
        journeyDetailsButton.addActionListener(this);

        JButton cancelTicketButton = new JButton("Cancel Ticket");
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(cancelTicketButton, gbc);
        cancelTicketButton.addActionListener(this);

        JButton boardingPassButton = new JButton("Boarding Pass");
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(boardingPassButton, gbc);
        boardingPassButton.addActionListener(this);
        
        // Add the image to the right
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        gbc.gridx = 1; // Positioning the image on the right side
        gbc.gridy = 1;
        gbc.gridheight = 6; // Span the image over the same number of rows as the buttons
        gbc.insets = new Insets(0, 20, 0, 20);
        gbc.anchor = GridBagConstraints.CENTER;
        add(lblimage, gbc);

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
        } else if (text.equals("Boarding Pass")) {
            new BoardingPass();
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}
