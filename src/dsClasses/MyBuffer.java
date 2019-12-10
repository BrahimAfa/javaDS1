package dsClasses;

import java.util.LinkedList;

public class MyBuffer {
	private int Size;
	public LinkedList<String> data;
	//public Object Sync_Obj = new Object();
	public MyBuffer(int size) {
		Size = size;
		data = new LinkedList<>();
		
	}
	
	public void addWord(String word) throws Exception {
		//if(Is_Limite_Size()) throw new Exception("Size is Been Passed");
//		synchronized (Sync_Obj) {
		System.out.println("<<"+word+">>");
			this.data.add(word);
//		}
		
		
	}
	
	public boolean Is_Limite_Size() { return this.Size >= this.data.size(); }
	
}
