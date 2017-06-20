package gov.cbp.air.controllers;

import gov.cbp.air.model.WayBill;
import gov.cbp.air.services.WayBillService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

/**
 * Created by ramchalasani on 4/13/17.
 */
@RestController
@Api(value="WayBill", description = "Air Waybill end point")
public class WayBillController {

    private final WayBillService wayBillService;

    private static final Logger logger = LoggerFactory.getLogger(WayBillController.class);

    @Autowired
    public WayBillController(WayBillService wayBillService) {
        this.wayBillService = wayBillService;
    }



    @ApiOperation(value = "Search WayBill")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation", response = WayBill.class),
            @ApiResponse(code = 500, message = "Internal server error", response = String.class)
    })
    @RequestMapping(value = "/waybill/{wayBillNumber}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<WayBill> getWayBill(@ApiParam(name="wayBillNumber", required=true ) @PathVariable String wayBillNumber)
    {
        Optional<WayBill> optionalWayBill = wayBillService.getWayBill(wayBillNumber);
        if (optionalWayBill.isPresent()) {
            return new ResponseEntity<>(optionalWayBill.get(), HttpStatus.OK);
        }
        return new ResponseEntity(null, HttpStatus.OK);

    }


    @ApiOperation(value = "Save WayBill")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation", response = String.class),
            @ApiResponse(code = 500, message = "Internal server error", response = String.class)
    })
    @RequestMapping (value = "/waybill", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Collection<String>> saveWayBill(@Valid @RequestBody WayBill wayBill) {
        try {

            Optional<String> optionalMsg = wayBillService.saveWayBill(wayBill);
            return new ResponseEntity(optionalMsg.get(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("Error while saving WayBill : " + wayBill + " " + ex.getMessage());
           return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
