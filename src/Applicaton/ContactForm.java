package Applicaton;

import javax.swing.*;
import java.awt.*; //позволяет создать объекты в приложении.
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {
    JTextField name_field;
    JTextField email_field;
    JRadioButton male, female;
    JCheckBox check;

    public ContactForm(){
        super("Контактная форма");
        super.setBounds(500, 500, 500, 500);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane(); //создали контейнер
        super.setLayout(new GridLayout(5, 2, 2, 10)); //Система сеток
        JLabel name = new JLabel("Введите имя"); //поле с текстом
        name_field = new JTextField("", 1); //поле ввода
        JLabel email = new JLabel("Введите email");
        email_field = new JTextField("@", 1);

        //передаем поля в контейнер
        container.add(name);
        container.add(name_field);
        container.add(email);
        container.add(email_field);

        male = new JRadioButton("Мужчина");
        female = new JRadioButton("Женщина");
        check = new JCheckBox("Согласен?", false);
        JButton send_button = new JButton("Отправить");
        male.setSelected(true);

        //чтобы кнопки работали корректно их надо поместить в одну общую группу
        container.add(male);
        container.add(female);
        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        container.add(check);
        container.add(send_button);

        send_button.addActionListener(new ButtonEventManager()); // обработчик событий
    }

    class ButtonEventManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = name_field.getText(); //получаем текст, введенный в поле
            String email = email_field.getText();

            String isMale = "Мужчина";

            if (!male.isSelected())
                isMale = "Женщина";

            boolean checkBox = check.isSelected();
            String yon;
            if (checkBox == true){
                yon = "Да";
            } else {
                yon = "Нет";
            }

            JOptionPane.showMessageDialog(null, "Ваша почта: " + email + "\nВаш пол: " + isMale + "\nВы согласны на обработку? " + yon, "Привет, " + name, JOptionPane.PLAIN_MESSAGE);
        }
    }

}
