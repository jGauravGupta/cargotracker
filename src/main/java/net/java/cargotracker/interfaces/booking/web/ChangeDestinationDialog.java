package net.java.cargotracker.interfaces.booking.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author davidd
 */
@Named("changeDestinationDialog")
@SessionScoped
public class ChangeDestinationDialog implements Serializable {


    public void showDialog(String trackingId) {
        Map<String, Object> options = new HashMap<>();
        options.put("modal", true);
        options.put("draggable", true);
        options.put("resizable", false);
        options.put("contentWidth", 360);
        options.put("contentHeight", 230);
        
        Map<String, List<String>> params = new HashMap<>();
        List<String> values = new ArrayList<>();
        values.add(trackingId);
        params.put("trackingId", values);
        PrimeFaces.current().dialog().openDynamic("/admin/changeDestination.xhtml", options, params);
    }
    
    public void handleReturn(SelectEvent event) {
    }
    
    public void cancel() {
        // just kill the dialog
        PrimeFaces.current().dialog().closeDynamic("");
    }


}

