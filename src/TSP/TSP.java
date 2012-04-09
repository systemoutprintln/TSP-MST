
package TSP;


import java.util.ArrayList;

/**
 *
 * Drew McDermott
 * adm75@pitt.edu
 */
public class TSP 
{
    //Be sure to generate the MST before calling
    public static ArrayList<GraphVertex> generateTSP(MinSpanTree MST)
      {
          ArrayList<GraphVertex> verts = MST.getVerticies();
          double dist=0;
          ArrayList<GraphVertex> tsp = new ArrayList<GraphVertex>();

          for(GraphVertex gv : verts)
          {
               gv.Marked = false;   
          }
          
          recurTSP(verts.get(0), tsp);
          tsp.add(verts.get(0));
          
          
          
          
          GraphVertex last = verts.get(0);
          boolean first = true;
          for(GraphVertex gv : tsp)
          {
              if(first) { first = false; continue;}
              
              dist += last.distanceTo(gv);

              
              last = gv;
          }
          System.out.println("Distance: " + dist + " px");

          return tsp;
          
      }
      
      private static void recurTSP( GraphVertex par, ArrayList<GraphVertex> tsp)
      {
          par.Marked = true;
          tsp.add(par);
          for(GraphVertex gv : par.getConnected())
          {
              if(!gv.Marked)
              {
                  
                  recurTSP(gv, tsp);
                  
              }
          }
      }

}
