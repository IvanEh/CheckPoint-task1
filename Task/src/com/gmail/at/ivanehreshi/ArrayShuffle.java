package com.gmail.at.ivanehreshi;

import java.util.HashSet;
import java.util.Random;
import java.util.Vector;

public class ArrayShuffle {
	public static Random random = new Random();
	

	public static void shuffleQuarter(Vector<Vector<Integer>> arr){
		if(arr == null || arr.get(0).size() == 0)
			return;
		
		int rowSize = arr.get(0).size();
		int totalCount = arr.size()*rowSize;
		int quarter = totalCount >> 2; //  divide by two
		
		if(quarter == 1)
			return;
		
		int[] indicesToShuffle = new int[quarter];
		int[] shuffledIndices = new int[quarter];
		boolean[] shuffled = new boolean[totalCount];
		
		HashSet<Integer> hash = new HashSet<Integer>(totalCount/2);
				// indices from 1..totalCount;
							
		
//		int ind;
//		int i = ind % rowSize;
//		int j = (ind-1) / rowSize;
		
		int currentAdded = 0;
		
		
		while(hash.size() != quarter){
			int ind = random.nextInt(totalCount) + 1;
			if(!hash.contains(ind))
				hash.add(ind);
		}
		
		int c = 0; // var for counting 
		for(int elem: hash){
			indicesToShuffle[c] = elem;
			shuffledIndices[c] = elem;
			c++;
		}
		
		for(int i = 0; i < quarter; i++){
			boolean success = false;
			while(!success){
				int randomIndex = i + random.nextInt(quarter - i) ;
				if(shuffledIndices[randomIndex] != indicesToShuffle[i]){
					success = true;
					int t = shuffledIndices[i];
					shuffledIndices[i] = shuffledIndices[randomIndex];
					shuffledIndices[randomIndex] = t;
				}
				
			}
		}
		
	
		for(int i = 0; i < quarter; i++){
			
			int index1 = shuffledIndices[i];
			int index2 = indicesToShuffle[i];
			if(shuffled[index1-1] && shuffled[index2-1])
				continue;
			
			int i1 = (index1) % rowSize;
			i1 = i1 == 0 ? rowSize: i1;
			i1--;
			int j1 = (index1 - 1) / rowSize;
			
			
			
			int i2 = index2 % rowSize; 
			i2 = i2 == 0 ? rowSize: i2;
			i2--;
			int j2 = (index2 - 1) / rowSize;
			
			int t = arr.get(j1).get(i1);
			arr.get(j1).set(i1, arr.get(j2).get(i2));
			arr.get(j2).set(i2, t);
			
			shuffled[index1-1] = true;
			shuffled[index2-1] = true;
			
		}
		
	}
}
