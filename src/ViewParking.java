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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class ViewParking extends JFrame implements Assign{
    
    private JTable Slot;
    private JScrollPane viewslot;
    
    static String[] content = new String[90];
    
    static int k=0;
    
    public ViewParking() {
        init();
        
         if(k==0)
         {
             for(int i=0; i<90; i++){
                 content[i]=i+1+"";
                 k++;
             }
        }
        showParking();
        
        //let the frame appear in the center of the screen
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2-getWidth()/2, size.height/2-getHeight()/2);
    }
    
    public void showParking()
    {
        DefaultTableModel table = (DefaultTableModel)Slot.getModel();
        for(int i=0; i<90; i++)
        {
            table.addRow(new Object[]{content[i],content[i+1],content[i+2],content[i+3],content[i+4],content[i+5]});
            i=i+5;
        }
    }
    
     public static void addVec(int x)
     {
        content[x-1]="Not Available";
     }
    
     public static void rmVec(int x)
     {
         content[x-1]= x+"";
     }
     
    public void init() {

        Font f1 = new Font("Minion Pro SmBd", 0, 18);
        Font f2 = new Font("Bodoni MT Black", 0, 40);
        Font f3 = new Font("Minion Pro", 0, 14);
        
        Color c1 = new Color(255, 255, 255);
        Color c2 = new Color(0, 0, 153);
        
        viewslot = new JScrollPane();
        Slot = new JTable();

        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(null);

        JButton Return = new JButton("Return");
        add(Return);
        Return.setFont(f1); 
        Return.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Return.setBorder(BorderFactory.createEtchedBorder());
        Return.setBounds(630, 440, 100, 40);
        Return.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close();
                Menu m=new Menu();
                m.setVisible(true);
            }
        });

        JButton addVehicle = new JButton("Add Vehicle");
        add(addVehicle);
        addVehicle.setFont(f1); 
        addVehicle.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addVehicle.setBorder(BorderFactory.createEtchedBorder());
        addVehicle.setBounds(810, 440, 120, 40);
        addVehicle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close();
                AssignParking assign=new AssignParking();
                assign.setVisible(true);
            }
        });

        JLabel ParkingSlot = new JLabel("PARKING SLOT");
        add(ParkingSlot);
        ParkingSlot.setFont(f2);
        ParkingSlot.setForeground(c1);
        ParkingSlot.setBounds(340, 15, 480, 100);

        Slot.setFont(f3); 
        Slot.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "A", "B", "C", "D", "E", "F"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Slot.setAlignmentX(1.0F);
        Slot.setAlignmentY(1.0F);
        Slot.setAutoscrolls(false);
        Slot.setIntercellSpacing(new java.awt.Dimension(1, 2));
        Slot.setRowHeight(20);
        viewslot.setViewportView(Slot);

        JTableHeader tableH=Slot.getTableHeader();
        tableH.setFont(f1); 
        tableH.setForeground(c2);
        
        add(viewslot);
        viewslot.setBounds(100, 120, 840, 270);

        JLabel backg = new JLabel();
        add(backg);
        backg.setIcon(new ImageIcon(getClass().getResource("/Images/car.jpg")));
        backg.setBounds(0, 0, 1030, 690);

        pack();
    }                      
    
    @Override
    public void close(){ 
        WindowEvent window=new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(window);       
    }
    
    public static void main(String args[]) {
        ViewParking frame = new ViewParking();
        frame.setVisible(true);
        frame.setBounds(130, 5, 1024, 683); //set frame size
        frame.setResizable(false); //unable to resize the frame
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }                 
}