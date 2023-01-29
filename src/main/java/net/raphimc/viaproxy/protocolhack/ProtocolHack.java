/*
 * This file is part of ViaProxy - https://github.com/RaphiMC/ViaProxy
 * Copyright (C) 2023 RK_01/RaphiMC and contributors
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
 */
package net.raphimc.viaproxy.protocolhack;

import net.raphimc.viaprotocolhack.ViaProtocolHack;
import net.raphimc.viaprotocolhack.impl.platform.ViaLegacyPlatformImpl;
import net.raphimc.viaproxy.plugins.PluginManager;
import net.raphimc.viaproxy.plugins.events.ProtocolHackInitEvent;
import net.raphimc.viaproxy.protocolhack.impl.*;

import java.util.function.Supplier;

public class ProtocolHack {

    public static void init() {
        final Supplier<?>[] additionalPlatformSuppliers = PluginManager.EVENT_MANAGER.call(new ProtocolHackInitEvent(ViaAprilFoolsPlatformImpl::new)).getPlatformSuppliers().toArray(new Supplier[0]);
        ViaProtocolHack.init(new ViaProxyViaVersionPlatformImpl(), new ViaProxyVPLoader(), null, null, ViaProxyViaBackwardsPlatformImpl::new, ViaProxyViaRewindPlatformImpl::new, ViaLegacyPlatformImpl::new, additionalPlatformSuppliers);
    }

}
