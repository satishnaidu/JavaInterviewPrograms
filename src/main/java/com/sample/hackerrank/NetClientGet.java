package com.sample.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class NetClientGet {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://api.github.com/users/mralexgray/repos");
			HttpURLConnection conn= (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept","application/json");
			if(conn.getResponseCode() ==200) {
				String output;
				Gson gson = new Gson();
				
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				
				Type listType = new TypeToken<ArrayList<Repo>>() {}.getType();
				List<Repo> r = gson.fromJson(br, listType);
				for(Repo rr : r) {
					System.out.println(rr.getFull_Name());
				}
				System.out.println(r.size());
//				String s = gson.fromJson(json, classOfT)(br, String.class);
//				System.out.println("s "+s);
//				while((output=br.readLine()) != null) {
//					System.out.println(output);
//					
//				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	class Repo {
		private String id;
		private String name;
		private String full_name;
		
		public void setId(String id) {
			this.id= id;
		}
		
		public String getId() {
			return id;
		}
		
		public void setName(String name) {
			this.name= name;
		}
		
		public String getName() {
			return name;
		}
		
		public void setFull_Name(String full_name) {
			this.full_name=full_name;
		}
		
		public String getFull_Name() {
			return full_name;
		}
	}
}
