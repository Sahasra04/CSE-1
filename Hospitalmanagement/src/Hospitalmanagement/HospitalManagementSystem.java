package Hospitalmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class Patient {
    private String name;
    private String id;
    private String condition;

    public Patient(String name, String id, String condition) {
        this.name = name;
        this.id = id;
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "Patient ID: " + id + "\nName: " + name + "\nCondition: " + condition + "\n";
    }
}

public class HospitalManagementSystem extends JFrame {

    private List<Patient> patients = new ArrayList<>();

    private JTextArea outputTextArea;

    public HospitalManagementSystem() {
        setTitle("Hospital Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Hospital Management System");
        titleLabel.setBounds(80, 10, 250, 25);
        panel.add(titleLabel);

        JButton addPatientButton = new JButton("Add Patient");
        addPatientButton.setBounds(20, 40, 150, 25);
        panel.add(addPatientButton);

        JButton viewPatientsButton = new JButton("View Patients");
        viewPatientsButton.setBounds(200, 40, 150, 25);
        panel.add(viewPatientsButton);

        outputTextArea = new JTextArea();
        outputTextArea.setBounds(20, 80, 330, 150);
        outputTextArea.setEditable(false);
        panel.add(outputTextArea);

        addPatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPatient();
            }
        });

        viewPatientsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewPatients();
            }
        });
    }

    private void addPatient() {
        String name = JOptionPane.showInputDialog("Enter patient name:");
        String id = JOptionPane.showInputDialog("Enter patient ID:");
        String condition = JOptionPane.showInputDialog("Enter patient condition:");

        if (name != null && id != null && condition != null) {
            Patient patient = new Patient(name, id, condition);
            patients.add(patient);

            JOptionPane.showMessageDialog(this, "Patient added successfully!");
        }
    }

    private void viewPatients() {
        if (patients.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No patients to display.");
        } else {
            StringBuilder output = new StringBuilder("Patient List:\n");
            for (Patient patient : patients) {
                output.append(patient.toString()).append("\n");
            }
            outputTextArea.setText(output.toString());
        }
    }

    public static void main(String[] args) {
        new HospitalManagementSystem();
    }
}