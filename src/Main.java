import java.io.IOException;

import dsClasses.*;
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("test");
		MyBuffer buff = new MyBuffer(5);
		Processor p1 = new Processor("P1", buff);
		Processor p2 = new Processor("P2", buff);
		
		Thread L1 = new Lecteur("L1", "fichier1.txt", buff);
		Thread L2 = new Lecteur("L2", "fichier2.txt", buff);
		L1.start();
		L2.start();
		p1.start();
		p2.start();
		
		
		System.out.println(p1.getWordsCount().size());
		System.out.println(p2.getWordsCount().size());
//		System.out.println(L.readWord());
//		System.out.println(L.readWord());
//		System.out.println(L.readWord());
//		System.out.println(L.readWord());
	}

}
