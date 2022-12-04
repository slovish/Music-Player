
package final_project;

import java.io.*;
import javax.swing.*;
import jaco.mp3.player.MP3Player;
import java.util.Arrays;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;



public class Final_project {

    private JFrame jframe;
    private JButton Select_button;
    private JButton next_button;
    private JButton import_button;
    private JButton vol_down_button;
    private JButton vol_up_button;
    private JButton back_button;
    private JLabel gif_label;
    private JLabel songname_label;
    private JLabel volume_label;
    private JList<String> jList1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JToggleButton jToggleButton1;
    
    MP3Player player;
    File songfile;
    String currentDirectory;
    
    
    public Final_project(){
        
        jframe = new JFrame();
        jPanel1 = new JPanel();
        gif_label = new JLabel();
        next_button = new JButton();
        back_button = new JButton();
        songname_label = new JLabel();
        jToggleButton1 = new JToggleButton();
        jPanel2 = new JPanel();
        jScrollPane1 = new JScrollPane();
        
        DefaultListModel model = new DefaultListModel();
        jList1 = new JList<>(model);
        
        Select_button = new JButton();
        import_button = new JButton();
        jPanel3 = new JPanel();
        vol_down_button = new JButton();
        vol_up_button = new JButton();
        volume_label = new JLabel();

        jframe.setTitle("Music Player");
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(29, 6, 48));

        gif_label.setBackground(new java.awt.Color(0, 0, 0));
        gif_label.setForeground(new java.awt.Color(255, 255, 255));
        gif_label.setHorizontalAlignment(SwingConstants.CENTER);
        gif_label.setIcon(new ImageIcon(getClass().getResource(
                "/final_project/images2/image.png"))); // NOI18N

