
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
 *         &lt;element name="Customers" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZdebitorkrem"/&gt;
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
    "customers"
})
@XmlRootElement(name = "ZdebitorSearchResponse")
public class ZdebitorSearchResponse {

    @XmlElement(name = "Customers", required = true)
    protected TableOfZdebitorkrem customers;

    /**
     * Gets the value of the customers property.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZdebitorkrem }
     *     
     */
    public TableOfZdebitorkrem getCustomers() {
        return customers;
    }

    /**
     * Sets the value of the customers property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZdebitorkrem }
     *     
     */
    public void setCustomers(TableOfZdebitorkrem value) {
        this.customers = value;
    }

}
