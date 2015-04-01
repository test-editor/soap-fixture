/*******************************************************************************
 * Copyright (c) 2012 - 2015 Signal Iduna Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Signal Iduna Corporation - initial API and implementation
 * akquinet AG
 *******************************************************************************/
package org.testeditor.fixture.webservice.soap;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.xml.namespace.NamespaceContext;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class SimpleNamespaceContext implements NamespaceContext {

	private BiMap<String, String> namespaceByPrefix = HashBiMap.create();

	public void addNamespacePrefix(String prefix, String namespace) {
		namespaceByPrefix.put(prefix, namespace);
	}

	public String getNamespaceURI(String prefix) {
		return namespaceByPrefix.get(prefix);
	}

	public String getPrefix(String namespaceURI) {
		return namespaceByPrefix.inverse().get(namespaceURI);
	}

	@SuppressWarnings("rawtypes")
	public Iterator getPrefixes(String namespaceURI) {
		return Collections.singleton(getPrefix(namespaceURI)).iterator();
	}

	public void clear() {
		namespaceByPrefix.clear();
	}

	public Iterable<Entry<String, String>> allNamespaces() {
		return namespaceByPrefix.entrySet();
	}

}