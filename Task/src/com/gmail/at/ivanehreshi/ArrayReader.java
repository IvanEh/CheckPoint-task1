package com.gmail.at.ivanehreshi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Scanner;
import java.util.Vector;

import org.json.JSONObject;

public class ArrayReader {
	
	public static void readArray(Vector<Vector<Integer>> arr,
			BufferedReader reader){
	
		if(arr == null)
			return;
		
		String line = null;
		try {
			line = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(line != null){
			Vector<Integer> pVector = new Vector<Integer>();
			arr.add(pVector);
			
			Scanner scanner = new Scanner(line);
			while(scanner.hasNext())
				pVector.add(scanner.nextInt());
			
			try {
				line =  reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			scanner.close();
		}
		
		
	}
	
	public static void main(String[] args){
		Vector<Vector<Integer>> v = new Vector<Vector<Integer>>();
		try {
			readArray(v, new BufferedReader(new FileReader("input.txt")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
