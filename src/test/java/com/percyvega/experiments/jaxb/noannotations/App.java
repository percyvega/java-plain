package com.percyvega.experiments.jaxb.noannotations;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lombok.extern.log4j.Log4j2;

import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;

@Log4j2
public class App {

    public static void main(String[] args) throws JAXBException {
        log.info("Starting App");

        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StreamSource streamSource = new StreamSource("src/main/java/" + "com/percyvega/experiments/jaxb/noannotations/" + "customer.xml");
        JAXBElement<Customer> customerJAXBElementToRead = unmarshaller.unmarshal(streamSource, Customer.class);
        Customer customer = customerJAXBElementToRead.getValue();

        log.info(customer.getFirstName() + " " + customer.getLastName() + " loaded from an XML file!!!");

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        JAXBElement<Customer> customerJAXBElementToWrite = new JAXBElement<>(new QName("customer"), Customer.class, customer);
        marshaller.marshal(customerJAXBElementToWrite, System.out);

        log.info("Finishing App");
    }

}
