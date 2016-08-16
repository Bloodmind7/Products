package md.convertit.products.services;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;


import md.convertit.products.domain.Notebook;

public class JsonFileServices implements FileService{
	private static final Logger log = Logger.getLogger(JsonFileServices.class.getName());
	
	
	private Gson gson = new Gson();
	private File file;


	public void saveAll(List<Notebook> notebooks, String path) throws Exception {
		System.out.println("salvare");
		
		    file = new File(path);
			FileWriter fw = new FileWriter(file);
			gson.toJson(notebooks, fw);
			fw.close();
			
			log.log(Level.INFO, "object savet to" + file.getAbsolutePath());
		
	}

	public List<Notebook> readAll(String path) throws Exception {
		 file = new File(path);
			FileReader fr = new FileReader(file);
			List<Notebook> notebooks = gson.fromJson(fr, List.class);
			log.log(Level.INFO, String.format("Loaded from file %s total %d objects", file.getAbsolutePath(), notebooks.size()));
			return notebooks;
	}

}
