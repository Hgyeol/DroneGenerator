package drone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class VWorld {
	public static String locationToAddress(double lng, double lat) throws MalformedURLException, IOException, ParseException {
		final String apikey = "0BD03859-1258-3750-B5F1-82AAFF40E77E";
		String searchType = "road";
		String searchPoint = lng + "," + lat;
		String epsg = "epsg:4326";

		StringBuilder sb = new StringBuilder("https://api.vworld.kr/req/address");
		sb.append("?service=address");
		sb.append("&request=getaddress");
		sb.append("&format=json");
		sb.append("&crs=" + epsg);
		sb.append("&key=" + apikey);
		sb.append("&type=" + searchType);
		sb.append("&point=" + searchPoint);

		JSONParser jspa = new JSONParser();
		JSONObject jsob = (JSONObject) jspa.parse(new BufferedReader(new InputStreamReader(new URL(sb.toString()).openStream(), StandardCharsets.UTF_8)));
		JSONObject jsrs = (JSONObject) jsob.get("response");
		JSONArray jsonArray = (JSONArray) jsrs.get("result");
		JSONObject jsonfor = new JSONObject();
		
		String result = "";
		
		for (int i = 0; i< jsonArray.size(); i++){
			jsonfor = (JSONObject) jsonArray.get(i);
			result += jsonfor.get("text");
			//System.out.println(jsonfor.get("text"));
		}
		return result;
	}
}
