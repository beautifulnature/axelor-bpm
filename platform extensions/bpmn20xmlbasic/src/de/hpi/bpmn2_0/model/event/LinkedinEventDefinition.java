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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import de.hpi.bpmn2_0.model.data_object.Account;
import de.hpi.bpmn2_0.model.data_object.Template;
import de.hpi.bpmn2_0.model.data_object.TemplateRule;




@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tLinkedinEventDefinition", propOrder = {
    "account",
    "privateMessage",
    "template",
    "templateRule"
})
public class LinkedinEventDefinition
    extends EventDefinition
{
	
	@XmlElement
	protected Account account;
	
	@XmlAttribute
	protected Boolean privateMessage;
	
	@XmlElement
	protected Template template;
	
	@XmlElement
	protected TemplateRule templateRule;
	
	@XmlAttribute
    protected Boolean persist;
    
    /* Constructors */
    public LinkedinEventDefinition() {
    	super();
    }
    
    public Account getAccount(){
		return this.account;
	}
	
	public void setAccount(Account account){
		this.account = account;
	}
	
	public Boolean getPrivateMessage(){
		return this.privateMessage;
	}
	
	public void setPrivateMessage(Boolean privateMessage){
		this.privateMessage = privateMessage;
	}
	
	public Template getTemplate(){
    	return this.template;
    }
    
    public void setTemplate(Template template){
    	this.template = template;
    }
    
    public TemplateRule getTemplateRule(){
    	return this.templateRule;
    }
    
    public void setTemplateRule(TemplateRule templateRule){
    	this.templateRule = templateRule;
    }
    
    public Boolean getPersist(){
    	return this.persist;
    }
    
    public void setPersist(Boolean persist){
    	this.persist = persist;
    }
    
    
    

}
