package me.calculator.controller;

import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.mockito.ArgumentCaptor;
import static org.assertj.core.api.Assertions.assertThat;

public class TokensListTest  {

    @Test
    public void testAdd_WithEmptyList_TokenIsAdded() {
        //Given
        TokensList tokenList = new TokensList();
        final String tokenValue = "test";

        //When
        tokenList.add(tokenValue);

        //Then
        assertThat(tokenValue).isEqualTo(tokenList.get(0));
    }

    @Test
    public void testRemove_WithNonEmptyList_RemoveElement() {
        //Given
        TokensList tokenList = new TokensList();
        final String tokenValue = "test";
        tokenList.add(tokenValue);

        //When
        tokenList.remove(tokenValue);

        //Then
        assertThat(tokenList).isEmpty();
    }

    @Test
    public void testRemove_WithEmptyList_RemoveElement() {
        //Given
        TokensList tokenList = new TokensList();

        //When
        tokenList.remove("test");

        //Then
        assertThat(tokenList).isEmpty();
    }

    @Test
    public void testRemoveLastToken_WithNonEmptyList_RemoveElement() {
        //Given
        TokensList tokenList = new TokensList();
        tokenList.add("test0");
        tokenList.add("test1");

        //When
        tokenList.removeLastToken();

        //Then
        assertThat(tokenList.get(0)).isEqualTo("test0");
        assertThat(tokenList.size()).isEqualTo(1);
    }

    @Test
    public void testAdd_WhenElementAddedToTokenList_FireChangeEvent() {
        //Given
        TokensList tokenList = new TokensList();
        ListChangeListener<String> listener = mock( ListChangeListener.class);
        tokenList.addListener(listener);
        ArgumentCaptor<Change> argument = ArgumentCaptor.forClass(Change.class);

        //When
        tokenList.add("test");

        //Then
        verify(listener).onChanged(argument.capture());
        assertThat(argument.getValue().next()).isTrue();
        assertThat(argument.getValue().wasAdded()).isTrue();
    }

    @Test
    public void testRemove_WhenElementRemovedFromTokenList_FireChangeEvent() {
        //Given
        TokensList tokenList = new TokensList();
        tokenList.add("test");
        ListChangeListener<String> listener = mock( ListChangeListener.class );
        tokenList.addListener(listener);
        ArgumentCaptor<Change> argument = ArgumentCaptor.forClass(Change.class);

        //When
        tokenList.remove("test");

        //Then
        verify(listener).onChanged(argument.capture());
        assertThat(argument.getValue().next()).isTrue();
        assertThat(argument.getValue().wasRemoved()).isTrue();
    }

    @Test
    public void testRemoveLastToken_WhenLastElementRemovedFromTokenList_FireChangeEvent() {
        //Given
        TokensList tokenList = new TokensList();
        tokenList.add("test");
        ListChangeListener<String> listener = mock( ListChangeListener.class );
        tokenList.addListener(listener);
        ArgumentCaptor<Change> argument = ArgumentCaptor.forClass(Change.class);

        //When
        tokenList.removeLastToken();

        //Then
        verify(listener).onChanged(argument.capture());
        assertTrue(argument.getValue().next());
        assertTrue(argument.getValue().wasRemoved());
    }

    @Test
    public void testRemoveLastToken_WhenLastElementRemovedFromTokenList_NoExceptionThrown() {
        //Given
        TokensList tokenList = new TokensList();

        //When
        //Then
        assertDoesNotThrow(()-> tokenList.removeLastToken());
    }
    
    @Test
    public void testClear_WhenClearTokenList_FireChangeEvent() {
        //Given
        TokensList tokenList = new TokensList();
        tokenList.add("test");
        ListChangeListener<String> listener = mock( ListChangeListener.class );
        tokenList.addListener(listener);
        ArgumentCaptor<Change> argument = ArgumentCaptor.forClass(Change.class);

        //When
        tokenList.clear();
        
        //Then
        verify(listener).onChanged(argument.capture());
        assertTrue(argument.getValue().next());
        assertTrue(argument.getValue().wasRemoved());
    }
    
}
