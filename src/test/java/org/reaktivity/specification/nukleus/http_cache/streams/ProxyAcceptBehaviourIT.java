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

public class ProxyAcceptBehaviourIT
{
    private final K3poRule k3po = new K3poRule()
            .addScriptRoot("streams", "org/reaktivity/specification/nukleus/http_cache/streams/proxy/behavior");

    private final TestRule timeout = new DisableOnDebug(new Timeout(5, SECONDS));

    private final NukleusRule nukleus = new NukleusRule()
            .directory("target/nukleus-itests");

    @Rule
    public final TestRule chain = outerRule(nukleus).around(k3po).around(timeout);

    @Test
    @Specification({
        "${streams}/accept.sent.abort/accept/client",
        "${streams}/accept.sent.abort/accept/server",
    })
    public void shouldAcceptSentAbort() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/accept.sent.abort.cacheable.request/accept/client",
        "${streams}/accept.sent.abort.cacheable.request/accept/server",
    })
    public void shouldHandleAbortSentOnCacheableRequest() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/connect.reply.sent.abort/accept/client",
        "${streams}/connect.reply.sent.abort/accept/server",
    })
    public void shouldConnectReplySentAbort() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/connect.sent.reset/accept/client",
        "${streams}/connect.sent.reset/accept/server",
    })
    public void shouldConnectSentReset() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/accept.reply.sent.reset/accept/client",
        "${streams}/accept.reply.sent.reset/accept/server",
    })
    public void shouldAcceptReplySentReset() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/nukleus.overloaded/accept/client",
        "${streams}/nukleus.overloaded/accept/server"})
    public void shouldResetIfOOM() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/client.sent.abort.on.scheduled.poll/accept/client",
        "${streams}/client.sent.abort.on.scheduled.poll/accept/server"
    })
    public void shouldClientSentAbortOnScheduledPoll() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/reset.connect.reply.if.accept.reply.reset/accept/client",
        "${streams}/reset.connect.reply.if.accept.reply.reset/accept/server",
    })
    public void shouldResetConnectReplyIfAcceptReplyReset() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/reset.stream.if.group.request.already.dequeued/accept/client",
        "${streams}/reset.stream.if.group.request.already.dequeued/accept/server",
    })
    public void shouldResetStreamIfGroupRequestAlreadyDequeued() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_PROXY");
        k3po.finish();
    }
}
