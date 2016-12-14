/**
 * Created by ludwighandel on 2016-12-14.
 */

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class JParser {

    public JSONObject data;

    public JParser(String file){


        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader(file));


            this.data = (JSONObject) obj;


        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
