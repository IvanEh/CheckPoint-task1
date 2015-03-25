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
		
		Integer dimension = null;
		
		while(line != null){
			Vector<Integer> pVector = new Vector<Integer>();
			arr.add(pVector);
			
			Scanner scanner = new Scanner(line);
			while(scanner.hasNext() && (dimension == null || pVector.size() < dimension))
				pVector.add(scanner.nextInt());
			
			if(dimension == null)
				dimension = pVector.size();
			
			try {
				line =  reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			scanner.close();
		}
		
		
	}
	
	public static void genArray(Vector<Vector<Integer>> arr, int m, int n){
		int c = 11;
		for(int i = 0; i < m; i++){
			arr.add(new Vector<Integer>());
			for(int j = 0; j < n; j++){
				arr.get(i).add(c);
				c++;
			}
		}
	}
	
	public static void main(String[] args){
		Vector<Vector<Integer>> v = new Vector<Vector<Integer>>();
		// readArray(v, new BufferedReader(new FileReader("input.txt")));
		genArray(v, 1, 20);
		ArrayShuffle.shuffleQuarter(v);
	}
}
