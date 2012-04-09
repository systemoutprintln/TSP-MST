
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
       ArrayList<GraphVertex> TSPath;
       public Grapher(ArrayList<GraphVertex> vertices)
        {
            verts = vertices;
            
            MinSpanTree mst = new MinSpanTree(verts);
            mst.generateTree();
            
            TSPath = TSP.generateTSP(verts);
            
            
            
        }

    
      public void paintComponent(Graphics g) 
      {
            super.paintComponent(g) ;
            
            g.setColor(Color.white);
            g.fillRect(0, 0,this.getWidth(), this.getHeight() );
            
           //Graph points
            g.setColor(Color.blue);

            for(GraphVertex gv : verts)
            {
                Point p = gv.getLocation();
                g.drawOval(p.x - POINT_SIZE/2,p.y-POINT_SIZE/2 ,POINT_SIZE ,POINT_SIZE );
                
            }

            
            //Graph TSP
            graphTSP(g);
            
            //Graph MST

            graphMST(g);
            

            
 
            

    
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
      private void graphTSP(Graphics g)
      { 
          Graphics2D g2d = (Graphics2D)g;
          g2d.setStroke(new BasicStroke(4));
          g2d.setColor(new Color(0,0.75f,0,0.5f));
          
          GraphVertex last = verts.get(0);
          boolean first = true;
          for(GraphVertex gv : TSPath)
          {
              if(first) { first = false; continue;}
              
              g2d.drawLine(gv.getLocation().x, gv.getLocation().y, last.getLocation().x, last.getLocation().y);
              
              last = gv;
          }
          g2d.setStroke(new BasicStroke(1));
          
          
      }
      
      
}
