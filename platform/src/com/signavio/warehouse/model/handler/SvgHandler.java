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
package com.signavio.warehouse.model.handler;

import javax.servlet.ServletContext;

import com.signavio.platform.annotations.HandlerConfiguration;
import com.signavio.platform.annotations.HandlerExportConfiguration;
import com.signavio.platform.annotations.HandlerMethodActivation;
import com.signavio.platform.security.business.FsSecureBusinessObject;
import com.signavio.warehouse.model.business.FsModel;
import com.signavio.warehouse.revision.handler.AbstractRevisionExportHandler;

@HandlerConfiguration(uri="/svg", context=ModelHandler.class, rel="exp")
@HandlerExportConfiguration(name="SVG", icon="/explorer/src/img/famfamfam/page_white_vector.png", mime="image/svg+xml")
public class SvgHandler extends AbstractRevisionExportHandler {

	public SvgHandler(ServletContext servletContext) {
		super(servletContext);
	}
	
	@Override
	@HandlerMethodActivation
	public  <T extends FsSecureBusinessObject> byte[] doExport(T sbo, Object params){
		FsModel model = (FsModel) sbo;
		return new com.signavio.warehouse.revision.handler.SvgHandler(this.getServletContext())
				.doExport(model.getHeadRevision(), params);
	}
}
