package com.percyvega.experiments.jaxb.noannotations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.*;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws JAXBException {
        logger.debug("Starting App");

        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StreamSource streamSource = new StreamSource("src/main/java/" + "com/percyvega/experiments/jaxb/noannotations/" + "customer.xml");
        JAXBElement<Customer> customerJAXBElementToRead = unmarshaller.unmarshal(streamSource, Customer.class);
        Customer customer = customerJAXBElementToRead.getValue();

        logger.debug(customer.getFirstName() + " " + customer.getLastName() + " loaded from an XML file!!!");

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        JAXBElement<Customer> customerJAXBElementToWrite = new JAXBElement<>(new QName("customer"), Customer.class, customer);
        marshaller.marshal(customerJAXBElementToWrite, System.out);

        logger.debug("Finishing App");
    }

}
