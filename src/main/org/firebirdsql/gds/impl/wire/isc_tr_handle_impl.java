/*
 * Firebird Open Source J2ee connector - jdbc driver
 *
 * Distributable under LGPL license.
 * You may obtain a copy of the License at http://www.gnu.org/copyleft/lgpl.html
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * LGPL License for more details.
 *
 * This file was created by members of the firebird development team.
 * All individual contributions remain the Copyright (C) of those
 * individuals.  Contributors to this file are either listed here or
 * can be obtained from a CVS history command.
 *
 * All rights reserved.
 */
/*
 * The Original Code is the Firebird Java GDS implementation.
 *
 * The Initial Developer of the Original Code is Alejandro Alberola.
 * Portions created by Alejandro Alberola are Copyright (C) 2001
 * Boix i Oltra, S.L. All Rights Reserved.
 */

package org.firebirdsql.gds.impl.wire;

import org.firebirdsql.gds.IscDbHandle;
import org.firebirdsql.gds.impl.AbstractIscTrHandle;


/**
 * Describe class <code>isc_tr_handle_impl</code> here.
 *
 * @author <a href="mailto:alberola@users.sourceforge.net">Alejandro Alberola</a>
 * @author <a href="mailto:d_jencks@users.sourceforge.net">David Jencks</a>
 * @version 1.0
 */
public final class isc_tr_handle_impl extends AbstractIscTrHandle {
    private int rtr_id;
    private IscDbHandle rtr_rdb;
    private int state = NOTRANSACTION;

    public isc_tr_handle_impl() {
    }

    public IscDbHandle getDbHandle() {
        return rtr_rdb;
    }

    void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    void setTransactionId(final int rtr_id)
    {
        this.rtr_id = rtr_id;
    }

    int getTransactionId()
    {
        return rtr_id;
    }

    void setDbHandle(final IscDbHandle db)
    {
        this.rtr_rdb = db;
        rtr_rdb.addTransaction(this);
    }

    void unsetDbHandle()
    {
        rtr_rdb.removeTransaction(this);
        rtr_rdb = null;
    }

    public int hashCode() {
        return rtr_id;
    }
    
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof isc_tr_handle_impl)) return false;
        isc_tr_handle_impl that = (isc_tr_handle_impl)obj;
        return this.rtr_id == that.rtr_id;
    }
}
