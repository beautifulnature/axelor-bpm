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
package de.hpi.bpmn2_0.factory.node;

import org.oryxeditor.server.diagram.generic.GenericShape;

import de.hpi.bpmn2_0.annotations.StencilId;
import de.hpi.bpmn2_0.exceptions.BpmnConverterException;
import de.hpi.bpmn2_0.factory.AbstractShapeFactory;
import de.hpi.bpmn2_0.factory.BPMNElement;
import de.hpi.bpmn2_0.model.BaseElement;
import de.hpi.bpmn2_0.model.FormalExpression;
import de.hpi.bpmn2_0.model.activity.Activity;
import de.hpi.bpmn2_0.model.activity.Task;
import de.hpi.bpmn2_0.model.activity.misc.Operation;
import de.hpi.bpmn2_0.model.bpmndi.BPMNShape;
import de.hpi.bpmn2_0.model.data_object.Filter;
import de.hpi.bpmn2_0.model.data_object.Account;
import de.hpi.bpmn2_0.model.data_object.Message;
import de.hpi.bpmn2_0.model.data_object.Template;
import de.hpi.bpmn2_0.model.data_object.TemplateRule;
import de.hpi.bpmn2_0.model.event.BoundaryEvent;
import de.hpi.bpmn2_0.model.event.CancelEventDefinition;
import de.hpi.bpmn2_0.model.event.CompensateEventDefinition;
import de.hpi.bpmn2_0.model.event.ConditionalEventDefinition;
import de.hpi.bpmn2_0.model.event.ErrorEventDefinition;
import de.hpi.bpmn2_0.model.event.Escalation;
import de.hpi.bpmn2_0.model.event.EscalationEventDefinition;
import de.hpi.bpmn2_0.model.event.Event;
import de.hpi.bpmn2_0.model.event.FilterEventDefinition;
import de.hpi.bpmn2_0.model.event.IntermediateCatchEvent;
import de.hpi.bpmn2_0.model.event.InternetSiteEventDefinition;
import de.hpi.bpmn2_0.model.event.LinkEventDefinition;
import de.hpi.bpmn2_0.model.event.MailEventDefinition;
import de.hpi.bpmn2_0.model.event.MessageEventDefinition;
import de.hpi.bpmn2_0.model.event.PhoneCallEventDefinition;
import de.hpi.bpmn2_0.model.event.SignalEventDefinition;
import de.hpi.bpmn2_0.model.event.SmsEventDefinition;
import de.hpi.bpmn2_0.model.event.StopFilterEventDefinition;
import de.hpi.bpmn2_0.model.event.TerminateEventDefinition;
import de.hpi.bpmn2_0.model.event.TimerEventDefinition;
import de.hpi.bpmn2_0.model.misc.Error;
import de.hpi.bpmn2_0.model.misc.Signal;
import de.hpi.diagram.SignavioUUID;

/**
 * Factory to create intermediate catching Events
 * 
 * @author Philipp Giese
 * @author Sven Wagner-Boysen
 * 
 */
@StencilId( { "IntermediateMessageEventCatching", "IntermediateTimerEvent",
		"IntermediateEscalationEvent", "IntermediateConditionalEvent",
		"IntermediateLinkEventCatching", "IntermediateErrorEvent",
		"IntermediateCancelEvent", "IntermediateCompensationEventCatching",
		"IntermediateSignalEventCatching", "IntermediateMultipleEventCatching",
		"IntermediateParallelMultipleEventCatching","SMS","PhoneCall","InternetSite","Mail","Filter","StopFilter" })
public class IntermediateCatchEventFactory extends AbstractShapeFactory {

