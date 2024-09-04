package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener {

    JTextField tfname, tfphone, tfaadhar, tfnationality, tfaddress;
    JRadioButton rbmale, rbfemale;

    public AddCustomer() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(280, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);

        // First column
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 80, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(220, 80, 150, 25);
        add(tfname);

        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 130, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);

        tfnationality = new JTextField();
        tfnationality.setBounds(220, 130, 150, 25);
        add(tfnationality);

        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(60, 180, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(220, 180, 150, 25);
        add(tfaadhar);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60, 230, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(220, 230, 150, 25);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(60, 280, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(220, 280, 150, 25);
        add(tfphone);

        // Second column
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(420, 80, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);

        ButtonGroup gendergroup = new ButtonGroup();

        rbmale = new JRadioButton("Male");
        rbmale.setBounds(580, 80, 70, 25);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(660, 80, 70, 25);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);

        // Save button
        JButton save = new JButton("SAVE");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(220, 350, 150, 30);
        save.addActionListener(this);
        add(save);

        // Adjusted image size and position
        ImageIcon image = new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/logo.png"))
                .getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT));
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(450, 130, 300, 250);
        add(lblimage);

        setSize(800, 500);
        setLocation(300, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String phone = tfphone.getText();
        String address = tfaddress.getText();
        String aadhar = tfaadhar.getText();
        String gender = null;
        if (rbmale.isSelected()) {
            gender = "Male";
        } else {
            gender = "Female";
        }

        try {
            Conn conn = new Conn();

            String query = "insert into passenger values('" + name + "', '" + nationality + "', '" + phone + "', '" + address + "', '" + aadhar + "', '" + gender + "')";

            conn.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");

            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AddCustomer();
    }
}
