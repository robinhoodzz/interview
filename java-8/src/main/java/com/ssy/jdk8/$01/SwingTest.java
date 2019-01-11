package com.ssy.jdk8.$01;

import javax.swing.*;

/**
 * 匿名内部类 VS lambda表达式
 * Created by robin on 19/1/11.
 */
public class SwingTest {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("My Jframe");
        JButton jbutton = new JButton("My Jbutton");

//        jbutton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Button pressed!");
//            }
//        });
        jbutton.addActionListener(x -> System.out.println("Button pressed!"));

        jFrame.add(jbutton);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
