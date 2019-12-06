
import java.awt.Font;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Rodas
 */
public class GameStage extends javax.swing.JFrame
{
    private AddPlayerNames addPlayers = new AddPlayerNames();
    ArrayList <String> temp = new ArrayList <>();
    String[] pids;
    Game game;
    ArrayList<JButton> cardButtons = new ArrayList<JButton>();
    ArrayList<String> cardIds;
    PopUp window;
    
    /**
     *
     */
    public GameStage(){}
            
    /**
     *
     * @param playerIds
     */
    public GameStage(ArrayList<String> playerIds)
    {
        initComponents();
        temp = playerIds; //uses the array passed from the AddPlayerNames class and assigns it to a temporary ArrayList
        pids = temp.toArray(new String[temp.size()]);//arraylist to a String array
        game = new Game(pids);
        populateArrayList();
        game.start(game);
        setPidName(); //this must be after the game is initialized becuase we set the pid's name with the game object
        topCardButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unogui/uno_assets_2d/PNGs/small/" + game.getTopCardImage())));
        setButtonIcons();
    }
    
    /**
     * pre-condition: none
     * post-condition: none
     * activity: sets the icons of the Uno cards at the bottom of the screen
     */
    public void setButtonIcons()
    {
        String listString = game.getPlayerHand(game.getCurrentPlayer()).stream().map(Object::toString).collect(Collectors.joining(",")); //turns the array of uno cards into a single string
        String[] cardNames = listString.split(","); //turns the String into an array of Strings
        cardIds = new ArrayList<>(Arrays.asList(cardNames)); //turns the array of strings into an arraylist of strings
        for(int i = 0; i < cardIds.size(); i++)
        {
            cardButtons.get(i).setIcon(new javax.swing.ImageIcon(getClass().getResource("/unogui/uno_assets_2d/PNGs/small/" + cardIds.get(i) + ".png"))); //sets all the card icons that are in the player's hand
        }
        
        for(int i = cardIds.size(); i < cardButtons.size(); i++) //sets all the card icons to null if they aren't in the player's hand
        {
            cardButtons.get(i).setIcon(null);
        }
        
    }
    
    /**
     * pre-condition: none
     * post-condition: none
     * activity: adds elements to my cardButtons ArrayList. 
     */
    public void populateArrayList()
    {
        //the button names at the bottom start at jbutton2 and go to 14
        cardButtons.add(jButton2);
        cardButtons.add(jButton3);
        cardButtons.add(jButton4);
        cardButtons.add(jButton5);
        cardButtons.add(jButton6);
        cardButtons.add(jButton7);
        cardButtons.add(jButton8);
        cardButtons.add(jButton9);
        cardButtons.add(jButton10);
        cardButtons.add(jButton11);
        cardButtons.add(jButton12);
        cardButtons.add(jButton13);
        cardButtons.add(jButton14);
        cardButtons.add(jButton15);
        cardButtons.add(jButton16);
        cardButtons.add(jButton17);
        cardButtons.add(jButton18);
    }
    
    /**
     * pre-condition: none
     * post-condition: none
     * activity: sets the name in the gamestage to be the current player's name.
     */
    public void setPidName()
    {
        String currentPlayer = game.getCurrentPlayer();
        pidNameLabel.setText(currentPlayer + "'s Cards");
    }
    
    /**
     * pre-condition: none
     * post-condition: none
     * activity: sets the name in the gamestage to be the parameter.
     * @param currentPlayer
     */
    public void setPidName(String currentPlayer)
    {
        pidNameLabel.setText(currentPlayer + "'s Cards");
    }
     
