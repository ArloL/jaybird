/*
 * Firebird Open Source JavaEE Connector - JDBC Driver
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
 * can be obtained from a source control history command.
 *
 * All rights reserved.
 */
package org.firebirdsql.gds.ng.wire.auth;

/**
 * Srp256 authentication plugin service provider.
 *
 * @author <a href="mailto:mrotteveel@users.sourceforge.net">Mark Rotteveel</a>
 * @since 3.0.5
 */
public class Srp256AuthenticationPluginSpi implements AuthenticationPluginSpi {

    @SuppressWarnings("WeakerAccess")
    public static final String SRP_AUTH_NAME = "Srp256";

    @Override
    public String getPluginName() {
        return SRP_AUTH_NAME;
    }

    @Override
    public AuthenticationPlugin createPlugin() {
        return new SrpAuthenticationPlugin(SRP_AUTH_NAME, "SHA-256");
    }
    
}