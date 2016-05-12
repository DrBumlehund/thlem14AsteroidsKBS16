package dk.sdu.mmmi.cbse.osgibundleserviceinitializer;

import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.ComponentContext;

public class IEntityProcessingServiceInitializer {

    private ServiceReference reference;
    private IEntityProcessingService service;

    protected void activate(ComponentContext context) {
        System.out.println(reference.getBundle().getLocation());
        if (reference != null) {
            service = (IEntityProcessingService) context.locateService("IEntityProcessingServiceRef", reference);
            System.out.println("Service activated. " + service.getClass());
            
            
        }

    }

    public void gotService(ServiceReference reference) {
        this.reference = reference;
        System.out.println("Got reference: " + reference);
    }

    public void lostService(ServiceReference reference) {
        this.reference = null;
        System.out.println("Lost reference: " + reference);
    }
}
