
import java.awt.Font;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Rodas
 */
public class PickColorFrame extends javax.swing.JFrame
{

    private UnoCard.Color wildColor = null;
    Boolean allow = false;
    PopUp popUp;
    
    /**
     *
     */
    public PickColorFrame()
    {
        initComponents();
    }

    /**
     *
     * @param pop
     */
    public PickColorFrame(PopUp pop){
        initComponents();
        popUp = pop;
    }
    
    /**
     *
     * pre-condition: none
     * post-condition: none
     * activity: plays music when a button is clicked.
     * @throws IOException
     */
    public void buttonMusic() throws IOException
    {
        // open the sound file as a Java input stream
    InputStream in = getClass().getResourceAsStream("softClick.wav");
    
    // create an audiostream from the inputstream
    AudioStream audioStream = new AudioStream(in);
    
    // play the audio clip with the audioplayer class
    AudioPlayer.player.start(audioStream);
    }
    
    /**
     * /**
     * pre-condition: UnoCard
     * post-condition: UnoCard.Color
     * activity: returns the color of the UnoCard
     * @param card
     * @return
     */
    public UnoCard.Color choseColor(UnoCard card)
    {
        if(card.getColor() == UnoCard.Color.Wild)
        {
            this.setVisible(true);
            this.setResizable(false);
            this.setBounds(100,150,600,700);
        }
        return card.getColor();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        redButton = new javax.swing.JButton();
        blueButton = new javax.swing.JButton();
        greenButton = new javax.swing.JButton();
        yellowButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Pick the color of your Wild Card");
        jLabel1.setToolTipText("");

        redButton.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        redButton.setText("Red");
        redButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                redButtonActionPerformed(evt);
            }
        });

        blueButton.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        blueButton.setText("Blue");
        blueButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                blueButtonActionPerformed(evt);
            }
        });

        greenButton.setFont(new java.awt.Font("Tahoma", 0, 44)); // NOI18N
        greenButton.setText("Green");
        greenButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                greenButtonActionPerformed(evt);
            }
        });

        yellowButton.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        yellowButton.setText("Yellow");
        yellowButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                yellowButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(redButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(blueButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(greenButton, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(yellowButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(redButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(blueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(greenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(yellowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

      /**
     * pre-condition: ActionEvent
     * post-condition: none
     * activity: lets the players know the color that has been selected
     */
    private void redButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_redButtonActionPerformed
    {//GEN-HEADEREND:event_redButtonActionPerformed
        try
        {
            buttonMusic();
        } catch (IOException ex)
        {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        wildColor = UnoCard.Color.Red;
        JLabel message = new JLabel("The Wild Card color is Red!");
        message.setFont(new Font("Arial", Font.BOLD, 48));
        JOptionPane.showMessageDialog(null, message);
        allow = true;
        this.dispose();
        popUp.declaredColor = UnoCard.Color.Red; 
        popUp.gameStage.setPidName(popUp.game.getCurrentPlayer());
        popUp.gameStage.setButtonIcons();
        popUp.topCardButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unogui/uno_assets_2d/PNGs/small/" + popUp.game.getTopCardImage())));
        popUp.game.setCardColor(UnoCard.Color.Red);
        popUp.dispose();
    }//GEN-LAST:event_redButtonActionPerformed

      /**
     * pre-condition: ActionEvent
     * post-condition: none
     * activity: lets the players know the color that has been selected
     */
    private void blueButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_blueButtonActionPerformed
    {//GEN-HEADEREND:event_blueButtonActionPerformed
        try
        {
            buttonMusic();
        } catch (IOException ex)
        {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        wildColor = UnoCard.Color.Blue;
        JLabel message = new JLabel("The Wild Card color is Blue!");
        message.setFont(new Font("Arial", Font.BOLD, 48));
        JOptionPane.showMessageDialog(null, message);
        allow = true;
        this.dispose();
        popUp.declaredColor = UnoCard.Color.Blue; 
        popUp.gameStage.setPidName(popUp.game.getCurrentPlayer());
        popUp.gameStage.setButtonIcons();
        popUp.topCardButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unogui/uno_assets_2d/PNGs/small/" + popUp.game.getTopCardImage())));
        popUp.game.setCardColor(UnoCard.Color.Blue);
        popUp.dispose();
    }//GEN-LAST:event_blueButtonActionPerformed

      /**
     * pre-condition: ActionEvent
     * post-condition: none
     * activity: lets the players know the color that has been selected
     */
    private void greenButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_greenButtonActionPerformed
    {//GEN-HEADEREND:event_greenButtonActionPerformed
        try
        {
            buttonMusic();
        } catch (IOException ex)
        {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        wildColor = UnoCard.Color.Green;
        JLabel message = new JLabel("The Wild Card color is Green!");
        message.setFont(new Font("Arial", Font.BOLD, 48));
        JOptionPane.showMessageDialog(null, message);
        allow = true;
        this.dispose();
        popUp.declaredColor = UnoCard.Color.Green; 
        popUp.gameStage.setPidName(popUp.game.getCurrentPlayer());
        popUp.gameStage.setButtonIcons();
        popUp.topCardButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unogui/uno_assets_2d/PNGs/small/" + popUp.game.getTopCardImage())));
        popUp.game.setCardColor(UnoCard.Color.Green);
        popUp.dispose();
    }//GEN-LAST:event_greenButtonActionPerformed

    /**
     * pre-condition: ActionEvent
     * post-condition: none
     * activity: lets the players know the color that has been selected
     */
    private void yellowButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_yellowButtonActionPerformed
    {//GEN-HEADEREND:event_yellowButtonActionPerformed
        try
        {
            buttonMusic();
        } catch (IOException ex)
        {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        wildColor = UnoCard.Color.Yellow;
        JLabel message = new JLabel("The Wild Card color is Yellow!");
        message.setFont(new Font("Arial", Font.BOLD, 48));
        JOptionPane.showMessageDialog(null, message);
        allow = true;
        this.dispose();
        popUp.declaredColor = UnoCard.Color.Blue; 
        popUp.gameStage.setPidName(popUp.game.getCurrentPlayer());
        popUp.gameStage.setButtonIcons();
        popUp.topCardButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unogui/uno_assets_2d/PNGs/small/" + popUp.game.getTopCardImage())));
        popUp.game.setCardColor(UnoCard.Color.Yellow);
        popUp.dispose();
    }//GEN-LAST:event_yellowButtonActionPerformed

    /**
     *
     * @param args
     */
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
            java.util.logging.Logger.getLogger(PickColorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(PickColorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(PickColorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(PickColorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new PickColorFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton blueButton;
    private javax.swing.JButton greenButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton redButton;
    private javax.swing.JButton yellowButton;
    // End of variables declaration//GEN-END:variables
}
