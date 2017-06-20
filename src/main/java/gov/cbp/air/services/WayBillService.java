package gov.cbp.air.services;

import gov.cbp.air.model.Manifest;
import gov.cbp.air.model.WayBill;
import gov.cbp.air.persistence.ManifestDAO;
import gov.cbp.air.persistence.WayBillDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by ramchalasani on 4/13/17.
 */
@Service
public class WayBillService {

    private final WayBillDAO wayBillDAO;

    @Autowired
    public WayBillService(WayBillDAO wayBillDAO) {
        this.wayBillDAO = wayBillDAO;
    }


    public Optional<WayBill> getWayBill(String wayBillNumber)
    {
        return this.wayBillDAO.getWayBill(wayBillNumber);
    }

    public Optional<String> saveWayBill(WayBill wayBill)
    {
        Optional<String> optionalMsg = wayBillDAO.saveWayBill(wayBill);

        return optionalMsg;

    }
}