	/*
	 * (non-Javadoc)
	 * 
	 * @seede.hpi.bpmn2_0.factory.AbstractBpmnFactory#createProcessElement(org.
	 * oryxeditor.server.diagram.Shape)
	 */
	// @Override
	protected BaseElement createProcessElement(GenericShape shape)
			throws BpmnConverterException {
		try {
			IntermediateCatchEvent icEvent = (IntermediateCatchEvent) this
					.invokeCreatorMethod(shape);
			icEvent.setId(shape.getResourceId());
			icEvent.setName(shape.getProperty("name"));
			icEvent.setCancelActivity(shape
					.getProperty("boundarycancelactivity2"));

			return icEvent;
		} catch (Exception e) {
			/* Wrap exceptions into specific BPMNConverterException */
			throw new BpmnConverterException(
					"Error while creating the process element of "
							+ shape.getStencilId(), e);
		}

	}

	/* Creator methods for different event definitions */

	@StencilId("IntermediateCompensationEventCatching")
	public IntermediateCatchEvent createCompensateEvent(GenericShape shape) {
		IntermediateCatchEvent icEvent = new IntermediateCatchEvent();
		CompensateEventDefinition compEvDef = new CompensateEventDefinition();
		
		/* Activity Reference */
		String activityRef = shape.getProperty("activityref");
		if(activityRef != null && !(activityRef.length() == 0)) {
			Task taskRef = new Task();
			taskRef.setId(activityRef);
			compEvDef.setActivityRef(taskRef);
		}
		
		/* Wait for Completion */
		String waitForCompletion = shape.getProperty("waitforcompletion");
		if(waitForCompletion != null && waitForCompletion.equals("false")) {
			compEvDef.setWaitForCompletion(false);
		} else {
			compEvDef.setWaitForCompletion(true);
		}
		
		icEvent.getEventDefinition().add(compEvDef);
		return icEvent;
	}

	@StencilId("IntermediateTimerEvent")
	public IntermediateCatchEvent createTimerEvent(GenericShape shape) {
		IntermediateCatchEvent icEvent = new IntermediateCatchEvent();

		TimerEventDefinition timerEvDef = new TimerEventDefinition();
		
		/* Time Date */
		String timeDate = shape.getProperty("timedate");
		if(timeDate != null && !(timeDate.length() == 0)) {
			FormalExpression expr = new FormalExpression(timeDate);
			timerEvDef.setTimeDate(expr);
		}
		
		/* Time Cycle */
		String timeCycle = shape.getProperty("timecycle");
		if(timeCycle != null && !(timeCycle.length() == 0)) {
			FormalExpression expr = new FormalExpression(timeCycle);
			timerEvDef.setTimeCycle(expr);
		}
		
		/* Time Duration */
		String timeDuration = shape.getProperty("timeduration");
		if(timeDuration != null && !(timeDuration.length() == 0)) {
			FormalExpression expr = new FormalExpression(timeDuration);
			timerEvDef.setTimeDuration(expr);
		}
		
		icEvent.getEventDefinition().add(timerEvDef);

		return icEvent;
	}

