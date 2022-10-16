package reservation_system;
import cancellation_form.cancellation;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.event.*;
public class reserve extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JRadioButton rb1,rb2;
    JComboBox c1;
    JComboBox c2;
    JComboBox c3;
    JButton b1,b2;
    JTextArea a1;
    public reserve(){
        l1=new JLabel();
        l1.setText("Name");
        l1.setBounds(10,40,200,30);

        l2=new JLabel();
        l2.setText("Gender");
        l2.setBounds(10,70,200,30);

        l3=new JLabel();
        l3.setText("Age");
        l3.setBounds(10,100,200,30);

        l4=new JLabel();
        l4.setText("Train Number");
        l4.setBounds(10,130,200,30);

        l5=new JLabel();
        l5.setText("Train Name");
        l5.setBounds(10,160,200,30);

        l6=new JLabel();
        l6.setText("Date of journey");
        l6.setBounds(10,190,200,30);

        l7=new JLabel();
        l7.setText("From");
        l7.setBounds(10,250,200,30);

        l8=new JLabel();
        l8.setText("Departure");
        l8.setBounds(10,280,200,30);

        l9=new JLabel();
        l9.setText("Class");
        l9.setBounds(10,310,200,30);

        l10=new JLabel();
        l10.setText("Filled details");
        l10.setBounds(350,430,200,20);

        t1=new JTextField();
        t1.setBounds(250,40,200,30);

        rb1=new JRadioButton("Male");
        rb1.setBounds(250,70,100,30);
        rb2=new JRadioButton("Female");
        rb2.setBounds(410,70,100,30);
        ButtonGroup bg1=new ButtonGroup();
        bg1.add(rb1);
        bg1.add(rb2);

        t2=new JTextField();
        t2.setBounds(250,100,200,30);

        t3=new JTextField();
        t3.setBounds(250,130,200,30);

        t4=new JTextField();
        t4.setBounds(250,160,200,30);

        String[] day= new String[32];
        for(int i=1;i<32;i++){
            day[i]= String.valueOf(i);
        }
        c1= new JComboBox<>(day);
        c1.setBounds(250,190,200,30);
        String[] Month= {"January","February","March","April","May","June","July","August","September","October","November","December"};
        c2 = new JComboBox<>(Month);
        c2.setBounds(470,190,200,30);
        String[] year = new String[2];
        for(int i=0;i<2;i++){
            year[i]=String.valueOf(i+2022);
        }
        c3 = new JComboBox<>(year);
        c3.setBounds(690,190,200,30);

         t5= new JTextField();
         t5.setBounds(250,250,300,30);

         t6=new JTextField();
         t6.setBounds(250,280,300,30);

         t7=new JTextField();
         t7.setBounds(250,310,200,30);

         b1=new JButton("Insert");
         b1.setBounds(250,340,150,30);
         b1.addActionListener(this);

         b2=new JButton("Cancellation");
         b2.setBounds(250,370,150,30);
         b2.addActionListener(this);

         a1=new JTextArea();
         a1.setBounds(350,450,400,200);
         add(a1);

        add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);add(l7);add(l8);add(l9);add(l10);
        add(t1);add(t2);add(t3);add(t4);add(t5);add(t6);add(t7);
        add(rb1);add(rb2);
        add(c1);add(c2);add(c3);
        add(b1);add(b2);

        setTitle("Reservation Page");
        setSize(1000,1000);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String trainNo=t3.getText();
        if(trainNo.equals("1234"))
        {
            t4.setText("Venkatadri Express");
        }
        if(e.getSource()==b1)
        {
            String res="";
            res+="Name: "+t1.getText()+"\n";
            if(rb1.isSelected())
            {
                res+="Gender: "+rb1.getText()+"\n";
            }
            if(rb2.isSelected()){
                res+="Gender: "+rb2.getText()+"\n";
            }
            res+="Age: "+t2.getText()+"\n";
            res+="Train Number: "+t3.getText()+"\n";
            res+="Train Name: "+t4.getText()+"\n";
            res+="Date of Journey: "+c1.getSelectedItem()+"/"+c2.getSelectedItem()+"/"+c3.getSelectedItem()+"\n";
            res+="From: "+t5.getText()+"\n";
            res+="To: "+t6.getText()+"\n";
            res+="Class: "+t7.getText()+"\n";

            a1.setText(res);
        }
        if(e.getSource()==b2){
            cancellation c=new cancellation();
            this.dispose();
            c.setVisible(true);
        }
    }
    public static void main(String[] args) {
        new reserve();
    }
}
