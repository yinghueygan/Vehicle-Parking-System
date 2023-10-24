
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

public class ClearParking extends JFrame implements Assign, ActionListener {
    
    private ClearParking frame;
    private JTextField entrydate;
    private JTextField entrytime;
    private JTextField exittime;
    private JTextField parkingfee;
    private JTextField parkingslot;
    private JTextField platenumber;
    private JTable ViewParkingSlot;
    private JScrollPane jScrollPane1;
    private JDialog dialog;
    
    ImageIcon icon[] = {new ImageIcon(getClass().getResource("/Images/alert.png"))};
    
      public ClearParking() {
        init();
        
        //let the frame appear in the center of the screen
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2-getWidth()/2, size.height/2-getHeight()/2);
    }
      
    public void init() {

        entrydate = new JTextField();
        entrydate = new JTextField();
        exittime = new JTextField();
        platenumber = new JTextField();
        entrytime = new JTextField();
        parkingslot = new JTextField();
        parkingfee = new JTextField();
        
        jScrollPane1 = new JScrollPane();
        ViewParkingSlot = new JTable();

        Font f1 = new Font("Bodoni MT Black", 0, 48);
        Font f2 = new Font("Minion Pro", 0, 14);
        Font f3 = new Font("Minion Pro SmBd", 0, 15);
        Font f4 = new Font("Bodoni MT Black", 0, 24);
        Font f5 = new Font("UD Digi Kyokasho NK-B", 0, 18);
        
        Color c1 = new Color(255, 255, 255);
        Color c2 = new Color(0, 0, 153);
        Color c3 = new Color(250, 250, 194);

        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(null);

        JLabel title = new JLabel("PARKING FEE PAYMENT");
        add(title);
        title.setFont(f1); 
        title.setForeground(c1);
        title.setBounds(180, 40, 690, 70);

        
        JLabel PlateNumber = new JLabel("Plate Number:");
        add(PlateNumber);
        PlateNumber.setFont(f4);
        PlateNumber.setForeground(c2);
        PlateNumber.setBounds(300, 330, 190, 50);

        JLabel EntryDate = new JLabel("Entry Date:");
        add(EntryDate);
        EntryDate.setFont(f4);
        EntryDate.setForeground(c2);
        EntryDate.setBounds(540, 330, 170, 50);

        JLabel EntryTime = new JLabel("Entry Time:");
        add(EntryTime);
        EntryTime.setFont(f4);
        EntryTime.setForeground(c2);
        EntryTime.setBounds(780, 330, 170, 50);
        
        JLabel ExitTime = new JLabel("Exit Time:");
        add(ExitTime);
        ExitTime.setFont(f4);
        ExitTime.setForeground(c2);
        ExitTime.setBounds(540, 450, 170, 50);

        JLabel ParkingFee = new JLabel("Parking Fee:");
        add(ParkingFee);
        ParkingFee.setFont(f4);
        ParkingFee.setForeground(c2);
        ParkingFee.setBounds(780, 450, 170, 50);

        JLabel ParkingSlot5 = new JLabel("Parking Slot:");
        add(ParkingSlot5);
        ParkingSlot5.setFont(f4);
        ParkingSlot5.setForeground(c2);
        ParkingSlot5.setBounds(60, 330, 170, 50);

        ViewParkingSlot.setFont(f2); 
        ViewParkingSlot.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Parking Slot", "Plate Number", "Entry Date", "Entry Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ViewParkingSlot.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewParkingSlotMouseClicked(e);
            }
        });
        
        ViewParkingSlot.setAlignmentX(1.0F);
        ViewParkingSlot.setAlignmentY(1.0F);
        ViewParkingSlot.setAutoscrolls(false);
        ViewParkingSlot.setIntercellSpacing(new java.awt.Dimension(1, 2));
        ViewParkingSlot.setRowHeight(20);
        jScrollPane1.setViewportView(ViewParkingSlot);
        
        JTableHeader tableH=ViewParkingSlot.getTableHeader();
        tableH.setFont(f3); 
        tableH.setForeground(c2);
        
        add(jScrollPane1);
        jScrollPane1.setBounds(90, 150, 850, 140);

        add(entrydate);
        entrydate.setBackground(c3);
        entrydate.setFont(f5);
        entrydate.setBorder(BorderFactory.createEtchedBorder());
        entrydate.setEnabled(false);
        entrydate.setBounds(540, 380, 180, 40);

        add(exittime);
        exittime.setBackground(c3);
        exittime.setFont(f5);
        exittime.setBorder(BorderFactory.createEtchedBorder());
        exittime.setBounds(540, 500, 180, 40);

        add(platenumber);
        platenumber.setBackground(c3);
        platenumber.setFont(f5);
        platenumber.setBorder(BorderFactory.createEtchedBorder());
        platenumber.setEnabled(false);
        platenumber.setBounds(300, 380, 180, 40);

        add(entrytime);
        entrytime.setBackground(c3);
        entrytime.setFont(f5);
        entrytime.setBorder(BorderFactory.createEtchedBorder());
        entrytime.setEnabled(false);
        entrytime.setBounds(780, 380, 180, 40);

        add(parkingslot);
        parkingslot.setBackground(c3);
        parkingslot.setFont(f5);
        parkingslot.setBorder(BorderFactory.createEtchedBorder());
        parkingslot.setEnabled(false);
        parkingslot.setBounds(60, 380, 180, 40);

        add(parkingfee);
        parkingfee.setBackground(c3);
        parkingfee.setFont(f5);
        parkingfee.setBorder(BorderFactory.createEtchedBorder());
        parkingfee.setEnabled(false);
        parkingfee.setBounds(780, 500, 180, 40);

        JButton home = new JButton("home");
        add(home);
        home.setFont(f3);
        home.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        home.setBorder(BorderFactory.createEtchedBorder());
        home.setBounds(860, 590, 100, 40);

        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close();
                Menu m=new Menu();
                m.setVisible(true);
            }
        });
        
        JButton search = new JButton("search");
        add(search);
        search.setFont(f3); 
        search.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        search.setBorder(BorderFactory.createEtchedBorder());
        search.setBounds(400, 590, 100, 40);
        
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        
        JButton calculate = new JButton("Calculate Fee");
        add(calculate);
        calculate.setFont(f3); 
        calculate.setCursor(new Cursor(Cursor.HAND_CURSOR));
        calculate.setBorder(BorderFactory.createEtchedBorder());
        calculate.setBounds(540, 590, 120, 40);
        
        calculate.addActionListener(this);

        JButton payandclear = new JButton("Pay and Clear");
        add(payandclear);
        payandclear.setFont(f3); 
        payandclear.setCursor(new Cursor(Cursor.HAND_CURSOR));
        payandclear.setBorder(BorderFactory.createEtchedBorder());
        payandclear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                payandclearActionPerformed(e);
            }
        });
        payandclear.setBounds(700, 590, 120, 40);

        JButton back = new JButton("back");
        add(back);
        back.setFont(f3);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.setBorder(BorderFactory.createEtchedBorder());
        back.setBounds(260, 590, 100, 40);
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) { 
                close();
                ViewParking view=new ViewParking();
                view.setVisible(true);
            } 
        });
        
        JLabel backg = new JLabel();
        add(backg);
        backg.setIcon(new ImageIcon(getClass().getResource("/Images/car.jpg")));
        backg.setBounds(0, 0, 1030, 690);

        pack();
    }
    
    @Override
    public void close() {
        WindowEvent window = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(window);
    }
   
    static void verifyExitTime(String exTime){
        int exTimeL = exTime.length();
        if (exTime.equals("") || exTime.equals(" ") || exTime.equals(null)) {
            //to prevent null string is passed
            System.out.println("Exception caught. The input of exit time is empty.");
            throw new IllegalArgumentException("Invalid Format !!!/             Exit time cannot be empty. /       (e.g: 00:00)");
        } 
        else if(exTimeL<3 || exTimeL>5)
        {
            System.out.println("Exception caught. The input of exit time is too short or too long.");
            throw new ArithmeticException("Invalid Format !!!/          Exit time must be 2 to 4 numbers. /       (e.g: 0:0 or 00:00)");
        }
        
        String[] arrOfStr={""};
        
        try{
            arrOfStr = exTime.split(":", 2);
        }
        catch(Exception ex){
            System.out.println(ex.toString());
            System.out.println("Exception caught at split");
        }
        
        int h=0, m=0;
        
        try{
        h=Integer.parseInt(arrOfStr[0]);
        m=Integer.parseInt(arrOfStr[1]);
        }
        catch(NumberFormatException ex){
            System.out.println("Exception caught. The input of exit time is characters.");
            throw new NumberFormatException("Invalid Format !!!/       The hours, minutes and seconds must be numbers. /       (e.g: 00:00)");
        } 
	catch(ArrayIndexOutOfBoundsException ex){
        System.out.println("Exception caught. The input of exit time without : symbol.");
        throw new NumberFormatException("Invalid Format !!!/     There must have a : symbol between the numbers./       (e.g: 00:00)");
        }

        if (h<0 || h>=24) {
          System.out.println("Exception caught. The input of hours is invalid.");
          throw new ArithmeticException("Access Denied !!!/           Hours must between 0 to 23./       (e.g: 23:00)");
        }
        else if (m<0 || m>59) {
          System.out.println("Exception caught. The input of minutes is invalid.");
          throw new ArithmeticException("Access Denied !!!/           Minutes must between 0 to 59./       (e.g: 00:59)");
        }
    }
     
    private JDialog createDialog(ClearParking frame, String eMsg) {

        Font f1 = new Font("Lucida Bright", 1, 20);
        Font f2 = new Font("Minion Pro Cond", 0, 18);
        Font f3 = new Font("UD Digi Kyokasho NK-B", 0, 14);
        Font f4 = new Font("Minion Pro SmBd", 0, 18);

        Color c1 = new Color(250, 0, 0);
        Color c2 = new Color(0, 0, 153);
        Color c3 = new Color(102, 102, 102);

        System.out.println(eMsg);
        final JDialog dialog = new JDialog(frame, Dialog.ModalityType.DOCUMENT_MODAL);
        dialog.setBounds(200, 450, 380, 230);
        dialog.setLocationRelativeTo(null); //restrict the dialog appear in same place everytime
        dialog.setResizable(false);
        dialog.setTitle("Error");
        dialog.setIconImage(icon[0].getImage());

        String[] arrOfStr = {""};
        String error1, error2, error3;

        try {
            arrOfStr = eMsg.split("/", 3);
        } catch (Exception ex) {
            System.out.println(ex.toString()); //return the string representation of the object
            System.out.println("Exception caught at split");
        }

        try {
            error1 = arrOfStr[0];
            error2 = arrOfStr[1];
            error3 = arrOfStr[2];
        } catch (NumberFormatException ex) {
            throw new NumberFormatException("Invalid Format");
        }

        JPanel errorPanel = new JPanel();
        errorPanel.setBorder(BorderFactory.createEmptyBorder(20, 100, 10, 10));
        errorPanel.setLayout(new FlowLayout());
        errorPanel.setLayout(new BoxLayout(errorPanel,BoxLayout.LINE_AXIS));
        JLabel errorImg = new JLabel();
        errorPanel.add(errorImg);

        JLabel errorTitle1 = new JLabel(error1);
        errorPanel.add(errorTitle1);
        errorTitle1.setFont(f1);
        errorTitle1.setForeground(c1);

        JLabel errorTitle2 = new JLabel(error2); //error2=error message
        errorTitle2.setFont(f2);
        errorTitle2.setForeground(c2);
      
        JLabel errorTitle3 = new JLabel(error3); //error3=e.g text
        errorTitle3.setFont(f3);
        errorTitle3.setForeground(c3);

        JPanel errorPanel2 = new JPanel();
        errorPanel2.add(errorTitle2, BorderLayout.NORTH);
        errorPanel2.add(errorTitle3, BorderLayout.SOUTH);

        JPanel errorPanel3 = new JPanel();
        JButton ok = new JButton("OK");
        errorPanel3.add(ok);
        ok.setFont(f4);
        ok.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        ok.setBorder(BorderFactory.createEtchedBorder());
        ok.setBounds(860, 590, 100, 40);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
            }
        });

        Container dialogContainer = dialog.getContentPane();
        dialogContainer.setLayout(new BorderLayout());
        dialogContainer.add(errorPanel, BorderLayout.PAGE_START);
        dialogContainer.add(errorPanel2, BorderLayout.CENTER);
        dialogContainer.add(errorPanel3, BorderLayout.PAGE_END);
        return dialog;
    }
    
    private void searchActionPerformed(ActionEvent e) {                                                                       
        try{
            FileReader fr=new FileReader("data.txt"); //read file and update the record table
            BufferedReader br=new BufferedReader(fr);
            
            DefaultTableModel model=(DefaultTableModel)ViewParkingSlot.getModel();
            Object[] lines=br.lines().toArray();
            
            for(int i=0; i<lines.length; i++){
                String[] row=lines[i].toString().split(" ");
                model.addRow(row);
            }
            
            br.close();
            fr.close();
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "error");
        
        }
    }                                      

    private void viewParkingSlotMouseClicked(MouseEvent e) {                                             
        int sldata = ViewParkingSlot.getSelectedRow();
        parkingslot.setText(ViewParkingSlot.getValueAt(sldata, 0).toString());
        platenumber.setText(ViewParkingSlot.getValueAt(sldata, 1).toString());
        entrytime.setText(ViewParkingSlot.getValueAt(sldata, 2).toString());
        entrydate.setText(ViewParkingSlot.getValueAt(sldata, 3).toString());
        
    }  
    
     @Override
    public void actionPerformed(ActionEvent e) {
        {
            String exTime = exittime.getText(); //check exit time input 

            try {
                verifyExitTime(exTime); //to validate the exit time (code that might generate exception)
            } 
            catch (Exception ex) {
                dialog = createDialog(frame, ex.getMessage()); //if exception occur, catch the throw, show error message
                dialog.setVisible(true);
                return;
            }
        }
        
        String entime = entrytime.getText();
        String extime = exittime.getText();
        String splt1[]= entime.split(":");
        String splt2[]= extime.split(":");
        double hour1 = Double.parseDouble(splt1[0]);
        double hour2 = Double.parseDouble(splt2[0]);
        double min1 = Double.parseDouble(splt1[1]);
        double min2 = Double.parseDouble(splt2[1]);
        double hour = hour2-hour1;
        if(hour>=0)
        {
            if(min1<min2)
            {
                double min = (min2-min1)/60;
                hour=hour+min;
            }
            else if(min2<min1)
            {
                min2 = min2 + 60;
                double min = (min2-min1)/60;
                hour=hour+min-1;
            }
            
            if(hour>0)
            {
                double fee = hour * 2.00;
                String hr = String.valueOf(fee).format("%.2f",fee);
                parkingfee.setText(hr);
            }
        }
    }                                         

    private void payandclearActionPerformed(ActionEvent e) { 
        {
            String exTime = exittime.getText(); //check exit time input 

            try {
                verifyExitTime(exTime); //to validate the exit time (code that might generate exception)
            } 
            catch (Exception ex) {
                dialog = createDialog(frame, ex.getMessage()); //if exception occur, catch the throw, show error message
                dialog.setVisible(true);
                return;
            }
        }
        DefaultTableModel delrow = (DefaultTableModel)ViewParkingSlot.getModel();
        ViewParkingSlot.getSelectedRow();
        int sldata = ViewParkingSlot.getSelectedRow();
        delrow.removeRow(ViewParkingSlot.getSelectedRow());
        
        String dlt = parkingslot.getText(); 
        int rm = Integer.parseInt(dlt);
        ViewParking.rmVec(rm);
        File ori = new File("data.txt");
        File del = new File("tmpy.txt");
        String lineCheck;
        String chk[];
        
        try {
            FileWriter fwrite = new FileWriter("tmpy.txt", true);
            BufferedWriter bwrite = new BufferedWriter(fwrite);
            PrintWriter pwrite = new PrintWriter(bwrite);
            FileReader fread = new FileReader("data.txt"); 
            BufferedReader bread = new BufferedReader(fread);
          
            while((lineCheck = bread.readLine())!= null)
            {
                chk = lineCheck.split(" ");
                if(!chk[0].equalsIgnoreCase(dlt))
                {
                    pwrite.println(lineCheck);
                }
            }
            
            pwrite.flush();
            pwrite.close();
            fread.close();
            bread.close();
            fwrite.close();
            bwrite.close();
            
            ori.delete();
            File data = new File("data.txt");
            del.renameTo(data);
            
        } 
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, "error");
        }
        
        parkingslot.setText("");
        platenumber.setText("");
        entrydate.setText("");
        entrytime.setText("");
        exittime.setText("");
        parkingfee.setText("");
        
    }                                                                               
    
    public static void main(String args[]) {
        ClearParking frame = new ClearParking();
        frame.setVisible(true);
        frame.setBounds(130, 5, 1024, 683); //set frame size
        frame.setResizable(false); //unable to resize the frame
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }  

}
