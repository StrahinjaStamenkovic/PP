import java.util.ArrayList;
import java.util.HashMap;

public class SyntaxTable {

    public final static int WHILE_LOOP_PRIME = 420;
    public final static int WHILE_LOOP = 421;
    public final static int EXPRESSION = 422;
    public final static int STATEMENT = 423;
    public final static int AND_EXPRESSION = 424;
    public final static int TERM = 425;

    public ArrayList<Rule> Rules;
    public ArrayList<HashMap<Integer, String>> Table;

    public SyntaxTable() {
        Rules = new ArrayList<Rule>() {
            {
                add(
                        new Rule(SyntaxTable.WHILE_LOOP_PRIME, new ArrayList<Integer>() {
                            {
                                add(SyntaxTable.WHILE_LOOP);
                            }
                        }));
                add(
                        new Rule(SyntaxTable.WHILE_LOOP, new ArrayList<Integer>() {
                            {
                                add(sym.WHILE);
                                add(SyntaxTable.EXPRESSION);
                                add(sym.COLON);
                                add(SyntaxTable.STATEMENT);
                                add(sym.ELSE);
                                add(SyntaxTable.STATEMENT);
                            }
                        }));
                add(
                        new Rule(SyntaxTable.EXPRESSION, new ArrayList<Integer>() {
                            {
                                add(SyntaxTable.EXPRESSION);
                                add(sym.OR);
                                add(SyntaxTable.AND_EXPRESSION);
                            }
                        }));
                add(
                        new Rule(SyntaxTable.EXPRESSION, new ArrayList<Integer>() {
                            {
                                add(SyntaxTable.AND_EXPRESSION);
                            }
                        }));
                add(
                        new Rule(SyntaxTable.AND_EXPRESSION, new ArrayList<Integer>() {
                            {
                                add(SyntaxTable.AND_EXPRESSION);
                                add(sym.AND);
                                add(SyntaxTable.TERM);
                            }
                        }));
                add(
                        new Rule(SyntaxTable.AND_EXPRESSION, new ArrayList<Integer>() {
                            {
                                add(SyntaxTable.TERM);
                            }
                        }));
                add(
                        new Rule(SyntaxTable.TERM, new ArrayList<Integer>() {
                            {
                                add(sym.ID);
                            }
                        }));
                add(
                        new Rule(SyntaxTable.TERM, new ArrayList<Integer>() {
                            {
                                add(sym.CONST);
                            }
                        }));
                add(
                        new Rule(SyntaxTable.STATEMENT, new ArrayList<Integer>() {
                            {
                                add(SyntaxTable.WHILE_LOOP);
                            }
                        }));
                add(
                        new Rule(SyntaxTable.STATEMENT, new ArrayList<Integer>() {
                            {
                                add(sym.ID);
                                add(sym.ASSIGN);
                                add(SyntaxTable.EXPRESSION);
                                add(sym.SEMICOLON);
                            }
                        }));
            }
        };

        Table = new ArrayList<HashMap<Integer, String>>() {
            {
                // 0
                add(new HashMap<Integer, String>() {
                    {
                        put(sym.WHILE, "sk 2");
                        put(SyntaxTable.WHILE_LOOP, "1");
                    }
                });

                // 1
                add(new HashMap<>() {
                    {
                        put(sym.EOF, "acc");
                    }
                });

                // 2
                add(new HashMap<>() {
                    {
                        put(sym.ID, "sk 19");
                        put(sym.CONST, "sk 20");
                        put(SyntaxTable.EXPRESSION, "3");
                        put(SyntaxTable.AND_EXPRESSION, "15");
                        put(SyntaxTable.TERM, "18");

                    }
                });

                // 3
                add(new HashMap<>() {
                    {
                        put(sym.COLON, "sk 4");
                        put(sym.OR, "sk 13");
                    }
                });

                // 4
                add(new HashMap<>() {
                    {
                        put(sym.WHILE, "sk 2");
                        put(sym.ID, "sk 9");
                        put(SyntaxTable.WHILE_LOOP, "8");
                        put(SyntaxTable.STATEMENT, "5");
                    }
                });

                // 5
                add(new HashMap<>() {
                    {
                        put(sym.ELSE, "sk 6");
                    }
                });

                // 6
                add(new HashMap<>() {
                    {
                        put(sym.WHILE, "sk 2");
                        put(sym.ID, "sk 9");
                        put(SyntaxTable.WHILE_LOOP, "8");
                        put(SyntaxTable.STATEMENT, "7");
                    }
                });

                // 7
                add(new HashMap<>() {
                    {
                        put(sym.ELSE, "rk 1");
                        put(sym.EOF, "rk 1");
                    }
                });

                // 8
                add(new HashMap<>() {
                    {
                        put(sym.ELSE, "rk 8");
                        put(sym.EOF, "rk 8");
                    }
                });

                // 9
                add(new HashMap<>() {
                    {
                        put(sym.ASSIGN, "sk 10");
                    }
                });

                // 10
                add(new HashMap<>() {
                    {
                        put(sym.ID, "sk 19");
                        put(sym.CONST, "sk 20");
                        put(SyntaxTable.EXPRESSION, "11");
                        put(SyntaxTable.AND_EXPRESSION, "15");
                        put(SyntaxTable.TERM, "18");

                    }
                });

                // 11
                add(new HashMap<>() {
                    {
                        put(sym.SEMICOLON, "sk 12");
                        put(sym.OR, "sk 13");
                    }
                });

                // 12
                add(new HashMap<>() {
                    {
                        put(sym.ELSE, "rk 9");
                        put(sym.EOF, "rk 9");
                    }
                });

                // 13
                add(new HashMap<>() {
                    {
                        put(sym.ID, "sk 19");
                        put(sym.CONST, "sk 20");
                        put(SyntaxTable.AND_EXPRESSION, "14");
                        put(SyntaxTable.TERM, "18");
                    }
                });

                // 14
                add(new HashMap<>() {
                    {
                        put(sym.COLON, "rk 2");
                        put(sym.SEMICOLON, "rk 2");
                        put(sym.OR, "rk 2");
                        put(sym.AND, "sk 16");
                    }
                });

                // 15
                add(new HashMap<>() {
                    {
                        put(sym.COLON, "rk 3");
                        put(sym.SEMICOLON, "rk 3");
                        put(sym.OR, "rk 3");
                        put(sym.AND, "sk 16");
                    }
                });

                // 16
                add(new HashMap<>() {
                    {
                        put(sym.ID, "sk 19");
                        put(sym.CONST, "sk 20");
                        put(SyntaxTable.TERM, "17");
                    }
                });

                // 17
                add(new HashMap<>() {
                    {
                        put(sym.COLON, "rk 4");
                        put(sym.SEMICOLON, "rk 4");
                        put(sym.OR, "rk 4");
                        put(sym.AND, "rk 4");
                    }
                });

                // 18
                add(new HashMap<>() {
                    {
                        put(sym.COLON, "rk 5");
                        put(sym.SEMICOLON, "rk 5");
                        put(sym.OR, "rk 5");
                        put(sym.AND, "rk 5");
                    }
                });

                // 19
                add(new HashMap<>() {
                    {
                        put(sym.COLON, "rk 6");
                        put(sym.SEMICOLON, "rk 6");
                        put(sym.OR, "rk 6");
                        put(sym.AND, "rk 6");
                    }
                });

                // 20
                add(new HashMap<>() {
                    {
                        put(sym.COLON, "rk 7");
                        put(sym.SEMICOLON, "rk 7");
                        put(sym.OR, "rk 7");
                        put(sym.AND, "rk 7");
                    }
                });
            }
        };
    }
}
