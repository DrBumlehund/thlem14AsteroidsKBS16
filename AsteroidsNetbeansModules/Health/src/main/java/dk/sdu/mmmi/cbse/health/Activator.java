package dk.sdu.mmmi.cbse.health;

import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    @Override
    public void start(BundleContext context) throws Exception {
        context.registerService(IEntityProcessingService.class, new HealthProcessor(), null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
    }

}
