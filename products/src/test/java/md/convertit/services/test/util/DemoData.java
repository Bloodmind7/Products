package md.convertit.services.test.util;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import md.convertit.products.domain.Notebook;
import md.convertit.products.util.RandomDate;



public class DemoData {
	public static List<Notebook> getDemoData(int totalObjects) {

		List<Notebook> notebooks = new ArrayList<Notebook>();
		Random ran = new Random();

		for (int i = 0; i < totalObjects; i++) {
			Notebook notebook = new Notebook();
			notebook.setType("type" + ran.nextInt());
			notebook.setPrice(ran.nextDouble());
			notebook.setStock(ran.nextInt());
			notebook.setInfo("Info" + ran.nextInt());
			notebook.setOrdered(ran.nextBoolean());
			notebook.setOrderedDate(RandomDate.getRandomDate());

			notebooks.add(notebook);
		}

		return notebooks;
	}

}