	@StencilId("IntermediateMessageEventCatching")
	public IntermediateCatchEvent createMessageEvent(GenericShape shape) {
		IntermediateCatchEvent icEvent = new IntermediateCatchEvent();

		MessageEventDefinition messageEvDef = new MessageEventDefinition();
		
		
		/* Message name */
		String messageName = shape.getProperty("messagename");
		if(messageName != null && !(messageName.length() == 0)) {
			Message message = new Message();
			message.setName(messageName);
			messageEvDef.setMessageRef(message);
		}
		
		/* Operation name */
		String operationName = shape.getProperty("operationname");
		if(operationName != null && !(operationName.length() == 0)) {
			Operation operation = new Operation();
			operation.setName(operationName);
			messageEvDef.setOperationRef(operation);
		}
		
		/*** Start By Axelor ***/
		/* Template */
		String templateName = shape.getProperty("template");
		if(templateName != null && !(templateName.length() == 0)){
			Template template = new Template();
			template.setName(templateName);
			messageEvDef.setTemplate(template);
		}
		/* TemplateRule */
		String templateRuleName = shape.getProperty("template_rule");
		if(templateRuleName != null && !(templateRuleName.length() == 0)){
			TemplateRule templateRule = new TemplateRule();
			templateRule.setName(templateRuleName);
			messageEvDef.setTemplateRule(templateRule);
		}
		/* Account */
		String accountName = shape.getProperty("account");
		if(accountName != null && !(accountName.length() == 0)){ 
			Account account = new Account();
			account.setName(accountName);
			messageEvDef.setAccount(account);
		}
		
		String persist = shape.getProperty("persist");
		if(persist != null && !(persist.length() == 0)){ 
			messageEvDef.setPersist(Boolean.parseBoolean(persist));
		}
		
		/*** End By Axelor ***/
		
		icEvent.getEventDefinition().add(messageEvDef);
		
		

		return icEvent;
	}

	
	@StencilId("SMS")
	public IntermediateCatchEvent createSMS(GenericShape shape) {
		IntermediateCatchEvent icEvent = new IntermediateCatchEvent();

		SmsEventDefinition smsEvDef = new SmsEventDefinition();
		
		
		/* Message name */
		String messageName = shape.getProperty("messagename");
		if(messageName != null && !(messageName.length() == 0)) {
			Message message = new Message();
			message.setName(messageName);
			smsEvDef.setMessageRef(message);
		}
		
		/* Operation name */
		String operationName = shape.getProperty("operationname");
		if(operationName != null && !(operationName.length() == 0)) {
			Operation operation = new Operation();
			operation.setName(operationName);
			smsEvDef.setOperationRef(operation);
		}
		
		/*** Start By Axelor ***/
		/* Template */
		String templateName = shape.getProperty("template");
		if(templateName != null && !(templateName.length() == 0)){
			Template template = new Template();
			template.setName(templateName);
			smsEvDef.setTemplate(template);
		}
		/* TemplateRule */
		String templateRuleName = shape.getProperty("template_rule");
		if(templateRuleName != null && !(templateRuleName.length() == 0)){
			TemplateRule templateRule = new TemplateRule();
			templateRule.setName(templateRuleName);
			smsEvDef.setTemplateRule(templateRule);
		}
		/* Account */
		String accountName = shape.getProperty("account");
		if(accountName != null && !(accountName.length() == 0)){ 
			Account account = new Account();
			account.setName(accountName);
			smsEvDef.setAccount(account);
		}
		
		String persist = shape.getProperty("persist");
		if(persist != null && !(persist.length() == 0)){ 
			smsEvDef.setPersist(Boolean.parseBoolean(persist));
		}
		
		/*** End By Axelor ***/
		
		
		icEvent.getEventDefinition().add(smsEvDef);
		
		return icEvent;
	}

	
	@StencilId("PhoneCall")
	public IntermediateCatchEvent createPhoneCall(GenericShape shape) {
		IntermediateCatchEvent icEvent = new IntermediateCatchEvent();

		PhoneCallEventDefinition phoneEvDef = new PhoneCallEventDefinition();
		
		
		/* Message name */
		String messageName = shape.getProperty("messagename");
		if(messageName != null && !(messageName.length() == 0)) {
			Message message = new Message();
			message.setName(messageName);
			phoneEvDef.setMessageRef(message);
		}
		
		/* Operation name */
		String operationName = shape.getProperty("operationname");
		if(operationName != null && !(operationName.length() == 0)) {
			Operation operation = new Operation();
			operation.setName(operationName);
			phoneEvDef.setOperationRef(operation);
		}
		
		/*** Start By Axelor ***/
		/* Template */
		String templateName = shape.getProperty("template");
		if(templateName != null && !(templateName.length() == 0)){
			Template template = new Template();
			template.setName(templateName);
			phoneEvDef.setTemplate(template);
		}
		/* TemplateRule */
		String templateRuleName = shape.getProperty("template_rule");
		if(templateRuleName != null && !(templateRuleName.length() == 0)){
			TemplateRule templateRule = new TemplateRule();
			templateRule.setName(templateRuleName);
			phoneEvDef.setTemplateRule(templateRule);
		}
		/* Account */
		String accountName = shape.getProperty("account");
		if(accountName != null && !(accountName.length() == 0)){ 
			Account account = new Account();
			account.setName(accountName);
			phoneEvDef.setAccount(account);
		}
		/*** End By Axelor ***/
		
		String persist = shape.getProperty("persist");
		if(persist != null && !(persist.length() == 0)){ 
			phoneEvDef.setPersist(Boolean.parseBoolean(persist));
		}
		
		icEvent.getEventDefinition().add(phoneEvDef);
		
		return icEvent;
	}
	
