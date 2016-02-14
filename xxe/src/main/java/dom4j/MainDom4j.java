package dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

public class MainDom4j {

	public static void main(String[] args) throws DocumentException, SAXException {
		SAXReader reader = new SAXReader();

		// The xxe problem can be solved in one of the two ways:
		// 1. You create your own entity resolver that ignores the problematic entities
		// 2. You turn off the external entities if not needed.
		// To know the features you can steer see:
		// http://www.saxproject.org/apidoc/org/xml/sax/package-summary.html#package_description
		
		// Following code fixes the issue
//		reader.setFeature("http://xml.org/sax/features/external-general-entities", false);
        Document document = reader.read("src\\main\\resources\\test.xml");
        treeWalk(document);
	}

	private static void treeWalk(Document document) {
		treeWalk(document.getRootElement());
	}

	private static void treeWalk(Element element) {
		for (int i = 0, size = element.nodeCount(); i < size; i++) {
			Node node = element.node(i);
			if (node instanceof Element) {
				printTextIfPresent(node);
				treeWalk((Element) node);
			} 
		}
	}

	private static void printTextIfPresent(Node node) {
		if (!"".equals(node.getText().trim())) {
			System.out.println(node.getText());
		}
	}
}
