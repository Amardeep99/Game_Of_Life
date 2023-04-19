import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View {
    private Controller controller;

    private JFrame frame;

    private JPanel menyPanel;
    private JLabel antallLevende;
    private JButton startKnapp;
    private JButton avsluttKnapp;
    
    private JPanel buttonPanel;

    View(Controller controller){
        this.controller = controller;
        frame = new JFrame();

        
        menyPanel = new JPanel();
        antallLevende = new JLabel("Antall levende: 34 ");
        startKnapp = new JButton("Start");
        avsluttKnapp = new JButton("Avslutt");
        menyPanel.add(antallLevende); menyPanel.add(startKnapp); menyPanel.add(avsluttKnapp);
        

       
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(8, 12));

        for(int i = 1; i <= 12*8; i++){
            buttonPanel.add(new Button("*"));
        }

        frame.add(menyPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    class StartKnapp implements ActionListener{
        public void actionPerformed(ActionEvent e){
            
        }
    }
}
