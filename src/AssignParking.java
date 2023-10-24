
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
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class AssignParking extends JFrame implements Assign, ActionListener {

    private AssignParking frame;
    private JTextField date;
    private JTextField inPlateNo;
    private JTextField inSlotNo;
    private JTextField inTelNo;
    private JTextField time;
    private JDialog dialog;

    ImageIcon icon[] = {new ImageIcon(getClass().getResource("/Images/alert.png"))};

    
    public AssignParking() {
        init();
        edit();
        showDate();
        
        //let the frame appear in the center of the screen
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2-getWidth()/2, size.height/2-getHeight()/2);

    }

    public void init() {

        Font f1 = new Font("Bodoni MT Black", Font.PLAIN, 40);
        Font f2 = new Font("Minion Pro Cond", 0, 24);
        Font f3 = new Font("UD Digi Kyokasho NK-B", 0, 18);
        Font f4 = new Font("Minion Pro SmBd", 0, 18);

        Color c1 = new Color(255, 255, 255);
        Color c2 = new Color(0, 0, 153);
        Color c3 = new Color(250, 250, 194);

        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(null);

        JLabel entryForm = new JLabel("ENTRY FORM");
        add(entryForm);
        entryForm.setFont(f1);
        entryForm.setForeground(c1);
        entryForm.setBounds(330, 20, 350, 100);

        JLabel slot = new JLabel("Parking Slot          :");
        add(slot);
        slot.setFont(f2);
        slot.setForeground(c2);
        slot.setBounds(60, 140, 180, 40);

        inSlotNo = new JTextField();
        add(inSlotNo);
        inSlotNo.setFont(f3);
        inSlotNo.setBackground(c3);
        inSlotNo.setBorder(BorderFactory.createEtchedBorder());
        inSlotNo.setBounds(240, 140, 170, 40);
        inSlotNo.setDocument(new Validation(2)); //limit to 2 inputs only

        JLabel plate = new JLabel("Plate Number       :");
        add(plate);
        plate.setFont(f2);
        plate.setForeground(c2);
        plate.setBounds(60, 230, 180, 60);

        inPlateNo = new JTextField();
        add(inPlateNo);
        inPlateNo.setFont(f3);
        inPlateNo.setBackground(c3);
        inPlateNo.setBorder(BorderFactory.createEtchedBorder());
        inPlateNo.setBounds(240, 240, 170, 40);
        inPlateNo.setDocument(new Validation(7)); //limit to 7 inputs only

        JLabel contact = new JLabel("Contact Number  :");
        add(contact);
        contact.setFont(f2);
        contact.setForeground(c2);
        contact.setBounds(60, 340, 190, 40);

        inTelNo = new JTextField();
        add(inTelNo);
        inTelNo.setFont(f3);
        inTelNo.setBackground(c3);
        inTelNo.setBorder(BorderFactory.createEtchedBorder());
        inTelNo.setBounds(240, 340, 170, 40);

        inTelNo.setDocument(new Validation(11)); //limit to 11 inputs only

        JLabel entryDate = new JLabel("Entry Date    :");
        add(entryDate);
        entryDate.setFont(f2);
        entryDate.setForeground(c2);
        entryDate.setBounds(530, 140, 140, 50);

        date = new JTextField();
        add(date);
        date.setFont(f3);
        date.setBackground(c3);
        date.setBorder(BorderFactory.createEtchedBorder());
        date.setBounds(660, 140, 170, 40);

        JLabel entryTime = new JLabel("Entry Time   :");
        add(entryTime);
        entryTime.setFont(f2);
        entryTime.setForeground(c2);
        entryTime.setBounds(530, 230, 140, 50);

        time = new JTextField();
        add(time);
        time.setFont(f3);
        time.setBackground(c3);
        time.setBorder(BorderFactory.createEtchedBorder());
        time.setBounds(660, 230, 170, 40);
        time.setDocument(new Validation(5)); //limit to 5 inputs only

        JButton back1 = new JButton("back");
        add(back1);
        back1.setFont(f4);
        back1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back1.setBorder(BorderFactory.createEtchedBorder());
        back1.setBounds(40, 480, 100, 40);

        back1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close();
                ViewParking view = new ViewParking();
                view.setVisible(true);
            }
        });

        JButton save = new JButton("save");
        add(save);
        save.setFont(f4);
        save.setCursor(new Cursor(Cursor.HAND_CURSOR));
        save.setBorder(BorderFactory.createEtchedBorder());
        save.setBounds(730, 490, 100, 40);

        save.addActionListener(this);

        JLabel backg = new JLabel();
        add(backg);
        backg.setIcon(new ImageIcon(getClass().getResource("/Images/car.jpg")));
        backg.setBounds(0, 0, 1020, 550);

        pack();
    }

    private void edit() {
        inSlotNo.setEditable(true);
        inPlateNo.setEditable(true);
        inTelNo.setEditable(true);
        date.setEditable(false);
        time.setEditable(true);
    }

    public void showDate() {
        Calendar c = new GregorianCalendar();
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);
        int day = c.get(Calendar.DAY_OF_MONTH);

        date.setText(day + "/" + (month + 1) + "/" + year);
    }

    @Override
    public void close() {
        WindowEvent window = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(window);
    }
    
    static void verifySlotNo(String slotNo){
        int slotNoL = slotNo.length();
        if (slotNo.equals("") || slotNo.equals(" ") || slotNo.equals(null)) {
            //to prevent null string is passed
            System.out.println("Exception caught. The input of slot number is empty.");
            throw new IllegalArgumentException("Invalid Format !!!/           Slot number cannot be empty. /           (e.g: 1)");
        } 
        else if(slotNoL<1 || slotNoL>2)
        {
            System.out.println("Exception caught. The input of slot number is too short or too long");
            throw new ArithmeticException("Invalid Format !!!/           Slot number must have 1 or 2 numbers. /           (e.g: 1)");
        }
        
        String[] arrOfStr={""};
        
        try{
            arrOfStr = slotNo.split(":", 2);
        }
        catch(Exception ex){
            System.out.println(ex.toString());
            System.out.println("Exception caught at split");
        }
        
        int s=0;
        
        try{
        s=Integer.parseInt(arrOfStr[0]);
        }
        catch(NumberFormatException ex){
            System.out.println("Exception caught. The input of slot number is characters.");
            throw new NumberFormatException("Invalid Format !!!/           Slot number must be numbers. /           (e.g: 1)");
        } 
        
        if (s<0 || s>90) {
          System.out.println("Exception caught. The input of slot number is invalid.");
          throw new ArithmeticException("Access Denied !!!/           Slot number must between 0 to 90./           (e.g: 1)");
        }
    }
    
    static void verifyPlateNo(String plateNo){
        int plateNoL = plateNo.length();
        if (plateNo.equals("") || plateNo.equals(" ") || plateNo.equals(null)) {
            //to prevent null string is passed
            System.out.println("Exception caught. The input of plate number is empty.");
            throw new IllegalArgumentException("Invalid Format !!!/           Plate number cannot be empty. /           (e.g: ABC1234)");
        } 
        else if (plateNoL!=7) {
            System.out.println("Exception caught. Plate number is less than 7 character.");
            throw new ArithmeticException("Invalid Format !!!/    Plate number cannot less than 7 character. /           (e.g: ABC1234)");
        }
    }
    
    static void verifyContactNo(String contactNo){
        int contactNoL = contactNo.length();
        if (contactNo.equals("") || contactNo.equals(" ") || contactNo.equals(null)) {
            //to prevent null string is passed
            System.out.println("Exception caught. The input of contact number is empty.");
            throw new IllegalArgumentException("Invalid Format !!!/       Contact number cannot be empty. /       (e.g: 01123456786)");
        } 
        else if(contactNoL<10 || contactNoL>11)
        {
            System.out.println("Exception caught. The input of contact number is too short or too long");
            throw new ArithmeticException("Invalid Format !!!/    Contact number must have 10 to 11 numbers./       (e.g: 01123456786)");
        }
        
        String[] arrOfStr={""};
        
        try{
            arrOfStr = contactNo.split("", 0);
        }
        catch(Exception ex){
            System.out.println(ex.toString());
            System.out.println("Exception caught at split");
        }
        
        int tel;
        
        try{
        tel=Integer.parseInt(arrOfStr[0]);
        }
        catch(NumberFormatException ex){
            System.out.println("Exception caught. The input of contact number is characters.");
            throw new NumberFormatException("Invalid Format !!!/ The input of contact number must be number only./           (e.g: 01110123456)");
        } 
    }
    
    static void verifyEntryTime(String enTime){
        int enTimeL = enTime.length();
        if (enTime.equals("") || enTime.equals(" ") || enTime.equals(null)) {
            //to prevent null string is passed
            System.out.println("Exception caught. The input of entry time is empty.");
            throw new IllegalArgumentException("Invalid Format !!!/           Entry time cannot be empty. /       (e.g: 00:00)");
        } 
        else if(enTimeL<3 || enTimeL>5)
        {
            System.out.println("Exception caught. The input of entry time is too short or too long.");
            throw new ArithmeticException("Invalid Format !!!/       Entry time must be 2 to 4 numbers. /       (e.g: 0:0 or 00:00)");
        }
        
        String[] arrOfStr={""};
        
        try{
            arrOfStr = enTime.split(":", 2);
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
            System.out.println("Exception caught. The input of entry time is characters.");
            throw new NumberFormatException("Invalid Format !!!/       The hours and minutes must be numbers. /       (e.g: 00:00)");
        } 
	catch(ArrayIndexOutOfBoundsException ex){
        System.out.println("Exception caught. The input of entry time without : symbol.");
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
    
    private JDialog createDialog(AssignParking frame, String eMsg) {

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

    @Override
    public void actionPerformed(ActionEvent e) {
        {
            String slotNo = inSlotNo.getText(); //check plate number input 

            try {
                verifySlotNo(slotNo); //to validate the plate number (code that might generate exception)
            } 
            catch (Exception ex) {
                dialog = createDialog(frame, ex.getMessage()); //if exception occur, catch the throw, show error message
                dialog.setVisible(true);
                return;
            }
        }
       {
            String plateNo = inPlateNo.getText(); //check plate number input 

            try {
                verifyPlateNo(plateNo); //to validate the plate number (code that might generate exception)
            } 
            catch (Exception ex) {
                dialog = createDialog(frame, ex.getMessage()); //if exception occur, catch the throw, show error message
                dialog.setVisible(true);
                return;
            }
        }
       {
            String contactNo = inTelNo.getText(); //check plate number input 

            try {
                verifyContactNo(contactNo); //to validate the plate number (code that might generate exception)
            } 
            catch (Exception ex) {
                dialog = createDialog(frame, ex.getMessage()); //if exception occur, catch the throw, show error message
                dialog.setVisible(true);
                return;
            }
        }
       {
            String enTime = time.getText(); //check plate number input 

            try {
                verifyEntryTime(enTime); //to validate the plate number (code that might generate exception)
            } 
            catch (Exception ex) {
                dialog = createDialog(frame, ex.getMessage()); //if exception occur, catch the throw, show error message
                dialog.setVisible(true);
                return;
            }
        }
       
        close();
        ClearParking clear=new ClearParking();
        clear.setVisible(true);
       
        String plate=inPlateNo.getText();
        String contact=inTelNo.getText();
        String entryTime=time.getText();
        String entryDate=date.getText();
        
        int x=Integer.parseInt(inSlotNo.getText());
        ViewParking.addVec(x);
         
        try{
            FileWriter pw=new FileWriter("data.txt", true); //save record to data.txt
            BufferedWriter br=new BufferedWriter(pw);
            
            pw.write(x+" "+plate+" "+entryTime+" "+entryDate);
            pw.write(System.getProperty("line.separator"));
            br.close();
            pw.close(); //close connection
            JOptionPane.showMessageDialog(null, "Success");
            setVisible(false); //remove the ady save data from the fields 
            
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "error");
        }
    }
    
    public static void main(String args[]) {
        AssignParking frame = new AssignParking();
        frame.setVisible(true);
        frame.setBounds(130, 5, 1024, 683); //set frame size
        frame.setResizable(false); //unable to resize the frame
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
