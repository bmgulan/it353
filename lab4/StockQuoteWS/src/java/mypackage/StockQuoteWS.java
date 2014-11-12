/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.util.HashMap;
import java.util.Map;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author brando
 */
@WebService
public class StockQuoteWS {
    @WebMethod
    public double getTradePrice(String stockName){
        
        Map<String, Double> map = new HashMap();
        map.put("MMM", 156.55);
        map.put("AXP", 92.26);
        map.put("T", 34.91);
        map.put("BA", 124.45);
        map.put("CAT", 101.76);
        map.put("CVX", 118.80);
        map.put("CSCO", 25.23);
        map.put("DD", 70.41);
        map.put("XOM", 96.59);
        map.put("GE", 26.41);
        map.put("GS", 190.71);
        map.put("HD",97.65 );
        map.put("INTC", 33.58);
        map.put("IBM", 162.07);
        map.put("JNJ", 108.20);
        map.put("JPM", 61.47);
        map.put("MCD", 95.10);
        map.put("MRK", 59.34);
        map.put("MSFT", 48.68);
        map.put("NKE", 93.78);
        map.put("PFE", 29.92);
        map.put("PG", 89.19);
        map.put("KO", 42.32);
        map.put("TRV", 102.37);
        map.put("UTX", 109.08);
        map.put("UNH", 93.61);
        map.put("VZ", 50.86);
        map.put("V", 252.43);
        map.put("WMT", 78.77);
        map.put("DIS", 90.00);
        
        Double price = map.get(stockName);
        
        if(price == null)
            price = -1.0;
        
        return price;
    }
}
