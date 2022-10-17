package calculator.view.controller;

import javafx.collections.ModifiableObservableListBase;

import java.util.LinkedList;

public final class TokensList extends ModifiableObservableListBase<String> {

    private LinkedList<String> tokenList;

    public TokensList() {
        tokenList = new LinkedList<>();
    }

    /**
     * This function concatenate all values of a TokensList and return it in
     * one unique String variable.
     * @return string variable
     */
    public String concatTokensValues() {
        StringBuilder fullTokensExpression = new StringBuilder();

        for (String token : tokenList) {
            fullTokensExpression.append(token);
        }

        return fullTokensExpression.toString();
    }

    @Override
    public String get(final int arg0) {
        return tokenList.get(arg0);
    }

    @Override
    public int size() {
        return tokenList.size();
    }

    @Override
    protected void doAdd(final int arg0, final String arg1) {
        tokenList.add(arg0, arg1);
    }

    @Override
    protected String doSet(final int arg0, final String arg1) {
        return tokenList.set(arg0, arg1);
    }

    @Override
    protected String doRemove(final int arg0) {
       return tokenList.remove(arg0);
    }

    /**
     * This function remove the last element of the token list if
     * it's not empty.
     */
    public void removeLastToken() {
        int lastTokenPosition = this.size() - 1;
        if (!tokenList.isEmpty()) {
            this.remove(lastTokenPosition);
        }
    }
}
