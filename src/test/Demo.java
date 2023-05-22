package test;

import java.util.EventListener;
import java.util.HashSet;
import java.util.Set;

// Step 1: Define the custom event class
class CustomEvent extends java.util.EventObject {
    public CustomEvent(Object source) {
        super(source);
    }
}

// Step 2: Declare the listener interface
interface CustomEventListener extends EventListener {
    void handleCustomEvent(CustomEvent event);
}

// Step 3: Implement the listener interface
class CustomListener implements CustomEventListener {
    @Override
    public void handleCustomEvent(CustomEvent event) {
        System.out.println("Custom event handled!");
    }
}

// Step 4: Fire the event
class EventProducer {
    private Set<CustomEventListener> listeners = new HashSet<>();

    public void addCustomEventListener(CustomEventListener listener) {
        listeners.add(listener);
    }

    public void removeCustomEventListener(CustomEventListener listener) {
        listeners.remove(listener);
    }

    public void fireEvent() {
        CustomEvent event = new CustomEvent(this);
        for (CustomEventListener listener : listeners) {
            listener.handleCustomEvent(event);
        }
    }
}

public class Demo {
    public static void main(String[] args) {
        // Step 5: Register and use the listener
        EventProducer producer = new EventProducer();
        CustomListener listener = new CustomListener();
        producer.addCustomEventListener(listener);

        // Fire the custom event
        producer.fireEvent();

        // Unregister the listener
        producer.removeCustomEventListener(listener);
    }
}
