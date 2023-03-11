package fr.insa.api.events;

import fr.insa.api.models.Summary;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class SummaryConsumerEvent extends ApplicationEvent {

    private Summary summary;

    public SummaryConsumerEvent(Object source, Summary summary) {
        super(source);
        this.summary = summary;
    }
}
