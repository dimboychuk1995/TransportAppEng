
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
 *         &lt;element name="Zmatnrtable" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZsdsmitmatnr"/&gt;
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
    "zmatnrtable"
})
@XmlRootElement(name = "ZsdGetMatnrForSmitResponse")
public class ZsdGetMatnrForSmitResponse {

    @XmlElement(name = "Zmatnrtable", required = true)
    protected TableOfZsdsmitmatnr zmatnrtable;

    /**
     * Gets the value of the zmatnrtable property.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZsdsmitmatnr }
     *     
     */
    public TableOfZsdsmitmatnr getZmatnrtable() {
        return zmatnrtable;
    }

    /**
     * Sets the value of the zmatnrtable property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZsdsmitmatnr }
     *     
     */
    public void setZmatnrtable(TableOfZsdsmitmatnr value) {
        this.zmatnrtable = value;
    }

}