	@StencilId("InternetSite")
	public IntermediateCatchEvent createInternetSite(GenericShape shape) {
		IntermediateCatchEvent icEvent = new IntermediateCatchEvent();

		InternetSiteEventDefinition internetEvDef = new InternetSiteEventDefinition();
		
		
		/* Message name */
		String messageName = shape.getProperty("messagename");
		if(messageName != null && !(messageName.length() == 0)) {
			Message message = new Message();
			message.setName(messageName);
			internetEvDef.setMessageRef(message);
		}
		
		/* Operation name */
		String operationName = shape.getProperty("operationname");
		if(operationName != null && !(operationName.length() == 0)) {
			Operation operation = new Operation();
			operation.setName(operationName);
			internetEvDef.setOperationRef(operation);
		}
		/*** Start By Axelor ***/
		/* Template */
		String templateName = shape.getProperty("template");
		if(templateName != null && !(templateName.length() == 0)){
			Template template = new Template();
			template.setName(templateName);
			internetEvDef.setTemplate(template);
		}
		/* TemplateRule */
		String templateRuleName = shape.getProperty("template_rule");
		if(templateRuleName != null && !(templateRuleName.length() == 0)){
			TemplateRule templateRule = new TemplateRule();
			templateRule.setName(templateRuleName);
			internetEvDef.setTemplateRule(templateRule);
		}
		/* Account */
		String accountName = shape.getProperty("account");
		if(accountName != null && !(accountName.length() == 0)){ 
			Account account = new Account();
			account.setName(accountName);
			internetEvDef.setAccount(account);
		}
		/*** End By Axelor ***/
		String persist = shape.getProperty("persist");
		if(persist != null && !(persist.length() == 0)){ 
			internetEvDef.setPersist(Boolean.parseBoolean(persist));
		}
		
		icEvent.getEventDefinition().add(internetEvDef);
		
		return icEvent;
	}
	
	
	@StencilId("Mail")
	public IntermediateCatchEvent createMail(GenericShape shape) {
		IntermediateCatchEvent icEvent = new IntermediateCatchEvent();

		MailEventDefinition mailEvDef = new MailEventDefinition();
		
		
		/* Message name */
		String messageName = shape.getProperty("messagename");
		if(messageName != null && !(messageName.length() == 0)) {
			Message message = new Message();
			message.setName(messageName);
			mailEvDef.setMessageRef(message);
		}
		
		/* Operation name */
		String operationName = shape.getProperty("operationname");
		if(operationName != null && !(operationName.length() == 0)) {
			Operation operation = new Operation();
			operation.setName(operationName);
			mailEvDef.setOperationRef(operation);
		}
		/*** Start By Axelor ***/
		/* Template */
		String templateName = shape.getProperty("template");
		if(templateName != null && !(templateName.length() == 0)){
			Template template = new Template();
			template.setName(templateName);
			mailEvDef.setTemplate(template);
		}
		/* TemplateRule */
		String templateRuleName = shape.getProperty("template_rule");
		if(templateRuleName != null && !(templateRuleName.length() == 0)){
			TemplateRule templateRule = new TemplateRule();
			templateRule.setName(templateRuleName);
			mailEvDef.setTemplateRule(templateRule);
		}
		/* account */
		String accountName = shape.getProperty("account");
		if(accountName != null && !(accountName.length() == 0)){ 
			Account account = new Account();
			account.setName(accountName);
			mailEvDef.setAccount(account);
		}
		/*** End By Axelor ***/
		
		String persist = shape.getProperty("persist");
		if(persist != null && !(persist.length() == 0)){ 
			mailEvDef.setPersist(Boolean.parseBoolean(persist));
		}
		
		icEvent.getEventDefinition().add(mailEvDef);
		
		return icEvent;
	}
	
	
	@StencilId("Filter")
	public IntermediateCatchEvent createFilter(GenericShape shape) {
		IntermediateCatchEvent icEvent = new IntermediateCatchEvent();

		FilterEventDefinition filterEvDef = new FilterEventDefinition();
		
		
		/* Message name */
		String filterName = shape.getProperty("filter");
		if(filterName != null && !(filterName.length() == 0)) {
			Filter filter = new Filter();
			filter.setName(filterName);
			filterEvDef.setFilter(filter);
		}
		
		icEvent.getEventDefinition().add(filterEvDef);
		
		return icEvent;
	}
	
