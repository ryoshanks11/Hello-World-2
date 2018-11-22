package guitest;

/**
 *
 * @author Ryan
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SmallGUIFrame extends JFrame {

public boolean play = true;
    
/**
* The constructor
*/

public SmallGUIFrame()
{
    JMenuBar menuBar = new JMenuBar();
    JMenu menuFile = new JMenu();
    JMenuItem menuFileExit = new JMenuItem();
    
    // Add action listener.for the menu button
    menuFileExit.addActionListener
            ( new ActionListener()
                {
                public void actionPerformed(ActionEvent e)
                    {
                    SmallGUIFrame.this.windowClosed();
                    }
                }
            );
    
    menuFile.add(menuFileExit);
    menuBar.add(menuFile);
    menuFile.setText("File");
    menuFileExit.setText("Exit");
    setTitle("TEST");
    setJMenuBar(menuBar);
    setSize(new Dimension(800, 800));
    
    // Add window listener.
    this.addWindowListener
    (
    new WindowAdapter()
        {
        public void windowClosing(WindowEvent e)
            {
                SmallGUIFrame.this.windowClosed();
            }
        }
    );
    
    //adds the Timer
    TimerTest testTimer1 = new TimerTest();
    testTimer1.timer();
    
    //Adds the stop button
    JButton stopButton = new JButton();
    stopButton.setSize(400,400);
    stopButton.setVisible(true);
    stopButton.setText("Stop");
    
    this.add(stopButton, BorderLayout.SOUTH);
    stopButton.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            testTimer1.stopTimer(); //this calls the method to the Timer
            System.out.println(testTimer1.getAmountList());
            //drawGraph(testTimer1.getAmountList());
        }
    });
    
    //adds the Graph Panel to the GUI
    //DrawingPanel centre = new DrawingPanel(testTimer1.getAmountList());
    //getFrameName().add(centre, BorderLayout.CENTER);
    //centre.amount(100,100);
}

public void drawGraph(TimerTest timerRef)
{
    //adds the Graph Panel to the GUI
    DrawingPanel centre = new DrawingPanel(timerRef.getAmountList());
    this.add(centre, BorderLayout.CENTER);
    centre.amount(100,100);
    System.out.println("works");
}

public SmallGUIFrame getFrameName()
{
    return this;
}

public void setPlay(boolean set)
{
    play = false;
}

public boolean getPlay(boolean get)
{
    return play;
}

/* Shutdown procedure when run as an application. */
    protected void windowClosed()
        {
        // TODO: Check if it is safe to close the application
        // Exit application.
        System.exit(0);
        }
}