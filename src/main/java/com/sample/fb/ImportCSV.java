package com.sample.fb;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ImportCSV {

	public static void main(String[] args) {

	}

	public void importCsv() {

		String fileName = "";
		FileReader fileReader;
		String line = "";
		BufferedReader br = null;
		try {
			fileReader = new FileReader(new File(fileName));

			 br = new BufferedReader(fileReader);
			while((line = br.readLine()) != null) {
				String[] country = line.split("\\,");
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