	@StencilId("StopFilter")
	public IntermediateCatchEvent createStopFilter(GenericShape shape) {
		IntermediateCatchEvent icEvent = new IntermediateCatchEvent();

		StopFilterEventDefinition stopFilterDef= new StopFilterEventDefinition();
		
		icEvent.getEventDefinition().add(stopFilterDef);
		
		return icEvent;
	}
	
	
	
	@StencilId("IntermediateEscalationEvent")
	public IntermediateCatchEvent createEscalationEvent(GenericShape shape) {
		IntermediateCatchEvent icEvent = new IntermediateCatchEvent();

		EscalationEventDefinition escalDef = new EscalationEventDefinition();
		
		Escalation escalation = new Escalation();
		
		/* Escalation name */
		String escalationName = shape.getProperty("escalationname");
		if(escalationName != null && !(escalationName.length() == 0)) {
			escalation.setName(escalationName);
		}
		
		/* Escalation code */
		String escalationCode = shape.getProperty("escalationcode");
		if(escalationCode != null && !(escalationCode.length() == 0)) {
			escalation.setEscalationCode(escalationCode);
		}
		
		escalDef.setEscalationRef(escalation);
		icEvent.getEventDefinition().add(escalDef);

		return icEvent;
	}

	@StencilId("IntermediateConditionalEvent")
	public IntermediateCatchEvent createConditionalEvent(GenericShape shape) {
		IntermediateCatchEvent icEvent = new IntermediateCatchEvent();

		ConditionalEventDefinition conDef = new ConditionalEventDefinition();

		/* Set condition attribute as FormalExpression */
		String condition = shape.getProperty("condition");
		if (condition != null && !(condition.length() == 0))
			conDef.setCondition(new FormalExpression(condition));

		icEvent.getEventDefinition().add(conDef);

		return icEvent;
	}

	@StencilId("IntermediateLinkEventCatching")
	public IntermediateCatchEvent createLinkEvent(GenericShape shape) {
		IntermediateCatchEvent icEvent = new IntermediateCatchEvent();

		LinkEventDefinition linkDef = new LinkEventDefinition();

		/* Set required name attribute */
		String name = shape.getProperty("name");
		if (name != null && !(name.length() == 0))
			linkDef.setName(name);
		
		/* Set source reference */
		String sourceEntry = shape.getProperty("entry");
		if(sourceEntry != null && sourceEntry.length() != 0) {
			linkDef.getSource().add(sourceEntry);
		}
		
		
		icEvent.getEventDefinition().add(linkDef);

		return icEvent;
	}

	@StencilId("IntermediateErrorEvent")
	public IntermediateCatchEvent createErrorEvent(GenericShape shape) {
		IntermediateCatchEvent icEvent = new IntermediateCatchEvent();

		ErrorEventDefinition errorDef = new ErrorEventDefinition();
		
		Error error = new Error();
		
		/* Error name */
		String errorName = shape.getProperty("errorname");
		if(errorName != null && !(errorName.length() == 0)) {
			error.setName(errorName);
		}
		
		/* Error code */
		String errorCode = shape.getProperty("errorcode");
		if(errorCode != null && !(errorCode.length() == 0)) {
			error.setErrorCode(errorCode);
		}
		
		errorDef.setErrorRef(error);
		
		icEvent.getEventDefinition().add(errorDef);

		return icEvent;
	}

