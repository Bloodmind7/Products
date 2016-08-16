package md.convertit.products.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class NotebookXmlHelper {
	private List<Notebook> notebookList;

	public List<Notebook> getUserList() {
		return notebookList;
	}
	@XmlElement
	public void setNotebookList(List<Notebook> notebookList) {
		this.notebookList = notebookList;
	}
	public List<Notebook> getNotebookList() {
		return notebookList;
	}
	

}
