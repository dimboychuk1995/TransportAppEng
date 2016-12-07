/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oblenergo.editor;


import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oblenergo.model.WorkType;
import com.oblenergo.service.WorkTypeService;

/**
 *
 * @author us9522
 */
@Component
public class ServiceEditor extends PropertyEditorSupport{
    
    @Autowired
    WorkTypeService workTypeServiceImpl;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        WorkType instance = workTypeServiceImpl.findWorkTypeById(text);
        this.setValue(instance);
    }
}
    