	@StencilId("IntermediateCancelEvent")
	public IntermediateCatchEvent createCancelEvent(GenericShape shape) {
		IntermediateCatchEvent icEvent = new IntermediateCatchEvent();

		CancelEventDefinition cancelDef = new CancelEventDefinition();
		icEvent.getEventDefinition().add(cancelDef);

		return icEvent;
	}

	@StencilId("IntermediateSignalEventCatching")
	public IntermediateCatchEvent createSignalEvent(GenericShape shape) {
		IntermediateCatchEvent icEvent = new IntermediateCatchEvent();

		SignalEventDefinition signalDef = new SignalEventDefinition();
		
		Signal signal = new Signal();
		
		/* Signal ID */
		signal.setId(SignavioUUID.generate());
		
		/* Signal name */
		String signalName = shape.getProperty("signalname");
		if(signalName != null && !(signalName.length() == 0)) {
			signal.setName(signalName);
		}
		
		signalDef.setSignalRef(signal);
		icEvent.getEventDefinition().add(signalDef);

		return icEvent;
	}

	@StencilId("IntermediateMultipleEventCatching")
	public IntermediateCatchEvent createMultipleEvent(GenericShape shape) {
		IntermediateCatchEvent icEvent = new IntermediateCatchEvent();
		
		icEvent.getEventDefinition().add(new CancelEventDefinition());
		icEvent.getEventDefinition().add(new TerminateEventDefinition());
		
		icEvent.setParallelMultiple(false);

		return icEvent;
	}

	@StencilId("IntermediateParallelMultipleEventCatching")
	public IntermediateCatchEvent createParallelMultipleEvent(GenericShape shape) {
		IntermediateCatchEvent icEvent = new IntermediateCatchEvent();
		
		icEvent.getEventDefinition().add(new CancelEventDefinition());
		icEvent.getEventDefinition().add(new TerminateEventDefinition());
		
		icEvent.setParallelMultiple(true);

		return icEvent;
	}

	public static void changeToBoundaryEvent(BPMNElement activity,
			BPMNElement event) {
		if (!(activity.getNode() instanceof Activity)
				|| !(event.getNode() instanceof IntermediateCatchEvent)) {
			return;
		}

		BoundaryEvent bEvent = new BoundaryEvent();
		bEvent.getEventDefinition().addAll(
				((Event) event.getNode()).getEventDefinition());
		
		/* Special boundary event attributes */
		bEvent.setAttachedToRef((Activity) activity.getNode());
		bEvent.setCancelActivity(!((IntermediateCatchEvent) event.getNode())
				.getCancelActivity().equalsIgnoreCase("false"));
		
		// bEvent.setProcessRef(event.get);
		bEvent.setId(event.getNode().getId());
		bEvent.setName(((IntermediateCatchEvent) event.getNode()).getName());
		bEvent.setParallelMultiple(((IntermediateCatchEvent) event.getNode())
				.isParallelMultiple());
		
		IntermediateCatchEvent ice = (IntermediateCatchEvent) event.getNode();
		event.setNode(bEvent);
		if(event.getShape() instanceof BPMNShape) {
			((BPMNShape) event.getShape()).setBpmnElement(bEvent);
		}
		((Activity) activity.getNode()).getBoundaryEventRefs().add(bEvent);

		/* Handle boundary events as child elements of a lane */
		if (ice.getLane() != null) {
			/* Exchange intermediate event with boundary event */
			bEvent.setLane(ice.getLane());
			int index = bEvent.getLane().getFlowNodeRef().indexOf(ice);
			bEvent.getLane().getFlowNodeRef().remove(ice);
			if(index != -1) {
				bEvent.getLane().getFlowNodeRef().add(index, bEvent);
			} else {
				bEvent.getLane().getFlowNodeRef().add(bEvent);
			}
		}
	}
}
