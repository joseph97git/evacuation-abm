import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import javax.swing.*;

/**
 * Base layout of building. 
 * Default Layout: single room, 
 * one door, one agent.
 * 
 * @author Joseph Kim
 * @version 10.22.18
 */
public class Layout extends JPanel implements ActionListener {

    /**
     * Prevent different serial versions.
     */
    private static final long serialVersionUID = 1L;

    private int width;
    private int depth;
    private Timer timer;


    /**
     * Creates a new SingleRoom object.
     * 
     * @param width
     *            The width of the room, if you are
     *            standing in the doorway looking in.
     * @param depth
     *            The depth of the room, if you are
     *            standing in the doorway looking in.
     */
    public Layout(int width, int depth) {
        this.width = width;
        this.depth = depth;
        this.timer = new Timer(5, this);
    }


    /**
     * Runs the single room evacuation.
     */
    public void run() {
        JFrame window = new JFrame("Evacuation ABM");
        window.add(this);
        window.setVisible(true);
        window.setSize(this.width, this.depth);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    /**
     * Paints the environment and
     * everything within it.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g1 = (Graphics2D)g;
        this.create(g1);
        this.timer.start();
    }


    /**
     * Calls parent and every child's
     * paintCompenent method.
     */
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    
    /**
     * Creates the type of layout.
     * 
     *  @param graphics
     */
    public void create(Graphics2D graphics) {
        // single room
        Rectangle2D room = new Rectangle2D.Double(25, 25, this.width - 60,
            this.depth - 80);
        graphics.setPaint(Color.BLACK);
        graphics.draw(room);
        
        // one agent
        Agent agent1 = new Agent(225, 200, 40, 80.0, 1.0);
        graphics.setPaint(Color.BLUE);
        graphics.fill(agent1.person());
    }

}