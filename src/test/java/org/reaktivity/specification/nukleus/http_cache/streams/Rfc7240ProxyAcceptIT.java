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

public class Rfc7240ProxyAcceptIT
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
        "${streams}/send.304.on.prefer.wait.timeout/accept/client",
        "${streams}/send.304.on.prefer.wait.timeout/accept/server",
    })
    public void shouldSend304OnPreferWaitTimeout() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/acknowledge.prefer.wait.header.in.response/accept/client",
        "${streams}/acknowledge.prefer.wait.header.in.response/accept/server",
    })
    public void shouldAcknowledgePreferWaitHeaderInResponse() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/missing.preference.applied.header.on.prefer.wait/accept/client",
        "${streams}/missing.preference.applied.header.on.prefer.wait/accept/server",
    })
    public void shouldHandleMissingPreferenceAppliedHeaderOnPreferWait() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/missing.preference.applied.header.with.trailer/accept/client",
        "${streams}/missing.preference.applied.header.with.trailer/accept/server",
    })
    public void shouldHandleMissingPreferenceAppliedHeaderWithTrailer() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/missing.preference.applied.header.with.retry.after/accept/client",
        "${streams}/missing.preference.applied.header.with.retry.after/accept/server",
    })
    public void shouldHandleMissingPreferenceAppliedHeaderWithRetryAfter() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/multiple.parallel.requests.with.prefer.wait.and.updated.authorization/accept/client",
        "${streams}/multiple.parallel.requests.with.prefer.wait.and.updated.authorization/accept/server",
    })
    public void shouldHandleMultipleParallelRequestWithPreferWaitAndUpdatedAuthorization() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/serve.next.request.if.current.request.expired/accept/client",
        "${streams}/serve.next.request.if.current.request.expired/accept/server",
    })
    public void shouldServeNextRequestIfCurrentRequestExpired() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/update.cache.while.polling/accept/client",
        "${streams}/update.cache.while.polling/accept/server",
    })
    public void shouldUpdateCacheWhilePolling() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/serve.immediately.when.if.none.match.missing.while.polling/accept/client",
        "${streams}/serve.immediately.when.if.none.match.missing.while.polling/accept/server",
    })
    public void shouldServeImmediatelyWhenIfNoneMatchMissingWhilePolling() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/respond.with.first.etag.after.cache.miss.second.etag/accept/client",
        "${streams}/respond.with.first.etag.after.cache.miss.second.etag/accept/server",
    })
    public void shouldRespondWithFirstEtagAfterCacheMissSecondEtag() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/respond.with.second.etag.after.cache.miss.first.etag/accept/client",
        "${streams}/respond.with.second.etag.after.cache.miss.first.etag/accept/server",
    })
    public void shouldRespondWithSecondEtagAfterCacheMissFirstEtag() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/respond.with.second.etag.after.cache.miss.second.etag/accept/client",
        "${streams}/respond.with.second.etag.after.cache.miss.second.etag/accept/server",
    })
    public void shouldRespondWithSecondEtagAfterCacheMissSecondEtag() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/respond.with.second.etag.after.cache.miss.without.etag/accept/client",
        "${streams}/respond.with.second.etag.after.cache.miss.without.etag/accept/server",
    })
    public void shouldRespondWithSecondEtagAfterCacheMissWithoutEtag() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/respond.with.third.etag.after.cache.miss.second.etag/accept/client",
        "${streams}/respond.with.third.etag.after.cache.miss.second.etag/accept/server",
    })
    public void shouldRespondWithThirdEtagAfterCacheMissSecondEtag() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/receive.503.on.group.request.reset/accept/client",
        "${streams}/receive.503.on.group.request.reset/accept/server",
    })
    public void shouldReceive503OnGroupRequestReset() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/poll.immediately.if.cache.entry.invalidated/accept/client",
        "${streams}/poll.immediately.if.cache.entry.invalidated/accept/server",
    })
    public void shouldPollImmediatelyIfCacheEntryInvalidated() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }
}
