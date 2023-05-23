import java.lang.invoke.VolatileCallSite;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class MainFrame extends JFrame{
    InputPanel asidePanel;
    InputPanel bsidePanel;
    InputPanel csidePanel;
    JPanel buttonPanel;
    JButton calcButton;
    

    public MainFrame() {
        this.initComponent();
        this.addComponent();
        this.handleEvent();
        this.setFrame();

    }
    private void initComponent() {
        this.asidePanel = new InputPanel("a");
        this.bsidePanel = new InputPanel("b");
        this.csidePanel = new InputPanel("c");
        this.buttonPanel = new JPanel();
        //this.areaPanel = new InputPanel("TERÜLET");
        this.calcButton = new JButton("Számít");


    }

    private void addComponent() {
        this.add(this.asidePanel);
        this.add(this.bsidePanel);
        this.add(this.csidePanel);        
        this.add(this.buttonPanel);
        //this.add(this.areaPanel);
        this.buttonPanel.add(this.calcButton);
    }
    
    private void handleEvent() {
        this.calcButton.addActionListener(e -> {
            startCalc();
        });

    }
    private void startCalc() {
        String tomegStr = this.tomegPanel.getValue();
        if(!this.checkInput(tomegStr)) {
            JOptionPane.showMessageDialog(this, "Csak számjegy");
            return;
        }
        double tomeg = Double.parseDouble(tomegStr);
        String magassagStr = this.magassagPanel.getValue();
        if(!this.checkInput(magassagStr)) {
            JOptionPane.showMessageDialog(this, "Csak számjegy");
            return;
        }
        double magassag = Double.parseDouble(magassagStr);
        Double testtomegIndex = this.calcBodyIndex(tomeg, magassag);
        this.indexPanel.setValue(testtomegIndex.toString());

    }

    public double calcBodyIndex(double weight, double height) {
        return weight / Math.pow(height, 2);
    }

    public boolean checkInput(String input) {
        boolean ok = false;
        if(input.matches("[0-9.]+")) {
            ok = true;
        }
        return ok;

    }
    
    private void setFrame() {    
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setSize(400, 300);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
    }
    
}
