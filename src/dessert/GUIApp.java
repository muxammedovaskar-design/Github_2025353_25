/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dessert;

/**
 * This class creates a GUI for managing desserts in a fridge
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GUIApp extends JFrame {
// Queue to store desserts
    private Dessertqueue fridge = new Dessertqueue();
// Input components
    private JComboBox<String> dessertBox;
    private JTextField weightField;
    private JTextField daysField;
    private JTextArea outputArea;

    public GUIApp() {
        setTitle("Dessert Fridge Management");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Inputs
        dessertBox = new JComboBox<>(new String[]{
                "Cheesecake", "Brownie", "Tiramisu", "Muffin", "Donut"
        });

        weightField = new JTextField(10);
        daysField = new JTextField(10);

        // Buttons
        JButton addBtn = new JButton("Add Dessert");
        JButton removeBtn = new JButton("Remove Dessert");
        JButton peekBtn = new JButton("Peek Next");
        JButton displayBtn = new JButton("Display All");
        JButton exitBtn = new JButton("Exit");

        // Output
        outputArea = new JTextArea(15, 40);
        outputArea.setEditable(false);

        // Add components
        add(new JLabel("Dessert:"));
        add(dessertBox);

        add(new JLabel("Weight (g):"));
        add(weightField);

        add(new JLabel("Best Before (days):"));
        add(daysField);

        add(addBtn);
        add(removeBtn);
        add(peekBtn);
        add(displayBtn);
        add(exitBtn);

        add(new JScrollPane(outputArea));

        // Button Actions

        addBtn.addActionListener((ActionEvent e) -> {
            try {
                String name = (String) dessertBox.getSelectedItem();
                int weight = Integer.parseInt(weightField.getText());
                int days = Integer.parseInt(daysField.getText());

                if (days > 14) {
                    outputArea.setText("Max 14 days allowed!");
                    return;
                }

                String bestBefore = days + " days";

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                String timeAdded = LocalDateTime.now().format(dtf);

                Dessert dessert = new Dessert(name, weight, bestBefore, timeAdded);

                if (!fridge.addDessert(dessert)) {
                    outputArea.setText("Fridge is FULL!");
                } else {
                    outputArea.setText("Dessert added successfully!");
                }

            } catch (Exception ex) {
                outputArea.setText("Invalid input!");
            }
        });

        removeBtn.addActionListener(e -> {
            Dessert d = fridge.removeDessert();
            if (d == null) {
                outputArea.setText("Fridge is empty!");
            } else {
                outputArea.setText("Removed:\n" + d);
            }
        });

        peekBtn.addActionListener(e -> {
            Dessert d = fridge.peekDessert();
            if (d == null) {
                outputArea.setText("Fridge is empty!");
            } else {
                outputArea.setText("Next Dessert:\n" + d);
            }
        });

        displayBtn.addActionListener(e -> {
            outputArea.setText(fridge.displayDessert());
        });

        exitBtn.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        new GUIApp().setVisible(true);
    }
}