        next_button.setBackground(new java.awt.Color(153, 204, 255));
        next_button.setForeground(new java.awt.Color(0, 51, 102));
        next_button.setIcon(new ImageIcon(getClass().getResource(
                "/final_project/images2/forward-arrows.png"))); // NOI18N
        next_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next_buttonActionPerformed(evt);
            }
        });
        
        back_button.setBackground(new java.awt.Color(153, 204, 255));
        back_button.setForeground(new java.awt.Color(0, 51, 102));
        back_button.setIcon(new ImageIcon(getClass().getResource(
                "/final_project/images2/back-arrows.png"))); // NOI18N
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });

        songname_label.setForeground(new java.awt.Color(153, 204, 255));
        songname_label.setHorizontalAlignment(SwingConstants.CENTER);
        songname_label.setText("SONGNAME");

        jToggleButton1.setBackground(new java.awt.Color(153, 204, 255));
        jToggleButton1.setForeground(new java.awt.Color(0, 51, 102));
        jToggleButton1.setIcon(new ImageIcon(getClass().getResource(
                "/final_project/images2/pause.png"))); // NOI18N
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(         
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(songname_label, GroupLayout.DEFAULT_SIZE, 
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(back_button, 
                                GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jToggleButton1, 
                                GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(next_button, 
                                GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 43, Short.MAX_VALUE)))
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.CENTER,
                    jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(gif_label, 
                        GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))        
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(gif_label, 
                        GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(songname_label)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 
                        14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(
                        GroupLayout.Alignment.BASELINE)
                    .addComponent(next_button, 
                            GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addComponent(back_button, 
                            GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton1, 
                            GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jPanel2.setBackground(new java.awt.Color(29, 6, 48));

        jList1.setBackground(new java.awt.Color(29, 6, 48));
        jList1.setBorder(BorderFactory.createLineBorder(new 
        java.awt.Color(153, 204, 255), 2));
        jList1.setForeground(new java.awt.Color(204, 204, 255));
        
        jScrollPane1.setViewportView(jList1);

        Select_button.setBackground(new java.awt.Color(153, 204, 255));
        Select_button.setForeground(new java.awt.Color(0, 51, 102));
        Select_button.setIcon(new ImageIcon(
                getClass().getResource("/final_project/images2/play_sel.png"))); // NOI18N
        Select_button.setBorder(javax.swing.BorderFactory.createTitledBorder(null, 
                "   PLAY", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
                javax.swing.border.TitledBorder.BOTTOM, 
                new java.awt.Font("Segoe UI", 0, 9), 
                new java.awt.Color(29, 6, 48))); // NOI18N

        Select_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Select_buttonActionPerformed(evt);
            }
        });
        
        import_button.setBackground(new java.awt.Color(153, 204, 255));
        import_button.setForeground(new java.awt.Color(0, 51, 102));
        import_button.setIcon(new ImageIcon(
                getClass().getResource("/final_project/images2/music-folder.png"))); // NOI18N
        import_button.setBorder(javax.swing.BorderFactory.createTitledBorder(null, 
                " IMPORT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
                javax.swing.border.TitledBorder.BOTTOM, 
                new java.awt.Font("Segoe UI", 0, 9), 
                new java.awt.Color(29, 6, 48)));
        import_button.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                String[] listofsongs = import_buttonActionPerformed(evt);
                for ( int i = 0; i < listofsongs.length; i++ )
                {
                model.addElement( listofsongs[i] );
                }
            }
        });
        
        jPanel3.setBackground(new java.awt.Color(29, 6, 48));
        jPanel3.setBorder(BorderFactory.createLineBorder(
                new java.awt.Color(153, 204, 255), 2));

        vol_down_button.setBackground(new java.awt.Color(153, 204, 255));
        vol_down_button.setForeground(new java.awt.Color(0, 51, 102));
        vol_down_button.setIcon(new ImageIcon(getClass().getResource(
                "/final_project/images2/speaker1.png"))); // NOI18N
        vol_down_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vol_down_buttonActionPerformed(evt);
            }
        });

        vol_up_button.setBackground(new java.awt.Color(153, 204, 255));
        vol_up_button.setForeground(new java.awt.Color(0, 51, 102));
        vol_up_button.setIcon(new ImageIcon(getClass().getResource(
                "/final_project/images2/speaker.png"))); // NOI18N
        vol_up_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vol_up_buttonActionPerformed(evt);
            }
        });

        volume_label.setForeground(new java.awt.Color(153, 204, 255));
        volume_label.setHorizontalAlignment(SwingConstants.CENTER);
        volume_label.setText("volume");
        volume_label.setBorder(BorderFactory.createLineBorder(
                new java.awt.Color(153, 204, 255)));

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, 
                    jPanel3Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(
                        GroupLayout.Alignment.LEADING)
                    .addComponent(vol_down_button, 
                            GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 
                            40, GroupLayout.PREFERRED_SIZE)
                    .addComponent(vol_up_button, GroupLayout.Alignment.TRAILING, 
                            GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(volume_label)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.CENTER, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(vol_up_button, GroupLayout.PREFERRED_SIZE, 
                        42, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(volume_label)
                .addGap(8, 8, 8)
                .addComponent(vol_down_button, GroupLayout.PREFERRED_SIZE, 
                        42, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.CENTER, jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(
                        GroupLayout.Alignment.CENTER, false)
                    .addComponent(jPanel3, 
                            GroupLayout.DEFAULT_SIZE, 
                            GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(import_button, 
                            GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                    .addComponent(Select_button, 
                            GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Select_button, 
                                GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(import_button, 
                                GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, 
                                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(jframe.getContentPane());
        jframe.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, 
                    GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 
                    GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, 
                    GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 
                    GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 
                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, 
                        GroupLayout.DEFAULT_SIZE, 
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jframe.pack();
        jframe.setVisible(true);
        player = mp3Player();
    }
    private void vol_up_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        Mixer.Info[] mixers = AudioSystem.getMixerInfo();
        String vol = "";
        int i = 0;
        for(Mixer.Info mixerInfo : mixers){
            Mixer mixer = AudioSystem.getMixer(mixerInfo);
            Line.Info[] lineInfos = mixer.getTargetLineInfo();
            for(Line.Info lineInfo : lineInfos){
                Line line = null;
                boolean opened = true;
                try{
                    line = mixer.getLine(lineInfo);
                    opened = line.isOpen() || line instanceof Clip;
                    if(!opened){
                        line.open();
                    }
                    FloatControl volControl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                    float currentVolume = volControl.getValue();
                    Double volumeToCut = 0.2;
                    float changedCalc = (float) ((float)currentVolume+(double)volumeToCut);
                    volControl.setValue(changedCalc);
                   
                    if (changedCalc > 1)
                    {
                        vol = "100";
                    }
                   if (i==0)
                   {
                       vol = String.valueOf(Math.round(changedCalc*100));
                   }
                    i++;
                }catch (LineUnavailableException lineException){
                }catch (IllegalArgumentException illException){
                }finally{
                    // Close Line If it opened
                    if(line != null && !opened){
                        line.close();
                    }
                }
            }
        }
        volume_label.setText(vol);
    } 
    
    private void vol_down_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        Mixer.Info[] mixers = AudioSystem.getMixerInfo();
        int i =0;
        String vol = "";
        for(Mixer.Info mixerInfo : mixers){
           
            Mixer mixer = AudioSystem.getMixer(mixerInfo);
            
            Line.Info[] lineInfos = mixer.getTargetLineInfo();
            for(Line.Info lineInfo : lineInfos){
                Line line = null;
                boolean opened = true;
                try{
                    line = mixer.getLine(lineInfo);
                    opened = line.isOpen() || line instanceof Clip;
                    // Now Check If Line Is not Opened
                    if(!opened){
                        // Open Line
                        line.open();
                    }
                    FloatControl volControl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                    float currentVolume = volControl.getValue();
                    Double volumeToCut = 0.2;
                    float changedCalc = (float) ((float)currentVolume-(double)volumeToCut);
                    volControl.setValue(changedCalc);
                    if (changedCalc < 0)
                    {
                        vol = "0";
                    }
                    if (i==0)
                    {
                    vol = String.valueOf(Math.round(changedCalc*100));
                    }
                    i++;
                }catch (LineUnavailableException lineException){
                }catch (IllegalArgumentException illException){
                }finally{
                    // Close Line If it opened
                    if(line != null && !opened){
                        line.close();
                    }
                }
            }
        }
        volume_label.setText(vol);
    }
    String fileName;
    private void Select_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        fileName = jList1.getSelectedValue();
        player.stop();
        player = mp3Player();
        int ind = Arrays.binarySearch(files, fileName);
        songname_label.setText(fileName);
        gif_label.setIcon(new ImageIcon(
                getClass().getResource("/final_project/images2/playing.gif"))); // NOI18N

        for (int i =ind;i<files.length;i++)
        {
            songfile = new File(currentDirectory+"\\"+files[i]);
            player.addToPlayList(songfile); 
        }
        player.play();   
        gif_label.setIcon(new ImageIcon(
                getClass().getResource("/final_project/images2/playing.gif"))); // NOI18N

    }
    
                                            
    
    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) { 

    if(jToggleButton1.isSelected())
    {
        player.pause();
        jToggleButton1.setIcon(new ImageIcon(
                getClass().getResource("/final_project/images2/play.png")));
        gif_label.setIcon(new ImageIcon(
                getClass().getResource("/final_project/images2/paused.gif"))); // NOI18N

    }
    else
    {        
        player.play();
        jToggleButton1.setIcon(new ImageIcon(
                getClass().getResource("/final_project/images2/pause.png")));
        gif_label.setIcon(new ImageIcon(
                getClass().getResource("/final_project/images2/playing.gif"))); // NOI18N
       
    }
        
    }                                              
                                           

    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                         
            player.stop();
        player = mp3Player();
        int ind = Arrays.binarySearch(files, fileName);
         if (ind==0){
             ind = files.length;
         }
        for (int i =ind-1;i<files.length;i++)
        {
            songfile = new File(currentDirectory+"\\"+files[i]);
            player.addToPlayList(songfile); 
        }
        fileName = files[ind-1];
        songname_label.setText(fileName);
        player.play();
        gif_label.setIcon(new ImageIcon(
                getClass().getResource("/final_project/images2/playing.gif"))); // NOI18N

           }
    
    private void next_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                         
            player.stop();
        player = mp3Player();
        int ind = Arrays.binarySearch(files, fileName);
        if (ind==files.length-1)
        {
            ind = -1;
        }
        for (int i =ind+1;i<files.length;i++)
        {
            songfile = new File(currentDirectory+"\\"+files[i]);
            player.addToPlayList(songfile); 
        }
        fileName = files[ind+1];
        songname_label.setText(fileName);
        player.play();
        gif_label.setIcon(new ImageIcon(
                getClass().getResource("/final_project/images2/playing.gif"))); // NOI18N

         }
    
    String files[];
    private String[] import_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        
        JFileChooser openFileChooser = new JFileChooser(
                "C:\\Users\\Vishal jha\\Desktop\\final_project");
        openFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if(openFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            currentDirectory = openFileChooser.getSelectedFile().getAbsolutePath();
            File f = new File(currentDirectory);
            files = f.list();

            return files;
        }
        return null;
    }
    
    public static void main(String args[]) {
        
                new Final_project();
  
    }
    private MP3Player mp3Player(){
        MP3Player mp3Player = new MP3Player();
        return mp3Player;
    }
}
