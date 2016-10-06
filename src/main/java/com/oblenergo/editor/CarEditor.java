/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oblenergo.editor;

import com.oblenergo.model.Car;
import com.oblenergo.service.CarService;

import java.beans.PropertyEditorSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author us9522
 */
@Component
public class CarEditor extends PropertyEditorSupport{
    
    @Autowired
    CarService carServiceImpl;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Car instance = carServiceImpl.findCarById(Integer.parseInt(text));
        
        this.setValue(instance);
    }
}
