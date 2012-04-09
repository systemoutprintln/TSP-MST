
import TSP.GraphVertex;
import TSP.Grapher;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import java.util.Random;


/**
 *
 * Drew McDermott
 * adm75@pitt.edu
 */
public class randomCities {

    /**
     * @param 1: number of cities, default 20
     */
    public static void main(String[] args) 
    {
        int n = 20;
        if(args.length >= 1)
        {
            n = Integer.parseInt(args[0]);
        }
        
         JFrame graph = new JFrame("Map");
         
         ArrayList<GraphVertex> points = new ArrayList<GraphVertex>();
        
         Random r = new Random();
         
        for(int i = 0; i < n; i++)
        {
            points.add(new GraphVertex(r.nextInt(540) + 10, r.nextInt(540) + 10));
        }
        
                 Grapher plot = new Grapher(points);
         
         // Finish up
         
        Dimension d = new Dimension(600, 600);
        
        graph.setPreferredSize(d);
        graph.getContentPane().add(plot);
        graph.pack();
        graph.setVisible(true);

    }

}
