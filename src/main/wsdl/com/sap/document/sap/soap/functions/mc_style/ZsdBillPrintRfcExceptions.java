
package com.sap.document.sap.soap.functions.mc_style;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZsdBillPrint.RfcExceptions.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ZsdBillPrint.RfcExceptions"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="SpoolRequest"/&gt;
 *     &lt;enumeration value="SpoolNotChanged"/&gt;
 *     &lt;enumeration value="ConvertOtf_2Pdf"/&gt;
 *     &lt;enumeration value="SendBillToSpool"/&gt;
 *     &lt;enumeration value="DeleteSpoolRequest"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ZsdBillPrint.RfcExceptions")
@XmlEnum
public enum ZsdBillPrintRfcExceptions {

    @XmlEnumValue("SpoolRequest")
    SPOOL_REQUEST("SpoolRequest"),
    @XmlEnumValue("SpoolNotChanged")
    SPOOL_NOT_CHANGED("SpoolNotChanged"),
    @XmlEnumValue("ConvertOtf_2Pdf")
    CONVERT_OTF_2_PDF("ConvertOtf_2Pdf"),
    @XmlEnumValue("SendBillToSpool")
    SEND_BILL_TO_SPOOL("SendBillToSpool"),
    @XmlEnumValue("DeleteSpoolRequest")
    DELETE_SPOOL_REQUEST("DeleteSpoolRequest");
    private final String value;

    ZsdBillPrintRfcExceptions(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ZsdBillPrintRfcExceptions fromValue(String v) {
        for (ZsdBillPrintRfcExceptions c: ZsdBillPrintRfcExceptions.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
