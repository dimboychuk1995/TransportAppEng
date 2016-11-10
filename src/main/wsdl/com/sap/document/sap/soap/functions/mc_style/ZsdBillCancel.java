
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
 *         &lt;element name="BillNum" type="{urn:sap-com:document:sap:rfc:functions}char132"/&gt;
 *         &lt;element name="Messtab" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfBdcmsgcoll"/&gt;
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
    "billNum",
    "messtab"
})
@XmlRootElement(name = "ZsdBillCancel")
public class ZsdBillCancel {

    @XmlElement(name = "BillNum", required = true)
    protected String billNum;
    @XmlElement(name = "Messtab", required = true)
    protected TableOfBdcmsgcoll messtab;

    /**
     * Gets the value of the billNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillNum() {
        return billNum;
    }

    /**
     * Sets the value of the billNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillNum(String value) {
        this.billNum = value;
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

}
