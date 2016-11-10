package com.oblenergo.wsClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.sap.document.sap.soap.functions.mc_style.ObjectFactory;
import com.sap.document.sap.soap.functions.mc_style.ZsearchPerson;
import com.sap.document.sap.soap.functions.mc_style.ZsearchPersonResponse;

public class SapClient extends WebServiceGatewaySupport {

  @Autowired
  private ObjectFactory of;
  
  private ZsearchPersonResponse getZsearchPersonResponse() {

    //ok for person searhing
    ZsearchPerson request = of.createZsearchPerson();
    request.setFstnameM("");
    request.setLastnameM("");
    request.setOrgtxt("");
    request.setJobtxt("");
    request.setJob("");
    request.setOrgtxt("");
    request.setOrgUnit("");
    request.setCheckCommunities("X");
    request.setEmployeeId("9047");
    request.setOutTab(of.createTableOfZpernDebitor());
    ZsearchPersonResponse response = (ZsearchPersonResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    return response;
  }
  
  //will be changed
  /*
  private ZsdGetMatnrForSmitResponse getZsdGetMatnrForSmitResponse() {

    ZsdGetMatnrForSmit request = of.createZsdGetMatnrForSmit();
    request.setZmatnrtable(of.createTableOfZsdsmitmatnr());
    ZsdGetMatnrForSmitResponse response = (ZsdGetMatnrForSmitResponse) getWebServiceTemplate()
        .marshalSendAndReceive(request);
    return response;
  }
  */
  
  //will be changed
  /*
  private ZsdOrderCreateResponse getZsdOrderCreateResponse() {

    ZsdOrderCreate request = of.createZsdOrderCreate();
    TableOfBdcmsgcoll tob = of.createTableOfBdcmsgcoll();
    Bdcmsgcoll bdcm = of.createBdcmsgcoll();
    bdcm.setFldname("SMIT");
    tob.getItem().add(bdcm);
    request.setOrderClient("100");
    request.setMesstab(tob);
    ZsdOrderCreateResponse response = (ZsdOrderCreateResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    return response;
  }*/

  //only for testing
  /*
  public void checkResponse() {
    ZsdOrderCreateResponse response = getZsdOrderCreateResponse();
    System.out.println(response.getSubrc() + "  " + response.getSalesOrder());
  }

  public void checkService() {
    ZsdGetMatnrForSmitResponse response = getZsdGetMatnrForSmitResponse();
    List<Zsdsmitmatnr> list = response.getZmatnrtable().getItem();
    for (Zsdsmitmatnr item : list) {
      System.out.println(item.getMatnr());
      System.out.println(item.getMaktx());
      System.out.println(item.getKbetr());
      System.out.println(item.getVrvez());
      System.out.println();
    }
  }

  public void returnName() {
    ZsearchPersonResponse resposne = getZsearchPersonResponse();
    List<ZpernDebitor> list = resposne.getOutTab().getItem();
    for (ZpernDebitor zpd : list) {
      System.out.println(zpd.getFamily() + " " + zpd.getName() + " " + zpd.getFather());
    }
  }
  */
}
