package com.lingjoin.sentimentAnalysis.test;

import java.io.File;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import com.lingjoin.sentimentAnalysis.SentimentAnalysis;

public class SentimentAnalysisTest {

	List<String> files=new ArrayList<String>();
	
	public void getAllfiles(File filePath){
		File[] fsFiles=filePath.listFiles();
		for(File f:fsFiles){
			if(f.isFile()&&!f.getName().equals(".DS_Store")) files.add(f.getPath());
			if(f.isDirectory()) this.getAllfiles(f);
		}
	}
	
	public String getContent(File file)throws Exception{
		RandomAccessFile f=new RandomAccessFile(file, "r");
		byte[] b=new byte[(int) file.length()];
		f.read(b);
		f.close();
		String c=new String(b,"GBK").replaceAll("\\s", "");
		return c;
	}
	
	public static void main(String[] args)throws Exception{
		SentimentAnalysis.init("lib");
		FileWriter fw=new FileWriter(new File("sentiment.txt"));
		String fPath="./data_train";
		SentimentAnalysisTest test=new SentimentAnalysisTest();
		test.getAllfiles(new File(fPath));
		for(String f:test.files){
			System.out.println(f);
			String con=test.getContent(new File(f));
			System.out.println(con);
			//fw.write(new File(f).getName()+"\t"+NLPIR.paragraphProcess(con, 1).replaceAll(" ", "\t")+"\n");
			System.out.println(new String(SentimentAnalysis.getParagraphSent(con)));
		}
		fw.flush();
		fw.close();
	}
}
