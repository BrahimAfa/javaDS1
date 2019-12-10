package dsClasses;

import java.util.HashMap;

public class Processor extends Thread {

	private  String PName;
	private MyBuffer buff;
	private HashMap<String,Integer> WordsCount;
	
	public Processor(String pname, MyBuffer buff) {
		super(pname);
		PName = pname; //Instead use This.getName();
		this.buff = buff;
		WordsCount = new HashMap<>();
	}
	public synchronized void Process() {
		if (buff.data.size() == 0) return;
		String word = buff.data.remove(0);
		System.out.println(this.PName +" REMOVED <<"+word+">> from <data> "+buff.data.size());
		if(WordsCount.containsKey(word)) {
			WordsCount.replace(word, WordsCount.get(word)+1);
			return;
		}
		WordsCount.put(word, 1);
		
	}

	public HashMap<String, Integer> getWordsCount() {
		return WordsCount;
	}
	
	@Override
	public void run() {
		super.run();
		
		while(true) {
			try {
				Thread.sleep(2000);
				
				Process();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
