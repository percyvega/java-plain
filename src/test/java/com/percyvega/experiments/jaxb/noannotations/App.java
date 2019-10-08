package com.percyvega.experiments.jaxb.noannotations;

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.*;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;

@Log4j2
public class App {

    public static void main(String[] args) throws JAXBException {
        log.debug("Starting App");

        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StreamSource streamSource = new StreamSource("src/main/java/" + "com/percyvega/experiments/jaxb/noannotations/" + "customer.xml");
        JAXBElement<Customer> customerJAXBElementToRead = unmarshaller.unmarshal(streamSource, Customer.class);
        Customer customer = customerJAXBElementToRead.getValue();

        log.debug(customer.getFirstName() + " " + customer.getLastName() + " loaded from an XML file!!!");

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        JAXBElement<Customer> customerJAXBElementToWrite = new JAXBElement<>(new QName("customer"), Customer.class, customer);
        marshaller.marshal(customerJAXBElementToWrite, System.out);

        log.debug("Finishing App");
    }

}
