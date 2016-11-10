
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
 *         &lt;element name="OutTab" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZpernDebitor"/&gt;
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
    "outTab"
})
@XmlRootElement(name = "ZsearchPersonResponse")
public class ZsearchPersonResponse {

    @XmlElement(name = "OutTab", required = true)
    protected TableOfZpernDebitor outTab;

    /**
     * Gets the value of the outTab property.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZpernDebitor }
     *     
     */
    public TableOfZpernDebitor getOutTab() {
        return outTab;
    }

    /**
     * Sets the value of the outTab property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZpernDebitor }
     *     
     */
    public void setOutTab(TableOfZpernDebitor value) {
        this.outTab = value;
    }

}
