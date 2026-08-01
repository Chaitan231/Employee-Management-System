package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

public class AddEmployee extends JFrame implements ActionListener{
    Random ran = new Random();
    int number = ran.nextInt(999999);
    JTextField tname,tfname,temail,tphone,taddress,tsalary,taadhaar,tdesignation;
    JLabel tempid;
    JSpinner tdob;
    JButton add,back;
    JComboBox<String> Boxeducation;
    AddEmployee(){
        getContentPane().setBackground(new Color(163, 255, 188));
        
        JLabel heading=new JLabel("Add Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(heading);
        JLabel name=new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(name);
        tname=new JTextField();
        tname.setBounds(200, 150, 150, 30);
        tname.setBackground(new Color(177,252,197));
        add(tname);
        JLabel fname=new JLabel("Father's Name");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(fname);
        tfname=new JTextField();
        tfname.setBounds(600, 150, 150, 30);
        tfname.setBackground(new Color(177,252,197));
        add(tfname);
        JLabel dob=new JLabel("Date Of Birth");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(dob);

        tdob = new JSpinner(new SpinnerDateModel());
        tdob.setEditor(new JSpinner.DateEditor(tdob, "dd-MM-yyyy"));
        tdob.setBounds(200, 200, 150, 30);
        try {
            javax.swing.JComponent editor = tdob.getEditor();
            if (editor instanceof JSpinner.DefaultEditor) {
                ((JSpinner.DefaultEditor) editor).getTextField().setBackground(new Color(177,252,197));
            }
        } catch (Exception ignored) {}
        add(tdob);
        JLabel salary=new JLabel("Salary");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(salary);
        tsalary=new JTextField();
        tsalary.setBounds(600, 200, 150, 30);
        tsalary.setBackground(new Color(177,252,197));
        add(tsalary);
         JLabel address=new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(address);
        taddress=new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        taddress.setBackground(new Color(177,252,197));
        add(taddress);
        JLabel phone=new JLabel("Phone");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(phone);
        tphone=new JTextField();
        tphone.setBounds(600, 250, 150, 30);
        tphone.setBackground(new Color(177,252,197));
        add(tphone);
        JLabel email=new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(email);
        temail=new JTextField();
        temail.setBounds(200, 300, 150, 30);
        temail.setBackground(new Color(177,252,197));
        add(temail);
        JLabel education=new JLabel("Highest Education");
        education.setFont(new Font("Tahoma", Font.BOLD, 20));
        education.setBounds(400, 300, 150, 30);
        add(education);
        String items[]={"B.Tech","M.Tech","BBA","MBA","BSC","MSC","BCA","MCA","BA","MA","PHD","B.Com","M.Com"};
        Boxeducation=new JComboBox<String>(items);
        Boxeducation.setBackground(new Color(177,252,197));
        Boxeducation.setBounds(600, 300, 150, 30);
        add(Boxeducation);
        JLabel aadhaar=new JLabel("Aadhaar Number");
        aadhaar.setBounds(400, 350, 150, 30);
        aadhaar.setFont(new Font("Tahoma", Font.BOLD, 20));
        
        add(aadhaar);
        taadhaar=new JTextField();
        taadhaar.setBounds(600, 350, 150, 30);
        taadhaar.setBackground(new Color(177,252,197));
        
        add(taadhaar);
        JLabel empid=new JLabel("Employee ID");
        empid.setBounds(50, 400, 150, 30);
        empid.setFont(new Font("Tahoma", Font.BOLD, 20));
        
        add(empid);
        tempid=new JLabel(" "+number);
        tempid.setBounds(200, 400, 150, 30);
        tempid.setFont(new Font("Tahoma", Font.BOLD, 20));
        tempid.setForeground(Color.RED);
        add(tempid);
        JLabel designation=new JLabel("Designation");
        designation.setBounds(50, 350, 150, 30);
        designation.setFont(new Font("Tahoma", Font.BOLD, 20));
        designation.setLayout(null);
        add(designation);
        tdesignation=new JTextField();
        tdesignation.setBounds(200, 350, 150, 30);
        tdesignation.setBackground(new Color(177,252,197));
        tdesignation.setLayout(null);
        add(tdesignation);
        add=new JButton("ADD");
        add.setBounds(250, 550, 150, 40);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);

        back=new JButton("BACK");
        back.setBounds(450, 550, 150, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLocation(300, 50);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String name=tname.getText();
            String fname=tfname.getText();
            String dob=((JSpinner.DefaultEditor) tdob.getEditor()).getTextField().getText();
            String salary=tsalary.getText();
            String address=taddress.getText();
            String aadhaar=taadhaar.getText();
            String phone=tphone.getText();
            String email=temail.getText();
            String education=(String)Boxeducation.getSelectedItem();
            
            String designation=tdesignation.getText();
            String empID=tempid.getText();
            
            try{
                conn c=new conn();
                String query="insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+aadhaar+"','"+empID+"')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Main_class();
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        } else{
            setVisible(false);
            new Main_class();
        }
    }   
    public static void main(String[] args) {
        new AddEmployee();
    }

     
}
