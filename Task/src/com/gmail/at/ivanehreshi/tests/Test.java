package com.gmail.at.ivanehreshi.tests;

import static org.junit.Assert.*;

import java.util.Random;
import java.util.Vector;

import com.gmail.at.ivanehreshi.ArrayReader;
import com.gmail.at.ivanehreshi.ArrayShuffle;

public class Test {

	private boolean quarterTest(Vector<Vector<Integer>> orig,
			Vector<Vector<Integer>> shuffled){
		
		if(orig == null || orig.get(0).size() == 0)
			return false;
		
		int rowSize = orig.get(0).size();
		int totalCount = orig.size()*rowSize;
		int quarter = totalCount >> 2; //  divide by two
		
		if(quarter <= 1)
			return true;
		
		int count = 0;
		for(int i = 0; i < orig.size(); i++){
			for(int j = 0; j < orig.get(i).size(); j++){
				if(orig.get(i).get(j) != shuffled.get(i).get(j))
					count++;
			}
		}
		
		return quarter == count;
	}
	
	@org.junit.Test
	public void test() {
		Random random = new Random(1);
		Vector<Vector<Integer>> v1, v2;
		for(int i = 0; i < 100; i++){
			int m = random.nextInt(10);
			int n = random.nextInt(10);
			
			v1 = new Vector<Vector<Integer>>();
			ArrayReader.genArray(v1, m, n);
			v2 = new Vector<Vector<Integer>>();
			
			for(int k = 0; k < v1.size(); k++){
				v2.add(new Vector<Integer>());
				for(int j = 0; j < v1.get(k).size(); j++){
					v2.get(k).add(v1.get(k).get(j));
				}
			}
			
			ArrayShuffle.shuffleQuarter(v2);
			boolean testResult = quarterTest(v1, v2);
			if(!testResult){
				assertTrue(testResult);
				return;
			}
			
		}
	}

}
