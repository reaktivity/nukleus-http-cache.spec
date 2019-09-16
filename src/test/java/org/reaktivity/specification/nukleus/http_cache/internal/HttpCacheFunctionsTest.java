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
package org.reaktivity.specification.nukleus.http_cache.internal;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.kaazing.k3po.lang.internal.el.ExpressionFactoryUtils.newExpressionFactory;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;
import org.kaazing.k3po.lang.internal.el.ExpressionContext;

public class HttpCacheFunctionsTest
{
    private ExpressionFactory factory;
    private ELContext ctx;

    @Before
    public void setUp() throws Exception
    {
        factory = newExpressionFactory();
        ctx = new ExpressionContext();
    }

    @Test
    public void shouldInvokeDate() throws Exception
    {
        String expressionText = "${http_cache:date()}";
        ValueExpression expression = factory.createValueExpression(ctx, expressionText, String.class);
        Object actual = expression.getValue(ctx);
        assertThat(actual, instanceOf(String.class));
    }

    @Test
    public void shouldInvokeDatePlus() throws Exception
    {
        String expressionText = "${http_cache:datePlus(5)}";
        ValueExpression expression = factory.createValueExpression(ctx, expressionText, String.class);
        Object actual = expression.getValue(ctx);
        assertThat(actual, instanceOf(String.class));
    }

    @Test
    public void shouldInvokeFixedStrongEtag() throws Exception
    {
        String expressionText = "${http_cache:fixedStrongEtag(\"strong\")}";
        ValueExpression expression = factory.createValueExpression(ctx, expressionText, String.class);
        Object actual = expression.getValue(ctx);
        assertThat(actual, IsEqual.equalTo("\"strong\""));
    }

    @Test
    public void shouldInvokeStrongEtag() throws Exception
    {
        String expressionText = "${http_cache:strongEtag()}";
        ValueExpression expression = factory.createValueExpression(ctx, expressionText, String.class);
        Object actual = expression.getValue(ctx);
        assertNotNull(actual);
    }

    @Test
    public void shouldInvokeWeakEtag() throws Exception
    {
        String expressionText = "${http_cache:weakEtag()}";
        ValueExpression expression = factory.createValueExpression(ctx, expressionText, String.class);
        Object actual = expression.getValue(ctx);
        assertNotNull(actual);
    }

    @Test
    public void shouldInvokeLargePayload() throws Exception
    {
        String expressionText = "${http_cache:largePayload(20)}";
        ValueExpression expression = factory.createValueExpression(ctx, expressionText, byte[].class);
        Object actual = expression.getValue(ctx);
        assertThat(actual, instanceOf(byte[].class));
        assertEquals(20, ((byte[])actual).length);
    }

    @Test
    public void shouldInvokeRandomCacheableByDefaultStatusCode() throws Exception
    {
        String expressionText = "${http_cache:randomCacheableByDefaultStatusCode()}";
        ValueExpression expression = factory.createValueExpression(ctx, expressionText, String.class);
        Object actual = expression.getValue(ctx);
        assertNotNull(actual);
    }
}
