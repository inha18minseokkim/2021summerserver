import java.io.FileWriter;
import java.io.IOException;
import javax.json.*;
import java.io.*;
import java.net.HttpURLConnection;
public class JSONUtil {
	public JSONUtil() {
		
	}
	public void sendJSON() {
		JSONObject sendObj = new JSONObject();
		JSONArray sendArray = new JSONArray();
		for(int i = 0; i < 10 ;i++){
			JSONObject informationObject = new JSONObject();
			informationObject.put("name","byeongseong" + i);
			informationObject.put("number", i+1);
			sendArray.put(informationObject);
		}
		sendObject.put("list",sendArray);
		String host_url = "https://webhook.site/1f1acc97-5519-481d-aca3-77a40f82fa56";
		HttpURLConnection conn = null;

		URL url = new URL(host_url);
		conn = (HttpURLConnection)url.openConnection();
		conn.setReqeustMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setDoOutput(true);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
		bw.write(sendArray.toString());
		bw.flush();
		bw.close();
	}
}
