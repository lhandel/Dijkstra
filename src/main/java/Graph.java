
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ludwighandel on 2016-12-14.
 */
public class Graph {
    public Veredges[] veredges;

    public JSONArray data;

    public Graph(String file){

       JParser jsp = new JParser(file);

        this.data = (JSONArray)jsp.data.get("data");
        this.veredges = new Veredges[this.data.size()];

        Iterator<JSONObject> iterator = this.data.iterator();

        while (iterator.hasNext()) {
            JSONObject vertexObject = (JSONObject)iterator.next();
            JSONObject vertexInfo = (JSONObject)vertexObject.get("vertex");

            JSONArray vertexEdges = (JSONArray)vertexObject.get("edges");

            String label = (String)vertexInfo.get("label");

            System.out.println(label+" har "+vertexEdges.size()+"st edges");

            int id = sToInt((Long) vertexInfo.get("id"));

            this.veredges[id] = new Veredges(vertexInfo,vertexEdges);
        }


    }

    public static int sToInt(long l) {
        if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE) {
            throw new IllegalArgumentException
                    (l + " cannot be cast to int without changing its value.");
        }
        return (int) l;
    }

    public int numberOfVertices(){
        return  this.data.size();
    }

    public Iterator<Edge> adj(int v) {
        System.out.print(this.veredges[v].edges.size());
        return this.veredges[v].edges.iterator();
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
