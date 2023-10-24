
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Admin extends JFrame implements Assign, ActionListener {
    
    private JTextField inUserid;
    private JPasswordField inPwd;
    private JCheckBox shpass;
    private JButton login;
    private JButton set;
    
    public Admin(){
        init();
        
        //let the frame appear in the center of the screen
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2-getWidth()/2, size.height/2-getHeight()/2);
    }
    
    public void init() {

        Font f1=new Font("Bodoni MT Black", 0, 48);
        Font f2=new Font("Minion Pro SmBd", 0, 24);
        Font f3=new Font("Minion Pro Cond", 0, 30);
        Font f4=new Font("UD Digi Kyokasho NK-B", 0, 18);
        Font f5=new Font("UD Digi Kyokasho NK-B", 0, 10);
        
        Color c1=new Color(255, 255, 255);
        Color c2=new Color(0, 0, 153);
        Color c3=new Color(250, 250, 194);

        JPanel jPanel1= new JPanel();
        jPanel1.setLayout(null);

        JLabel title = new JLabel("User Access");
        add(title);
        title.setFont(f1);
        title.setForeground(c1);
        title.setBounds(350, 70, 350, 60);

        login = new JButton("login");
        add(login);
        login.setFont(f2);
        login.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.setBorder(BorderFactory.createEtchedBorder());
        login.setBounds(640, 420, 100, 40);
        login.addActionListener(this);

        set = new JButton("reset");
        add(set);
        set.setFont(f2);
        set.setCursor(new Cursor(Cursor.HAND_CURSOR));
        set.setBorder(BorderFactory.createEtchedBorder());
        set.setBounds(450, 420, 100, 40);
        set.addActionListener(this);
        
        JButton cancel = new JButton("cancel");
        add(cancel);
        cancel.setFont(f2);
        cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cancel.setBounds(260, 420, 100, 40);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close();
                Welcome wel = new Welcome();
                wel.setVisible(true);
            }
        });
        
        JLabel userid = new JLabel("User ID        :");
        add(userid);
        userid.setFont(f3);
        userid.setForeground(c2);
        userid.setBounds(290, 190, 160, 50);

        JLabel pwd = new JLabel("Password    : ");
        add(pwd);
        pwd.setFont(f3);
        pwd.setForeground(c2);
        pwd.setBounds(290, 310, 170, 40);
        
        shpass = new JCheckBox("View Password");
        add(shpass);
        shpass.setFont(f5);
        shpass.setBounds(470, 360, 110, 30);
        shpass.addActionListener(this);

        inUserid = new JTextField();
        add(inUserid);
        inUserid.setFont(f4);
        inUserid.setBackground(c3);
        inUserid.setBorder(BorderFactory.createEtchedBorder());
        inUserid.setBounds(470, 180, 220, 50);

        inPwd = new JPasswordField();
        add(inPwd);
        inPwd.setBackground(c3);
        inPwd.setBorder(BorderFactory.createEtchedBorder());
        inPwd.setBounds(470, 300, 220, 50);

        JLabel backg = new JLabel();
        add(backg);
        backg.setIcon(new ImageIcon(getClass().getResource("/Images/car.jpg")));
        backg.setBounds(10, 0, 1030, 690);

        pack();
    }
    
    @Override
    public void close() {
        WindowEvent window = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(window);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String user=inUserid.getText();
        String pwd=inPwd.getText();
    
    if(e.getSource()==login)
    {
        if(user.equals("admin") && pwd.equals("123456")){
            JOptionPane.showMessageDialog(null, "Welcome, you are successfully logged in");
            close();
            Menu m=new Menu();
            m.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "Invalid user id or password");
        }
    }
    
    if(e.getSource()==set)
    {
        inUserid.setText("");
        inPwd.setText("");
    }
    
    if(e.getSource()==shpass)
    {
        if(shpass.isSelected())
        {
            inPwd.setEchoChar((char)0);
        }
        else
        {
            inPwd.setEchoChar('*');
        }
    }
    
    }
    
    public static void main(String args[]) {
        Admin frame = new Admin();
        frame.setVisible(true);
        frame.setBounds(130, 5, 1024, 683); //set frame size
        frame.setResizable(false); //unable to resize the frame
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}

