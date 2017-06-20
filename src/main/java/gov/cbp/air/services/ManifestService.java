/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.cbp.air.services;

import gov.cbp.air.model.Manifest;
import gov.cbp.air.persistence.ManifestDAO;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.validation.Validator;

/**
 *
 * @author chrismoran
 */
@Service
public class ManifestService {
    
    private final ManifestDAO manifestDAO;
    private static final Logger logger = LoggerFactory.getLogger(ManifestService.class);

    @Autowired
    public ManifestService(ManifestDAO manifestDAO) {
        this.manifestDAO = manifestDAO;
    }
    
    public Optional<Manifest> getSampleManifest(String manifestKey)
    {
        return this.manifestDAO.getSampleManifest(manifestKey);
    }
    
    public Optional<Manifest> getManifest(String  manifestKey, String arrivalPort)
    {
        return this.manifestDAO.getManifest(manifestKey, arrivalPort);
    }
    
    public Optional<String> saveManifest(Manifest manifest)
    {
        Optional<String> optionalMssg = manifestDAO.saveManifest(manifest);

        return optionalMssg;
        
    }
    
    
}
