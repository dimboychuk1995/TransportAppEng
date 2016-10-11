/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oblenergo.enums;

/**
 *
 * @author us9522
 */
public enum StatusOrderEnum {
        NEW("нове"),
        PAID("оплачене"),
        DONE("виконане"),
        CANCELED("скасоване");
        
        String statusOrder;
        
        private StatusOrderEnum(String statusOrder){
            this.statusOrder = statusOrder;
        }
        
        public String getStatusOrder(){
            return statusOrder;
        }
}
