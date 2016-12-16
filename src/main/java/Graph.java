
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Iterator;
import java.util.LinkedList;


/**
 * Created by ludwighandel on 2016-12-14.
 */
public class Graph {

    public Veredges[] vertexes;

    int numberOfEdges = 0;


    public Graph(String file){

        // Open and read from the file
        JParser jsp = new JParser(file);
        
        // Extract the data object
        JSONArray data = (JSONArray)jsp.data.get("data");
        
        // Update the size of the vertexes
        this.vertexes = new Veredges[data.size()];

        // Loop through the vertxes
        Iterator<JSONObject> iterator = data.iterator();
        while (iterator.hasNext()) {
            JSONObject vertexObject = (JSONObject)iterator.next();

            // Extract vertexInfo object
            JSONObject vertexInfo = (JSONObject)vertexObject.get("vertex");

            // Extract edges object
            JSONArray vertexEdges = (JSONArray)vertexObject.get("edges");

            // cast the vertex-id
            int id = sToInt((Long) vertexInfo.get("id"));

            // Add Veredges-object to vertexes-array
            this.vertexes[id] = new Veredges(vertexInfo,vertexEdges);

            this.numberOfEdges = this.numberOfEdges+vertexEdges.size();
        }


    }

    /*
     * Converts a long to int, if it's possible
     */
    public static int sToInt(long l) {
        if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE) {
            throw new IllegalArgumentException
                    (l + " cannot be cast to int without changing its value.");
        }
        return (int) l;
    }

    public int numberOfVertices(){
        return  this.vertexes.length;
    }

    public Iterator<Edge> adj(int v) {
        return this.vertexes[v].edges.iterator();
    }



    private static class Veredges {

        Vertex vertex;
        LinkedList<Edge> edges;


        private Veredges(JSONObject vertexInfo, JSONArray edges) {

            vertex = new Vertex((String)vertexInfo.get("label"),(Long)vertexInfo.get("id"));

            this.edges = new LinkedList();
            for(int i = 0;i<edges.size(); i++){
                JSONObject ed = (JSONObject)edges.get(i);

                int from = sToInt((Long)ed.get("from"));
                int to = sToInt((Long)ed.get("to"));
                double weight = (Double)ed.get("weight");
                Edge n = new Edge(from,to,weight);
                this.edges.add(n);
            }

        }
    }
}
