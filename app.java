package com.codebind;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;


public class App extends JFrame {
    private JButton editButton;
    private JPanel topPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JButton saveNewButton;
    private JLabel name;
    private JTextField nameText;
    private JTextField idText;
    private JTextField cityText;
    private JTextField salaryText;
    private JTextField dateText;
    private JLabel ID;
    private JLabel city;
    private JLabel salary;
    private JLabel date;
    private JPanel panelMain;
    private JPanel bottomPanel;
    private JList peopleList;
    private ArrayList<Person> people;
    private DefaultListModel listPeople;

    App(){
        super("First GUI");
        this.setContentPane(this.panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        people = new ArrayList<Person>();
        listPeople = new DefaultListModel();
        peopleList.setModel(listPeople);
        editButton.setEnabled(false);

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            int personNumber = peopleList.getSelectedIndex();
            if(personNumber>=0){
                Person p=people.get(personNumber);
                p.setName(nameText.getText());
                p.setId(idText.getText());
                p.setCity(cityText.getText());
                p.setJoinedDate(dateText.getText());
                refreshPeopleList();
                refreshEditFile(nameText.getText(), idText.getText(), cityText.getText(), salaryText.getText(), dateText.getText());
                nameText.setText("");
                idText.setText("");
                cityText.setText("");
                salaryText.setText("");
                dateText.setText("");
            }
            }
        });
        saveNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Person p=new Person(
                        nameText.getText(),
                        idText.getText(),
                        cityText.getText(),
                        salaryText.getText(),
                        dateText.getText()
                );
                refreshNewFile(nameText.getText(),
                        idText.getText(),
                        cityText.getText(),
                        salaryText.getText(),
                        dateText.getText());
                people.add(p);
                refreshPeopleList();
                nameText.setText("");
                idText.setText("");
                cityText.setText("");
                salaryText.setText("");
                dateText.setText("");

            }
        });

        peopleList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int personNumber= peopleList.getSelectedIndex();
                if(personNumber>=0){
                    Person p =people.get(personNumber);
                    nameText.setText(p.getName());
                    idText.setText(p.getId());
                    cityText.setText(p.getCity());
                    dateText.setText(p.getJoinedDate());
                    salaryText.setText(p.getSalary());
                    editButton.setEnabled(true);
                }else
                    editButton.setEnabled(false);
            }
        });
    }
    public void refreshEditFile(String name, String id, String city, String salary, String joinedDate){
        try {
            File objFile = new File("C:\\Users\\Lapstore.lk\\IdeaProjects\\information system\\src\\com\\codebind\\Editdata.txt");
            if(objFile.exists()==false) {
                if (objFile.createNewFile()) {
                    System.out.println("File created");
                } else {
                    System.out.println("File not created");
                    System.exit(0);
                }
            }
            String text=name + " " +id +  " " + city +" "+ salary +" "+joinedDate+"\n";
            FileOutputStream fileOut =new FileOutputStream(objFile,true);
            fileOut.write(text.getBytes());
            fileOut.close();
            System.out.println("File saved");

        }catch (Exception e){
            System.out.println("Exception: "+e.toString());
        }
    }
    public void refreshNewFile(String name, String id, String city, String salary, String joinedDate){
        try {
            File objFile = new File("C:\\Users\\Lapstore.lk\\IdeaProjects\\information system\\src\\com\\codebind\\Newdata.txt");
            if(objFile.exists()==false) {
                if (objFile.createNewFile()) {
                    System.out.println("File created");
                } else {
                    System.out.println("File not created");
                    System.exit(0);
                }
            }
            String text=name + " " +id +  " " + city +" "+ salary +" "+joinedDate+"\n";
            FileOutputStream fileOut =new FileOutputStream(objFile,true);
            fileOut.write(text.getBytes());
            fileOut.close();
            System.out.println("File saved");

        }catch (Exception e){
            System.out.println("Exception: "+e.toString());
        }
    }

    public void refreshPeopleList(){
        listPeople.removeAllElements();
        System.out.println("Elements removed");
        for(Person p: people){
            System.out.println("Elements added");
            listPeople.addElement(p.getName());
        }
    }
    public void addPerson(Person p){
        people.add(p);
        refreshPeopleList();
    }

    public static void main(String[] args) {
        App screen = new App();
        screen.setVisible(true);


    }
}


