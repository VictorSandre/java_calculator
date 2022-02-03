package me.calculator.controller;

import java.util.LinkedList;
import javafx.collections.ModifiableObservableListBase;

public class TokensList extends ModifiableObservableListBase<String>{

    private LinkedList<String> tokenList;

    public TokensList() {
        tokenList = new LinkedList<>();
    }

    public String concatTokensValues() {
        StringBuilder fullTokensExpression = new StringBuilder();
        
        for (String token : tokenList) 
            fullTokensExpression.append(token);
        
        return fullTokensExpression.toString();
    }

    @Override
    public String get(int arg0) {
        return tokenList.get(arg0);
    }

    @Override
    public int size() {
        return tokenList.size();
    }

    @Override
    protected void doAdd(int arg0, String arg1) {
        tokenList.add(arg0, arg1);
    }

    @Override
    protected String doSet(int arg0, String arg1) {
        return tokenList.set(arg0, arg1);
    }

    @Override
    protected String doRemove(int arg0) {
       return tokenList.remove(arg0);
    }
    
    public void removeLastToken() {
        int lastTokenPosition = this.size() - 1;
        if (lastTokenPosition >= 0)
            this.remove(lastTokenPosition);
    }
}
