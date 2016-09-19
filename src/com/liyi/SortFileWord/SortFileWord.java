package com.liyi.SortFileWord;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortFileWord {
	
	public void sortFileWord(File file) throws IOException{
		String regex = "\\W+";
		BufferedReader br = new BufferedReader(new FileReader(file));
		List<String> rlt = new ArrayList<String>();
		do{
			String str = br.readLine();
			if(str != null){
				String content[] = str.split(regex); 
				List<String> temp = new ArrayList<String>(Arrays.asList(content));
				for(int i = 0; i < temp.size(); i++){
					String tempStr = temp.get(i).toLowerCase();
					if(!rlt.contains(tempStr)){
						rlt.add(tempStr);
					}
				}
			}else
				break;
		}while(true);
		rlt = reverse(rlt);
		Collections.sort(rlt);
		rlt = reverse(rlt);
		int counter = 1;
		System.out.println("total "+ rlt.size() + "words!");
        for(String s:rlt){
        	System.out.printf("%15s",s); 
        	if(counter++ % 10 == 0)
        		System.out.println();
        }
	    br.close();
	}
	
	public List<String> reverse(List<String> list){
		List<String> reverseList = new ArrayList<String>();
		for(String s:list){
			StringBuffer sb = new StringBuffer(s);  
			reverseList.add(sb.reverse().toString());
		}
		return reverseList;
	}
	
	public static void main(String[] args) throws IOException {
		File file = new File("src/com/liyi/SortFileWord/words.txt");
		SortFileWord sfw = new SortFileWord();
		sfw.sortFileWord(file);
	}
}
