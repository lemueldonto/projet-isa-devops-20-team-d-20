package stubs.delivery;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.10
 * 2020-03-17T12:42:57.768+01:00
 * Generated source version: 3.1.10
 * 
 */
@WebService(targetNamespace = "http://www.polytech.unice.fr/si/4a/isa/dd/deliveryService", name = "DeliveryWebService")
@XmlSeeAlso({ObjectFactory.class})
public interface DeliveryWebService {

    @WebMethod
    @RequestWrapper(localName = "getNextDelivery", targetNamespace = "http://www.polytech.unice.fr/si/4a/isa/dd/deliveryService", className = "stubs.delivery.GetNextDelivery")
    @ResponseWrapper(localName = "getNextDeliveryResponse", targetNamespace = "http://www.polytech.unice.fr/si/4a/isa/dd/deliveryService", className = "stubs.delivery.GetNextDeliveryResponse")
    @WebResult(name = "the_next_delivery", targetNamespace = "")
    public stubs.delivery.Delivery getNextDelivery();
}
