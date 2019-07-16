/**
 * Copyright 2016-2019 The Reaktivity Project
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

public class EdgeArchProxyAcceptIT
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
        "${streams}/does.not.inject.on.post/accept/client",
        "${streams}/does.not.inject.on.post/accept/server",
        })
    public void shouldNotInjectOnPost() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/does.not.inject.on.non-cacheable.response/accept/client",
        "${streams}/does.not.inject.on.non-cacheable.response/accept/server",
    })
    public void shouldNotInjectOnNonCacheableResponse() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/serve.from.cache.when.freshness.extension.is.valid/accept/client",
        "${streams}/serve.from.cache.when.freshness.extension.is.valid/accept/server",
    })
    public void serveFromCacheWhenFreshnessExtensionIsValid() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/share.with.x-protected.scope/accept/client",
        "${streams}/share.with.x-protected.scope/accept/server",
    })
    public void shareWithXProtectedScope() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/does.not.share.with.different.protected.scope/accept/client",
        "${streams}/does.not.share.with.different.protected.scope/accept/server",
    })

    public void doesNotShareWithDifferentProtectedScope() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/freshness-extension.inject.individualized.push.promises/accept/client",
        "${streams}/freshness-extension.inject.individualized.push.promises/accept/server",
    })
    public void shouldInjectIndividualizedPushPromisesOnSharedFreshnessExtension() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/inject.stale-while-revalidate.push-promise.no-cache/accept/client",
        "${streams}/inject.stale-while-revalidate.push-promise.no-cache/accept/server",
    })
    public void shouldInjectValuesOnFreshnessExtension() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/inject.and.update.stale-while-revalidate/accept/client",
        "${streams}/inject.and.update.stale-while-revalidate/accept/server",
    })
    public void shouldInjectAndUpdateStaleWhileRevalidate() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/cache.and.poll.on.surrogate.max-age.when.fresh.ext/accept/client",
        "${streams}/cache.and.poll.on.surrogate.max-age.when.fresh.ext/accept/server",
    })
    public void shouldCacheAndPollOnSurrogateMaxAgeWhenFreshExt() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/polling.updates.cache/accept/client",
        "${streams}/polling.updates.cache/accept/server",
    })
    public void shouldUpdateCacheOnPoll() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/polling.updates.after.cache.full/accept/client",
        "${streams}/polling.updates.after.cache.full/accept/server",
    })
    public void pollingUpdateShouldRemoveCacheEntry() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/polling.updates.cache.after.503.retry-after/accept/client",
        "${streams}/polling.updates.cache.after.503.retry-after/accept/server",
    })
    public void shouldUpdateCacheOnPollAfter503RetryAfter() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/polling.waits.on.surrogate-age/accept/client",
        "${streams}/polling.waits.on.surrogate-age/accept/server",
    })
    public void pollingWaitsOnSurrogateAge() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/polling.updates.pending.on-update.requests/accept/client",
        "${streams}/polling.updates.pending.on-update.requests/accept/server",
    })
    public void shouldUpdateOnUpdateRequestsWhenPollCompletes() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/polling.update.attachs.to.next.cache.if.push.promise.arrives.before.response.completes/accept/client",
        "${streams}/polling.update.attachs.to.next.cache.if.push.promise.arrives.before.response.completes/accept/server",
    })
    public void shouldAttachToNextCacheEntryIfPushPromiseArrivesBeforeResponseCompletes() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/polling.updates.pending.on-update.requests.only.when.modified/accept/client",
        "${streams}/polling.updates.pending.on-update.requests.only.when.modified/accept/server",
    })
    public void shouldUpdateOnUpdateRequestsOnlyWhenModified() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/failed.polling.aborts.pending.on-update.requests/accept/client",
        "${streams}/failed.polling.aborts.pending.on-update.requests/accept/server",
    })
    public void shouldAbortPendingOnUpdateRequestsWhenFailedPollingUpdates() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/failed.polling.aborts.pending.on-update.requests.and.recovers/accept/client",
        "${streams}/failed.polling.aborts.pending.on-update.requests.and.recovers/accept/server",
    })
    public void shouldAbortPendingOnUpdateRequestsWhenFailedPollingUpdatesAndRecovers() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/polling.403.response.cancels.pending.on-update.requests/accept/client",
        "${streams}/polling.403.response.cancels.pending.on-update.requests/accept/server",
    })
    public void shouldCancelPushPromisesOn403() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/polling.304.response.does.not.cancel.pending.on-update.requests/accept/client",
        "${streams}/polling.304.response.does.not.cancel.pending.on-update.requests/accept/server",
    })
    public void shouldNotCancelPushPromiseOn304() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/polling.stops.if.no.subscribers/accept/client",
        "${streams}/polling.stops.if.no.subscribers/accept/server",
    })
    public void shouldStopPollingIfNoSubscribers() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/polling.stops.if.no.subscribers.and.not.updated/accept/client",
        "${streams}/polling.stops.if.no.subscribers.and.not.updated/accept/server",
    })
    public void shouldStopPollingIfNoSubscribersAndNotUpdated() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/maintain.polling.per.multiple.auth.scopes/accept/client",
        "${streams}/maintain.polling.per.multiple.auth.scopes/accept/server",
    })
    public void shouldMaintainPollingForMultipleAuthScopes() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/no.authorization.sends.cache.control.private/accept/client",
            "${streams}/no.authorization.sends.cache.control.private/accept/server",
    })
    public void noAuthorizationSendsCacheControlPrivate() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/no.authorization.sends.cache.control.private.except.when.public/accept/client",
            "${streams}/no.authorization.sends.cache.control.private.except.when.public/accept/server",
    })
    public void noAuthorizationSendsCacheControlPrivateExceptWhenPublic() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/polling.vary.header.mismatch/accept/client",
            "${streams}/polling.vary.header.mismatch/accept/server",
    })
    public void pollingVaryHeaderMismatch() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/polling.vary.header.value.mismatch/accept/client",
            "${streams}/polling.vary.header.value.mismatch/accept/server",
    })
    public void pollingVaryHeaderValuerMismatch() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/polling.vary.header.asterisk/accept/client",
            "${streams}/polling.vary.header.asterisk/accept/server",
    })
    public void pollingVaryHeaderAsterisk() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/push.promise.after.cache.full/accept/client",
        "${streams}/push.promise.after.cache.full/accept/server",
    })
    public void pushPromiseAfterCacheFull() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/cache.sends.503.retry-after/accept/client",
        "${streams}/cache.sends.503.retry-after/accept/server",
    })
    public void sends503RetryAfter() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/update.cache.when.304.response.has.matching.etag/accept/client",
        "${streams}/update.cache.when.304.response.has.matching.etag/accept/server",
    })
    public void shouldUpdateCacheHeadersOn304ForMatchingEtag() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/update.cache.when.200.response.has.different.etag/accept/client",
        "${streams}/update.cache.when.200.response.has.different.etag/accept/server",
    })
    public void shouldUpdateCacheWhen200ResponseHasDifferentEtag() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/update.cache.when.200.response.doesnot.have.etag/accept/client",
        "${streams}/update.cache.when.200.response.doesnot.have.etag/accept/server",
    })
    public void shouldCacheWhen200ResponseDoesnotHaveEtag() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/does.not.serve.from.cache.if.no.subscribers/accept/client",
        "${streams}/does.not.serve.from.cache.if.no.subscribers/accept/server",
    })
    public void shouldBypassCacheIfEntryIsStaleAndNotRefreshing() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

}
