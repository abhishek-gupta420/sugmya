package com.sugmya.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SugmyaRootFrame extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SugmyaRootFrame frame = new SugmyaRootFrame();
					 
					//frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SugmyaRootFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("Sugmya");
		setIconImage(toolkit.getImage(SugmyaRootFrame.class.getResource("/com/sugmya/view/icon.png")));
	}
}
