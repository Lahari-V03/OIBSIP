package cancellation_form;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class cancellation extends JFrame implements ActionListener {
    JLabel l1;
    JButton b1;
    JTextField t1;
    JTextArea a1;
    public cancellation()
    {
        l1=new JLabel();
        l1.setText("PNR Number");
        l1.setBounds(10,40,200,30);

        a1=new JTextArea("Cancellation has been done for PNR: ");
        a1.setBounds(10,70,500,30);

        t1=new JTextField();
        t1.setBounds(150,40,200,30);

        add(l1);
        add(t1);
        add(a1);

        b1=new JButton("submit");
        b1.setBounds(250,120,100,30);
        b1.addActionListener(this);
        add(b1);

        setTitle("Cancellation Page");
        setSize(1000,1000);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String pnr=t1.getText();
        if(pnr.equals("123456789"))
            a1.setText(pnr);
    }

    public static void main(String[] args) {
        new cancellation();
    }
}
