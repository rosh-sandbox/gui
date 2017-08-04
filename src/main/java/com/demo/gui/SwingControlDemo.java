package com.demo.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import javax.swing.*;

public final class SwingControlDemo {

	private JFrame mainFrame;
	private JPanel controlPanel;
	private JLabel headerLable;
	private JLabel statusLable;

	public SwingControlDemo() {
		prepareGui();
	}

	private void prepareGui() {
		mainFrame = new JFrame("Java Swing Examples");
		mainFrame.setSize(400, 400);
		mainFrame.setLayout(new GridBagLayout());

		mainFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.exit(0);
			}
		});

		headerLable = new JLabel("Name", JLabel.CENTER);
		statusLable = new JLabel("Status", JLabel.CENTER);
		statusLable.setSize(350, 100);

		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());

		mainFrame.add(headerLable);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLable);
		mainFrame.setVisible(false);

	}

	public void showLabelDemo() {
		headerLable.setText("Control in action: JLabel");
		JLabel label = new JLabel("", JLabel.CENTER);
		label.setText("Welcome to GUI tutorial");
		label.setOpaque(true);
		label.setBackground(Color.GRAY);
		label.setForeground(Color.WHITE);

		controlPanel.add(label);

		mainFrame.setVisible(true);
	}

	public void showButtonDemo() {
		headerLable.setText("Control in action: Button");
		ImageIcon imageIcon = createImageIcon("java_icon.png", "Java");

		JButton okButton = new JButton("OK", imageIcon);
		JButton javaButton = new JButton("Submit", imageIcon);
		JButton cancelButton = new JButton("Cancel", imageIcon);
		cancelButton.setHorizontalTextPosition(SwingConstants.LEFT);

		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				statusLable.setText("Ok Button Clicked!");
			}
		});

		javaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				statusLable.setText("Submit Button Clicked!");
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				statusLable.setText("Cancle Button Clicked~");
			}
		});

		controlPanel.add(okButton);
		controlPanel.add(javaButton);
		controlPanel.add(cancelButton);

		mainFrame.setVisible(true);
	}

	private ImageIcon createImageIcon(String path, String description) {
		URL imgUrl = this.getClass().getClassLoader().getResource(path);
		if(imgUrl != null) {
			return new ImageIcon(imgUrl, description);
		} else {
			System.err.println("Couldn't find the file : " + path);
			return null;
		}
	}

	
}
