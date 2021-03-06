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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import de.hpi.bpmn2_0.transformation.Visitor;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tSocialNetworkEvent")
public class SocialNetworkEvent
    extends Event
{
	protected String cancelActivity;
	
	
	
	
	public void acceptVisitor(Visitor v){
		v.visitSocialNetworkEvent(this);
	}
	
	/**
	 * Avoid null values.
	 * 
	 * @return the cancelActivity
	 */
	public String getCancelActivity() {
		if(cancelActivity == null)
			return "";
		return cancelActivity;
	}

	/**
	 * @param cancelActivity the cancelActivity to set
	 */
	public void setCancelActivity(String cancelActivity) {
		this.cancelActivity = cancelActivity;
	}
	
	

}
