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
        NEW("\u043d\u043e\u0432\u0435"),
        DONE("\u043f\u0456\u0434\u0442\u0432\u0435\u0440\u0434\u0436\u0435\u043d\u0435"),
        CANCELED("\u0432\u0456\u0434\u043c\u0456\u043d\u0435\u043d\u0435"),
        PAID("\u043e\u043f\u043b\u0430\u0447\u0435\u043d\u0435"),
        CANCELEDAFTERPAID("\u0432\u0456\u0434\u043c\u0456\u043d\u0435\u043d\u0435 \u043f\u0456\u0441\u043b\u044f \u043e\u043f\u043b\u0430\u0442\u0438");

        
        String statusOrder;
        
        private StatusOrderEnum(String statusOrder){
            this.statusOrder = statusOrder;
        }
        
        public String getStatusOrder(){
            return statusOrder;
        }
}
