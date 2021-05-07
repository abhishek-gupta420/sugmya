/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sugmya.view.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sugmya.entities.Company;
import com.sugmya.service.CompanyService;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

@Component
public class Compdetail extends javax.swing.JFrame {

    
	@Autowired
	private CompanyView companyView;
	
	@Autowired 
	private CompanyService companyService;
	
    public Compdetail() {
    	addWindowFocusListener(new WindowFocusListener() {
    		public void windowGainedFocus(WindowEvent e) {
    			load();
    		}
    		public void windowLostFocus(WindowEvent e) {
    		}
    	});
        initComponents();
    }

    public void load() {
    	
    	System.out.println("------------------------------------------");
    	Company company = companyService.findById(1);
    	cNameTxt.setText(company.getName());
    	businessTypeTxt.setText(company.getBusinessType());
    	stateTxt.setText(company.getState());
    	cityTxt.setText(company.getCity());
    	disttTxt.setText(company.getDistt());
    	poTxt.setText(company.getPostOffice());
    	tehsilTxt.setText(company.getTehsil());
    	pincodeTxt.setText(company.getPincode());
    	contactTxt.setText(company.getContact());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel23 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cNameTxt = new javax.swing.JLabel();
        businessTypeTxt = new javax.swing.JLabel();
        cityTxt = new javax.swing.JLabel();
        poTxt = new javax.swing.JLabel();
        tehsilTxt = new javax.swing.JLabel();
        disttTxt = new javax.swing.JLabel();
        stateTxt = new javax.swing.JLabel();
        pincodeTxt = new javax.swing.JLabel();
        contactTxt = new javax.swing.JLabel();

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setText("Company Name ");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Company Name ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Business Type    ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("C i t y                   ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Post Office          ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("T e h s i l             ");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("D i s t r i c t");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("S t a t e");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("P I N    CODE");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Contact Number ");

        jLabel13.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel13.setText(":-");

        jLabel14.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel14.setText(":-");

        jLabel15.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel15.setText(":-");

        jLabel16.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel16.setText(":-");

        jLabel17.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel17.setText(":-");

        jLabel18.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel18.setText(":-");

        jLabel19.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel19.setText(":-");

        jLabel20.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel20.setText(":-");

        jLabel21.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel21.setText(":-");

        cNameTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cNameTxt.setText("-----------------");

        businessTypeTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        businessTypeTxt.setText("-----------------");

        cityTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cityTxt.setText("---------------- ");

        poTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        poTxt.setText("-----------------");

        tehsilTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tehsilTxt.setText("-----------------");

        disttTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        disttTxt.setText("----------------");

        stateTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        stateTxt.setText("----------------");

        pincodeTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pincodeTxt.setText("------------");

        contactTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        contactTxt.setText("--------------");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(jLabel5)
        						.addComponent(jLabel7)
        						.addComponent(jLabel11, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jLabel12, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jLabel9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jLabel10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jLabel8, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
        					.addGap(18)
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(jPanel2Layout.createSequentialGroup()
        							.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(jLabel18)
        								.addComponent(jLabel19)
        								.addComponent(jLabel20)
        								.addComponent(jLabel21)
        								.addComponent(jLabel14)
        								.addComponent(jLabel16)
        								.addComponent(jLabel17))
        							.addGap(62)
        							.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(businessTypeTxt, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
        								.addComponent(poTxt, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
        								.addComponent(tehsilTxt, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
        								.addComponent(disttTxt, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
        								.addComponent(stateTxt, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
        								.addComponent(pincodeTxt, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
        								.addComponent(contactTxt, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)))
        						.addGroup(jPanel2Layout.createSequentialGroup()
        							.addComponent(jLabel13)
        							.addGap(62)
        							.addComponent(cNameTxt, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)))
        					.addGap(26))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addComponent(jLabel6)
        					.addGap(18)
        					.addComponent(jLabel15)
        					.addGap(62)
        					.addComponent(cityTxt, GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
        					.addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2)
        				.addComponent(jLabel13)
        				.addComponent(cNameTxt))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel5)
        				.addComponent(jLabel14)
        				.addComponent(businessTypeTxt))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel6)
        				.addComponent(jLabel15)
        				.addComponent(cityTxt))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel7)
        				.addComponent(jLabel16)
        				.addComponent(poTxt))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(tehsilTxt)
        				.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        					.addGroup(jPanel2Layout.createSequentialGroup()
        						.addComponent(jLabel8)
        						.addGap(13))
        					.addGroup(jPanel2Layout.createSequentialGroup()
        						.addComponent(jLabel17)
        						.addPreferredGap(ComponentPlacement.RELATED))))
        			.addGap(6)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel9)
        				.addComponent(jLabel18)
        				.addComponent(disttTxt))
        			.addGap(18)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel10)
        				.addComponent(jLabel19)
        				.addComponent(stateTxt))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel11)
        				.addComponent(jLabel20)
        				.addComponent(pincodeTxt))
        			.addGap(18)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel12)
        				.addComponent(jLabel21)
        				.addComponent(contactTxt))
        			.addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel2.setLayout(jPanel2Layout);
        
        JLabel label = new JLabel();
        label.setText("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        
        JLabel lblCompanyDetails = new JLabel();
        lblCompanyDetails.setText("Company Details :-");
        lblCompanyDetails.setFont(new Font("Tahoma", Font.BOLD, 18));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(10)
        					.addComponent(lblCompanyDetails, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE))
        				.addComponent(label, GroupLayout.PREFERRED_SIZE, 724, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addComponent(lblCompanyDetails, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        			.addGap(8)
        			.addComponent(label)
        			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 399, GroupLayout.PREFERRED_SIZE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Compdetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compdetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compdetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compdetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compdetail().setVisible(true);
            }
        });
    }
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel cityTxt;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel poTxt;
    private javax.swing.JLabel tehsilTxt;
    private javax.swing.JLabel disttTxt;
    private javax.swing.JLabel stateTxt;
    private javax.swing.JLabel pincodeTxt;
    private javax.swing.JLabel contactTxt;
    private javax.swing.JLabel cNameTxt;
    private javax.swing.JLabel businessTypeTxt;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
}
