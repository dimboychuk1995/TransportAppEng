
package com.sap.document.sap.soap.functions.mc_style;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Zsdsmitmatnr complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Zsdsmitmatnr"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Matnr" type="{urn:sap-com:document:sap:rfc:functions}char18"/&gt;
 *         &lt;element name="Maktx" type="{urn:sap-com:document:sap:rfc:functions}char40"/&gt;
 *         &lt;element name="Vrvez" type="{urn:sap-com:document:sap:rfc:functions}decimal5.2"/&gt;
 *         &lt;element name="Kbetr" type="{urn:sap-com:document:sap:rfc:functions}curr11.2"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Zsdsmitmatnr", propOrder = {
    "matnr",
    "maktx",
    "vrvez",
    "kbetr"
})
public class Zsdsmitmatnr {

    @XmlElement(name = "Matnr", required = true)
    protected String matnr;
    @XmlElement(name = "Maktx", required = true)
    protected String maktx;
    @XmlElement(name = "Vrvez", required = true)
    protected BigDecimal vrvez;
    @XmlElement(name = "Kbetr", required = true)
    protected BigDecimal kbetr;

    /**
     * Gets the value of the matnr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatnr() {
        return matnr;
    }

    /**
     * Sets the value of the matnr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatnr(String value) {
        this.matnr = value;
    }

    /**
     * Gets the value of the maktx property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaktx() {
        return maktx;
    }

    /**
     * Sets the value of the maktx property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaktx(String value) {
        this.maktx = value;
    }

    /**
     * Gets the value of the vrvez property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVrvez() {
        return vrvez;
    }

    /**
     * Sets the value of the vrvez property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVrvez(BigDecimal value) {
        this.vrvez = value;
    }

    /**
     * Gets the value of the kbetr property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getKbetr() {
        return kbetr;
    }

    /**
     * Sets the value of the kbetr property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setKbetr(BigDecimal value) {
        this.kbetr = value;
    }

}
