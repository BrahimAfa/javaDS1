package dsClasses;

import java.io.*;
import java.util.HashMap;

public class Lecteur extends Thread {
	private String fileName ;
	private String threadName ;
	private MyBuffer buff;
	private BufferedInputStream bis;
	private File _file;
	public Lecteur(String threadName, String fileName, MyBuffer buff) {
		super();
		this.threadName = threadName;
		this.fileName =fileName;
		this.buff = buff;
		_file = new File(fileName);
	}
	
	public synchronized String  readWord() throws IOException {
		if(bis ==null) {
			bis = new BufferedInputStream(new FileInputStream(_file));
		}
		String word="";
		byte[] bytes = new byte[1];
		//System.out.println(bis.available());
		int Readed_Bytes;
		while((Readed_Bytes=bis.read(bytes))!=-1) {
			for (int i = 0; i < Readed_Bytes; i++) {
				char c = (char)bytes[i];
				if(!Character.isWhitespace(c)) {
					word+=c;
					continue;
				}
				return word;
			}
			
		}
		//System.out.println(bis.available());
		return null;	
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			while(true) {
				while(!buff.Is_Limite_Size()) {
					Thread.sleep(100);
					String w = readWord();
					System.out.println(this.threadName +" added <"+w+"> word to <data>");
					buff.data.add(w);
				}
				System.out.println(this.threadName +" data is Full");
				Thread.sleep(300);
			}
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
