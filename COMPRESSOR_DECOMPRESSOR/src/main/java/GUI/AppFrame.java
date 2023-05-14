/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import comp_decomp.compressor;
import comp_decomp.decompressor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author hi
 */
public class AppFrame extends JFrame implements ActionListener{
    JButton compressButton;
    JButton decompressButton;
    
    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
       // frame.setLayout(null);
        
        compressButton=new JButton("Select file to compress");
        compressButton.setBounds(110,100 , 180, 23);
        compressButton.setBackground(Color.WHITE);
        compressButton.setForeground(Color.RED);
        compressButton.addActionListener(this);
        
        decompressButton=new JButton("Select file to decompress");
        decompressButton.setBounds(380, 100, 180, 23);
        decompressButton.setBackground(Color.WHITE);
        decompressButton.setForeground(Color.RED);
        decompressButton.addActionListener(this);
        
        this.setLayout(null);
        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(650,450);
        this.getContentPane().setBackground(Color.blue);
        
        this.setVisible(true);
    }
   
    
    @Override
    public void actionPerformed(ActionEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    if(e.getSource()==compressButton){
        JFileChooser filechooser=new JFileChooser();
        int response=filechooser.showSaveDialog(null);
        if(response==JFileChooser.APPROVE_OPTION){
            File file=new File(filechooser.getSelectedFile().getAbsolutePath());
            System.out.print(file);
            try{
                compressor.method(file);
            }catch(Exception ee){
                JOptionPane.showMessageDialog(null,ee.toString());
            }
        }
    }
    if(e.getSource()==decompressButton){
        JFileChooser filechooser=new JFileChooser();
        int response=filechooser.showSaveDialog(null);
        if(response==JFileChooser.APPROVE_OPTION){
            File file=new File(filechooser.getSelectedFile().getAbsolutePath());
            System.out.print(file);
            try{
                decompressor.method(file);
            }catch(Exception ee){
                JOptionPane.showMessageDialog(null,ee.toString());
            }
        }
    }
    }
    
}
