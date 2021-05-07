/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sugmya.view.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sugmya.entities.Labour;
import com.sugmya.entities.Tool;
import com.sugmya.entities.ToolAllocated;
import com.sugmya.service.LabourService;
import com.sugmya.service.ToolAllocatedService;
import com.sugmya.service.ToolService;
import com.sugmya.view.SugmyaRootFrame;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.WindowFocusListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;

@Component
public class Allocate extends SugmyaRootFrame {

    @Autowired
    private Stock stock;
    
    @Autowired
    private ToolService toolService;
    
    @Autowired
    private LabourService labourService;
    
    @Autowired
    private ToolAllocatedService toolAllocatedService;
    
    private Labour labour;
    private List<Tool> tools;
    
    public Allocate() {
    	addWindowListener(new WindowAdapter() {
    		@Override
    		public void windowOpened(WindowEvent e) {
    			
    		}
    		@Override
    		public void windowActivated(WindowEvent e) {
    		}
    	});
    	addWindowFocusListener(new WindowFocusListener() {
    		public void windowGainedFocus(WindowEvent e) {
    			
    		}
    		public void windowLostFocus(WindowEvent e) {
    		}
    	});
        initComponents();
    }
    
    public void setVisible(boolean b) {
        super.setVisible(b);
        if(b) {
        	dateLbl.setText(new SimpleDateFormat("EEEE, dd, MMMM  yyyy").format(new Date()));
			tools = toolService.findAll();
			itemList.removeAllItems();
			itemList.setSelectedIndex(-1);
			itemList.addItem("--select item--");
			for (Tool tool : tools) {
				itemList.addItem(tool.getToolName());
			}
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        dateLbl = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        workerIdTxt = new javax.swing.JTextField();
        workerIdTxt.addKeyListener(new KeyAdapter() {
        	
        	@Override
        	public void keyReleased(KeyEvent e) {
        		if(!workerIdTxt.getText().equals("")) {
        			searchBtn.setEnabled(true);
        		}else
        			searchBtn.setEnabled(false);
        	}
        });
        searchBtn = new javax.swing.JButton();
        searchBtn.setEnabled(false);
        nameLbl = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        categoryLbl = new javax.swing.JLabel();
        aadharLbl = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        mobLbl = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        quantityTxt = new javax.swing.JTextField();
        quantityTxt.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyReleased(KeyEvent e) {
        		if(!quantityTxt.getText().equals("")) {
        			saveBtn.setEnabled(true);
        		}else
        			saveBtn.setEnabled(false);
        	}
        });
        quantityTxt.setEditable(false);
        jButton2 = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        saveBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					Tool tool = null;
					int quantity = Integer.parseInt(quantityTxt.getText());
        			String selectedItem = itemList.getSelectedItem().toString();
        			for (Tool temp : tools) {
						if(temp.getToolName().equals(selectedItem)) {
							tool = temp;
							break;
						}
					}
        			if(tool != null && labour != null && quantity > 0) {
        				
        				if(quantity <= tool.getAvailable()) {
        					ToolAllocated toolAllocated = new ToolAllocated();
            				toolAllocated.setLabour(labour);
            				toolAllocated.setTool(tool);
            				toolAllocated.setQuantity(quantity);
            				toolAllocatedService.createToolAllocated(toolAllocated);
            				tool.setAllocated(tool.getAllocated() + quantity);
            				tool.setAvailable(tool.getAvailable() - quantity);
            				toolService.updateTool(tool);
            				JOptionPane.showMessageDialog(null, "Item Allocated Successfully");
            				clear();
        				}else
        					JOptionPane.showMessageDialog(null, "You don't have enough quantity");
        			}else
        				JOptionPane.showMessageDialog(null, "Quantity can't be zero");
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Please enter valid quantity");
				}
        	}
        });
        saveBtn.setEnabled(false);

        jLabel13.setText("jLabel13");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Allocate Stock Items To Workers :-");

        jLabel2.setText("--------------------------------------------------------------------------------");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Date :-");

        dateLbl.setText("System Date");

        jButton7.setBackground(new java.awt.Color(255, 102, 102));
        jButton7.setText("B A C K ");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 381, Short.MAX_VALUE)
        					.addComponent(jButton7, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
        					.addComponent(jLabel15, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(dateLbl, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addComponent(jLabel1)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(jLabel2))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addComponent(jButton7)
        					.addGap(18)
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(dateLbl)
        						.addComponent(jLabel15))))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2.setLayout(jPanel2Layout);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Enter Worker ID :-");

        workerIdTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        searchBtn.setText("S E A R C H ");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        nameLbl.setFont(new java.awt.Font("Tahoma", 0, 14));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Category :-");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Name    :-");

        categoryLbl.setFont(new java.awt.Font("Tahoma", 0, 14));

        aadharLbl.setFont(new java.awt.Font("Tahoma", 0, 14));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Aadhar Number :-");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Mobile No. :-");

        mobLbl.setFont(new java.awt.Font("Tahoma", 0, 14));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Select Item :-");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Quantity :-");

        quantityTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 153, 153));
        jButton2.setText("C a n c e l");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        saveBtn.setBackground(new java.awt.Color(153, 153, 255));
        saveBtn.setText("A L L O C A T E");
        
        itemList = new JComboBox();
        itemList.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		if(itemList.getSelectedIndex() > 0 && !nameLbl.getText().equals("")) {
        			quantityTxt.setEditable(true);
        		}else
        			quantityTxt.setEditable(false);
        	}
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
        								.addComponent(jLabel12, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addComponent(jLabel6, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addComponent(jLabel3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
        								.addComponent(jLabel9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        							.addGap(18)
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        								.addComponent(workerIdTxt, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
        								.addComponent(nameLbl, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
        								.addComponent(aadharLbl, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
        								.addComponent(itemList, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        							.addGap(31)
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(searchBtn, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
        								.addGroup(jPanel1Layout.createSequentialGroup()
        									.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
        										.addComponent(jButton2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        										.addComponent(jLabel14, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        										.addComponent(jLabel10, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
        									.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        										.addGroup(jPanel1Layout.createSequentialGroup()
        											.addGap(6)
        											.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        												.addComponent(quantityTxt, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        												.addComponent(mobLbl, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
        										.addGroup(jPanel1Layout.createSequentialGroup()
        											.addPreferredGap(ComponentPlacement.UNRELATED)
        											.addComponent(saveBtn, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))))
        							.addGap(109)))
        					.addContainerGap())
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(categoryLbl, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
        					.addGap(79))))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(32)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel3)
        				.addComponent(workerIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(searchBtn))
        			.addGap(29)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(nameLbl, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel5)
        				.addComponent(categoryLbl, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel6))
        			.addGap(40)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(aadharLbl, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel10)
        				.addComponent(mobLbl, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel9))
        			.addGap(37)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(jLabel14)
        					.addComponent(quantityTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        					.addComponent(itemList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addComponent(jLabel12)))
        			.addGap(24)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jButton2)
        				.addComponent(saveBtn))
        			.addContainerGap())
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    	try {
			
    		int workerId = Integer.parseInt(workerIdTxt.getText());
    		labour = labourService.findById(workerId);
    		if(labour != null) {
    			nameLbl.setText(labour.getName());
    			categoryLbl.setText(labour.getCategory());
    			aadharLbl.setText(labour.getAadharCard());
    			mobLbl.setText(labour.getPhone());
    		}
    		else {
    			clear();
    			workerIdTxt.setText(workerId+"");
    			searchBtn.setEnabled(true);
    			JOptionPane.showMessageDialog(this, "Worker not Found");
    		}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Please enter valid worker id");
		}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
    	stock.setVisible(true);
    	this.setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    	stock.setVisible(true);
    	this.setVisible(false);
    }
    
    private void clear() {
    	workerIdTxt.setText("");
    	searchBtn.setEnabled(false);
    	nameLbl.setText("");
    	categoryLbl.setText("");
    	aadharLbl.setText("");
    	mobLbl.setText("");
    	categoryLbl.setText("");
    	saveBtn.setEnabled(false);
    	quantityTxt.setText("");
    	quantityTxt.setEditable(false);
    	labour = null;
    	itemList.setSelectedIndex(0);
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Allocate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Allocate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Allocate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Allocate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Allocate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton searchBtn;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel mobLbl;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel categoryLbl;
    private javax.swing.JLabel aadharLbl;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField workerIdTxt;
    private javax.swing.JTextField quantityTxt;
    private JComboBox itemList;
    // End of variables declaration//GEN-END:variables
}