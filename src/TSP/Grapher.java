
package TSP;

/**
 *
 * Drew McDermott
 * adm75@pitt.edu
 */
import java.util.ArrayList;
import java.awt.*;
import javax.swing.* ;

public class Grapher extends JPanel
{
        public int POINT_SIZE = 10; 
        
       ArrayList<GraphVertex> verts = new ArrayList<GraphVertex>();
       public Grapher(ArrayList<GraphVertex> vertices)
        {
            verts = vertices;
        }

    
      public void paintComponent(Graphics g) 
      {
            super.paintComponent(g) ;
            
            g.setColor(Color.white);
            g.fillRect(0, 0,this.getWidth(), this.getHeight() );
            
            //Graph MST
            MinSpanTree mst = new MinSpanTree(verts);
            mst.generateTree();
            graphMST(g);
            
            //Graph TSP
            
            
            //Graph points (Last)
            g.setColor(Color.blue);
            for(GraphVertex gv : verts)
            {
                Point p = gv.getLocation();
                g.drawOval(p.x - POINT_SIZE/2,p.y-POINT_SIZE/2 ,POINT_SIZE ,POINT_SIZE );
                
            }
    
      }
      
      private void graphMST(Graphics g)
      {
          g.setColor(Color.black);
          for(GraphVertex gv : verts)
          {
               gv.Marked = false;   
          }
          graphDFS(g, verts.get(0));
      }
      private void graphDFS(Graphics g, GraphVertex par)
      {
          par.Marked = true;
          for(GraphVertex gv : par.getConnected())
          {
              if(!gv.Marked)
              {
                  g.drawLine(par.getLocation().x, par.getLocation().y, gv.getLocation().x, gv.getLocation().y);
                  graphDFS(g, gv);
              }
          }
          
      }
}
