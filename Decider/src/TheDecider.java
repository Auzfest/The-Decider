import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;  


public class TheDecider extends JFrame {

    // all objects that will be on window
    private JTextField textField;
    private JButton addChoiceButton;
    private JButton MakeChoiceButton;
    private JButton clearButton;
    private JTextArea textArea;

    public TheDecider() {
        //create window
        super("Decision Maker");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //creating objects to put on window
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(150, 10));  
        addChoiceButton = new JButton("Add Choice");
        MakeChoiceButton = new JButton("Make A Choice");
        clearButton = new JButton("Restart");
        textArea = new JTextArea();


        // add objects to window
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(200, 150));
        panel.add(textField);
        panel.add(Box.createHorizontalStrut(175));
        panel.add(addChoiceButton);
        panel.add(MakeChoiceButton);
        panel.add(clearButton);
        add(panel, BorderLayout.NORTH);
        add(textArea, BorderLayout.CENTER);

        java.util.List<String> choice_list = new java.util.ArrayList<String>();

        // when add choice is pushed
        addChoiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String new_choice = textField.getText();
                    choice_list.add(new_choice);
                    textArea.append(new_choice + "\n");
                    textField.setText("");
            }
        });

        // when done is pushed
        MakeChoiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String random = choice_list.get(new Random().nextInt(choice_list.size()));
                textArea.append("\n The choice made is: " + random  + "\n");
                textField.setText("");    
            }
        });

        // when clear is pushed
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                choice_list.clear();
            }
        });
    }

    //main function, starts program
    public static void main(String[] args) {
        TheDecider app = new TheDecider();
        app.setVisible(true);
    }
}
