package app.gui;

import app.save.Record;
import app.save.SaveToFile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GUI extends JFrame implements ActionListener{

    private final String [] choices = {"-", "WIKTORIA", "KRZYSIEK", "JAREK P", "JAREK N", "MARCIN", "łUKASZ"};
    private final String [] doctype = {"-", "PA", "FS", "BRAK"};

    private final int x = 25;

    private Record record;
    private SaveToFile saveToFile;

    private JComboBox cbWho, cbDocType;
    private JTextField tfDocumentNr, tfName, tfNick;
    private JTextArea taDescription;
    private JButton btnAdd, btnNew, btnOpen;
    private JLabel lAutor, lImage, lDocumentNr, lName, lNick, lWho, lDescription, lStatus;

    public GUI() {
        createFrame();
    }

    private void createFrame() {
        lAutor = new JLabel("JRK ® 2018");
        lAutor.setBounds(370, 435, 100, 10);

        lImage = new JLabel(new ImageIcon("src/main/java/app/img/ami.gif"));
        lImage.setBounds(x + 225, 190, 200, 200);

        lDocumentNr = new JLabel("Numer dokumentu:");
        lDocumentNr.setBounds(x, 15, 200, 25);
        tfDocumentNr = new JTextField();
        tfDocumentNr.setBounds(x + 60, 40, 150, 25);
        cbDocType = new JComboBox(doctype);
        cbDocType.setBounds(x, 40, 50, 25);
        cbDocType.addActionListener(this);

        lName = new JLabel("Nazwa klienta:");
        lName.setBounds(x, 65, 200, 25);
        tfName = new JTextField();
        tfName.setBounds(x, 90, 200, 25);

        lNick = new JLabel("Nick klienta:");
        lNick.setBounds(x, 115, 200, 25);
        tfNick = new JTextField();
        tfNick.setBounds(x, 140, 200, 25);

        lWho = new JLabel("Zainteresowany:");
        lWho.setBounds(x, 165, 200, 25);
        cbWho = new JComboBox(choices);
        cbWho.setBounds(x, 190, 200, 25);

        lDescription = new JLabel("Opis sytuacji:");
        lDescription.setBounds(x, 215, 200, 25);
        taDescription = new JTextArea();
        taDescription.setBounds(x, 240, 200, 170);
        taDescription.setLineWrap(true);

        btnAdd = new JButton("Add record");
        btnAdd.setBounds(x + 225, 40, 200, 25);
        //btnAdd.setEnabled(true);
        btnAdd.addActionListener(this);
        btnNew = new JButton("New record");
        btnNew.setBounds(x + 225, 90, 200, 25);
        btnNew.setEnabled(false);
        btnNew.addActionListener(this);
        btnOpen = new JButton("Open file");
        btnOpen.setBounds(x + 225, 140, 200, 25);
        btnOpen.setEnabled(false);

        lStatus = new JLabel("Satus: OK");
        lStatus.setBounds(10, 420, 350, 25);


        add(lAutor);
        add(lImage);
        add(lDocumentNr);
        add(tfDocumentNr);
        add(cbDocType);
        add(lName);
        add(tfName);
        add(lNick);
        add(tfNick);
        add(lWho);
        add(cbWho);
        add(lDescription);
        add(taDescription);
        add(btnAdd);
        add(btnNew);
        add(btnOpen);
        add(lStatus);

        setTitle("Mistake App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(475, 480);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == cbDocType && (cbDocType.getSelectedItem().equals("BRAK")))
            tfDocumentNr.setEnabled(false);

        if (source == btnAdd) {
            record = new Record(
                    (String)cbDocType.getSelectedItem(),
                    tfDocumentNr.getText(),
                    tfName.getText(),
                    tfNick.getText(),
                    (String)cbWho.getSelectedItem(),
                    taDescription.getText()
            );

            try {
                    saveToFile = new SaveToFile();
            } catch (IOException e1) {
                    lStatus.setText("Status: " + e);
            }
            try {
                    saveToFile.saveFile(record);
            } catch(NullPointerException npe) {
                    JOptionPane.showMessageDialog(this, "Plik do którego chcesz zapisać record jest aktualnie niedostępny!", "Błąd dostepu do pliku!", JOptionPane.WARNING_MESSAGE);
            }

            lStatus.setText("Status: Record dodany pomyślnie.");
            enabledFrame(false);
        }else if (source == btnNew) {
            clearForm();
            lStatus.setText("Status: New record.");
            enabledFrame(true);

        }

    }

    private void clearForm() {
        cbDocType.setSelectedIndex(0);
        tfDocumentNr.setText("");
        tfName.setText("");
        tfNick.setText("");
        cbWho.setSelectedIndex(0);
        taDescription.setText("");
    }

    private void enabledFrame(boolean b) {
        tfDocumentNr.setEnabled(b);
        tfName.setEnabled(b);
        tfNick.setEnabled(b);
        taDescription.setEnabled(b);
        cbWho.setEnabled(b);
        cbDocType.setEnabled(b);
        btnAdd.setEnabled(b);
        btnNew.setEnabled(!b);
    }
}
