package com.gmail.at.ivanehreshi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;
import java.util.Vector;

public class App {
	
	public static void print(Writer w, String mess){
		try {
			w.write(mess);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(mess);
	}
	
	public static void main(String[] args){
		
		Vector<Vector<Integer>> v = new Vector<Vector<Integer>>();
		Scanner scanner = new Scanner(System.in);
		
		BufferedWriter bufferedWriter = null;
		 try {
			String inputFilePath = "input.txt";
			System.out.println("Enter input file or leave it empty to set default input file(input.txt): ");
			inputFilePath = scanner.next();
			scanner.close();
			
			ArrayReader.readArray(v, new BufferedReader(new FileReader(inputFilePath)));
			
			bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));	
			
			System.out.println("input file: input.txt \noutput file: output.txt");
			
			int quarter = v.size();
			if(quarter != 0){
				quarter*=v.get(0).size();
				quarter>>=2;
			}else{
				quarter = 0;
			}			
			System.out.println("25% = " + quarter );	
			System.out.println("PS: Array should contain unique set of numbers");
			
			for(int i = 0; i < v.size(); i++){
				for(int j = 0; j < v.get(i).size(); j++){
					String mess = v.get(i).get(j).toString() + "\t";
					print(bufferedWriter, mess);
				}
				print(bufferedWriter, "\n");
			}
			
			print(bufferedWriter, "\n");
			
			
			ArrayShuffle.shuffleQuarter(v);
			for(int i = 0; i < v.size(); i++){
				for(int j = 0; j < v.get(i).size(); j++){
					String mess = v.get(i).get(j).toString() + "\t";
					print(bufferedWriter, mess);
				}
				print(bufferedWriter, "\n");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ArrayShuffle.shuffleQuarter(v);
		
	}
}
