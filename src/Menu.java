
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

public class Menu extends JFrame implements Assign, ActionListener {
    
    public Menu() {
        init();
        
        //let the frame appear in the center of the screen
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2-getWidth()/2, size.height/2-getHeight()/2);
    }
                       
    public void init() {

        Font f1=new Font("Bodoni MT Black", 0, 48);
        Font f2=new Font("Minion Pro SmBd", 0, 24);
        Font f3=new Font("Minion Pro Cond", 0, 24);
        
        Color c1=new Color(255, 255, 255);
        Color c2=new Color(0, 0, 153);
        
        JPanel jPanel1= new JPanel();
        jPanel1.setLayout(null);

        JLabel title = new JLabel("MENU");
        add(title);
        title.setFont(f1);
        title.setForeground(c1);
        title.setBounds(420, 50, 180, 60);

        JButton logout = new JButton("log out");
        add(logout);
        logout.setFont(f2);
        logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logout.setBorder(BorderFactory.createEtchedBorder());
        logout.setBounds(720, 490, 100, 40);
        logout.addActionListener(this);
        
        JButton view = new JButton("View Parking Slot");
        add(view);
        view.setFont(f3);
        view.setForeground(c2);
        view.setCursor(new Cursor(Cursor.HAND_CURSOR));
        view.setBorder(BorderFactory.createEtchedBorder());
        view.setBounds(330, 140, 330, 50);
        
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close();
                ViewParking view = new ViewParking();
                view.setVisible(true);
            }
        });

        JButton assign = new JButton("Assign Parking");
        add(assign);
        assign.setFont(f3);
        assign.setForeground(c2);
        assign.setCursor(new Cursor(Cursor.HAND_CURSOR));
        assign.setBorder(BorderFactory.createEtchedBorder());
        assign.setBounds(330, 240, 330, 50);
        
        assign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close();
                AssignParking assign = new AssignParking();
                assign.setVisible(true);
            }
        });

        JButton clear = new JButton("Clear Parking");
        add(clear);
        clear.setFont(f3);
        clear.setForeground(c2);
        clear.setCursor(new Cursor(Cursor.HAND_CURSOR));
        clear.setBorder(BorderFactory.createEtchedBorder());
        clear.setBounds(330, 340, 330, 50);

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close();
                ClearParking clear = new ClearParking();
                clear.setVisible(true);
            }
        });
        
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
        JFrame frame=new JFrame("Exit");
        if(JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Exit",
                JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
        {
            System.exit(0);
        }
    }
    
    public static void main(String args[]) {
        Menu frame = new Menu();
        frame.setVisible(true);
        frame.setBounds(130, 5, 1024, 683); //set frame size
        frame.setResizable(false); //unable to resize the frame
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }       

}
