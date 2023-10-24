
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Welcome extends JFrame implements Assign, ActionListener{
    
    public Welcome(){
        init();
        
        //let the frame appear in the center of the screen
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2-getWidth()/2, size.height/2-getHeight()/2);
    }
    
    public void init(){
        
        Font f1 = new Font("Lithos Pro Regular", 1, 18);
        Font f2 = new Font("Lithos Pro Regular", 1, 30);
        Font f3 = new Font("Minion Pro SmBd", 0, 18);
        Font f4 = new Font("Berlin Sans FB", 0, 14);
        
        Color c1 = new Color(0, 0, 102);   
        
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        
        JLabel title1 = new JLabel("Welcome  To");
        add(title1);
        title1.setFont(f1);
        title1.setForeground(c1);
        title1.setBounds(70, 10, 330, 50);
        
        JLabel title2 = new JLabel("Vehicle Parking System");
        add(title2);
        title2.setFont(f2);
        title2.setForeground(c1);
        title2.setBounds(10, 30, 510, 80);
        
        JLabel title3 = new JLabel("Give it a try now and you will be amazed by it!");
        add(title3);
        title3.setFont(f4);
        title3.setForeground(c1);
        title3.setBounds(40, 80, 350, 50);
        
        JButton logout = new JButton("log out");
        add(logout);
        logout.setFont(f3);
        logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logout.setBorder(BorderFactory.createEtchedBorder());
        logout.setBounds(10, 210, 80, 35);
        logout.addActionListener(this);
        
        JButton proceed = new JButton("proceed");
        add(proceed);
        proceed.setFont(f3);
        proceed.setCursor(new Cursor(Cursor.HAND_CURSOR));
        proceed.setBorder(BorderFactory.createEtchedBorder());
        proceed.setBounds(450, 210, 80, 35);
        proceed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                close();
                Admin admin=new Admin();
                admin.setVisible(true);
            }
        });
        
        JLabel background1 = new JLabel();
        add(background1);
        background1.setIcon(new ImageIcon(getClass().getResource("/Images/background.jpg")));
        background1.setBounds(0, 0, 560, 260);
        
        pack();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame=new JFrame("Exit");
        if(JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Exit",
                JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
        {
            System.exit(0);
        }
    }
    
    //close previous window when another window come out
    @Override
    public void close(){ 
        WindowEvent window=new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(window);       
    }
    
    public static void main(String args[]) {
        Welcome frame = new Welcome();
        frame.setVisible(true);
        frame.setBounds(380, 180, 555, 290); //set frame size
        frame.setResizable(false); //unable to resize the frame
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}

