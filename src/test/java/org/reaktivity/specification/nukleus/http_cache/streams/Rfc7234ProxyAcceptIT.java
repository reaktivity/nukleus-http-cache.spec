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

public class Rfc7234ProxyAcceptIT
{
    private final K3poRule k3po = new K3poRule()
            .addScriptRoot("streams", "org/reaktivity/specification/nukleus/http_cache/streams/proxy/rfc7234");

    private final TestRule timeout = new DisableOnDebug(new Timeout(5, SECONDS));

    private final NukleusRule nukleus = new NukleusRule()
            .directory("target/nukleus-itests");

    @Rule
    public final TestRule chain = outerRule(nukleus).around(k3po).around(timeout);

    @Test
    @Specification({
        "${streams}/proxy.get.request/accept/client",
        "${streams}/proxy.get.request/accept/server",
        })
    public void shouldProxyGetRequest() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/proxy.get.request.with.body/accept/client",
        "${streams}/proxy.get.request.with.body/accept/server",
        })
    public void shouldProxyGetRequestWithBody() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/proxy.get.request.with.transfer.encoding/accept/client",
        "${streams}/proxy.get.request.with.transfer.encoding/accept/server",
    })
    public void shouldProxyGetRequestWithTransferEncoding() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/proxy.post.request/accept/client",
        "${streams}/proxy.post.request/accept/server",
    })
    public void shouldProxyPostRequest() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/proxy.request.and.304/accept/client",
        "${streams}/proxy.request.and.304/accept/server",
    })
    public void shouldProxyRequestWith304() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/cache.request.and.304/accept/client",
        "${streams}/cache.request.and.304/accept/server",
    })
    public void shouldCacheRequestWith304() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/cache.max-age/accept/client",
        "${streams}/cache.max-age/accept/server",
    })
    public void shouldCacheMaxAge() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/503.retry-after/accept/client",
        "${streams}/503.retry-after/accept/server",
    })
    public void shouldRetryFor503RetryAfter() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/request.greater.max-age/accept/client",
            "${streams}/request.greater.max-age/accept/server",
    })
    public void shouldNotCacheWhenResponseAgeIsGreaterThanMaxAge() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/request.lesser.max-age/accept/client",
            "${streams}/request.lesser.max-age/accept/server",
    })
    public void shouldCacheRequestMaxAge() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/cache.min-fresh/accept/client",
            "${streams}/cache.min-fresh/accept/server",
    })
    public void shouldCacheMinFresh() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.awaitBarrier("REQUEST_CACHED");
        k3po.notifyBarrier("CACHE_WAIT_1_SEC");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/expire.min-fresh/accept/client",
            "${streams}/expire.min-fresh/accept/server",
    })
    public void shouldExpireMinFresh() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/expire.max-age/accept/client",
        "${streams}/expire.max-age/accept/server",
    })
    public void shouldExpireMaxAge() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/cache.max-stale.with.value/accept/client",
        "${streams}/cache.max-stale.with.value/accept/server",
    })
    public void shouldCacheMaxStaleWithValue() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/cache.max-stale.no.value/accept/client",
        "${streams}/cache.max-stale.no.value/accept/server",
    })
    public void shouldCacheMaxStaleWithNoValue() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/cache.max-stale.with.max-age/accept/client",
            "${streams}/cache.max-stale.with.max-age/accept/server",
    })
    public void shouldCacheMaxStaleWithMaxAge() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/expire.max-stale/accept/client",
            "${streams}/expire.max-stale/accept/server",
    })
    public void shouldExpireMaxStale() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/request.cache.max-age=0/accept/client",
            "${streams}/request.cache.max-age=0/accept/server",
    })
    public void shouldRequestCacheMaxAgeZero() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/request.cache.max-age=0.and.304/accept/client",
        "${streams}/request.cache.max-age=0.and.304/accept/server",
    })
    public void shouldRequestCacheMaxAgeZeroAnd304() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/request.no-cache/accept/client",
        "${streams}/request.no-cache/accept/server",
    })
    public void shouldRequestNoCache() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/request.only-if-cached/accept/client",
            "${streams}/request.only-if-cached/accept/server",
    })
    public void shouldRequestOnlyIfCached() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/request.only-if-cached.and.504/accept/client",
        "${streams}/request.only-if-cached.and.504/accept/server",
    })
    public void shouldRequestOnlyIfCachedAnd504() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/request.expire.only-if-cached/accept/client",
        "${streams}/request.expire.only-if-cached/accept/server",
    })
    public void shouldRequestExpireOnlyIfCached() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/should.bypass.cache.on.no.cache/accept/client",
        "${streams}/should.bypass.cache.on.no.cache/accept/server",
    })
    public void shouldByPassCacheOnNoCache() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/cache.get.request.with.no-store/accept/client",
        "${streams}/cache.get.request.with.no-store/accept/server",
    })
    public void shouldCacheGetRequestWithNoStore() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/cache.get.request.with.no-store.and.response.marked.cacheable/accept/client",
        "${streams}/cache.get.request.with.no-store.and.response.marked.cacheable/accept/server",
    })
    public void shouldCacheGetRequestWithNoStoreAndResponeMarkedCacheable() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/cache.s-maxage/accept/client",
        "${streams}/cache.s-maxage/accept/server",
    })
    public void shouldCacheSMaxage() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/expire.s-maxage/accept/client",
        "${streams}/expire.s-maxage/accept/server",
    })
    public void shouldExpireSMaxage() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    // TODO expires headers
    // TODO quoted maxage header
    // TODO quoted smaxage header

    @Test
    @Specification({
        "${streams}/expire.cache.by.default.for.0.seconds/accept/client",
        "${streams}/expire.cache.by.default.for.0.seconds/accept/server",
    })
    public void shouldExpireCacheByDefaultFor0Seconds() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/cache.by.default.for.10.percent.of.last-modified/accept/client",
        "${streams}/cache.by.default.for.10.percent.of.last-modified/accept/server",
    })
    public void shouldCacheDefaultFor10PercentOfLastModified() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/expire.cache.by.default.for.10.percent.of.last-modified/accept/client",
        "${streams}/expire.cache.by.default.for.10.percent.of.last-modified/accept/server",
    })
    public void shouldExpireCacheDefaultFor10PercentOfLastModified() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/private.cache/accept/client",
        "${streams}/private.cache/accept/server",
    })
    public void shouldNotUsePrivateCache() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/implied.private.cache/accept/client",
        "${streams}/implied.private.cache/accept/server",
    })
    public void shouldNotUseImpliedPrivateCache() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/explicitly.public.cache/accept/client",
        "${streams}/explicitly.public.cache/accept/server",
    })
    public void shouldUseExplicitlyPublicCache() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/not.use.cache.that.varys/accept/client",
        "${streams}/not.use.cache.that.varys/accept/server",
    })
    public void shouldNotUseCacheForRequestThatVarys() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/cache.that.varys.but.matches/accept/client",
        "${streams}/cache.that.varys.but.matches/accept/server",
    })
    public void shouldUseCacheForRequestThatMatchesVarys() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/cache.large.response/accept/client",
        "${streams}/cache.large.response/accept/server",
    })
    public void shouldCacheLargeResponse() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/serve.from.cache.if.server.returns.503.on.forced.revalidation/accept/client",
        "${streams}/serve.from.cache.if.server.returns.503.on.forced.revalidation/accept/server",
    })
    public void shouldCacheIfServerReturns503WhileValidation() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/invalidate.multiple.max-age/accept/client",
        "${streams}/invalidate.multiple.max-age/accept/server",
    })
    public void shouldNotCacheWithMultipleMaxAge() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/ignore.expires.if.response.contains.max-age/accept/client",
        "${streams}/ignore.expires.if.response.contains.max-age/accept/server",
    })
    public void shouldCacheMaxAgeAndExpires() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/not.cache.when.authorization.is.provided/accept/client",
        "${streams}/not.cache.when.authorization.is.provided/accept/server",
    })
    public void shouldServeFromCacheIfServerReturns503OnForcedRevalidation() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/not.use.cache.that.varys.with.asterisk.value/accept/client",
        "${streams}/not.use.cache.that.varys.with.asterisk.value/accept/server",
    })
    public void shouldNotUseCacheForRequestThatHasAsteriskSymbolValueInVary() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/cache.with.freshened.response.that.updated.by.strong.validator/accept/client",
        "${streams}/cache.with.freshened.response.that.updated.by.strong.validator/accept/server",
    })
    public void shouldCacheWithFreshenedResponseThatUpdatedByStrongValidator() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/response.no-cache/accept/client",
        "${streams}/response.no-cache/accept/server",
    })
    public void shouldRevalidateOnResponseNoCache() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/explicitly.smaxage.and.authorization/accept/client",
        "${streams}/explicitly.smaxage.and.authorization/accept/server",
    })
    public void shouldCacheWithRequestAuthorizationHeaderAndSmaxage() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/response.no-cache.with.max-stale/accept/client",
        "${streams}/response.no-cache.with.max-stale/accept/server",
    })
    public void shouldRevalidateOnResponseNoCacheWithStaleResponseConfigured() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/do.not.cache.response.with.no-store/accept/client",
            "${streams}/do.not.cache.response.with.no-store/accept/server",
    })
    public void shouldNotCacheResponseWithResponseNoStore() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/not.cache.private.cache.with.s-maxage/accept/client",
        "${streams}/not.cache.private.cache.with.s-maxage/accept/server",
    })
    public void shouldNotCacheResponseWithSMaxageInPrivateCache() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/override.max-age.with.s-maxage/accept/client",
            "${streams}/override.max-age.with.s-maxage/accept/server",
    })
    public void shouldOverrideMaxAgeWithSMaxage() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/ignore.expires.if.response.contains.s-maxage/accept/client",
        "${streams}/ignore.expires.if.response.contains.s-maxage/accept/server",
    })
    public void shouldOverrideExpireWithSMaxage() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/proxy.get.request.without.etag/accept/client",
        "${streams}/proxy.get.request.without.etag/accept/server",
    })
    public void shouldProxyGetRequestWithoutEtag() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/use.etag.from.trailer.on.200.response/accept/client",
        "${streams}/use.etag.from.trailer.on.200.response/accept/server",
    })
    public void shouldUseEtagFromTrailerOn200Response() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/invalidate.cache.for.unsafe.request/accept/client",
        "${streams}/invalidate.cache.for.unsafe.request/accept/server",
    })
    public void shouldInvalidateCacheForUnsafeRequest() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/change.request.leader.if.initial.response.not.cacheable/accept/client",
        "${streams}/change.request.leader.if.initial.response.not.cacheable/accept/server",
    })
    public void shouldChangeRequestLeaderIfInitialResponseNotCacheable() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/update.freshness.of.expired.entry/accept/client",
        "${streams}/update.freshness.of.expired.entry/accept/server",
    })
    public void shouldUpdateFreshnessOfExpiredEntry() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/respond.new.request.when.inflight.response.expires.while.sending.payload/accept/client",
        "${streams}/respond.new.request.when.inflight.response.expires.while.sending.payload/accept/server",
    })
    public void shouldRespondNewRequestWhenInflightResponseExpiresWhileSendingPayload() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/respond.new.request.when.inflight.response.expires.while.sending.close/accept/client",
        "${streams}/respond.new.request.when.inflight.response.expires.while.sending.close/accept/server",
    })
    public void shouldRespondNewRequestWhenInflightResponseExpiresWhileSendingClose() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/respond.new.request.when.inflight.response.expires.while.sending.payload.and.trailer/accept/client",
        "${streams}/respond.new.request.when.inflight.response.expires.while.sending.payload.and.trailer/accept/server",
    })
    public void shouldRespondNewRequestWhenInflightResponseExpiresWhileSendingPayloadAndTrailer() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/respond.new.request.when.inflight.response.expires.while.sending.trailer/accept/client",
        "${streams}/respond.new.request.when.inflight.response.expires.while.sending.trailer/accept/server",
    })
    public void shouldRespondNewRequestWhenInflightResponseExpiresWhileSendingTrailer() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }
}
