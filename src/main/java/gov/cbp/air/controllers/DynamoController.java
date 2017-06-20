/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.cbp.air.controllers;

import com.csra.dynamodb.model.TableSchema;
import gov.cbp.air.model.Manifest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import gov.cbp.air.services.DynamoService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author chrismoran
 */
@RestController
@Api(value="Dynamo", description = "Dynamo DB Operations end point")
public class DynamoController 
{
    private final DynamoService dynamoService;
    private static final Logger logger = LoggerFactory.getLogger(DynamoController.class);

    @Autowired
    public DynamoController(DynamoService dynamoService) {
        this.dynamoService = dynamoService;
    }

    @ApiOperation(value = "Create Table")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation", response = List.class),
            @ApiResponse(code = 500, message = "Internal server error", response = String.class)
    })
    @RequestMapping(value = "/dynamo", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Collection<String>> createTable(@RequestBody TableSchema schema)
    {
        Collection<String> messagesCol = new ArrayList(); 
        try {
            Optional<String> optionalResponse = dynamoService.createTable(schema);
            messagesCol.add(optionalResponse.get());
            messagesCol.add("created table: " + schema.getTableName());
            logger.info("created table: " + schema.getTableName());
        } catch (Exception ex) {
            logger.error(ex.toString());
        }

        return new ResponseEntity<>(messagesCol, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete Table")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation", response = List.class),
            @ApiResponse(code = 500, message = "Internal server error", response = String.class)
    })
    @RequestMapping(value = "/dynamo", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity<Collection<String>> deleteTable(@RequestBody TableSchema schema)
    {
        Collection<String> messagesCol = new ArrayList(); 
        try {
            Optional<String> optionalResponse = dynamoService.deleteTable(schema);
            messagesCol.add(optionalResponse.get());
            logger.info(optionalResponse.get());
        } catch (Exception ex) {
            logger.error(ex.toString());
        }

        return new ResponseEntity<>(messagesCol, HttpStatus.OK);
    }

    @ApiOperation(value = "Get Table Schema")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation", response = String.class),
            @ApiResponse(code = 500, message = "Internal server error", response = String.class)
    })
    @RequestMapping(value = "/dynamo/{tableName}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<String> getTableSchema(@PathVariable String tableName)
    {
        Optional<String> optionalResponse = dynamoService.getTable(tableName);
        if (optionalResponse.isPresent()) {
            return new ResponseEntity<>(optionalResponse.get(), HttpStatus.OK);
        }
        return new ResponseEntity(null, HttpStatus.OK);
        
    }

    @ApiOperation(value = "Get Sample JSON Table Schema")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation", response = TableSchema.class),
            @ApiResponse(code = 500, message = "Internal server error", response = String.class)
    })
    @RequestMapping(value = "/dynamo/sampleJSON/{tableName}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<TableSchema> getSampleJSONTableSchema(@PathVariable String tableName)
    {
        Optional<TableSchema> optionalTable = dynamoService.getSampleTableSchema(tableName);
        if (optionalTable.isPresent()) {
            return new ResponseEntity<>(optionalTable.get(), HttpStatus.OK);
        }
        return new ResponseEntity(null, HttpStatus.OK);
        
    }
    
    
}
