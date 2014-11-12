/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package widgetparser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author brando
 */
public class WidgetParser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        final String filePath = "../widget.json";
        
        try{
            FileReader reader = new FileReader(filePath);
            
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            
            //top level widget object
            JSONObject widget = (JSONObject) jsonObject.get("Widget");
            System.out.println("Object: Widget");
            String debug = (String) widget.get("debug");
            System.out.println("Debug: " + debug);
            System.out.println();
            
            //for windo object
            JSONObject window = (JSONObject) widget.get("window");
            System.out.println("Object: Window");
            System.out.println("Title: " + (String) window.get("-title"));
            System.out.println("Name: " + (String) window.get("name"));
            System.out.println("Width: " + (Long) window.get("width"));
            System.out.println("Height: " + (Long) window.get("height"));
            System.out.println();
           
            //for image object
            JSONObject image = (JSONObject) widget.get("image");
            System.out.println("Object: Image");
            System.out.println("Src: " + (String) image.get("-src"));
            System.out.println("Name: " + (String) image.get("-name"));
            System.out.println("hOffset: " + (Long) image.get("hOffset"));
            System.out.println("vOffset: " + (Long) image.get("vOffset"));
            System.out.println("Alignment: " + (String) image.get("alignment"));
            System.out.println();
            
            //for text object
            JSONObject text = (JSONObject) widget.get("text");
            System.out.println("Object: Text");
            System.out.println("Data: " + (String) text.get("-data"));
            System.out.println("Size: " + (String) text.get("-size"));
            System.out.println("Style: " + (String) text.get("-style"));
            System.out.println("Name: " + (String) text.get("name"));
            System.out.println("hOffset: " + (Long) text.get("hOffset"));
            System.out.println("vOffset: " + (Long) text.get("vOffset"));
            System.out.println("Alignment: " + (String) text.get("alignment"));
            System.out.println("onMouseUp: " + (String) text.get("onMouseUp"));
            System.out.println();
             
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        } catch(NullPointerException e){
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException ex) {
            Logger.getLogger(WidgetParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
