package jdom;

import java.io.File;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class MainJDom {

	public static void main(String[] args) throws JDOMException, IOException {
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File("src\\main\\resources\\test.xml");
//		builder.setExpandEntities(false);
		Document document = builder.build(xmlFile);
		treeWalk(document);
	}
	
	private static void treeWalk(Document document) {
		treeWalk(document.getRootElement());
	}

	private static void treeWalk(Element element) {
		for (Element child : element.getChildren()) {
			printTextIfPresent(child);
			treeWalk(child);
		}
	}

	private static void printTextIfPresent(Element node) {
		if (!"".equals(node.getText().trim())) {
			System.out.println(node.getText());
		}
	}
}
