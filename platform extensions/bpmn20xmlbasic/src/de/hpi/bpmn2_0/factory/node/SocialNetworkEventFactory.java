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
import de.hpi.bpmn2_0.model.BaseElement;
import de.hpi.bpmn2_0.model.data_object.Account;
import de.hpi.bpmn2_0.model.data_object.Template;
import de.hpi.bpmn2_0.model.data_object.TemplateRule;
import de.hpi.bpmn2_0.model.event.FacebookEventDefinition;
import de.hpi.bpmn2_0.model.event.LinkedinEventDefinition;
import de.hpi.bpmn2_0.model.event.SocialNetworkEvent;
import de.hpi.bpmn2_0.model.event.TwitterEventDefinition;

/**
 * Factory to create intermediate catching Events
 * 
 * @author Philipp Giese
 * @author Sven Wagner-Boysen
 * 
 */
@StencilId( { "Facebook","Twitter",	"Linkedin" })
public class SocialNetworkEventFactory extends AbstractShapeFactory {

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
			SocialNetworkEvent soEvent = (SocialNetworkEvent) this
					.invokeCreatorMethod(shape);
			soEvent.setId(shape.getResourceId());
			soEvent.setName(shape.getProperty("name"));
			soEvent.setCancelActivity(shape
					.getProperty("boundarycancelactivity2"));

			return soEvent;
		} catch (Exception e) {
			/* Wrap exceptions into specific BPMNConverterException */
			throw new BpmnConverterException(
					"Error while creating the process element of "
							+ shape.getStencilId(), e);
		}

	}

	/* Creator methods for different event definitions */

	@StencilId("Facebook")
	public SocialNetworkEvent createFacebookEvent(GenericShape shape) {
		SocialNetworkEvent soEvent = new SocialNetworkEvent();
		FacebookEventDefinition fbEvDef = new FacebookEventDefinition();
		
		String accountName = shape.getProperty("account");
		if(accountName != null && !(accountName.length() == 0)) {
			Account account = new Account();
			account.setName(accountName);
			fbEvDef.setAccount(account);
		}
		
		String targetPage = shape.getProperty("target_page");
		if(targetPage != null && !(targetPage.length() == 0)) {
			fbEvDef.setTargetPage(targetPage);
		}
		/* Template */
		String templateName = shape.getProperty("template");
		if(templateName != null && !(templateName.length() == 0)){
			Template template = new Template();
			template.setName(templateName);
			fbEvDef.setTemplate(template);
		}
		/* TemplateRule */
		String templateRuleName = shape.getProperty("template_rule");
		if(templateRuleName != null && !(templateRuleName.length() == 0)){
			TemplateRule templateRule = new TemplateRule();
			templateRule.setName(templateRuleName);
			fbEvDef.setTemplateRule(templateRule);
		}
		String privateMessage = shape.getProperty("private_message");
		if(privateMessage != null && !(privateMessage.length() == 0)) {
			fbEvDef.setPrivateMessage(Boolean.parseBoolean(privateMessage));
		}
		
		String persist = shape.getProperty("persist");
		if(persist != null && !(persist.length() == 0)){ 
			fbEvDef.setPersist(Boolean.parseBoolean(persist));
		}
		
		soEvent.getEventDefinition().add(fbEvDef);
		return soEvent;
	}
	
	@StencilId("Twitter")
	public SocialNetworkEvent createTwitterEvent(GenericShape shape) {
		SocialNetworkEvent soEvent = new SocialNetworkEvent();
		TwitterEventDefinition twEvDef = new TwitterEventDefinition();
		
		String accountName = shape.getProperty("account");
		if(accountName != null && !(accountName.length() == 0)) {
			Account account = new Account();
			account.setName(accountName);
			twEvDef.setAccount(account);
		}
		
		String privateMessage = shape.getProperty("private_message");
		if(privateMessage != null && !(privateMessage.length() == 0)) {
			twEvDef.setPrivateMessage(Boolean.parseBoolean(privateMessage));
		}
		
		/* Template */
		String templateName = shape.getProperty("template");
		if(templateName != null && !(templateName.length() == 0)){
			Template template = new Template();
			template.setName(templateName);
			twEvDef.setTemplate(template);
		}
		/* TemplateRule */
		String templateRuleName = shape.getProperty("template_rule");
		if(templateRuleName != null && !(templateRuleName.length() == 0)){
			TemplateRule templateRule = new TemplateRule();
			templateRule.setName(templateRuleName);
			twEvDef.setTemplateRule(templateRule);
		}
		String persist = shape.getProperty("persist");
		if(persist != null && !(persist.length() == 0)){ 
			twEvDef.setPersist(Boolean.parseBoolean(persist));
		}
		
		soEvent.getEventDefinition().add(twEvDef);
		return soEvent;
	}
	
	@StencilId("Linkedin")
	public SocialNetworkEvent createLinkedinEvent(GenericShape shape) {
		SocialNetworkEvent soEvent = new SocialNetworkEvent();
		LinkedinEventDefinition liEvDef = new LinkedinEventDefinition();
		
		String accountName = shape.getProperty("account");
		if(accountName != null && !(accountName.length() == 0)) {
			Account account = new Account();
			account.setName(accountName);
			liEvDef.setAccount(account);
		}
		
		String privateMessage = shape.getProperty("private_message");
		if(privateMessage != null && !(privateMessage.length() == 0)) {
			liEvDef.setPrivateMessage(Boolean.parseBoolean(privateMessage));
		}
		/* Template */
		String templateName = shape.getProperty("template");
		if(templateName != null && !(templateName.length() == 0)){
			Template template = new Template();
			template.setName(templateName);
			liEvDef.setTemplate(template);
		}
		/* TemplateRule */
		String templateRuleName = shape.getProperty("template_rule");
		if(templateRuleName != null && !(templateRuleName.length() == 0)){
			TemplateRule templateRule = new TemplateRule();
			templateRule.setName(templateRuleName);
			liEvDef.setTemplateRule(templateRule);
		}
		String persist = shape.getProperty("persist");
		if(persist != null && !(persist.length() == 0)){ 
			liEvDef.setPersist(Boolean.parseBoolean(persist));
		}
		
		soEvent.getEventDefinition().add(liEvDef);
		return soEvent;
	}

	
	
}
