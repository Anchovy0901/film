/*
 * Created by JFormDesigner on Fri Sep 11 21:57:00 CST 2020
 */

package ui;

import dao.impl.DiscountCardDaoImpl;
import dao.impl.FilmScheduleDaoImpl;
import entity.DiscountCard;
import entity.FilmSchedule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author unknown
 */
public class FilmScheduleHomePage {
    public FilmScheduleHomePage() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        insert = new JButton();
        label1 = new JLabel();
        udpate = new JButton();
        button1 = new JButton();
        label3 = new JLabel();
        updateId = new JTextField();
        deleteId = new JTextField();
        jFrame = new JFrame();

        //======== this ========
        Container contentPane = jFrame.getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(list1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 85, 700, 314);

        //---- insert ----
        insert.setText("\u65b0\u589e");
        contentPane.add(insert);
        insert.setBounds(new Rectangle(new Point(20, 10), insert.getPreferredSize()));

        //---- label1 ----
        label1.setText("\u7f16\u53f7");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(140, 15), label1.getPreferredSize()));

        //---- udpate ----
        udpate.setText("\u4fee\u6539");
        contentPane.add(udpate);
        udpate.setBounds(new Rectangle(new Point(210, 10), udpate.getPreferredSize()));

        //---- button1 ----
        button1.setText("\u5220\u9664");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(400, 10), button1.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u7f16\u53f7");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(330, 15), label3.getPreferredSize()));
        contentPane.add(updateId);
        updateId.setBounds(170, 10, 30, 30);
        contentPane.add(deleteId);
        deleteId.setBounds(365, 10, 30, 30);
        list1.setSize(700,200);

        List<FilmSchedule> list = new FilmScheduleDaoImpl().list();
        if(!list.isEmpty()){
            String[] values=new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                FilmSchedule filmSchedule = list.get(i);
                values[i] = "编号："+filmSchedule.getId()+"  影城编号："+filmSchedule.getCineplexId()+"  影厅编号："+filmSchedule.getMovieHallId()+"  电影编号："+filmSchedule.getFilmId()+"  票价："+filmSchedule.getTicketRates()+"  开播时间："+ DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.ofInstant(Instant.ofEpochMilli(filmSchedule.getStartTime()), ZoneId.systemDefault()))+"  结束时间："+DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.ofInstant(Instant.ofEpochMilli(filmSchedule.getEndTime()), ZoneId.systemDefault()));
            }
            list1.setModel(new AbstractListModel() {

                @Override
                public int getSize() {
                    return values.length;
                }

                @Override
                public Object getElementAt(int index) {
                    return values[index];
                }
            });
        }

        insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FilmScheduleInsert();
                jFrame.dispose();
            }
        });
        udpate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(updateId.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "修改编号不能为空");
                }
                new FilmScheduleUpdate(Integer.parseInt(updateId.getText()));
                jFrame.dispose();
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(deleteId.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "删除编号不能为空");
                }
                new FilmScheduleDaoImpl().delete(Integer.parseInt(deleteId.getText()));
                jFrame.dispose();
                new FilmScheduleHomePage();
            }
        });

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setSize(600,400);
        jFrame.setLocationRelativeTo(jFrame.getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane scrollPane1;
    private JList list1;
    private JButton insert;
    private JLabel label1;
    private JButton udpate;
    private JButton button1;
    private JLabel label3;
    private JTextField updateId;
    private JTextField deleteId;
    private JFrame jFrame;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String args[]){
        new FilmScheduleHomePage();
    }
}
