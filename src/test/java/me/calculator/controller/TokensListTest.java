package me.calculator.controller;

import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.mockito.ArgumentCaptor;

public class TokensListTest  {
    
    public TokensListTest() {
    }

    @Test
    public void testAddElementToEmptyTokenList() {
        TokensList tokenList = new TokensList();
        final String tokenValue = "test";
        tokenList.add(tokenValue);
        assertEquals(tokenValue, tokenList.get(0));
    }

    @Test
    public void testRemoveElementFromTokenList() {
        TokensList tokenList = new TokensList();
        final String tokenValue = "test";
        tokenList.remove(tokenValue);
        assertTrue(tokenList.isEmpty());
    }

    @Test
    public void testAddElementToTokenListFireChangeEvent() {
        TokensList tokenList = new TokensList();
        ListChangeListener<String> listener = mock( ListChangeListener.class );
        tokenList.addListener(listener);

        tokenList.add("test");

        ArgumentCaptor<Change> argument = ArgumentCaptor.forClass(Change.class);
        verify(listener).onChanged(argument.capture());
        assertTrue(argument.getValue().next());
        assertTrue(argument.getValue().wasAdded());
    }

    @Test
    public void testRemoveElementFromTokenListFireChangeEvent() {
        TokensList tokenList = new TokensList();
        tokenList.add("test");
        ListChangeListener<String> listener = mock( ListChangeListener.class );
        tokenList.addListener(listener);

        tokenList.remove("test");

        ArgumentCaptor<Change> argument = ArgumentCaptor.forClass(Change.class);
        verify(listener).onChanged(argument.capture());
        assertTrue(argument.getValue().next());
        assertTrue(argument.getValue().wasRemoved());
    }

    @Test
    public void testRemoveLastTokenFromTokenListFireChangeEvent() {
        TokensList tokenList = new TokensList();
        tokenList.add("test");
        ListChangeListener<String> listener = mock( ListChangeListener.class );
        tokenList.addListener(listener);

        tokenList.removeLastToken();

        ArgumentCaptor<Change> argument = ArgumentCaptor.forClass(Change.class);
        verify(listener).onChanged(argument.capture());
        assertTrue(argument.getValue().next());
        assertTrue(argument.getValue().wasRemoved());
    }

    @Test
    public void testRemoveLastTokenFromTokenListThrowNoException() {
        TokensList tokenList = new TokensList();
        assertDoesNotThrow(()-> tokenList.removeLastToken());
    }
    
    @Test
    public void testRemoveLastTokenFromTokenList() {
        TokensList tokenList = new TokensList();
        tokenList.add("test0");
        tokenList.add("test1");
        tokenList.removeLastToken();
        assertEquals(tokenList.get(0), "test0");
        assertEquals(tokenList.size(), 1);
    }
    
    @Test
    public void testClearTokenListFireChangeEvent() {
        TokensList tokenList = new TokensList();
        tokenList.add("test");
        ListChangeListener<String> listener = mock( ListChangeListener.class );
        tokenList.addListener(listener);
        
        tokenList.clear();
        
        ArgumentCaptor<Change> argument = ArgumentCaptor.forClass(Change.class);
        verify(listener).onChanged(argument.capture());
        assertTrue(argument.getValue().next());
        assertTrue(argument.getValue().wasRemoved());
    }
    
}
