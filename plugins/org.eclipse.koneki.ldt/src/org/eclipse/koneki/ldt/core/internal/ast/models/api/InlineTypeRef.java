/*******************************************************************************
 * Copyright (c) 2011, 2013 Sierra Wireless and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sierra Wireless - initial API and implementation
 *******************************************************************************/
package org.eclipse.koneki.ldt.core.internal.ast.models.api;

public class InlineTypeRef extends TypeRef {

	private TypeDef definition;

	public InlineTypeRef(TypeDef definition) {
		super();
		this.definition = definition;
	}

	public TypeDef getDefinition() {
		return definition;
	}

	public void setDefinition(TypeDef definition) {
		this.definition = definition;
	}

	/**
	 * @see org.eclipse.koneki.ldt.core.internal.ast.models.api.TypeRef#toReadableString()
	 */
	@Override
	public String toReadableString() {
		if (definition instanceof RecordTypeDef) {
			RecordTypeDef recordTypeDef = (RecordTypeDef) definition;
			if (recordTypeDef.getName().equals("list")) //$NON-NLS-1$
				return String.format("#list<%s>", recordTypeDef.getDefaultvaluetyperef().toReadableString()); //$NON-NLS-1$
			else if (recordTypeDef.getName().equals("map")) //$NON-NLS-1$
				return String
						.format("#map<%s,%s>", recordTypeDef.getDefaultkeytyperef().toReadableString(), recordTypeDef.getDefaultvaluetyperef().toReadableString()); //$NON-NLS-1$
			else
				return "#table"; //$NON-NLS-1$
		} else if (definition instanceof FunctionTypeDef) {
			return "#function"; //$NON-NLS-1$
		} else {
			return null;
		}
	}
}
