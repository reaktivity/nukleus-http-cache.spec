/**
 * Copyright 2016-2021 The Reaktivity Project
 *
 * The Reaktivity Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.reaktivity.specification.nukleus.http_cache.streams;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.rules.RuleChain.outerRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.kaazing.k3po.junit.annotation.Specification;
import org.kaazing.k3po.junit.rules.K3poRule;
import org.reaktivity.specification.nukleus.NukleusRule;

public class EdgeArchProxyConnectIT
{
    private final K3poRule k3po = new K3poRule()
            .addScriptRoot("streams", "org/reaktivity/specification/nukleus/http_cache/streams/proxy/edge-arch");

    private final TestRule timeout = new DisableOnDebug(new Timeout(5, SECONDS));

    private final NukleusRule nukleus = new NukleusRule()
            .directory("target/nukleus-itests");

    @Rule
    public final TestRule chain = outerRule(nukleus).around(k3po).around(timeout);

    @Test
    @Specification({
        "${streams}/does.not.inject.on.post/connect/client",
        "${streams}/does.not.inject.on.post/connect/server",
        })
    public void shouldNotInjectOnPost() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/does.not.inject.on.non-cacheable.response/connect/client",
        "${streams}/does.not.inject.on.non-cacheable.response/connect/server",
    })
    public void shouldNotInjectOnNonCacheableResponse() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/serve.from.cache.when.freshness.extension.is.valid/connect/client",
        "${streams}/serve.from.cache.when.freshness.extension.is.valid/connect/server",
    })
    public void serveFromCacheWhenFreshnessExtensionIsValid() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/share.with.x-protected.scope/connect/client",
        "${streams}/share.with.x-protected.scope/connect/server",
    })
    public void shareWithXProtectedScope() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/does.not.share.with.different.protected.scope/connect/client",
        "${streams}/does.not.share.with.different.protected.scope/connect/server",
    })
    public void doesNotShareWithDifferentProtectedScope() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/freshness-extension.inject.individualized.push.promises/connect/client",
        "${streams}/freshness-extension.inject.individualized.push.promises/connect/server",
    })
    public void shouldInjectIndividualizedPushPromisesOnSharedFreshnessExtension() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/inject.stale-while-revalidate.push-promise.no-cache/connect/client",
        "${streams}/inject.stale-while-revalidate.push-promise.no-cache/connect/server",
    })
    public void shouldInjectValuesOnFreshnessExtension() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/polling.updates.pending.on-update.requests/connect/client",
        "${streams}/polling.updates.pending.on-update.requests/connect/server",
    })
    public void shouldUpdateOnUpdateRequestsWhenPollCompletes() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/polling.403.response.cancels.pending.on-update.requests/connect/client",
        "${streams}/polling.403.response.cancels.pending.on-update.requests/connect/server",
    })
    public void shouldCancelPushPromisesOn403() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/polling.304.response.does.not.cancel.pending.on-update.requests/connect/client",
        "${streams}/polling.304.response.does.not.cancel.pending.on-update.requests/connect/server",
    })
    public void shouldNotCancelPushPromiseOn304() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/no.authorization.sends.cache.control.private/connect/client",
        "${streams}/no.authorization.sends.cache.control.private/connect/server",
    })
    public void noAuthorizationSendsCacheControlPrivate() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/no.authorization.sends.cache.control.private.except.when.public/connect/client",
        "${streams}/no.authorization.sends.cache.control.private.except.when.public/connect/server",
    })
    public void noAuthorizationSendsCacheControlPrivateExceptWhenPublic() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/polling.vary.header.mismatch/connect/client",
        "${streams}/polling.vary.header.mismatch/connect/server",
    })
    public void pollingVaryHeaderMismatch() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/polling.vary.header.value.mismatch/connect/client",
        "${streams}/polling.vary.header.value.mismatch/connect/server",
    })
    public void pollingVaryHeadeValuerMismatch() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/polling.vary.header.asterisk/connect/client",
        "${streams}/polling.vary.header.asterisk/connect/server",
    })
    public void pollingVaryHeaderAsterisk() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/cache.sends.503.retry-after/connect/client",
        "${streams}/cache.sends.503.retry-after/connect/server",
    })
    public void sends503RetryAfter() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }
}
