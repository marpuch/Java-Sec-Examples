package jaxb;

import javax.xml.transform.stream.StreamSource;

import javax.xml.bind.*;
import javax.xml.stream.*;
import javax.xml.transform.stream.StreamSource;

public class MainJaxB {

	public static void main(String[] args) throws JAXBException, XMLStreamException {
		JAXBContext jc = JAXBContext.newInstance(Strona.class);

        XMLInputFactory xif = XMLInputFactory.newFactory();
        xif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
        xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);
        XMLStreamReader xsr = xif.createXMLStreamReader(new StreamSource("src\\main\\resources\\test.xml"));

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Strona customer = (Strona) unmarshaller.unmarshal(xsr);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(customer, System.out);
	}

}
