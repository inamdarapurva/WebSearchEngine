package project;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JApplet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



/**
 *
 * @author APURVA
 */
public class GUI extends JApplet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    MasterControl mc =new MasterControl();
    public void init() {
        // TODO start asynchronous download of heavon?(y resources
        JLabel Label1 = new JLabel("Input");
        JLabel Label2= new JLabel("Output");
        final JTextArea Area1= new JTextArea();
        final JTextArea Area2= new JTextArea();
        JButton Button= new JButton("OK");
        JScrollPane Pane1= new JScrollPane();
        JScrollPane Pane2= new JScrollPane();
       Pane1.setViewportView(Area1);
        Area1.setColumns(5);
        Area1.setRows(2);
                
       Pane2.setViewportView(Area2);
        Area2.setColumns(5);
        Area2.setRows(2);
        GroupLayout layout = new GroupLayout(getContentPane());
getContentPane().setLayout(layout);
layout.setAutoCreateGaps(true);
layout.setAutoCreateContainerGaps(true);

layout.setHorizontalGroup(layout.createSequentialGroup()
    .addComponent(Label1)
     .addComponent(Label2)
    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(Pane1)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(Pane2))))
                
            
    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(Button)));
layout.linkSize(SwingConstants.HORIZONTAL, Button);


layout.setVerticalGroup(layout.createSequentialGroup()
    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(Label1)
        .addComponent(Pane1)
        .addComponent(Button))
    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(Label2)
                .addComponent(Pane2))))
            
);
        
Button.addActionListener(new ActionListener()
{

            @Override
            public void actionPerformed(ActionEvent ae) {
           // mc.start(Area1, Area2);
            
            }
    




}


);
    }
    

    // TODO overwrite start(), stop() and destroy() methods
}
