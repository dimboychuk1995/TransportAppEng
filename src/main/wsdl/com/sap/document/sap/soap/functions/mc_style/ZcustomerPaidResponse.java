
package com.sap.document.sap.soap.functions.mc_style;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Payments" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZbapiCustomerPayment"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "payments"
})
@XmlRootElement(name = "ZcustomerPaidResponse")
public class ZcustomerPaidResponse {

    @XmlElement(name = "Payments", required = true)
    protected TableOfZbapiCustomerPayment payments;

    /**
     * Gets the value of the payments property.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZbapiCustomerPayment }
     *     
     */
    public TableOfZbapiCustomerPayment getPayments() {
        return payments;
    }

    /**
     * Sets the value of the payments property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZbapiCustomerPayment }
     *     
     */
    public void setPayments(TableOfZbapiCustomerPayment value) {
        this.payments = value;
    }

}
