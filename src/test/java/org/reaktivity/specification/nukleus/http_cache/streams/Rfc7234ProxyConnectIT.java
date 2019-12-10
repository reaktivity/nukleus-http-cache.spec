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

public class Rfc7234ProxyConnectIT
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
        "${streams}/proxy.get.request/connect/client",
        "${streams}/proxy.get.request/connect/server",
        })
    public void shouldProxyGetRequest() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/proxy.get.request.with.body/connect/client",
        "${streams}/proxy.get.request.with.body/connect/server",
        })
    public void shouldProxyGetRequestWithBody() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/proxy.get.request.with.transfer.encoding/connect/client",
        "${streams}/proxy.get.request.with.transfer.encoding/connect/server",
    })
    public void shouldProxyGetRequestWithTransferEncoding() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/proxy.post.request/connect/client",
        "${streams}/proxy.post.request/connect/server",
    })
    public void shouldProxyPostRequest() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/proxy.request.and.304/connect/client",
        "${streams}/proxy.request.and.304/connect/server",
    })
    public void shouldProxyRequestWith304() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/cache.request.and.304/connect/client",
        "${streams}/cache.request.and.304/connect/server",
    })
    public void shouldCacheRequestWith304() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/cache.min-fresh/connect/client",
            "${streams}/cache.min-fresh/connect/server",
    })
    public void shouldCacheMinFresh() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/expire.min-fresh/connect/client",
            "${streams}/expire.min-fresh/connect/server",
    })
    public void shouldExpireMinFresh() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/cache.max-age/connect/client",
        "${streams}/cache.max-age/connect/server",
    })
    public void shouldCacheMaxAge() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/503.retry-after/connect/client",
        "${streams}/503.retry-after/connect/server",
    })
    public void shouldRetryFor503RetryAfter() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/expire.max-age/connect/client",
        "${streams}/expire.max-age/connect/server",
    })
    public void shouldExpireMaxAge() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/cache.max-stale.with.value/connect/client",
            "${streams}/cache.max-stale.with.value/connect/server",
    })
    public void shouldCacheMaxStaleWithValue() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/cache.max-stale.no.value/connect/client",
            "${streams}/cache.max-stale.no.value/connect/server",
    })
    public void shouldCacheMaxStaleWithNoValue() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/cache.max-stale.with.max-age/connect/client",
            "${streams}/cache.max-stale.with.max-age/connect/server",
    })
    public void shouldCacheMaxStaleWithMaxAge() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/expire.max-stale/connect/client",
            "${streams}/expire.max-stale/connect/server",
    })
    public void shouldExpireMaxStale() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/request.cache.max-age=0/connect/client",
            "${streams}/request.cache.max-age=0/connect/server",
    })
    public void shouldRequestCacheMaxAgeZero() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/request.cache.max-age=0.and.304/connect/client",
            "${streams}/request.cache.max-age=0.and.304/connect/server",
    })
    public void shouldRequestCacheMaxAgeZeroAnd304() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/request.no-cache/connect/client",
            "${streams}/request.no-cache/connect/server",
    })
    public void shouldRequestNoCache() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/request.only-if-cached/connect/client",
            "${streams}/request.only-if-cached/connect/server",
    })
    public void shouldRequestOnlyIfCached() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/request.expire.only-if-cached/connect/client",
            "${streams}/request.expire.only-if-cached/connect/server",
    })
    public void shouldRequestExpireOnlyIfCached() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/should.bypass.cache.on.no.cache/connect/client",
        "${streams}/should.bypass.cache.on.no.cache/connect/server",
    })
    public void shouldBypassCacheOnNoCache() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/cache.s-maxage/connect/client",
        "${streams}/cache.s-maxage/connect/server",
    })
    public void shouldCacheSMaxage() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/cache.get.request.with.no-store/connect/client",
            "${streams}/cache.get.request.with.no-store/connect/server",
    })
    public void shouldCacheGetRequestWithNoStore() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
            "${streams}/cache.get.request.with.no-store.and.response.marked.cacheable/connect/client",
            "${streams}/cache.get.request.with.no-store.and.response.marked.cacheable/connect/server",
    })
    public void shouldCacheGetRequestWithNoStoreAndResponeMarkedCacheable() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/expire.s-maxage/connect/client",
        "${streams}/expire.s-maxage/connect/server",
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
        "${streams}/expire.cache.by.default.for.0.seconds/connect/client",
        "${streams}/expire.cache.by.default.for.0.seconds/connect/server",
    })
    public void shouldExpireCacheByDefaultFor0Seconds() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/cache.by.default.for.10.percent.of.last-modified/connect/client",
        "${streams}/cache.by.default.for.10.percent.of.last-modified/connect/server",
    })
    public void shouldCacheDefaultFor10PercentOfLastModified() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/expire.cache.by.default.for.10.percent.of.last-modified/connect/client",
        "${streams}/expire.cache.by.default.for.10.percent.of.last-modified/connect/server",
    })
    public void shouldExpireCacheDefaultFor10PercentOfLastModified() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/private.cache/connect/client",
        "${streams}/private.cache/connect/server",
    })
    public void shouldNotUsePrivateCache() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/implied.private.cache/connect/client",
        "${streams}/implied.private.cache/connect/server",
    })
    public void shouldNotUseImpliedPrivateCache() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/explicitly.public.cache/connect/client",
        "${streams}/explicitly.public.cache/connect/server",
    })
    public void shouldUseExplicitlyPublicCache() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/not.use.cache.that.varys/connect/client",
        "${streams}/not.use.cache.that.varys/connect/server",
    })
    public void shouldNotUseCacheForRequestThatVarys() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/cache.that.varys.but.matches/connect/client",
        "${streams}/cache.that.varys.but.matches/connect/server",
    })
    public void shouldUseCacheForRequestThatMatchesVarys() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/cache.large.response/connect/client",
        "${streams}/cache.large.response/connect/server",
    })
    public void shouldCacheLargeResponse() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/serve.from.cache.if.server.returns.503.on.forced.revalidation/connect/client",
        "${streams}/serve.from.cache.if.server.returns.503.on.forced.revalidation/connect/server",
    })
    public void shouldServeFromCacheIfServerReturns503OnForcedRevalidation() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/invalidate.multiple.max-age/connect/client",
        "${streams}/invalidate.multiple.max-age/connect/server",
    })
    public void shouldNotCacheWithMultipleMaxAge() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/ignore.expires.if.response.contains.max-age/connect/client",
        "${streams}/ignore.expires.if.response.contains.max-age/connect/server",
    })
    public void shouldCacheMaxAgeAndExpires() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/not.cache.when.authorization.is.provided/connect/client",
        "${streams}/not.cache.when.authorization.is.provided/connect/server",
    })
    public void shouldNotCacheWithRequestAuthorizationHeader() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/cache.with.freshened.response.that.updated.by.strong.validator/connect/client",
        "${streams}/cache.with.freshened.response.that.updated.by.strong.validator/connect/server",
    })
    public void shouldCacheWithFreshenedResponseThatUpdatedByStrongValidator() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/response.no-cache/connect/client",
        "${streams}/response.no-cache/connect/server",
    })
    public void shouldRevalidateOnResponseNoCache() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/response.no-cache.with.max-stale/connect/client",
        "${streams}/response.no-cache.with.max-stale/connect/server",
    })
    public void shouldRevalidateOnResponseNoCacheWithStaleResponseConfigured() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/do.not.cache.response.with.no-store/connect/client",
        "${streams}/do.not.cache.response.with.no-store/connect/server",
    })
    public void shouldNotCacheResponseWithResponseNoStore() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/not.cache.private.cache.with.s-maxage/connect/client",
        "${streams}/not.cache.private.cache.with.s-maxage/connect/server",
    })
    public void shouldNotCacheResponseWithSMaxageInPrivateCache() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/override.max-age.with.s-maxage/connect/client",
        "${streams}/override.max-age.with.s-maxage/connect/server",
    })
    public void shouldOverrideMaxAgeWithSMaxage() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/ignore.expires.if.response.contains.s-maxage/connect/client",
        "${streams}/ignore.expires.if.response.contains.s-maxage/connect/server",
    })
    public void shouldOverrideExpireWithSMaxage() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/explicitly.smaxage.and.authorization/connect/client",
        "${streams}/explicitly.smaxage.and.authorization/connect/server",
    })
    public void shouldCacheWithRequestAuthorizationHeaderAndSmaxage() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/proxy.get.request.without.etag/connect/client",
        "${streams}/proxy.get.request.without.etag/connect/server",
    })
    public void shouldProxyGetRequestWithoutEtag() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/use.etag.from.trailer.on.200.response/connect/client",
        "${streams}/use.etag.from.trailer.on.200.response/connect/server",
    })
    public void shouldUseEtagFromTrailerOn200Response() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/invalidate.cache.for.unsafe.request/connect/client",
        "${streams}/invalidate.cache.for.unsafe.request/connect/server",
    })
    public void shouldInvalidateCacheForUnsafeRequest() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/change.request.leader.if.initial.response.not.cacheable/connect/client",
        "${streams}/change.request.leader.if.initial.response.not.cacheable/connect/server",
    })
    public void shouldChangeRequestLeaderIfInitialResponseNotCacheable() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/update.freshness.of.expired.entry/connect/client",
        "${streams}/update.freshness.of.expired.entry/connect/server",
    })
    public void shouldUpdateFreshnessOfExpiredEntry() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }
}
