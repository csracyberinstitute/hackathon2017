/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.cbp.air.controllers;

import gov.cbp.air.model.Manifest;
import gov.cbp.air.services.ManifestService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

/**
 *
 * @author chrismoran
 */
@RestController
@Api (value="Manifest", description = "Air Manifest end point")
public class ManifestController {
    
    private final ManifestService manifestService;
    private static final Logger logger = LoggerFactory.getLogger(ManifestController.class);

    @Autowired
    public ManifestController(ManifestService manifestService) {
        this.manifestService = manifestService;
    }

    @ApiOperation(value = "Search Manifest")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation", response = Manifest.class),
            @ApiResponse(code = 500, message = "Internal server error", response = String.class)
    })
    @RequestMapping(value = "/manifest/sample/{manifestKey}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Manifest> getManifest(@ApiParam(name="manifestKey", required=true ) @PathVariable String manifestKey)
    {
        Optional<Manifest> optionalManifest = manifestService.getSampleManifest(manifestKey);
        if (optionalManifest.isPresent()) {
            return new ResponseEntity<>(optionalManifest.get(), HttpStatus.OK);
        }
        return new ResponseEntity(null, HttpStatus.OK);
        
    }
    
    @RequestMapping(value = "/manifest/{arrivalPort}/{manifestKey}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Manifest> getManifest(@PathVariable String arrivalPort, @PathVariable String manifestKey)
    {
        Optional<Manifest> optionalManifest = manifestService.getManifest(manifestKey, arrivalPort);
        if (optionalManifest.isPresent()) {
            return new ResponseEntity<>(optionalManifest.get(), HttpStatus.OK);
        }
        return new ResponseEntity(null, HttpStatus.OK);
        
    }
    
    @RequestMapping(value = "/manifest", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Collection<String>> saveManifest(@Valid @RequestBody Manifest manifest)
    {
        Collection<String> messagesCol = new ArrayList(); 
        try {
            messagesCol.add("Manifest received: " + manifest.getArrivalInfo());
            messagesCol.add(manifestService.saveManifest(manifest).get());
        } catch (Exception ex) {
            logger.error(ex.toString());
            messagesCol.add(ex.toString());
        }

        return new ResponseEntity(messagesCol, HttpStatus.OK);
    }
    
    
    
}
