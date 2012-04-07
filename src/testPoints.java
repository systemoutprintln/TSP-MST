
import javax.swing.JFrame;


/**
 *
 * Drew McDermott
 * adm75@pitt.edu
 */

import java.awt.* ;
import javax.swing.* ;
import java.util.ArrayList;
import TSP.*;

public class testPoints {

    public static void main(String[] args) 
    {
         JFrame graph = new JFrame("Map");
         
         ArrayList<GraphVertex> points = new ArrayList<GraphVertex>();
         
         points.add(new GraphVertex(10,10));
         points.add(new GraphVertex(490,10));
         points.add(new GraphVertex(490,490));
         points.add(new GraphVertex(10,490));
         
         points.add(new GraphVertex(100,390));
         
         Grapher plot = new Grapher(points);
         
         // Finish up
         
        Dimension d = new Dimension(600, 600);
        
        graph.setPreferredSize(d);
        graph.getContentPane().add(plot);
        graph.pack();
        graph.setVisible(true);
         
    }

}
