package employee.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class View_Employee extends JFrame implements ActionListener {
    JTable table;
    Choice choiceEMP;
    JButton searchbtn, print, update, back;

    View_Employee() {
        setLayout(null);
        setTitle("View Employee");
        getContentPane().setBackground(new Color(255, 131, 122));

        JLabel search = new JLabel("Search by Employee ID");
        search.setBounds(20, 20, 150, 20);
        add(search);

        choiceEMP = new Choice();
        choiceEMP.setBounds(180, 20, 150, 20);
        add(choiceEMP);

        searchbtn = new JButton("Search");
        searchbtn.setBounds(350, 20, 100, 25);
        searchbtn.setBackground(Color.black);
        searchbtn.setForeground(Color.white);
        searchbtn.addActionListener(this);
        add(searchbtn);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while (resultSet.next()) {
                choiceEMP.add(resultSet.getString("empID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            table.setModel(TableUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(20, 60, 850, 520);
        add(jp);

        print = new JButton("Print");
        print.setBounds(120, 600, 120, 30);
        print.setBackground(Color.black);
        print.setForeground(Color.white);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(280, 600, 120, 30);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(440, 600, 120, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==searchbtn){
            String query="select * from employee where empID= '"+choiceEMP.getSelectedItem()+"'";
            try{
                conn c=new conn();
                ResultSet resultSet=c.statement.executeQuery(query);
                table.setModel(TableUtils.resultSetToTableModel(resultSet));
            }catch(Exception E){
                E.printStackTrace();
            }
        } else if(e.getSource()==print){
            try{
                table.print();
            }catch(Exception E){
                E.printStackTrace();
            }
        } else if(e.getSource()==update){
            setVisible(false);
            new UpdateEmployee(choiceEMP.getSelectedItem());
        }
        else{
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new View_Employee();
    }
}
