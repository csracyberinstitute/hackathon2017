/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.cbp.air.services;


import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;
import com.csra.dynamodb.model.TableSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author chrismoran
 */
@Service
public class DynamoService 
{
    private DynamoDB dynamoDB = null;
    private static final Logger logger = LoggerFactory.getLogger(DynamoService.class);
//    @Autowired
//    private Environment environment;
//    
//    @Value("#{environment['awsCredentials']}") private String awsCredentials;
    
    @Autowired
    public DynamoService(@Value ("${dynamodb.region}") String region)
    {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                        .withRegion(region)
                        .build();
        dynamoDB = new DynamoDB(client);
    }
    
    public Optional<String> getTable(String tableName)
    {
        Optional<String> optionalReturnMessage = Optional.empty();
        Table table = dynamoDB.getTable(tableName);
        try {
            
            if (dynamoDB.getTable(tableName) == null) {
                System.out.println("Table not found");
                optionalReturnMessage = Optional.of("Table not found");
                
            } else {
                
                optionalReturnMessage = Optional.of(table.describe().getTableStatus());
            }

        } catch (Exception e) {
            System.err.println("Unable to find table: ");
            System.err.println(e.getMessage());
        }
        return optionalReturnMessage;
    }
    
    /**
     * Builds a sample TableSchema to guide the creation of JSON passed to the DynamoController
     * to build tables in dynamo
     * @param tableName
     * @return 
     */
    public Optional <TableSchema> getSampleTableSchema(String tableName)
    {
        Optional<TableSchema> optionalTableSchema = Optional.empty();
        TableSchema tableSchema = new TableSchema();
        tableSchema.setTableName(tableName);
        ArrayList<AttributeDefinition> attributeDefinitions = new ArrayList();
        attributeDefinitions.add(new AttributeDefinition("manifestID", ScalarAttributeType.N));
        attributeDefinitions.add(new AttributeDefinition("flightNumber", ScalarAttributeType.S));
        tableSchema.setAttributeDefinitionArray(attributeDefinitions);
        ArrayList<KeySchemaElement> keySchemaElementArray = new ArrayList();
        keySchemaElementArray.add(new KeySchemaElement("manifestID", KeyType.HASH));
        keySchemaElementArray.add(new KeySchemaElement("flightNumber", KeyType.RANGE));
        tableSchema.setKeySchemaElementArray(keySchemaElementArray);
        tableSchema.setProvisionedThroughputReadCapacityUnits(10L);
        tableSchema.setProvisionedThroughputWriteCapacityUnits(10L);
        optionalTableSchema = Optional.of(tableSchema);
        return optionalTableSchema;
    }
    
    public Optional<String> createTable(TableSchema tableSchema)
    {
        Optional<String> optionalReturnMessage = Optional.empty();
        try {
            Table table = dynamoDB.createTable(tableSchema.getTableName(), 
                                            tableSchema.getKeySchemaElementArray(),
                                            tableSchema.getAttributeDefinitionArray(),
                                            new ProvisionedThroughput(
                                                    tableSchema.getProvisionedThroughputReadCapacityUnits(),
                                                    tableSchema.getProvisionedThroughputWriteCapacityUnits()));
            table.waitForActive();
//            System.out.println("Table status: " + table.getDescription().getTableStatus());
            optionalReturnMessage = Optional.of("Table created " + tableSchema.getTableName());
        } catch (Exception e) {
//            System.err.println("Unable to create table: ");
//            System.err.println(e.getMessage());
            logger.error(e.getMessage());
            optionalReturnMessage = Optional.of("Unable to create table: " + tableSchema.getTableName());
        }
        return optionalReturnMessage;
    }
    
    public Optional<String> deleteTable(TableSchema tableSchema)
    {
        Optional<String> optionalReturnMessage = Optional.empty();
        Table table = dynamoDB.getTable(tableSchema.getTableName());

        try {
            logger.info("Deleting table; " + table.getTableName());
            table.delete();
            table.waitForDelete();
            optionalReturnMessage = Optional.of("Table deleted: " + table.getTableName());

        } catch (Exception e) {
            logger.info("Unable to delete table: " + tableSchema.getTableName());
            logger.info(e.getMessage());
            optionalReturnMessage = Optional.of("Unable to delete table: " + tableSchema.getTableName());
        }
        return optionalReturnMessage;
    }
    
}
