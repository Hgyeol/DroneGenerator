package drone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class PublicIP {
	public static String getPublicIP() throws IOException {
		String urlString = "http://checkip.amazonaws.com/";
		
		URL url = new URL(urlString);
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		return br.readLine();
	}
}