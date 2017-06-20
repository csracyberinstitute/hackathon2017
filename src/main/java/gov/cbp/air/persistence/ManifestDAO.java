/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.cbp.air.persistence;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.google.gson.Gson;
import gov.cbp.air.gov.cbp.air.db.model.*;
import gov.cbp.air.model.*;
import gov.cbp.air.model.Manifest;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Calendar;
import java.util.Optional;

/**
 *
 * @author chrismoran
 */
@Service
public class ManifestDAO {

    private DynamoDB dynamoDB = null;
    private static final Logger logger = LoggerFactory.getLogger(ManifestDAO.class);
    
//    @Autowired
//    private Environment environment;
//    
//    @Value("#{environment['awsCredentials']}") private String awsCredentials;

    @Autowired
    private WayBillDAO wayBillDAO;


    @Autowired
    public ManifestDAO(@Value ("${dynamodb.region}") String region) 
    {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                        .withRegion(region)
                        .build();
        dynamoDB = new DynamoDB(client);
    }
    
    public Optional<Manifest> getSampleManifest(String manifestKey)
    {
        Optional<Manifest> optionalManifest = Optional.empty();
        
        Manifest manifest = new Manifest();

        manifest.setAirportOfArrival("JFK");
        ArrivalInfo arrival = new ArrivalInfo();
        arrival.setFlightNumber("FDX2001");
        arrival.setImportingCarrier("FDX");
        arrival.setScheduledArrivalDate(Calendar.getInstance().getTime());
        manifest.setArrivalInfo(arrival);

        WayBill wayBill = new WayBill();
        wayBill.setWayBillNumber("999-12345678");
        wayBill.setNoOfPieces(10);
        wayBill.setCargoDescription("Toys");
        wayBill.setWeight(new Double(100));
        wayBill.setWeightCode("K");

        Entity consignee = new Entity(), shipper = new Entity();
        consignee.setAddress(new Address("Clarendon Blvd","", "Arlington","VA","22013","USA"));
        shipper.setAddress(new Address("Frankfurt Str","", "Frankfurt","FRA","22013","GER"));

        wayBill.setConsignee(consignee);
        wayBill.setShipper(shipper);

        manifest.addAirWayBill(wayBill);
        manifest.setDestinationAirport("JFK");
        manifest.setOriginAirPort("FRA");

        optionalManifest = Optional.of(manifest);
        
        return optionalManifest;
    }
    
    
    public Optional<String> saveManifest(Manifest manifest)
    {
        ModelMapper mapper = new ModelMapper();
        gov.cbp.air.gov.cbp.air.db.model.Manifest manifestDbObject = mapper.map(manifest, gov.cbp.air.gov.cbp.air.db.model.Manifest.class);

        manifest.getAirWayBills().forEach( dto -> {
            wayBillDAO.saveWayBill(dto);
        });

         manifest.getAirWayBills().forEach(dto -> {
             if (!StringUtils.isEmpty(dto.getWayBillNumber())) {
                 manifestDbObject.getAirWayBillNumbers().add(dto.getWayBillNumber());
             }
         });



        Gson gson = new Gson();
        String manifestJson = gson.toJson(manifestDbObject);
        Table table = dynamoDB.getTable("manifest");
        Optional<String> optionalReturnMsg = Optional.empty();
        try {
            // This putItem saves the entire contents of the manifest object under a json node called 'info'
            // Not sure if this is the best way to model the information or if it is merely a standard
            // practice for storing documents in Dynamo. it does have the advantage that the JSON can be
            // queried more easily
            table.putItem(new Item()
                      .withPrimaryKey("manifestKey",
                              manifest.getDestinationAirport()+manifest.getArrivalInfo().getFlightNumber()+manifest.getArrivalInfo().getScheduledArrivalDate(),
                              "arrivalDate",manifest.getArrivalInfo().getScheduledArrivalDate().toString())
                      .withJSON("info", manifestJson));
            optionalReturnMsg = Optional.of("Saved manifest: " + manifest);

        } catch (Exception e) {
            optionalReturnMsg = Optional.of("Unable to save manifest: " + manifest + ": " + e.toString());
            logger.error("Unable to save manifest: " + manifest + ": " + e.toString());
        }
        return optionalReturnMsg;
    }
    
    public Optional<Manifest> getManifest(String manifestKey, String arrivalPort)
    {
        Optional<Manifest> optionalManifest = Optional.empty();
        Gson gson = new Gson();
        Table table = dynamoDB.getTable("manifest");

        try {
            GetItemSpec spec = new GetItemSpec()
               .withPrimaryKey("manifestID", manifestKey, "arrivalPortCode", arrivalPort);
            Item item = table.getItem(spec);
            if (item != null) {
                String manifestInfoJson = item.getJSON("info");
                Manifest manifest = gson.fromJson(manifestInfoJson, Manifest.class);
                optionalManifest = Optional.of(manifest);
            }
        } catch (Exception e) {
            logger.error("Unable to get manifest: " + manifestKey + ": " + e.toString());
        }

        return optionalManifest;
            
    }
    
}
