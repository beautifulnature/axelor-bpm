/*******************************************************************************
 * Signavio Core Components
 * Copyright (C) 2012  Signavio GmbH
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package de.hpi.bpmn2_0.model.event;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import de.hpi.bpmn2_0.model.FlowNode;
import de.hpi.bpmn2_0.model.extension.PropertyListItem;
import de.hpi.bpmn2_0.transformation.Visitor;



/**
 * <p>Java class for tEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/bpmn20}tFlowNode">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tEvent")
@XmlSeeAlso({
    ThrowEvent.class,
    CatchEvent.class,
    SocialNetworkEvent.class
})
public abstract class Event
    extends FlowNode
{
	@XmlElementRefs({
		@XmlElementRef(type = MessageEventDefinition.class),
		@XmlElementRef(type = TimerEventDefinition.class),
		@XmlElementRef(type = CancelEventDefinition.class),
		@XmlElementRef(type = CompensateEventDefinition.class),
		@XmlElementRef(type = ConditionalEventDefinition.class),
		@XmlElementRef(type = ErrorEventDefinition.class),
		@XmlElementRef(type = EscalationEventDefinition.class),
		@XmlElementRef(type = LinkEventDefinition.class),
		@XmlElementRef(type = SignalEventDefinition.class),
		@XmlElementRef(type = TerminateEventDefinition.class),
		@XmlElementRef(type = SmsEventDefinition.class),
		@XmlElementRef(type = PhoneCallEventDefinition.class),
		@XmlElementRef(type = InternetSiteEventDefinition.class),
		@XmlElementRef(type = MailEventDefinition.class),
		@XmlElementRef(type = FilterEventDefinition.class),
		@XmlElementRef(type = FacebookEventDefinition.class),
		@XmlElementRef(type = TwitterEventDefinition.class),
		@XmlElementRef(type = LinkedinEventDefinition.class),
		@XmlElementRef(type = StopFilterEventDefinition.class)
	})
	List<EventDefinition> eventDefinition;
	
	@XmlElement
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	String eventDefinitionRef;
	
	@XmlElementRef
	protected List<PropertyListItem> additionalProperties;
	
	/* Constructors */
	
	public Event() {}
	
	public Event(Event event) {
		super(event);
		this.getEventDefinition().addAll(event.getEventDefinition());
		this.setEventDefinitionRef(event.getEventDefinitionRef());
		
		if(event.getAdditionalProperties().size() > 0) {
			this.getAdditionalProperties().addAll(event.getAdditionalProperties());
		}
	}
	
	public void acceptVisitor(Visitor v){
		v.visitEvent(this);
	}
	
	
	/**
	 * Helper for the import, see {@link FlowElement#isElementWithFixedSize().
	 */
    // @Override
    public boolean isElementWithFixedSize() {
		return true;
	}
    
    /**
     * For the fixed-size shape, return the fixed width.
     */
    public double getStandardWidth(){
    	return 28.0;
    }
    
    /**
     * For the fixed-size shape, return the fixed height.
     */
    public double getStandardHeight(){
    	return 28.0;
    }
	
	/**
	 * 
	 * @param type
	 * 		The {@link EventDefinition} type.
	 * @return
	 * 		The first occurrence of an {@link EventDefinition} where the type fits.
	 * 		Or null if no {@link EventDefinition} of this type exists.
	 */
	public EventDefinition getEventDefinitionOfType(Class<? extends EventDefinition> type) {
		for(EventDefinition evDef : this.getEventDefinition()) {
			if(evDef.getClass().equals(type))
				return evDef;
		}
		return null;
	}
	
	public boolean isSignalEvent() {
		return getEventDefinitionOfType(SignalEventDefinition.class) != null;
	}
	
	/* Getter & Setter */
	
	public List<PropertyListItem> getAdditionalProperties() {
		if(additionalProperties == null) {
			additionalProperties = new ArrayList<PropertyListItem>();
		}
		return additionalProperties;
	}
	
	/**
     * Gets the value of the eventDefinition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eventDefinition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEventDefinition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CompensateEventDefinition }
     * {@link TMessageEventDefinition }
     * {@link ErrorEventDefinition }
     * {@link TTimerEventDefinition }
     * {@link EventDefinition }
     * {@link ConditionalEventDefinition }
     * {@link LinkEventDefinition }
     * {@link CancelEventDefinition }
     * {@link TEscalationEventDefinition }
     * {@link SignalEventDefinition }
     * {@link TTerminateEventDefinition }
     * 
	 * @return the eventDefinition
	 */
	public List<EventDefinition> getEventDefinition() {
		if(this.eventDefinition == null) {
			this.eventDefinition = new ArrayList<EventDefinition>();
		}
		return this.eventDefinition;
	}

	/**
	 * @return the eventDefinitionRef
	 */
	public String getEventDefinitionRef() {
		return eventDefinitionRef;
	}

	/**
	 * @param eventDefinitionRef the eventDefinitionRef to set
	 */
	public void setEventDefinitionRef(String eventDefinitionRef) {
		this.eventDefinitionRef = eventDefinitionRef;
	}

}
