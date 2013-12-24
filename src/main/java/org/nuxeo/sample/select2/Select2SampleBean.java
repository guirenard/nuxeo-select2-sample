/*
 * (C) Copyright 2013 Nuxeo SA (http://nuxeo.com/) and contributors.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * Contributors:
 *     guillaume
 */
package org.nuxeo.sample.select2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.web.RequestParameter;
import org.nuxeo.ecm.core.api.ClientException;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.IdRef;
import org.nuxeo.ecm.core.api.PathRef;
import org.nuxeo.ecm.platform.ui.web.api.NavigationContext;

/**
 * Select2 sample bean.
 *
 */
@Name("select2SampleBean")
@Scope(ScopeType.PAGE)
public class Select2SampleBean {

    private static final Log log = LogFactory.getLog(Select2SampleBean.class);

    @In(create = true)
    protected transient NavigationContext navigationContext;

    @In(create = true, required = false)
    protected transient CoreSession documentManager;

    @RequestParameter
    private String docId;

    private DocumentModel doc = null;

    public DocumentModel getDoc() {
        if (doc == null) {
            if (docId != null) {
                IdRef ref = new IdRef(docId);
                try {
                    doc = documentManager.getDocument(ref);
                } catch (ClientException e) {
                    log.error("Could not find document: " + docId);
                }
            }
        }
        return doc;
    }

    public void setDoc(DocumentModel doc) {
        this.doc = doc;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
        if (docId != null) {
            PathRef ref = new PathRef(docId);
            try {
                doc = documentManager.getDocument(ref);
            } catch (ClientException e) {
                log.error("Could not find document: " + docId);
            }
        }
    }

}
