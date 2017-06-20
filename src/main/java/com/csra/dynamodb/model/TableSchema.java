/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csra.dynamodb.model;

import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author chrismoran
 */
public class TableSchema {
    private String tableName;
    private ArrayList<KeySchemaElement> keySchemaElementArray;
    private ArrayList<AttributeDefinition> attributeDefinitionArray;
    private Long ProvisionedThroughputReadCapacityUnits;
    private Long ProvisionedThroughputWriteCapacityUnits;

    public TableSchema(String tableName, ArrayList<KeySchemaElement> keySchemaElementArray, ArrayList<AttributeDefinition> attributeDefinitionArray, Long ProvisionedThroughputReadCapacityUnits, Long ProvisionedThroughputWriteCapacityUnits) {
        this.tableName = tableName;
        this.keySchemaElementArray = keySchemaElementArray;
        this.attributeDefinitionArray = attributeDefinitionArray;
        this.ProvisionedThroughputReadCapacityUnits = ProvisionedThroughputReadCapacityUnits;
        this.ProvisionedThroughputWriteCapacityUnits = ProvisionedThroughputWriteCapacityUnits;
    }

    public TableSchema() {
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public ArrayList<KeySchemaElement> getKeySchemaElementArray() {
        return keySchemaElementArray;
    }

    public void setKeySchemaElementArray(ArrayList<KeySchemaElement> keySchemaElementArray) {
        this.keySchemaElementArray = keySchemaElementArray;
    }

    public ArrayList<AttributeDefinition> getAttributeDefinitionArray() {
        return attributeDefinitionArray;
    }

    public void setAttributeDefinitionArray(ArrayList<AttributeDefinition> attributeDefinitionArray) {
        this.attributeDefinitionArray = attributeDefinitionArray;
    }

    public Long getProvisionedThroughputReadCapacityUnits() {
        return ProvisionedThroughputReadCapacityUnits;
    }

    public void setProvisionedThroughputReadCapacityUnits(Long ProvisionedThroughputReadCapacityUnits) {
        this.ProvisionedThroughputReadCapacityUnits = ProvisionedThroughputReadCapacityUnits;
    }

    public Long getProvisionedThroughputWriteCapacityUnits() {
        return ProvisionedThroughputWriteCapacityUnits;
    }

    public void setProvisionedThroughputWriteCapacityUnits(Long ProvisionedThroughputWriteCapacityUnits) {
        this.ProvisionedThroughputWriteCapacityUnits = ProvisionedThroughputWriteCapacityUnits;
    }
    
    
    
}
