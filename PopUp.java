
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Rodas
 */
public class PopUp extends javax.swing.JFrame
{
    String cardImage = "";
    Game game;
    ArrayList<UnoCard> playerHand;
    int choice;
    ArrayList<JButton> cardButtons;
    GameStage gameStage;
    JButton topCardButton;
    UnoCard.Color declaredColor;
    
    /**
     *
     */
    public PopUp(){}
    
    /**
     *
     * @param cardName
     * @param game
     * @param index
     * @param cardButtons
     * @param gameStage
     * @param topCardButton
     */
    public PopUp(String cardName, Game game, int index, ArrayList<JButton> cardButtons, GameStage gameStage, JButton topCardButton)
    {
        initComponents();
        cardImage = cardName;
        this.game = game;
        playerHand = game.getPlayerHand(game.getCurrentPlayer());
        choice = index;
        this.cardButtons = cardButtons;
        cardLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unogui/uno_assets_2d/PNGs/large/" + cardImage + ".png")));
        this.gameStage = gameStage;
        this.topCardButton = topCardButton;
    }
    
    /**
     * /**
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        useCardButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        cardLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Uno");
        setMaximumSize(new java.awt.Dimension(700, 800));
        setResizable(false);

        useCardButton.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        useCardButton.setText("Use Card");
        useCardButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                useCardButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(useCardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(cardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(101, Short.MAX_VALUE)
                .addComponent(cardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(useCardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * pre-condition: ActionEvent
     * post-condition: none
     * activity: when the used card button is clicked it will submit a player's card
     */
    private void useCardButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_useCardButtonActionPerformed
    {//GEN-HEADEREND:event_useCardButtonActionPerformed
         try
        {
            buttonMusic();
        } catch (IOException ex)
        {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PickColorFrame pickColor = new PickColorFrame(this);
        declaredColor = pickColor.choseColor(playerHand.get(choice));
        
        if(declaredColor != null){
            try
            {
                game.submitPlayerCard(game.getCurrentPlayer(), playerHand.get(choice), declaredColor);
            } catch (InvalidColorSubmissionException ex)
            {
                Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidValueSubmissionException ex)
            {
                Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidPlayerTurnException ex)
            {
                Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.revalidate();
            if(declaredColor != UnoCard.Color.Wild){
                gameStage.setPidName(game.getCurrentPlayer());
                gameStage.setButtonIcons();
                topCardButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unogui/uno_assets_2d/PNGs/small/" + game.getTopCardImage())));
                this.dispose();
            }
        }
    }//GEN-LAST:event_useCardButtonActionPerformed
    
    /**
     * pre-condition: ActionEvent
     * post-condition: none
     * activity: when a player clicks cancel this window will close
     */
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cancelButtonActionPerformed
    {//GEN-HEADEREND:event_cancelButtonActionPerformed
         try
        {
            buttonMusic();
        } catch (IOException ex)
        {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

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
            java.util.logging.Logger.getLogger(PopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(PopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(PopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(PopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new PopUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel cardLabel;
    private javax.swing.JButton useCardButton;
    // End of variables declaration//GEN-END:variables
}
