package login_form;
import reservation_system.reserve;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.event.*;
public class login extends JFrame implements ActionListener {
    JLabel l1,l2,l3;
    JButton b1;
    JTextField t1,t2;
    login()
    {
        l1=new JLabel();
        l1.setText("Login ID");
        l1.setBounds(10,40,200,30);

        l2=new JLabel();
        l2.setText("Password");
        l2.setBounds(10,70,200,30);

        l3=new JLabel();
        l3.setBounds(150,120,100,30);

        t1=new JTextField();
        t1.setBounds(150,40,200,30);

        t2=new JTextField();
        t2.setBounds(150,70,200,30);

        b1=new JButton("Submit");
        b1.setBounds(250,120,100,30);

        add(l1);add(l2);add(l3);
        add(t1);add(t2);
        add(b1);
        b1.addActionListener(this);

        setTitle("Login Page");
        setSize(1000,1000);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String userId=t1.getText();
        String passId=t2.getText();
        if(userId.equals("Lahari")&&passId.equals("6899"))
        {
            l3.setText("Hello admin");
            reserve r=new reserve();
            this.dispose();
            r.setVisible(true);
        }
        else
        {
            l3.setText("Invalid details");
        }
    }
    public static void main(String... args){
        new login();
    }
}