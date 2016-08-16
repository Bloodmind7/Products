package md.convertit.products.services;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import md.convertit.products.domain.Notebook;
import md.convertit.products.domain.NotebookXmlHelper;

public class XmlFileServices implements FileService {

	private static final Logger log = Logger.getLogger(XmlFileServices.class.getName());
	private File file;

	public void saveAll(List<Notebook> notebooks, String path) throws Exception {

		file = new File(path);
		JAXBContext jaxbContext = JAXBContext.newInstance(NotebookXmlHelper.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		// pregatim un helper
		NotebookXmlHelper helper = new NotebookXmlHelper();
		helper.setNotebookList(notebooks);
		marshaller.marshal(helper, file);
		log.log(Level.INFO, String.format("saved objects in file: %s", file.getAbsolutePath()));

	}

	public List<Notebook> readAll(String path) throws Exception {
		file = new File(path);
		JAXBContext jaxbContext = JAXBContext.newInstance(NotebookXmlHelper.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		NotebookXmlHelper helper = (NotebookXmlHelper) unmarshaller.unmarshal(file);

		log.log(Level.INFO,
				String.format("Return total of %d objects", helper.getUserList().size(), file.getAbsolutePath()));
		return helper.getUserList();
	}

}