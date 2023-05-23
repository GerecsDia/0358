/*
* File: dolg2.js
* Author: Gerecs Diána
* Copyright: 2023, Gerecs Diána
* Group: Szoft-2-E
* Date: 2023-05-23
* Github: https://github.com/GerecsDia/
* Licenc: GNU GPL
*/


import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    InputPanel asidePanel;
    InputPanel bsidePanel;
    InputPanel csidePanel;
    JPanel buttonPanel;
    JButton calcButton;
    InputPanel volumePanel;
    double aside;
    double bside;
    double cside;

    public MainFrame() {
        this.initComponent();
        this.addComponent();
        this.handleEvent();
        this.setFrame();
    }

    private void initComponent() {
        this.asidePanel = new InputPanel("a oldal");
        this.bsidePanel = new InputPanel("b oldal");
        this.csidePanel = new InputPanel("c oldal");
        this.buttonPanel = new JPanel();
        this.calcButton = new JButton("Számít");
        this.volumePanel = new InputPanel("Térfogat");
    }

    private void addComponent() {
        this.add(this.asidePanel);
        this.add(this.bsidePanel);
        this.add(this.csidePanel);
        this.add(this.buttonPanel);
        this.buttonPanel.add(this.calcButton);
        this.add(this.volumePanel);
    }

    private void handleEvent() {
        this.calcButton.addActionListener(e -> {
            startCalc();
        });
    }

    private void startCalc() {
        String asideStr = this.asidePanel.getValue();
        if (!this.checkInput(asideStr)) {
            JOptionPane.showMessageDialog(this, "Csak szám");
            return;
        }
        String bsideStr = this.bsidePanel.getValue();
        if (!this.checkInput(bsideStr)) {
            JOptionPane.showMessageDialog(this, "Csak szám");
            return;
        }
        String csideStr = this.csidePanel.getValue();
        if (!this.checkInput(csideStr)) {
            JOptionPane.showMessageDialog(this, "Csak szám");
            return;
        }
       
        aside = Double.parseDouble(asideStr);
        bside = Double.parseDouble(bsideStr);
        cside = Double.parseDouble(csideStr);

        double volume = calcVolume(aside, bside, cside);

        volumePanel.setValue("" + volume);
    }

    private double calcVolume(double aside, double bside, double cside) {
        return aside * bside * cside;

    }

    private boolean checkInput(String input) {
        return input.matches("[0-9.]+");
    }

    private void setFrame() {
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}