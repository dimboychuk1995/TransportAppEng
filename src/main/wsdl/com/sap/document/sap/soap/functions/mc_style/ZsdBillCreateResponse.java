
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
 *         &lt;element name="BillNumber" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="Messtab" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfBdcmsgcoll"/&gt;
 *         &lt;element name="Subrc" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
    "billNumber",
    "messtab",
    "subrc"
})
@XmlRootElement(name = "ZsdBillCreateResponse")
public class ZsdBillCreateResponse {

    @XmlElement(name = "BillNumber", required = true)
    protected String billNumber;
    @XmlElement(name = "Messtab", required = true)
    protected TableOfBdcmsgcoll messtab;
    @XmlElement(name = "Subrc")
    protected int subrc;

    /**
     * Gets the value of the billNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillNumber() {
        return billNumber;
    }

    /**
     * Sets the value of the billNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillNumber(String value) {
        this.billNumber = value;
    }

    /**
     * Gets the value of the messtab property.
     * 
     * @return
     *     possible object is
     *     {@link TableOfBdcmsgcoll }
     *     
     */
    public TableOfBdcmsgcoll getMesstab() {
        return messtab;
    }

    /**
     * Sets the value of the messtab property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfBdcmsgcoll }
     *     
     */
    public void setMesstab(TableOfBdcmsgcoll value) {
        this.messtab = value;
    }

    /**
     * Gets the value of the subrc property.
     * 
     */
    public int getSubrc() {
        return subrc;
    }

    /**
     * Sets the value of the subrc property.
     * 
     */
    public void setSubrc(int value) {
        this.subrc = value;
    }

}