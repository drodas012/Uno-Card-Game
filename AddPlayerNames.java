import java.awt.Font;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class AddPlayerNames extends javax.swing.JFrame
{

    public ArrayList<String> playerIds;
    public AddPlayerNames()
    {
        initComponents();
        playerIds = new ArrayList<>();
    }
    
     /**
     * pre-condition: none
     * post-condition: String[]
     * activity: returns an array of all the players names.
     */
    public String[] getPids()
    {
        String[] pids = playerIds.toArray(new String[playerIds.size()]);
        return pids;
    }
    
     /**
     * pre-condition: none
     * post-condition: none
     * activity: plays music when a button is clicked.
     */
    public void buttonMusic() throws IOException
    {
        // open the sound file as a Java input stream
    InputStream in = getClass().getResourceAsStream("click.wav");
    
    // create an audiostream from the inputstream
    AudioStream audioStream = new AudioStream(in);
    
    // play the audio clip with the audioplayer class
    AudioPlayer.player.start(audioStream);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        pidTextBox = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pidOneLabel = new javax.swing.JLabel();
        pidTwoLabel = new javax.swing.JLabel();
        pidThreeLabel = new javax.swing.JLabel();
        pidFiveLabel = new javax.swing.JLabel();
        pidSixLabel = new javax.swing.JLabel();
        pidSevenLabel = new javax.swing.JLabel();
        pidFourLabel = new javax.swing.JLabel();
        pidEightLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Uno");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Add the names of the players");

        pidTextBox.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        pidTextBox.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                pidTextBoxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Name of the player:");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unogui/res/save.png"))); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unogui/res/job.png"))); // NOI18N
        jButton2.setText("Done");
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });

        pidOneLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        pidTwoLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        pidThreeLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        pidFiveLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        pidSixLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        pidSevenLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        pidFourLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        pidEightLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jButton1)
                        .addGap(193, 193, 193)
                        .addComponent(jButton2)))
                .addContainerGap(208, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(pidTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pidFourLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                            .addComponent(pidOneLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pidTwoLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pidThreeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pidFiveLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                                .addComponent(pidSixLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pidSevenLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(pidEightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pidTextBox))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pidOneLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pidFiveLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pidTwoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pidSixLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pidSevenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pidEightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pidThreeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(pidFourLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pidTextBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_pidTextBoxActionPerformed
    {//GEN-HEADEREND:event_pidTextBoxActionPerformed
        
    }//GEN-LAST:event_pidTextBoxActionPerformed

     /**
     * pre-condition: ActionEvent
     * post-condition: none
     * activity: saves the players names and displays them.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        try
        {
            buttonMusic();
        } catch (IOException ex)
        {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(pidTextBox.getText().isEmpty())
        {
            JLabel message = new JLabel("Please enter in a name! ");
            message.setFont(new Font("Arial", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message);
        }
        else
        { 
            String name = pidTextBox.getText().trim();
            playerIds.add(name);
            
            if(playerIds.size() == 1)
            pidOneLabel.setText(playerIds.get(0));
            
            else if(playerIds.size() == 2)
            {
                 pidOneLabel.setText(playerIds.get(0));
                 pidTwoLabel.setText(playerIds.get(1));
            }
             else if(playerIds.size() == 3)
            {
                 pidOneLabel.setText(playerIds.get(0));
                 pidTwoLabel.setText(playerIds.get(1));
                 pidThreeLabel.setText(playerIds.get(2));
            }
             else if(playerIds.size() == 4)
            {
                 pidOneLabel.setText(playerIds.get(0));
                 pidTwoLabel.setText(playerIds.get(1));
                 pidThreeLabel.setText(playerIds.get(2));
                 pidFourLabel.setText(playerIds.get(3));
            }
             else if(playerIds.size() == 5)
            {
                 pidOneLabel.setText(playerIds.get(0));
                 pidTwoLabel.setText(playerIds.get(1));
                 pidThreeLabel.setText(playerIds.get(2));
                 pidFourLabel.setText(playerIds.get(3));
                pidFiveLabel.setText(playerIds.get(4));
            }
             else if(playerIds.size() == 6)
            {
                 pidOneLabel.setText(playerIds.get(0));
                 pidTwoLabel.setText(playerIds.get(1));
                 pidThreeLabel.setText(playerIds.get(2));
                 pidFourLabel.setText(playerIds.get(3));
                pidFiveLabel.setText(playerIds.get(4));
                pidSixLabel.setText(playerIds.get(5));
            }
             else if(playerIds.size() == 7)
            {
                 pidOneLabel.setText(playerIds.get(0));
                 pidTwoLabel.setText(playerIds.get(1));
                 pidThreeLabel.setText(playerIds.get(2));
                 pidFourLabel.setText(playerIds.get(3));
                 pidFiveLabel.setText(playerIds.get(4));
                 pidSixLabel.setText(playerIds.get(5));
                 pidSevenLabel.setText(playerIds.get(6));
            }
             else if(playerIds.size() == 8)
            {
                 pidOneLabel.setText(playerIds.get(0));
                 pidTwoLabel.setText(playerIds.get(1));
                 pidThreeLabel.setText(playerIds.get(2));
                 pidFourLabel.setText(playerIds.get(3));
                 pidFiveLabel.setText(playerIds.get(4));
                 pidSixLabel.setText(playerIds.get(5));
                 pidSevenLabel.setText(playerIds.get(6));
                 pidEightLabel.setText(playerIds.get(7));
            }
            
             if(playerIds.size() > 0 && playerIds.size() < 9)
            {
                JLabel message = new JLabel("Successful save! ");
                message.setFont(new Font("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message);
                pidTextBox.setText("");
            }
             
            if(playerIds.size() == 9)
            {
                playerIds.remove(name);
                JLabel message = new JLabel("There can only be 2-8 players! ");
                message.setFont(new Font("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message);
                pidTextBox.setText("");
            }
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

     /**
     * pre-condition: ActionEvent
     * post-condition: none
     * activity: checks to see if the numbers of players are valid and if they are it will close this window and set the GameStage to be visble.
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
        try
        {
            buttonMusic();
        } catch (IOException ex)
        {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(playerIds.size() == 1 || playerIds.size() == 0)
        {
                JLabel message = new JLabel("There must be at least 2 players! ");
                message.setFont(new Font("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message);
                pidTextBox.setText("");
        }
        else
        {
        this.dispose();
        new GameStage(playerIds).setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(AddPlayerNames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(AddPlayerNames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(AddPlayerNames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(AddPlayerNames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new AddPlayerNames().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel pidEightLabel;
    private javax.swing.JLabel pidFiveLabel;
    private javax.swing.JLabel pidFourLabel;
    private javax.swing.JLabel pidOneLabel;
    private javax.swing.JLabel pidSevenLabel;
    private javax.swing.JLabel pidSixLabel;
    private javax.swing.JTextField pidTextBox;
    private javax.swing.JLabel pidThreeLabel;
    private javax.swing.JLabel pidTwoLabel;
    // End of variables declaration//GEN-END:variables
}
