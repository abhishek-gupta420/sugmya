/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sugmya.view.customer;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sugmya.entities.Customer;
import com.sugmya.service.CustomerService;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 *
 * @author ABU BHAI ENGINEER
 */
@Component
public class Details extends javax.swing.JFrame {

    /**
     * Creates new form Details
     */
	@Autowired
	private CustomerService customerService;
	
	@Autowired 
	private CustomerView customerView;
    public Details() {
    	addWindowListener(new WindowAdapter() {
    		@Override
    		public void windowActivated(WindowEvent e) {
    			load();
    		}
    	});
        initComponents();
    }

    
    void load() {
    	List<Customer> customers = customerService.findAll();
    	DefaultTableModel model = (DefaultTableModel) table.getModel();
    	model.setRowCount(0);
		for (Customer customer : customers) {
			Object rowData[] = new Object[8];
			rowData[0] = customer.getUniqueId();
			rowData[1] = customer.getName();
			rowData[2] = customer.getArea();
			rowData[3] = customer.getPhoneNumber();
			rowData[4] = customer.getAadharCard();
			rowData[5] = customer.getAddress();
			rowData[6] = customer.getRent();
			rowData[7] = customer.getEmail();
			model.addRow(rowData);
		}
		table.setModel(model);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("CUSTOMER DETAILS  :-");

        jLabel3.setText("----------------------------------------------------------");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Id", "Name", "Area", "Mobile No.", "Aadhar No.", "Address", "Rent Per Month", "E-mail"
            }
        ));
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
        			.addGap(0, 822, Short.MAX_VALUE))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        		.addComponent(jScrollPane1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 903, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(8)
        			.addComponent(jLabel1)
        			.addGap(1)
        			.addComponent(jLabel3)
        			.addGap(23)
        			.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(42)
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 977, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
