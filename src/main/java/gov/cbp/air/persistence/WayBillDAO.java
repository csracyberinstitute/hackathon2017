package gov.cbp.air.persistence;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.google.gson.Gson;
import gov.cbp.air.model.WayBill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by ramchalasani on 4/13/17.
 */
@Service
public class WayBillDAO {

    private DynamoDB dynamoDB = null;
    private static final Logger logger = LoggerFactory.getLogger(WayBillDAO.class);

    @Autowired
    public WayBillDAO(@Value("${dynamodb.region}") String region)
    {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withRegion(region)
                .build();
        dynamoDB = new DynamoDB(client);
    }

    public Optional<String> saveWayBill(WayBill wayBill) {

        Gson gson = new Gson();
        String wayBillJson = gson.toJson(wayBill);

        Table table = dynamoDB.getTable("waybill");

        Optional<String> optionalReturnMsg = Optional.empty();
        try {

            table.putItem(new Item()
                    .withPrimaryKey("wayBillNumber", wayBill.getWayBillNumber())
                    .withJSON("info", wayBillJson));
            optionalReturnMsg = Optional.of("Saved WayBill: " + wayBill);

        } catch (Exception e) {
            optionalReturnMsg = Optional.of("Unable to save WayBillInfo: " + wayBill + ": " + e.toString());
            logger.error("Unable to save WayBill: " + wayBill + ": " + e.toString());
        }
        return optionalReturnMsg;

    }


    public Optional<WayBill> getWayBill(String wayBillNumber) {
        Optional<WayBill> optionalWayBill = Optional.empty();
        Gson gson = new Gson();
        Table table = dynamoDB.getTable("waybill");

        try {
            GetItemSpec spec = new GetItemSpec()
                    .withPrimaryKey("wayBillNumber", wayBillNumber);
            Item item = table.getItem(spec);
            if (item != null) {
                String manifestInfoJson = item.getJSON("info");
                WayBill wayBill = gson.fromJson(manifestInfoJson, WayBill.class);
                optionalWayBill = Optional.of(wayBill);
            }
        } catch (Exception e) {
            logger.error("Unable to get WayBill: " + wayBillNumber + ": " + e.toString());
        }

        return optionalWayBill;
    }
}
