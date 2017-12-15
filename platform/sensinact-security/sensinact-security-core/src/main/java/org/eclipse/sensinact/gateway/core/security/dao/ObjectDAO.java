/*
 * Copyright (c) 2017 CEA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    CEA - initial API and implementation
 */
package org.eclipse.sensinact.gateway.core.security.dao;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.eclipse.sensinact.gateway.common.bundle.Mediator;
import org.eclipse.sensinact.gateway.core.security.entity.ObjectEntity;
import org.eclipse.sensinact.gateway.util.UriUtils;

/**
 * Method DAO 
 * 
 * @author <a href="mailto:christophe.munilla@cea.fr">Christophe Munilla</a>
 */
public class ObjectDAO extends AbstractMutableSnaDAO<ObjectEntity>
{
	//********************************************************************//
	//						NESTED DECLARATIONS	     					  //
	//********************************************************************//

	//********************************************************************//
	//						ABSTRACT DECLARATIONS						  //
	//********************************************************************//

	//********************************************************************//
	//						STATIC DECLARATIONS  						  //
	//********************************************************************//
	
	private static final String ANY_REGEX = "[^/]+";
	
	private static final String ANY_REPLACEMENT = "#ANY#";
	
	//********************************************************************//
	//						INSTANCE DECLARATIONS						  //
	//********************************************************************//
		
	/**
	 * Constructor
	 * 
	 * @param mediator
	 * 		the {@link Mediator} allowing to
	 * 		interact with the OSGi host environment
	 * 
	 * @throws DAOException 
	 */
    public ObjectDAO(Mediator mediator) throws DAOException
    {
	    super(mediator, ObjectEntity.class);

		super.registerUserDefinedSelectStatement(
			"getObjectFromPath",
			new UserDefinedSelectStatement(mediator, 
			"script/getObjectFromPath.sql"));
    }
   
    /**
     * Returns the {@link ObjectEntity} from the datastore 
     * matching the given String path, otherwise null.
     * 
     * @param mediator the {@link Mediator} to interact with the
     * OSGi host environment
     * @param path The String path of the {@link ObjectEntity} 
     * to be returned.
     * 
     * @return the {@link ObjectEntity} from the datastore matching 
     * the given String path, otherwise null.
     * 
     * @throws DAOException 
     */
    public ObjectEntity find(String path) throws DAOException 
    {
    	return find(path, false);
    }    

    /**
     * Returns the {@link ObjectEntity} from the datastore 
     * matching the given String path, otherwise null.
     * 
     * @param mediator the {@link Mediator} to interact with the
     * OSGi host environment
     * @param path The String path of the {@link ObjectEntity} 
     * to be returned.
     * @param exact returns the last {@link ObjectEntity} matching 
     * the path if false or the {@link ObjectEntity} matching the entire 
     * path only otherwise
     * 
     * @return the {@link ObjectEntity} from the datastore matching 
     * the given String path, otherwise null.
     * @throws DAOException 
     * 
     */
    public ObjectEntity find(String path, boolean exact) 
    		throws DAOException 
    {    	
    	if(path == null)
    	{
    		return null;
    	}
		List<ObjectEntity> objectEntities = super.select(
			"getObjectFromPath", path);
		
		if(objectEntities.size() != 1)
		{ 	
			return null;
		}
		ObjectEntity tmpEntity = objectEntities.get(0);
		
		if(!exact || tmpEntity == null  || path.equals(tmpEntity.getPath()))
		{ 
		   return tmpEntity;
		}		
		String[] uriElements = UriUtils.getUriElements(path);
		
		String objectPath = tmpEntity.getPath();
		
		String[] objectPathElements = (objectPath != null)?
			UriUtils.getUriElements(objectPath.replace(ANY_REGEX, 
				ANY_REPLACEMENT)):new String[0];
		
		if(uriElements.length == objectPathElements.length)
		{
			String lastSearched = uriElements[uriElements.length-1];
			String lastFound = objectPathElements[uriElements.length-1];
			
			try
			{
				if(lastFound.equals(ANY_REPLACEMENT) 
					|| lastSearched.equals(lastFound) 
					|| Pattern.matches(lastFound, lastSearched))
				{
					return tmpEntity;
				} 
			}
			catch(PatternSyntaxException e)
			{
				mediator.debug("exact path '%s' not found", path);
			}
		}
		return null;
    }

    /**
     * Returns the list of {@link ObjectEntity}s from the datastore 
     * whose parent {@link ObjectEntity} matches the long identifier
     * passed as parameter.
     * 
     * @param identifier the long identifier of the parent {@link 
     * ObjectEntity} of those to be returned.
     * 
     * @return the list of {@link ObjectEntity}s from the datastore 
     * whose parent {@link ObjectEntity} matches the given long identifier.
     * 
     * @throws DAOException 
     */
	public List<ObjectEntity> findChildren(final long identifier) 
			throws DAOException
	{
		return super.select(new HashMap<String,Object>(){{
			this.put("PARENT",identifier);
		}});
	}
}
