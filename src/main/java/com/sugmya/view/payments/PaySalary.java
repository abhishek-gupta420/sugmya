package com.sugmya.view.payments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sugmya.entities.Labour;
import com.sugmya.entities.SalaryPaid;
import com.sugmya.service.LabourService;
import com.sugmya.service.SalaryPaidService;
import com.sugmya.view.SugmyaRootFrame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@Component
public class PaySalary extends SugmyaRootFrame {

	@Autowired
	private Payments payments;
	
	@Autowired
	private LabourService labourService;
	
	@Autowired
	private SalaryPaidService salaryPaidService;
	
	private Labour labour;
	
    public PaySalary() {
    	setTitle("Pay Salary");
        initComponents();
    }
    
    private void enableSearchBtn() {
		if(!workerIdTxt.getText().equals("") || !workerMobTxt.getText().equals("")) {
			searchBtn.setEnabled(true);
		}else
			searchBtn.setEnabled(false);
	}
    
    private void enablePayBtn() {
		if(!paidTxt.getText().equals("") && modeBox.getSelectedIndex() > 0) {
			payBtn.setEnabled(true);
		}else
			payBtn.setEnabled(false);
	}
    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jButton7 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        workerIdTxt = new javax.swing.JTextField();
        workerIdTxt.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyReleased(KeyEvent e) {
        		enableSearchBtn();
        	}
        });
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        workerMobTxt = new javax.swing.JTextField();
        workerMobTxt.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyReleased(KeyEvent e) {
        		enableSearchBtn();
        	}
        });
        searchBtn = new javax.swing.JButton();
        panel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        workerNameLbl = new javax.swing.JLabel();
        workerIdLbl = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        workerCatLbl = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        workerMobLbl = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        workerAddLbl = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        payableLbl = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        paidTxt = new javax.swing.JTextField();
        paidTxt.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyReleased(KeyEvent e) {
        		enablePayBtn();
        	}
        });
        payBtn = new javax.swing.JButton();
        payBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		try {
					int amount = Integer.parseInt(paidTxt.getText());
					if(labour != null) {
						SalaryPaid salaryPaid = new SalaryPaid();
						salaryPaid.setPaidAmount(amount);
						salaryPaid.setLabour(labour);
						salaryPaid.setMode(modeBox.getSelectedItem().toString());
						salaryPaidService.createSalaryPaid(salaryPaid);
						labour.setPendingSalary(Integer.parseInt(payableLbl.getText()) - amount);
						labour.setSalaryPaidInCurrentMonth(true);
						labourService.updateLabour(labour);
						JOptionPane.showMessageDialog(null, "Salary pay Successfully");
						clear();
						workerIdTxt.setText("");
						workerMobTxt.setText("");
					}
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Please enter valid Amount");
				}
        	}
        });
        payBtn.setEnabled(false);
        jLabel24 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dateLbl = new javax.swing.JLabel();

        jButton7.setBackground(new java.awt.Color(255, 102, 102));
        jButton7.setText("B A C K ");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel1.setText("Pay Salary  :-");

        jLabel2.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        jButton8.setBackground(new java.awt.Color(255, 102, 102));
        jButton8.setText("B A C K ");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        jLabel3.setText("Enter Worker ID  :-");

        workerIdTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel4.setText("OR ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        jLabel5.setText("Worker Mobile No.  :-");

        workerMobTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        searchBtn.setBackground(new java.awt.Color(153, 153, 255));
        searchBtn.setText("S E A R C H ");
        searchBtn.setEnabled(false);
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        panel.setVisible(false);
        panel.setBackground(new java.awt.Color(0, 204, 204));
        panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel8.setText("Name :-");

        workerNameLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        workerNameLbl.setText("from db");

        workerIdLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        workerIdLbl.setText("from db");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel11.setText("Worker ID :-");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel12.setText("Category   :-");

        workerCatLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        workerCatLbl.setText("from db");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel14.setText("Mobile :-");

        workerMobLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        workerMobLbl.setText("from db");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel16.setText("Address          :-");

        workerAddLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        workerAddLbl.setText("from db");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel18.setText("Payment Mode :-");

        payableLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        payableLbl.setText("from db");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel20.setText("RS. ");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        jLabel21.setText("Only");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        jLabel22.setText("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel23.setText("Amount Paid To Worker :-");

        payBtn.setBackground(new java.awt.Color(51, 51, 255));
        payBtn.setText("P A Y");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel24.setText("Amount Payable :-");
        
        modeBox = new JComboBox<String>();
        modeBox.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		enablePayBtn();
        	}
        });
        modeBox.setModel(new DefaultComboBoxModel<String>(new String[] {"--select mode--", "cash", "online"}));
        
        JLabel lblSalary = new JLabel();
        lblSalary.setText("Salary         :-");
        lblSalary.setFont(new Font("Tahoma", Font.BOLD, 18));
        
        salaryLbl = new JLabel();
        salaryLbl.setText("from db");
        salaryLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        lblPenddingAmount = new JLabel();
        lblPenddingAmount.setText("Pending Salory :-");
        lblPenddingAmount.setFont(new Font("Tahoma", Font.BOLD, 18));
        
        pendingSalLbl = new JLabel();
        pendingSalLbl.setText("from db");
        pendingSalLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));

        javax.swing.GroupLayout gl_panel = new javax.swing.GroupLayout(panel);
        gl_panel.setHorizontalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel.createSequentialGroup()
        					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_panel.createSequentialGroup()
        							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
        								.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jLabel14, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
        							.addGap(46)
        							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
        								.addComponent(workerNameLbl, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
        								.addComponent(workerMobLbl, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
        						.addGroup(gl_panel.createSequentialGroup()
        							.addComponent(lblPenddingAmount)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(pendingSalLbl, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))
        					.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
        					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_panel.createSequentialGroup()
        							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
        								.addGroup(gl_panel.createSequentialGroup()
        									.addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
        									.addGap(18)
        									.addComponent(workerIdLbl, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
        								.addGroup(gl_panel.createSequentialGroup()
        									.addComponent(jLabel16, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
        									.addGap(18)
        									.addComponent(workerAddLbl, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
        							.addPreferredGap(ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
        							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
        								.addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
        								.addComponent(lblSalary))
        							.addGap(67)
        							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
        								.addComponent(workerCatLbl, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
        								.addComponent(salaryLbl, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))
        						.addGroup(gl_panel.createSequentialGroup()
        							.addComponent(jLabel24, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(jLabel20)
        							.addGap(18)
        							.addComponent(payableLbl, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(jLabel21, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))))
        				.addComponent(jLabel22, GroupLayout.DEFAULT_SIZE, 1153, Short.MAX_VALUE)
        				.addGroup(gl_panel.createSequentialGroup()
        					.addComponent(jLabel23, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(paidTxt, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
        					.addGap(34)
        					.addComponent(jLabel18, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(modeBox, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
        					.addGap(75)
        					.addComponent(payBtn, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        gl_panel.setVerticalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addGap(22)
        			.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel8)
        				.addComponent(workerNameLbl)
        				.addComponent(jLabel11)
        				.addComponent(workerIdLbl)
        				.addComponent(jLabel12)
        				.addComponent(workerCatLbl))
        			.addGap(60)
        			.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel14)
        				.addComponent(workerMobLbl)
        				.addComponent(lblSalary, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        				.addComponent(salaryLbl, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel16)
        				.addComponent(workerAddLbl))
        			.addGap(53)
        			.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblPenddingAmount, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        				.addComponent(pendingSalLbl, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel24)
        				.addComponent(jLabel20)
        				.addComponent(payableLbl)
        				.addComponent(jLabel21))
        			.addGap(26)
        			.addComponent(jLabel22)
        			.addGap(46)
        			.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel23)
        				.addComponent(payBtn)
        				.addComponent(jLabel18)
        				.addComponent(modeBox, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        				.addComponent(paidTxt, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(128, Short.MAX_VALUE))
        );
        panel.setLayout(gl_panel);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jLabel6.setText("DATE :-");

        dateLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        dateLbl.setText(new SimpleDateFormat("dd/MM/YYYY").format(new Date()));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(workerIdTxt, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
        							.addGap(34)
        							.addComponent(jLabel4)
        							.addGap(18)
        							.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(workerMobTxt, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
        							.addGap(32)
        							.addComponent(searchBtn, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(dateLbl, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
        							.addGap(0, 0, Short.MAX_VALUE))
        						.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
        					.addGap(197)
        					.addComponent(jButton8, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
        				.addGroup(Alignment.LEADING, jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
        					.addComponent(jLabel2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addGroup(Alignment.LEADING, jPanel1Layout.createSequentialGroup()
        						.addGap(65)
        						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1175, GroupLayout.PREFERRED_SIZE))))
        			.addContainerGap(186, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jLabel1)
        				.addComponent(jButton8))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jLabel2)
        			.addGap(20)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel3)
        				.addComponent(workerIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel4)
        				.addComponent(jLabel5)
        				.addComponent(workerMobTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(searchBtn)
        				.addComponent(jLabel6)
        				.addComponent(dateLbl))
        			.addGap(18)
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 446, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(194, Short.MAX_VALUE))
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
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
    	
    	int i = 0;
    	if(!workerIdTxt.getText().equals("")) {
    		try {
    			labour = labourService.findById(Integer.parseInt(workerIdTxt.getText()));
			} catch (NumberFormatException e) {
			}
    		i = 1;
    	}else if(!workerMobTxt.getText().equals("")){
    		labour = labourService.findByMobile(workerMobTxt.getText());
    		i = 2;
    	}
    	if(labour != null) {
    		workerIdLbl.setText(labour.getId()+"");
    		workerNameLbl.setText(labour.getName());
    		workerIdTxt.setText(labour.getId()+"");
    		workerMobTxt.setText(labour.getPhone());
    		workerMobLbl.setText(labour.getPhone());
    		workerCatLbl.setText(labour.getCategory());
    		workerAddLbl.setText(labour.getAddress());
    		salaryLbl.setText(labour.getSalary()+"");
    		pendingSalLbl.setText(labour.getPendingSalary()+"");
    		if(labour.isSalaryPaidInCurrentMonth())
    			payableLbl.setText(labour.getPendingSalary() + "");
    		else
    			payableLbl.setText(labour.getPendingSalary() + labour.getSalary() + "");
    		panel.setVisible(true);
    	}else {
    		clear();
    		if(i == 1) {
    			workerMobTxt.setText("");
    		}else if(i == 2)
    			workerIdTxt.setText("");
    		JOptionPane.showMessageDialog(this, "Worker not found");
    	}
    }

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
    	
    	payments.setVisible(true);
    	super.setVisible(false);
    }
    
    private void clear() {
    	workerIdLbl.setText("");
		workerNameLbl.setText("");
		workerMobLbl.setText("");
		workerCatLbl.setText("");
		workerAddLbl.setText("");
		salaryLbl.setText("");
		pendingSalLbl.setText("");
		payableLbl.setText("");
		paidTxt.setText("");
		modeBox.setSelectedIndex(0);
		payBtn.setEnabled(false);
		panel.setVisible(false);
		labour = null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http:
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PayBills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PayBills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PayBills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PayBills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PayBills().setVisible(true);
            }
        });
    }

    
    private javax.swing.JButton payBtn;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton searchBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel workerIdLbl;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel workerCatLbl;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel workerMobLbl;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel workerAddLbl;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel payableLbl;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel workerNameLbl;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField workerIdTxt;
    private javax.swing.JTextField workerMobTxt;
    private javax.swing.JTextField paidTxt;
    private javax.swing.JComboBox<String> modeBox;
    private JLabel salaryLbl;
    private JLabel lblPenddingAmount;
    private JLabel pendingSalLbl;
}
