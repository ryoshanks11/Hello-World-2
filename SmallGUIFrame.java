package guitest;

/**
 *
 * @author Ryan
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SmallGUIFrame extends JFrame 
{
    
    JMenuBar menuBar = new JMenuBar();
    JMenu menuFile = new JMenu();
    JMenuItem menuFileExit = new JMenuItem();
    TimerTest testTimer1 = new TimerTest();
    boolean play = true;

    /**
    * The constructor
    */

    public SmallGUIFrame()
    {
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
        setSize(new Dimension(800,1000));

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
                testTimer1.stopTimer(); //this calls the method to stop the Timer
                System.out.println(testTimer1.getAmountList());
                setPlayFalse();                
            }
        });

        //add graph button
        JButton graphButton = new JButton();
        graphButton.setSize(400,400);
        graphButton.setVisible(true);
        graphButton.setText("Graph");
        this.add(graphButton, BorderLayout.EAST);
        
        graphButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                drawGraph(testTimer1);              
            }
        });
    }

    public void drawGraph(TimerTest timerRef)
    {
        //adds the Graph Panel to the GUI
        DrawingPanel centreGraphing = new DrawingPanel(timerRef.getAmountList());
        this.add(centreGraphing, BorderLayout.CENTER);
        
        //this method allows the graph to appear on click
        this.revalidate();
    }

    public void drawsGraphAfterTimer()
    {
        if ( play = false)
        {
            this.drawGraph(testTimer1);
        }
    }
    
    public TimerTest getTimerRef()
    {
        return testTimer1;
    }

    public SmallGUIFrame getFrameName()
    {
        return this;
    }

    public boolean getPlay()
    {
        return play;
    }
    
    public void setPlayFalse()
    {
        play = false;
    }

    /* Shutdown procedure when run as an application. */
        protected void windowClosed()
            {
            // TODO: Check if it is safe to close the application
            // Exit application.
            System.exit(0);
            }
}