     /**
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

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        deckButton = new javax.swing.JButton();
        topCardButton = new javax.swing.JButton();
        pidNameLabel = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        drawCardButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Uno");
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        jPanel1.setMaximumSize(new java.awt.Dimension(1920, 1080));
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 1080));

        deckButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unogui/uno_assets_2d/PNGs/small/Card_Back.png"))); // NOI18N
        deckButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                deckButtonActionPerformed(evt);
            }
        });

        pidNameLabel.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        pidNameLabel.setText("pid's name");

        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton14ActionPerformed(evt);
            }
        });

        drawCardButton.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        drawCardButton.setText("Draw Card");
        drawCardButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                drawCardButtonActionPerformed(evt);
            }
        });

        jButton15.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(pidNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(989, 989, 989)
                            .addComponent(drawCardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(deckButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(topCardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1882, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(topCardButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deckButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(508, 508, 508)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pidNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(drawCardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1322, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addGap(1650, 1650, 1650))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     /**
     * pre-condition: none
     * post-condition: none
     * activity: submits a draw to the Game class.
     */
    private void drawCardButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_drawCardButtonActionPerformed
    {//GEN-HEADEREND:event_drawCardButtonActionPerformed
        try
        {
            buttonMusic();
        } catch (IOException ex)
        {
            Logger.getLogger(GameStage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JLabel message = new JLabel(game.getCurrentPlayer() + " drew a card! ");
        message.setFont(new Font("Arial", Font.BOLD, 48));
        JOptionPane.showMessageDialog(null, message);
        try
        {
            game.submitDraw(game.getCurrentPlayer());
        } catch (InvalidPlayerTurnException ex)
        {
            Logger.getLogger(GameStage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.setPidName(game.getCurrentPlayer());
        this.setButtonIcons();
    }//GEN-LAST:event_drawCardButtonActionPerformed

     /**
     * pre-condition: none
     * post-condition: none
     * activity: Used just as a picture for an Uno card in the top left of the screen
     */
    private void deckButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deckButtonActionPerformed
    {//GEN-HEADEREND:event_deckButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deckButtonActionPerformed

     /**
     * pre-condition: ActionEvent
     * post-condition: none
     * activity: All of these methods below stores the card that matches the icon that the user clicks in the gamestage
     * in a String called cardId and creates a pop up window with it.
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
        try
        {
            buttonMusic();
        } catch (IOException ex)
        {
            Logger.getLogger(GameStage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(cardIds.get(1) != null)
        {
            int index = 1;
            String cardId = cardIds.get(1);
            window = new PopUp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750,40,700,800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
        try
        {
            buttonMusic();
        } catch (IOException ex)
        {
            Logger.getLogger(GameStage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(cardIds.get(0) != null)
        {
            int index = 0;
            String cardId = cardIds.get(0);
            window = new PopUp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750,40,700,800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton4ActionPerformed
    {//GEN-HEADEREND:event_jButton4ActionPerformed
        try
        {
            buttonMusic();
        } catch (IOException ex)
        {
            Logger.getLogger(GameStage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(cardIds.get(2) != null)
        {
            int index = 2;
            String cardId = cardIds.get(2);
            window = new PopUp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750,40,700,800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton5ActionPerformed
    {//GEN-HEADEREND:event_jButton5ActionPerformed
        try
        {
            buttonMusic();
        } catch (IOException ex)
        {
            Logger.getLogger(GameStage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(cardIds.get(3) != null)
        {
            int index = 3;
            String cardId = cardIds.get(3);
            window = new PopUp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750,40,700,800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton6ActionPerformed
    {//GEN-HEADEREND:event_jButton6ActionPerformed
        try
        {
            buttonMusic();
        } catch (IOException ex)
        {
            Logger.getLogger(GameStage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(cardIds.get(4) != null)
        {
            int index = 4;
            String cardId = cardIds.get(4);
            window = new PopUp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750,40,700,800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton7ActionPerformed
    {//GEN-HEADEREND:event_jButton7ActionPerformed
        try
        {
            buttonMusic();
        } catch (IOException ex)
        {
            Logger.getLogger(GameStage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(cardIds.get(5) != null)
        {
            int index = 5;
            String cardId = cardIds.get(5);
            window = new PopUp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750,40,700,800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton8ActionPerformed
    {//GEN-HEADEREND:event_jButton8ActionPerformed
        try
        {
            buttonMusic();
        } catch (IOException ex)
        {
            Logger.getLogger(GameStage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(cardIds.get(6) != null)
        {
            int index = 6;
            String cardId = cardIds.get(6);
            window = new PopUp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750,40,700,800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton9ActionPerformed
    {//GEN-HEADEREND:event_jButton9ActionPerformed
        try
        {
            buttonMusic();
        } catch (IOException ex)
        {
            Logger.getLogger(GameStage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(cardIds.get(7) != null)
        {
            int index = 7;
            String cardId = cardIds.get(7);
            window = new PopUp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750,40,700,800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton10ActionPerformed
    {//GEN-HEADEREND:event_jButton10ActionPerformed
        try
        {
            buttonMusic();
        } catch (IOException ex)
        {
            Logger.getLogger(GameStage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(cardIds.get(8) != null)
        {
            int index = 8;
            String cardId = cardIds.get(8);
            window = new PopUp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750,40,700,800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton11ActionPerformed
    {//GEN-HEADEREND:event_jButton11ActionPerformed
        try
        {
            buttonMusic();
        } catch (IOException ex)
        {
            Logger.getLogger(GameStage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(cardIds.get(9) != null)
        {
            int index = 9;
            String cardId = cardIds.get(9);
            window = new PopUp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750,40,700,800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton12ActionPerformed
    {//GEN-HEADEREND:event_jButton12ActionPerformed
        try
        {
            buttonMusic();
        } catch (IOException ex)
        {
            Logger.getLogger(GameStage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(cardIds.get(10) != null)
        {
            int index = 10;
            String cardId = cardIds.get(10);
            window = new PopUp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750,40,700,800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton13ActionPerformed
    {//GEN-HEADEREND:event_jButton13ActionPerformed
        try
        {
            buttonMusic();
        } catch (IOException ex)
        {
            Logger.getLogger(GameStage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(cardIds.get(11) != null)
        {
            int index = 11;
            String cardId = cardIds.get(11);
            window = new PopUp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750,40,700,800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton14ActionPerformed
    {//GEN-HEADEREND:event_jButton14ActionPerformed
        try
        {
            buttonMusic();
        } catch (IOException ex)
        {
            Logger.getLogger(GameStage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(cardIds.get(12) != null)
        {
            int index = 12;
            String cardId = cardIds.get(12);
            window = new PopUp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750,40,700,800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton15ActionPerformed
    {//GEN-HEADEREND:event_jButton15ActionPerformed
        try
        {
            buttonMusic();
        } catch (IOException ex)
        {
            Logger.getLogger(GameStage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(cardIds.get(13) != null)
        {
            int index = 13;
            String cardId = cardIds.get(13);
            window = new PopUp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750,40,700,800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton16ActionPerformed
    {//GEN-HEADEREND:event_jButton16ActionPerformed
        try
        {
            buttonMusic();
        } catch (IOException ex)
        {
            Logger.getLogger(GameStage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(cardIds.get(14) != null)
        {
            int index = 14;
            String cardId = cardIds.get(14);
            window = new PopUp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750,40,700,800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton17ActionPerformed
    {//GEN-HEADEREND:event_jButton17ActionPerformed
        try
        {
            buttonMusic();
        } catch (IOException ex)
        {
            Logger.getLogger(GameStage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(cardIds.get(15) != null)
        {
            int index = 15;
            String cardId = cardIds.get(15);
            window = new PopUp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750,40,700,800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton18ActionPerformed
    {//GEN-HEADEREND:event_jButton18ActionPerformed
        try
        {
            buttonMusic();
        } catch (IOException ex)
        {
            Logger.getLogger(GameStage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(cardIds.get(16) != null)
        {
            int index = 16;
            String cardId = cardIds.get(16);
            window = new PopUp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750,40,700,800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    /**
     * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(GameStage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(GameStage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(GameStage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(GameStage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new GameStage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deckButton;
    private javax.swing.JButton drawCardButton;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel pidNameLabel;
    private javax.swing.JButton topCardButton;
    // End of variables declaration//GEN-END:variables
}
