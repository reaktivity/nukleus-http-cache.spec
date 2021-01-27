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

public class Rfc7240ProxyConnectIT
{
    private final K3poRule k3po = new K3poRule()
        .addScriptRoot("streams", "org/reaktivity/specification/nukleus/http_cache/streams/proxy/rfc7240");

    private final TestRule timeout = new DisableOnDebug(new Timeout(5, SECONDS));

    private final NukleusRule nukleus = new NukleusRule()
            .directory("target/nukleus-itests");

    @Rule
    public final TestRule chain = outerRule(nukleus).around(k3po).around(timeout);

    @Test
    @Specification({
        "${streams}/send.304.on.prefer.wait.timeout/connect/client",
        "${streams}/send.304.on.prefer.wait.timeout/connect/server",
    })
    public void shouldSend304OnPreferWaitTimeout() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/acknowledge.prefer.wait.header.in.response/connect/client",
        "${streams}/acknowledge.prefer.wait.header.in.response/connect/server",
    })
    public void shouldAcknowledgePreferWaitHeaderInResponse() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/missing.preference.applied.header.on.prefer.wait/connect/client",
        "${streams}/missing.preference.applied.header.on.prefer.wait/connect/server",
    })
    public void shouldHandleMissingPreferenceAppliedHeaderOnPreferWait() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/missing.preference.applied.header.with.trailer/connect/client",
        "${streams}/missing.preference.applied.header.with.trailer/connect/server",
    })
    public void shouldHandleMissingPreferenceAppliedHeaderWithTrailer() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/missing.preference.applied.header.with.retry.after/connect/client",
        "${streams}/missing.preference.applied.header.with.retry.after/connect/server",
    })
    public void shouldHandleMissingPreferenceAppliedHeaderWithRetryAfter() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/multiple.parallel.requests.with.prefer.wait.and.updated.authorization/connect/client",
        "${streams}/multiple.parallel.requests.with.prefer.wait.and.updated.authorization/connect/server",
    })
    public void shouldHandleMultipleParallelRequestWithPreferWaitAndUpdatedAuthorization() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/serve.next.request.if.current.request.expired/connect/client",
        "${streams}/serve.next.request.if.current.request.expired/connect/server",
    })
    public void shouldServeNextRequestIfCurrentRequestExpired() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/update.cache.while.polling/connect/client",
        "${streams}/update.cache.while.polling/connect/server",
    })
    public void shouldUpdateCacheWhilePolling() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/serve.immediately.when.if.none.match.missing.while.polling/connect/client",
        "${streams}/serve.immediately.when.if.none.match.missing.while.polling/connect/server",
    })
    public void shouldServeImmediatelyWhenIfNoneMatchMissingWhilePolling() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/respond.with.first.etag.after.cache.miss.second.etag/connect/client",
        "${streams}/respond.with.first.etag.after.cache.miss.second.etag/connect/server",
    })
    public void shouldRespondWithFirstEtagAfterCacheMissSecondEtag() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/respond.with.second.etag.after.cache.miss.first.etag/connect/client",
        "${streams}/respond.with.second.etag.after.cache.miss.first.etag/connect/server",
    })
    public void shouldRespondWithSecondEtagAfterCacheMissFirstEtag() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/respond.with.second.etag.after.cache.miss.second.etag/connect/client",
        "${streams}/respond.with.second.etag.after.cache.miss.second.etag/connect/server",
    })
    public void shouldRespondWithSecondEtagAfterCacheMissSecondEtag() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/respond.with.second.etag.after.cache.miss.without.etag/connect/client",
        "${streams}/respond.with.second.etag.after.cache.miss.without.etag/connect/server",
    })
    public void shouldRespondWithSecondEtagAfterCacheMissWithoutEtag() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/respond.with.third.etag.after.cache.miss.second.etag/connect/client",
        "${streams}/respond.with.third.etag.after.cache.miss.second.etag/connect/server",
    })
    public void shouldRespondWithThirdEtagAfterCacheMissSecondEtag() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/poll.immediately.if.cache.entry.invalidated/connect/client",
        "${streams}/poll.immediately.if.cache.entry.invalidated/connect/server",
    })
    public void shouldPollImmediatelyIfCacheEntryInvalidated() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }
}
