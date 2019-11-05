package aptuser.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Sms {
	public void sendMessage(int number, String phone) throws Exception {
	    String targetUrl = "http://api.solapi.com/messages/v4/send";
	    /*String parameters = "{\"message\":{\"to\":\""+phone+",\"from\":\"01026854111\",\"text\":\"인증번호는 ["+number+"] 입니다.\"}}";*/
	    String parameters = "{\"message\":{\"to\":\"01026854111\",\"from\":\"01026854111\",\"text\":\"인증번호는 입니다.\"}}";
	    
	    URL url = new URL(targetUrl);
	    HttpURLConnection con = (HttpURLConnection) url.openConnection();

	    con.setRequestMethod("POST");

	    
	    con.setRequestProperty("Authorization", "HMAC-SHA256 apiKey=NCSLTKRT2RWQUZ7E, date=2019-10-10 19:20:17, salt=2be835cb5e9c823456abe0683d3767647856961be9742cf7c6523b963bba70b0, signature=43d353b8b94477f6d58306cfabe9308af8dba6ee72f1b4b9caa14c267c47ffa2");
	    con.setRequestProperty("Content-Type", "application/json");
	    
	    con.setDoOutput(true);
	    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	    wr.writeBytes(parameters);
	    wr.flush();
	    wr.close();

	    int responseCode = con.getResponseCode();
	    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	    String line;
	    StringBuffer response = new StringBuffer();
	    while ((line = in.readLine()) != null) {
	      response.append(line);
	    }
	    in.close();

	    System.out.println("HTTP response code : " + responseCode);
	    System.out.println("HTTP body : " + response.toString());
	  }
	}
